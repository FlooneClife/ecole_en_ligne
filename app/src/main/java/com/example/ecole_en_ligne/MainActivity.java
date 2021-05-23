package com.example.ecole_en_ligne;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ecole_en_ligne.Inscription.Indentification_inscription;
import com.example.ecole_en_ligne.bdd.EleveManager;
import com.example.ecole_en_ligne.classes.Cinquieme;
import com.example.ecole_en_ligne.classes.Quatrieme;
import com.example.ecole_en_ligne.classes.Sixieme;
import com.example.ecole_en_ligne.classes.Troisieme;
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
        classes.add(("--Choisissez une classe--"));
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
                if(spinner.getSelectedItem().toString().compareTo("6ème") == 0){
                    Intent six = new Intent(MainActivity.this, Sixieme.class);
                    six.putExtra("niveauClasse","6ème");
                    startActivity(six);
                }
                if(spinner.getSelectedItem().toString().compareTo("5ème") == 0){
                    Intent cinq = new Intent(MainActivity.this, Cinquieme.class);
                    cinq.putExtra("niveauClasse","5ème");
                    startActivity(cinq);
                }
                if(spinner.getSelectedItem().toString().compareTo("4ème") == 0){
                    Intent quatre = new Intent(MainActivity.this, Quatrieme.class);
                    quatre.putExtra("niveauClasse","4ème");
                    startActivity(quatre);
                }
                if(spinner.getSelectedItem().toString().compareTo("3ème") == 0){
                    Intent trois = new Intent(MainActivity.this, Troisieme.class);
                    trois.putExtra("niveauClasse","3ème");
                    startActivity(trois);
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
                ActionUtil.showOrangePopup(MainActivity.this,
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