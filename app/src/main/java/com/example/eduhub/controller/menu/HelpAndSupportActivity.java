package com.example.eduhub.controller.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eduhub.R;
import com.example.eduhub.controller.certificate.CertificatesActivity;
import com.example.eduhub.controller.main.HomePageActivity;

public class HelpAndSupportActivity extends AppCompatActivity {

    ImageButton btnHome, btnCertificates, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_and_support_page);

        btnHome = findViewById(R.id.button_home);
        btnCertificates = findViewById(R.id.button_certificates);
        btnBack = findViewById(R.id.button_back);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpAndSupportActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnCertificates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpAndSupportActivity.this, CertificatesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpAndSupportActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}

