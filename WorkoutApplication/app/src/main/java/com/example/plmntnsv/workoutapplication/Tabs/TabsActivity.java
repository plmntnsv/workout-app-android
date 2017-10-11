package com.example.plmntnsv.workoutapplication.Tabs;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;
import com.example.plmntnsv.workoutapplication.R;
import com.example.plmntnsv.workoutapplication.Tabs.Fragments.TabsFragmentType;
import com.example.plmntnsv.workoutapplication.Tabs.Fragments.TabsPinnedWorkoutFragment;
import com.example.plmntnsv.workoutapplication.Tabs.Fragments.TabsSavedWorkoutsFragment;
import com.example.plmntnsv.workoutapplication.Tabs.Fragments.TabsWorkoutCreateFragment;

import java.io.Serializable;

public class TabsActivity extends AppCompatActivity {
    private Fragment mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        Intent intent = getIntent();
        Serializable type = intent.getSerializableExtra("type");
        mView = setTabsView((TabsFragmentType) type);
        // Initialize the ViewPager and set an adapter
        ViewPager pager = findViewById(R.id.tabs_pager);

        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager(),(TabsFragmentType) type);

        pager.setAdapter(adapter);

        // Bind the tabs to the ViewPager
        PagerSlidingTabStrip tabs = findViewById(R.id.tabs);
        tabs.setViewPager(pager);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public Fragment setTabsView(TabsFragmentType type) {
        Fragment fragment;
        switch (type) {
            case CREATE:
                fragment = TabsWorkoutCreateFragment.newInstance();
                return fragment;
            case PINNED:
                fragment = TabsPinnedWorkoutFragment.newInstance();
                return fragment;
            case SAVED:
                fragment = TabsSavedWorkoutsFragment.newInstance();
                return fragment;
            default:
                return null;
        }
    }
}
