package com.example.plmntnsv.workoutapplication.Tabs.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.plmntnsv.workoutapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabsPinnedWorkoutFragment extends Fragment {


    public TabsPinnedWorkoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tabs_pinned, container, false);
        return root;
    }

    public static TabsPinnedWorkoutFragment newInstance() {
        TabsPinnedWorkoutFragment fragment = new TabsPinnedWorkoutFragment();
        return fragment;
    }

    public static Fragment createFragment(int position) {

        return null;
    }
}
