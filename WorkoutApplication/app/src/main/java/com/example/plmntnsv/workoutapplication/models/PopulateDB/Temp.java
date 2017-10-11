package com.example.plmntnsv.workoutapplication.Models.PopulateDB;

import com.example.plmntnsv.workoutapplication.Models.Exercise.Exercise;

import java.util.ArrayList;

/**
 * Created by Plmn Tnsv on 10-Oct-17.
 */

public class Temp {
    private ArrayList<Exercise> mChest;
    private ArrayList<Exercise> mBack;
    private ArrayList<Exercise> mShoulders;
    private ArrayList<Exercise> mArms;
    private ArrayList<Exercise> mLegs;
    private ArrayList<Exercise> mCore;
    private ArrayList<Exercise> mCardio;
    private ArrayList<ArrayList<Exercise>> all;

    public Temp(){
        all = new ArrayList<>();

        ArmsExercises arms = new ArmsExercises();
        mArms = arms.getArms();
        all.add(mArms);

        BackExercises back = new BackExercises();
        mBack = back.getBack();
        all.add(mBack);

        ShouldersExercises shoulders = new ShouldersExercises();
        mShoulders = shoulders.getShoulders();
        all.add(mShoulders);

        ChestExercises chest = new ChestExercises();
        mChest = chest.getChest();
        all.add(mChest);

        LegsExercises legs = new LegsExercises();
        mLegs = legs.getLegs();
        all.add(mLegs);

        CoreExercises core = new CoreExercises();
        mCore = core.getCore();
        all.add(mCore);

        CardioExercises cardio = new CardioExercises();
        mCardio = cardio.getCardio();
        all.add(mCardio);
    }

    public ArrayList<ArrayList<Exercise>> getAll(){
        return all;
    }
}
