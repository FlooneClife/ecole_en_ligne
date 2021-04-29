package com.example.ecole_en_ligne.Inscription;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.IndentificationC;
import com.example.ecole_en_ligne.MainActivity;
import com.example.ecole_en_ligne.R;

public class ValidationInscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validation_inscription);

        Button acceuil = (Button) findViewById(R.id.acceuil);
        Button connexion = (Button) findViewById(R.id.connexion);

        acceuil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connexion = new Intent(ValidationInscription.this, MainActivity.class);
                startActivity(connexion);
                finish();
            }
        });

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connexion = new Intent(ValidationInscription.this, IndentificationC.class);
                startActivity(connexion);
                finish();
            }
        });

    }


}
