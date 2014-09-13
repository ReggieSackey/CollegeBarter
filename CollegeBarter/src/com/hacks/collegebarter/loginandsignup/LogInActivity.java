package com.hacks.collegebarter.loginandsignup;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hacks.collegebarter.R;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LogInActivity extends Activity {

	/* Variables storing widget id's */
	
	EditText userNameField;
	EditText passwordField;
	Button signUpButton;
	Button logInButton;
	String userNameText;
	String passwordText;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);
		
		// set widget id's
		userNameField = (EditText) findViewById(R.id.usernameField);
		passwordField = (EditText) findViewById(R.id.passwordField);
		signUpButton = (Button) findViewById(R.id.signUpButton);
		logInButton = (Button) findViewById(R.id.logInId);
		
		//Parse Initialize
		 Parse.initialize(this, "yGAHbDZTw9xuh1NHC5YMLoif5u9qgYoOGak2nd62", "BY79vcfUFtS9WTRCdg9Vf2ovnLnYzPnYk2waPwbq");
		 
		
 
		 /* When signUp button is clicked */
		 
		 signUpButton.setOnClickListener(new View.OnClickListener(){
			 public void onClick(View v){
				 // create a new Parse User
			ParseUser newUser = new ParseUser();
			
			// get the strings stored in userName and password field
			
			userNameText = userNameField.getText().toString();
			passwordText = passwordField.getText().toString();
			
			//set parseuser name and password fields
			newUser.setUsername(userNameText);
			newUser.setPassword(passwordText);
			
		  /* save username and password on server, background process */
			
			newUser.signUpInBackground(new SignUpCallback(){
				public void done(ParseException e){
					if (e == null){
						Toast.makeText(LogInActivity.this, "Going to app", Toast.LENGTH_SHORT).show();
					} //if sigUp passed
					else if(e.getCode() == ParseException.USERNAME_TAKEN){
				        Toast.makeText(LogInActivity.this, "Username already taken", Toast.LENGTH_LONG).show();	
					}//userName is taken
				}
	     	});	 
		 }
	 });
		 
		 
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.log_in, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
