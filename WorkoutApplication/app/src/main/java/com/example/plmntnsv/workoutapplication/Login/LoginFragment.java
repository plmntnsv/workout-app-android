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
import com.example.plmntnsv.workoutapplication.R;
import com.example.plmntnsv.workoutapplication.Registration.RegistrationActivity;
import com.example.plmntnsv.workoutapplication.utils.ModalWindow;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContracts.View {

    private LoginContracts.Presenter mPresenter;
    private EditText loginEmail;
    private EditText loginPassword;
    private Button loginBtn;
    private TextView tvRegister;
    private String mEmail;
    private String mPassword;
    private ModalWindow mModalWindow;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_login, container, false);

        loginEmail = root.findViewById(R.id.et_email);
        loginPassword = root.findViewById(R.id.et_password);
        loginBtn = root.findViewById(R.id.button_login);

        mModalWindow = new ModalWindow(root);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               loginUser();
            }
        });

        tvRegister = root.findViewById(R.id.tv_register);
        tvRegister.setOnClickListener(new View.OnClickListener() {
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

        mEmail = loginEmail.getText().toString().trim();
        mPassword = loginPassword.getText().toString().trim();

        mPresenter.loginUser(mEmail, mPassword);
    }

    @Override
    public void navigateToHome() {
        mModalWindow.hide();
        Toast.makeText(getContext(), "Welcome " + mEmail, Toast.LENGTH_SHORT).show();
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
        //mModalWindow.hide();
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
