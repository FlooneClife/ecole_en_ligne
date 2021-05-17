package com.example.ecole_en_ligne.Inscription;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.Common_bdd;
import com.example.ecole_en_ligne.Eleve;
import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.util.ActionUtil;

import java.util.ArrayList;
import java.util.List;

public class Inscription_eleve extends AppCompatActivity {

    private EditText nom;
    private EditText prenom;
    private EditText login;
    private EditText mdp;
    private EditText mail;
    private Button valider;
    private ImageView retour;
    private Spinner annee_scol;
    private Spinner niveau_scol;
    private Spinner formule;

    private String defaultAnnee;
    private String defaultNiveau;
    private String defaultFormule;

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
        annee_scol = findViewById(R.id.anneeScolaire);
        niveau_scol = findViewById(R.id.niveauScolaire);
        formule = findViewById(R.id.formule);


        //----------------------Listes déroulantes---------------------------------
        List annee = new ArrayList();
        defaultAnnee = "--Choisissez l'année scolaire--";
        annee.add((defaultAnnee));
        annee.add("2018/2019");
        annee.add("2019/2020");
        annee.add("2020/2021");


        ArrayAdapter adapter1 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                annee
        );


        List niveau = new ArrayList();
        defaultNiveau = "--Choisissez un niveau scolaire--";
        niveau.add((defaultNiveau));
        niveau.add("6ème");
        niveau.add("5ème");
        niveau.add("4ème");
        niveau.add("3ème");


        ArrayAdapter adapter3 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                niveau
        );

        List form = new ArrayList();
        defaultFormule = "--Choisissez une formule--";
        form.add((defaultFormule));
        form.add("Un cours par année");
        form.add("Deux cours par année");
        form.add("Trois cours par année");
        form.add("Tout les cours par année");


        ArrayAdapter adapter4 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                form
        );


        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        annee_scol.setAdapter(adapter1);
        niveau_scol.setAdapter(adapter3);
        formule.setAdapter(adapter4);



        //----------------------------------------------------Actions------------------------------------------------------
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Ajoute un eleve a la base de donnée puis passe a la page connexion
                if(
                    ActionUtil.verifEmptyEdit(nom) |
                    ActionUtil.verifEmptyEdit(prenom) |
                    ActionUtil.verifEmptyEdit(login) |
                    ActionUtil.verifEmptyEdit(mdp) |
                    ActionUtil.verifEmailFormat(mail)|
                    ActionUtil.verifEmptySpinner(annee_scol, defaultAnnee) |
                    ActionUtil.verifEmptySpinner(niveau_scol, defaultNiveau) |
                    ActionUtil.verifEmptySpinner(formule, defaultFormule)
                ) {
                    Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs.", Toast.LENGTH_SHORT).show();
                } else {
                    Common_bdd.addEleve(new Eleve(nom.getText().toString(),
                                                  prenom.getText().toString(),
                                                  login.getText().toString(),
                                                  mdp.getText().toString(),
                                                  mail.getText().toString(),
                                                  formule.getSelectedItem().toString(),
                                                  niveau_scol.getSelectedItem().toString(),
                                                  annee_scol.getSelectedItem().toString()));
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
