package com.example.ecole_en_ligne.espaces.Parents.elementMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ecole_en_ligne.MainActivity;
import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.bdd.EleveManager;
import com.example.ecole_en_ligne.espaces.Parents.EspaceParents;
import com.example.ecole_en_ligne.espaces.Parents.ProfilParent;
import com.example.ecole_en_ligne.espaces.Parents.SuiviEnfantI;
import com.google.android.material.navigation.NavigationView;

public class HistoriqueConnexionEleve extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private TextView loginName;
    private ImageView menu;
    private ImageView retour;
    private Intent i;
    private TextView dateCo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique_connexion_eleve);

        i = getIntent();
        loginName = findViewById(R.id.loginName);
        String myLogin = i.getStringExtra("Login");
        String loginEleve = i.getStringExtra("loginEleve");
        loginName.setText(" "+ myLogin);
        dateCo = findViewById(R.id.dateCo);

        navigationView = findViewById(R.id.navigation);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView.setNavigationItemSelectedListener(this);

        menu = findViewById(R.id.menu);
        retour = findViewById(R.id.retour);

        EleveManager em = new EleveManager(this);
        em.open();
        String date = em.getEleve(loginEleve).getLastTimeOnline();
        if(!date.equals("")) {
            dateCo.setText(date);
        } else {
            dateCo.setText(R.string.aucuneCo);
        }
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
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.tableau_bordP: {Intent redir = new Intent(getApplicationContext(), EspaceParents.class);
                redir.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }
            case R.id.cours_exos_fait: {
                Intent redir = new Intent(HistoriqueConnexionEleve.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Cours et Exercices effectués");
                Intent intent = new Intent(getApplicationContext(), EspaceParents.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                break;
            }
            case R.id.momentCO: {
                break;
            }
            case R.id.courbes_progressionP: {
                Intent redir = new Intent(HistoriqueConnexionEleve.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Courbes de progressions");
                Intent intent = new Intent(getApplicationContext(), EspaceParents.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                break;
            }
            case R.id.recommandationsP: {
                Intent redir = new Intent(HistoriqueConnexionEleve.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Recommandation");
                Intent intent = new Intent(getApplicationContext(), EspaceParents.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                break;
            }
            case R.id.rappel: {
                Intent redir = new Intent(HistoriqueConnexionEleve.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Définir un rappel");
                Intent intent = new Intent(getApplicationContext(), EspaceParents.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                break;
            }
            case R.id.profil: {
                Intent redir = new Intent(getApplicationContext(), ProfilParent.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                Intent intent = new Intent(getApplicationContext(), EspaceParents.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                finish();
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
