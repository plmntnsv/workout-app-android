package com.example.plmntnsv.workoutapplication.Base;

import com.example.plmntnsv.workoutapplication.Models.Exercise.Exercise;
import com.example.plmntnsv.workoutapplication.Models.Workout.Workout;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * Created by Plmn Tnsv on 07-Oct-17.
 */

public abstract class BaseContracts {
    public interface View<T>{
        void setPresenter(T presenter);
    }

    public interface Presenter<T>{
        void subscribe(T view);
        void unsubscribe();
    }

    public interface OnLoginFinishedListener {
        void onUnecpectedError(String errMsg);

        void onSuccess(FirebaseUser user);
    }

    public interface  OnLogoutFinishedListener {
        void onLogout();
    }

    public interface OnSuccessfulExerciseDataTrasfer {
        void onUnecpectedError(String errMsg);

        void onSuccess(ArrayList<Exercise> exercises);
    }

    public interface OnSuccessfulWorkoutDataTrasfer {
        void onUnecpectedError(String errMsg);

        void onSuccess(ArrayList<Workout> exercises);
    }
}
