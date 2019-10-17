package com.adriangalvarez.cv.HelperClasses;

import android.view.View;

import androidx.core.widget.NestedScrollView;

/**
 * Created by adriangalvarez on 04/10/2019.
 */
public class Tools{
	public static void nestedScrollTo( final NestedScrollView nested, final View targetView) {
		nested.post(new Runnable() {
			@Override
			public void run() {
				nested.scrollTo(500, targetView.getBottom());
			}
		});
	}
}
