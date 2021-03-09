package com.example.ecole_en_ligne;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //-------------------identification---------------------------------------
        Button inscription = (Button) findViewById(R.id.inscription);
        Button connexion = (Button) findViewById(R.id.connexion);
        TextView propos = (TextView) findViewById(R.id.aPropos);
        TextView contact = (TextView) findViewById(R.id.contact);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);



        //----------------------Liste déroulante---------------------------------
        List classes = new ArrayList();
        classes.add(("--Choisissez une classe--"));
        classes.add("CP");
        classes.add("CE1");
        classes.add("CE2");
        classes.add("CM1");
        classes.add("CM2");

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                classes
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


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
                Toast.makeText(getApplicationContext(),R.string.aPropos,Toast.LENGTH_SHORT).show();
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri num = Uri.parse("tel: 01 23 45 67 89");
                Intent appel = new Intent(Intent.ACTION_DIAL,num);
                startActivity(appel);

            }
        });




    }
}