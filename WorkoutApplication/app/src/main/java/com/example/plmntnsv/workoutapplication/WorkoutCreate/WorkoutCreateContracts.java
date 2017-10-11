package com.example.plmntnsv.workoutapplication.WorkoutCreate;

import com.example.plmntnsv.workoutapplication.base.BaseContracts;
import com.example.plmntnsv.workoutapplication.models.Exercise.Exercise;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * Created by Plmn Tnsv on 10-Oct-17.
 */

public class WorkoutCreateContracts {
    public interface View extends BaseContracts.View<WorkoutCreateContracts.Presenter>{
        void displayChestExercises();
        void displayArmsExercises();
        void displayBackExercises();
        void displayLegsExercises();
        void displayShouldersExercises();
        void displayCardioExercises();
        void displayCoreExercises();
        void displayUnexpectedError(String errMsg);
    }

    public interface Presenter extends BaseContracts.Presenter<WorkoutCreateContracts.View>{
        FirebaseUser getCurrentUser();
        ArrayList<ArrayList<Exercise>> getAllExercises();
        ArrayList<Exercise> getChestExercises();
        ArrayList<Exercise> getArmsExercises();
        ArrayList<Exercise> getBackExercises();
        ArrayList<Exercise> getLegsExercises();
        ArrayList<Exercise> getShouldersExercises();
        ArrayList<Exercise> getCardioExercises();
        ArrayList<Exercise> getCoreExercises();
    }
}
