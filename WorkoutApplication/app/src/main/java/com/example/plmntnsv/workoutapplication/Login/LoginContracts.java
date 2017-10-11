package com.example.plmntnsv.workoutapplication.Login;

import com.example.plmntnsv.workoutapplication.Base.BaseContracts;

/**
 * Created by Plmn Tnsv on 09-Oct-17.
 */

public abstract class LoginContracts {
    public interface View extends BaseContracts.View<LoginContracts.Presenter>{
        void loginUser();
        void navigateToHome();
        void setUnexpectedError(String errMsg);
        void setInvalidEmailError();
        void setInvalidPasswordError();
    }

    public interface Presenter extends BaseContracts.Presenter<LoginContracts.View>{
        void loginUser(String email, String password);
    }
}
