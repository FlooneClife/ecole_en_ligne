package com.example.ecole_en_ligne.espaces.eleves.ListeTableauBord;

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
import com.example.ecole_en_ligne.espaces.eleves.EspaceEleve;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Activites;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.CoursLive;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Cours_Exos;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Progression;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Recommandation;
import com.google.android.material.navigation.NavigationView;

public class MesMatieres extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView menu;
    ImageView deco;
    TextView loginName;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_matieres);

        i = getIntent();
        loginName = findViewById(R.id.loginName);

        navigationView = findViewById(R.id.navigation);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);

        loginName.setText(" " + i.getStringExtra("Login"));

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

        //------------------------------LISTE DES MATIERES------------------------------

        String[] mat = new String[] {
                "Mathématiques",
                "Français",
                "Anglais",
                "Histoire"
        };

        ListView list = (ListView) findViewById(R.id.listeMatières);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mat);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                 @Override
                 public void onItemClick (AdapterView<?> adapter, View view, int position, long arg){
                     if (position == 0){
                         Intent redir = new Intent(MesMatieres.this, Tchat.class);
                         redir.putExtra("Login",i.getStringExtra("Login"));
                         startActivity(redir);
                     }else if (position == 1){
                         Intent redir = new Intent(MesMatieres.this, Tchat.class);
                         redir.putExtra("Login",i.getStringExtra("Login"));
                         startActivity(redir);
                     }else if (position == 2){
                         Intent redir = new Intent(MesMatieres.this, Tchat.class);
                         redir.putExtra("Login",i.getStringExtra("Login"));
                         startActivity(redir);
                     }else if (position == 3){
                         Intent redir = new Intent(MesMatieres.this, Tchat.class);
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
                Intent redir = new Intent(MesMatieres.this, EspaceEleve.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }

            case R.id.cours_exos: {
                //ouvrir page des cours et des exercices
                Intent redir = new Intent(MesMatieres.this, Cours_Exos.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }
            case R.id.cours_live: {
                //ouvrir page des rappels de cours
                Intent redir = new Intent(MesMatieres.this, CoursLive.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }
            case R.id.recommandations: {
                //ouvrir page des recommandations
                Intent redir = new Intent(MesMatieres.this, Recommandation.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }
            case R.id.progression: {
                //ouvrir page des progressions et courbes
                Intent redir = new Intent(MesMatieres.this, Progression.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }
            case R.id.activites: {
                //ouvrir page des dernières activites
                Intent redir = new Intent(MesMatieres.this, Activites.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
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
