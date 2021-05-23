package com.example.ecole_en_ligne;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ecole_en_ligne.Inscription.Indentification_inscription;
import com.example.ecole_en_ligne.util.ActionUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-------------------identification---------------------------------------
        Button inscription = (Button) findViewById(R.id.inscription);
        ImageView connexion = findViewById(R.id.connexion);
        TextView propos = (TextView) findViewById(R.id.aPropos);
        TextView contact = (TextView) findViewById(R.id.contact);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Button valider = (Button) findViewById(R.id.valider);

        //----------------------Liste déroulante---------------------------------
        List classes = new ArrayList();
        String defaut = "--Choisissez une classe--";
        classes.add(defaut);
        classes.add("6ème");
        classes.add("5ème");
        classes.add("4ème");
        classes.add("3ème");

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                classes
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ClasseAccueil.class);
                if(spinner.getSelectedItem().toString().compareTo("6ème") == 0){
                    i.putExtra("niveauClasse","6ème");
                    startActivity(i);
                }
                if(spinner.getSelectedItem().toString().compareTo("5ème") == 0){
                    i.putExtra("niveauClasse","5ème");
                    startActivity(i);
                }
                if(spinner.getSelectedItem().toString().compareTo("4ème") == 0){
                    i.putExtra("niveauClasse","4ème");
                    startActivity(i);
                }
                if(spinner.getSelectedItem().toString().compareTo("3ème") == 0){
                    i.putExtra("niveauClasse","3ème");
                    startActivity(i);
                }
            }
        });


        //--------------------------------Bouttons-----------------------------------

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inscription = new Intent(MainActivity.this, Indentification_inscription.class);
                startActivity(inscription);
            }
        });

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connexion = new Intent(MainActivity.this, IndentificationC.class);
                startActivity(connexion);
            }
        });


        //-------------------------Texte clickable------------------------------
        propos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout root = (ConstraintLayout) findViewById(R.id.root_layout);
                ActionUtil.showCyanPopup(MainActivity.this,
                        getResources().getString(R.string.propos),
                        getResources().getString(R.string.aPropos),
                        getResources().getString(R.string.retour),
                        root);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout root = (ConstraintLayout) findViewById(R.id.root_layout);
                ActionUtil.showContactPopup(MainActivity.this, root);
            }
        });

    }

}