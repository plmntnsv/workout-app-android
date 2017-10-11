package com.example.plmntnsv.workoutapplication.Repositoriy.base;

import com.example.plmntnsv.workoutapplication.Base.BaseContracts;
import com.example.plmntnsv.workoutapplication.Models.Exercise.Exercise;
import com.example.plmntnsv.workoutapplication.Models.Workout.Workout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * Created by Plmn Tnsv on 09-Oct-17.
 */

public abstract class BaseRepositoryContracts {
    public interface FirebaseLoginTools {
        void registerUserToDb(String email, String password, final BaseContracts.OnLoginFinishedListener listener);

        void loginUser(final String username, final String password, final BaseContracts.OnLoginFinishedListener listener);

        void logoutUser(final BaseContracts.OnLogoutFinishedListener listener);

        FirebaseUser getCurrentUser();

        FirebaseAuth.AuthStateListener authListener(BaseContracts.OnLoginFinishedListener listener);
    }

    public interface FirebaseDataTools {
        ArrayList<ArrayList<Exercise>> getAllExercises(BaseContracts.OnSuccessfulExerciseDataTrasfer listener);
        ArrayList<Exercise> getAllChestExercisesFromDb(BaseContracts.OnSuccessfulExerciseDataTrasfer listener);
        ArrayList<Exercise> getAllArmsExercisesFromDb(BaseContracts.OnSuccessfulExerciseDataTrasfer listener);
        ArrayList<Exercise> getAllBackExercisesFromDb(BaseContracts.OnSuccessfulExerciseDataTrasfer listener);
        ArrayList<Exercise> getAllShouldersExercisesFromDb(BaseContracts.OnSuccessfulExerciseDataTrasfer listener);
        ArrayList<Exercise> getAllCardioExercisesFromDb(BaseContracts.OnSuccessfulExerciseDataTrasfer listener);
        ArrayList<Exercise> getAllCoreExercisesFromDb(BaseContracts.OnSuccessfulExerciseDataTrasfer listener);
        ArrayList<Exercise> getAllLegsExercisesFromDb(BaseContracts.OnSuccessfulExerciseDataTrasfer listener);

        void postUserToDb(String uid, String email);
        void postWorkoutToDb(String uid, Workout workout);
        void postExerciseToWorkout();

        ArrayList<Workout> getAllUserWorkouts(String uid, BaseContracts.OnSuccessfulWorkoutDataTrasfer listener);
    }
}
