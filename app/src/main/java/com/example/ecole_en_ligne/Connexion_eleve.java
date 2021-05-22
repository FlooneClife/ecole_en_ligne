package com.example.ecole_en_ligne;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.bdd.EleveManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Connexion_eleve extends AppCompatActivity {

    ImageView retour;
    Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion_eleve);

        retour = findViewById(R.id.retour);
        valider = findViewById(R.id.valider);
        TextView mdpOublie = (TextView) findViewById(R.id.forgottenPW);
        EditText login = (EditText) findViewById(R.id.login);
        EditText mdp = (EditText) findViewById(R.id.mdp);
        TextView erreurCo = (TextView) findViewById(R.id.erreur);

        EleveManager em = new EleveManager(this);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mdpOublie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent redir = new Intent(Connexion_eleve.this, MdpOublie.class);
                startActivity(redir);
            }
        });

        valider.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                em.open();
                if (em.peutSeCo(login.getText().toString(),mdp.getText().toString())){
                    java.util.Date date=new java.util.Date();
                    System.out.println(date);
                    em.modDate(login.getText().toString(), String.valueOf(date));
                    login.setBackgroundResource(R.drawable.edit_text);
                    mdp.setBackgroundResource(R.drawable.edit_text);
                    Intent espace = new Intent(Connexion_eleve.this, com.example.ecole_en_ligne.espaces.eleves.EspaceEleve.class);
                    espace.putExtra("Login",login.getText().toString());
                    em.close();
                    startActivity(espace);
                }else{
                    erreurCo.setText("Mot de passe ou login incorrecte, veuillez réessayer.");
                    login.setBackgroundResource(R.drawable.edit_text_error);
                    mdp.setBackgroundResource(R.drawable.edit_text_error);
                    em.close();
                }
            }
        });

    }
}
