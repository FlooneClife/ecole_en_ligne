package com.example.ecole_en_ligne.bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Manager {

    private static final String TABLE_NAME = "Test";
    public static final String KEY_ID_ANIMAL="id";
    public static final String KEY_NOM_ANIMAL="nom";
    public static final String CREATE_TABLE_ANIMAL = "CREATE TABLE "+TABLE_NAME+
            " (" +
            " "+KEY_ID_ANIMAL+" INTEGER primary key," +
            " "+KEY_NOM_ANIMAL+" TEXT" +
            ");";
    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur
    public Manager(Context context)
    {
        maBaseSQLite = MySQLite.getInstance(context);
    }

    public void open()
    {
        //on ouvre la table en lecture/écriture
        db = maBaseSQLite.getWritableDatabase();
    }

    public void close()
    {
        //on ferme l'accès à la BDD
        db.close();
    }

    public long addAnimal(Test test) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_NOM_ANIMAL, test.getNom());

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME,null,values);
    }

    public int modAnimal(Test test) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_NOM_ANIMAL, test.getNom());

        String where = KEY_ID_ANIMAL+" = ?";
        String[] whereArgs = {test.getId()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supAnimal(Test test) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_ANIMAL+" = ?";
        String[] whereArgs = {test.getId()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public Test getAnimal(int id) {
        // Retourne l'animal dont l'id est passé en paramètre
        Test a=new Test(0,"");

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID_ANIMAL+"="+id, null);
        if (c.moveToFirst()) {
            a.setId(c.getInt(c.getColumnIndex(KEY_ID_ANIMAL)));
            a.setNom(c.getString(c.getColumnIndex(KEY_NOM_ANIMAL)));
            c.close();
        }

        return a;
    }

    public Cursor getAnimaux() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }

}
