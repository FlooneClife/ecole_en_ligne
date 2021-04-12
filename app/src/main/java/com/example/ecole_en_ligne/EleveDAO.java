package com.example.ecole_en_ligne;

import android.content.ContentValues;
import android.content.Context;

public class EleveDAO extends DAOBase {
    public static final String ELEVE_KEY = "ID_ELEVE";
    public static final String ELEVE_NOM = "NOM_ELEVE";
    public static final String ELEVE_PRENOM = "PRENOM_ELEVE";
    public static final String ELEVE_LOGIN = "LOGIN_ELEVE";
    public static final String ELEVE_MDP = "MDP_ELEVE";
    public static final String ELEVE_EMAIL = "EMAIL_ELEVE";
    public static final String ELEVE_TABLE_NAME = "ELEVES_INSCRIPTION";

    public static final String ELEVE_TABLE_CREATE =
            "CREATE TABLE " + ELEVE_TABLE_NAME + "("+
                    ELEVE_KEY + "INTERGER PRIMARY KEY AUTOINCREMENT," +
                    ELEVE_NOM + "TEXT,"+
                    ELEVE_PRENOM + "TEXT,"+
                    ELEVE_LOGIN + "TEXT,"+
                    ELEVE_MDP + "TEXT,"+
                    ELEVE_EMAIL + "TEXT);";

    public static final String ELEVE_TABLE_DROP = "DROP TABLE IF EXISTS " + ELEVE_TABLE_NAME + ";";

    public EleveDAO(Context pContext) {
        super(pContext);
    }

    public void ajouter(Eleve e){
        ContentValues value = new ContentValues();
        value.put(EleveDAO.ELEVE_NOM,e.getNom());
        value.put(EleveDAO.ELEVE_PRENOM,e.getPrenom());
        value.put(EleveDAO.ELEVE_LOGIN,e.getLogin());
        value.put(EleveDAO.ELEVE_MDP,e.getMdp());
        value.put(EleveDAO.ELEVE_EMAIL,e.getEmail());
        mDb.insert(EleveDAO.ELEVE_TABLE_NAME,null,value);
    }

    public void supprimer(long id){
        mDb.delete(ELEVE_TABLE_NAME, ELEVE_KEY + " = ?", new String[] {String.valueOf(id)});
    }

    public void modifier(Eleve e){
        ContentValues value = new ContentValues();
        value.put(EleveDAO.ELEVE_NOM,e.getNom());
        value.put(EleveDAO.ELEVE_PRENOM,e.getPrenom());
        value.put(EleveDAO.ELEVE_LOGIN,e.getLogin());
        value.put(EleveDAO.ELEVE_MDP,e.getMdp());
        value.put(EleveDAO.ELEVE_EMAIL,e.getEmail());
        mDb.update(ELEVE_TABLE_NAME, value, ELEVE_KEY  + " = ?", new String[] {String.valueOf(e.getId())});
    }

    /*public Eleve selectionner(long id){

    }*/





}
