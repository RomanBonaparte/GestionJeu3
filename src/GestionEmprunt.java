//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionEmprunt {
    private static GestionEmprunt Singleton;
    private ArrayList<Emprunt> liste = new ArrayList();

    public GestionEmprunt() {
    }

    public static GestionEmprunt getInstance() {
        if (Singleton == null) {
            Singleton = new GestionEmprunt();
        }

        return Singleton;
    }

    public void init() {
        LocalDate datedeb = LocalDate.now();
        this.liste.add(new Emprunt((Client)GestionClient.getSingleton().getListe().get(0), (JeuxVideo)GestionJeu.getInstance().getListe().get(0), datedeb));
        ((JeuxVideo)GestionJeu.getInstance().getListe().get(0)).setLibre(false);
        datedeb = datedeb.plusWeeks(1L);
        this.liste.add(new Emprunt((Client)GestionClient.getSingleton().getListe().get(1), (JeuxVideo)GestionJeu.getInstance().getListe().get(1), datedeb));
        ((JeuxVideo)GestionJeu.getInstance().getListe().get(1)).setLibre(false);
        datedeb = datedeb.plusWeeks(2L);
        this.liste.add(new Emprunt((Client)GestionClient.getSingleton().getListe().get(2), (JeuxVideo)GestionJeu.getInstance().getListe().get(2), datedeb));
        ((JeuxVideo)GestionJeu.getInstance().getListe().get(2)).setLibre(false);
        datedeb = datedeb.plusWeeks(3L);
        this.liste.add(new Emprunt((Client)GestionClient.getSingleton().getListe().get(3), (JeuxVideo)GestionJeu.getInstance().getListe().get(3), datedeb));
        ((JeuxVideo)GestionJeu.getInstance().getListe().get(3)).setLibre(false);
    }

    public Emprunt getEmpruntById(int[] id) {
        for(Emprunt emprunt : this.liste) {
            if (emprunt.getId()[0] == id[0] && emprunt.getId()[1] == id[1]) {
                return emprunt;
            }
        }

        return null;
    }

    public static GestionEmprunt getSingleton() {
        return Singleton;
    }

    public static void setSingleton(GestionEmprunt singleton) {
        Singleton = singleton;
    }

    public ArrayList<Emprunt> getListe() {
        return this.liste;
    }

    public void setListe(ArrayList<Emprunt> liste) {
        this.liste = liste;
    }
}
