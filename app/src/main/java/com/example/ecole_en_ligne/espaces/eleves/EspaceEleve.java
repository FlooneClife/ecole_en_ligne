package com.example.ecole_en_ligne.espaces.eleves;

import android.content.Intent;
import android.os.Bundle;

import com.example.ecole_en_ligne.MainActivity;
import com.example.ecole_en_ligne.espaces.eleves.ListeTableauBord.Tchat;
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

    private ImageView menu;
    private ImageView deco;
    private TextView loginName;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Intent i;

    @Override
    public void onBackPressed() {
        // do nothing
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil_eleves);

        i = getIntent();
        loginName = findViewById(R.id.loginName);

        navigationView = findViewById(R.id.navigation);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);

        loginName.setText(" " + i.getStringExtra("Login"));

        menu = findViewById(R.id.menu);
        deco = findViewById(R.id.retour);

        deco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
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
                "Mes cours et exercices",   //0
                "Mes cours en direct",  //1
                "Ma progression",   //2
                "Recommandations",  //3
                "Accéder au tchat"  //4
        };

        ListView listP = (ListView) findViewById(R.id.liste_profilE);
        final ArrayAdapter<String> adapterP = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, profil);
        listP.setAdapter(adapterP);


        listP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick (AdapterView<?> adapter, View view, int position, long arg){
                    switch (position) {
                        case 0 : {
                            Intent redir = new Intent(EspaceEleve.this, Cours_Exos.class);
                            redir.putExtra("Login", i.getStringExtra("Login"));
                            startActivity(redir);
                            break;
                        } case 1 : {
                            Intent redir = new Intent(EspaceEleve.this, CoursLive.class);
                            redir.putExtra("Login", i.getStringExtra("Login"));
                            startActivity(redir);
                            break;
                        } case 2 : {
                            Intent redir = new Intent(EspaceEleve.this, Progression.class);
                            redir.putExtra("Login", i.getStringExtra("Login"));
                            startActivity(redir);
                            break;
                        } case 3 : {
                            Intent redir = new Intent(EspaceEleve.this, Recommandation.class);
                            redir.putExtra("Login", i.getStringExtra("Login"));
                            startActivity(redir);
                            break;
                        } case 4 : {
                            Intent redir = new Intent(EspaceEleve.this, Tchat.class);
                            redir.putExtra("Login", i.getStringExtra("Login"));
                            startActivity(redir);
                            break;
                        }
                    }
                }
            }
        );
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tableau_bord: {
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
