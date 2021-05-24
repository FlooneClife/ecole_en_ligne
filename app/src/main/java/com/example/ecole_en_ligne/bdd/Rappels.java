package com.example.ecole_en_ligne.bdd;

public class Rappels {

    private int id;
    private String loginEleve;
    private String loginParent;
    private String heure;

    public Rappels(int id, String loginEleve, String loginParent, String heure) {
        this.id = id;
        this.loginEleve = loginEleve;
        this.loginParent = loginParent;
        this.heure = heure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginEleve() {
        return loginEleve;
    }

    public void setLoginEleve(String loginEleve) {
        this.loginEleve = loginEleve;
    }

    public String getLoginParent() {
        return loginParent;
    }

    public void setLoginParent(String loginParent) {
        this.loginParent = loginParent;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
