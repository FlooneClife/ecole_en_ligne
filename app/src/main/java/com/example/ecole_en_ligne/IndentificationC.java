package com.example.ecole_en_ligne;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IndentificationC extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identification);
        Button eleve = (Button) findViewById(R.id.eleve);
        Button retour = (Button) findViewById(R.id.retour);
        Button parent = (Button) findViewById(R.id.parent);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retour = new Intent(IndentificationC.this,MainActivity.class);
                startActivity(retour);
            }
        });

        eleve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eleve = new Intent(IndentificationC.this,Connexion_eleve.class);
                startActivity(eleve);
            }
        });

        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent parent = new Intent(IndentificationC.this,Connexion_parent.class);
                startActivity(parent);
            }
        });



    }
}
