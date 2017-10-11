package com.example.plmntnsv.workoutapplication.Models.PopulateDB;

import com.example.plmntnsv.workoutapplication.Models.Exercise.Category;
import com.example.plmntnsv.workoutapplication.Models.Exercise.Exercise;

import java.util.ArrayList;

/**
 * Created by Plmn Tnsv on 10-Oct-17.
 */

public class CardioExercises {
    private ArrayList<Exercise> mCardio;
    private int mId = 0;

    public CardioExercises(){
        mCardio = new ArrayList<Exercise>();
        populate();
    }

    public ArrayList<Exercise> getCardio(){
        return this.mCardio;
    }

    private void populate(){
        mCardio.add(biking());
        mCardio.add(running());
        mCardio.add(walking());
        mCardio.add(burpee());
        mCardio.add(jumpingJack());
        mCardio.add(mountainClimber());
        mCardio.add(BurpeeAdvanced());
        mCardio.add(bearCrawl());
        mCardio.add(backwardRun());
        mCardio.add(jumpRopeAlternatingLegHop());
        mCardio.add(JumpRopeBasicHop());
    }

    private Exercise template(String name, String desc){
        int id = mId++;
        String eName = name;
        String eDescription = desc;
        Category category = Category.CARDIO;
        float weight = 0;
        int sets = 0;
        int repetitions = 0;
        Exercise exercise = new Exercise(id, eName, eDescription, category, weight, sets, repetitions);
        return exercise;
    }

    private Exercise biking(){
        String name = "Cycling";
        String description = "Because the bike carries your own weight and the pedal motion is low impact, you have a workout that doesn’t beat up your body. This means that you can ride with both high volume and high frequency to burn massive amounts of flab. As an added bonus, this sort of intensity is also very effective towards building all of the muscles in your lower body. side from the time you put in, the more muscle you work the more calories you stand to burn. Riding up hills works you in a way no cardio machine at the gym can no matter how high you crank that resistance. A big reason for this is because a hill is not adjustable. ";
        return template(name, description);
    }

    private Exercise running(){
        String name = "Running";
        String description = "Leaning forward places a runner's center of mass on the front part of the foot, which avoids landing on the heel and facilitates the use of the spring mechanism of the foot. It also makes it easier for the runner to avoid landing the foot in front of the center of mass and the resultant braking effect. While upright posture is essential, a runner should maintain a relaxed frame and use his/her core to keep posture upright and stable. This helps prevent injury as long as the body is neither rigid nor tense. The most common running mistakes are tilting the chin up and scrunching shoulders.";
        return template(name, description);
    }

    private Exercise walking(){
        String name = "Walking";
        String description = "Preparation: Step onto deck of tread climber and grasp rails. Attach safety tether. Select \"quick start\" or enter program. Execution: Walk, keeping pace with machine.";
        return template(name, description);
    }

    private Exercise burpee(){
        String name = "Burpee";
        String description = "Preparation: Stand upright with arms to sides. Execution: Bend over and squat down. Place hands on floor, slightly wider than shoulder width. While holding upper body in place, kick legs back. Land on forefeet with body in straight, plank position. Keeping upper body in place, pull legs forward under body returning feet in original position. Rise up to original standing posture.";
        return template(name, description);
    }

    private Exercise jumpingJack(){
        String name = "Jumping Jack";
        String description = "Preparation: Stand with feet together, knees slightly bent, and arms to sides. Execution: Jump while raising arms and separating legs to sides. Land on forefoot with legs apart and arms overhead. Jump again while lower arms and returning legs to midline. Land on forefoot with arms and legs in original position and repeat.";
        return template(name, description);
    }

    private Exercise mountainClimber(){
        String name = "Mountain Climber";
        String description = "Preparation: Place hands on floor, slightly wider than shoulder width. On forefeet, position one leg forward bent under body and extend other leg back. Execution: While holding upper body in place, alternate leg positions by pushing hips up while immediately extending forward leg back and pulling rear leg forward under body, landing on both forefeet simultaneously.";
        return template(name, description);
    }

    private Exercise BurpeeAdvanced(){
        String name = "Burpee (advanced)";
        String description = "Preparation: Stand upright with arms to sides. Execution: Bend over and squat down. Place hands on floor, slightly wider than shoulder width. While holding upper body in place, kick legs back. Land on forefeet with body in straight, plank position. Perform pushup by lowering body to floor and back up. Keeping upper body in place, pull legs forward under body returning feet in original position. Jump up and land to original standing posture or repeat.";
        return template(name, description);
    }

    private Exercise bearCrawl(){
        String name = "Bear Crawl";
        String description = "Preparation: Kneel on hands and knees facing crawling path. Raise knees off of floor, but keep hips low. Execution: Crawl forward while keeping hips low.";
        return template(name, description);
    }

    private Exercise backwardRun(){
        String name = "Backward Run";
        String description = "Preparation: Stand facing away from running area with foot planted back. Slightly bend and knees and arms. Execution: Run backwards through running area while glancing over shoulder. Keep upright and land on balls of feet.";
        return template(name, description);
    }

    private Exercise jumpRopeAlternatingLegHop(){
        String name = "Jump Rope: Alternating Leg Hop";
        String description = "Preparation: Grasp jump rope handles on each side. Initiate side swing mount or start with rope behind body and swing rope from behind over head. Execution: Swing rope in front of body, down to floor. Hop on one leg as rope travels under foot and repeat with same foot. Alternate successive hops between opposite foot. Repeat.";
        return template(name, description);
    }

    private Exercise JumpRopeBasicHop(){
        String name = "Jump Rope: Basic Hop";
        String description = "Preparation: Grasp jump rope handles on each side. Initiate side swing mount or start with rope behind body and swing rope from behind over head. Body weight should be balanced on the balls of the feet, with knees slightly bent. Execution: Swing rope in front of body, down to floor. Hop as rope travels under feet, and repeat.";
        return template(name, description);
    }
}
