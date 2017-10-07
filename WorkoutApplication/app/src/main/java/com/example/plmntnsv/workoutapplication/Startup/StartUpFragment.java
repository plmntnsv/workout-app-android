package com.example.plmntnsv.workoutapplication.Startup;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.plmntnsv.workoutapplication.Home.HomeActivity;
import com.example.plmntnsv.workoutapplication.R;
import com.example.plmntnsv.workoutapplication.Registration.RegistrationActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartUpFragment extends Fragment implements View.OnClickListener {

    public StartUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_start_up, container, false);

        Button logInBtn = root.findViewById(R.id.button_login);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(root.getContext(), HomeActivity.class);
                root.getContext().startActivity(intent);
            }
        });

        TextView tvRegister = root.findViewById(R.id.tv_register);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(root.getContext(), RegistrationActivity.class);
                root.getContext().startActivity(intent);
            }
        });

        return root;
    }

    public static Fragment newInstance() {
        StartUpFragment fragment = new StartUpFragment();
        return fragment;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), HomeActivity.class);

        getContext().startActivity(intent);
    }
}
