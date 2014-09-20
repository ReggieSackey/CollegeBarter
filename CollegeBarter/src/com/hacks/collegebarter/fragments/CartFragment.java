package com.hacks.collegebarter.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.hacks.collegebarter.R;
import com.hacks.collegebarter.navdrawer.MainAppActivity;

public class CartFragment extends Fragment {

	public static final String ARG_SECTION_NUMBER = "section_number";

	// Constructor for CartFragment
	public CartFragment() {
		Bundle sectionTracker = new Bundle();
		sectionTracker.putInt("section_number", 0);
		this.setArguments(sectionTracker);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.cart_fragment, container,
				false);
		
	

		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainAppActivity) activity).onSectionAttached(getArguments().getInt(
				ARG_SECTION_NUMBER));
	}

}
