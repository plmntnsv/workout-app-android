package com.example.plmntnsv.workoutapplication.Registration;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.plmntnsv.workoutapplication.Home.HomeActivity;
import com.example.plmntnsv.workoutapplication.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment implements RegistrationContracts.View {
    private RegistrationContracts.Presenter mPresenter;
    private EditText registerEmail;
    private EditText registerPassword;
    private EditText registerPasswordRepeat;

    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_registration, container, false);

       registerEmail = root.findViewById(R.id.et_registerEmail);
       registerPassword = root.findViewById(R.id.et_registerPassword);
       registerPasswordRepeat = root.findViewById(R.id.et_registerRepeatPassword);

        Button registerBtn = root.findViewById(R.id.btn_register);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
               }
       });

        return root;
    }

    public static RegistrationFragment newInstance() {
        RegistrationFragment fragment = new RegistrationFragment();
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
    public void setPresenter(RegistrationContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void registerUser() {
        String email = registerEmail.getText().toString().trim();
        String password = registerPassword.getText().toString().trim();
        String repeatPassword = registerPasswordRepeat.getText().toString().trim();

        mPresenter.registerUser(email, password, repeatPassword);
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(getContext(), HomeActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    public void setUnexpectedError(String errMsg) {
        Toast.makeText(getContext(), errMsg, Toast.LENGTH_SHORT).show();
    }

    public void setEmailEmptyError() {
        Toast.makeText(getContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
    }

    public void setPasswordEmptyError() {
        Toast.makeText(getContext(), "Enter password!", Toast.LENGTH_SHORT).show();
    }

    public void setPasswordTooShortError() {
        Toast.makeText(getContext(), "Password must be minimum 6 characters!", Toast.LENGTH_SHORT).show();
    }

    public void setPasswordMissMatchError() {
        Toast.makeText(getContext(), "Passwords do not match!", Toast.LENGTH_SHORT).show();
    }
}
