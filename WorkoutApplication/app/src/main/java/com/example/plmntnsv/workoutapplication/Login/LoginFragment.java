package com.example.plmntnsv.workoutapplication.Login;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plmntnsv.workoutapplication.Home.HomeActivity;
import com.example.plmntnsv.workoutapplication.Models.PopulateDB.Temp;
import com.example.plmntnsv.workoutapplication.R;
import com.example.plmntnsv.workoutapplication.Registration.RegistrationActivity;
import com.example.plmntnsv.workoutapplication.Repositoriy.FirebaseDataLogicRepository;
import com.example.plmntnsv.workoutapplication.Utils.ModalWindow;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContracts.View {

    private LoginContracts.Presenter mPresenter;
    private EditText mLoginEmail;
    private EditText mLoginPassword;
    private Button mLoginBtn;
    private TextView mTvRegister;
    private String mEmail;
    private String mPassword;
    private ModalWindow mModalWindow;
    private Button mTestBtn;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_login, container, false);

        mLoginEmail = root.findViewById(R.id.et_email);
        mLoginPassword = root.findViewById(R.id.et_password);
        mLoginBtn = root.findViewById(R.id.button_login);
        //TODO:delete later
        mTestBtn = root.findViewById(R.id.btn_test);
        final FirebaseDataLogicRepository repo = new FirebaseDataLogicRepository();
        mTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temp temp = new Temp();
                repo.populateDbWorkouts(temp.getAll());
                //repo.getAllChestExercisesFromDb();
            }
        });

        String loggingIn = getResources().getString(R.string.logging_in);
        mModalWindow = new ModalWindow(root, loggingIn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               loginUser();
            }
        });

        mTvRegister = root.findViewById(R.id.tv_register);
        mTvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToRegister();
            }
        });

        return root;
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
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
    public void setPresenter(LoginContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void loginUser() {
        mModalWindow.show();

        mEmail = mLoginEmail.getText().toString().trim();
        mPassword = mLoginPassword.getText().toString().trim();

        mPresenter.loginUser(mEmail, mPassword);
    }

    @Override
    public void navigateToHome() {
        mModalWindow.hide();
        Toast.makeText(getContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), HomeActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void setUnexpectedError(String errMsg) {
        mModalWindow.hide();
        Toast.makeText(getContext(), errMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setInvalidEmailError() {
        mModalWindow.hide();
        Toast.makeText(getContext(), "Invalid email!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setInvalidPasswordError() {
        mModalWindow.hide();
        Toast.makeText(getContext(), "Invalid password!", Toast.LENGTH_SHORT).show();
    }

    private void navigateToRegister(){
        Intent intent = new Intent(getContext(), RegistrationActivity.class);
        getContext().startActivity(intent);
    }
}
