//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

public class GestionJeu {
    private static GestionJeu Singleton;
    private ArrayList<JeuxVideo> liste = new ArrayList();

    public GestionJeu() {
    }

    public static GestionJeu getInstance() {
        if (Singleton == null) {
            Singleton = new GestionJeu();
        }

        return Singleton;
    }

    public void init() {
        String[] nom = new String[]{"Escape the backrooms", "Ready Or Not", "Supreme Commander", "Lethal Company"};
        String[] dev = new String[]{"Fancy Games", "Void Studio", "Gas Powered Games", "Zeekerss"};
        String[] sortie = new String[]{"2022", "2021", "2007", "2023"};
        int[] pegi = new int[]{12, 16, 12, 12};

        for(int i = 0; i < nom.length; ++i) {
            JeuxVideo jeu = new JeuxVideo(nom[i], dev[i], sortie[i], pegi[i]);
            this.liste.add(jeu);
        }

    }

    public static GestionJeu getSingleton() {
        return Singleton;
    }

    public static void setSingleton(GestionJeu singleton) {
        Singleton = singleton;
    }

    public ArrayList<JeuxVideo> getListe() {
        return this.liste;
    }

    public void setListe(ArrayList<JeuxVideo> liste) {
        this.liste = liste;
    }

    public void deleteGame(int index) {
        this.liste.remove(index);
    }

    public void addGame(JeuxVideo jeu) {
        this.liste.add(jeu);
    }

    public void modifierJeu(int index, JeuxVideo jeu) {
        ((JeuxVideo)this.liste.get(index)).setNom(jeu.getNom());
        ((JeuxVideo)this.liste.get(index)).setAnnee(jeu.getAnnee());
        ((JeuxVideo)this.liste.get(index)).setDeveloppeur(jeu.getDeveloppeur());
        ((JeuxVideo)this.liste.get(index)).setPegi(jeu.getPegi());
    }
}
