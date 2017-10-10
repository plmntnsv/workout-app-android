package com.example.plmntnsv.workoutapplication.Tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;
import com.example.plmntnsv.workoutapplication.R;

public class TabsActivity extends AppCompatActivity {
    private static final int WORKOUTS_COUNT = 7;
    //private TabsFragment mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        // Initialize the ViewPager and set an adapter
        ViewPager pager = findViewById(R.id.tabs_pager);
        pager.setAdapter(new TabsNavigationAdapter(getSupportFragmentManager()));

        // Bind the tabs to the ViewPager
        PagerSlidingTabStrip tabs = findViewById(R.id.tabs);
        tabs.setViewPager(pager);

  }

    public class TabsNavigationAdapter extends FragmentStatePagerAdapter {

        public TabsNavigationAdapter(FragmentManager manager){
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return TabsFragment.createFragment(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.monday);
                case 1:
                    return getResources().getString(R.string.tuesday);
                case 2:
                    return getResources().getString(R.string.wednesday);
                case 3:
                    return getResources().getString(R.string.thursday);
                case 4:
                    return getResources().getString(R.string.friday);
                case 5:
                    return getResources().getString(R.string.saturday);
                case 6:
                    return getResources().getString(R.string.sunday);
                default: return "Extra day";
            }
        }

        @Override
        public int getCount() {
            return WORKOUTS_COUNT;
        }
    }

}
