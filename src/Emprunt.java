//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.LocalDate;

public class Emprunt {
    private int[] id;
    private Client client;
    private JeuxVideo jeu;
    private LocalDate dateDeb;
    private LocalDate dateFin;

    public Emprunt(Client client, JeuxVideo jeu, LocalDate dateDeb) {
        this.client = client;
        this.jeu = jeu;
        this.dateDeb = dateDeb;
        this.dateFin = this.calculateDateFin(dateDeb);
        this.id = this.generateId(this.client.getId(), this.jeu.getId());
    }

    private int[] generateId(int clientId, int jeuId) {
        return new int[]{clientId, jeuId};
    }

    public int[] getId() {
        return this.id;
    }

    public void setId(int[] id) {
        this.id = id;
    }

    private LocalDate calculateDateFin(LocalDate dateDeb) {
        int dureeEmpruntMois = 5;
        return dateDeb.plusMonths((long)dureeEmpruntMois);
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public JeuxVideo getJeu() {
        return this.jeu;
    }

    public void setJeu(JeuxVideo jeu) {
        this.jeu = jeu;
    }

    public LocalDate getDateDeb() {
        return this.dateDeb;
    }

    public void setDateDeb(LocalDate dateDeb) {
        this.dateDeb = dateDeb;
    }

    public LocalDate getDateFin() {
        return this.dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public boolean islate() {
        LocalDate now = LocalDate.now();
        return this.getDateFin().isBefore(now);
    }

    public void afficheloeurjeu() {
        System.out.println("le client est " + this.id[0]);
        System.out.println("le jeu est " + this.id[1]);
    }
}
