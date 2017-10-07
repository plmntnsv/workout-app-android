package com.example.plmntnsv.workoutapplication.ExercisesList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.plmntnsv.workoutapplication.R;

public class ExercisesListActivity extends AppCompatActivity {

    private ExercisesListFragment mView;
    private ExercisesListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_list);

        mPresenter = new ExercisesListPresenter();

        mView = ExercisesListFragment.newInstance();
        mView.setPresenter(mPresenter);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_content, mView)
                .commit();
    }
}
