package srv;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.hapi.server.HohServlet;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;

public class Hl7_listener extends HohServlet {	
	
	private static final long serialVersionUID = 1L;
	@Override
	public void init(ServletConfig theConfig) throws ServletException {
		setApplication(new MyApplication());
	}
	private class MyApplication implements ReceivingApplication {
		public Message processMessage(Message theMessage, Map<String, Object> theMetadata) 
				throws ReceivingApplicationException, HL7Exception {
			System.out.println("Received message:\n" + theMessage.encode());
			// TODO .. process the message ..
			Message response;
			try {
				response = theMessage.generateACK();
			} catch (IOException e) {
				throw new ReceivingApplicationException(e);
			}
			boolean somethingFailed = false;
			if (somethingFailed) {
				throw new ReceivingApplicationException("");
			}
			if (somethingFailed) {
				try {
					response = theMessage.generateACK("AE", new HL7Exception("There was a problem!!"));
				} catch (IOException e) {
					throw new ReceivingApplicationException(e);
				}
			}
			return response;
		}
		public boolean canProcess(Message theMessage) {
			return true;
		}
	}
}