package com.example.ecole_en_ligne.bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ParentManager {
    private static final String PARENT_TABLE_NAME = "Parent";
    public static final String PARENT_NOM = "nom";
    public static final String PARENT_PRENOM = "prenom";
    public static final String PARENT_LOGIN = "login";
    public static final String PARENT_MDP = "mdp";
    public static final String PARENT_EMAIL = "email";
    public static final String PARENT_NBENFANTS = "nbEnfant";

    public static final String PARENT_TABLE_CREATE =
            "CREATE TABLE " + PARENT_TABLE_NAME + " ("+
//                    PARENT_KEY + "INTEGER PRIMARY KEY NOT NULL," +
                    PARENT_NOM + " TEXT, "+
                    PARENT_PRENOM + " TEXT, "+
                    PARENT_LOGIN + " TEXT PRIMARY KEY, "+
                    PARENT_MDP + " TEXT, "+
                    PARENT_EMAIL + " TEXT, "+
                    PARENT_NBENFANTS + " INTEGER);";

    private MySQLite mDb;
    private SQLiteDatabase db;

    public static final String PARENT_TABLE_DROP = "DROP TABLE IF EXISTS " + PARENT_TABLE_NAME + ";";

    //constructeur
    public ParentManager(Context pContext) {
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

    public long addParent(Parent p){
        ContentValues value = new ContentValues();
//        value.put(ParentManager.PARENT_KEY,e.getId());
        value.put(PARENT_NOM, p.getNom());
        value.put(PARENT_PRENOM, p.getPrenom());
        value.put(PARENT_LOGIN, p.getLogin());
        value.put(PARENT_MDP, p.getMdp());
        value.put(PARENT_EMAIL, p.getEmail());
        value.put(PARENT_NBENFANTS, p.getNbEnfant());
        return db.insert(PARENT_TABLE_NAME,null,value);
    }

    public int suppParent(Parent p){
        String where = PARENT_LOGIN +" = ?";
        String[] whereArgs = {p.getLogin()+""};
        return db.delete(PARENT_TABLE_NAME, where, whereArgs);
    }

    public int modParent(Parent p){
        ContentValues value = new ContentValues();
        String where = PARENT_LOGIN+" = ?";
        String[] whereArgs = {p.getLogin()+""};
        value.put(PARENT_NOM,p.getNom());
        value.put(PARENT_PRENOM,p.getPrenom());
        value.put(PARENT_LOGIN,p.getLogin());
        value.put(PARENT_MDP,p.getMdp());
        value.put(PARENT_EMAIL,p.getEmail());
        value.put(PARENT_NBENFANTS,p.getNbEnfant());
        return db.update(PARENT_TABLE_NAME, value, where, whereArgs);
    }

    // Retourne l'element dont l'id est passé en paramètre
    public Parent getParent(String login) {
        Parent a=new Parent("","","","","",0);

        Cursor c = db.rawQuery("SELECT * FROM "+PARENT_TABLE_NAME+" WHERE "+PARENT_LOGIN+"=\""+login + "\"", null);
        if (c.moveToFirst()) {
//            a.setId(c.getInt(c.getColumnIndex(PARENT_KEY)));
            a.setNom(c.getString(c.getColumnIndex(PARENT_NOM)));
            a.setPrenom(c.getString(c.getColumnIndex(PARENT_PRENOM)));
            a.setLogin(c.getString(c.getColumnIndex(PARENT_LOGIN)));
            a.setMdp(c.getString(c.getColumnIndex(PARENT_MDP)));
            a.setEmail(c.getString(c.getColumnIndex(PARENT_EMAIL)));
            a.setNbEnfant(c.getInt(c.getColumnIndex(PARENT_NBENFANTS)));
            c.close();
        }
        return a;
    }

    // sélection de tous les enregistrements de la table
    public Cursor getAllParent() {
        return db.rawQuery("SELECT * FROM " + PARENT_TABLE_NAME, null);
    }

    public boolean peutSeCo(String login, String mdp_taper){   //Fonction qui permet de vérifier les logins pour se connecter
        Cursor c = db.rawQuery("SELECT * FROM "+PARENT_TABLE_NAME+" WHERE "+PARENT_LOGIN+"=\""+login + "\"", null);
        if (c.moveToFirst()) {
            if (getParent(login).getMdp().contentEquals(mdp_taper)) {
                c.close();
                return true;
            }
            c.close();
        }
        return false;
    }

}