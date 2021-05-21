package com.example.ecole_en_ligne.Paiement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.Inscription.ValidationInscription;
import com.example.ecole_en_ligne.R;

public class Paiement_prelev extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paiement_prelev);

        ImageView retour = findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button valider = findViewById(R.id.valider);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent redir = new Intent(Paiement_prelev.this, ValidationInscription.class);
                startActivity(redir);
                finish();
            }
        });


    }
}
