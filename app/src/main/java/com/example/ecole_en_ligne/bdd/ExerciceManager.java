package com.example.ecole_en_ligne.bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ExerciceManager {

    private static final String EXERCICE_TABLE_NAME = "Exercice";
    private static final String EXERCICE_ID = "id";
    public static final String EXERCICE_LOGINELEVE = "loginEleve";
    public static final String EXERCICE_LOGINPARENT = "loginParent";
    public static final String EXERCICE_TERMINE = "termine";

    public static final String EXERCICE_TABLE_CREATE =
            "CREATE TABLE " + EXERCICE_TABLE_NAME + " ("+
//                    ELEVE_KEY + "INTEGER PRIMARY KEY NOT NULL," +
                    EXERCICE_ID + " INTEGER PRIMARY KEY, "+
                    EXERCICE_LOGINELEVE + " TEXT, "+
                    EXERCICE_LOGINPARENT + " TEXT, "+
                    EXERCICE_TERMINE + " INTEGER);";

    private MySQLite mDb;
    private SQLiteDatabase db;

    public static final String EXERCICE_TABLE_DROP = "DROP TABLE IF EXISTS " + EXERCICE_TABLE_NAME + ";";

    //constructeur
    public ExerciceManager(Context pContext) {
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

    public long addExercice(Exercice e){
        ContentValues value = new ContentValues();
//        value.put(EleveManager.ELEVE_KEY,e.getId());
        value.put(EXERCICE_ID, e.getId());
        value.put(EXERCICE_LOGINELEVE, e.getLoginEleve());
        value.put(EXERCICE_LOGINPARENT, e.getLoginParent());
        value.put(EXERCICE_TERMINE, e.getTermine());
        return db.insert(EXERCICE_TABLE_NAME,null,value);
    }

    public int suppExercice(Exercice e){
        String where = EXERCICE_ID +" = ?";
        String[] whereArgs = {e.getId()+""};
        return db.delete(EXERCICE_TABLE_NAME, where, whereArgs);
    }

    public int modExercice(Exercice e){
        ContentValues value = new ContentValues();
        String where = EXERCICE_ID +" = ?";
        String[] whereArgs = {e.getId()+""};
        value.put(EXERCICE_ID,e.getId());
        value.put(EXERCICE_LOGINELEVE,e.getLoginEleve());
        value.put(EXERCICE_LOGINPARENT,e.getLoginParent());
        value.put(EXERCICE_TERMINE,e.getTermine());
        return db.update(EXERCICE_TABLE_NAME, value, where, whereArgs);
    }

    public Exercice getExercice(int id) {
        Exercice a = new Exercice(-1, "", "", -1);

        Cursor c = db.rawQuery("SELECT * FROM " + EXERCICE_TABLE_NAME + " WHERE " + EXERCICE_ID + "=" + id, null);
        if (c.moveToFirst()) {
            a.setId(c.getInt(c.getColumnIndex(EXERCICE_ID)));
            a.setLoginEleve(c.getString(c.getColumnIndex(EXERCICE_LOGINELEVE)));
            a.setLoginParent(c.getString(c.getColumnIndex(EXERCICE_LOGINPARENT)));
            a.setTermine(c.getInt(c.getColumnIndex(EXERCICE_TERMINE)));
            c.close();
        }
        return a;
    }

    // sélection de tous les enregistrements de la table
    public Cursor getAllExercice() {
        return db.rawQuery("SELECT * FROM " + EXERCICE_TABLE_NAME, null);
    }

    public int nbExosFait(String login){
        int cpt =0 ;
        Cursor c = db.rawQuery("SELECT * FROM " + EXERCICE_TABLE_NAME+ " WHERE " + EXERCICE_TERMINE + "=" + 1 + " AND " + EXERCICE_LOGINELEVE +"=\"" + login + "\"", null);
        if (c.moveToFirst()) {
            do {
                cpt ++;
            }
            while (c.moveToNext());
        }
        return cpt;
    }

    public int nbExosTotal(String login){
        int cpt =0 ;
        Cursor c = db.rawQuery("SELECT * FROM " + EXERCICE_TABLE_NAME+ " WHERE " + EXERCICE_LOGINELEVE + "=\"" + login + "\"", null);
        if (c.moveToFirst()) {
            do {
                cpt ++;
            }
            while (c.moveToNext());
        }
        return cpt;
    }

    public int aTermine(Exercice e){
        ContentValues value = new ContentValues();
        String where = EXERCICE_ID +" = ?";
        String[] whereArgs = {e.getId()+""};
        value.put(EXERCICE_TERMINE,"1");
        return db.update(EXERCICE_TABLE_NAME, value, where, whereArgs);
    }

}