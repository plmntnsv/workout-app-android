package com.example.plmntnsv.workoutapplication.Registration;

import com.example.plmntnsv.workoutapplication.Base.BaseContracts;
import com.example.plmntnsv.workoutapplication.Repositoriy.FirebaseDataLogicRepository;
import com.example.plmntnsv.workoutapplication.Repositoriy.FirebaseAuthLogicRepository;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Plmn Tnsv on 08-Oct-17.
 */

public class RegistrationPresenter implements RegistrationContracts.Presenter, BaseContracts.OnLoginFinishedListener {
    private RegistrationContracts.View mView;
    private FirebaseAuthLogicRepository mAuthRepository;
    private FirebaseDataLogicRepository mDataRepository;

    @Override
    public void subscribe(RegistrationContracts.View view) {
        mView =  view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public void registerUser(String email, String password, String repeatPassword) {
        if (android.text.TextUtils.isEmpty(email)) {
            mView.setEmailEmptyError();
            return;
        }

        if (android.text.TextUtils.isEmpty(password)) {
            mView.setPasswordEmptyError();
            return;
        }

        if (password.length() < 6) {
            mView.setPasswordTooShortError();
            return;
        }

        if (!(password.equals(repeatPassword))) {
            mView.setPasswordMissMatchError();
            return;
        }

        mAuthRepository = new FirebaseAuthLogicRepository();

        mAuthRepository.registerUserToDb(email, password, this);
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

        mDataRepository = new FirebaseDataLogicRepository();
        mDataRepository.postUserToDb(user.getUid(), user.getEmail());
    }
}
