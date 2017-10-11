package com.example.plmntnsv.workoutapplication.Models.Exercise;

/**
 * Created by Plmn Tnsv on 07-Oct-17.
 */

public class Exercise {
    private int mId;
    private String mName;
    private String mDescription;
    private Category mCategory;
    private String mImage;
    private float mWeight;
    private int mSets;
    private int mRepetitionsPerSet;

    public Exercise() { }

    public Exercise(int id, String name, String description, Category category, float weight, int sets, int repetitionsPerSet){
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setCategory(category);
        this.setWeight(weight);
        this.setSets(sets);
        this.setRepetitionsPerSet(repetitionsPerSet);
    }

    public Exercise(String name){
        this.setName(name);
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getmId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category mCategory) {
        this.mCategory = mCategory;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String mImage) {
        this.mImage = mImage;
    }

    public int getSets() {
        return mSets;
    }

    public void setSets(int mSets) {
        this.mSets = mSets;
    }

    public int getRepetitionsPerSet() {
        return mRepetitionsPerSet;
    }

    public void setRepetitionsPerSet(int mRepetitionsPerSet) {
        this.mRepetitionsPerSet = mRepetitionsPerSet;
    }

    public float getWeight() {
        return mWeight;
    }

    public void setWeight(float mWeight) {
        this.mWeight = mWeight;
    }
}