package com.example.eduhub.controller.certificate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eduhub.R;
import com.example.eduhub.controller.certificate.courses.Course1CertificateActivity;
import com.example.eduhub.controller.main.HomePageActivity;
import com.example.eduhub.controller.menu.MenuActivity;

import java.util.ArrayList;

public class CertificatesActivity extends AppCompatActivity {

    private LinearLayout homeContainer, menuContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.certificates_page);

        bottomBar();
        setCertificates();
    }

    private void setCertificates() {
        ArrayList<LinearLayout> certificates = new ArrayList<>();
        ArrayList<ImageButton> buttons = new ArrayList<>();

        certificates.add(findViewById(R.id.course_1_container));
        certificates.add(findViewById(R.id.course_2_container));
        certificates.add(findViewById(R.id.course_3_container));
        certificates.add(findViewById(R.id.course_4_container));
        certificates.add(findViewById(R.id.course_5_container));

        buttons.add(findViewById(R.id.btn1));
        buttons.add(findViewById(R.id.btn2));
        buttons.add(findViewById(R.id.btn3));
        buttons.add(findViewById(R.id.btn4));
        buttons.add(findViewById(R.id.btn5));

        for(LinearLayout certificate: certificates) {
            certificate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CertificatesActivity.this, Course1CertificateActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                }
            });
        }

        for(ImageButton button: buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CertificatesActivity.this, Course1CertificateActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                }
            });
        }
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
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        menuContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CertificatesActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }
}

