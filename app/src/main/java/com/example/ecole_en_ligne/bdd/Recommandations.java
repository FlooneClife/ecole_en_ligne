package com.example.ecole_en_ligne.bdd;

public class Recommandations {

    private int id;
    private String loginEleve;
    private String loginParent;
    private String text;

    public Recommandations(int id, String loginEleve, String loginParent, String text) {
        this.id = id;
        this.loginEleve = loginEleve;
        this.loginParent = loginParent;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
