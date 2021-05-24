package com.example.ecole_en_ligne.bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RecommandationsManager {private static final String RECOMMANDATIONS_TABLE_NAME = "Recommandations";
    public static final String RECOMMANDATIONS_ID = "id";
    public static final String RECOMMANDATIONS_ELEVE = "loginEleve";
    public static final String RECOMMANDATIONS_PARENT = "loginParent";
    public static final String RECOMMANDATIONS_TEXT = "heure";

    public static final String RECOMMANDATIONS_TABLE_CREATE =
            "CREATE TABLE " + RECOMMANDATIONS_TABLE_NAME + " (" +
                    RECOMMANDATIONS_ID + " INTEGER PRIMARY KEY, " +
                    RECOMMANDATIONS_ELEVE + " TEXT, " +
                    RECOMMANDATIONS_PARENT + " TEXT, " +
                    RECOMMANDATIONS_TEXT + " TEXT);";

    private MySQLite mDb;
    private SQLiteDatabase db;

    public static final String RECOMMANDATIONS_TABLE_DROP = "DROP TABLE IF EXISTS " + RECOMMANDATIONS_TABLE_NAME + ";";

    //constructeur
    public RecommandationsManager(Context pContext) {
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

    public long addRecommandations(Recommandations r){
        ContentValues value = new ContentValues();
//        value.put(EleveManager.ELEVE_KEY,e.getId());
        value.put(RECOMMANDATIONS_ID, r.getId());
        value.put(RECOMMANDATIONS_ELEVE, r.getLoginEleve());
        value.put(RECOMMANDATIONS_PARENT, r.getLoginParent());
        value.put(RECOMMANDATIONS_TEXT, r.getText());
        return db.insert(RECOMMANDATIONS_TABLE_NAME,null,value);
    }

    public int suppRecommandations(Recommandations r){
        String where = RECOMMANDATIONS_ID +" = ?";
        String[] whereArgs = {r.getId()+""};
        return db.delete(RECOMMANDATIONS_TABLE_NAME, where, whereArgs);
    }

    public Recommandations getRecommandations(int id) {
        Recommandations r=new Recommandations(-1,"","","");
        Cursor c = db.rawQuery("SELECT * FROM "+ RECOMMANDATIONS_TABLE_NAME +" WHERE "+ RECOMMANDATIONS_ID +"="+id, null);
        if (c.moveToFirst()) {
            r.setId(c.getInt(c.getColumnIndex(RECOMMANDATIONS_ID)));
            r.setLoginEleve(c.getString(c.getColumnIndex(RECOMMANDATIONS_ELEVE)));
            r.setLoginParent(c.getString(c.getColumnIndex(RECOMMANDATIONS_PARENT)));
            r.setText(c.getString(c.getColumnIndex(RECOMMANDATIONS_TEXT)));
            c.close();
        }
        return r;
    }

    public Recommandations getRecommandationsByStudent(String loginEleve) {
        Recommandations r=new Recommandations(-1,"","","");
        Cursor c = db.rawQuery("SELECT * FROM "+ RECOMMANDATIONS_TABLE_NAME +" WHERE "+ RECOMMANDATIONS_ELEVE +"=\""+loginEleve + "\"", null);
        if (c.moveToFirst()) {
            r.setId(c.getInt(c.getColumnIndex(RECOMMANDATIONS_ID)));
            r.setLoginEleve(c.getString(c.getColumnIndex(RECOMMANDATIONS_ELEVE)));
            r.setLoginParent(c.getString(c.getColumnIndex(RECOMMANDATIONS_PARENT)));
            r.setText(c.getString(c.getColumnIndex(RECOMMANDATIONS_TEXT)));
            c.close();
        }
        return r;
    }

    public Recommandations getRecommandationsByParent(String loginParent) {
        Recommandations r=new Recommandations(-1,"","","");
        Cursor c = db.rawQuery("SELECT * FROM "+ RECOMMANDATIONS_TABLE_NAME +" WHERE "+ RECOMMANDATIONS_PARENT +"=\""+loginParent + "\"", null);
        if (c.moveToFirst()) {
            r.setId(c.getInt(c.getColumnIndex(RECOMMANDATIONS_ID)));
            r.setLoginEleve(c.getString(c.getColumnIndex(RECOMMANDATIONS_ELEVE)));
            r.setLoginParent(c.getString(c.getColumnIndex(RECOMMANDATIONS_PARENT)));
            r.setText(c.getString(c.getColumnIndex(RECOMMANDATIONS_TEXT)));
            c.close();
        }
        return r;
    }

    public Cursor getAllRecommandations() {
        return db.rawQuery("SELECT * FROM " + RECOMMANDATIONS_TABLE_NAME, null);
    }

}
