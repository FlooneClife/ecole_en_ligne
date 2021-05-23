package com.example.ecole_en_ligne.espaces.eleves.matieres;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.media.session.MediaController;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.bdd.EleveManager;
import com.example.ecole_en_ligne.bdd.Exercice;
import com.example.ecole_en_ligne.bdd.ExerciceManager;

public class Maths extends AppCompatActivity {

    private ExerciceManager exoM;
    private EleveManager em;
    private String myLogin;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maths);

        Intent i = getIntent();
        myLogin = i.getStringExtra("Login");

        exoM = new ExerciceManager(this);
        em = new EleveManager(this);
        exoM.open();
        em.open();
        String loginParent = em.getEleve(myLogin).getLoginParent();

        try {
            Exercice ex1 = new Exercice(0, myLogin, loginParent, 0);
            Exercice ex2 = new Exercice(1, myLogin, loginParent, 0);
            exoM.addExercice(ex1);
            exoM.addExercice(ex2);
        } catch (SQLiteConstraintException e) {
            System.err.println("L'exercice existe déjà dans la base de données");
        }


        ImageView retour = (ImageView) findViewById(R.id.retour);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exoM.close();
                em.close();
                finish();
            }
        });

        //-----------VALIDATION REPONSES-----------

        CheckBox c1 = (CheckBox) findViewById(R.id.check1);
        CheckBox c2 = (CheckBox) findViewById(R.id.check2);
        CheckBox c3 = (CheckBox) findViewById(R.id.check3);
        TextView t1 = (TextView) findViewById(R.id.erreur1);

        Button valider1 = (Button) findViewById(R.id.valider1);

        if(exoM.getExercice(0).getTermine() == 1) {
            c1.setChecked(true);
            c1.setEnabled(false);
            c2.setChecked(false);
            c2.setEnabled(false);
            c3.setChecked(false);
            c3.setEnabled(false);
            valider1.setEnabled(false);
            valider1.setBackgroundResource(R.drawable.button_greyscale);
        }

        valider1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {   ////exercice id 0
                if (c1.isChecked() && !c2.isChecked() && !c3.isChecked()){
                    //message bonne reponse
                    t1.setText("Votre réponse est correcte, félicitations !");
                    t1.setTextColor(R.color.x_blue100);
                    exoM.aTermine(exoM.getExercice(0));
                    c1.setChecked(true);
                    c1.setEnabled(false);
                    c2.setChecked(false);
                    c2.setEnabled(false);
                    c3.setChecked(false);
                    c3.setEnabled(false);
                    valider1.setEnabled(false);
                    valider1.setBackgroundResource(R.drawable.button_greyscale);
                }else{
                    //message mauvaise réponse
                    t1.setText("Votre réponse est fausse, réessayez !");
                }
            }
        });

        Button valider2 = (Button) findViewById(R.id.valider2);
        EditText rep = (EditText) findViewById(R.id.reponseQ2) ;
        TextView t2 = (TextView) findViewById(R.id.erreur2);

        if(exoM.getExercice(1).getTermine() == 1) {
            rep.setText("AB² = AC² + BC²");
            rep.setBackgroundResource(R.drawable.edit_text_greyscale);
            valider2.setEnabled(false);
            valider2.setBackgroundResource(R.drawable.button_greyscale);
        }

        valider2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {   ////exercice id 1
                if (rep.getText().toString().replaceAll("\\s+","").equalsIgnoreCase("AB² = AC² + BC²".replaceAll("\\s+",""))){
                    //message bonne reponse
                    t2.setText("Votre réponse est correcte, félicitations !");
                    t2.setTextColor(R.color.x_blue100);
                    exoM.aTermine(exoM.getExercice(1));
                    rep.setText("AB² = AC² + BC²");
                    rep.setEnabled(false);
                    rep.setBackgroundResource(R.drawable.edit_text_greyscale);
                    valider2.setEnabled(false);
                    valider2.setBackgroundResource(R.drawable.button_greyscale);
                }else{
                    //message mauvaise réponse
                    t2.setText("Votre réponse est fausse, réessayez !");
                }
            }
        });


    }
}
