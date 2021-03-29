package com.example.ecole_en_ligne;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

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

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
