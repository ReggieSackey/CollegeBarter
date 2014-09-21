package com.hacks.collegebarter.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hacks.collegebarter.R;
import com.hacks.collegebarter.navdrawer.MainAppActivity;

public class SoldItemsFragment extends Fragment {
	
	// Constant number to identify section. Used in onSessionAttached
    public static final String ARG_SECTION_NUMBER = "section_number";


	// SoldItemsFragment constructor
	public SoldItemsFragment() {
		Bundle sectionTracker = new Bundle();
		sectionTracker.putInt("section_number", 2);
		this.setArguments(sectionTracker);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.solditems_fragment,
				container, false);

		return rootView;
	}
	
	// Attaches the fragment to the activity
	  @Override
	    public void onAttach(Activity activity) {
	        super.onAttach(activity);
	        ((MainAppActivity) activity).onSectionAttached(
	                getArguments().getInt(ARG_SECTION_NUMBER)); // Retrieves the constant number tagged to this section
	    }

}
