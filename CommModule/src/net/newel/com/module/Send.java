package net.newel.com.module;

import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.api.MessageMetadataKeys;
import ca.uhn.hl7v2.hoh.hapi.api.MessageSendable;
import ca.uhn.hl7v2.hoh.raw.client.HohRawClientSimple;
import ca.uhn.hl7v2.hoh.sockets.CustomCertificateTlsSocketFactory;
import ca.uhn.hl7v2.model.v26.message.ORU_R01;

public class Send {

	private String host = "localhost";
	private int port = 8443;
	private String uri = "/Server/Hl7_listener";
	public void sendMessage(ORU_R01 mess) throws HL7Exception {
		HohRawClientSimple cli = new HohRawClientSimple(this.host, this.port, this.uri);

		CustomCertificateTlsSocketFactory clientSocketFactory = new CustomCertificateTlsSocketFactory();
		clientSocketFactory.setKeystoreFilename("/home/leo/workspace/TX/keystors/.truststore");
		clientSocketFactory.setKeystorePassphrase("e-Care");
		cli.setSocketFactory(clientSocketFactory);
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
