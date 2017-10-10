package com.example.plmntnsv.workoutapplication.models.Workout;

import com.example.plmntnsv.workoutapplication.models.Exercise.Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Plmn Tnsv on 10-Oct-17.
 */

public class Workout {
    private String mName;
    private List<Exercise> mDay1;
    private List<Exercise> mDay2;
    private List<Exercise> mDay3;
    private List<Exercise> mDay4;
    private List<Exercise> mDay5;
    private List<Exercise> mDay6;
    private List<Exercise> mDay7;

    public Workout() { }

    public Workout(String name){
        mName = name;
        mDay1 = new ArrayList<>();
        mDay2 = new ArrayList<>();
        mDay3 = new ArrayList<>();
        mDay4 = new ArrayList<>();
        mDay5 = new ArrayList<>();
        mDay6 = new ArrayList<>();
        mDay7 = new ArrayList<>();
    }

    public List<Exercise> getmDay1() {
        return mDay1;
    }

    public List<Exercise> getmDay2() {
        return mDay2;
    }

    public List<Exercise> getmDay3() {
        return mDay3;
    }

    public List<Exercise> getmDay4() {
        return mDay4;
    }

    public List<Exercise> getmDay5() {
        return mDay5;
    }

    public List<Exercise> getmDay6() {
        return mDay6;
    }

    public List<Exercise> getmDay7() {
        return mDay7;
    }
}
