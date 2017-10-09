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

/**
 * Created by Plmn Tnsv on 08-Oct-17.
 */

public class FirebaseRepository implements BaseRepositoryContracts.FirebaseTools {

    private static FirebaseAuth mAuth;

    public FirebaseRepository() {
        mAuth = FirebaseAuth.getInstance();
    }

    public void registerUserToDb(String email, String password, final BaseRepositoryContracts.OnLoginFinishedListener listener) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Toast.makeText(view.getContext(), "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        if (!task.isSuccessful()) {
                            listener.onUnecpectedError("Unexpected error. " + task.getException());
                        } else {
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
                            listener.onSuccess();
                        }
                    }
                });

    }

    @Override
    public FirebaseAuth.AuthStateListener authListener(BaseRepositoryContracts.OnLoginFinishedListener listener) {
        return null;
        //firebaseAuth -> {
//            FirebaseUser user = firebaseAuth.getCurrentUser();
//            if (user != null) {
//                listener.onSuccess();
//            } else {
//                // User is signed out
//                listener.onUsernameError();
//            }
//        };
    }
}
