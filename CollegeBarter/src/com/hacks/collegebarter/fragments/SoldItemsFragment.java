package com.hacks.collegebarter.fragments;

import com.hacks.collegebarter.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SoldItemsFragment extends Fragment {
	
	//SoldItemsFragment constructor
	public SoldItemsFragment(){
		//to be populated
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.solditems_fragment, container, false);
          
        return rootView;
    }

}
