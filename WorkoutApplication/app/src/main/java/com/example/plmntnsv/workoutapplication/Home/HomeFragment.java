package com.example.plmntnsv.workoutapplication.Home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.plmntnsv.workoutapplication.Login.LoginActivity;
import com.example.plmntnsv.workoutapplication.R;
import com.example.plmntnsv.workoutapplication.Tabs.Fragments.TabsFragmentType;
import com.example.plmntnsv.workoutapplication.Tabs.TabsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private HomeContracts.Presenter mPresenter;
    private View mBtnCreatePlan;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        mBtnCreatePlan = root.findViewById(R.id.btn_create_plan);
        mBtnCreatePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCreateWorkouts();
            }
        });
        return root;
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    protected void navigateToCreateWorkouts(){
        Intent intent = new Intent(getContext(), TabsActivity.class);
        intent.putExtra("type", TabsFragmentType.CREATE);
        startActivity(intent);
    }
}
