package com.example.ecole_en_ligne;

import android.content.Intent;
import android.os.Bundle;
import android.provider.FontRequest;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Ins_donnees_enf extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout donnees = new LinearLayout(this);
        donnees.setOrientation(LinearLayout.VERTICAL);

        Intent i = getIntent();
        int nb_enf = Integer.parseInt(i.getStringExtra("nb_eleve"));

        //----------------------------------------------Element du Layout--------------------------------------------------
        Button suivant = new Button(this);
        Button retour = new Button(this);
        TextView text = new TextView(this);
        EditText nom_enf = new EditText(this);
        EditText prenom_enf = new EditText(this);
        Spinner annee_scol = new Spinner(this);
        Spinner lien_parents = new Spinner(this);
        Spinner niveau_scol = new Spinner(this);
        Spinner formule = new Spinner(this);

        suivant.setText(R.string.Suivant);
        retour.setText(R.string.retour);
        text.setText(R.string.donnees_enf);



        //----------------------Listes déroulantes donnees enfants---------------------------------
        List annee = new ArrayList();
        annee.add(("--Choisissez l'année scolaire--"));
        annee.add("2018/2019");
        annee.add("2019/2020");
        annee.add("2020/2021");


        ArrayAdapter adapter1 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                annee
        );

        List lien = new ArrayList();
        lien.add(("--Choisissez un lien de parenté--"));
        lien.add("Parents");
        lien.add("Oncle / Tante");
        lien.add("Parrain / Marraine");
        lien.add("Parents adoptifs");


        ArrayAdapter adapter2 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                lien
        );

        List niveau = new ArrayList();
        niveau.add(("--Choisissez un niveau scolaire--"));
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
        form.add(("--Choisissez une formule--"));
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
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        annee_scol.setAdapter(adapter1);
        lien_parents.setAdapter(adapter2);
        niveau_scol.setAdapter(adapter3);
        formule.setAdapter(adapter4);


        donnees.addView(text);



        //----------------------------------------------Actions--------------------------------------------------

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });





        donnees.addView(suivant);
        donnees.addView(retour);

        setContentView(donnees);



    }
}
