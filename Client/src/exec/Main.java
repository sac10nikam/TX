package exec;

import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import testTools.GenMessages;

public class Main {
	public static void main(String[] args) {
		try {
			GenMessages mess = new GenMessages();
			Integer[] val = {27, 34, 36};
			Integer[] val2 = {29, 39, 42};
			mess.addMeasur("21:27:45:67:58:65:f7", val);
			mess.addMeasur("69:27:45:67:58:65:f7", val2);
			Send snd = new Send();
			snd.sendMessage(mess.getMessage());
		} catch (HL7Exception e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
