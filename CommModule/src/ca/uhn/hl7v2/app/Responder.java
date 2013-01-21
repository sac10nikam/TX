/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "Responder.java".  Description:
 * "Performs the responding role in a message exchange according to HL7's original mode
 * processing rules."
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import android.os.Environment;
import net.newel.android.Log;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Constants;
import ca.uhn.hl7v2.util.MessageIDGenerator;
import ca.uhn.hl7v2.util.Terser;

/**
 * <p>
 * Performs the responding role in a message exchange (i.e receiver of the first
 * message, sender of the response; analagous to the server in a client-server
 * interaction), according to HL7's original mode processing rules.
 * </p>
 * <p>
 * At the time of writing, enhanced mode, two-phase reply, continuation
 * messages, and batch processing are unsupported.
 * </p>
 * 
 * @author Bryan Tripp
 */
public class Responder {

	// private LowerLayerProtocol llp;
	private Parser parser;
	private List<Application> apps;
	private BufferedWriter checkWriter = null;

	/**
	 * Creates a new instance of Responder that optionally validates parsing of
	 * incoming messages using a system property. If the system property
	 * <code>ca.uhn.hl7v2.app.checkparse</code> equals "true", parse integrity
	 * is checked, i.e. each message is re-encoded and differences between the
	 * received message text and the re-encoded text are written to the file
	 * <hapi.home>/parse_check.txt.
	 */
	public Responder(Parser parser) throws LLPException {
		String checkParse = System.getProperty("ca.uhn.hl7v2.app.checkparse");
		if (checkParse != null && checkParse.equals("true")) {
			init(parser, true);
		} else {
			init(parser, false);
		}
	}

	/**
	 * Creates a new instance of Responder that optionally validates parsing of
	 * incoming messages.
	 * 
	 * @param validate
	 *            if true, encodes each incoming message after parsing it,
	 *            compares the result to the original message string, and prints
	 *            differences to the file "<hapi.home>/parse_check.txt" in the
	 *            working directory. This process is slow and should only be
	 *            used during testing.
	 */
	public Responder(Parser parser, boolean checkParse) {
		init(parser, checkParse);
	}

	/**
	 * Performs common constructor tasks.
	 */
	private void init(Parser parser, boolean checkParse) {
		this.parser = parser;
		apps = new ArrayList<Application>(10);
		try {
			if (checkParse)
				checkWriter = new BufferedWriter(new FileWriter(Environment.getExternalStorageDirectory() + "/parse_check.txt", true));
		} catch (IOException e) {
			Log.e(Constants.TAG, "Unable to open file to write parse check results.  Parse integrity checks will not proceed");
		}
	}

	/**
	 * Processes an incoming message string and returns the response message
	 * string. Message processing consists of parsing the message, finding an
	 * appropriate Application and processing the message with it, and encoding
	 * the response. Applications are chosen from among those registered using
	 * <code>registerApplication</code>. The Parser is obtained from the
	 * Connection associated with this Responder.
	 */
	protected String processMessage(String incomingMessageString) throws HL7Exception {

		Log.d(Constants.TAG, "Responder got message: {"+incomingMessageString+"}");
		Log.d(Constants.TAG, incomingMessageString);

		Message incomingMessageObject = null;
		String outgoingMessageString = null;
		try {
			incomingMessageObject = parser.parse(incomingMessageString);
		} catch (HL7Exception e) {
			// TODO this may also throw an Exception, which hides the
			// previous one.
			outgoingMessageString = logAndMakeErrorMessage(e,
					parser.getCriticalResponseData(incomingMessageString),
					parser, parser.getEncoding(incomingMessageString));
			for (Object app : apps) {
				if (app instanceof ApplicationExceptionHandler) {
					ApplicationExceptionHandler aeh = (ApplicationExceptionHandler) app;
					outgoingMessageString = aeh.processException(
							incomingMessageString, outgoingMessageString, e);
				}
			}
		}

		if (outgoingMessageString == null) {
			try {
				// optionally check integrity of parse
				try {
					if (checkWriter != null)
						checkParse(incomingMessageString,
								incomingMessageObject, parser);
				} catch (IOException e) {
					Log.e(Constants.TAG, "Unable to write parse check results to file");
				}

				// message validation (in terms of optionality, cardinality)
				// would go here ***

				Application app = findApplication(incomingMessageObject);
				Message response = app.processMessage(incomingMessageObject);

				if (response == null) {
					throw new HL7Exception("Application of type " + app.getClass().getName() + " failed to return a response message from 'processMessage'");
				}
				
				// Here we explicitly use the same encoding as that of the
				// inbound message - this is important with GenericParser, which
				// might use a different encoding by default
				outgoingMessageString = parser.encode(response,
						parser.getEncoding(incomingMessageString));
			} catch (Exception e) {
				outgoingMessageString = logAndMakeErrorMessage(e,
						(Segment) incomingMessageObject.get("MSH"), parser,
						parser.getEncoding(incomingMessageString));
			}
		}

		Log.d(Constants.TAG, "Responder sending message: {"+outgoingMessageString+"}");
		Log.d(Constants.TAG, outgoingMessageString);

		return outgoingMessageString;
	}

	/**
	 * Returns the first Application that has been registered, which can process
	 * the given Message (according to its canProcess() method). If none is
	 * found, returns the DefaultApplication that always NAKs.
	 */
	private Application findApplication(Message message) {
		Application app = new DefaultApplication();
		for (Application a : apps) {
			if (a.canProcess(message)) {
				app = a;
				break;
			}
		}
		return app;
	}

	/**
	 * Encodes the given message and compares it to the given string. Any
	 * differences are noted in the file [hapi.home]/parse_check.txt. Ignores
	 * extra field delimiters.
	 */
	private void checkParse(String originalMessageText, Message parsedMessage,
			Parser parser) throws HL7Exception, IOException {
		Log.i(Constants.TAG, "ca.uhn.hl7v2.app.Responder is checking parse integrity (turn this off if you are not testing)");
		String newMessageText = parser.encode(parsedMessage);

		checkWriter
				.write("******************* Comparing Messages ****************\r\n");
		checkWriter
				.write("Original:           " + originalMessageText + "\r\n");
		checkWriter.write("Parsed and Encoded: " + newMessageText + "\r\n");

		if (!originalMessageText.equals(newMessageText)) {
			// check each segment
			StringTokenizer tok = new StringTokenizer(originalMessageText, "\r");
			List<String> one = new ArrayList<String>();
			while (tok.hasMoreTokens()) {
				String seg = tok.nextToken();
				if (seg.length() > 4)
					one.add(seg);
			}
			tok = new StringTokenizer(newMessageText, "\r");
			List<String> two = new ArrayList<String>();
			while (tok.hasMoreTokens()) {
				String seg = tok.nextToken();
				if (seg.length() > 4)
					two.add(stripExtraDelimiters(seg, seg.charAt(3)));
			}

			if (one.size() != two.size()) {
				checkWriter
						.write("Warning: inbound and parsed messages have different numbers of segments: \r\n");
				checkWriter.write("Original: " + originalMessageText + "\r\n");
				checkWriter.write("Parsed:   " + newMessageText + "\r\n");
			} else {
				// check each segment
				for (int i = 0; i < one.size(); i++) {
					String origSeg = one.get(i);
					String newSeg = two.get(i);
					if (!origSeg.equals(newSeg)) {
						checkWriter
								.write("Warning: inbound and parsed message segment differs: \r\n");
						checkWriter.write("Original: " + origSeg + "\r\n");
						checkWriter.write("Parsed: " + newSeg + "\r\n");
					}
				}
			}
		} else {
			checkWriter.write("No differences found\r\n");
		}

		checkWriter
				.write("********************  End Comparison  ******************\r\n");
		checkWriter.flush();

	}

	/**
	 * Removes unecessary delimiters from the end of a field or segment. This is
	 * cut-and-pasted from PipeParser (just making it public in PipeParser would
	 * kind of cloud the purpose of PipeParser).
	 */
	private static String stripExtraDelimiters(String in, char delim) {
		char[] chars = in.toCharArray();

		// search from back end for first occurance of non-delimiter ...
		int c = chars.length - 1;
		boolean found = false;
		while (c >= 0 && !found) {
			if (chars[c--] != delim)
				found = true;
		}

		String ret = "";
		if (found)
			ret = String.valueOf(chars, 0, c + 2);
		return ret;
	}

	/**
	 * Logs the given exception and creates an error message to send to the
	 * remote system.
	 * 
	 * @param encoding
	 *            The encoding for the error message. If <code>null</code>, uses
	 *            default encoding
	 */
	public static String logAndMakeErrorMessage(Exception e, Segment inHeader,
			Parser p, String encoding) throws HL7Exception {

		Log.e(Constants.TAG, "Attempting to send error message to remote system.");

		// create error message ...
		String errorMessage = null;
		try {
			Message out = DefaultApplication.makeACK(inHeader);
			Terser t = new Terser(out);

			// copy required data from incoming message ...
			try {
				t.set("/MSH-10", MessageIDGenerator.getInstance().getNewID());
			} catch (IOException ioe) {
				throw new HL7Exception("Problem creating error message ID: "
						+ ioe.getMessage());
			}

			// populate MSA ...
			t.set("/MSA-1", "AE"); // should this come from HL7Exception
									// constructor?
			t.set("/MSA-2", Terser.get(inHeader, 10, 0, 1, 1));
			String excepMessage = e.getMessage();
			if (excepMessage != null)
				t.set("/MSA-3",
						excepMessage.substring(0,
								Math.min(80, excepMessage.length())));

			/*
			 * Some earlier ACKs don't have ERRs, but I think we'll change this
			 * within HAPI so that there is a single ACK for each version (with
			 * an ERR).
			 */
			// see if it's an HL7Exception (so we can get specific information)
			// ...
			if (e.getClass().equals(HL7Exception.class)) {
//				Segment err = (Segment) out.get("ERR");
				// ((HL7Exception) e).populate(err); // FIXME: this is broken,
				// it relies on the database in a place where it's not available
			} else {
				t.set("/ERR-1-4-1", "207");
				t.set("/ERR-1-4-2", "Application Internal Error");
				t.set("/ERR-1-4-3", "HL70357");
			}

			if (encoding != null) {
				errorMessage = p.encode(out, encoding);
			} else {
				errorMessage = p.encode(out);
			}

		} catch (IOException ioe) {
			throw new HL7Exception(
					"IOException creating error response message: "
							+ ioe.getMessage(),
					HL7Exception.APPLICATION_INTERNAL_ERROR);
		}
		return errorMessage;
	}

	/**
	 * Registers a message parser/encoder with this responder. If multiple
	 * parsers are registered, each message is inspected by each parser in the
	 * order in which they are registered, until one parser recognizes the
	 * format and parses the message.
	 */
	/*
	 * public void registerParser(Parser p) { this.parsers.add(p); }
	 */

	/**
	 * Registers an Application with this Responder. The "Application", in this
	 * context, is the software that uses the information in the message. If
	 * multiple applications are registered, incoming Message objects will be
	 * passed to each one in turn (calling <code>canProcess()</code>) until one
	 * of them accepts responsibility for the message. If none of the registered
	 * applications can process the message, a DefaultApplication is used, which
	 * simply returns an Application Reject message.
	 */
	public void registerApplication(Application a) {
		this.apps.add(a);
	}

	/**
	 * Test code.
	 */
	@SuppressWarnings("unused")
	public static void main(String args[]) {
		if (args.length != 1) {
			System.err.println("Usage: DefaultApplication message_file");
			System.exit(1);
		}

		// read test message file ...
		try {
			File messageFile = new File(args[0]);
			Reader in = new BufferedReader(new FileReader(messageFile));
			int fileLength = (int) messageFile.length();
			char[] cbuf = new char[fileLength];
			in.read(cbuf, 0, fileLength);
			String messageString = new String(cbuf);

			// parse inbound message ...
			final Parser parser = new PipeParser();
			Message inMessage = null;
			try {
				inMessage = parser.parse(messageString);
			} catch (HL7Exception e) {
				e.printStackTrace();
			}

			// process with responder ...
			PipedInputStream initInbound = new PipedInputStream();
			PipedOutputStream initOutbound = new PipedOutputStream();
			PipedInputStream respInbound = new PipedInputStream(initOutbound);
			PipedOutputStream respOutbound = new PipedOutputStream(initInbound);

			/*
			 * This code won't work with new changes: final Initiator init = new
			 * Initiator(parser, new MinLowerLayerProtocol(), initInbound,
			 * initOutbound); Responder resp = new Responder(respInbound,
			 * respOutbound);
			 * 
			 * //run the initiator in a separate thread ... final Message
			 * inMessCopy = inMessage; Thread initThd = new Thread(new
			 * Runnable() { public void run() { try { Message response =
			 * init.sendAndReceive(inMessCopy);
			 * System.out.println("This is initiator writing response ...");
			 * System.out.println(parser.encode(response)); } catch (Exception
			 * ie) { if (HL7Exception.class.isAssignableFrom(ie.getClass())) {
			 * System.out.println("Error in segment " +
			 * ((HL7Exception)ie).getSegmentName() + " field " +
			 * ((HL7Exception)ie).getFieldPosition()); } ie.printStackTrace(); }
			 * } }); initThd.start();
			 * 
			 * //process the message we expect from the initiator thread ...
			 * System.out.println("Responder is going to respond now ...");
			 * resp.processOneMessage();
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
