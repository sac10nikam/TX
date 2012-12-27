package exec;

import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IAuthorizationClientCallback;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.api.MessageMetadataKeys;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialClientCallback;
import ca.uhn.hl7v2.hoh.hapi.api.MessageSendable;
import ca.uhn.hl7v2.hoh.hapi.client.HohClientSimple;
import ca.uhn.hl7v2.hoh.sockets.TlsSocketFactory;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v26.message.ORU_R01;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

public class Send {
	/*
	 * http://localhost:8080/AppContext
	 */
	String host = "localhost";
	int port = 8080;
	String uri = "/Hl7_listener";

	public void send(ORU_R01 mess) throws HL7Exception {
		// Create a parser
		Parser parser = PipeParser.getInstanceWithNoValidation();
	
		// Create a client
		HohClientSimple client = new HohClientSimple(host, port, uri, parser);
		// Set the socket factory to use TLS
		client.setSocketFactory(new TlsSocketFactory());
	
		// Optionally, if credentials should be sent, they 
		// can be provided using a credential callback
		IAuthorizationClientCallback authCalback = new SingleCredentialClientCallback("ausername", "somepassword");
		client.setAuthorizationCallback(authCalback);
	
		// The ISendable defines the object that provides the actual
		// message to send
	
		// The MessageSendable provides the message to send 
		ISendable sendable = new MessageSendable(mess);
	
		try {
		        // sendAndReceive actually sends the message
		        IReceivable<Message> receivable = client.sendAndReceiveMessage(sendable);
		        
		        // receivavle.getRawMessage() provides the response
		        Message message = receivable.getMessage();
		        System.out.println("Response was:\n" + message.encode());
		        
		        // IReceivable also stores metadata about the message
		        String remoteHostIp = (String) receivable.getMetadata().get(MessageMetadataKeys.REMOTE_HOST_ADDRESS);
		        System.out.println("From:\n" + remoteHostIp);
		        
		        /*
		         * Note that the client may be reused as many times as you like,
		         * by calling sendAndReceiveMessage repeatedly
		         */
		        
		} catch (DecodeException e) {
		        // Thrown if the response can't be read
		        e.printStackTrace();
		} catch (IOException e) {
		        // Thrown if communication fails
		        e.printStackTrace();
		} catch (EncodeException e) {
		        // Thrown if the message can't be encoded (generally a programming bug)
		        e.printStackTrace();
		}
	}
}
