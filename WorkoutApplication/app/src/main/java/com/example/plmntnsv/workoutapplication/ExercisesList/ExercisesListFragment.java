package com.example.plmntnsv.workoutapplication.ExercisesList;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.plmntnsv.workoutapplication.R;
import com.example.plmntnsv.workoutapplication.models.Exercise.Exercise;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExercisesListFragment extends Fragment implements ExercisesListContracts.View {


    private ListView mListViewWorkouts;
    private ArrayAdapter<Exercise> mExercisesAdapter;
    private ExercisesListContracts.Presenter mPresenter;

    public ExercisesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_exercises_list, container, false);

        mExercisesAdapter = new ArrayAdapter<Exercise>(getContext(), android.R.layout.simple_list_item_1) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView view = null;
                if (convertView == null || !(convertView instanceof TextView)) {
                    LayoutInflater viewInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = (TextView) viewInflater.inflate(android.R.layout.simple_list_item_1, null);
                } else {
                    view = (TextView) convertView;
                }

                view.setText(getItem(position).getName());

                return view;
            }
        };


        mListViewWorkouts = root.findViewById(R.id.lv_exercises);
        mListViewWorkouts.setAdapter(mExercisesAdapter);

        return root;
    }

    public static ExercisesListFragment newInstance() {
        ExercisesListFragment fragment = new ExercisesListFragment();
        return fragment;
    }

    @Override
    public void onResume() {
        mPresenter.subscribe(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mPresenter.unsubscribe();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mPresenter = null;
        super.onDestroy();
    }

    @Override
    public void setPresenter(ExercisesListContracts.Presenter presenter) {
        mPresenter = presenter;
    }
}
