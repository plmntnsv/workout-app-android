package com.example.plmntnsv.workoutapplication.Tabs.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.plmntnsv.workoutapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabsSavedWorkoutsFragment extends Fragment {

    public TabsSavedWorkoutsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tabs_saved, container, false);

        int position = this.getArguments().getInt("position");

        ((TextView) root.findViewById(R.id.tv_text)).setText(String.format("Position %d", position));
        return root;
    }

    public static TabsSavedWorkoutsFragment createFragment(int position) {
        TabsSavedWorkoutsFragment fragment = new TabsSavedWorkoutsFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    public static TabsSavedWorkoutsFragment newInstance() {
        TabsSavedWorkoutsFragment fragment = new TabsSavedWorkoutsFragment();
        return fragment;
    }
}
