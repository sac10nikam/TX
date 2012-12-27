package testHAPIScript;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;
import ca.uhn.hl7v2.validation.impl.NoValidation;


public class MessageValidation {

	public static void main(String[] args) throws EncodingNotSupportedException {

		/*
			* In this example, we are looking at a few aspects of message
			* validation using HAPI.
			* 
			* The following message will be used in the examples:
			* 
			* MSH|^~\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|75535037-1237815294895|P^T|2.4
			* EVN|A31|200903230934
			* PID|1||29^^CAISI_1-2^PI~""||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||
		*/
		String validMessage = "MSH|^~\\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|75535037-1237815294895|P^T|2.4\r\n"
		+ "EVN|A31|200903230934\r\n"
		+ "PID|1||29^^CAISI_1-2^PI~\"\"||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||";

		/*
			* Let's start by constructing a parser using default settings. By
			* default, a parser has certain validation settings, as defined by the
			* DefaultValidation class.
		*/
		PipeParser parser = new PipeParser();

		/*
			* These two lines are actually redundant, since this is the default/
			* validator. The default validation includes a number of sensible/
			* defaults including maximum lengths on string types, formats for/
			* telephone numbers and timestamps, etc./
		*/
		DefaultValidation defaultValidation = new DefaultValidation();
		parser.setValidationContext(defaultValidation);

		// Let's try parsing the valid message:/
		try {
			parser.parse(validMessage);
			System.out.println("Successfully parsed valid message");
		} catch (HL7Exception e) {
			// This shouldn't happen!/
			System.out.println("Something went wrong!");
			System.exit(-1);
		}

		/* 
			Next, let's set EVN-2 to a string that is longer than 200 chars.
			DefaultValidation specified that ID datatypes must not exceed this
			length
		*/
		String invalidMessage = "MSH|^~\\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|75535037-1237815294895|P^T|2.4\r\n"
		+ "EVN|0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789|200903230934\r\n"
		+ "PID|1||29^^CAISI_1-2^PI~\"\"||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||";

		// Let's try parsing the valid message:/
		try {
			parser.parse(invalidMessage);
			// This shouldn't happen!/
			System.out.println("Something went wrong!");
			System.exit(-1);
		} catch (HL7Exception e) {
			// This time, we are expecing an exception, because the message
			// should fail validation.
			System.out.println("As expected, the message did not validate: "
			+ e.getMessage());
			/*
				* Prints: 
				* As expected, the message did not validate: Failed validation rule: Maxumim size <= 200 characters: Segment: EVN (rep 0) Field #1
			*/
		}

		/*
			* Now, suppose we want to throw caution to the wind, and not do 
			* any validation. This is fairly common practice in the real
			* world, since sending systems don't always behave as nicely as
			* we might want.
		*/
		NoValidation noValidation = new NoValidation();
		parser.setValidationContext(noValidation);

		try {
			parser.parse(invalidMessage);
			System.out.println("Successfully parsed invalid message");
		} catch (HL7Exception e) {
			// This shouldn't happen!/
			System.out.println("Something went wrong!");
			System.exit(-1);
		}

		/*
			* One important thing to note is that NoValidation still includes one/
			* rule: A rule which strips leading space from FT, ST, and TX fields./
			* /
			* Let's add some leading space to MSH-10 (this isn't something you would /
			* want to do normally, but it does demonstrate leading space trimming from/
			* ST datatypes) /
		*/
		invalidMessage = "MSH|^~\\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|             CONTROLID|P^T|2.4\r\n"
		+ "EVN|A03|200903230934\r\n"
		+ "PID|1||29^^CAISI_1-2^PI~\"\"||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||";
		try {
			Message parsedMessage = parser.parse(invalidMessage);

			// Print the mesage back out/
			System.out.println(new PipeParser().encode(parsedMessage));

			/*/
				* MSH|^~\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|CONTROLID|P^T|2.4/
				* EVN|A03|200903230934/
				* PID|1||29^^CAISI_1-2^PI~""||Test300^Leticia^^^^^L||19770202|M/
			*/

		} catch (HL7Exception e) {
			e.printStackTrace();
		}


	}

}
