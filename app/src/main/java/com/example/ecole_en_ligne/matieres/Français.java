package com.example.ecole_en_ligne.matieres;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.R;

public class Français extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.francais);

        Button valider = (Button) findViewById(R.id.valider);
        ImageView retour = (ImageView) findViewById(R.id.retour);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Button valider2 = (Button) findViewById(R.id.valider2);
        EditText rep = (EditText) findViewById(R.id.reponseQ2) ;
        TextView t2 = (TextView) findViewById(R.id.erreur2);

        valider2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (rep.getText().toString().equals("étais")){
                    //message bonne reponse
                    t2.setText("Votre réponse est correcte, félicitations !");
                    t2.setTextColor(R.color.x_blue100);
                }else{
                    //message mauvaise réponse
                    t2.setText("Votre réponse est fausse, réessayez !");
                    t2.setTextColor(R.color.errorRed);
                }
            }
        });



    }
}
