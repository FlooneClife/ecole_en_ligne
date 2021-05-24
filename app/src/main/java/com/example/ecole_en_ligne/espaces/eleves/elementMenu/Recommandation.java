package com.example.ecole_en_ligne.espaces.eleves.elementMenu;

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
import com.example.ecole_en_ligne.bdd.Recommandations;
import com.example.ecole_en_ligne.bdd.RecommandationsManager;
import com.example.ecole_en_ligne.espaces.eleves.EspaceEleve;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

public class Recommandation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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
        setContentView(R.layout.recommandation);

        i = getIntent();
        loginName = findViewById(R.id.loginName);
        myLogin = i.getStringExtra("Login");

        navigationView = findViewById(R.id.navigation);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);

        loginName.setText(" " + myLogin);

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

        //--------------RECOMMANDATION--------------

        TextView text = findViewById(R.id.texteRecommandation);
        String txt ="Mathématiques : Revoir les fonctions.\n\nAnglais : Revoir les conjugaisons.";

        text.setText(txt);


        RecommandationsManager rM = new RecommandationsManager(this);
        EleveManager eM = new EleveManager(this);

        eM.open();
        String LoginEleveParent = eM.getLoginEleveParent(myLogin);
        eM.close();

        Recommandations r = new Recommandations(1,myLogin,LoginEleveParent,txt);
        rM.open();
        rM.addRecommandations(r);
        rM.close();




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
                Intent redir = new Intent(Recommandation.this, Cours_Exos.class);
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
                Intent redir = new Intent(Recommandation.this, CoursLive.class);
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
                break;
            }
            case R.id.progression: {
                //ouvrir page des progressions et courbes
                Intent redir = new Intent(Recommandation.this, Progression.class);
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
                Intent redir = new Intent(Recommandation.this, Activites.class);
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
