package com.nirvanapass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class LoginActivity extends AppCompatActivity {

    private EditText loginNameEditText;
    private EditText loginPasswordEditText;
    private Button loginSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);
        loginNameEditText = (EditText) findViewById(R.id.loginNameEditText);
        loginPasswordEditText = (EditText) findViewById(R.id.loginPasswordEditText);
        loginSubmitButton = (Button) findViewById(R.id.loginSubmitButton);

        loginPasswordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginSubmitButton.performClick();
                    return true;
                }
                return false;
            }
        });
    }

    public void onClickLoginSubmitButton(View view) {
        Argon2 argon2 = Argon2Factory.create();
        try {
            String hash = argon2.hash(10, 65536, 8, loginNameEditText.getText().toString() + " " + loginPasswordEditText.getText().toString());
            Toast.makeText(LoginActivity.this, hash, Toast.LENGTH_LONG).show();
        } catch (UnsatisfiedLinkError ule) {
            Toast.makeText(LoginActivity.this, "Need to fix linking error", Toast.LENGTH_LONG).show();
        }
    }
}
