package com.example.ecole_en_ligne.bdd;

public class Eleve {
//    private long id;
    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    private String email;
    private String formule;
    private String nivScol;
    private String anneeScol;

    public Eleve(String nom, String prenom, String login, String mdp, String email, String formule, String nivScol, String anneeScol) {
        super();
//        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
        this.email = email;
        this.formule = formule;
        this.nivScol = nivScol;
        this.anneeScol = anneeScol;
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormule() {
        return formule;
    }

    public void setFormule(String formule) {
        this.formule = formule;
    }

    public String getNivScol() {
        return nivScol;
    }

    public void setNivScol(String nivScol) {
        this.nivScol = nivScol;
    }

    public String getAnneeScol() {
        return anneeScol;
    }

    public void setAnneeScol(String anneeScol) {
        this.anneeScol = anneeScol;
    }
}
