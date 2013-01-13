package net.newel.com.module;

import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button sendButton = (Button) findViewById(R.id.Send_button);
		OnClickListener lis = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
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
