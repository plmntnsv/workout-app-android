package com.example.plmntnsv.workoutapplication.models.PopulateDB;

import com.example.plmntnsv.workoutapplication.models.Exercise.Category;
import com.example.plmntnsv.workoutapplication.models.Exercise.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Plmn Tnsv on 10-Oct-17.
 */

public class ShouldersExercises {
    private ArrayList<Exercise> mShoulders;
    private int mId = 0;

    public ShouldersExercises(){
        mShoulders = new ArrayList<Exercise>();
        populate();
    }

    public ArrayList<Exercise> getShoulders(){
        return this.mShoulders;
    }

    private void populate(){
        mShoulders.add(this.dumbbellArnoldPress());
        mShoulders.add(this.dumbbellFrontLateralRaise());
        mShoulders.add(this.dumbbellFrontRaise());
        mShoulders.add(this.dumbbellShoulderPress());
        mShoulders.add(this.pikePress());
        mShoulders.add(this.cableBarBehindNeckPress());
        mShoulders.add(this.dumbbellInclineLateralRaise());
        mShoulders.add(this.barbellShoulderPress());
        mShoulders.add(this.dumbbellLateralRaise());
        mShoulders.add(this.rearDeltInvertedRow());
    }

    private Exercise template(String name, String desc){
        int id = mId++;
        String eName = name;
        String eDescription = desc;
        Category category = Category.SHOULDERS;
        float weight = 0;
        int sets = 0;
        int repetitions = 0;
        Exercise exercise = new Exercise(id, eName, eDescription, category, weight, sets, repetitions);
        return exercise;
    }

    private Exercise dumbbellArnoldPress(){
        String name = "Dumbbell Arnold Press";
        String description = "Preparation: Stand with two dumbbells position in front of shoulders, palms facing body and elbows under wrists. Execution: Initiate movement by bringing elbows out to sides. Continue to raise elbows outward while pressing dumbbells overhead until arms are straight. Lower to front of shoulders in opposite pattern and repeat.";
        return template(name, description);
    }

    private Exercise dumbbellFrontRaise(){
        String name = "Dumbbell Front Raise";
        String description = "Preparation: Grasp dumbbells in both hands. Position dumbbells in front of upper legs with elbows straight or slightly bent. Execution: Raise dumbbells forward and upward until upper arms are above horizontal. Lower and repeat.";
        return template(name, description);
    }

    private Exercise dumbbellShoulderPress(){
        String name = "Dumbbell Shoulder Press";
        String description = "Preparation: Position dumbbells to each side of shoulders with elbows below wrists. Execution: Press dumbbells upward until arms are extended overhead. Lower to sides of shoulders and repeat.";
        return template(name, description);
    }

    private Exercise pikePress(){
        String name = "Pike Press";
        String description = "Preparation: Kneel on two benches positioned side by side slightly apart at end nearest head. Place hands on ends of benches. With forefeet on opposite ends of bench, raise rear end high up with arms, back, and knees straight. Adjust feet so they are somewhat close to hands while keeping back and legs straight. Execution: Lower head between ends of benches by bending arms. Push body back up to original position by extending arms. Repeat.";
        return template(name, description);
    }

    private Exercise cableBarBehindNeckPress(){
        String name = "Cable Bar Behind Neck Press";
        String description = "Preparation: Stand facing cable bar, mounted on each side to upper waist height narrow double pulley cables. Grasp cable bar with wide overhand grip upper chest height. Stand directly between both cable pulleys with one foot forward and other foot back. Push cable bar over head and position cable bar behind neck or rest on shoulders. Execution: Press cable bar upward until arms are extended overhead. Return behind neck and repeat.";
        return template(name, description);
    }

    private Exercise barbellShoulderPress(){
        String name = "Barbell Shoulder Press";
        String description = "";
        return template(name, description);
    }

    private Exercise dumbbellInclineLateralRaise(){
        String name = "Dumbbell Incline Lateral Raise";
        String description = "Preparation: Grasp dumbbell in one hand. Lie on 30° to 45° incline bench with opposite side of body on incline, arm over top of bench, lower leg positioned on front side of seat, and upper leg on back side of seat. Position dumbbell inside of lower leg, just in front of upper leg. Execution: Raise dumbbell from until upper arm is perpendicular to torso. Maintain slight fixed bend in elbow throughout exercise. Lower dumbbell to front of upper leg and repeat.";
        return template(name, description);
    }

    private Exercise dumbbellLateralRaise(){
        String name = "Dumbbell Lateral Raise";
        String description = "Preparation: Grasp dumbbells in front of thighs with elbows slightly bent. Bend over slightly with hips and knees bent slightly. Execution: Raise upper arms to sides until elbows are shoulder height. Maintain elbows' height above or equal to wrists. Lower and repeat.";
        return template(name, description);
    }

    private Exercise rearDeltInvertedRow(){
        String name = "Rear Delt Inverted Row";
        String description = "Preparation: Stand facing waist to lower chest height horizontal bar. Grasp bar with wide overhand grip. Turn elbows outward to sides. Walk forward under bar while pulling upper chest close to bar. With heels on floor, position body at angle under bar with legs, hips and spine straight. Position forearms perpendicular to body, orientated forward. Also, position upper arms perpendicular to body, orientated to each side. Execution: Lower body downward until arms are extended straight while keeping body straight and elbows high (upper arm perpendicular to torso). Pull body toward bar until upper arms are just beyond parallel to one another. Return and repeat.";
        return template(name, description);
    }

    private Exercise dumbbellFrontLateralRaise(){
        String name = "Dumbbell Front Lateral Raise";
        String description = "Preparation: Grasp dumbbell and position in front of thigh with arm straight. Turn pinkie finger side outward. Execution: Raise arms to side, slightly to front until shoulder height or slightly higher. Lower and repeat. Continue with opposite arm.";
        return template(name, description);
    }









}
