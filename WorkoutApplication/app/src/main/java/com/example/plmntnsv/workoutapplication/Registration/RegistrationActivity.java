package com.example.plmntnsv.workoutapplication.Registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.plmntnsv.workoutapplication.R;

public class RegistrationActivity extends AppCompatActivity {

    private RegistrationFragment mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mView = RegistrationFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_content, mView)
                .commit();
    }
}
