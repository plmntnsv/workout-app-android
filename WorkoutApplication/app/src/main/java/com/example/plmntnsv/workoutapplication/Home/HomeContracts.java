package com.example.plmntnsv.workoutapplication.Home;

import com.example.plmntnsv.workoutapplication.base.BaseContracts;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Plmn Tnsv on 10-Oct-17.
 */

public class HomeContracts {
    public interface View extends BaseContracts.View<HomeContracts.Presenter>{
        String getCurrentUserEmail();
        void navigateToLogin();
        void logoutCurrentUser();
    }

    public interface Presenter extends BaseContracts.Presenter<HomeContracts.View>{
        String getCurrentUser();
        void logoutUser();
    }
}
