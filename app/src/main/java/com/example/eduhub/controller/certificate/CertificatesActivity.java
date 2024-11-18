package com.example.eduhub.controller.certificate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eduhub.R;
import com.example.eduhub.controller.main.HomePageActivity;
import com.example.eduhub.controller.menu.MenuActivity;

public class CertificatesActivity extends AppCompatActivity {

    private LinearLayout homeContainer, menuContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.certificates_page);

        bottomBar();
    }

    private void bottomBar() {
        homeContainer = findViewById(R.id.homeContainer);
        menuContainer = findViewById(R.id.menuContainer);

        homeContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CertificatesActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
            }
        });

        menuContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CertificatesActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
            }
        });

    }
}

