package com.adriangalvarez.cv.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.adriangalvarez.cv.fragments.AboutMeFragment;
import com.adriangalvarez.cv.fragments.CertsFragment;
import com.adriangalvarez.cv.fragments.EducationFragment;
import com.adriangalvarez.cv.fragments.ExperienceFragment;
import com.adriangalvarez.cv.fragments.LangsFragment;
import com.adriangalvarez.cv.fragments.TechsFragment;
import com.adriangalvarez.cv.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

	private ActionBar actionBar;
	private NavigationView navigationView;

	@Override
	protected void onCreate( Bundle savedInstanceState ){
		setTheme( R.style.AppTheme );
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );

		Toolbar toolbar = findViewById( R.id.toolbar );
		setSupportActionBar( toolbar );
		actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled( true );
		actionBar.setHomeButtonEnabled( true );

		DrawerLayout drawer = findViewById( R.id.drawer_layout );
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
		drawer.addDrawerListener( toggle );
		toggle.syncState();

		navigationView = findViewById( R.id.nav_view );
		navigationView.setNavigationItemSelectedListener( this );

		changeFragment( new AboutMeFragment() );
		navigationView.setCheckedItem( R.id.nav_about );
	}

	@Override
	public boolean onNavigationItemSelected( @NonNull MenuItem item ){
		boolean itemSelected = false;
		Fragment fragment = null;

		switch( item.getItemId() ){
			case R.id.nav_about:
				fragment = new AboutMeFragment();
				itemSelected = true;
				break;
			case R.id.nav_certs:
				fragment = new CertsFragment();
				itemSelected = true;
				break;
			case R.id.nav_education:
				fragment = new EducationFragment();
				itemSelected = true;
				break;
			case R.id.nav_experience:
				fragment = new ExperienceFragment();
				itemSelected = true;
				break;
			case R.id.nav_languages:
				fragment = new LangsFragment();
				itemSelected = true;
				break;
			case R.id.nav_techs:
				fragment = new TechsFragment();
				itemSelected = true;
				break;
		}

		if( itemSelected ){
			changeFragment( fragment );
			item.setChecked( true );
			getSupportActionBar().setTitle( item.getTitle() );
		}

		DrawerLayout drawer = findViewById( R.id.drawer_layout );
		drawer.closeDrawer( GravityCompat.START );
		return true;
	}

	public void changeFragment( Fragment fragment ){
		getSupportFragmentManager().beginTransaction().replace( R.id.content_main, fragment ).commit();
	}
}
