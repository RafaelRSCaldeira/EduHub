package com.example.eduhub.controller.authentication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eduhub.R;

import java.util.Timer;

public class ConfirmPassResetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_page);

        Timer timer = new Timer();
        try {
            timer.wait(3000);
            Intent intent = new Intent(ConfirmPassResetActivity.this, SignInActivity.class);
            startActivity(intent);
            finish();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}

