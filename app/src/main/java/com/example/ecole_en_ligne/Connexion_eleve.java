package com.example.ecole_en_ligne;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.classes.Sixieme;

import org.w3c.dom.Text;

public class Connexion_eleve extends AppCompatActivity {

    ImageView retour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion_eleve);

        retour = findViewById(R.id.retour);
        TextView mdpOublie = (TextView) findViewById(R.id.forgottenPW);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mdpOublie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent redir = new Intent(Connexion_eleve.this, MdpOublie.class);
                startActivity(redir);
            }
        });





    }
}
