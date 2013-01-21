package net.newel.com.module;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import android.os.Bundle;
import android.app.Activity;
import android.util.Base64;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/* Creation du certificat */
		FileOutputStream output = null;       
		         
		try {
			File f = new File(this.getFilesDir().getPath().toString()+"/.truststore");
			f.delete();
			if (!f.exists()) {
				f.createNewFile();
				output = new FileOutputStream(f);
				output.write(Base64.decode("" +
						"AAAAAQAAABRCIkntBdljUQmkjYN40RRu9OXe8AAABa8BAAZ0b21jYXQAAAE8WZ30vwAAAAAABVgu"+
						"NTA5AAACTzCCAkswggG0oAMCAQICBFDg2eswDQYJKoZIhvcNAQEFBQAwajELMAkGA1UEBhMCRlIx"+
						"DzANBgNVBAgTBkZyYW5jZTEQMA4GA1UEBxMHQmVsZm9ydDEOMAwGA1UEChMFTmV3ZWwxFDASBgNV"+
						"BAsTC2FuZHJvLmVjYXJlMRIwEAYDVQQDEwluZXdlbC5uZXQwHhcNMTIxMjMxMDAxODUxWhcNMjMw"+
						"MTA4MDAxODUxWjBqMQswCQYDVQQGEwJGUjEPMA0GA1UECBMGRnJhbmNlMRAwDgYDVQQHEwdCZWxm"+
						"b3J0MQ4wDAYDVQQKEwVOZXdlbDEUMBIGA1UECxMLYW5kcm8uZWNhcmUxEjAQBgNVBAMTCW5ld2Vs"+
						"Lm5ldDCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA3tEys+KveDCYUpVKcfvKAPFnyrIYS4c0"+
						"qzVveEtIK8ak5RK18PRRkbrQseLIPKqC70I29GFtEq0OxhlfXoGIiIAYSEodkLFe9fnyLczcVEEZ"+
						"a0RbBp9vfL8qlV6LJ+edp6RqQKxD/kGybSKjiRCeKGzoz6WDeARKHS5W0Ut5bSECAwEAATANBgkq"+
						"hkiG9w0BAQUFAAOBgQCOWJGzaxkz27RzUzMPgNwk4kHTlnFU34vGggT8T3SL1Hz35wJKohZGVDi4"+
						"V5J7mZi/MKTBADEVgPRozt9JUERM2olSerG7xATvALe8gWuPH60v+iIvIsPMfHSLyS3Wj8HMmQRy"+
						"6THubhdNnIwTpVOtWX4Q5bBW41dYItp7UgswxABkHEIuuJAEt2sZNJk+x0fai4x4RA=="
						, 0));
				
				if(output != null) {
					output.close();
					System.out.println("File create");
				}
			} else {
				System.out.println("File already exist");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* Boutton envoyer */
		final Button sendButton = (Button) findViewById(R.id.Send_button);
		final TextView txt = (TextView) findViewById(R.id.textView1);
		OnClickListener lis = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				txt.setText("MSH|^~\\&|||||20130113141158.06+0100||ACK^R01|5|6428|2.6\nMSA|AA|110");
				//*
				try {
					GenMessages mess = new GenMessages();
					Integer[] val = {27, 34, 36};
					Integer[] val2 = {29, 39, 42};
					mess.addMeasur("21:27:45:67:58:65:f7", val);
					mess.addMeasur("69:27:45:67:58:65:f7", val2);
					Send snd = new Send(MainActivity.this);
					snd.sendMessage(mess.getMessage());
				} catch (HL7Exception e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}				//*/
			}
		};
		sendButton.setOnClickListener(lis);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
