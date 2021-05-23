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

import com.example.ecole_en_ligne.bdd.EleveManager;
import com.example.ecole_en_ligne.bdd.Parent;
import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.bdd.ParentManager;
import com.example.ecole_en_ligne.espaces.Parents.elementMenu.ExoEnfFait;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class SuiviEnfantI extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ImageView menu;
    private ImageView deco;
    private Intent i;
    private TextView loginName;
    private String myLogin;
    private ArrayList<String> listNom;
    private ArrayList<String> listPrenom;
    private ArrayList<String> listlogin;

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

        myLogin = i.getStringExtra("Login");
        //loginName.setText(" " + myLogin);

        menu = findViewById(R.id.menu);
        deco = findViewById(R.id.retour);

        ParentManager pm = new ParentManager(this);
        EleveManager em = new EleveManager(this);

        em.open();
        listNom = em.getNomEleveLoginParent(myLogin);
        listPrenom = em.getPrenomEleveLoginParent(myLogin);
        listlogin = em.getLoginEleveLoginParent(myLogin);
        em.close();


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

        pm.open();
        Parent p = pm.getParent(i.getStringExtra("Login"));
        ArrayList<String> listEnf = new ArrayList<String>();

        for (int i = 0; i<p.getNbEnfant();i++){
            listEnf.add(listNom.get(i) + " "+listPrenom.get(i)); //em.getNomEleveLoginParent(...)
        }

        pm.close();

        ListView list = (ListView) findViewById(R.id.liste_enfant);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listEnf);
        list.setAdapter(adapter);

        //TODO......


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick (AdapterView<?> adapter, View view, int position, long arg){
                    if (position == 0){
                        if (i.getStringExtra("Content").contentEquals("Cours et Exercices effectués")){
                            Intent redir = new Intent(SuiviEnfantI.this, ExoEnfFait.class);
                            redir.putExtra("login",i.getStringExtra("Login"));
                            redir.putExtra("loginEleve",listlogin.get(position));
                            startActivity(redir);
                        }
                    }

                }
        });





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
