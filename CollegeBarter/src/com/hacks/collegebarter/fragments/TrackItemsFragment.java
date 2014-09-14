package com.hacks.collegebarter.fragments;

import com.hacks.collegebarter.R;
import com.hacks.collegebarter.navdrawer.MainAppActivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TrackItemsFragment extends Fragment {

	public static final String ARG_SECTION_NUMBER = "section_number";

	// TrackitemsFragment Constructor
	public TrackItemsFragment() {
		Bundle sectionTracker = new Bundle();
		sectionTracker.putInt("section_number", 2);
		this.setArguments(sectionTracker);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.following_fragment,
				container, false);

		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainAppActivity) activity).onSectionAttached(getArguments().getInt(
				ARG_SECTION_NUMBER));
	}
}
