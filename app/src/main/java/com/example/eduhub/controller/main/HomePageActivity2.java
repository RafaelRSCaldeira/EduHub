package com.example.eduhub.controller.main;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.eduhub.R;
import com.example.eduhub.controller.main.adapters.ListAdapter;
import com.example.eduhub.controller.main.adapters.SliderAdaptes;
import com.example.eduhub.controller.main.domain.ListItem;
import com.example.eduhub.controller.main.domain.SliderItems;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity2 extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private final Handler slideHandler = new Handler();
    private RecyclerView recyclerView, recyclerView2, recyclerView3;
    private ListAdapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);

        initView();
        banners();
        initRecyclerView();
    }

    private void initRecyclerView() {
        listItems = new ArrayList<>();

        for(int i = 0; i <= 10; i++) {
            ListItem listItem = new ListItem("https://i.ytimg.com/vi/tN6oJu2DqCM/maxresdefault.jpg");

            listItems.add(listItem);
        }

        recyclerView = (RecyclerView) findViewById(R.id.view1);
        recyclerView2 = (RecyclerView) findViewById(R.id.view2);
        recyclerView3 = (RecyclerView) findViewById(R.id.view3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        adapter = new ListAdapter(listItems, this);

        recyclerView.setAdapter(adapter);
        recyclerView2.setAdapter(adapter);
        recyclerView3.setAdapter(adapter);
    }

    private void banners() {
        List<SliderItems> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItems(R.drawable.thumb1));
        sliderItems.add(new SliderItems(R.drawable.thumb2));
        sliderItems.add(new SliderItems(R.drawable.thumb3));

        viewPager2.setAdapter(new SliderAdaptes(sliderItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_ALWAYS);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.setCurrentItem(1);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            int currentItem = viewPager2.getCurrentItem();
            int nextItem = (currentItem + 1) % viewPager2.getAdapter().getItemCount();
            viewPager2.setCurrentItem(nextItem);
            slideHandler.postDelayed(this, 3000);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        slideHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        slideHandler.postDelayed(sliderRunnable, 3000);
    }

    private void initView() {
        viewPager2 = findViewById(R.id.viewpagerSlider);
    }
}