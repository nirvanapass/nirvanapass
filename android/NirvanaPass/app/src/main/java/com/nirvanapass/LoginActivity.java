package com.nirvanapass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
//        try {
//            String hash = Base64.encodeToString(SCrypt.scrypt(loginPasswordEditText.getText().toString().getBytes(), loginNameEditText.getText().toString().getBytes(), 16384, 16, 2, 128), Base64.DEFAULT);
//            SharedPreferences userSession = getSharedPreferences("userSession", Context.MODE_PRIVATE);
//            SharedPreferences.Editor userSessionEditor = userSession.edit();
//            userSessionEditor.putString("name", loginNameEditText.getText().toString());
//            userSessionEditor.putString("hash", hash);
//            userSessionEditor.apply();

        Intent intent = new Intent(this, PasswordActivity.class);
        startActivity(intent);
//        } catch (GeneralSecurityException e) {
//            e.printStackTrace();
//        }
    }
}
