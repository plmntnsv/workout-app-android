package com.example.plmntnsv.workoutapplication.WorkoutCreate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.plmntnsv.workoutapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutCreateFragment extends Fragment implements WorkoutCreateContracts.View {
    private WorkoutCreateContracts.Presenter mPresenter;

    public WorkoutCreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workout_create, container, false);
        // Inflate the layout for this fragment
        return root;
    }

    public static WorkoutCreateFragment newInstance() {
        WorkoutCreateFragment fragment = new WorkoutCreateFragment();
        return fragment;
    }

    @Override
    public void onResume() {
        mPresenter.subscribe(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mPresenter.unsubscribe();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mPresenter = null;
        super.onDestroy();
    }

    @Override
    public void setPresenter(WorkoutCreateContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void displayChestExercises() {

    }

    @Override
    public void displayArmsExercises() {

    }

    @Override
    public void displayBackExercises() {

    }

    @Override
    public void displayLegsExercises() {

    }

    @Override
    public void displayShouldersExercises() {

    }

    @Override
    public void displayCardioExercises() {

    }

    @Override
    public void displayCoreExercises() {

    }

    @Override
    public void displayUnexpectedError(String errMsg) {

    }
}
