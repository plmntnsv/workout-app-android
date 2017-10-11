package com.example.plmntnsv.workoutapplication.ExercisesList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.plmntnsv.workoutapplication.Models.Exercise.Exercise;
import com.example.plmntnsv.workoutapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Plmn Tnsv on 12-Oct-17.
 */

public class ExercisesListAdapter {
    private final View mView;
    private final ArrayList<Exercise> mExercises;
    private ArrayAdapter<Exercise> mExercisesAdapter;
    private ListView mListViewExercises;

    public ExercisesListAdapter(View view, ArrayList<Exercise> exercises){
        mView = view;
        mExercises = exercises;
        this.setAdapter();
    }

    void setAdapter(){

        mExercisesAdapter = new ArrayAdapter<Exercise>(mView.getContext(), -1, mExercises) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = convertView;
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(mView.getContext());;
                    view = inflater.inflate(R.layout.exercise_layout, parent, false);
                }

                TextView tvExName = view.findViewById(R.id.tv_ex_name);
                String name = this.getItem(position).getName();
                tvExName.setText(name);

                TextView tvExDesc = view.findViewById(R.id.tv_ex_desc);
                String desc = this.getItem(position).getDescription();
                tvExDesc.setText(desc);

                return view;
            }


        };

        mListViewExercises = mView.findViewById(R.id.lv_exercises);
        mListViewExercises.setAdapter(mExercisesAdapter);
    }
}
