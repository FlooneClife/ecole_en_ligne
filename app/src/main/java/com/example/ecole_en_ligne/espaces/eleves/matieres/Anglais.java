package com.example.ecole_en_ligne.espaces.eleves.matieres;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.espaces.eleves.EspaceEleve;

public class Anglais extends AppCompatActivity {

    private Intent i;
    private String myLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anglais);

        Button valider = (Button) findViewById(R.id.valider);
        ImageView retour = (ImageView) findViewById(R.id.retour);
        i = getIntent();
        myLogin = i.getStringExtra("Login");

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
