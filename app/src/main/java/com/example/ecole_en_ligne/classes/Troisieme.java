package com.example.ecole_en_ligne.classes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.ecole_en_ligne.IndentificationC;
import com.example.ecole_en_ligne.Inscription.Indentification_inscription;
import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.util.ActionUtil;

public class Troisieme extends AppCompatActivity {

    private TextView title;
    ImageView retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matieres);

        Button connexion = (Button) findViewById(R.id.connexion);
        Button inscription = (Button) findViewById(R.id.inscription);
        TextView propos = (TextView) findViewById(R.id.aPropos);
        TextView contact = (TextView) findViewById(R.id.contact);
        TextView sixiemeC = (TextView) findViewById(R.id.classeSixieme);
        title = findViewById(R.id.titleClasse);
        title.setText(R.string.classe3e);
        retour = findViewById(R.id.retour);
        
        Intent i = getIntent();

        sixiemeC.setText("Nos Classes : " + i.getStringExtra("niveauClasse"));

        ListView Mat = (ListView) findViewById(R.id.listeMatieres);
        String[] matieres = new String[]{getString(R.string.Maths),getString(R.string.Histoire_geo),getString(R.string.Francais), getString(R.string.SVT),getString(R.string.physique),getString(R.string.Langue_viv1),getString(R.string.Langue_viv2),getString(R.string.techno)};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, matieres);
        Mat.setAdapter(adapter);



        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connexion = new Intent(Troisieme.this, IndentificationC.class);
                startActivity(connexion);
            }
        });

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connexion = new Intent(Troisieme.this, Indentification_inscription.class);
                startActivity(connexion);
            }
        });

        propos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout root = (ConstraintLayout) findViewById(R.id.root_layout);
                ActionUtil.showOrangePopup(Troisieme.this,
                        getResources().getString(R.string.propos),
                        getResources().getString(R.string.aPropos),
                        getResources().getString(R.string.retour),
                        root);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout root = (ConstraintLayout) findViewById(R.id.root_layout);
                ActionUtil.showContactPopup(Troisieme.this,
                        root);
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
