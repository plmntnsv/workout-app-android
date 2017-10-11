package com.example.plmntnsv.workoutapplication.Tabs;

import com.example.plmntnsv.workoutapplication.Base.BaseContracts;

/**
 * Created by Plmn Tnsv on 11-Oct-17.
 */

public class TabsContracts {
    public interface View extends BaseContracts.View<TabsContracts.Presenter>{
    }

    public interface Presenter extends BaseContracts.Presenter<TabsContracts.View>{
    }

    public interface CreateWorkoutsLogic {
        void displayChestExercises();
        void displayBackExercises();
        void displayShouldersExercises();
        void displayArmsExercises();
        void displayLegsExercises();
        void displayCoreExercises();
        void displayCardioExercises();
    }
}
