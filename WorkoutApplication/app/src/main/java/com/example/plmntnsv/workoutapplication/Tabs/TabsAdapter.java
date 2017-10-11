package com.example.plmntnsv.workoutapplication.Tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.plmntnsv.workoutapplication.R;
import com.example.plmntnsv.workoutapplication.Tabs.Fragments.TabsFragmentType;
import com.example.plmntnsv.workoutapplication.Tabs.Fragments.TabsPinnedWorkoutFragment;
import com.example.plmntnsv.workoutapplication.Tabs.Fragments.TabsSavedWorkoutsFragment;
import com.example.plmntnsv.workoutapplication.Tabs.Fragments.TabsWorkoutCreateFragment;

/**
 * Created by Plmn Tnsv on 11-Oct-17.
 */

public class TabsAdapter extends FragmentStatePagerAdapter {
    private static final int WORKOUTS_COUNT = 7;
    private final TabsFragmentType mType;

    public TabsAdapter(FragmentManager manager, TabsFragmentType type) {
        super(manager);
        mType = type;
    }

    @Override
    public Fragment getItem(int position) {
        return getItemFrom(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            case 3:
                return "Thursday";
            case 4:
                return "Friday";
            case 5:
                return "Saturday";
            case 6:
                return "Sunday";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return WORKOUTS_COUNT;
    }

    public Fragment getItemFrom(int position) {
        switch (mType) {
            case CREATE:
                return TabsWorkoutCreateFragment.createFragment(position);
            case PINNED:
                return TabsPinnedWorkoutFragment.createFragment(position);
            case SAVED:
                return TabsSavedWorkoutsFragment.createFragment(position);
            default:
                return null;
        }
    }
}
