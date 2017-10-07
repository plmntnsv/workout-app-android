package com.example.plmntnsv.workoutapplication.Startup;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.plmntnsv.workoutapplication.ExercisesList.ExercisesListFragment;
import com.example.plmntnsv.workoutapplication.R;

public class StartUpActivity extends AppCompatActivity {

    private Fragment mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        mView = StartUpFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_content, mView)
                .commit();
    }
}
