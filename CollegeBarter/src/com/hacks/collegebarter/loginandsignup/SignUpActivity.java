package com.hacks.collegebarter.loginandsignup;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.hacks.collegebarter.R;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends Activity {



	/* Variables storing widget id's */

	EditText userNameField;
	EditText emailField;
	EditText passwordField;
	String usernameText;
	String emailText;
	String passwordText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		// Parse Initialize
				Parse.initialize(this, "yGAHbDZTw9xuh1NHC5YMLoif5u9qgYoOGak2nd62",
						"BY79vcfUFtS9WTRCdg9Vf2ovnLnYzPnYk2waPwbq");
		userNameField = (EditText) findViewById(R.id.signUpUserNameText);
		emailField = (EditText) findViewById(R.id.signUpEmailText);
		passwordField = (EditText) findViewById(R.id.signUpPasswordText);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_sign_in) {
			// set widget id's
			//Toast.makeText(SignUpActivity.this, "Going to app1",
				//	Toast.LENGTH_SHORT).show();
			
			

			// create new parseUser object
			ParseUser newUser = new ParseUser();

			// get the strings stored in userName and password field

			usernameText = userNameField.getText().toString();
			emailText = emailField.getText().toString();
			passwordText = passwordField.getText().toString();

			// set parse User name and password fields
			newUser.setUsername(usernameText);
			newUser.setEmail(emailText);
			newUser.setPassword(passwordText);

				//signUpInBackground
			newUser.signUpInBackground(new SignUpCallback() {
				public void done(ParseException e) {
					Toast.makeText(SignUpActivity.this, "Going to exception",
					Toast.LENGTH_SHORT).show();
					if (e == null) {
						Toast.makeText(SignUpActivity.this, "Going to app",
								Toast.LENGTH_SHORT).show();
					} // if sigUp passed
					else if (e.getCode() == ParseException.USERNAME_TAKEN) {
						Toast.makeText(SignUpActivity.this,
								"Username already taken", Toast.LENGTH_LONG)
								.show();
					}// userName is taken
					else {
						Toast.makeText(SignUpActivity.this,
								e.getMessage(), Toast.LENGTH_LONG)
								.show();
					}
				}
			});
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
	

