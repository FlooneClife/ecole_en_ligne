package com.example.ecole_en_ligne.matieres;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.R;

public class Histoire extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.histoire);

        Button valider = (Button) findViewById(R.id.valider);
        ImageView retour = (ImageView) findViewById(R.id.retour);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //-----------VALIDATION REPONSES-----------

        CheckBox c1 = (CheckBox) findViewById(R.id.check1);
        CheckBox c2 = (CheckBox) findViewById(R.id.check2);
        TextView t1 = (TextView) findViewById(R.id.erreur1);

        Button valider1 = (Button) findViewById(R.id.valider1);
        valider1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (c1.isChecked() && !c2.isChecked()){
                    //message bonne reponse
                    t1.setText("Votre réponse est correcte, félicitations !");
                    t1.setTextColor(R.color.x_blue100);
                }else{
                    //message mauvaise réponse
                    t1.setText("Votre réponse est fausse, réessayez !");
                    t1.setTextColor(R.color.errorRed);
                }
            }
        });



    }
}
