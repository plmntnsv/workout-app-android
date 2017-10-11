package com.example.plmntnsv.workoutapplication.Models.PopulateDB;

import com.example.plmntnsv.workoutapplication.Models.Exercise.Category;
import com.example.plmntnsv.workoutapplication.Models.Exercise.Exercise;

import java.util.ArrayList;

/**
 * Created by Plmn Tnsv on 10-Oct-17.
 */

public class ArmsExercises {
    private ArrayList<Exercise> mArms;
    private int mId = 0;

    public ArmsExercises(){
        mArms = new ArrayList<Exercise>();
        populate();
    }

    public ArrayList<Exercise> getArms(){
        return this.mArms;
    }

    private void populate(){
        mArms.add(dumbbellHammerCurl());
        mArms.add(barbellWristCurl());
        mArms.add(benchDip());
        mArms.add(closeGripPushup());
        mArms.add(skullCrusher());
        mArms.add(barbellCloseGripBenchPress());
        mArms.add(barbellLyingTricepsExtension());
        mArms.add(dumbbellKickback());
        mArms.add(dumbbellCurl());
        mArms.add(barbellCurl());
        mArms.add(chinUp());
        mArms.add(barbellPreacherCurl());
        mArms.add(dumbbellConcentrationCurl());
    }

    private Exercise template(String name, String desc){
        int id = mId++;
        String eName = name;
        String eDescription = desc;
        Category category = Category.ARMS;
        float weight = 0;
        int sets = 0;
        int repetitions = 0;
        Exercise exercise = new Exercise(id, eName, eDescription, category, weight, sets, repetitions);
        return exercise;
    }

    private Exercise dumbbellHammerCurl(){
        String name = "Dumbbell Hammer Curl";
        String description = "Preparation: Position two dumbbells to sides, palms facing in, arms straight. Execution: With elbows to sides, raise one dumbbell until forearm is vertical and thumb faces shoulder. Lower to original position and repeat with alternative arm.";
        return template(name, description);
    }

    private Exercise barbellWristCurl(){
        String name = "Barbell Wrist Curl";
        String description = "Preparation: Sit and grasp bar with narrow to shoulder width underhand grip. Rest forearms on thighs with wrists just beyond knees. Execution: Allow barbell to roll out of palms down to fingers. Raise barbell back up by gripping and pointing knuckles up as high as possible. Lower and repeat.";
        return template(name, description);
    }

    private Exercise benchDip(){
        String name = "Bench Dip";
        String description = "Preparation: Sit on inside of one of two benches placed parallel, slightly less than leg's length away. Place hands on edge of bench, straighten arms, slide rear end off of bench, and position heels on adjacent bench with legs straight. Execution: Lower body by bending arms until slight stretch is felt in chest or shoulder, or rear end touches floor. Raise body and repeat.";
        return template(name, description);
    }

    private Exercise closeGripPushup(){
        String name = "Close Grip Push-up";
        String description = "Preparation: Lie prone on floor with hands under shoulders or slightly narrower. Position body up off floor with extended arms and body straight. Execution: Keeping body straight, lower body to floor by bending arms. Push body up until arms are extended. Repeat.";
        return template(name, description);
    }

    private Exercise skullCrusher(){
        String name = "Barbell Lying Triceps Extension \"Skull Crusher\"";
        String description = "Preparation: Lie on bench with narrow overhand grip on barbell. Position barbell over shoulders with arms extended. Execution: Lower bar to forehead by bending elbows. Extend arms and repeat.";
        return template(name, description);
    }

    private Exercise barbellCloseGripBenchPress(){
        String name = "Barbell Close Grip Bench Press";
        String description = "Preparation: Lie on bench and grasp barbell from rack with shoulder width grip. Execution: Lower weight to chest with elbows close to body. Push barbell back up until arms are straight. Repeat.";
        return template(name, description);
    }

    private Exercise barbellLyingTricepsExtension(){
        String name = "Barbell Lying Triceps Extension";
        String description = "Preparation: Lie on bench with narrow overhand grip on barbell. Position barbell over forehead with arms extended. Execution: Lower bar by bending elbows. As bar nears head, move elbows slightly back just enough to allow bar to clear around curvature of head. Extend arms. As bar clears head, reposition elbows to their former position until arms are fully extended. Repeat.";
        return template(name, description);
    }

    private Exercise dumbbellKickback(){
        String name = "Dumbbell Kickback";
        String description = "Preparation: Kneel over bench with arm supporting body. Grasp dumbbell. Position upper arm parallel to floor. Execution: Extend arm until it is straight. Return and repeat. Continue with opposite arm.";
        return template(name, description);
    }

    private Exercise dumbbellCurl(){
        String name = "Dumbbell Curl";
        String description = "Preparation: Position two dumbbells to sides, palms facing in, arms straight. Execution: With elbows to sides, raise one dumbbell and rotate forearm until forearm is vertical and palm faces shoulder. Lower to original position and repeat with opposite arm. Continue to alternate between sides.";
        return template(name, description);
    }

    private Exercise barbellCurl(){
        String name = "Barbell Curl";
        String description = "Preparation: Grasp bar with shoulder width underhand grip. Execution: With elbows to side, raise bar until forearms are vertical. Lower until arms are fully extended. Repeat.";
        return template(name, description);
    }

    private Exercise chinUp(){
        String name = "Underhand Chin-up";
        String description = "Preparation: Step up and grasp bar with underhand shoulder width grip. Execution: Pull body up until elbows are to sides. Lower body until arms and shoulders are fully extended. Repeat.";
        return template(name, description);
    }

    private Exercise barbellPreacherCurl(){
        String name = "Barbell Preacher Curl";
        String description = "Preparation: Sit on preacher bench placing back of arms on pad. Grasp curl bar with shoulder width underhand grip. Execution: Raise bar until forearms are vertical. Lower barbell until arms are fully extended. Repeat.";
        return template(name, description);
    }

    private Exercise dumbbellConcentrationCurl(){
        String name = "Dumbbell Concentration Curl";
        String description = "Preparation: Sit on bench. Grasp dumbbell between feet. Place back of upper arm to inner thigh. Lean into leg to raise elbow slightly. Execution: Raise dumbbell to front of shoulder. Lower dumbbell until arm is fully extended. Repeat. Continue with opposite arm.";
        return template(name, description);
    }
}
