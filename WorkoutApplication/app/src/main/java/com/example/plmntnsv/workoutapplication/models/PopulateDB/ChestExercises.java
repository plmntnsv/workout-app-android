package com.example.plmntnsv.workoutapplication.Models.PopulateDB;

import com.example.plmntnsv.workoutapplication.Models.Exercise.Category;
import com.example.plmntnsv.workoutapplication.Models.Exercise.Exercise;

import java.util.ArrayList;

/**
 * Created by Plmn Tnsv on 10-Oct-17.
 */

public class ChestExercises {
    private ArrayList<Exercise> mChest;
    private int mId = 0;

    public ChestExercises(){
        mChest = new ArrayList<Exercise>();
        populate();
    }

    public ArrayList<Exercise> getChest(){
        return this.mChest;
    }

    private void populate(){
        mChest.add(benchPress());
        mChest.add(dumbellBenchPress());
        mChest.add(chestFly());
        mChest.add(standartPushUp());
        mChest.add(dolphinPushUp());
        mChest.add(dumbbellPullover());
        mChest.add(dumbbellDeclineBenchPress());
        mChest.add(weightedChestDip());
        mChest.add(cableChestPress());
        mChest.add(leverChestDip());
    }

    private Exercise template(String name, String desc){
        int id = mId++;
        String eName = name;
        String eDescription = desc;
        Category category = Category.CHEST;
        float weight = 0;
        int sets = 0;
        int repetitions = 0;
        Exercise exercise = new Exercise(id, eName, eDescription, category, weight, sets, repetitions);
        return exercise;
    }

    private Exercise benchPress(){
        String name = "Bench Press";
        String description = "The person performing the exercise lies on their back on a bench with a weight grasped in both hands. They push the weight upwards until their arms are extended, not allowing the elbows to lock. They then lower the weight to chest level. This is one repetition (rep). Powerlifting: Take position on a flat bench with body weight resting on buttocks and upper traps whilst driving feet into the floor. Movement requires the weight to be taken at full arms' length, lowered to upper torso, paused, and then lifted to starting position.";
        return template(name, description);
    }

    private Exercise dumbellBenchPress(){
        String name = "Dumbbell Bench Press";
        String description = "The person performing the exercise lies on their back on a bench with a weight grasped in both hands. They push the weight upwards until their arms are extended, not allowing the elbows to lock. They then lower the weight to chest level. This is one repetition (rep). Powerlifting: Take position on a flat bench with body weight resting on buttocks and upper traps whilst driving feet into the floor. Movement requires the weight to be taken at full arms' length, lowered to upper torso, paused, and then lifted to starting position.";
        return template(name, description);
    }

    private Exercise chestFly(){
        int id = mId++;
        String name = "Dumbbell Fly";
        String description = "Preparation: Grasp two dumbbells. Lie supine on bench. Support dumbbells above chest with arms fixed in slightly bent position. Internally rotate shoulders so elbows point out to sides. Execution: Lower dumbbells to sides until chest muscles are stretched with elbows fixed in slightly bent position. Bring dumbbells together in wide hugging motion until dumbbells are nearly together. Repeat.";
        return template(name, description);
    }

    private Exercise standartPushUp(){
        String name = "Standart Push-Up";
        String description = "With hands shoulder-width apart, keep the feet flexed at hip distance, and tighten the core. Bend the elbows until the chest reaches the ground, and then push back up (make sure to keep the elbows tucked close to the body).";
        return template(name, description);
    }

    private Exercise dolphinPushUp(){
        String name = "Dolphin Push-Up";
        String description = "Start out in dolphin pose (think: down-dog with elbows on the floor). Lean forward, lowering the shoulders until the head is over the hands. Pull up the arms and return to the starting position.";
        return template(name, description);
    }

    private Exercise dumbbellPullover(){
        String name = "Dumbbell Pullover";
        String description = "Lie on upper back perpendicular to bench. Flex hips slightly. Grasp one dumbbell from behind or from side with both hands under inner plate of dumbbell. Position dumbbell over chest with elbows slightly bent. Keeping elbows slightly bent throughout movement, lower dumbbell over and beyond head until upper arms are in-line with torso. Pull dumbbell up and over chest. Repeat.";
        return template(name, description);
    }
    private Exercise dumbbellDeclineBenchPress(){
        String name = "Dumbbell Decline Bench Press";
        String description = "Preparation: Sit down on decline bench with feet under leg brace and dumbbells resting on thigh. Lie back with dumbbells. Position dumbbells to sides of chest with bent arm under each dumbbell. Execution: Press dumbbells up with elbows to sides until arms are extended. Lower weight to sides of chest until slight stretch is felt in chest or shoulder. Repeat.";
        return template(name, description);
    }
    private Exercise weightedChestDip(){
        String name = "Weighted Chest Dip";
        String description = "Preparation: Place weight on dip belt around waist or place dumbbell between lower legs just above feet. Mount wide dip bar with oblique grip (bar diagonal under palm), arms straight with shoulders above hands. Keep hips and knees bent. Execution: Lower body by bending arms, allowing elbows to flare out to sides. When slight stretch is felt in chest or shoulders, push body up until arms are straight. Repeat.";
        return template(name, description);
    }
    private Exercise cableChestPress(){
        String name = "Cable Chest Press";
        String description = "Preparation: Sit on seat and grasp stirrups to each side. Position elbows out to sides, slightly lower than shoulder height. Position hands slightly narrower than elbow width in front of upper arms. Execution: Push stirrups out straight until arms are straight and parallel to one another. Return stirrups to original position, until slight stretch is felt in shoulders or chest. Repeat.";
        return template(name, description);
    }

    private Exercise leverChestDip(){
        String name = "Lever Chest Dip (plate loaded)";
        String description = "Preparation: Sit on seat and grasp handles with oblique grip. If possible, place handles in wide position. Lean forward slightly. Execution: Push lever down with elbows away from body. Return until chest is slightly stretched. Repeat.";
        return template(name, description);
    }
}
