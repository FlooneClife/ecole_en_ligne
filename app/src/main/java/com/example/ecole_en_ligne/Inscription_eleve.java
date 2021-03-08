package com.example.ecole_en_ligne;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Inscription_eleve extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout inscription_eleve = new LinearLayout(this);
        inscription_eleve.setOrientation(LinearLayout.VERTICAL);


        //----------------------------------------------Element du Layout--------------------------------------------------
        TextView Saisie = new TextView(this);
        EditText nom = new EditText(this);
        EditText prenom = new EditText(this);
        EditText login = new EditText(this);
        EditText mdp = new EditText(this);
        EditText mail = new EditText(this);
        Button valider = new Button(this);
        Button retour = new Button(this);

        Saisie.setText(R.string.donnees);
        Saisie.setGravity(View.TEXT_ALIGNMENT_CENTER);
        nom.setHint(R.string.nom);
        prenom.setHint(R.string.prenom);
        login.setHint(R.string.login);
        mdp.setHint(R.string.mdp);
        mail.setHint(R.string.mail);
        retour.setText(R.string.retour);
        valider.setText(R.string.valider);

        inscription_eleve.addView(Saisie);
        inscription_eleve.addView(nom);
        inscription_eleve.addView(prenom);
        inscription_eleve.addView(login);
        inscription_eleve.addView(mdp);
        inscription_eleve.addView(mail);
        inscription_eleve.addView(valider);
        inscription_eleve.addView(retour);

        setContentView(inscription_eleve);


        //----------------------------------------------------Actions------------------------------------------------------

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retour = new Intent(Inscription_eleve.this, Indentification_inscription.class);
                startActivity(retour);
            }
        });

    }
}
