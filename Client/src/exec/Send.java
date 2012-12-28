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
import ca.uhn.hl7v2.hoh.raw.client.HohRawClientSimple;
import ca.uhn.hl7v2.hoh.sockets.CustomCertificateTlsSocketFactory;
import ca.uhn.hl7v2.hoh.sockets.TlsSocketFactory;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v26.message.ORU_R01;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

public class Send {

	private String host = "localhost";
	private int port = 8080;
	private String uri = "/Server/Hl7_listener";
	private String theUsername = "ecare";
	private String thePassword = "ecare";
	
	public void sendMessage(ORU_R01 mess) throws HL7Exception {
		Parser p = PipeParser.getInstanceWithNoValidation();
		HohRawClientSimple cli = new HohRawClientSimple(this.host, this.port, this.uri);
		
		CustomCertificateTlsSocketFactory clientSocketFactory = new CustomCertificateTlsSocketFactory();
		clientSocketFactory.setKeystoreFilename("truststore.jks");
		clientSocketFactory.setKeystorePassphrase("trustpassword");
		cli.setSocketFactory(clientSocketFactory);

		
		IAuthorizationClientCallback authCallback = new SingleCredentialClientCallback(theUsername, thePassword);
		cli.setSocketFactory(new TlsSocketFactory());
		cli.setAuthorizationCallback(authCallback);
		ISendable sendable = new MessageSendable(mess);
		
		try {
			IReceivable<String> receivable = cli.sendAndReceive(sendable);
			String message = receivable.getMessage();
			System.out.println(message);
			String remoteip = (String) receivable.getMetadata().get(MessageMetadataKeys.REMOTE_HOST_ADDRESS);
			System.out.println(remoteip);
		} catch (DecodeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncodeException e) {
			e.printStackTrace();
		} finally {}
	}
}
