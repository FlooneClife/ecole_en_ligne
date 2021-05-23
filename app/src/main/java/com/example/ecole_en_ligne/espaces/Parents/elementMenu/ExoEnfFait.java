package com.example.ecole_en_ligne.espaces.Parents.elementMenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.bdd.ExerciceManager;


public class ExoEnfFait extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enf_exo_fait);

        Intent i =getIntent();

        TextView loginName = findViewById(R.id.loginName);
        loginName.setText(" " + i.getStringExtra("login"));

        TextView texte = findViewById(R.id.texte_exo_fait);

        String text ="";

        ExerciceManager exM = new ExerciceManager(this);

        exM.open();
        int nbExoFait = exM.nbExosFait(i.getStringExtra("loginEleve"));
        int nbExoTotal = exM.nbExosTotal(i.getStringExtra("loginEleve"));
        exM.close();

        text += "Exercice effectué : " + nbExoFait + "/"+nbExoTotal;

        texte.setText(text);



    }
}
