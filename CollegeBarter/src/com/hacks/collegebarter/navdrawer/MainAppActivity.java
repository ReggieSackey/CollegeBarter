package com.hacks.collegebarter.navdrawer;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.hacks.collegebarter.R;
import com.hacks.collegebarter.fragments.CartFragment;
import com.hacks.collegebarter.fragments.FollowingFragment;
import com.hacks.collegebarter.fragments.SoldItemsFragment;
import com.hacks.collegebarter.fragments.TrackItemsFragment;
import com.hacks.collegebarter.loginandsignup.LogInActivity;
import com.hacks.collegebarter.loginandsignup.SignUpActivity;

public class MainAppActivity extends Activity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */

	// Test to commit ;
	private CharSequence mTitle;
	private String[] fragmentNames;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_app);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// Create fragments
		Fragment changeFragments = null;
		FragmentManager fragmentManager = getFragmentManager();

		// Case to change fragments on item selected from the nav drawer
		switch (position) {
		case 0:
			changeFragments = new CartFragment();
			break;
		case 1:
			changeFragments = new SoldItemsFragment();
			break;
		case 2:
			changeFragments = new TrackItemsFragment();
			break;
		case 3:
			changeFragments = new FollowingFragment();
			break;
		}

		fragmentManager.beginTransaction()
				.replace(R.id.container, changeFragments).commit();
	//	onSectionAttached(changeFragments.getArguments().getInt(CartFragment.ARG_SECTION_NUMBER));
		getActionBar().setTitle(mTitle);

	}

	public void onSectionAttached(int number) {
		fragmentNames = getResources().getStringArray(R.array.item_list);
		switch (number) {
		case 0:
			mTitle = fragmentNames[0];
			break;
		case 1:
			mTitle = fragmentNames[1];
			break;
		case 2:
			mTitle = fragmentNames[2];
			break;
		case 3:
			mTitle = fragmentNames[3];
			break;
		case 4:
			mTitle = fragmentNames[4];
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);

		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main_app, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_sign_out) {
			
			//move to logIn page
			Intent myIntent = new Intent(this,LogInActivity.class);
			startActivity(myIntent);
			
			// end current activity
			finish(); 
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
