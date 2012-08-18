package buet.threebyzero.autoSecuritySystem.client;

import android.app.Activity;
import android.os.Bundle;


public class Client extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		try {
			new FileServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block			
		}

	}
}
