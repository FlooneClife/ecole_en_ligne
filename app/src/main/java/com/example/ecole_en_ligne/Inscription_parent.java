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

        TextView nb_eleve = new TextView(this);
        EditText nb = new EditText(this);

        TextView eleve = new TextView(this);
        EditText nom_eleve = new EditText(this);
        EditText prenom_eleve = new EditText(this);
        EditText lien_parente = new EditText(this);
        EditText niveau_scolaire_eleve = new EditText(this);


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
        nb_eleve.setText(R.string.nb_enfant);
        nb_eleve.setGravity(View.TEXT_ALIGNMENT_CENTER);
        nb.setHint(R.string.nb);
        nb.setInputType(InputType.TYPE_CLASS_NUMBER);

        inscription_parent.addView(Saisie);
        inscription_parent.addView(nom);
        inscription_parent.addView(prenom);
        inscription_parent.addView(login);
        inscription_parent.addView(mdp);
        inscription_parent.addView(mail);
        inscription_parent.addView(nb_eleve);
        inscription_parent.addView(nb);


        //--------------------------Boucle nombre d'eleve----------------
        /*if (nb_eleve != null){
            int nbEleve = Integer.parseInt(nb.getText().toString());
            for (int i = 0; i<nbEleve;i++){
                eleve.setText("----- Eleve n°"+(i+1)+" -----");
                eleve.setGravity(View.TEXT_ALIGNMENT_CENTER);
                nom_eleve.setHint(R.string.nom);
                prenom_eleve.setHint(R.string.prenom);
                lien_parente.setHint(R.string.lien);
                niveau_scolaire_eleve.setHint(R.string.niveauxScol);

                inscription_parent.addView(eleve);
                inscription_parent.addView(nom_eleve);
                inscription_parent.addView(prenom_eleve);
                inscription_parent.addView(lien_parente);
                inscription_parent.addView(niveau_scolaire_eleve);
            }
        }
        */
        //----------------------------------------------------------------

        inscription_parent.addView(valider);
        inscription_parent.addView(retour);

        setContentView(inscription_parent);

        //----------------------------------------------------Actions------------------------------------------------------

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
