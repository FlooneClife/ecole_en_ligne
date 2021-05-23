package com.example.ecole_en_ligne.Paiement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.Connexion_eleve;
import com.example.ecole_en_ligne.R;

public class Choix_paiement extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix_paiement);

        Button carte = findViewById(R.id.carte);
        Button prelev = findViewById(R.id.prelevement);
        ImageView retour = findViewById(R.id.retour);

        Intent i = getIntent();
        int var = i.getIntExtra("variable", 2);
        System.out.println("Choix :" + var);


        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        carte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent redir = new Intent(Choix_paiement.this, Paiement_carte.class);
                redir.putExtra("loginParent", i.getStringExtra("loginParent"));
                redir.putExtra("loginEleve", i.getStringExtra("loginEleve"));
                redir.putExtra("variable", var);
                startActivity(redir);
            }
        });

        prelev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent redir = new Intent(Choix_paiement.this, Paiement_prelev.class);
                redir.putExtra("loginParent", i.getStringExtra("loginParent"));
                redir.putExtra("loginEleve", i.getStringExtra("loginEleve"));
                redir.putExtra("variable", var);
                startActivity(redir);
            }
        });



    }
}
