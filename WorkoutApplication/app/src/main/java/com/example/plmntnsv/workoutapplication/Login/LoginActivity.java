package com.example.plmntnsv.workoutapplication.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.plmntnsv.workoutapplication.R;

public class LoginActivity extends AppCompatActivity {

    private LoginFragment mView;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPresenter = new LoginPresenter();
        mView = LoginFragment.newInstance();
        mView.setPresenter(mPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_content, mView)
                .commit();
    }
}
