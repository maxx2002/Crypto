package com.example.cryptocurrencytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    private TextView login_text_register;
    private TextInputLayout login_textinput_email, login_textinput_password;
    private Button login_button_login;
    private Boolean validate_email = false, validate_password = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_text_register = findViewById(R.id.login_text_register);
        login_textinput_email = findViewById(R.id.login_textinput_email);
        login_textinput_password = findViewById(R.id.login_textinput_password);
        login_button_login = findViewById(R.id.login_button_login);
        final LoadingDialog loadingDialog = new LoadingDialog(Login.this);

        login_button_login.setEnabled(false);

        login_text_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Register.class);
                startActivity(intent);
            }
        });

        login_button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingDialog.startLoadingAnimation();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 1000);
            }
        });

        login_textinput_email.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = login_textinput_email.getEditText().getText().toString().trim();

                if (email.isEmpty()) {
                    login_textinput_email.setError("Please fill the email column");
                    validate_email = false;
                } else {
                    login_textinput_email.setError("");
                    validate_email = true;
                }

                if (validate_password == true && validate_email == true) {
                    login_button_login.setEnabled(true);
                } else {
                    login_button_login.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        login_textinput_password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = login_textinput_password.getEditText().getText().toString().trim();

                if (password.isEmpty()) {
                    login_textinput_password.setError("Please fill the email column");
                    validate_password = false;
                } else {
                    login_textinput_password.setError("");
                    validate_password = true;
                }

                if (validate_password == true && validate_email == true) {
                    login_button_login.setEnabled(true);
                } else {
                    login_button_login.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}