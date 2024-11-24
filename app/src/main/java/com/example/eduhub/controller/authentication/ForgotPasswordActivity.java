package com.example.eduhub.controller.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.eduhub.R;
import com.example.eduhub.model.AuthenticationModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private AppCompatButton btnResetPassword;
    private FirebaseAuth mAuth;
    private ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_pass_page);

        editTextEmail = findViewById(R.id.emailEditText);
        btnResetPassword = findViewById(R.id.resetPassButton);
        mAuth = FirebaseAuth.getInstance();
        backBtn = findViewById(R.id.button_back);

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email;
                email = String.valueOf(editTextEmail.getText());
                if(TextUtils.isEmpty(email)) {
                    Toast.makeText(ForgotPasswordActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!AuthenticationModel.isValidEmail(email)) {
                    Toast.makeText(ForgotPasswordActivity.this, "Invalid email", Toast.LENGTH_SHORT).show();
                    return;

                }
                mAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ForgotPasswordActivity.this, "Reset pass sent to email", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(ForgotPasswordActivity.this, LandingActivity.class);
                                    startActivity(intent);
                                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                                    finish();
                                }
                            }
                        });
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordActivity.this, SignInActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }

}