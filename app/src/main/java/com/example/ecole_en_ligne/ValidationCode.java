package com.example.ecole_en_ligne;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ValidationCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validation_code);

        Button Valider = (Button) findViewById(R.id.valider);
        ImageView retour = (ImageView) findViewById(R.id.retour);
        EditText codeEntre = (EditText) findViewById(R.id.code);
        /*Intent i = getIntent();
        int codeValidation = Integer.parseInt(i.getStringExtra("nb_eleve"));
        TextView erreur = (TextView) findViewById(R.id.erreur);*/

/*
        Valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (codeEntre.getText().toString().contentEquals(String.valueOf(codeValidation))){
                    Intent redir = new Intent(ValidationCode.this, Changer_mdp.class);
                    startActivity(redir);
                }else{
                    erreur.setText("Le code de validation est incorrect."); // à mettre en rouge
                }
            }
        });*/


        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
