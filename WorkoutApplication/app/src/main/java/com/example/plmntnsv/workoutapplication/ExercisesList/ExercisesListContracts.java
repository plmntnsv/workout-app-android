package com.example.plmntnsv.workoutapplication.ExercisesList;

import com.example.plmntnsv.workoutapplication.Base.BaseContracts;
import com.example.plmntnsv.workoutapplication.Models.Exercise.Category;
import com.example.plmntnsv.workoutapplication.Models.Exercise.Exercise;

import java.util.ArrayList;

/**
 * Created by Plmn Tnsv on 11-Oct-17.
 */

public class ExercisesListContracts {
    public interface View extends BaseContracts.View<ExercisesListContracts.Presenter>{
        void displayUnexpectedError(String errMsg);
        void displayOnSuccess(ArrayList<Exercise> exercises);
        void setCategory(Category category);
        void getExercises(Category category);
    }

    public interface Presenter extends BaseContracts.Presenter<ExercisesListContracts.View>{
        ArrayList<Exercise> getAllChestExercises();
        ArrayList<Exercise> getAllArmsExercises();
        ArrayList<Exercise> getAllBackExercises();
        ArrayList<Exercise> getAllShouldersExercises();
        ArrayList<Exercise> getAllCardioExercises();
        ArrayList<Exercise> getAllCoreExercises();
        ArrayList<Exercise> getAllLegsExercises();

        void getExercises(Category category);
    }
}
