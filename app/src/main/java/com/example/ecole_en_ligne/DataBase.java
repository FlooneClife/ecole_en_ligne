package com.example.ecole_en_ligne;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    public static final String ELEVE_KEY = "ID_ELEVE";
    public static final String ELEVE_NOM = "NOM_ELEVE";
    public static final String ELEVE_PRENOM = "PRENOM_ELEVE";
    public static final String ELEVE_LOGIN = "LOGIN_ELEVE";
    public static final String ELEVE_MDP = "MDP_ELEVE";
    public static final String ELEVE_EMAIL = "EMAIL_ELEVE";
    public static final String ELEVE_TABLE_NAME = "ELEVES_INSCRIPTION";

    public static final String PARENT_KEY = "ID_PARENT";
    public static final String PARENT_NOM = "NOM_PARENT";
    public static final String PARENT_PRENOM = "PRENOM_PARENT";
    public static final String PARENT_LOGIN = "LOGIN_PARENT";
    public static final String PARENT_MDP = "MDP_PARENT";
    public static final String PARENT_EMAIL = "EMAIL_PARENT";
    public static final String PARENT_NBENFANTS = "NBENFANTS_PARENT";
    public static final String PARENT_TABLE_NAME = "PARENTS_INSCRIPTION";



    public static final String ELEVE_TABLE_CREATE =
            "CREATE TABLE " + ELEVE_TABLE_NAME + "("+
                    ELEVE_KEY + "INTERGER PRIMARY KEY AUTOINCREMENT," +
                    ELEVE_NOM + "TEXT,"+
                    ELEVE_PRENOM + "TEXT,"+
                    ELEVE_LOGIN + "TEXT,"+
                    ELEVE_MDP + "TEXT,"+
                    ELEVE_EMAIL + "TEXT);";

    public static final String PARENT_TABLE_CREATE =
            "CREATE TABLE " + PARENT_TABLE_NAME + "("+
                    PARENT_KEY + "INTERGER PRIMARY KEY AUTOINCREMENT," +
                    PARENT_NOM + "TEXT,"+
                    PARENT_PRENOM + "TEXT,"+
                    PARENT_LOGIN + "TEXT,"+
                    PARENT_MDP + "TEXT,"+
                    PARENT_EMAIL + "TEXT," +
                    PARENT_NBENFANTS + "REAL);";


    public static final String ELEVE_TABLE_DROP = "DROP TABLE IF EXISTS " + ELEVE_TABLE_NAME + ";";
    public static final String PARENT_TABLE_DROP = "DROP TABLE IF EXISTS " + PARENT_TABLE_NAME + ";";


    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ELEVE_TABLE_DROP);
        db.execSQL(PARENT_TABLE_DROP);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(ELEVE_TABLE_CREATE);
            db.execSQL(PARENT_TABLE_CREATE);
    }
}
