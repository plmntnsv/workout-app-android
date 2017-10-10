package com.example.plmntnsv.workoutapplication.base;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Plmn Tnsv on 07-Oct-17.
 */

public abstract class BaseContracts {
    public interface View<T>{
        void setPresenter(T presenter);
    }

    public interface Presenter<T>{
        void subscribe(T view);
        void unsubscribe();
    }

    public interface OnLoginFinishedListener {
        void onUnecpectedError(String errMsg);

        void onSuccess(FirebaseUser user);
    }

    public interface  OnLogoutFinishedListener {
        void onLogout();
    }
}
