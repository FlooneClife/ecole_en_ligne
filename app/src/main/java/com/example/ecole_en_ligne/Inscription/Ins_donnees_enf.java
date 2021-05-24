package com.example.ecole_en_ligne.Inscription;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecole_en_ligne.Common_bdd;
import com.example.ecole_en_ligne.Paiement.Choix_paiement;
import com.example.ecole_en_ligne.bdd.Eleve;
import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.bdd.EleveManager;
import com.example.ecole_en_ligne.bdd.ParentManager;
import com.example.ecole_en_ligne.util.ActionUtil;

import java.util.ArrayList;
import java.util.List;

public class Ins_donnees_enf extends AppCompatActivity {

    private Button suivant;
    private ImageView retour;
    private TextView donneesEnfant;
    private EditText nom_enf;
    private EditText prenom_enf;
    private EditText email_enf;
    private Spinner annee_scol;
    private Spinner lien_parents;
    private Spinner niveau_scol;
    private Spinner formule;
    private int nbEnfRestant;
    private int numEnfCourant;
    private String autoLogin;
    private String autoMdp;
    private String lastLogin;

    private String defaultAnnee;
    private String defaultLien;
    private String defaultNiveau;
    private String defaultFormule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ins_donnees_enf);

        Intent i = getIntent();
        int nb_enf = Integer.parseInt(i.getStringExtra("nb_eleve"));
        int nb_enf_total = Integer.parseInt(i.getStringExtra("nb_eleve_total"));
        String loginParent = i.getStringExtra("loginParent");
        nbEnfRestant = nb_enf - 1;
        numEnfCourant = nb_enf_total - nbEnfRestant;
        lastLogin = i.getStringExtra("loginEleve");

        EleveManager em = new EleveManager(this);
        ParentManager pm = new ParentManager(this);


        //----------------------------------------------Element du Layout--------------------------------------------------
        suivant = findViewById(R.id.valider);
        retour = findViewById(R.id.retour);
        donneesEnfant = findViewById(R.id.donneesEnfant);
        nom_enf = findViewById(R.id.nomEnfant);
        prenom_enf = findViewById(R.id.prenomEnfant);
        email_enf = findViewById(R.id.emailEnfant);
        annee_scol = findViewById(R.id.anneeScolaire);
        lien_parents = findViewById(R.id.lienParentee);
        niveau_scol = findViewById(R.id.niveauScolaire);
        formule = findViewById(R.id.formule);

        donneesEnfant.setText(getString(R.string.donnees_enf) + " " + numEnfCourant);


        //----------------------Listes déroulantes donnees enfants---------------------------------
        List annee = new ArrayList();
        defaultAnnee = "--Choisissez l'année scolaire--";
        annee.add((defaultAnnee));
        annee.add("2018/2019");
        annee.add("2019/2020");
        annee.add("2020/2021");


        ArrayAdapter adapter1 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                annee
        );

        List lien = new ArrayList();
        defaultLien = "--Choisissez un lien de parenté--";
        lien.add((defaultLien));
        lien.add("Parents");
        lien.add("Oncle / Tante");
        lien.add("Parrain / Marraine");
        lien.add("Parents adoptifs");


        ArrayAdapter adapter2 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                lien
        );

        List niveau = new ArrayList();
        defaultNiveau = "--Choisissez un niveau scolaire--";
        niveau.add((defaultNiveau));
        niveau.add("6ème");
        niveau.add("5ème");
        niveau.add("4ème");
        niveau.add("3ème");


        ArrayAdapter adapter3 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                niveau
        );

        List form = new ArrayList();
        defaultFormule = "--Choisissez une formule--";
        form.add((defaultFormule));
        form.add("Un cours par année");
        form.add("Deux cours par année");
        form.add("Trois cours par année");
        form.add("Tout les cours par année");


        ArrayAdapter adapter4 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                form
        );


        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        annee_scol.setAdapter(adapter1);
        lien_parents.setAdapter(adapter2);
        niveau_scol.setAdapter(adapter3);
        formule.setAdapter(adapter4);




        //----------------------------------------------Actions--------------------------------------------------

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                em.open();
                if (
                    ActionUtil.verifEmptyEdit(nom_enf) |
                    ActionUtil.verifEmptyEdit(prenom_enf) |
                    ActionUtil.verifEmptyEdit(email_enf) |
                    ActionUtil.verifEmptySpinner(annee_scol, defaultAnnee) |
                    ActionUtil.verifEmptySpinner(lien_parents, defaultLien) |
                    ActionUtil.verifEmptySpinner(niveau_scol, defaultNiveau) |
                    ActionUtil.verifEmptySpinner(formule, defaultFormule)
                ) {
                    Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs.", Toast.LENGTH_SHORT).show();
                    em.close();
                } else {
                    //generate login (sous la forme nom + 2 premières lettres prénom
                    autoLogin = (nom_enf.getText().toString() + prenom_enf.getText().charAt(0) + prenom_enf.getText().charAt(1)).toLowerCase() + generate2RandomNumber();
                    autoMdp = autoLogin;
                    System.out.println(autoLogin);
                    em.addEleve(new Eleve(nom_enf.getText().toString(),prenom_enf.getText().toString(),autoLogin,autoMdp,email_enf.getText().toString(),formule.getSelectedItem().toString(), niveau_scol.getSelectedItem().toString(), annee_scol.getSelectedItem().toString(), loginParent,""));
                    //--------------
                    if (nbEnfRestant > 0) {
                        //test
                        Intent intent = new Intent(Ins_donnees_enf.this, Ins_donnees_enf.class);
                        intent.putExtra("nb_eleve", String.valueOf(nbEnfRestant));
                        intent.putExtra("nb_eleve_total", String.valueOf(nb_enf_total));
                        intent.putExtra("loginParent", String.valueOf(loginParent));
                        intent.putExtra("loginEleve", String.valueOf(autoLogin));
                        em.close();
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(Ins_donnees_enf.this, Choix_paiement.class);
                        intent.putExtra("loginParent", String.valueOf(loginParent));
                        intent.putExtra("variable", 0);
                        em.close();
                        startActivity(intent);
                    }
                }
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastLogin != null) {
                    em.open();
                    em.suppEleve(em.getEleve(lastLogin));
                    em.close();
                } else {
                    pm.open();
                    pm.suppParent(pm.getParent(loginParent));
                    pm.close();
                }
                finish();
            }
        });
    }

    private int generate2RandomNumber() {
        return (int) Math.random() * 100;
    }

}
