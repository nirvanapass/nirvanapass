package com.nirvanapass;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        TabHost passwordTabHost = (TabHost) findViewById(R.id.passwordTabHost);
        passwordTabHost.setup();

        TabHost.TabSpec spec = passwordTabHost.newTabSpec("Generate");
        spec.setContent(R.id.passwordHomeLayout);
        spec.setIndicator("", ContextCompat.getDrawable(this, R.drawable.password));
        passwordTabHost.addTab(spec);

        spec = passwordTabHost.newTabSpec("Me");
        spec.setContent(R.id.profileLayout);
        spec.setIndicator("", ContextCompat.getDrawable(this, R.drawable.user));
        passwordTabHost.addTab(spec);

        spec = passwordTabHost.newTabSpec("Help");
        spec.setContent(R.id.helpLayout);
        spec.setIndicator("", ContextCompat.getDrawable(this, R.drawable.help));
        passwordTabHost.addTab(spec);
    }
}
