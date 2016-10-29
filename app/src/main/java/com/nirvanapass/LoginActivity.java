package com.nirvanapass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lambdaworks.crypto.SCrypt;

import java.security.GeneralSecurityException;

public class LoginActivity extends AppCompatActivity {

    private EditText loginNameEditText;
    private EditText loginPasswordEditText;
    private Button loginSubmitButton;
    private ProgressBar loginProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);

        loginNameEditText = (EditText) findViewById(R.id.loginNameEditText);
        loginPasswordEditText = (EditText) findViewById(R.id.loginPasswordEditText);
        loginSubmitButton = (Button) findViewById(R.id.loginLoginButton);
        loginProgressBar = (ProgressBar) findViewById(R.id.loginProgressBar);

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
        new ScryptAsyncTask(this).execute(loginPasswordEditText.getText().toString(), loginNameEditText.getText().toString());
    }

    private class ScryptAsyncTask extends AsyncTask<String, Void, String> {

        private Context context;

        private ScryptAsyncTask(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            loginProgressBar.setVisibility(View.VISIBLE);
            Toast.makeText(LoginActivity.this, "Computing hash...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                long time1 = System.currentTimeMillis();
                String password = params[0];
                String name = params[1];
                String hash = Base64.encodeToString(SCrypt.scrypt(password.getBytes(), name.getBytes(), 16384, 16, 2, 128), Base64.DEFAULT);
                long time2 = System.currentTimeMillis();
                long timeDiff = time2 - time1;
                SharedPreferences userSession = getSharedPreferences("userSession", Context.MODE_PRIVATE);
                SharedPreferences.Editor userSessionEditor = userSession.edit();
                userSessionEditor.putString("name", name);
                userSessionEditor.putString("hash", hash);
                userSessionEditor.apply();

                return timeDiff + "ms:::" + hash;
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }

            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            loginProgressBar.setVisibility(View.GONE);
            Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, MainActivity.class);
            startActivity(intent);
        }
    }
}
