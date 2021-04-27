package com.example.ecole_en_ligne.elementMenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.R;

public class Activites extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activites);

        TextView loginName = findViewById(R.id.loginName);
        Intent i = getIntent();
        loginName.setText(" " + i.getStringExtra("Login"));

    }
}
