package com.example.eduhub.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthenticationModel {
    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String pass) {
        if (pass.length() <= 8) {
            return false;
        }
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W_]).+$";
        return Pattern.matches(regex, pass);
    }

    public static void saveValues(String email, String name) {
        UserModel userModel = new UserModel(email, name);
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference users = mDatabase.getReference("users");
        users.child(String.valueOf(email.hashCode())).setValue(userModel);
    }

}