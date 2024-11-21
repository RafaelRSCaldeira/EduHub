package com.example.eduhub.controller.main.courses;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Course1Activity extends AppCompatActivity {

    private ImageButton backBtn;
    private Button c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18;
    private List<String> urls;
    private List<Button> buttons;
    private HashMap<Integer, Boolean> states;
    private double progressBarCount;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course1);

        setProgressBar();
        setBackBtn();
        createUrlList();
        setButtons();
    }

    private void setProgressBar() {
        progressBarCount = 0;
        progressBar = findViewById(R.id.progressBar);
    }

    private void createUrlList() {
        urls = new ArrayList<>();
        urls.add("https://www.youtube.com/watch?v=tN6oJu2DqCM");
        urls.add("https://www.youtube.com/watch?v=nu_pCVPKzTk");
        urls.add("https://www.youtube.com/watch?v=qwAFL1597eM");
        urls.add("https://www.youtube.com/watch?v=ZxMB6Njs3ck");
        urls.add("https://www.youtube.com/watch?v=RGOj5yH7evk");
        urls.add("https://www.youtube.com/watch?v=-fW2X7fh7Yg");
        urls.add("https://www.youtube.com/watch?v=WXsD0ZgxjRw");
        urls.add("https://www.youtube.com/watch?v=0sOvCWFmrtA");
        urls.add("https://www.youtube.com/watch?v=YYe0FdfdgDU");
        urls.add("https://www.youtube.com/watch?v=IPiUDhwnZxA");
        urls.add("https://www.youtube.com/watch?v=m8Icp_Cid5o");
        urls.add("https://www.youtube.com/watch?v=hmkF77F9TLw");
        urls.add("https://www.youtube.com/watch?v=kTp5xUtcalw");
        urls.add("https://www.youtube.com/watch?v=5199E50O7SI");
        urls.add("https://www.youtube.com/watch?v=fgdpvwEWJ9M");
        urls.add("https://www.youtube.com/watch?v=9t9Mp0BGnyI");
        urls.add("https://www.youtube.com/watch?v=XCsS_NVAa1g");
        urls.add("https://www.youtube.com/watch?v=zN8YNNHcaZc");
    }

    private void setButtons() {
        buttons = new ArrayList<>();
        buttons.add(findViewById(R.id.couse1));
        buttons.add(findViewById(R.id.couse2));
        buttons.add(findViewById(R.id.couse3));
        buttons.add(findViewById(R.id.couse4));
        buttons.add(findViewById(R.id.couse5));
        buttons.add(findViewById(R.id.couse6));
        buttons.add(findViewById(R.id.couse7));
        buttons.add(findViewById(R.id.couse8));
        buttons.add(findViewById(R.id.couse9));
        buttons.add(findViewById(R.id.couse10));
        buttons.add(findViewById(R.id.couse11));
        buttons.add(findViewById(R.id.couse12));
        buttons.add(findViewById(R.id.couse13));
        buttons.add(findViewById(R.id.couse14));
        buttons.add(findViewById(R.id.couse15));
        buttons.add(findViewById(R.id.couse16));
        buttons.add(findViewById(R.id.couse17));
        buttons.add(findViewById(R.id.couse18));

        setStates();

        for(int i = 0; i < buttons.size(); i++) {
            setButtonListener(buttons.get(i), urls.get(i));
        }
    }

    private void setStates() {
        states = new HashMap<>();

        for(Button btn: buttons) {
            states.put(btn.getId(), false);
        }
    }

    private void setButtonListener(Button btn, String url) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                //startActivity(intent);
                if(Boolean.FALSE.equals(states.get(btn.getId()))) {
                    btn.setBackgroundResource(R.drawable.bg_button_course_done);
                    btn.setTextColor(ContextCompat.getColor(getApplicationContext() ,R.color.bg_main_color));
                    Drawable drawableLeft = ContextCompat.getDrawable(Course1Activity.this, R.drawable.ic_check);
                    btn.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, null, null, null);
                    addToProgressBar();
                    states.put(btn.getId(), true);
                }
            }
        });
    }

    private void addToProgressBar() {
        double step = 100.0 / buttons.size();
        progressBarCount += step;
        if(progressBarCount > 100) {
            progressBarCount = 100;
        }
        progressBar.setProgress((int) Math.round(progressBarCount));
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