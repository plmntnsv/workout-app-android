package com.example.plmntnsv.workoutapplication.repositoriy;

import android.support.constraint.solver.widgets.Snapshot;
import android.widget.Toast;

import com.example.plmntnsv.workoutapplication.models.Exercise.Exercise;
import com.example.plmntnsv.workoutapplication.models.Workout.Workout;
import com.example.plmntnsv.workoutapplication.repositoriy.base.BaseRepositoryContracts;
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
    private static DatabaseReference mDatabaseRef;
    private final FirebaseDatabase mDataBase;

    public FirebaseDataLogicRepository(){
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        mDataBase = FirebaseDatabase.getInstance();
    }

    @Override
    public ArrayList<Exercise> getAllExercises() {
        final ArrayList<Exercise> allExercises = new ArrayList<>();

        return null;
    }

    @Override
    public ArrayList<Exercise> getAllChestExercises() {
        final ArrayList<Exercise> chestEx = new ArrayList<>();
        mDataBase.getReference(EXERCISE_PATH+"/chest").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Object snp = snapshot.getValue(false);
                    Exercise exercise = snapshot.getValue(Exercise.class);
                    chestEx.add(exercise);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
//                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        return chestEx;
    }

    @Override
    public ArrayList<Exercise> getAllArmsExercises() {
        return null;
    }

    @Override
    public ArrayList<Exercise> getAllBackExercises() {
        return null;
    }

    @Override
    public ArrayList<Exercise> getAllShouldersExercises() {
        return null;
    }

    @Override
    public ArrayList<Exercise> getAllCardioExercises() {
        return null;
    }

    @Override
    public ArrayList<Exercise> getAllCoreExercises() {
        return null;
    }

    @Override
    public ArrayList<Exercise> getAllLegsExercises() {
        return null;
    }

    @Override
    public void postUserToDb(String uid, String email) {
        mDatabaseRef.child(USER_PATH).child(uid).child(USER_EMAIL).setValue(email);
    }

    @Override
    public void postWorkoutToDb(String uid, Workout workout) {
        mDatabaseRef.child(USER_PATH).child(uid).child(USER_WORKOUT_PATH).setValue(workout);
    }

    @Override
    public void postExerciseToWorkout() {

    }

    @Override
    public ArrayList<Workout> getAllUserWorkouts() {
        return null;
    }

    public void populateDbWorkouts(List<ArrayList<Exercise>> exercises){
        for(ArrayList<Exercise> alEx : exercises){
            for (Exercise ex : alEx){
                mDatabaseRef.child(EXERCISE_PATH).child(ex.getCategory().toString().toLowerCase()).child(ex.getName()).setValue(ex);
            }
        };
    }
}
