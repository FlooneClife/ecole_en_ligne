package com.example.ecole_en_ligne;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MdpOublie extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mdp_oublie);

        Button envoyer = (Button) findViewById(R.id.envoyer);
        ImageView retour = (ImageView) findViewById(R.id.retour);
        //EditText mail = (EditText) findViewById(R.id.mail);
        //int code_envoie  = (int) (Math.random() * ( 500000 - 100000 ));

        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{mail.getText().toString()});
                email.putExtra(Intent.EXTRA_SUBJECT, "Ecole en ligne : Code de validation");
                email.putExtra(Intent.EXTRA_TEXT, "Bonjour,\n\nVeuillez entrer ce code de validation dans le champs prévu : " + code_envoie + "\n\nCordialement,\nGroupe Xerneas.");

                try {
                    startActivity(Intent.createChooser(email, "Send mail..."));
                    finish();
                }catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(MdpOublie.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }*/

                Intent redir = new Intent(MdpOublie.this, ValidationCode.class);
                //redir.putExtra("codeValidation",String.valueOf(code_envoie));
                startActivity(redir);
            }
        });


        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
