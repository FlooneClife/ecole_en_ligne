package com.example.ecole_en_ligne.bdd;

public class Exercice {

    private int id;
    private String loginEleve;
    private String loginParent;
    private int termine;    //0:false, 1:true

    public Exercice(int id, String loginEleve, String loginParent, int termine) {
        this.id = id;
        this.loginEleve = loginEleve;
        this.loginParent = loginParent;
        this.termine = termine;
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

    public int getTermine() {
        return termine;
    }

    public void setTermine(int termine) {
        this.termine = termine;
    }

}
