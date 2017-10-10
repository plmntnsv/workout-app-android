package com.example.plmntnsv.workoutapplication.Tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.example.plmntnsv.workoutapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabsFragment extends Fragment {
    private static final int WORKOUTS_COUNT = 7;

    public TabsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tabs, container, false);

        int position = this.getArguments().getInt("position");

        ((TextView) root.findViewById(R.id.tv_text)).setText(String.format("Position %d", position));
        return root;
    }

    public static TabsFragment createFragment(int position) {
        TabsFragment fragment = new TabsFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }
}
