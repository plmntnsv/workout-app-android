package com.example.plmntnsv.workoutapplication.Registration;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Plmn Tnsv on 08-Oct-17.
 */

public class RegistrationPresenter implements RegistrationContracts.Presenter, RegistrationContracts.OnLoginFinishedListener {

    private RegistrationContracts.View mView;
    private FirebaseAuth mAuth;
    private RegistrationFragment mContext;
    private RegistrationPresenterImpl regImpl;

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

        RegistrationPresenterImpl.registerUserToDb(email, password, this, mContext);
    }

    @Override
    public void onUnecpectedError(String errMSg) {
        if (mContext != null) {
            mContext.setUnexpectedError(errMSg);
        }
    }

    @Override
    public void onSuccess() {
        if (mContext != null) {
            mContext.navigateToHome();
        }
    }

    @Override
    public FirebaseAuth.AuthStateListener authListener(RegistrationContracts.OnLoginFinishedListener listener) {
        return null;
    }
}
