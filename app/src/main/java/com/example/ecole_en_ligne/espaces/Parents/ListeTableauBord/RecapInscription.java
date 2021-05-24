package com.example.ecole_en_ligne.espaces.Parents.ListeTableauBord;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.espaces.Parents.EspaceParents;
import com.example.ecole_en_ligne.espaces.Parents.SuiviEnfantI;
import com.google.android.material.navigation.NavigationView;

public class RecapInscription extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    TextView loginName;
    ImageView menu;
    ImageView deco;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recap_inscrip_parent);

        navigationView = findViewById(R.id.navigationR);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layoutR);

        navigationView.setNavigationItemSelectedListener(this);

        menu = findViewById(R.id.menu);
        deco = findViewById(R.id.retour);
        String myLogin = i.getStringExtra("Login");
        loginName.setText(" " + myLogin);


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

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tableau_bordP: {
                Intent redir = new Intent(RecapInscription.this, EspaceParents.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                startActivity(redir);
                finish();
                break;
            }
            case R.id.cours_exos_fait: {
                Intent redir = new Intent(RecapInscription.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Cours et Exercices effectués");
                startActivity(redir);
                finish();
                break;
            }
            case R.id.momentCO: {
                Intent redir = new Intent(RecapInscription.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Moment de connexion");
                startActivity(redir);
                finish();
                break;
            }
            case R.id.courbes_progressionP: {
                Intent redir = new Intent(RecapInscription.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Courbes de progressions");
                startActivity(redir);
                finish();
                break;
            }
            case R.id.recommandationsP: {
                Intent redir = new Intent(RecapInscription.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Recommandation");
                startActivity(redir);
                finish();
                break;
            }
            case R.id.rappel: {
                Intent redir = new Intent(RecapInscription.this, SuiviEnfantI.class);
                //redir.putExtra("Login",i.getStringExtra("Login"));
                redir.putExtra("Content","Définir un rappel");
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
