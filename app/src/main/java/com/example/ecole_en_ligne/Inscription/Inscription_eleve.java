package com.example.ecole_en_ligne.Inscription;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.ecole_en_ligne.Common_bdd;
import com.example.ecole_en_ligne.Eleve;
import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.util.ActionUtil;

public class Inscription_eleve extends AppCompatActivity {

    private EditText nom;
    private EditText prenom;
    private EditText login;
    private EditText mdp;
    private EditText mail;
    private Button valider;
    private ImageView retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription_eleve);


        //----------------------------------------------Element du Layout--------------------------------------------------

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        login = findViewById(R.id.login);
        mdp = findViewById(R.id.mdp);
        mail = findViewById(R.id.mail);
        valider = findViewById(R.id.valider);
        retour = findViewById(R.id.retour);


        //----------------------------------------------------Actions------------------------------------------------------
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Ajoute un eleve a la base de donnée puis passe a la page connexion
                if(
                    ActionUtil.verifEmptyEdit(Inscription_eleve.this, nom) |
                    ActionUtil.verifEmptyEdit(Inscription_eleve.this, prenom) |
                    ActionUtil.verifEmptyEdit(Inscription_eleve.this, login) |
                    ActionUtil.verifEmptyEdit(Inscription_eleve.this, mdp) |
                    ActionUtil.verifEmptyEdit(Inscription_eleve.this, mail)
                ) {
                    Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs.", Toast.LENGTH_SHORT).show();
                } else {
                    Common_bdd.addEleve(new Eleve(
                            nom.getText().toString(),
                            prenom.getText().toString(),
                            login.getText().toString(),
                            mdp.getText().toString(),
                            mail.getText().toString()));
                    Intent connexion = new Intent(Inscription_eleve.this, ValidationInscription.class);
                    startActivity(connexion);
                    finish();
                }
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
