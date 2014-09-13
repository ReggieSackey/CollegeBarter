package com.hacks.collegebarter.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hacks.collegebarter.R;

public class CartFragment extends Fragment {
 
	// Constructor for CartFragment
	public CartFragment(){}
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	  
	        View rootView = inflater.inflate(R.layout.cart_fragment, container, false);
	          
	        return rootView;
	    }
}
