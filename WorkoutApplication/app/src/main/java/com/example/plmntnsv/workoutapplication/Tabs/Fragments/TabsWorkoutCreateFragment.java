package com.example.plmntnsv.workoutapplication.Tabs.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.plmntnsv.workoutapplication.ExercisesList.ExercisesListActivity;
import com.example.plmntnsv.workoutapplication.Models.Exercise.Category;
import com.example.plmntnsv.workoutapplication.R;
import com.example.plmntnsv.workoutapplication.Tabs.TabsContracts;

public class TabsWorkoutCreateFragment extends Fragment implements TabsContracts.CreateWorkoutsLogic {

    private Button btnAddCardioEx;
    private Button btnAddArmsEx;
    private Button btnAddChestEx;
    private Button btnAddBackEx;
    private Button btnAddShouldersEx;
    private Button btnAddLegsEx;
    private Button btnAddCoreEx;

    public TabsWorkoutCreateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tabs_create, container, false);

        btnAddChestEx = root.findViewById(R.id.btn_add_chest_ex);
        btnAddBackEx = root.findViewById(R.id.btn_add_back_ex);
        btnAddShouldersEx = root.findViewById(R.id.btn_add_shoulders_ex);
        btnAddArmsEx = root.findViewById(R.id.btn_add_arms_ex);
        btnAddLegsEx = root.findViewById(R.id.btn_add_legs_ex);
        btnAddCoreEx = root.findViewById(R.id.btn_add_core_ex);
        btnAddCardioEx = root.findViewById(R.id.btn_add_cardio_ex);

        this.setOnClickListeners();

        return root;
    }

    public static Fragment createFragment(int position) {
        TabsWorkoutCreateFragment fragment = new TabsWorkoutCreateFragment();
//        Bundle args = new Bundle();
//        args.putInt("position", position);
//        fragment.setArguments(args);
        return fragment;
    }

    public static TabsWorkoutCreateFragment newInstance() {
        TabsWorkoutCreateFragment fragment = new TabsWorkoutCreateFragment();
        return fragment;
    }

    @Override
    public void displayChestExercises() {
        Intent intent = new Intent(getContext(), ExercisesListActivity.class);
        intent.putExtra("type", Category.CHEST);
        startActivity(intent);
    }

    @Override
    public void displayBackExercises() {
        Intent intent = new Intent(getContext(), ExercisesListActivity.class);
        intent.putExtra("type", Category.BACK);
        startActivity(intent);
    }

    @Override
    public void displayShouldersExercises() {
        Intent intent = new Intent(getContext(), ExercisesListActivity.class);
        intent.putExtra("type", Category.SHOULDERS);
        startActivity(intent);
    }

    @Override
    public void displayArmsExercises() {
        Intent intent = new Intent(getContext(), ExercisesListActivity.class);
        intent.putExtra("type", Category.ARMS);
        startActivity(intent);
    }

    @Override
    public void displayLegsExercises() {
        Intent intent = new Intent(getContext(), ExercisesListActivity.class);
        intent.putExtra("type", Category.LEGS);
        startActivity(intent);
    }

    @Override
    public void displayCoreExercises() {
        Intent intent = new Intent(getContext(), ExercisesListActivity.class);
        intent.putExtra("type", Category.CORE);
        startActivity(intent);
    }

    @Override
    public void displayCardioExercises() {
        Intent intent = new Intent(getContext(), ExercisesListActivity.class);
        intent.putExtra("type", Category.CARDIO);
        startActivity(intent);
    }

    protected void setOnClickListeners(){
        btnAddChestEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayChestExercises();
            }
        });
        btnAddBackEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayBackExercises();
            }
        });
        btnAddArmsEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayArmsExercises();
            }
        });
        btnAddCardioEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCardioExercises();
            }
        });
        btnAddCoreEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCoreExercises();
            }
        });
        btnAddLegsEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayLegsExercises();
            }
        });
        btnAddShouldersEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayShouldersExercises();
            }
        });
    }
}
