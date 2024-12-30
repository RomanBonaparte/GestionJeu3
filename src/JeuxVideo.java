//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.UUID;

public class JeuxVideo {
    private static int count = 1;
    private int id;
    private UUID identifiant;
    private String nom;
    private String developpeur;
    private String annee;
    private int pegi;
    private boolean libre = true;

    public JeuxVideo(String nom, String developpeur, String annee, int pegi) {
        this.nom = nom;
        this.developpeur = developpeur;
        this.annee = annee;
        this.pegi = pegi;
        this.identifiant = Application.getInstance().genererId();
        this.id = count++;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        JeuxVideo.count = count;
    }

    public UUID getIdentifiant() {
        return this.identifiant;
    }

    public void setIdentifiant(UUID identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDeveloppeur() {
        return this.developpeur;
    }

    public void setDeveloppeur(String developpeur) {
        this.developpeur = developpeur;
    }

    public String getAnnee() {
        return this.annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public int getPegi() {
        return this.pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public boolean isLibre() {
        return this.libre;
    }

    public void setLibre(boolean livre) {
        this.libre = livre;
    }
}
