package com.example.plmntnsv.workoutapplication.repositoriy.base;

import com.example.plmntnsv.workoutapplication.Login.LoginContracts;
import com.example.plmntnsv.workoutapplication.Login.LoginFragment;
import com.example.plmntnsv.workoutapplication.Registration.RegistrationFragment;
import com.example.plmntnsv.workoutapplication.base.BaseContracts;
import com.example.plmntnsv.workoutapplication.models.Exercise.Exercise;
import com.example.plmntnsv.workoutapplication.models.Workout.Workout;
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
        ArrayList<ArrayList<Exercise>> getAllExercises(BaseContracts.OnSuccessfulDataTrasfer listener);
        ArrayList<Exercise> getAllChestExercisesFromDb(BaseContracts.OnSuccessfulDataTrasfer listener);
        ArrayList<Exercise> getAllArmsExercisesFromDb(BaseContracts.OnSuccessfulDataTrasfer listener);
        ArrayList<Exercise> getAllBackExercisesFromDb(BaseContracts.OnSuccessfulDataTrasfer listener);
        ArrayList<Exercise> getAllShouldersExercisesFromDb(BaseContracts.OnSuccessfulDataTrasfer listener);
        ArrayList<Exercise> getAllCardioExercisesFromDb(BaseContracts.OnSuccessfulDataTrasfer listener);
        ArrayList<Exercise> getAllCoreExercisesFromDb(BaseContracts.OnSuccessfulDataTrasfer listener);
        ArrayList<Exercise> getAllLegsExercisesFromDb(BaseContracts.OnSuccessfulDataTrasfer listener);

        void postUserToDb(String uid, String email);
        void postWorkoutToDb(String uid, Workout workout);
        void postExerciseToWorkout();
        ArrayList<Workout> getAllUserWorkouts(String uid, BaseContracts.OnSuccessfulDataTrasfer listener);
    }
}
