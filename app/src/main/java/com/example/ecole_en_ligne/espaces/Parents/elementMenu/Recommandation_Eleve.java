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
import com.example.ecole_en_ligne.bdd.Recommandations;
import com.example.ecole_en_ligne.bdd.RecommandationsManager;
import com.example.ecole_en_ligne.espaces.Parents.SuiviEnfantI;
import com.example.ecole_en_ligne.espaces.eleves.EspaceEleve;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Activites;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.CoursLive;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Cours_Exos;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Progression;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Recommandation;
import com.google.android.material.navigation.NavigationView;


public class Recommandation_Eleve extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    ImageView menu;
    ImageView retour;
    TextView loginName;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Intent i;
    private String myLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommandation_parent);

        i = getIntent();

        TextView loginParent = findViewById(R.id.loginName);
        loginParent.setText(" "+i.getStringExtra("Login"));

        navigationView = findViewById(R.id.navigation);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);

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


        //--------------------AFFICHAGE RECOMMANDATIONS--------------------

        RecommandationsManager rM = new RecommandationsManager(this);
        rM.open();
        Recommandations r = rM.getRecommandationsByStudent(i.getStringExtra("loginEleve"));
        rM.close();

        TextView texte = findViewById(R.id.texteRecommandation);
        texte.setText(i.getStringExtra("loginEleve") + " : \n"+r.getText());



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tableau_bordP: {
                break;
            }
            case R.id.cours_exos_fait: {
                Intent redir = new Intent(Recommandation_Eleve.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Cours et Exercices réalisés");
                startActivity(redir);
                break;
            }
            case R.id.momentCO: {
                Intent redir = new Intent(Recommandation_Eleve.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Moment de connexion");
                startActivity(redir);
                break;
            }
            case R.id.courbes_progressionP: {
                Intent redir = new Intent(Recommandation_Eleve.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Courbes de progressions");
                startActivity(redir);
                break;
            }
            case R.id.recommandationsP: {
                break;
            }
            case R.id.rappel: {
                Intent redir = new Intent(Recommandation_Eleve.this, SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Définir un rappel");
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
