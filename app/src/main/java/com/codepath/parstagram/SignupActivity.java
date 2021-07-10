package com.codepath.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    public static final String TAG = "SignupActivity";
    private EditText etUsernameSignup;
    private EditText etPasswordSignup;
    private Button btnSignupOfficial;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsernameSignup = findViewById(R.id.etUsernameSignup);
        etPasswordSignup = findViewById(R.id.etPasswordSignup);
        btnSignupOfficial = findViewById(R.id.btnSignupOfficial);
        btnSignupOfficial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                String username = etUsernameSignup.getText().toString();
                String password = etPasswordSignup.getText().toString();

                // Create the ParseUser
                ParseUser user = new ParseUser();
                // Set core properties
                user.setUsername(username);
                user.setPassword(password);
                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            // Hooray! Let them use the app now.
                            Intent i = new Intent(SignupActivity.this, FeedActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(SignupActivity.this, "Issue with login!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });

            }
        });
    }
}
