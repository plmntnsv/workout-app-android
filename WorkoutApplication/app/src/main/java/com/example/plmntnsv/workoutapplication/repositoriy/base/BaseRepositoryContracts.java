package com.example.plmntnsv.workoutapplication.repositoriy.base;

import com.example.plmntnsv.workoutapplication.Login.LoginContracts;
import com.example.plmntnsv.workoutapplication.Login.LoginFragment;
import com.example.plmntnsv.workoutapplication.Registration.RegistrationFragment;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Plmn Tnsv on 09-Oct-17.
 */

public abstract class BaseRepositoryContracts {
    public interface FirebaseTools {
        void registerUserToDb(String email, String password, final BaseRepositoryContracts.OnLoginFinishedListener listener);

        void loginUser(final String username, final String password, final BaseRepositoryContracts.OnLoginFinishedListener listener);

        FirebaseAuth.AuthStateListener authListener(OnLoginFinishedListener listener);
    }

    public interface OnLoginFinishedListener {
        void onUnecpectedError(String errMsg);

        void onSuccess();
    }
}
