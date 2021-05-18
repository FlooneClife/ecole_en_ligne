package com.example.ecole_en_ligne;

import com.example.ecole_en_ligne.bdd.Eleve;

import java.util.ArrayList;

public class Common_bdd {
    private static ArrayList<Eleve> bddEleve = new ArrayList<Eleve>(); //Base de données temporaire pour les eleves
    private static ArrayList<Parent> bddParent = new ArrayList<Parent>(); //Base de données temporaire pour les eleves

    public static void addEleve(Eleve e){
        bddEleve.add(e);
        System.out.println("eleve ajouté");
        System.out.println("taille bdd : "+bddEleve.size());
        System.out.println(e.getLogin() + " && " + e.getMdp());

    }

    public static void addParent(Parent p){
        bddParent.add(p);
    }

    public static Eleve getEleveByLogin(String login){
        for (Eleve e : bddEleve) {
            if (e.getLogin().equals(login)){
                return e;
            }
        }
        return null;
    }

    public static Parent getParentByLogin(String login){
        for (Parent p : bddParent) {
            if (p.getLogin().equals(login)){
                return p;
            }
        }
        return null;
    }

    public static boolean peutSeCo(String login, String mdp_taper){   //Fonction qui permet de vérifier les logins pour se connecter
        if(getEleveByLogin(login) == null || !getEleveByLogin(login).getMdp().contentEquals(mdp_taper)){
            return false;
        }
        return true;
    }

    public static boolean peutSeCoParent(String login, String mdp_taper){   //Fonction qui permet de vérifier les logins pour se connecter
        if(getParentByLogin(login) == null || !getParentByLogin(login).getMdp().contentEquals(mdp_taper)){
            return false;
        }
        return true;
    }

    public static void modifMdpEleve(String login, String newMdp){ //Pour la modification de mot de passe, si mdp oublié
        for (Eleve e : bddEleve) {
            if(e.getLogin().contentEquals(login)){
                e.setMdp(newMdp);
            }
        }
    }

}
