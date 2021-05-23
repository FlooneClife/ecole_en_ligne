package com.example.ecole_en_ligne;

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

import com.example.ecole_en_ligne.Inscription.Indentification_inscription;
import com.example.ecole_en_ligne.util.ActionUtil;

public class ClasseAccueil extends AppCompatActivity {

    private TextView title;
    private ImageView retour;
    private ImageView connexion;
    private Button inscription;
    private TextView propos;
    private TextView contact;
    private TextView classe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matieres);

        connexion = (ImageView) findViewById(R.id.connexion);
        inscription = (Button) findViewById(R.id.inscription);
        propos = (TextView) findViewById(R.id.aPropos);
        contact = (TextView) findViewById(R.id.contact);
        classe = (TextView) findViewById(R.id.classe);
        title = (TextView) findViewById(R.id.titleClasse);
        title.setText(R.string.classe6e);
        retour = findViewById(R.id.retour);

        Intent i = getIntent();

        classe.setText("Classe de : " + i.getStringExtra("niveauClasse"));

        ListView Mat = (ListView) findViewById(R.id.listeMatieres);
        String[] matieres = new String[]{getString(R.string.Maths),getString(R.string.Histoire_geo),getString(R.string.Francais), getString(R.string.SVT),getString(R.string.physique),getString(R.string.Langue_viv1),getString(R.string.techno)};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, matieres);
        Mat.setAdapter(adapter);




        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connexion = new Intent(ClasseAccueil.this, IndentificationC.class);
                startActivity(connexion);
                finish();
            }
        });

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connexion = new Intent(ClasseAccueil.this, Indentification_inscription.class);
                startActivity(connexion);
                finish();
            }
        });

        propos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout root = (ConstraintLayout) findViewById(R.id.root_layout);
                ActionUtil.showCyanPopup(ClasseAccueil.this,
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
                ActionUtil.showContactPopup(ClasseAccueil.this,
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
