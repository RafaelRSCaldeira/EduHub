package com.example.eduhub.controller.main.courses;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.eduhub.R;
import com.example.eduhub.controller.authentication.LandingActivity;
import com.example.eduhub.controller.authentication.SignInActivity;
import com.example.eduhub.controller.main.HomePageActivity;

public class Course1Activity extends AppCompatActivity {

    private ImageButton backBtn;
    private Button c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course1);

        setBackBtn();
        setButtons();
    }

    private void setButtons() {
        c1 = findViewById(R.id.couse1);
        c2 = findViewById(R.id.couse2);
        c3 = findViewById(R.id.couse3);
        c4 = findViewById(R.id.couse4);
        c5 = findViewById(R.id.couse5);
        c6 = findViewById(R.id.couse6);
        c7 = findViewById(R.id.couse7);
        c8 = findViewById(R.id.couse8);
        c9 = findViewById(R.id.couse9);
        c10 = findViewById(R.id.couse10);
        c11 = findViewById(R.id.couse11);
        c12 = findViewById(R.id.couse12);
        c13 = findViewById(R.id.couse13);
        c14 = findViewById(R.id.couse14);
        c15 = findViewById(R.id.couse15);
        c16 = findViewById(R.id.couse16);
        c17 = findViewById(R.id.couse17);
        c18 = findViewById(R.id.couse18);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/watch?v=tN6oJu2DqCM"));
                //startActivity(intent);
                c1.setBackgroundResource(R.drawable.bg_button_course_done);
                c1.setTextColor(ContextCompat.getColor(getApplicationContext() ,R.color.bg_main_color));
                Drawable drawableLeft = ContextCompat.getDrawable(Course1Activity.this, R.drawable.ic_left_arrow);
                c1.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, null, null, null);


            }
        });
    }

    private void setBackBtn() {
        backBtn = findViewById(R.id.button_back);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Course1Activity.this, HomePageActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }
}