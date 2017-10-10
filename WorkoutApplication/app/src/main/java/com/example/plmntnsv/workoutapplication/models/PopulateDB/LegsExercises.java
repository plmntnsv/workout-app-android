package com.example.plmntnsv.workoutapplication.models.PopulateDB;

import com.example.plmntnsv.workoutapplication.models.Exercise.Category;
import com.example.plmntnsv.workoutapplication.models.Exercise.Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Plmn Tnsv on 10-Oct-17.
 */

public class LegsExercises {
    private ArrayList<Exercise> mLegs;
    private int mId = 0;

    public LegsExercises() {
        mLegs = new ArrayList<Exercise>();
        populate();
    }

    public ArrayList<Exercise> getLegs(){
        return this.mLegs;
    }

    private void populate() {
        mLegs.add(dumbbellStandingCalfRaise());
        mLegs.add(lungingStraightLegCalfStretch());
        mLegs.add(sled45CalfPress());
        mLegs.add(barbellDeadlift());
        mLegs.add(barbellSumoDeadlift());
        mLegs.add(dumbbellLunge());
        mLegs.add(dumbbellStepup());
        mLegs.add(singleLegHipBridge());
        mLegs.add(barbellSquat());
        mLegs.add(dumbbellSingleLegSplitSquat());
    }

    private Exercise template(String name, String desc) {
        int id = mId++;
        String eName = name;
        String eDescription = desc;
        Category category = Category.LEGS;
        float weight = 0;
        int sets = 0;
        int repetitions = 0;
        Exercise exercise = new Exercise(id, eName, eDescription, category, weight, sets, repetitions);
        return exercise;
    }

    private Exercise dumbbellStandingCalfRaise() {
        String name = "Dumbbell Standing Calf Raise";
        String description = "Preparation: Grasp dumbbell in one hand to side. Position toes and balls of feet on calf block with arches and heels extending off. Place hand on support for balance. Execution: Raise heels by extending ankles as high as possible. Lower heels by bending ankles until calves are stretched. Repeat.";
        return template(name, description);
    }

    private Exercise lungingStraightLegCalfStretch() {
        String name = "Lunging Straight Leg Calf Stretch";
        String description = "Preparation: Stand with one leg far forward and other leg extended back with knees straight. Both feet are positioned directly forward. Execution: Lower body forward by bending forward knee only. Hold stretch. Repeat with opposite leg.";
        return template(name, description);
    }

    private Exercise sled45CalfPress() {
        String name = "Sled 45 Degrees Calf Press";
        String description = "Preparation: Sit on seat with back on padded support. Place feet on platform. Grasp handles to sides and extend hips and knees. Place toes and balls of feet on lower portion of platform with heels and arches extending off. Execution: Push sled by extending ankles as far as possible. Return by bending ankles until calves are stretched. Repeat.";
        return template(name, description);
    }

    private Exercise barbellDeadlift() {
        String name = "Barbell Deadlift";
        String description = "Preparation: With feet flat beneath bar squat down and grasp bar with shoulder width or slightly wider overhand or mixed grip. Execution: Lift bar by extending hips and knees to full extension. Pull shoulders back at top of lift if rounded. Return weights to floor by bending hips back while allowing knees to bend forward, keeping back straight and knees pointed same direction as feet. Repeat.";
        return template(name, description);
    }

    private Exercise barbellSumoDeadlift() {
        String name = "Barbell Sumo Deadlift";
        String description = "Preparation: Position feet under bar with very wide stance. Squat down and grasp bar between legs with shoulder width mixed grip. Face forward while positioning shoulders upward with arms straight, chest high, hips low, and back straight. Execution: Pull bar up by driving feet outward, while pulling chest up. Extend knees when bar passes knees. At top of lift, when torso is upright, drive shoulders back and chest up. Return weight to floor by bending hips back and knees pointed outward, while keeping chest high and back straight. Repeat.";
        return template(name, description);
    }

    private Exercise dumbbellLunge() {
        String name = "Dumbbell Lunge";
        String description = "Preparation: Stand with dumbbells grasped to sides. Execution: Lunge forward with first leg. Land on heel then forefoot. Lower body by flexing knee and hip of front leg until knee of rear leg is almost in contact with floor. Return to original standing position by forcibly extending hip and knee of forward leg. Repeat by alternating lunge with opposite leg.";
        return template(name, description);
    }

    private Exercise dumbbellStepup() {
        String name = "Dumbbell Step-up";
        String description = "Preparation: Stand with dumbbells grasped to sides facing side of bench. Execution: Place foot of first leg on bench. Stand on bench by extending hip and knee of first leg and place foot of second leg on bench. Step down with second leg by flexing hip and knee of first leg. Return to original standing position by placing foot of first leg to floor. Repeat first step with opposite leg, alternating first steps between legs.";
        return template(name, description);
    }

    private Exercise singleLegHipBridge() {
        String name = "Single Leg Hip Bridge";
        String description = "Preparation: Lie on floor or mat. Place one leg straight and bend the other leg with foot flat on floor or mat. Place arms down on mat to each side of hips. Execution: Raise body by extending hip of bent leg, keeping extended leg and hip straight. Return to original position by lowering body with extended leg and hip straight. Repeat and continue with opposite sides.";
        return template(name, description);
    }

    private Exercise barbellSquat() {
        String name = "Barbell Squat (power lift)";
        String description = "Preparation: From rack with barbell at upper chest height, position bar low on back of shoulders. Grasp barbell to sides. Dismount bar from rack and stand with wide stance. Execution: Squat down by bending hips back while allowing knees to bend forward slightly, keeping back straight and knees pointed same direction as feet. Descend until thighs are just past parallel to floor. Extend hips and knees until legs are straight. Return and repeat.";
        return template(name, description);
    }

    private Exercise dumbbellSingleLegSplitSquat() {
        String name = "Dumbbell Single Leg Split Squat";
        String description = "Preparation: Stand with dumbbells grasped to sides facing away from bench. Extend leg back and place top of foot on bench. Execution: Squat down by flexing knee and hip of front leg until knee of rear leg is almost in contact with floor. Return to original standing position by extending hip and knee of forward leg. Repeat. Continue with opposite leg.";
        return template(name, description);
    }


}
