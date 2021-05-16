package com.example.ecole_en_ligne.Inscription;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.util.ActionUtil;

public class Inscription_parent extends AppCompatActivity {

    private EditText nom;
    private EditText prenom;
    private EditText login;
    private EditText mdp;
    private EditText mail;
    private EditText nb_eleve;
    private Button valider;
    private ImageView retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription_parent);



        //----------------------------------------------Element du Layout--------------------------------------------------
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        login = findViewById(R.id.login);
        mdp = findViewById(R.id.mdp);
        mail = findViewById(R.id.mail);
        valider = findViewById(R.id.valider);
        retour = findViewById(R.id.retour);
        nb_eleve = findViewById(R.id.enfants);

        //----------------------------------------------------Actions------------------------------------------------------

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(
                    ActionUtil.verifEmptyEdit(nom) |
                    ActionUtil.verifEmptyEdit(prenom) |
                    ActionUtil.verifEmptyEdit(login) |
                    ActionUtil.verifEmptyEdit(mdp) |
                    ActionUtil.verifEmailFormat(mail) |
                    ActionUtil.verifEmptyEdit(nb_eleve)
                ) {
                    Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent donnees_enf = new Intent(Inscription_parent.this, Ins_donnees_enf.class);
                    donnees_enf.putExtra("nb_eleve",nb_eleve.getText().toString());
                    donnees_enf.putExtra("nb_eleve_total",nb_eleve.getText().toString());
                    startActivity(donnees_enf);
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
