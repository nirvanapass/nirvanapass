package com.nirvanapass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

//        TabHost mainTabHost = (TabHost) findViewById(R.id.mainTabHost);
//        mainTabHost.setup();
//
//        mainTabHost.addTab(mainTabHost.newTabSpec("Password").setIndicator("", ContextCompat.getDrawable(this, R.drawable.password)).setContent(new Intent(this, PasswordActivity.class)));
//
//        mainTabHost.addTab(mainTabHost.newTabSpec("User").setIndicator("", ContextCompat.getDrawable(this, R.drawable.user)).setContent(new Intent(this, UserActivity.class)));
//
//        mainTabHost.addTab(mainTabHost.newTabSpec("Help").setIndicator("", ContextCompat.getDrawable(this, R.drawable.help)).setContent(new Intent(this, HelpActivity.class)));
    }
}
