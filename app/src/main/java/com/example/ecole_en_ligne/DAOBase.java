package com.example.ecole_en_ligne;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class DAOBase {
    protected final static int VERSION = 1;
    protected final static String NOM = "database.db";

    protected SQLiteDatabase mDb = null;
    protected DataBase dataBase = null;

    public DAOBase(Context pContext) {
        this.dataBase = new DataBase(pContext, NOM, null, VERSION);
    }

    public SQLiteDatabase open() {
        mDb = dataBase.getWritableDatabase();
        return mDb;
    }

    public void close() {
        mDb.close();
    }

    public SQLiteDatabase getDb() {
        return mDb;
    }

}
