package com.example.plmntnsv.workoutapplication.models;

/**
 * Created by Plmn Tnsv on 07-Oct-17.
 */

public class Exercise {
    private String mName;

    public Exercise(String name){
        this.setmName(name);
    }

    public String getName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
