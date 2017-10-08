package com.example.plmntnsv.workoutapplication.Registration;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Plmn Tnsv on 08-Oct-17.
 */

public final class RegistrationPresenterImpl {

    private static FirebaseAuth mAuth;

    private RegistrationPresenterImpl(){

    }

    public static void registerUserToDb(String email, String password, final RegistrationContracts.OnLoginFinishedListener listener, final RegistrationFragment view) {

        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(view.getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(view.getContext(), "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        if (!task.isSuccessful()) {
                            listener.onUnecpectedError("Unexpected error. " + task.getException());
                        } else {
                            listener.onSuccess();
                        }
                    }
                });
    }
}
