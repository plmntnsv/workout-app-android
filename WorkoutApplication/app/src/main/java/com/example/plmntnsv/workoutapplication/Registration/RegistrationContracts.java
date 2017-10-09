package com.example.plmntnsv.workoutapplication.Registration;

import com.example.plmntnsv.workoutapplication.ExercisesList.ExercisesListContracts;
import com.example.plmntnsv.workoutapplication.base.BaseContracts;
import com.example.plmntnsv.workoutapplication.models.Exercise;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Plmn Tnsv on 08-Oct-17.
 */

public abstract class RegistrationContracts {
    public interface View extends BaseContracts.View<Presenter>{
        void registerUser();
        void navigateToHome();
        void setUnexpectedError(String errMsg);
        void setEmailEmptyError();
        void setPasswordEmptyError();
        void setPasswordTooShortError();
        void setPasswordMissMatchError();
    }

    public interface Presenter extends BaseContracts.Presenter<View>{
        void registerUser(String email, String password, String repeatedPassword);
    }
}
