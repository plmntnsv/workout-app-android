package com.example.plmntnsv.workoutapplication.Registration;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.plmntnsv.workoutapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment {


    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.fragment_registration, container, false);
        return root;
    }

    public static RegistrationFragment newInstance() {
        RegistrationFragment fragment = new RegistrationFragment();
        return fragment;
    }
}
