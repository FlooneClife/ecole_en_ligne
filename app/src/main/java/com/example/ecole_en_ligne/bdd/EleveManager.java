package com.example.ecole_en_ligne.bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EleveManager {
//    public static final String ELEVE_KEY = "ID_ELEVE";
    private static final String ELEVE_TABLE_NAME = "Eleve";
    public static final String ELEVE_NOM = "nom";
    public static final String ELEVE_PRENOM = "prenom";
    public static final String ELEVE_LOGIN = "login";
    public static final String ELEVE_MDP = "mdp";
    public static final String ELEVE_EMAIL = "email";
    public static final String ELEVE_FORMULE = "formule";
    public static final String ELEVE_NIVEAU = "nivScol";
    public static final String ELEVE_ANNEE = "anneeScol";
    public static final String ELEVE_LOGINPARENT = "loginParent";
    public static final String ELEVE_LASTTIMEONLINE = "lastTimeOnline";

    public static final String ELEVE_TABLE_CREATE =
            "CREATE TABLE " + ELEVE_TABLE_NAME + " ("+
//                    ELEVE_KEY + "INTEGER PRIMARY KEY NOT NULL," +
                    ELEVE_NOM + " TEXT, "+
                    ELEVE_PRENOM + " TEXT, "+
                    ELEVE_LOGIN + " TEXT PRIMARY KEY, "+
                    ELEVE_MDP + " TEXT, "+
                    ELEVE_EMAIL + " TEXT, "+
                    ELEVE_FORMULE + " TEXT, "+
                    ELEVE_NIVEAU + " TEXT, "+
                    ELEVE_ANNEE + " TEXT, "+
                    ELEVE_LOGINPARENT + " TEXT, "+
                    ELEVE_LASTTIMEONLINE + " DATE);";

    private MySQLite mDb;
    private SQLiteDatabase db;

    public static final String ELEVE_TABLE_DROP = "DROP TABLE IF EXISTS " + ELEVE_TABLE_NAME + ";";

    //constructeur
    public EleveManager(Context pContext) {
        mDb = MySQLite.getInstance(pContext);
    }

    //on ouvre la table en lecture/écriture
    public void open() {
        db = mDb.getWritableDatabase();
    }

    //on ferme l'accès à la BDD
    public void close() {
        db.close();
    }

    public long addEleve(Eleve e){
        ContentValues value = new ContentValues();
//        value.put(EleveManager.ELEVE_KEY,e.getId());
        value.put(ELEVE_NOM, e.getNom());
        value.put(ELEVE_PRENOM, e.getPrenom());
        value.put(ELEVE_LOGIN, e.getLogin());
        value.put(ELEVE_MDP, e.getMdp());
        value.put(ELEVE_EMAIL, e.getEmail());
        value.put(ELEVE_FORMULE, e.getFormule());
        value.put(ELEVE_NIVEAU, e.getNivScol());
        value.put(ELEVE_ANNEE, e.getAnneeScol());
        value.put(ELEVE_LOGINPARENT, e.getLoginParent());
        value.put(ELEVE_LASTTIMEONLINE, e.getLastTimeOnline());
        return db.insert(ELEVE_TABLE_NAME,null,value);
    }

    public int suppEleve(Eleve e){
        String where = ELEVE_LOGIN +" = ?";
        String[] whereArgs = {e.getLogin()+""};
        return db.delete(ELEVE_TABLE_NAME, where, whereArgs);
    }

    public int modEleve(Eleve e){
        ContentValues value = new ContentValues();
        String where = ELEVE_LOGIN+" = ?";
        String[] whereArgs = {e.getLogin()+""};
//        value.put(EleveManager.ELEVE_KEY,e.getId());
        value.put(ELEVE_NOM,e.getNom());
        value.put(ELEVE_PRENOM,e.getPrenom());
        value.put(ELEVE_LOGIN,e.getLogin());
        value.put(ELEVE_MDP,e.getMdp());
        value.put(ELEVE_EMAIL,e.getEmail());
        value.put(ELEVE_FORMULE,e.getFormule());
        value.put(ELEVE_NIVEAU,e.getNivScol());
        value.put(ELEVE_ANNEE,e.getAnneeScol());
        value.put(ELEVE_LOGINPARENT,e.getLoginParent());
        value.put(ELEVE_LASTTIMEONLINE,e.getLastTimeOnline());
        return db.update(ELEVE_TABLE_NAME, value, where, whereArgs);
    }

    public int modDate(String login, String date){
        ContentValues value = new ContentValues();
        String where = ELEVE_LOGIN+" = ?";
        String[] whereArgs = {login+""};
        value.put(ELEVE_LASTTIMEONLINE,date);
        return db.update(ELEVE_TABLE_NAME, value, where, whereArgs);
    }

    // Retourne l'element dont l'id est passé en paramètre
    public Eleve getEleve(String login) {
        Eleve a=new Eleve("","","","","","","","", "", "");

        Cursor c = db.rawQuery("SELECT * FROM "+ELEVE_TABLE_NAME+" WHERE "+ELEVE_LOGIN+"=\""+login + "\"", null);
        if (c.moveToFirst()) {
//            a.setId(c.getInt(c.getColumnIndex(ELEVE_KEY)));
            a.setNom(c.getString(c.getColumnIndex(ELEVE_NOM)));
            a.setPrenom(c.getString(c.getColumnIndex(ELEVE_PRENOM)));
            a.setLogin(c.getString(c.getColumnIndex(ELEVE_LOGIN)));
            a.setMdp(c.getString(c.getColumnIndex(ELEVE_MDP)));
            a.setEmail(c.getString(c.getColumnIndex(ELEVE_EMAIL)));
            a.setFormule(c.getString(c.getColumnIndex(ELEVE_FORMULE)));
            a.setNivScol(c.getString(c.getColumnIndex(ELEVE_NIVEAU)));
            a.setAnneeScol(c.getString(c.getColumnIndex(ELEVE_ANNEE)));
            a.setLoginParent(c.getString(c.getColumnIndex(ELEVE_LOGINPARENT)));
            a.setLastTimeOnline(c.getString(c.getColumnIndex(ELEVE_LASTTIMEONLINE)));
            c.close();
        }
        return a;
    }

    public ArrayList<String> getNomEleveLoginParent(String login){
        ArrayList<String> listNom = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM "+ELEVE_TABLE_NAME+" WHERE "+ELEVE_LOGINPARENT+"=\""+login + "\"", null);
        if (c.moveToFirst()) {
            do {
                listNom.add(c.getString(c.getColumnIndex(EleveManager.ELEVE_NOM)));
            }
            while (c.moveToNext());
        }
        return listNom;
    }

    public ArrayList<String> getPrenomEleveLoginParent(String login){
        ArrayList<String> listPrenom = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM "+ELEVE_TABLE_NAME+" WHERE "+ELEVE_LOGINPARENT+"=\""+login + "\"", null);
        if (c.moveToFirst()) {
            do {
                listPrenom.add(c.getString(c.getColumnIndex(EleveManager.ELEVE_PRENOM)));
            }
            while (c.moveToNext());
        }
        c.close();
        return listPrenom;
    }

    // sélection de tous les enregistrements de la table
    public Cursor getAllEleve() {
        return db.rawQuery("SELECT * FROM " + ELEVE_TABLE_NAME, null);
    }

    public boolean peutSeCo(String login, String mdp_taper){   //Fonction qui permet de vérifier les logins pour se connecter
        Cursor c = db.rawQuery("SELECT * FROM " + ELEVE_TABLE_NAME + " WHERE " + ELEVE_LOGIN + "=\"" + login + "\"", null);
        if (c.moveToFirst()) {
            if (getEleve(login).getMdp().contentEquals(mdp_taper)) {
                c.close();
                return true;
            }
            c.close();
        }
        return false;
    }

}