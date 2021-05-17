package com.example.ecole_en_ligne.espaces.parents;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.espaces.Parents.EspaceParents;
import com.google.android.material.navigation.NavigationView;

public class SuiviEnfantI extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ImageView menu;
    ImageView deco;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parents_enfanti);

        i = getIntent();

        TextView content = findViewById(R.id.contentS);
        content.setText(i.getStringExtra("Content"));

        navigationView = findViewById(R.id.navigationS);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layoutS);

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


        //------------------------------LISTE DE SUIVI------------------------------

        String[] mat = new String[] {
                "Enfant 1",
                "Enfant 2",
                "Enfant 3",
                "Enfant 4"
        };

        ListView list = (ListView) findViewById(R.id.liste_enfant);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mat);
        list.setAdapter(adapter);

        //TODO......

        /*
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick (AdapterView<?> adapter, View view, int position, long arg){
                                            if (position == 0){  //Si c'est l'eleve 1 qui est selectionné (se trouve a la position 0 dans la liste)
                                                Intent redir = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
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
                    i = new Intent(SuiviEnfantI.this, EspaceParents.class);
                    //redir.putExtra("Login",i.getStringExtra("Login"));
                    startActivity(i);
                    finish();
                    break;
                }


                case R.id.cours_exos_fait: {
                    i = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                    //redir.putExtra("Login",i.getStringExtra("Login"));
                    i.putExtra("Content","Cours et Exercices effectués");
                    startActivity(i);
                    finish();
                    break;
                }

                case R.id.momentCO: {
                    i = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                    //redir.putExtra("Login",i.getStringExtra("Login"));
                    i.putExtra("Content","Moment de connexion");
                    startActivity(i);
                    finish();
                    break;
                }

                case R.id.courbes_progressionP: {
                    i = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                    //redir.putExtra("Login",i.getStringExtra("Login"));
                    i.putExtra("Content","Courbes de progressions");
                    startActivity(i);
                    finish();
                    break;
                }
                case R.id.recommandationsP: {
                    i = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                    //redir.putExtra("Login",i.getStringExtra("Login"));
                    i.putExtra("Content","Recommandation");
                    startActivity(i);
                    finish();
                    break;
                }
                case R.id.rappel: {
                    i = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                    //redir.putExtra("Login",i.getStringExtra("Login"));
                    i.putExtra("Content","Définir un rappel");
                    startActivity(i);
                    finish();
                    break;
                }
                case R.id.activitesP: {
                    i = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
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
