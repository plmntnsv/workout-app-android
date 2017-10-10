package com.example.plmntnsv.workoutapplication.models.PopulateDB;

import com.example.plmntnsv.workoutapplication.models.Exercise.Category;
import com.example.plmntnsv.workoutapplication.models.Exercise.Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Plmn Tnsv on 10-Oct-17.
 */

public class BackExercises {
    private ArrayList<Exercise> mBack;
    private int mId = 0;

    public BackExercises(){
        mBack = new ArrayList<Exercise>();
        populate();
    }

    public ArrayList<Exercise> getBack(){
        return this.mBack;
    }

    private void populate(){
        mBack.add(contralateralLimbRaises());
        mBack.add(donkeyKick());
        mBack.add(reverseFly());
        mBack.add(barbellBentoverRow());
        mBack.add(camberedBarLyingRow());
        mBack.add(cableInclineRow());
        mBack.add(dumbbellLyingRow());
        mBack.add(dumbbellBentoverRow());
        mBack.add(pullup());
        mBack.add(barbellShrug());
        mBack.add(invertedRow());
        mBack.add(leverSeatedRow());
    }

    private Exercise template(String name, String desc){
        int id = mId++;
        String eName = name;
        String eDescription = desc;
        Category category = Category.BACK;
        float weight = 0;
        int sets = 0;
        int repetitions = 0;
        Exercise exercise = new Exercise(id, eName, eDescription, category, weight, sets, repetitions);
        return exercise;
    }

    private Exercise contralateralLimbRaises(){
        String name = "Contralateral Limb Raises";
        String description = "Lie on your stomach with the arms outstretched and palms facing one another. Slowly lift one arm a few inches off the floor, keeping it straight without rotating the shoulders and keeping the head and torso still. Hold the position, then lower the arm back down, moving to the other arm.";
        return template(name, description);
    }
    private Exercise donkeyKick(){
        String name = "Donkey Kick";
        String description = "Start in a push-up position, with the legs together. Tighten the core and kick both legs into the air with knees bent, reaching the feet back toward the glutes. Just try to land gently when reversing back to the starting position.";
        return template(name, description);
    }
    private Exercise reverseFly(){
        String name = "Reverse Fly";
        String description = "Stand up straight, with one foot in front of the other and the front knee slightly bent. With palms facing each other and the abs engaged, bend forward slightly from the waist and extend arms out to the side, squeezing the shoulder blades. Repeat.";
        return template(name, description);
    }
    private Exercise barbellBentoverRow(){
        String name = "Barbell Bent-over Row";
        String description = "Preparation: Bend knees slightly and bend over bar with back straight. Grasp bar with wide overhand grip. Execution: Pull bar to upper waist. Return until arms are extended and shoulders are stretched downward. Repeat.";
        return template(name, description);
    }
    private Exercise camberedBarLyingRow(){
        String name = "Cambered Bar Lying Row";
        String description = "Preparation: Lie chest down on elevated bench. Grasp cambered barbell below with overhand grip. Execution: Pull bar to upper waist or lower chest. Return until arms are extended and shoulders are stretched downward. Repeat.";
        return template(name, description);
    }

    private Exercise cableInclineRow(){
        String name = "Cable Incline Row";
        String description = "Preparation: Sit on incline and place feet on lower bar, or foot platform. Slide hips down by bending knees. Bend over and grasp cable attachment. Slide hips back, positioning knees with slight bend. Execution: Pull cable attachment to waist while straightening back upright. Pull shoulders back and push chest forward while arching back. Return until arms are extended, shoulders are stretched forward, and lower back is flexed forward. Repeat.";
        return template(name, description);
    }
    private Exercise dumbbellLyingRow(){
        String name = "Dumbbell Lying Row";
        String description = "Preparation: Lie chest down on elevated bench. Grasp dumbbells below. Execution: Pull dumbbells to sides until upper arm is just beyond horizontal or height of back. Return until arms are extended and shoulders are stretched downward. Repeat.";
        return template(name, description);
    }

    private Exercise dumbbellBentoverRow(){
        String name = "Dumbbell Bent-over Row";
        String description = "Preparation: Kneel over side of bench by placing knee and hand of supporting arm on bench. Position foot of opposite leg slightly back to side. Grasp dumbbell from floor. Execution: Pull dumbbell to up to side until it makes contact with ribs or until upper arm is just beyond horizontal. Return until arm is extended and shoulder is stretched downward. Repeat and continue with opposite arm.";
        return template(name, description);
    }

    private Exercise pullup(){
        String name = "Pull-up";
        String description = "Preparation: Step up and grasp bar with overhand wide grip. Execution: Pull body up until chin is above bar. Lower body until arms and shoulders are fully extended. Repeat.";
        return template(name, description);
    }

    private Exercise barbellShrug(){
        String name = "Barbell Shrug";
        String description = "Preparation: Stand holding barbell with overhand or mixed grip; shoulder width or slightly wider. Execution: Elevate shoulders as high as possible. Lower and repeat.";
        return template(name, description);
    }

    private Exercise invertedRow(){
        String name = "Inverted Row";
        String description = "Preparation: Lay on back under fixed horizontal bar. Grasp bar with wide overhand grip. Execution: Keeping body straight, pull body up to bar. Return until arms are extended and shoulders are stretched forward. Repeat.";
        return template(name, description);
    }

    private Exercise leverSeatedRow(){
        String name = "Lever Seated Row";
        String description = "Preparation: Sit on seat and position chest against pad. Push foot lever if available. Grasp narrower parallel grip handles. Execution: Pull lever back until elbows are behind back and shoulders are pulled back. Return until arms are extended and shoulders are stretched forward. Repeat.";
        return template(name, description);
    }
}
