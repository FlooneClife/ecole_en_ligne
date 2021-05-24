package com.example.ecole_en_ligne.bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RappelsManager {

    private static final String RAPPELS_TABLE_NAME = "Rappels";
    public static final String RAPPELS_ID = "id";
    public static final String RAPPELS_ELEVE = "loginEleve";
    public static final String RAPPELS_PARENT = "loginParent";
    public static final String RAPPELS_HEURE = "heure";

    public static final String RAPPELS_TABLE_CREATE =
            "CREATE TABLE " + RAPPELS_TABLE_NAME + " (" +
                    RAPPELS_ID + " INTEGER PRIMARY KEY, " +
                    RAPPELS_ELEVE + " TEXT, " +
                    RAPPELS_PARENT + " TEXT, " +
                    RAPPELS_HEURE + " TEXT);";

    private MySQLite mDb;
    private SQLiteDatabase db;

    public static final String ELEVE_TABLE_DROP = "DROP TABLE IF EXISTS " + RAPPELS_TABLE_NAME + ";";

    //constructeur
    public RappelsManager(Context pContext) {
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

    public long addRappels(Rappels r){
        ContentValues value = new ContentValues();
//        value.put(EleveManager.ELEVE_KEY,e.getId());
        value.put(RAPPELS_ID, r.getId());
        value.put(RAPPELS_ELEVE, r.getLoginEleve());
        value.put(RAPPELS_PARENT, r.getLoginParent());
        value.put(RAPPELS_HEURE, r.getHeure());
        return db.insert(RAPPELS_TABLE_NAME,null,value);
    }

    public int suppRappels(Rappels r){
        String where = RAPPELS_ID +" = ?";
        String[] whereArgs = {r.getId()+""};
        return db.delete(RAPPELS_TABLE_NAME, where, whereArgs);
    }

    public Rappels getRappels(int id) {
        Rappels r=new Rappels(-1,"","","");
        Cursor c = db.rawQuery("SELECT * FROM "+ RAPPELS_TABLE_NAME+" WHERE "+RAPPELS_ID+"="+id, null);
        if (c.moveToFirst()) {
            r.setId(c.getInt(c.getColumnIndex(RAPPELS_ID)));
            r.setLoginEleve(c.getString(c.getColumnIndex(RAPPELS_ELEVE)));
            r.setLoginParent(c.getString(c.getColumnIndex(RAPPELS_PARENT)));
            r.setHeure(c.getString(c.getColumnIndex(RAPPELS_HEURE)));
            c.close();
        }
        return r;
    }

    public Rappels getRappelsByStudent(String loginEleve) {
        Rappels r=new Rappels(-1,"","","");
        Cursor c = db.rawQuery("SELECT * FROM "+ RAPPELS_TABLE_NAME+" WHERE "+RAPPELS_ELEVE+"=\""+loginEleve + "\"", null);
        if (c.moveToFirst()) {
            r.setId(c.getInt(c.getColumnIndex(RAPPELS_ID)));
            r.setLoginEleve(c.getString(c.getColumnIndex(RAPPELS_ELEVE)));
            r.setLoginParent(c.getString(c.getColumnIndex(RAPPELS_PARENT)));
            r.setHeure(c.getString(c.getColumnIndex(RAPPELS_HEURE)));
            c.close();
        }
        return r;
    }

    public Rappels getRappelsByParent(String loginParent) {
        Rappels r=new Rappels(-1,"","","");
        Cursor c = db.rawQuery("SELECT * FROM "+ RAPPELS_TABLE_NAME+" WHERE "+RAPPELS_PARENT+"=\""+loginParent + "\"", null);
        if (c.moveToFirst()) {
            r.setId(c.getInt(c.getColumnIndex(RAPPELS_ID)));
            r.setLoginEleve(c.getString(c.getColumnIndex(RAPPELS_ELEVE)));
            r.setLoginParent(c.getString(c.getColumnIndex(RAPPELS_PARENT)));
            r.setHeure(c.getString(c.getColumnIndex(RAPPELS_HEURE)));
            c.close();
        }
        return r;
    }

    public Cursor getAllRappels() {
        return db.rawQuery("SELECT * FROM " + RAPPELS_TABLE_NAME, null);
    }

}
