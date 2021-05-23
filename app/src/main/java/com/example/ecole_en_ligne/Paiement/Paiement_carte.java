package com.example.ecole_en_ligne.Paiement;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.Inscription.ValidationInscription;
import com.example.ecole_en_ligne.MainActivity;
import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.bdd.ParentManager;

import java.util.ArrayList;
import java.util.List;

public class Paiement_carte extends AppCompatActivity {

    private ParentManager pm;
    private String loginParent;
    private String loginEleve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paiement_carte);

        Intent i = getIntent();
        int var = i.getIntExtra("variable", 2);
        pm = new ParentManager(this);
        loginParent = i.getStringExtra("loginParent");
        loginEleve = i.getStringExtra("loginEleve");

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
                Intent redir = new Intent(Paiement_carte.this, ValidationInscription.class);
                redir.putExtra("loginParent", loginParent);
                redir.putExtra("loginEleve", loginEleve);
                redir.putExtra("variable", var);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                finish();   //this page
            }
        });

        Spinner mois = findViewById(R.id.MoisCarte);
        Spinner annee = findViewById(R.id.AnneeCarte);

        List Lannee = new ArrayList();
        Lannee.add(("--Choisissez une année--"));
        Lannee.add("2019");
        Lannee.add("2020");
        Lannee.add("2021");
        Lannee.add("2022");
        Lannee.add("2023");


        ArrayAdapter adapter1 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                Lannee
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        annee.setAdapter(adapter1);

        List Lmois = new ArrayList();
        Lmois.add(("--Choisissez un mois--"));
        Lmois.add("01");
        Lmois.add("02");
        Lmois.add("03");
        Lmois.add("04");
        Lmois.add("05");
        Lmois.add("06");
        Lmois.add("07");
        Lmois.add("08");
        Lmois.add("09");
        Lmois.add("10");
        Lmois.add("11");
        Lmois.add("12");

        ArrayAdapter adapter2 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                Lmois
        );
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mois.setAdapter(adapter2);

    }
}
