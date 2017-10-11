package com.example.plmntnsv.workoutapplication.WorkoutCreate;

import com.example.plmntnsv.workoutapplication.base.BaseContracts;
import com.example.plmntnsv.workoutapplication.models.Exercise.Exercise;
import com.example.plmntnsv.workoutapplication.repositoriy.FirebaseDataLogicRepository;
import com.example.plmntnsv.workoutapplication.repositoriy.FirebaseAuthLogicRepository;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * Created by Plmn Tnsv on 11-Oct-17.
 */

public class WorkoutCreatePresenter implements WorkoutCreateContracts.Presenter, BaseContracts.OnSuccessfulDataTrasfer {
    private WorkoutCreateContracts.View mView;
    private FirebaseAuthLogicRepository mAuthRepository;
    private FirebaseDataLogicRepository mDataRepository;

    public WorkoutCreatePresenter(){
        mAuthRepository = new FirebaseAuthLogicRepository();
        mDataRepository = new FirebaseDataLogicRepository();
    }

    @Override
    public void subscribe(WorkoutCreateContracts.View view) {
        mView = view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public FirebaseUser getCurrentUser() {
        return mAuthRepository.getCurrentUser();
    }

    @Override
    public ArrayList<ArrayList<Exercise>> getAllExercises() {
        return mDataRepository.getAllExercises(this);
    }

    @Override
    public ArrayList<Exercise> getChestExercises() {
        return mDataRepository.getAllChestExercisesFromDb(this);
    }

    @Override
    public ArrayList<Exercise> getArmsExercises() {
        return mDataRepository.getAllArmsExercisesFromDb(this);
    }

    @Override
    public ArrayList<Exercise> getBackExercises() {
        return mDataRepository.getAllBackExercisesFromDb(this);
    }

    @Override
    public ArrayList<Exercise> getLegsExercises() {
        return mDataRepository.getAllLegsExercisesFromDb(this);
    }

    @Override
    public ArrayList<Exercise> getShouldersExercises() {
        return mDataRepository.getAllShouldersExercisesFromDb(this);
    }

    @Override
    public ArrayList<Exercise> getCardioExercises() {
        return mDataRepository.getAllCardioExercisesFromDb(this);
    }

    @Override
    public ArrayList<Exercise> getCoreExercises() {
        return mDataRepository.getAllCoreExercisesFromDb(this);
    }

    @Override
    public void onUnecpectedError(String errMsg) {
        if (mView != null) {
            mView.displayUnexpectedError(errMsg);
        }
    }

    @Override
    public void onSuccess() {
        if (mView != null) {

        }
    }
}
