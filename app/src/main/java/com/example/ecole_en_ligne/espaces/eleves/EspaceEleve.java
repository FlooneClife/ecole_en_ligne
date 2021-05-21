package com.example.ecole_en_ligne.espaces.eleves;

import android.content.Intent;
import android.os.Bundle;

import com.example.ecole_en_ligne.espaces.Parents.EspaceParents;
import com.example.ecole_en_ligne.espaces.eleves.ListeTableauBord.MesMatieres;
import com.example.ecole_en_ligne.espaces.eleves.ListeTableauBord.MesRappels;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Activites;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.CoursLive;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Cours_Exos;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Progression;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Recommandation;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ecole_en_ligne.R;

public class EspaceEleve extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView menu;
    ImageView deco;
    TextView loginName;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_eleve);

        i = getIntent();
        loginName = findViewById(R.id.loginName);

        navigationView = findViewById(R.id.navigation);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);

        loginName.setText(" " + i.getStringExtra("Login"));

        menu = findViewById(R.id.menu);
        deco = findViewById(R.id.deconnexion);

        deco.setOnClickListener(new View.OnClickListener() {
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

        //------------------------------LISTE PROFIL------------------------------

        String[] profil = new String[] {
                "Mes matières",
                "Mes résultats",
                "Récapitulatifs d'inscription",
                "Mes rappels",
                "Tchat"
        };

        ListView listP = (ListView) findViewById(R.id.liste_profilE);
        final ArrayAdapter<String> adapterP = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, profil);
        listP.setAdapter(adapterP);


        listP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick (AdapterView<?> adapter, View view, int position, long arg){
                    if (position == 0){
                        Intent redir = new Intent(EspaceEleve.this, MesMatieres.class);
                        redir.putExtra("Login",i.getStringExtra("Login"));
                        startActivity(redir);
                    }else if (position == 3){
                        Intent redir = new Intent(EspaceEleve.this, MesRappels.class);
                        redir.putExtra("Login",i.getStringExtra("Login"));
                        startActivity(redir);
                    }else if (position == 4){
                        Intent redir = new Intent(EspaceEleve.this, MesMatieres.class);
                        redir.putExtra("Login",i.getStringExtra("Login"));
                        startActivity(redir);
                    }

                }
            }
        );


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        ////TODO rediriger sur la page correspondante au bouton
        switch (item.getItemId()) {
            case R.id.tableau_bord: {
                //ouvrir page des cours et des exercices
                Intent redir = new Intent(EspaceEleve.this, EspaceEleve.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                break;
            }

            case R.id.cours_exos: {
                //ouvrir page des cours et des exercices
                Intent redir = new Intent(EspaceEleve.this, Cours_Exos.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                break;
            }
            case R.id.cours_live: {
                //ouvrir page des rappels de cours
                Intent redir = new Intent(EspaceEleve.this, CoursLive.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                break;
            }
            case R.id.recommandations: {
                //ouvrir page des recommandations
                Intent redir = new Intent(EspaceEleve.this, Recommandation.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                break;
            }
            case R.id.progression: {
                //ouvrir page des progressions et courbes
                Intent redir = new Intent(EspaceEleve.this, Progression.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                break;
            }
            case R.id.activites: {
                //ouvrir page des dernières activites
                Intent redir = new Intent(EspaceEleve.this, Activites.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                break;
            }
            case R.id.deconnexion: {
                finish();
                break;
            }
        }
        //close navigation drawer
        drawerLayout.closeDrawers();
        return true;
    }
}
