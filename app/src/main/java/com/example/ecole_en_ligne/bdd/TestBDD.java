package com.example.ecole_en_ligne.bdd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ecole_en_ligne.R;

public class TestBDD extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_bdd);
        txt = findViewById(R.id.text);

        Manager m1 = new Manager(this);
        EleveManager m2 = new EleveManager(this);
        m1.open();
        m2.open();

        m1.addAnimal(new Test(1,"maya"));
        m2.addEleve(new Eleve("nom", "prenom","login","mdp","email","formule","nivScol","anneeScol"));

//        System.out.println(m2.getEleve("login"));
// modification du nom de l'animal dont l'id est 1
//        Test a=m.getAnimal(1);
//        a.setNom("toto");
//        m.modAnimal(a);

// suppression
//        m.supAnimal(a);

// Listing des enregistrements de la table
        Cursor c1 = m1.getAnimaux();
        Cursor c2 = m2.getAllEleve();
//        txt.setText("test");
        if (c1.moveToFirst())
        {
            System.out.println("HERE");
            txt.setText(c2.getString(c2.getColumnIndex(EleveManager.ELEVE_LOGIN)));
//            txt.setText(c1.getString(c1.getColumnIndex(Manager.KEY_ID_ANIMAL)) + ",\" +\n" + c1.getString(c1.getColumnIndex(Manager.KEY_NOM_ANIMAL)));
        }
        c1.close(); // fermeture du curseur
        c2.close(); // fermeture du curseur

// fermeture du gestionnaire
        m1.close();
        m2.close();

    }

}