package com.example.vf996;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity {

	private ViewPager viewPager;
	private ActionBar actionBar;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		Fragment fragment0 = new CategoryFragment();
		Fragment fragment1 = new PaymentFragment();
		Fragment fragment2 = new PaymentFragment();
		Fragment fragment3 = new PaymentFragment();
		Fragment[] fragmentArray = new Fragment[] { fragment0, fragment1, fragment2,
				fragment3 };
		LFFragmentPagerAdapter adapter = new LFFragmentPagerAdapter(
				getSupportFragmentManager(), fragmentArray);
        
		viewPager.setAdapter(adapter);
		viewPager.setOffscreenPageLimit(3);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				System.out.println("arg0:" + arg0);
				actionBar.setSelectedNavigationItem(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		Tab tab0 = actionBar.newTab().setText(R.string.categories)
				.setTabListener(new ActionTabListener(fragment0));
		
		Tab tab1 = actionBar.newTab().setText(R.string.payment)
				//.setIcon(android.R.drawable.ic_menu_agenda)
				.setTabListener(new ActionTabListener(fragment1));

		Tab tab2 = actionBar.newTab().setText(R.string.vouchers)
				//.setIcon(android.R.drawable.ic_menu_agenda)
				.setTabListener(new ActionTabListener(fragment2));

		Tab tab3 = actionBar.newTab().setText(R.string.transport)
				//.setIcon(android.R.drawable.ic_menu_agenda)
				.setTabListener(new ActionTabListener(fragment3));

		actionBar.addTab(tab0);
		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
		actionBar.addTab(tab3);

	}

	class ActionTabListener implements ActionBar.TabListener {

		private Fragment fragment;
		public ActionTabListener(Fragment fragment) {
			this.fragment = fragment;
		}

		@Override
		public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
			// TODO Auto-generated method stub
			// ft.add(android.R.id.content, fragment, null);
			mType = tab.getPosition();
			System.out.println("tab.getPosition():" + tab.getPosition());
			viewPager.setCurrentItem(tab.getPosition());
			invalidateOptionsMenu();
		}

		@Override
		public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private int mType;

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.clear();
		MenuInflater inflater = this.getMenuInflater();
		switch (mType) {
		case 0:
			inflater.inflate(R.menu.main, menu);
			break;

		case 1:
			inflater.inflate(R.menu.main, menu);
			break;

		case 2:
			inflater.inflate(R.menu.main, menu);
			break;
		}
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.action_search:
			Toast.makeText(this, "first button", Toast.LENGTH_SHORT).show();
			break;
		case R.id.action_settings:
			Toast.makeText(this, "second button", Toast.LENGTH_SHORT).show();
			break;

		}

		return super.onOptionsItemSelected(item);
	}

}
