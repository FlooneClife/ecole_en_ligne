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

import com.example.ecole_en_ligne.MainActivity;
import com.example.ecole_en_ligne.bdd.EleveManager;
import com.example.ecole_en_ligne.bdd.Parent;
import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.bdd.ParentManager;
import com.example.ecole_en_ligne.espaces.Parents.elementMenu.ExoEnfFait;
import com.example.ecole_en_ligne.espaces.Parents.elementMenu.Recommandation_Eleve;
import com.example.ecole_en_ligne.espaces.Parents.elementMenu.HistoriqueConnexionEleve;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class SuiviEnfantI extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ImageView menu;
    private ImageView retour;
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
        System.out.println(myLogin);
        loginName.setText(" " + myLogin);

        menu = findViewById(R.id.menu);
        retour = findViewById(R.id.retour);

        ParentManager pm = new ParentManager(this);
        EleveManager em = new EleveManager(this);

        em.open();
        listNom = em.getNomEleveLoginParent(myLogin);
        listPrenom = em.getPrenomEleveLoginParent(myLogin);
        listlogin = em.getLoginEleveLoginParent(myLogin);
        em.close();


        //------------------------------HEADER------------------------------

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

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> adapter, View view, int position, long arg){
                if (i.getStringExtra("Content").contentEquals("Cours et Exercices effectués")){
                    Intent redir = new Intent(SuiviEnfantI.this, ExoEnfFait.class);
                    redir.putExtra("Login",i.getStringExtra("Login"));
                    redir.putExtra("loginEleve",listlogin.get(position));
                    startActivity(redir);
                }else if (i.getStringExtra("Content").contentEquals("Recommandation")){
                    Intent redir = new Intent(SuiviEnfantI.this, Recommandation_Eleve.class);
                    redir.putExtra("Login",i.getStringExtra("Login"));
                    redir.putExtra("loginEleve",listlogin.get(position));
                    startActivity(redir);
                } else if (i.getStringExtra("Content").contentEquals("Moment de connexion")) {
                    Intent redir = new Intent(SuiviEnfantI.this, HistoriqueConnexionEleve.class);
                    redir.putExtra("Login", i.getStringExtra("Login"));
                    redir.putExtra("loginEleve", listlogin.get(position));
                    startActivity(redir);
                }
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
                if (i.getStringExtra("Content").contentEquals("Cours et Exercices effectués")){
                    break;
                } else {
                    Intent redir = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                    redir.putExtra("Login", myLogin);
                    redir.putExtra("Content", "Cours et Exercices effectués");
                    startActivity(redir);
                    finish();
                    break;
                }
            }
            case R.id.momentCO: {
                if (i.getStringExtra("Content").contentEquals("Moment de connexion")){
                    break;
                } else {
                    Intent redir = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                    redir.putExtra("Login", i.getStringExtra("Login"));
                    redir.putExtra("Content", "Moment de connexion");
                    startActivity(redir);
                    finish();
                    break;
                }
            }
            case R.id.courbes_progressionP: {
                if (i.getStringExtra("Content").contentEquals("Courbes de progressions")){
                    break;
                } else {
                    Intent redir = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                    redir.putExtra("Login", i.getStringExtra("Login"));
                    redir.putExtra("Content", "Courbes de progressions");
                    startActivity(redir);
                    finish();
                    break;
                }
            }
            case R.id.recommandationsP: {
                if (i.getStringExtra("Content").contentEquals("Recommandation")){
                    break;
                } else {
                    Intent redir = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                    redir.putExtra("Login", i.getStringExtra("Login"));
                    redir.putExtra("Content", "Recommandation");
                    startActivity(redir);
                    finish();
                    break;
                }
            }
            case R.id.rappel: {
                if (i.getStringExtra("Content").contentEquals("Définir un rappel")){
                    break;
                } else {
                    Intent redir = new Intent(SuiviEnfantI.this, SuiviEnfantI.class);
                    redir.putExtra("Login", i.getStringExtra("Login"));
                    redir.putExtra("Content", "Définir un rappel");
                    startActivity(redir);
                    finish();
                    break;
                }
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
