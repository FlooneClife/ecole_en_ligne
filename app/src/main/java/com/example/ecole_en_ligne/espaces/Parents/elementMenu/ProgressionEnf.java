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
import com.example.ecole_en_ligne.espaces.Parents.EspaceParents;
import com.example.ecole_en_ligne.espaces.Parents.ProfilParent;
import com.example.ecole_en_ligne.espaces.Parents.SuiviEnfantI;
import com.google.android.material.navigation.NavigationView;

public class ProgressionEnf extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private ImageView menu;
    private ImageView retour;
    private TextView loginName;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private  Intent i;
    private String myLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progression_parent);

        i = getIntent();

        TextView loginParent = findViewById(R.id.loginName);
        loginParent.setText(" "+i.getStringExtra("Login"));

        navigationView = findViewById(R.id.navigation);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);

        retour = findViewById(R.id.retour);
        menu = findViewById(R.id.menu);

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

        TextView idEnf = findViewById(R.id.idELEVE);
        idEnf.setText(i.getStringExtra("loginEleve") + " : ");
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
                Intent redir = new Intent(getApplicationContext(), SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Cours et Exercices effectués");
                Intent intent = new Intent(getApplicationContext(), EspaceParents.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                break;
            }
            case R.id.momentCO: {
                Intent redir = new Intent(getApplicationContext(), SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Moment de connexion");
                Intent intent = new Intent(getApplicationContext(), EspaceParents.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                break;
            }
            case R.id.courbes_progressionP: {
                break;
            }
            case R.id.recommandationsP: {
                Intent redir = new Intent(getApplicationContext(), SuiviEnfantI.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Recommandations");
                Intent intent = new Intent(getApplicationContext(), EspaceParents.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                break;
            }
            case R.id.rappel: {
                Intent redir = new Intent(getApplicationContext(), SuiviEnfantI.class);
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
