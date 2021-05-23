package com.example.ecole_en_ligne.espaces.eleves.elementMenu;

import android.content.Intent;
import android.os.Bundle;

import com.example.ecole_en_ligne.espaces.eleves.EspaceEleve;
import com.example.ecole_en_ligne.espaces.eleves.matieres.Anglais;
import com.example.ecole_en_ligne.espaces.eleves.matieres.Français;
import com.example.ecole_en_ligne.espaces.eleves.matieres.Histoire;
import com.example.ecole_en_ligne.espaces.eleves.matieres.Maths;
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

public class Cours_Exos extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView menu;
    private ImageView deco;
    private TextView loginName;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Intent i;
    private String myLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cours_exos);


        i = getIntent();
        myLogin = i.getStringExtra("Login");
        loginName = findViewById(R.id.loginName);

        navigationView = findViewById(R.id.navigation);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);

        loginName.setText(" " + myLogin);

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

        ListView list = (ListView) findViewById(R.id.liste_matiere);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mat);
        list.setAdapter(adapter);

                     ///------------ELEMENT CLIQUABLE LISTE------------///


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick (AdapterView<?> adapter, View view, int position, long arg){
                    if (position == 0){  //Si c'est l'onglet Mathématiques qui est selectionné (se trouve a la position 0 dans la liste)
                        Intent redir = new Intent(Cours_Exos.this, Maths.class);
                        redir.putExtra("Login",myLogin);
                        startActivity(redir);
                    }else if (position == 1){  //Si c'est l'onglet Français qui est selectionné (se trouve a la position 0 dans la liste)
                        Intent redir = new Intent(Cours_Exos.this, Français.class);
                        redir.putExtra("Login",myLogin);
                        startActivity(redir);
                    }else if (position == 2){  //Si c'est l'onglet Anglais qui est selectionné (se trouve a la position 0 dans la liste)
                        Intent redir = new Intent(Cours_Exos.this, Anglais.class);
                        redir.putExtra("Login",myLogin);
                        startActivity(redir);
                    }else if (position == 3){  //Si c'est l'onglet Histoire qui est selectionné (se trouve a la position 0 dans la liste)
                        Intent redir = new Intent(Cours_Exos.this, Histoire.class);
                        redir.putExtra("Login",myLogin);
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
                Intent redir = new Intent(Cours_Exos.this, EspaceEleve.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }

            case R.id.cours_exos: {
                //ouvrir page des cours et des exercices
                Intent redir = new Intent(Cours_Exos.this, Cours_Exos.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }
            case R.id.cours_live: {
                //ouvrir page des rappels de cours
                Intent redir = new Intent(Cours_Exos.this, CoursLive.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }
            case R.id.recommandations: {
                //ouvrir page des recommandations
                Intent redir = new Intent(Cours_Exos.this, Recommandation.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }
            case R.id.progression: {
                //ouvrir page des progressions et courbes
                Intent redir = new Intent(Cours_Exos.this, Progression.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }
            case R.id.activites: {
                //ouvrir page des dernières activites
                Intent redir = new Intent(Cours_Exos.this, Activites.class);
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