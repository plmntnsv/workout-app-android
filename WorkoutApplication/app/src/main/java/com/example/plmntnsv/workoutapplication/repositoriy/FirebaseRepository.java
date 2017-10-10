package com.example.plmntnsv.workoutapplication.repositoriy;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.plmntnsv.workoutapplication.Login.LoginContracts;
import com.example.plmntnsv.workoutapplication.Login.LoginFragment;
import com.example.plmntnsv.workoutapplication.Registration.RegistrationFragment;
import com.example.plmntnsv.workoutapplication.repositoriy.base.BaseRepositoryContracts;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Plmn Tnsv on 08-Oct-17.
 */

public class FirebaseRepository implements BaseRepositoryContracts.FirebaseTools {

    private static FirebaseAuth mAuth;
    private static FirebaseAuth.AuthStateListener mListener;
    private static FirebaseUser mUser;

    public FirebaseRepository() {
        mAuth = FirebaseAuth.getInstance();
    }

    public void registerUserToDb(String email, String password, final BaseRepositoryContracts.OnLoginFinishedListener listener) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            listener.onUnecpectedError("Unexpected error. " + task.getException());
                        } else {
                            mUser = mAuth.getCurrentUser();
                            listener.onSuccess();
                        }
                    }
                });
    }

    @Override
    public void loginUser(String email, String password, final BaseRepositoryContracts.OnLoginFinishedListener listener) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            listener.onUnecpectedError("Unexpected error. " + task.getException());
                        } else {
                            mUser = mAuth.getCurrentUser();
                            listener.onSuccess();
                        }
                    }
                });

    }

    @Override
    public void logoutUser(final BaseRepositoryContracts.OnLogoutFinishedListener listener) {
        mUser = null;
        listener.onLogout();
    }

    @Override
    public FirebaseUser getCurrentUser() {
        return mUser;
    }

    @Override
    public FirebaseAuth.AuthStateListener authListener(final BaseRepositoryContracts.OnLoginFinishedListener listener) {
        mListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (mUser != null) {
                    //listener.onSuccess();
                } else {
                    // User is signed out
                    //listener.onUnecpectedError("asd");
                }
            }
        };

        mAuth.addAuthStateListener(mListener);

        return mListener;
    }
}
