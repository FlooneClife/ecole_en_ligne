package com.example.ecole_en_ligne.espaces.Parents;

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
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.espaces.Parents.ListeTableauBord.LesEnfants;
import com.google.android.material.navigation.NavigationView;

public class EspaceParents extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private TextView loginName;
    private ImageView menu;
    private ImageView deco;
    private Intent i;

    @Override
    public void onBackPressed() {
        //do nothing
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil_parents);

        i = getIntent();
        loginName = findViewById(R.id.loginName);
        String myLogin = i.getStringExtra("Login");
        System.out.println(i.getStringExtra("Login"));
        loginName.setText(" "+i.getStringExtra("Login"));

        navigationView = findViewById(R.id.navigationP);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layoutP);

        navigationView.setNavigationItemSelectedListener(this);

        menu = findViewById(R.id.menu);
        deco = findViewById(R.id.retour);

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

        listP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                 @Override
                 public void onItemClick (AdapterView<?> adapter, View view, int position, long arg){
                     if (position == 0){  //Si c'est l'eleve 1 qui est selectionné (se trouve a la position 0 dans la liste)
                         Intent redir = new Intent(EspaceParents.this, LesEnfants.class);
                         redir.putExtra("Login",i.getStringExtra("Login"));
                         startActivity(redir);
                         finish();
                     }

                 }
             }
        );


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.tableau_bordP: {
                Intent redir = new Intent(EspaceParents.this, EspaceParents.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }

            case R.id.cours_exos_fait: {
                Intent redir = new Intent(EspaceParents.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Cours et Exercices effectués");
                startActivity(redir);
                finish();
                break;
            }

            case R.id.momentCO: {
                Intent redir = new Intent(EspaceParents.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Moment de connexion");
                startActivity(redir);
                finish();
                break;
            }

            case R.id.courbes_progressionP: {
                Intent redir = new Intent(EspaceParents.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Courbes de progressions");
                startActivity(redir);
                finish();
                break;
            }
            case R.id.recommandationsP: {
                Intent redir = new Intent(EspaceParents.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Recommandation");
                startActivity(redir);
                finish();
                break;
            }
            case R.id.rappel: {
                Intent redir = new Intent(EspaceParents.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Définir un rappel");
                startActivity(redir);
                finish();
                break;
            }
            case R.id.activitesP: {
                Intent redir = new Intent(EspaceParents.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Activités de l'enfant");
                startActivity(redir);
                finish();
                break;
            }

            case R.id.retour: {
                finish();
                break;
            }
        }

        //close navigation drawer
        drawerLayout.closeDrawers();
        return true;
    }

}
