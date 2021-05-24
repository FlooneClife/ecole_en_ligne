package com.example.ecole_en_ligne.espaces.eleves.ListeTableauBord;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ecole_en_ligne.MainActivity;
import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.espaces.eleves.EspaceEleve;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Activites;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.CoursLive;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Cours_Exos;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Progression;
import com.example.ecole_en_ligne.espaces.eleves.elementMenu.Recommandation;
import com.google.android.material.navigation.NavigationView;


public class Tchat extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView menu;
    ImageView retour;
    TextView loginName;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private String myLogin;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tchat_eleve);

        i = getIntent();
        loginName = findViewById(R.id.loginName);
        myLogin = i.getStringExtra("Login");

        loginName.setText(" " + myLogin);

        navigationView = findViewById(R.id.navigation);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);

        menu = findViewById(R.id.menu);
        retour = findViewById(R.id.retour);

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


        //-------------TCHAT-------------

        EditText edit = findViewById(R.id.EntrerTexte);
        TextView affichage = findViewById(R.id.EndroitMsg);
        ImageView entrer = findViewById(R.id.Entrer);

        entrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                affichage.setText(affichage.getText() + "\n" + i.getStringExtra("Login") + " : " + edit.getText().toString());
                switch (edit.getText().toString().toLowerCase()) {
                    case "bonjour":
                    case "bonjour.":
                        affichage.setText(affichage.getText() + "\nProfesseur : Bonjour !");
                        break;
                    case "comment allez-vous ?":
                        affichage.setText(affichage.getText() + "\nProfesseur : Bien et vous ?");
                        break;
                    case "bien merci":
                    case "bien merci.":
                        affichage.setText(affichage.getText() + "\nProfesseur : Commençons à travailler !");
                        break;
                }
                edit.setText("");
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tableau_bord: {
                finish();
                break;
            }
            case R.id.cours_exos: {
                //ouvrir page des cours et des exercices
                Intent redir = new Intent(Tchat.this, Cours_Exos.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                Intent intent = new Intent(getApplicationContext(), EspaceEleve.class);
                intent.putExtra("Login",i.getStringExtra("Login"));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                finish();
                break;
            }
            case R.id.cours_live: {
                //ouvrir page des rappels de cours
                Intent redir = new Intent(Tchat.this, CoursLive.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                Intent intent = new Intent(getApplicationContext(), EspaceEleve.class);
                intent.putExtra("Login",i.getStringExtra("Login"));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                finish();
                break;
            }
            case R.id.recommandations: {
                //ouvrir page des recommandations
                Intent redir = new Intent(Tchat.this, Recommandation.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                Intent intent = new Intent(getApplicationContext(), EspaceEleve.class);
                intent.putExtra("Login",i.getStringExtra("Login"));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                finish();
                break;
            }
            case R.id.progression: {
                //ouvrir page des progressions et courbes
                Intent redir = new Intent(Tchat.this, Progression.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                Intent intent = new Intent(getApplicationContext(), EspaceEleve.class);
                intent.putExtra("Login",i.getStringExtra("Login"));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(redir);
                finish();
                break;
            }
            case R.id.activites: {
                //ouvrir page des dernières activites
                Intent redir = new Intent(Tchat.this, Activites.class);
                redir.putExtra("Login",i.getStringExtra("Login"));
                Intent intent = new Intent(getApplicationContext(), EspaceEleve.class);
                intent.putExtra("Login",i.getStringExtra("Login"));
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
