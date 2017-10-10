package com.example.plmntnsv.workoutapplication.Home;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.plmntnsv.workoutapplication.R;

public class HomeActivity extends AppCompatActivity {

    private HomeFragment mView;
    private DrawerFragment mDrawerView;
    private HomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mPresenter = new HomePresenter();
        mView = HomeFragment.newInstance();
        mDrawerView = DrawerFragment.newInstance();
        mDrawerView.setPresenter(mPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_drawer, mDrawerView)
                .replace(R.id.frame_content, mView)
                .commit();
    }
}
