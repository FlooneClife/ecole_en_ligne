package com.example.ecole_en_ligne;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.classes.Sixieme;

import org.w3c.dom.Text;

public class Connexion_parent extends AppCompatActivity {

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

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mdpOublie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent redir = new Intent(Connexion_parent.this, MdpOublie.class);
                startActivity(redir);
            }
        });


        valider.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Common_bdd.peutSeCoParent(login.getText().toString(),mdp.getText().toString())) {
                    login.setBackgroundResource(R.drawable.edit_text);
                    mdp.setBackgroundResource(R.drawable.edit_text);
                    Intent espace = new Intent(Connexion_parent.this, com.example.ecole_en_ligne.espaces.Parents.EspaceParents.class);
                    espace.putExtra("Login",login.getText().toString());
                    startActivity(espace);
                }else{
                    erreurCo.setText("Mot de passe ou login incorrecte, veuillez réessayer.");
                    login.setBackgroundResource(R.drawable.edit_text_error);
                    mdp.setBackgroundResource(R.drawable.edit_text_error);
                }
            }
        });


    }
}
