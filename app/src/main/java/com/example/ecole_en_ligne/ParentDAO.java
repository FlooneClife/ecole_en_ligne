package com.example.ecole_en_ligne;

import android.content.Context;

public class ParentDAO extends DAOBase {
    public static final String PARENT_KEY = "ID_PARENT";
    public static final String PARENT_NOM = "NOM_PARENT";
    public static final String PARENT_PRENOM = "PRENOM_PARENT";
    public static final String PARENT_LOGIN = "LOGIN_PARENT";
    public static final String PARENT_MDP = "MDP_PARENT";
    public static final String PARENT_EMAIL = "EMAIL_PARENT";
    public static final String PARENT_NBENFANTS = "NBENFANTS_PARENT";
    public static final String PARENT_TABLE_NAME = "PARENTS_INSCRIPTION";


    public static final String PARENT_TABLE_CREATE =
            "CREATE TABLE " + PARENT_TABLE_NAME + "("+
                    PARENT_KEY + "INTERGER PRIMARY KEY AUTOINCREMENT," +
                    PARENT_NOM + "TEXT,"+
                    PARENT_PRENOM + "TEXT,"+
                    PARENT_LOGIN + "TEXT,"+
                    PARENT_MDP + "TEXT,"+
                    PARENT_EMAIL + "TEXT," +
                    PARENT_NBENFANTS + "REAL);";

    public static final String PARENT_TABLE_DROP = "DROP TABLE IF EXISTS " + PARENT_TABLE_NAME + ";";

    public ParentDAO(Context pContext) {
        super(pContext);
    }


    public void ajouter(Parent p){

    }

    public void supprimer(long id){

    }

    public void modifier(Parent p){

    }

    /*public Parent selectionner(long id){

    }*/

}
