package com.example.ecole_en_ligne.espaces.Parents.elementMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecole_en_ligne.MainActivity;
import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.bdd.Rappels;
import com.example.ecole_en_ligne.bdd.RappelsManager;
import com.example.ecole_en_ligne.espaces.Parents.EspaceParents;
import com.example.ecole_en_ligne.espaces.Parents.ProfilParent;
import com.example.ecole_en_ligne.espaces.Parents.SuiviEnfantI;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class DefinitionRappels extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private TextView loginName;
    private ImageView menu;
    private ImageView retour;
    private Intent i;

    private RappelsManager rm;

    private TextView listRappels;
    private Button defRappel;
    private Button validerDef;
    private Spinner heure;
    private Spinner minute;
    private String addText;
    private int lastId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rappels_parent);

        i = getIntent();
        loginName = findViewById(R.id.loginName);
        String myLogin = i.getStringExtra("Login");
        String loginEleve = i.getStringExtra("loginEleve");
        loginName.setText(" "+ myLogin);

        listRappels = findViewById(R.id.listeRappels);
        defRappel = findViewById(R.id.definir);
        validerDef = findViewById(R.id.validerDef);
        heure = findViewById(R.id.spinnerHeure);
        minute = findViewById(R.id.spinnerMinute);
        validerDef.setEnabled(false);
        validerDef.setBackgroundResource(R.drawable.button_greyscale);
        heure.setEnabled(false);
        heure.setBackgroundResource(R.drawable.edit_text_greyscale);
        minute.setEnabled(false);
        minute.setBackgroundResource(R.drawable.edit_text_greyscale);

        navigationView = findViewById(R.id.navigation);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView.setNavigationItemSelectedListener(this);

        menu = findViewById(R.id.menu);
        retour = findViewById(R.id.retour);

        List heures = new ArrayList();
        for(int h = 0; h <= 12; h++) {
            if(h < 10) {
                heures.add("0" + h);
            } else {
                heures.add(String.valueOf(h));
            }
        }
        List minutes = new ArrayList();
        for(int m = 0; m <= 12; m++) {
            if(m < 10) {
                minutes.add("0" + m);
            } else {
                minutes.add(String.valueOf(m));
            }
        }
        ArrayAdapter adapterHeure = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                heures
        );
        ArrayAdapter adapterMinute = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                minutes
        );
        adapterHeure.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heure.setAdapter(adapterHeure);
        adapterMinute.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minute.setAdapter(adapterHeure);

        rm = new RappelsManager(this);
        rm.open();
        Cursor c = rm.getAllRappels();
        if(c.moveToFirst()) {
            do {
                addText += c.getString(c.getColumnIndex(RappelsManager.RAPPELS_ELEVE))
                        + " : " + c.getString(c.getColumnIndex(RappelsManager.RAPPELS_HEURE)) + "\n";
                listRappels.setText(addText);
            }
            while (c.moveToNext());
            if(c.moveToLast()) {
                lastId = c.getInt(c.getColumnIndex(RappelsManager.RAPPELS_ID));
            }
        }
        rm.close();

        defRappel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validerDef.setEnabled(true);
                validerDef.setBackgroundResource(R.drawable.button_blue_gradient);
                heure.setEnabled(true);
                heure.setBackgroundResource(R.drawable.edit_text);
                minute.setEnabled(true);
                minute.setBackgroundResource(R.drawable.edit_text);
            }
        });

        validerDef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rm.open();
                lastId++;
                rm.addRappels(new Rappels(lastId, loginEleve, myLogin, (heure.getSelectedItem() + ":" + minute.getSelectedItem())));
                addText += rm.getRappels(lastId).getLoginEleve()
                        + " : " + rm.getRappels(lastId).getHeure() + "\n";
                Toast.makeText(DefinitionRappels.this, "Votre rappel a bien été envoyé à " + loginEleve, Toast.LENGTH_LONG).show();
                listRappels.setText(addText);
                rm.close();
                validerDef.setEnabled(false);
                validerDef.setBackgroundResource(R.drawable.button_greyscale);
                heure.setEnabled(false);
                heure.setBackgroundResource(R.drawable.edit_text_greyscale);
                minute.setEnabled(false);
                minute.setBackgroundResource(R.drawable.edit_text_greyscale);
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(navigationView);
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tableau_bordP: {
                Intent redir = new Intent(getApplicationContext(), EspaceParents.class);
                redir.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }
            case R.id.cours_exos_fait: {
                Intent redir = new Intent(DefinitionRappels.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Cours et Exercices effectués");
                Intent intent = new Intent(getApplicationContext(), EspaceParents.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                break;
            }
            case R.id.momentCO: {
                Intent redir = new Intent(DefinitionRappels.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Moment de connexion");
                Intent intent = new Intent(getApplicationContext(), EspaceParents.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                break;
            }
            case R.id.courbes_progressionP: {
                Intent redir = new Intent(DefinitionRappels.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Courbes de progressions");
                Intent intent = new Intent(getApplicationContext(), EspaceParents.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                break;
            }
            case R.id.recommandationsP: {
                Intent redir = new Intent(DefinitionRappels.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Recommandation");
                Intent intent = new Intent(getApplicationContext(), EspaceParents.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                break;
            }
            case R.id.rappel: {
                break;
            }
            case R.id.profil: {
                Intent redir = new Intent(getApplicationContext(), ProfilParent.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                Intent intent = new Intent(getApplicationContext(), EspaceParents.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                finish();
                break;
            }
            case R.id.deconnexion: {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                break;
            }
        }
        //close navigation drawer
        drawerLayout.closeDrawers();
        return true;
    }
}