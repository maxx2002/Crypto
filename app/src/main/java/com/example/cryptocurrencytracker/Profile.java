package com.example.cryptocurrencytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private ImageView profile_image_back;
    private TextView profile_text_username, profile_text_email;
    private Button profile_button_price, profile_button_graph, profile_button_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_text_email = findViewById(R.id.profile_text_email);
        profile_text_username = findViewById(R.id.profile_text_username);
        profile_image_back = findViewById(R.id.profile_image_back);
        profile_button_price = findViewById(R.id.profile_button_price);
        profile_button_graph = findViewById(R.id.profile_button_graph);
        profile_button_logout = findViewById(R.id.profile_button_logout);

        profile_button_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        profile_image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        profile_button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}