package com.adriangalvarez.cv.fragments;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adriangalvarez.cv.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TechsFragment extends Fragment{

	private View thisFragment;

	private static final int MAX_STEP = 4;

	private String[] about_description_array;
	private int[] about_images_array;

	private ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener(){

		@Override
		public void onPageSelected( final int position ){
			bottomProgressDots( position );
		}

		@Override
		public void onPageScrolled( int arg0, float arg1, int arg2 ){
		}

		@Override
		public void onPageScrollStateChanged( int arg0 ){
		}
	};

	public TechsFragment(){
		// Required empty public constructor
	}


	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
		// Inflate the layout for this fragment
		return inflater.inflate( R.layout.fragment_techs, container, false );
	}

	@Override
	public void onViewCreated( @NonNull View view, @Nullable Bundle savedInstanceState ){
		super.onViewCreated( view, savedInstanceState );
		thisFragment = view;
		initComponent();
	}

	private void initComponent() {
		about_description_array = new String[4];
		about_description_array[0] = getString( R.string.dotnet );
		about_description_array[1] = getString( R.string.bbdd );
		about_description_array[2] = getString( R.string.android );
		about_description_array[3] = getString( R.string.techs_desuso_desc );

		about_images_array = new int[4];
		about_images_array[0] = R.drawable.ic_dotnet;
		about_images_array[1] = R.drawable.ic_logosbbdd;
		about_images_array[2] = R.drawable.ic_android;
		about_images_array[3] = R.drawable.ic_logostechsunused;

		ViewPager viewPager = thisFragment.findViewById( R.id.view_pager );

		bottomProgressDots(0);

		MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter();
		viewPager.setAdapter( myViewPagerAdapter );
		viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
	}

	private void bottomProgressDots(int current_index) {
		LinearLayout dotsLayout = thisFragment.findViewById(R.id.layoutDots);
		ImageView[] dots = new ImageView[MAX_STEP];

		dotsLayout.removeAllViews();
		for (int i = 0; i < dots.length; i++) {
			dots[i] = new ImageView(getContext());
			int width_height = 15;
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
			params.setMargins(10, 10, 10, 10);
			dots[i].setLayoutParams(params);
			dots[i].setImageResource(R.drawable.shape_circle);
			dots[i].setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);
			dotsLayout.addView(dots[i]);
		}

		dots[current_index].setImageResource(R.drawable.shape_circle);
		dots[current_index].setColorFilter(getResources().getColor(R.color.colorPrimaryDark), PorterDuff.Mode.SRC_IN);
	}

	public class MyViewPagerAdapter extends PagerAdapter{

		MyViewPagerAdapter() {
		}

		@Override
		public Object instantiateItem( ViewGroup container, int position) {
			LayoutInflater layoutInflater = ( LayoutInflater ) getActivity().getSystemService( Context.LAYOUT_INFLATER_SERVICE );

			View view = layoutInflater.inflate(R.layout.item_stepper_wizard, container, false);

			if( position == 3 ){
				( ( TextView ) view.findViewById( R.id.txtTechTitle ) ).setText( getString( R.string.techs_desuso ) );
			}else{
				( ( TextView ) view.findViewById( R.id.txtTechTitle ) ).setText( getString( R.string.techs ) );
			}

			( ( ImageView ) view.findViewById( R.id.imgTech ) ).setImageResource( about_images_array[ position ] );
			( ( TextView ) view.findViewById( R.id.txtTechDescription ) ).setText( about_description_array[ position ] );
			container.addView(view);

			return view;
		}

		@Override
		public int getCount() {
			return about_description_array.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object obj) {
			return view == obj;
		}


		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			View view = (View) object;
			container.removeView(view);
		}
	}

}
