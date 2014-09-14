package com.hacks.collegebarter.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hacks.collegebarter.R;
import com.hacks.collegebarter.navdrawer.MainAppActivity;

public class PurchaseHistoryFragment extends Fragment {
	public static final String ARG_SECTION_NUMBER = "section_number";

	// Following constructor
	public PurchaseHistoryFragment() {
		Bundle bundle = new Bundle();
		bundle.putInt(ARG_SECTION_NUMBER, 4);
		this.setArguments(bundle);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.purchase_history,
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
