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

        Intent i = getIntent();
        int var = i.getIntExtra("variable", 2);
        System.out.println("Prelev :" + var);

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
                redir.putExtra("loginParent", i.getStringExtra("loginParent"));
                redir.putExtra("loginEleve", i.getStringExtra("loginEleve"));
                redir.putExtra("variable", var);
                startActivity(redir);
                finish();
            }
        });


    }
}
