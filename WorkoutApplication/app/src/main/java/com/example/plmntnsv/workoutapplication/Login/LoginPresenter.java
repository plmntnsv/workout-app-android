package com.example.plmntnsv.workoutapplication.Login;

import com.example.plmntnsv.workoutapplication.base.BaseContracts;
import com.example.plmntnsv.workoutapplication.repositoriy.FirebaseAuthLogicRepository;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Plmn Tnsv on 09-Oct-17.
 */

public class LoginPresenter implements LoginContracts.Presenter, BaseContracts.OnLoginFinishedListener {
    private LoginContracts.View mView;
    @Override
    public void subscribe(LoginContracts.View view) {
        mView =  view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public void loginUser(String email, String password) {
        if (android.text.TextUtils.isEmpty(email)) {
            mView.setInvalidEmailError();
            return;
        }

        if (android.text.TextUtils.isEmpty(password)) {
            mView.setInvalidPasswordError();
            return;
        }

        FirebaseAuthLogicRepository repository = new FirebaseAuthLogicRepository();

        repository.loginUser(email, password, this);
    }

    @Override
    public void onUnecpectedError(String errMsg) {
        if (mView != null) {
            mView.setUnexpectedError(errMsg);
        }
    }

    @Override
    public void onSuccess(FirebaseUser user) {
        if (mView != null) {
            mView.navigateToHome();
        }
    }
}
