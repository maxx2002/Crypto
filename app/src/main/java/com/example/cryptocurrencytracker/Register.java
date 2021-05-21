package com.example.cryptocurrencytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    private TextView register_text_login;
    private TextInputLayout register_textinput_email, register_textinput_username, register_textinput_password;
    private Button register_button_register;
    private Boolean validate_password = false, validate_email = false, validate_username = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_text_login = findViewById(R.id.register_text_login);
        register_textinput_email = findViewById(R.id.register_textinput_email);
        register_textinput_username = findViewById(R.id.register_textinput_username);
        register_textinput_password = findViewById(R.id.register_textinput_password);
        register_button_register = findViewById(R.id.register_button_register);

        register_button_register.setEnabled(false);

        register_text_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Login.class);
                startActivity(intent);
            }
        });

        register_textinput_password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = register_textinput_password.getEditText().getText().toString().trim();

                Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9\\!\\@\\#\\$]{8,24}");

                if(password.isEmpty()) {
                    register_textinput_password.setError("Please fill the password column");
                    validate_password = false;
                } else {
                    if (!PASSWORD_PATTERN.matcher(password).matches()) {
                        register_textinput_password.setError("Password must include uppercase, lowercase, number and symbol");
                        validate_password = false;
                    } else {
                        register_textinput_password.setError("");
                        validate_password = true;
                    }
                }

                if (validate_username == true && validate_email == true && validate_password == true) {
                    register_button_register.setEnabled(true);
                } else {
                    register_button_register.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        register_textinput_email.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = register_textinput_email.getEditText().getText().toString().trim();

                Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("[a-zA-Z0-9+._%-+]{1,256}" + "@"
                        + "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" + "(" + "."
                        + "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" + ")+");

                if(email.isEmpty()) {
                    register_textinput_email.setError("Please fill the email column");
                    validate_email = false;
                } else {
                    if (!EMAIL_ADDRESS_PATTERN.matcher(email).matches()) {
                        register_textinput_email.setError("Wrong email format");
                        validate_email = false;
                    } else {
                        register_textinput_email.setError("");
                        validate_email = true;
                    }
                }

                if (validate_username == true && validate_email == true && validate_password == true) {
                    register_button_register.setEnabled(true);
                } else {
                    register_button_register.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        register_textinput_username.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name = register_textinput_username.getEditText().getText().toString().trim();

                if(name.isEmpty()) {
                    register_textinput_email.setError("Please fill the username column");
                    validate_username = false;
                } else {
                    register_textinput_email.setError("");
                    validate_username = true;
                }

                if (validate_username == true && validate_email == true && validate_password == true) {
                    register_button_register.setEnabled(true);
                } else {
                    register_button_register.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        register_button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"registration was successful",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}