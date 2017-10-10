package com.example.plmntnsv.workoutapplication.models.PopulateDB;

import com.example.plmntnsv.workoutapplication.models.Exercise.Category;
import com.example.plmntnsv.workoutapplication.models.Exercise.Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Plmn Tnsv on 10-Oct-17.
 */

public class CoreExercises {
    private ArrayList<Exercise> mCore;
    private int mId = 0;

    public CoreExercises(){
        mCore = new ArrayList<Exercise>();
        populate();
    }

    public ArrayList<Exercise> getCore(){
        return this.mCore;
    }

    private void populate(){
        mCore.add(crunch());
        mCore.add(JackKnifeSitup());
        mCore.add(dumbbellPushSitup());
        mCore.add(vUp());
        mCore.add(hangingLegHipRaise());
        mCore.add(inclineLegHipRaise());
        mCore.add(crunchUp());
        mCore.add(hangingStraightLegHipRaise());
        mCore.add(ballCrunch());
        mCore.add(frontPlank());
    }

    private Exercise template(String name, String desc){
        int id = mId++;
        String eName = name;
        String eDescription = desc;
        Category category = Category.CORE;
        float weight = 0;
        int sets = 0;
        int repetitions = 0;
        Exercise exercise = new Exercise(id, eName, eDescription, category, weight, sets, repetitions);
        return exercise;
    }

    private Exercise crunch(){
        String name = "Crunch";
        String description = "Preparation: Lie supine on mat with lower legs on bench. Place hands behind neck or head. Execution: Flex waist to raise upper torso from mat. Keep low back on mat and raise torso up as high as possible. Return until back of shoulders contact mat. Repeat.";
        return template(name, description);
    }

    private Exercise JackKnifeSitup(){
        String name = "Jack-knife Sit-up";
        String description = "Preparation: Sit on floor or mat. Lie supine with hands to sides. Execution: Simultaneously raise knees and torso until hips and knees are flexed. Return to starting position with waist, hips and knees extended. Repeat";
        return template(name, description);
    }

    private Exercise dumbbellPushSitup(){
        String name = "Dumbbell Push Sit-up";
        String description = "Preparation: Position feet under foot pad and lie supine on flat or incline bench. Position dumbbells straight over shoulders. Execution: Raise torso from bench as high as possible by bending waist and hips. Keep weight positioned above shoulders. Achieve near upright posture (hip flexibility, incline, and initial hip position permitting). Return to original lying posture with back of shoulders, contacting padded incline board. Repeat.";
        return template(name, description);
    }

    private Exercise vUp(){
        String name = "V-up";
        String description = "Preparation: Sit on floor or mat. Lie supine with hands on floor over head. Execution: Simultaneously raise straight legs and torso. Reach toward raised feet. Return to starting position. Repeat.";
        return template(name, description);
    }

    private Exercise hangingLegHipRaise(){
        String name = "Hanging Leg-Hip Raise";
        String description = "Preparation: Stand below ab straps hanging from high bar. Place upper arms in straps and grasp straps above. Execution: Raise legs by flexing hips and knees until hips are fully flexed. Continue to raise knees toward shoulders by flexing waist. Return until waist, hips, and knees are extended downward. Repeat.";
        return template(name, description);
    }

    private Exercise inclineLegHipRaise(){
        String name = "Incline Leg-Hip Raise";
        String description = "Preparation: Lie supine on incline board with torso elevated. Grasp feet hooks or sides of board by head for support. Execution: Raise legs by flexing hips and knees until hips are fully flexed. Continue to raise knees toward shoulders by flexing waist, raising hips from board. Return until waist, hips and knees are extended. Repeat.";
        return template(name, description);
    }

    private Exercise crunchUp(){
        String name = "Crunch Up";
        String description = "Preparation: Lie supine on mat or floor with bent leg and arms pointed up. Execution: Flex waist to raise upper torso from floor. Return until back of shoulders contact padded incline board. Repeat.";
        return template(name, description);
    }

    private Exercise hangingStraightLegHipRaise(){
        String name = "Hanging Straight Leg-Hip Raise";
        String description = "Preparation: Grasp and hang from high bar. Execution: Raise legs by flexing hips until fully flexed. Continue to raise feet toward bar by flexing waist. Return until waist and hips are extended downward. Repeat.";
        return template(name, description);
    }

    private Exercise ballCrunch(){
        String name = "Ball Crunch (on stability ball)";
        String description = "Preparation: Sit on exercise ball. Walk forward on ball and lie back on ball with shoulders and head hanging off and knees and hips bent. Gently hyperextend back on contour of ball. Place hands behind neck or beside head. Execution: Flex waist to raise upper torso. Return to original position. Repeat.";
        return template(name, description);
    }

    private Exercise frontPlank(){
        String name = "Front Plank";
        String description = "Preparation: Lie prone on mat. Place forearms on mat, elbows under shoulders. Place legs together with forefeet on floor. Execution: Raise body upward by straightening body in straight line. Hold position.";
        return template(name, description);
    }









}
