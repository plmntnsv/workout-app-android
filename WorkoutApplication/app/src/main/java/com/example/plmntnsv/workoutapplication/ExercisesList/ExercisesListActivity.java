package com.example.plmntnsv.workoutapplication.ExercisesList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.plmntnsv.workoutapplication.Models.Exercise.Category;
import com.example.plmntnsv.workoutapplication.R;

import java.io.Serializable;

public class ExercisesListActivity extends AppCompatActivity {

    private ExercisesListPresenter mPresenter;
    private ExercisesListFragment mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_list);

        Intent intent = getIntent();
        Serializable category = intent.getSerializableExtra("type");

        mPresenter = new ExercisesListPresenter();
        mView = ExercisesListFragment.newInstance();
        mView.setPresenter(mPresenter);
        mView.setCategory((Category) category);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_content, mView)
                .commit();
    }
}
