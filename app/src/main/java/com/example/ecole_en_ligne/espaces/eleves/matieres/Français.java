package com.example.ecole_en_ligne.espaces.eleves.matieres;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.bdd.EleveManager;
import com.example.ecole_en_ligne.bdd.Exercice;
import com.example.ecole_en_ligne.bdd.ExerciceManager;

public class Français extends AppCompatActivity {

    private ExerciceManager exoM;
    private EleveManager em;
    private String myLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.francais);

        Button valider = (Button) findViewById(R.id.valider);
        ImageView retour = (ImageView) findViewById(R.id.retour);
        Intent i = getIntent();
        myLogin = i.getStringExtra("Login");
        exoM = new ExerciceManager(this);
        em = new EleveManager(this);
        exoM.open();
        em.open();
        String loginParent = em.getEleve(myLogin).getLoginParent();

        try {
            Exercice ex = new Exercice(2, myLogin, loginParent, 0);
            exoM.addExercice(ex);
        } catch (SQLiteConstraintException e) {
            System.err.println("L'exercice existe déjà dans la base de données");
        }

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exoM.close();
                em.close();
                finish();
            }
        });

        Button valider2 = (Button) findViewById(R.id.valider2);
        EditText rep = (EditText) findViewById(R.id.reponseQ2) ;
        TextView t2 = (TextView) findViewById(R.id.erreur2);

        if(exoM.getExercice(2).getTermine() == 1) {
            rep.setText("étais");
            rep.setEnabled(false);
            rep.setBackgroundResource(R.drawable.edit_text_greyscale);
            valider2.setEnabled(false);
            valider2.setBackgroundResource(R.drawable.button_greyscale);
        }

        valider2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {   //////exercice id : 2
                if (rep.getText().toString().equals("étais")){
                    //message bonne reponse
                    t2.setText("Votre réponse est correcte, félicitations !");
                    t2.setTextColor(R.color.x_blue100);
                    exoM.aTermine(exoM.getExercice(2));
                    rep.setText("étais");
                    rep.setEnabled(false);
                    rep.setBackgroundResource(R.drawable.edit_text_greyscale);
                    valider2.setEnabled(false);
                    valider2.setBackgroundResource(R.drawable.button_greyscale);
                }else{
                    //message mauvaise réponse
                    t2.setText("Votre réponse est fausse, réessayez !");
                    t2.setTextColor(R.color.errorRed);
                }
            }
        });



    }
}
