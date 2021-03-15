package com.example.ecole_en_ligne;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Inscription_parent extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout inscription_parent = new LinearLayout(this);
        inscription_parent.setOrientation(LinearLayout.VERTICAL);



        //----------------------------------------------Element du Layout--------------------------------------------------
        TextView Saisie = new TextView(this);
        EditText nom = new EditText(this);
        EditText prenom = new EditText(this);
        EditText login = new EditText(this);
        EditText mdp = new EditText(this);
        EditText mail = new EditText(this);
        EditText nb_eleve = new EditText(this);


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
        nb_eleve.setGravity(View.TEXT_ALIGNMENT_CENTER);
        nb_eleve.setHint(R.string.nb_enfant);
        nb_eleve.setInputType(InputType.TYPE_CLASS_NUMBER);

        inscription_parent.addView(Saisie);
        inscription_parent.addView(nom);
        inscription_parent.addView(prenom);
        inscription_parent.addView(login);
        inscription_parent.addView(mdp);
        inscription_parent.addView(mail);
        inscription_parent.addView(nb_eleve);

        inscription_parent.addView(valider);
        inscription_parent.addView(retour);

        setContentView(inscription_parent);

        //----------------------------------------------------Actions------------------------------------------------------

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donnees_enf = new Intent(Inscription_parent.this, Ins_donnees_enf.class);
                donnees_enf.putExtra("nb_eleve",nb_eleve.getText().toString());
                startActivity(donnees_enf);
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
