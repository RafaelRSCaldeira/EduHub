package com.example.eduhub.controller.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.eduhub.R;
import com.example.eduhub.controller.authentication.LandingActivity;
import com.example.eduhub.controller.certificate.CertificatesActivity;
import com.example.eduhub.controller.main.HomePageActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {

    private AppCompatButton btnPersonalInfo, btnAboutUs, btnHelpAndSupport, btnLogOut;
    private LinearLayout homeContainer, certificateContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_page);

        setMenu();
        bottomBar();
    }

    private void bottomBar() {
        homeContainer = findViewById(R.id.homeContainer);
        certificateContainer = findViewById(R.id.certificateContainer);

        homeContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        certificateContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, CertificatesActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    private void setMenu() {
        btnPersonalInfo = findViewById(R.id.button_personal_info);
        btnAboutUs = findViewById(R.id.button_about_us);
        btnHelpAndSupport = findViewById(R.id.button_help_and_support);
        btnLogOut = findViewById(R.id.button_logout);

        btnPersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, PersonalInfoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AboutUsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnHelpAndSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, HelpAndSupportActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                Intent intent = new Intent(MenuActivity.this, LandingActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }
}