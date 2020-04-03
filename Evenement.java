/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author YURI
 */
public class Evenement {
    
    
       private int ref ;
    private int nbPart ;
    private String titre ;
    private String description ;
    private String date ;   //Date.valueOf("yyyy-mm-dd")
    private String ville ;

    public Evenement(int ref, int nbPart, String titre, String description, String date, String ville) {
        this.ref = ref;
        this.nbPart = nbPart;
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.ville = ville;
    }

    public Evenement(int nbPart, String titre, String description, String date, String ville) {
        this.nbPart = nbPart;
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.ville = ville;
    }

    public Evenement() {
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getNbPart() {
        return nbPart;
    }

    public void setNbPart(int nbPart) {
        this.nbPart = nbPart;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Evenement{" + "ref=" + ref + ", nbPart=" + nbPart + ", titre=" + titre + ", description=" + description + ", date=" + date + ", ville=" + ville + '}';
    }
    
}
