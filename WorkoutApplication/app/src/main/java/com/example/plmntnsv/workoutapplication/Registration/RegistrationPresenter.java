package com.example.plmntnsv.workoutapplication.Registration;

import com.example.plmntnsv.workoutapplication.base.BaseContracts;
import com.example.plmntnsv.workoutapplication.repositoriy.FirebaseDataLogicRepository;
import com.example.plmntnsv.workoutapplication.repositoriy.FirebaseLoginLogicRepository;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Plmn Tnsv on 08-Oct-17.
 */

public class RegistrationPresenter implements RegistrationContracts.Presenter, BaseContracts.OnLoginFinishedListener {
    private RegistrationContracts.View mView;
    private RegistrationFragment mContext;

    public RegistrationPresenter(RegistrationFragment context){
        mContext = context;
    }

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
            mContext.setEmailEmptyError();
            return;
        }

        if (android.text.TextUtils.isEmpty(password)) {
            mContext.setPasswordEmptyError();
            return;
        }

        if (password.length() < 6) {
            mContext.setPasswordTooShortError();
            return;
        }

        if (!(password.equals(repeatPassword))) {
            mContext.setPasswordMissMatchError();
            return;
        }

        FirebaseLoginLogicRepository repository = new FirebaseLoginLogicRepository();

        repository.registerUserToDb(email, password, this);
    }

    @Override
    public void onUnecpectedError(String errMsg) {
        if (mContext != null) {
            mContext.setUnexpectedError(errMsg);
        }
    }

    @Override
    public void onSuccess(FirebaseUser user) {
        if (mContext != null) {
            mContext.navigateToHome();
        }

        FirebaseDataLogicRepository repository = new FirebaseDataLogicRepository();
        repository.postUserToDb(user.getUid(), user.getEmail());
    }
}
