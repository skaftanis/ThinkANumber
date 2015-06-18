package com.smyc.thinkanumber;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button doit = (Button) findViewById(R.id.button1);
		doit.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				 Intent intent = new Intent(MainActivity.this, PickNumber.class); 
				 startActivity(intent);
				 overridePendingTransition(R.animator.animation1, R.animator.animation2);		
				 
				
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		//ads staff 
		 AdView adView = (AdView) findViewById(R.id.adView);
		 AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
		 adView.loadAd(adRequest);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			new AlertDialog.Builder(this)
		    .setTitle("About this app")
		    .setMessage("Think A Νumber is a trick(or magic) game. It's more complicated than the classic games of its category. "
		    		+ "So don't lose time! Try it and then impress your friends! Creator: Spiros Kaftanis. Builded(17/6/2015)")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		    .show();
			 
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
