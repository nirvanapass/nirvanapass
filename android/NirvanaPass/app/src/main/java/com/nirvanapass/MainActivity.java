package com.nirvanapass;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ViewPager mainViewPager;
    private FragmentPagerAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        mainAdapter = new MainAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(mainAdapter);
    }
}
