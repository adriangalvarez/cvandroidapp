package com.adriangalvarez.cv.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.adriangalvarez.cv.HelperClasses.Tools;
import com.adriangalvarez.cv.HelperClasses.ViewAnimation;
import com.adriangalvarez.cv.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CertsFragment extends Fragment{

	private View thisFragment;

	private NestedScrollView nested_scroll_view;
	private ImageView[] bt_toggle_text;
	private Button[] bt_hide_text;
	private View[] lyt_expand_text;

	public CertsFragment(){
		// Required empty public constructor
	}


	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
		// Inflate the layout for this fragment
		return inflater.inflate( R.layout.fragment_certs, container, false );
	}

	@Override
	public void onViewCreated( @NonNull View view, @Nullable Bundle savedInstanceState ){
		super.onViewCreated( view, savedInstanceState );
		thisFragment = view;
		initComponent();
	}

	private void initComponent() {
		// Title
		bt_toggle_text = new ImageView[ 4 ];
		bt_toggle_text[0] = thisFragment.findViewById(R.id.bt_certs_toggle_text_0);
		bt_toggle_text[1] = thisFragment.findViewById(R.id.bt_certs_toggle_text_1);
		bt_toggle_text[2] = thisFragment.findViewById(R.id.bt_certs_toggle_text_2);
		bt_toggle_text[3] = thisFragment.findViewById(R.id.bt_certs_toggle_text_3);

		bt_hide_text = new Button[ 4 ];
		bt_hide_text[0] = thisFragment.findViewById(R.id.bt_certs_hide_text_0);
		bt_hide_text[1] = thisFragment.findViewById(R.id.bt_certs_hide_text_1);
		bt_hide_text[2] = thisFragment.findViewById(R.id.bt_certs_hide_text_2);
		bt_hide_text[3] = thisFragment.findViewById(R.id.bt_certs_hide_text_3);

		lyt_expand_text = new View[ 4 ];
		lyt_expand_text[0] = thisFragment.findViewById(R.id.lyt_certs_expand_text_0);
		lyt_expand_text[1] = thisFragment.findViewById(R.id.lyt_certs_expand_text_1);
		lyt_expand_text[2] = thisFragment.findViewById(R.id.lyt_certs_expand_text_2);
		lyt_expand_text[3] = thisFragment.findViewById(R.id.lyt_certs_expand_text_3);

		nested_scroll_view = thisFragment.findViewById(R.id.nested_scroll_view);

		for( View layout : lyt_expand_text ){
			layout.setVisibility(View.GONE);
		}

		for( int i = 0; i < 4; i++ ){
			final int j = i;
			bt_toggle_text[i].setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					toggleSectionText(bt_toggle_text[j], lyt_expand_text[j]);
				}
			});
			bt_hide_text[i].setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					toggleSectionText(bt_toggle_text[j], lyt_expand_text[j]);
				}
			});
		}
	}

	private void toggleSectionText( View view, final View layout) {
		boolean show = toggleArrow(view);
		if (show) {
			ViewAnimation.expand(layout, new ViewAnimation.AnimListener() {
				@Override
				public void onFinish() {
					Tools.nestedScrollTo(nested_scroll_view, layout);
				}
			});
		} else {
			ViewAnimation.collapse(layout);
		}
	}

	public boolean toggleArrow(View view) {
		if (view.getRotation() == 0) {
			view.animate().setDuration(200).rotation(180);
			return true;
		} else {
			view.animate().setDuration(200).rotation(0);
			return false;
		}
	}
}
