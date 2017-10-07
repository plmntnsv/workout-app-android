package com.example.plmntnsv.workoutapplication.ExercisesList;

import com.example.plmntnsv.workoutapplication.base.BaseContracts;
import com.example.plmntnsv.workoutapplication.models.Exercise;

/**
 * Created by Plmn Tnsv on 07-Oct-17.
 */

public abstract class ExercisesListContracts {
    public interface View extends BaseContracts.View<Presenter>{
        void setExercises(Exercise[] exercises);
    }

    public interface Presenter extends BaseContracts.Presenter<View>{

    }
}
