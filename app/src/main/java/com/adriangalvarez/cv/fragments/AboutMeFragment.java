package com.adriangalvarez.cv.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adriangalvarez.cv.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.mikhaellopez.circularimageview.CircularImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutMeFragment extends Fragment{

	private View thisFragment;

	public AboutMeFragment(){
		// Required empty public constructor
	}


	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
		// Inflate the layout for this fragment
		return inflater.inflate( R.layout.fragment_about_me, container, false );
	}

	@Override
	public void onViewCreated( @NonNull View view, @Nullable Bundle savedInstanceState ){
		super.onViewCreated( view, savedInstanceState );
		thisFragment = view;
		initComponent();
	}

	private void initComponent() {
		final CircularImageView image = thisFragment.findViewById( R.id.image );
		final CollapsingToolbarLayout collapsing_toolbar = thisFragment.findViewById(R.id.collapsing_toolbar);
		(( AppBarLayout ) thisFragment.findViewById(R.id.app_bar_layout)).addOnOffsetChangedListener( new AppBarLayout.OnOffsetChangedListener() {
			@Override
			public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
				int min_height = ViewCompat.getMinimumHeight(collapsing_toolbar) * 2;
				float scale = (float) (min_height + verticalOffset) / min_height;
				image.setScaleX(scale >= 0 ? scale : 0);
				image.setScaleY(scale >= 0 ? scale : 0);
			}
		});
	}

}
