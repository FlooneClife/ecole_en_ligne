package com.example.ecole_en_ligne.espaces.Parents;

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

import com.example.ecole_en_ligne.Common_bdd;
import com.example.ecole_en_ligne.bdd.Parent;
import com.example.ecole_en_ligne.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class SuiviEnfantI extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ImageView menu;
    ImageView deco;
    Intent i;
    TextView loginName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parents_enfanti);

        i = getIntent();
        loginName = findViewById(R.id.loginNameP);

        TextView content = findViewById(R.id.contentS);
        content.setText(i.getStringExtra("Content"));

        navigationView = findViewById(R.id.navigationS);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layoutS);

        navigationView.setNavigationItemSelectedListener(this);

        //loginName.setText(" " + i.getStringExtra("Login"));

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

        Parent p = Common_bdd.getParentByLogin(i.getStringExtra("Login"));
        ArrayList<String> listEnf = new ArrayList<String>();

        for (int i = 0; i<p.getNbEnfant();i++){
            listEnf.add("Enfant " + (i+1));
        }

        ListView list = (ListView) findViewById(R.id.liste_enfant);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listEnf);
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
                Intent redir = new Intent(SuiviEnfantI.this, EspaceParents.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }


            case R.id.cours_exos_fait: {
                Intent redir = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Cours et Exercices effectués");
                startActivity(redir);
                finish();
                break;
            }

            case R.id.momentCO: {
                Intent redir = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Moment de connexion");
                startActivity(redir);
                finish();
                break;
            }

            case R.id.courbes_progressionP: {
                Intent redir = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Courbes de progressions");
                startActivity(redir);
                finish();
                break;
            }
            case R.id.recommandationsP: {
                Intent redir = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Recommandation");
                startActivity(redir);
                finish();
                break;
            }
            case R.id.rappel: {
                Intent redir = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Définir un rappel");
                startActivity(redir);
                finish();
                break;
            }
            case R.id.activitesP: {
                Intent redir = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Activités de l'enfant");
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
