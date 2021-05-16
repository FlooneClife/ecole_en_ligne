package com.example.ecole_en_ligne.espaces.parents;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.elementMenu.Activites;
import com.example.ecole_en_ligne.elementMenu.CoursLive;
import com.example.ecole_en_ligne.elementMenu.Cours_Exos;
import com.example.ecole_en_ligne.elementMenu.Progression;
import com.example.ecole_en_ligne.elementMenu.Recommandation;
import com.example.ecole_en_ligne.espaces.eleves.EspaceEleve;
import com.google.android.material.navigation.NavigationView;

public class EspaceParents extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ImageView menu;
    ImageView deco;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceuil_parents);

        navigationView = findViewById(R.id.navigationP);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layoutP);

        navigationView.setNavigationItemSelectedListener(this);

        menu = findViewById(R.id.menu);
        deco = findViewById(R.id.deconnexion);


        //------------------------------HEADER------------------------------

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
                "Mes enfants",
                "Récapitulatifs d'inscription",
                "Mon abonnement"
        };

        ListView listP = (ListView) findViewById(R.id.liste_profil);
        final ArrayAdapter<String> adapterP = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, profil);
        listP.setAdapter(adapterP);

        //TODO.....
        /*
        listP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick (AdapterView<?> adapter, View view, int position, long arg){
                    if (position == 0){  //Si c'est l'eleve 1 qui est selectionné (se trouve a la position 0 dans la liste)
                        Intent redir = new Intent(EspaceParents.this, SuiviEnfantI.class);
                        startActivity(redir);
                    }

                }
            }
        );*/


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.tableau_bordP: {
                Intent redir = new Intent(EspaceParents.this, EspaceParents.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }

            case R.id.cours_exos_fait: {
                i = new Intent(EspaceParents.this, EspaceParents.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                i.putExtra("Content","Cours et Exercices effectués");
                startActivity(i);
                finish();
                break;
            }

            case R.id.momentCO: {
                i = new Intent(EspaceParents.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                i.putExtra("Content","Moment de connexion");
                startActivity(i);
                finish();
                break;
            }

            case R.id.courbes_progressionP: {
                i = new Intent(EspaceParents.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                i.putExtra("Content","Courbes de progressions");
                startActivity(i);
                finish();
                break;
            }
            case R.id.recommandationsP: {
                i = new Intent(EspaceParents.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                i.putExtra("Content","Recommandation");
                startActivity(i);
                finish();
                break;
            }
            case R.id.rappel: {
                i = new Intent(EspaceParents.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                i.putExtra("Content","Définir un rappel");
                startActivity(i);
                finish();
                break;
            }
            case R.id.activitesP: {
                i = new Intent(EspaceParents.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                i.putExtra("Content","Activités de l'enfant");
                startActivity(i);
                finish();
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
