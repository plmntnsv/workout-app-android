package com.example.plmntnsv.workoutapplication.ExercisesList;


import com.example.plmntnsv.workoutapplication.models.Exercise.Exercise;

/**
 * Created by Plmn Tnsv on 07-Oct-17.
 */

public class ExercisesListPresenter implements ExercisesListContracts.Presenter {
    private final Exercise[] mExercises;
    private ExercisesListContracts.View mView;

    public ExercisesListPresenter(){
        mExercises = new Exercise[]{
                new Exercise("Push ups"),
                new Exercise("Pull ups"),
                new Exercise("Dumbbell press")
        };
    }

    @Override
    public void subscribe(ExercisesListContracts.View view) {
        mView = view;
        //mView.setExercises(mExercises);
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }
}
