package com.example.ecole_en_ligne.espaces.Parents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecole_en_ligne.R;
import com.example.ecole_en_ligne.bdd.Parent;
import com.example.ecole_en_ligne.bdd.ParentManager;
import com.example.ecole_en_ligne.util.ActionUtil;

public class ProfilParent extends AppCompatActivity {

    private Intent i;
    private TextView loginName;
    private String myLogin;
    private ImageView retour;
    private ParentManager pm;
    private TextView monNom;
    private TextView monPrenom;
    private TextView monEmail;
    private String nomParent;
    private String prenomParent;
    private String emailParent;
    private String mdpParent;
    private Button modifierEmail;
    private Button modifierMdp;
    private Button validerModif;
    private TextView textModif;
    private EditText editModif;
    private boolean annuler = false;
    private int changement; //0 = email, 1 = mdp

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_parent);

        i = getIntent();
        myLogin = i.getStringExtra("Login");
        loginName = findViewById(R.id.loginName);
        loginName.setText(" " + myLogin);

        retour = findViewById(R.id.retour);
        monNom = findViewById(R.id.monNom);
        monPrenom = findViewById(R.id.monPrenom);
        monEmail = findViewById(R.id.monEmail);
        modifierEmail = findViewById(R.id.monEmailModif);
        modifierMdp = findViewById(R.id.monMdpModif);
        validerModif = findViewById(R.id.buttonModifier);
        textModif = findViewById(R.id.modifier);
        editModif = findViewById(R.id.editModifier);
        pm = new ParentManager(this);

        pm.open();
        nomParent = pm.getParent(myLogin).getNom();
        prenomParent = pm.getParent(myLogin).getPrenom();
        emailParent = pm.getParent(myLogin).getEmail();
        mdpParent = pm.getParent(myLogin).getMdp();
        monNom.setText(nomParent);
        monPrenom.setText(prenomParent);
        monEmail.setText(emailParent);
        pm.close();

        modifierEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!annuler) {
                    changement = 0;
                    annuler = true;
                    modifierEmail.setText(R.string.annuler);
                    modifierEmail.setBackgroundResource(R.drawable.button_red_gradient);
                    modifierMdp.setEnabled(false);
                    validerModif.setVisibility(v.VISIBLE);
                    textModif.setVisibility(v.VISIBLE);
                    textModif.setText(R.string.nouvelEmail);
                    editModif.setVisibility(v.VISIBLE);
                    editModif.setHint(R.string.email);
                    editModif.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                } else if(annuler) {
                    annuler = false;
                    modifierEmail.setText(R.string.modifier);
                    modifierEmail.setBackgroundResource(R.drawable.button_blue_gradient);
                    modifierMdp.setEnabled(true);
                    validerModif.setVisibility(v.GONE);
                    textModif.setVisibility(v.GONE);
                    editModif.setVisibility(v.GONE);
                    editModif.setText("");
                }
            }
        });

        modifierMdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!annuler) {
                    changement = 1;
                    annuler = true;
                    modifierMdp.setText(R.string.annuler);
                    modifierMdp.setBackgroundResource(R.drawable.button_red_gradient);
                    modifierEmail.setEnabled(false);
                    validerModif.setVisibility(v.VISIBLE);
                    textModif.setVisibility(v.VISIBLE);
                    textModif.setText(R.string.nouveauMdp);
                    editModif.setVisibility(v.VISIBLE);
                    editModif.setHint(R.string.mdp);
                    editModif.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else if(annuler) {
                    annuler = false;
                    modifierMdp.setText(R.string.modifier);
                    modifierMdp.setBackgroundResource(R.drawable.button_blue_gradient);
                    modifierEmail.setEnabled(true);
                    validerModif.setVisibility(v.GONE);
                    textModif.setVisibility(v.GONE);
                    editModif.setVisibility(v.GONE);
                    editModif.setText("");
                }
            }
        });

        validerModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                annuler = false;
                if(changement == 0) {   //email
                    if(!ActionUtil.verifEmailFormat(editModif)) {
                        pm.open();
                        monEmail.setText(editModif.getText().toString());
                        pm.modParent(new Parent(nomParent,
                                prenomParent,
                                myLogin,
                                pm.getParent(myLogin).getMdp(),
                                editModif.getText().toString(),
                                pm.getParent(myLogin).getNbEnfant()));
                        modifierEmail.setText(R.string.modifier);
                        modifierMdp.setText(R.string.modifier);
                        modifierEmail.setBackgroundResource(R.drawable.button_blue_gradient);
                        modifierMdp.setBackgroundResource(R.drawable.button_blue_gradient);
                        modifierEmail.setEnabled(true);
                        modifierMdp.setEnabled(true);
                        validerModif.setVisibility(v.GONE);
                        textModif.setVisibility(v.GONE);
                        editModif.setText("");
                        editModif.setVisibility(v.GONE);
                        pm.close();
                    }
                } else if(changement == 1) {   //mdp
                    pm.open();
                    pm.modParent(new Parent(nomParent,
                            prenomParent,
                            myLogin,
                            emailParent,
                            editModif.getText().toString(),
                            pm.getParent(myLogin).getNbEnfant()));
                    modifierEmail.setText(R.string.modifier);
                    modifierMdp.setText(R.string.modifier);
                    modifierEmail.setBackgroundResource(R.drawable.button_blue_gradient);
                    modifierMdp.setBackgroundResource(R.drawable.button_blue_gradient);
                    modifierEmail.setEnabled(true);
                    modifierMdp.setEnabled(true);
                    validerModif.setVisibility(v.GONE);
                    textModif.setVisibility(v.GONE);
                    editModif.setText("");
                    editModif.setVisibility(v.GONE);
                    pm.close();
                }
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}