package com.example.eduhub.controller.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eduhub.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;

public class EmailVerificationActivity extends AppCompatActivity {

    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user = auth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_page);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if(user == null) {
            Toast.makeText(this, "Usuário não encontrado", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(EmailVerificationActivity.this, LandingActivity.class);
            startActivity(intent);
            finish();
        }
        user.sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Timer timer = new Timer();
                            try {
                                timer.wait(3000);
                                Intent intent = new Intent(EmailVerificationActivity.this, SignInActivity.class);
                                startActivity(intent);
                                finish();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });



    }

}

