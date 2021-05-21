package com.example.ecole_en_ligne.espaces.eleves.matieres;


import android.annotation.SuppressLint;
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

public class Maths extends AppCompatActivity {
    VideoView mVideoView;
    MediaController mediaController;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maths);

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
        CheckBox c3 = (CheckBox) findViewById(R.id.check3);
        TextView t1 = (TextView) findViewById(R.id.erreur1);

        Button valider1 = (Button) findViewById(R.id.valider1);
        valider1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (c1.isChecked() && !c2.isChecked() && !c3.isChecked()){
                    //message bonne reponse
                    t1.setText("Votre réponse est correcte, félicitations !");
                    t1.setTextColor(R.color.x_blue100);
                }else{
                    //message mauvaise réponse
                    t1.setText("Votre réponse est fausse, réessayez !");
                }
            }
        });

        Button valider2 = (Button) findViewById(R.id.valider2);
        EditText rep = (EditText) findViewById(R.id.reponseQ2) ;
        TextView t2 = (TextView) findViewById(R.id.erreur2);

        valider2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (rep.getText().toString().equals("AB2 = AC2 + BC2")){
                    //message bonne reponse
                    t2.setText("Votre réponse est correcte, félicitations !");
                    t2.setTextColor(R.color.x_blue100);
                }else{
                    //message mauvaise réponse
                    t2.setText("Votre réponse est fausse, réessayez !");
                }
            }
        });


    }
}
