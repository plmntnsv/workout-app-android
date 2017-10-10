package com.example.plmntnsv.workoutapplication.Home;

import com.example.plmntnsv.workoutapplication.base.BaseContracts;
import com.example.plmntnsv.workoutapplication.repositoriy.FirebaseLoginLogicRepository;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Plmn Tnsv on 10-Oct-17.
 */

public class HomePresenter implements HomeContracts.Presenter, BaseContracts.OnLogoutFinishedListener {
    private final FirebaseLoginLogicRepository mRepository;
    private HomeContracts.View mView;
    private FirebaseUser mUser;

    public HomePresenter(){
        mRepository = new FirebaseLoginLogicRepository();
    }

    @Override
    public void subscribe(HomeContracts.View view) {
        mView = view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public String getCurrentUser() {
        mUser = mRepository.getCurrentUser();
        return mUser.getEmail();
    }

    @Override
    public void logoutUser() {
        mRepository.logoutUser(this);
    }

    @Override
    public void onLogout() {
        mView.navigateToLogin();
    }
}
