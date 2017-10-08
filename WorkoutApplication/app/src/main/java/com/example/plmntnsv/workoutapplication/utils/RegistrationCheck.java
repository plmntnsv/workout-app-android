package com.example.plmntnsv.workoutapplication.utils;

import android.view.View;
import android.widget.Toast;

import static java.security.AccessController.getContext;

/**
 * Created by Plmn Tnsv on 08-Oct-17.
 */

public final class RegistrationCheck {

    private RegistrationCheck(){}

    public static boolean checkRegistrationForm(View root, String email, String password, String repeatPassword) {

        if (android.text.TextUtils.isEmpty(email)) {
            Toast.makeText(root.getContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (android.text.TextUtils.isEmpty(password)) {
            Toast.makeText(root.getContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.length() < 6) {
            Toast.makeText(root.getContext(), "Password must be minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!(password.equals(repeatPassword))) {
            Toast.makeText(root.getContext(), "Passwords do not match!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
