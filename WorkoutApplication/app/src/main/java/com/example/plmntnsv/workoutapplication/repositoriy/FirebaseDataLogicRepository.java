package com.example.plmntnsv.workoutapplication.Repositoriy;

import com.example.plmntnsv.workoutapplication.Base.BaseContracts;
import com.example.plmntnsv.workoutapplication.Models.Exercise.Exercise;
import com.example.plmntnsv.workoutapplication.Models.Workout.Workout;
import com.example.plmntnsv.workoutapplication.Repositoriy.base.BaseRepositoryContracts;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Plmn Tnsv on 10-Oct-17.
 */

public class FirebaseDataLogicRepository implements BaseRepositoryContracts.FirebaseDataTools {
    private final static String USER_PATH = "users";
    private final static String USER_EMAIL = "email";
    private final static String USER_WORKOUT_PATH = "workouts";
    private final static String EXERCISE_PATH = "exercises";
    private final static String EXERCISE_CHEST_PATH = EXERCISE_PATH + "/chest";
    private final static String EXERCISE_ARMS_PATH = EXERCISE_PATH + "/arms";
    private final static String EXERCISE_BACK_PATH = EXERCISE_PATH + "/back";
    private final static String EXERCISE_SHOULDERS_PATH = EXERCISE_PATH + "/shoulders";
    private final static String EXERCISE_CARDIO_PATH = EXERCISE_PATH + "/cardio";
    private final static String EXERCISE_CORE_PATH = EXERCISE_PATH + "/core";
    private final static String EXERCISE_LEGS_PATH = EXERCISE_PATH + "/legs";

    private static DatabaseReference mDatabaseRef;
    private static FirebaseDatabase mDataBase;

    public FirebaseDataLogicRepository() {
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        mDataBase = FirebaseDatabase.getInstance();
    }

    @Override
    public ArrayList<ArrayList<Exercise>> getAllExercises(BaseContracts.OnSuccessfulExerciseDataTrasfer listener) {
        final ArrayList<ArrayList<Exercise>> allExercises = new ArrayList<>();

        allExercises.add(getAllArmsExercisesFromDb(listener));
        allExercises.add(getAllBackExercisesFromDb(listener));
        allExercises.add(getAllCardioExercisesFromDb(listener));
        allExercises.add(getAllChestExercisesFromDb(listener));
        allExercises.add(getAllCoreExercisesFromDb(listener));
        allExercises.add(getAllLegsExercisesFromDb(listener));
        allExercises.add(getAllShouldersExercisesFromDb(listener));

        return allExercises;
    }

    @Override
    public ArrayList<Exercise> getAllChestExercisesFromDb(BaseContracts.OnSuccessfulExerciseDataTrasfer listener) {
        return getExercisesFromPath(EXERCISE_CHEST_PATH, listener);
    }

    @Override
    public ArrayList<Exercise> getAllArmsExercisesFromDb(BaseContracts.OnSuccessfulExerciseDataTrasfer listener) {
        return getExercisesFromPath(EXERCISE_ARMS_PATH, listener);
    }

    @Override
    public ArrayList<Exercise> getAllBackExercisesFromDb(BaseContracts.OnSuccessfulExerciseDataTrasfer listener) {
        return getExercisesFromPath(EXERCISE_BACK_PATH, listener);
    }

    @Override
    public ArrayList<Exercise> getAllShouldersExercisesFromDb(BaseContracts.OnSuccessfulExerciseDataTrasfer listener) {
        return getExercisesFromPath(EXERCISE_SHOULDERS_PATH, listener);
    }

    @Override
    public ArrayList<Exercise> getAllCardioExercisesFromDb(BaseContracts.OnSuccessfulExerciseDataTrasfer listener) {
        return getExercisesFromPath(EXERCISE_CARDIO_PATH, listener);
    }

    @Override
    public ArrayList<Exercise> getAllCoreExercisesFromDb(BaseContracts.OnSuccessfulExerciseDataTrasfer listener) {
        return getExercisesFromPath(EXERCISE_CORE_PATH, listener);
    }

    @Override
    public ArrayList<Exercise> getAllLegsExercisesFromDb(BaseContracts.OnSuccessfulExerciseDataTrasfer listener) {
        return getExercisesFromPath(EXERCISE_LEGS_PATH, listener);
    }

    private ArrayList<Exercise> getExercisesFromPath(String path, final BaseContracts.OnSuccessfulExerciseDataTrasfer listener) {
        final ArrayList<Exercise> exercises = new ArrayList<>();
        mDataBase.getReference(path).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Exercise exercise = snapshot.getValue(Exercise.class);
                    exercises.add(exercise);
                }
                listener.onSuccess(exercises);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listener.onUnecpectedError(databaseError.getMessage());
            }
        });

        return exercises;
    }

    @Override
    public void postUserToDb(String uid, String email) {
        mDatabaseRef.child(USER_PATH).child(uid).child(USER_EMAIL).setValue(email);
    }

    @Override
    public void postWorkoutToDb(String uid, Workout workout) {
        mDatabaseRef.child(USER_PATH).child(uid).child(USER_WORKOUT_PATH).setValue(workout);
    }

    //TODO:delete if not used
    @Override
    public void postExerciseToWorkout() {

    }

    @Override
    public ArrayList<Workout> getAllUserWorkouts(String uid, final BaseContracts.OnSuccessfulWorkoutDataTrasfer listener) {
        String path = USER_PATH + "/" + uid + USER_WORKOUT_PATH;
        final ArrayList<Workout> workouts = new ArrayList<>();

        mDataBase.getReference(path).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Workout workout = snapshot.getValue(Workout.class);
                    workouts.add(workout);
                }
                listener.onSuccess(workouts);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listener.onUnecpectedError(databaseError.getMessage());
            }
        });

        return workouts;
    }

    //TODO:delete me later
    public void populateDbWorkouts(List<ArrayList<Exercise>> exercises) {
        for (ArrayList<Exercise> alEx : exercises) {
            for (Exercise ex : alEx) {
                mDatabaseRef.child(EXERCISE_PATH).child(ex.getCategory().toString().toLowerCase()).child(ex.getName()).setValue(ex);
            }
        }
        ;
    }
}
