package com.example.eduhub.controller.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eduhub.R;
import com.example.eduhub.controller.certificate.CertificatesActivity;

public class MenuActivity extends AppCompatActivity {

    private Button btnPersonalInfo, btnAboutUs, btnHelpAndSupport;
    private ImageButton btnHome, btnCertificates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_page);

        btnPersonalInfo = findViewById(R.id.button_personal_info);
        btnAboutUs = findViewById(R.id.button_about_us);
        btnHelpAndSupport = findViewById(R.id.button_help_and_support);

        btnHome = findViewById(R.id.button_home);
        btnCertificates = findViewById(R.id.button_certificates);

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

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnCertificates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CertificatesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

