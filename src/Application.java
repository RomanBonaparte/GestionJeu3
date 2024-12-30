//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Application {
    private static Application Singleton;
    private static Scanner scan;

    public Application() {
    }

    public static Application getInstance() {
        if (Singleton == null) {
            Singleton = new Application();
        }

        return Singleton;
    }

    public void launch() {
        Display dysplay = Display.getInstance();

        while(true) {
            dysplay.MainMenu();
        }
    }

    public void faireChoix(int choix) {
        GestionJeu jeu = GestionJeu.getInstance();
        Scanner scan = new Scanner(System.in);
        switch (choix) {
            case 1:
                System.out.println("vous avez choisi de générer le park");
                if (GestionJeu.getInstance().getListe().isEmpty()) {
                    jeu.init();
                } else {
                    System.out.println("le park a déjà été généré");
                }
                break;
            case 2:
                System.out.println("vous avez choisi d'afficher les jeux");
                Display.getInstance().afficherJeu();
                break;
            case 3:
                System.out.println("vous avez choisi de supprimer un jeu");
                int choixS = scan.nextInt();
                GestionJeu.getInstance().deleteGame(choixS - 1);
                break;
            case 4:
                System.out.println("vous avez choisi d'ajouter un jeu");
                Display.getInstance().ajouterJeu();
                break;
            case 5:
                System.out.println("vous avez choisi de modifier un jeu ");
                System.out.println("quel jeu souhaitez-vous modifier saisissez l'index");
                System.out.println(this.toStringintervaletailleTableau());
                int index = scan.nextInt();
                JeuxVideo jeuModifier = (JeuxVideo)GestionJeu.getInstance().getListe().get(index - 1);
                Display.getInstance().modifierjeu(index - 1, jeuModifier);
                break;
            case 6:
                System.out.println("vous avez choisi de générer les clients");
                if (GestionClient.getSingleton().estVide()) {
                    GestionClient.getSingleton().init();
                } else {
                    System.out.println("les clients ont déjà été généré");
                }
                break;
            case 7:
                System.out.println("vous avez choisi d'afficher les clients");
                Display.getInstance().afficherCli();
                break;
            case 8:
                Display.getInstance().ajouterClient();
                break;
            case 9:
                System.out.println("vous avez choisi de modifier  un client");
                System.out.println("quel Client souhaitez-vous modifier saisissez l'index");
                System.out.println(this.toStringintervaletailleTableauCli());
                int indexCli = scan.nextInt();
                Client ClientModif = (Client)GestionClient.getSingleton().getListe().get(indexCli - 1);
                Display.getInstance().modifierClient(indexCli - 1, ClientModif);
                break;
            case 10:
                System.out.println("quel client voulez-vous supprimer choisissez l'index de 1 a" + GestionClient.getSingleton().getListe().size());
                int supCli = scan.nextInt();
                GestionClient.getSingleton().supprimerClient(supCli - 1);
                break;
            case 11:
                if (GestionEmprunt.getInstance().getListe().isEmpty()) {
                    GestionEmprunt.getInstance().init();
                } else {
                    System.out.println("vous avez déjà généré les emprunts");
                }
                break;
            case 12:
                Display.getInstance().afficheEmprunt();
                break;
            case 13:
                this.ajouterEmprunt();
                break;
            case 14:
                this.rendre();
        }

    }

    public void ajouterEmprunt() {
        System.out.println("saisissez l'index du Jeu");
        int idJ = scan.nextInt();
        System.out.println("saisissez l'id du Client");
        int idCli = scan.nextInt();
        JeuxVideo jeu = (JeuxVideo)GestionJeu.getInstance().getListe().get(idJ - 1);
        Client client = (Client)GestionClient.getSingleton().getListe().get(idCli - 1);
        LocalDate local = LocalDate.now();
        if (this.isEmprunt(jeu)) {
            jeu.setLibre(false);
            Emprunt emprunt = new Emprunt(client, jeu, local);
            GestionEmprunt.getInstance().getListe().add(emprunt);
        } else {
            System.err.println("le jeu est déjà emprunté");
        }

    }

    public void rendre() {
        System.out.println("Saisissez l'ID du client et du jeu associés à la location (séparés par un espace)");
        System.out.println("idcli");
        int Cli = scan.nextInt();
        System.out.println("idJeu");
        int jeux = scan.nextInt();

        try {
            int[] ids = new int[2];
            ids[0] = Cli;
            ids[1] = jeux;
            System.out.println("ID Client : " + ids[0]);
            System.out.println("ID Jeu : " + ids[1]);
            if (this.existe(ids)) {
                JeuxVideo jeu = (JeuxVideo)GestionJeu.getInstance().getListe().get(ids[1] - 1);
                System.out.println("Client " + ids[0] + " jeu " + ids[1]);
                jeu.setLibre(true);
                this.supprimerEmprunt(ids);
            } else {
                System.out.println("Aucun emprunt trouvé pour ces IDs.");
            }
        } catch (NumberFormatException var5) {
            System.out.println("Erreur : Veuillez saisir des nombres entiers valides.");
        }

    }

    public Client getCliById(int id) {
        int debut = 0;
        int fin = GestionClient.getSingleton().getListe().size();

        while(debut <= fin) {
            int middle = debut + (fin - debut) / 2;
            Client currentClient = (Client)GestionClient.getSingleton().getListe().get(middle);
            if (currentClient.getCount() == id) {
                return currentClient;
            }

            if (currentClient.getCount() < id) {
                debut = middle + 1;
            } else {
                fin = middle - 1;
            }
        }

        return null;
    }

    public void supprimerEmprunt(int[] ids) {
        Emprunt emprunt = GestionEmprunt.getInstance().getEmpruntById(ids);
        if (emprunt != null) {
            GestionEmprunt.getInstance().getListe().remove(emprunt);
            System.out.println("Emprunt supprimé.");
        } else {
            System.out.println("Aucun emprunt trouvé pour ces IDs.");
        }

    }

    public JeuxVideo getJeuById(int id) {
        int debut = 0;
        int fin = GestionJeu.getSingleton().getListe().size();

        while(debut <= fin) {
            int middle = debut + (fin - debut) / 2;
            JeuxVideo currentJeu = (JeuxVideo)GestionJeu.getSingleton().getListe().get(middle);
            if (currentJeu.getCount() == id) {
                return currentJeu;
            }

            if (currentJeu.getCount() < id) {
                debut = middle + 1;
            } else {
                fin = middle - 1;
            }
        }

        return null;
    }

    public boolean isEmprunt(JeuxVideo jeu) {
        return jeu.isLibre();
    }

    public boolean existe(int[] ids) {
        Emprunt emprunt = GestionEmprunt.getInstance().getEmpruntById(ids);
        return emprunt != null;
    }

    public UUID genererId() {
        UUID uuid = UUID.randomUUID();
        return uuid;
    }

    public String generate_identif(int i) {
        String str = "" + i;
        String var10000 = "0".repeat(3 - str.length());
        return var10000 + i;
    }

    public String toStringintervaletailleTableau() {
        int taille = GestionJeu.getInstance().getListe().size();
        return "saisissez un index de jeu entre 1 et " + taille;
    }

    public String toStringintervaletailleTableauCli() {
        int taille = GestionClient.getSingleton().getListe().size();
        return "saisissez un index de jeu entre 1 et " + taille;
    }

    static {
        scan = new Scanner(System.in);
    }
}
