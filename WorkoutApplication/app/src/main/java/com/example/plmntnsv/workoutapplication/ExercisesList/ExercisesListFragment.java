package com.example.plmntnsv.workoutapplication.ExercisesList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.plmntnsv.workoutapplication.Models.Exercise.Category;
import com.example.plmntnsv.workoutapplication.Models.Exercise.Exercise;
import com.example.plmntnsv.workoutapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExercisesListFragment extends Fragment implements ExercisesListContracts.View {

    private ExercisesListContracts.Presenter mPresenter;
    private ExercisesListAdapter mAdapter;
    private Category mCategory;
    private View mRoot;

    public ExercisesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_exercises_list, container, false);

        this.getExercises(mCategory);

        return mRoot;
    }

    public static ExercisesListFragment newInstance() {
        ExercisesListFragment fragment = new ExercisesListFragment();
        return fragment;
    }

    @Override
    public void setPresenter(ExercisesListContracts.Presenter presenter) {
        mPresenter = presenter;
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
    public void displayUnexpectedError(String errMsg) {
        Toast.makeText(getContext(), errMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayOnSuccess(ArrayList<Exercise> exercises) {
        mAdapter = new ExercisesListAdapter(mRoot, exercises);
    }

    @Override
    public void getExercises(Category category){
        mPresenter.getExercises(category);
    }

    @Override
    public void setCategory(Category category) {
        mCategory = category;
    }
}
