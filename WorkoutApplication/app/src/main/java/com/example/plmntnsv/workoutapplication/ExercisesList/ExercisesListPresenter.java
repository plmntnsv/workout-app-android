package com.example.plmntnsv.workoutapplication.ExercisesList;

import com.example.plmntnsv.workoutapplication.Base.BaseContracts;
import com.example.plmntnsv.workoutapplication.Models.Exercise.Category;
import com.example.plmntnsv.workoutapplication.Models.Exercise.Exercise;
import com.example.plmntnsv.workoutapplication.Repositoriy.FirebaseAuthLogicRepository;
import com.example.plmntnsv.workoutapplication.Repositoriy.FirebaseDataLogicRepository;

import java.util.ArrayList;

/**
 * Created by Plmn Tnsv on 11-Oct-17.
 */

public class ExercisesListPresenter implements ExercisesListContracts.Presenter, BaseContracts.OnSuccessfulExerciseDataTrasfer {
    private ExercisesListContracts.View mView;
    private FirebaseAuthLogicRepository mAuthRepository;
    private FirebaseDataLogicRepository mDataRepository;

    public ExercisesListPresenter(){
       mAuthRepository = new FirebaseAuthLogicRepository();
       mDataRepository = new FirebaseDataLogicRepository();
    }

    @Override
    public void subscribe(ExercisesListContracts.View view) {
        mView = view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public void onUnecpectedError(String errMsg) {
        mView.displayUnexpectedError(errMsg);
    }

    @Override
    public void onSuccess(ArrayList<Exercise> exercises) {
        mView.displayOnSuccess(exercises);
    }


    @Override
    public ArrayList<Exercise> getAllChestExercises() {
        return mDataRepository.getAllChestExercisesFromDb(this);
    }

    @Override
    public ArrayList<Exercise> getAllArmsExercises() {
        return mDataRepository.getAllArmsExercisesFromDb(this);
    }

    @Override
    public ArrayList<Exercise> getAllBackExercises() {
        return mDataRepository.getAllBackExercisesFromDb(this);
    }

    @Override
    public ArrayList<Exercise> getAllShouldersExercises() {
        return mDataRepository.getAllShouldersExercisesFromDb(this);
    }

    @Override
    public ArrayList<Exercise> getAllCardioExercises() {
        return mDataRepository.getAllCardioExercisesFromDb(this);
    }

    @Override
    public ArrayList<Exercise> getAllCoreExercises() {
        return mDataRepository.getAllCoreExercisesFromDb(this);
    }

    @Override
    public ArrayList<Exercise> getAllLegsExercises() {
        return mDataRepository.getAllLegsExercisesFromDb(this);
    }

    @Override
    public void getExercises(Category category) {
        switch (category){
            case CHEST:
                this.getAllChestExercises();
                break;
            case CARDIO:
                this.getAllCardioExercises();
                break;
            case CORE:
                this.getAllCoreExercises();
                break;
            case BACK:
                this.getAllBackExercises();
                break;
            case ARMS:
                this.getAllArmsExercises();
                break;
            case LEGS:
                this.getAllLegsExercises();
                break;
            case SHOULDERS:
                this.getAllShouldersExercises();
                break;
        }
    }
}
