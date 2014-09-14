package com.hacks.collegebarter.loginandsignup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hacks.collegebarter.R;
import com.hacks.collegebarter.navdrawer.MainAppActivity;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LogInActivity extends Activity {
	/* Variables storing widget id's */

	EditText userNameField;
	EditText passwordField;
	TextView cautionText;
	Button signUpButton;
	Button logInButton;
	String usernameText;
	String passwordText;
	ParseUser currentUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);

		// set widget id's
		userNameField = (EditText) findViewById(R.id.usernameField);
		passwordField = (EditText) findViewById(R.id.passwordField);
		cautionText = (TextView) findViewById(R.id.responseText);
		signUpButton = (Button) findViewById(R.id.signUpButton);
		logInButton = (Button) findViewById(R.id.logInId);

		// Parse Initialize
		Parse.initialize(this, "yGAHbDZTw9xuh1NHC5YMLoif5u9qgYoOGak2nd62",
				"BY79vcfUFtS9WTRCdg9Vf2ovnLnYzPnYk2waPwbq");

		/* When signUp button is clicked */

		signUpButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// switch to new activity
				Intent signUpIntent = new Intent(LogInActivity.this,
						SignUpActivity.class);
				startActivity(signUpIntent);
			}
		});

		/* When logIn button is clicked */


		logInButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// get strings from respective EditTextFields
				usernameText = userNameField.getText().toString().trim();
				passwordText = passwordField.getText().toString().trim();
				// login in background
				ParseUser.logInInBackground(usernameText, passwordText,
						new LogInCallback() {
							public void done(ParseUser user, ParseException e) {
								if (user != null) {
									// move to main
									Intent logInIntent = new Intent(
											LogInActivity.this,
											MainAppActivity.class);
									startActivity(logInIntent);
									finish();
								}// if user exist
								else {
									// if userName not found
									if (e.getCode() == ParseException.LINKED_ID_MISSING) {

										Toast.makeText(LogInActivity.this,
												"account does not exist",
												Toast.LENGTH_LONG).show();
										//make text in causionText view visible
										cautionText.setVisibility(View.VISIBLE);
									}
								}
							}
						});
			}
		});

		// Keep user signed in till user logs out
		currentUser = ParseUser.getCurrentUser();
		if (currentUser != null) {
			Intent logIn = new Intent(LogInActivity.this, MainAppActivity.class);
			startActivity(logIn);
			finish();
		} else {
			super.onResume();
		}

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
