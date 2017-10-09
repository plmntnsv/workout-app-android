package com.example.plmntnsv.workoutapplication.Login;

import com.example.plmntnsv.workoutapplication.repositoriy.FirebaseRepository;
import com.example.plmntnsv.workoutapplication.repositoriy.base.BaseRepositoryContracts;

/**
 * Created by Plmn Tnsv on 09-Oct-17.
 */

public class LoginPresenter implements LoginContracts.Presenter, BaseRepositoryContracts.OnLoginFinishedListener {
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

        FirebaseRepository repository = new FirebaseRepository();

        repository.loginUser(email, password, this);
    }

    @Override
    public void onUnecpectedError(String errMsg) {
        if (mView != null) {
            mView.setUnexpectedError(errMsg);
        }
    }

    @Override
    public void onSuccess() {
        if (mView != null) {
            mView.navigateToHome();
        }
    }
}
