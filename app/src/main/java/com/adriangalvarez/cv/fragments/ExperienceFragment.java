package com.adriangalvarez.cv.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adriangalvarez.cv.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExperienceFragment extends Fragment{


	public ExperienceFragment(){
		// Required empty public constructor
	}


	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
		// Inflate the layout for this fragment
		return inflater.inflate( R.layout.fragment_experience, container, false );
	}

}
