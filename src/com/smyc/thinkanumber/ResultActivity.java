package com.smyc.thinkanumber;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		setTitle("Think A Number");
		
		//ads staff 
		 AdView adView = (AdView) findViewById(R.id.adView);
		 AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
		 adView.loadAd(adRequest);
		 
		 TextView linked = (TextView) findViewById(R.id.textView2);
		 linked.setText(Html.fromHtml("Visit "
		 		+ "<a href=\"http://showmeyourcode.co.nf\">showmeyourcode.co.nf</a> "
		 		+ "to find more apps and to be a part of our open source community for programmers. "
		 		+ "You'll also find out how this works ;)"));
		 linked.setMovementMethod(LinkMovementMethod.getInstance());
		 
		 
		 
		
		Typeface myTypeface = Typeface.createFromAsset(getAssets(), "fonts/alpha_echo.ttf");
	    TextView resultText = (TextView) findViewById(R.id.result);
	    resultText.setText(ListActivity.theName);
	    resultText.setTypeface(myTypeface);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
	 
		
		 
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
		    .setTitle("About ShowMeYourCode.co.nf")
		    .setMessage("ShowMeYourCode is a community where anyone can post his/her open source programs, tutorials and much more to spread them to the world, to reinforce his/her CV and earn money from donations and ads.")
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
