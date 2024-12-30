//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Display {
    private Scanner scan;
    private static Display Singleton;

    public Display() {
        this.scan = new Scanner(System.in);
    }

    public static Display getInstance() {
        if (Singleton == null) {
            Singleton = new Display();
        }

        return Singleton;
    }

    public void MainMenu() {
        System.out.println("\u001b[31m1: Générer le park\u001b[0m");
        System.out.println("\u001b[31m2: Afficher les jeux\u001b[0m");
        System.out.println("\u001b[31m3: Supprimer un jeux\u001b[0m");
        System.out.println("\u001b[31m4: Ajouter un jeux\u001b[0m");
        System.out.println("\u001b[31m5: modifier un jeux\u001b[0m");
        System.out.println("-------------------------------");
        System.out.println("\u001b[38;2;255;255;0m6: générer les clients\u001b[0m");
        System.out.println("\u001b[38;2;255;255;0m7: afficher les clients\u001b[0m");
        System.out.println("\u001b[38;2;255;255;0m8: Ajouter un  clients\u001b[0m");
        System.out.println("\u001b[38;2;255;255;0m9: modifier un clients\u001b[0m");
        System.out.println("\u001b[38;2;255;255;0m10: Supprimer un  clients\u001b[0m");
        System.out.println("-------------------------------");
        System.out.println("\u001b[36m11: générer les emprunts\u001b[0m");
        System.out.println("\u001b[36m12: afficher les emprunts\u001b[0m");
        System.out.println("\u001b[36m13: Ajouter un  emprunts\u001b[0m");
        System.out.println("\u001b[36m14: rendre\u001b[0m");
        System.out.println("\u001b[36m15: consulter les emprunts par Client\u001b[0m");
        Scanner scan = new Scanner(System.in);
        int choix = scan.nextInt();
        Application.getInstance().faireChoix(choix);
    }

    public void afficherJeu() {
        GestionJeu gp = GestionJeu.getInstance();

        for(int i = 0; i < gp.getListe().size(); ++i) {
            PrintStream var10000 = System.out;
            JeuxVideo var10001 = (JeuxVideo)gp.getListe().get(i);
            var10000.println("\u001b[31m" + String.valueOf(var10001.getIdentifiant()) + "\u001b[0m");
            var10000 = System.out;
            var10001 = (JeuxVideo)gp.getListe().get(i);
            var10000.println("\u001b[31m" + var10001.getId() + "\u001b[0m");
            var10000 = System.out;
            var10001 = (JeuxVideo)gp.getListe().get(i);
            var10000.println("\u001b[31m" + var10001.getNom() + "\u001b[0m");
            var10000 = System.out;
            var10001 = (JeuxVideo)gp.getListe().get(i);
            var10000.println("\u001b[31m" + var10001.getDeveloppeur() + "\u001b[0m");
            var10000 = System.out;
            var10001 = (JeuxVideo)gp.getListe().get(i);
            var10000.println("\u001b[31m" + var10001.getPegi() + "\u001b[0m");
            var10000 = System.out;
            var10001 = (JeuxVideo)gp.getListe().get(i);
            var10000.println("\u001b[31m" + var10001.getAnnee() + "\u001b[0m");
            var10000 = System.out;
            var10001 = (JeuxVideo)gp.getListe().get(i);
            var10000.println("\u001b[31metat " + var10001.isLibre() + "\u001b[0m");
            System.out.println("\u001b[31m------------------------------------\u001b[0m");
        }

    }

    public void afficheEmprunt() {
        new ArrayList();
        ArrayList<Emprunt> liste = GestionEmprunt.getInstance().getListe();
        PrintStream var10000 = System.out;
        String var10001 = " ".repeat(10);
        var10000.println("| titre" + var10001 + "|emprunteur" + " ".repeat(10) + "|date de retour");

        for(Emprunt emprunt : liste) {
            this.afficherLeCli(emprunt.getClient());
            this.afficherLeJeu(emprunt.getJeu());
            emprunt.afficheloeurjeu();
            System.out.println("date debut: " + String.valueOf(emprunt.getDateDeb()));
            System.out.println("date fin: " + String.valueOf(emprunt.getDateFin()));
            System.out.println("\u001b[32m--------------------------------------------------------\u001b[0m");
        }

    }

    public void afficherCli() {
        GestionClient gp = GestionClient.getSingleton();

        for(int i = 0; i < gp.getListe().size(); ++i) {
            PrintStream var10000 = System.out;
            Client var10001 = (Client)gp.getListe().get(i);
            var10000.println("\u001b[38;2;255;255;0m" + var10001.getIdentifiant() + "\u001b[0m");
            var10000 = System.out;
            var10001 = (Client)gp.getListe().get(i);
            var10000.println("\u001b[38;2;255;255;0m" + var10001.getId() + "\u001b[0m");
            var10000 = System.out;
            var10001 = (Client)gp.getListe().get(i);
            var10000.println("\u001b[38;2;255;255;0m" + var10001.getNom() + "\u001b[0m");
            var10000 = System.out;
            var10001 = (Client)gp.getListe().get(i);
            var10000.println("\u001b[38;2;255;255;0m" + var10001.getPrenom() + "\u001b[0m");
            var10000 = System.out;
            var10001 = (Client)gp.getListe().get(i);
            var10000.println("\u001b[38;2;255;255;0m" + var10001.getAge() + "\u001b[0m");
            var10000 = System.out;
            var10001 = (Client)gp.getListe().get(i);
            var10000.println("\u001b[38;2;255;255;0m" + String.valueOf(var10001.getDdd()) + "\u001b[0m");
            System.out.println("\u001b[38;2;255;255;0m------------------------------------\u001b[0m");
        }

    }

    public void afficherLeCli(Client jeu) {
        GestionClient gp = GestionClient.getSingleton();
        System.out.println("\u001b[38;2;255;255;0m" + jeu.getIdentifiant() + "\u001b[0m");
        System.out.println("\u001b[38;2;255;255;0m" + jeu.getNom() + "\u001b[0m");
        System.out.println("\u001b[38;2;255;255;0m" + jeu.getPrenom() + "\u001b[0m");
        System.out.println("\u001b[38;2;255;255;0m" + String.valueOf(jeu.getDdd()) + "\u001b[0m");
        System.out.println("------------------------------------");
    }

    public void afficherLeJeu(JeuxVideo jeu) {
        GestionJeu gp = GestionJeu.getInstance();
        System.out.println(jeu.getNom());
        System.out.println(jeu.getDeveloppeur());
        System.out.println(jeu.getPegi());
        System.out.println(jeu.getAnnee());
        System.out.println("------------------------------------");
    }

    public void ajouterJeu() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Entrez le nom du jeu : ");
        String nom = scan.nextLine();
        System.out.print("Entrez le nom du développeur : ");
        String dev = scan.nextLine();
        System.out.print("Entrez l'année de sortie : ");
        String sortie = scan.nextLine();
        System.out.print("Entrez le PEGI (âge minimum recommandé) : ");
        int pegi = 0;
        if (scan.hasNextInt()) {
            pegi = scan.nextInt();
            JeuxVideo nouveauJeu = new JeuxVideo(nom, dev, sortie, pegi);
            GestionJeu.getInstance().getListe().add(nouveauJeu);
        } else {
            System.out.println("Entrée invalide pour le PEGI. Ajout annulé.");
        }
    }

    public void modifierjeu(int index, JeuxVideo jeu) {
        this.afficherLeJeu(jeu);
        String nom = this.scan.nextLine();
        String dev = this.scan.nextLine();
        int pegi = this.scan.nextInt();
        String annee = this.scan.next();
        JeuxVideo JeuUpdate = new JeuxVideo(nom, dev, annee, pegi);
        GestionJeu.getInstance().modifierJeu(index, JeuUpdate);
    }

    public void modifierClient(int index, Client cli) {
        Scanner scan = new Scanner(System.in);
        System.out.println("=== Modifier le client ===");
        this.afficherLeCli(cli);
        System.out.print("Nom : ");
        String nom = scan.nextLine();
        System.out.print("Prénom : ");
        String prenom = scan.nextLine();
        System.out.print("Âge : ");
        int age = scan.nextInt();
        LocalDate dateNaissance = null;
        boolean dateValide = false;

        while(!dateValide) {
            try {
                System.out.println("Saisissez la date de naissance :");
                System.out.print("Année : ");
                int annee = scan.nextInt();
                System.out.print("Mois (1-12) : ");
                int mois = scan.nextInt();
                System.out.print("Jour (1-31) : ");
                int jour = scan.nextInt();
                dateNaissance = LocalDate.of(annee, mois, jour);
                dateValide = true;
            } catch (Exception var12) {
                System.out.println("Date invalide. Veuillez réessayer.");
                scan.nextLine();
            }
        }

        Client clientModifie = new Client(cli.getIdentifiant(), nom, prenom, age, dateNaissance);
        GestionClient.getSingleton().getListe().set(index, clientModifie);
        System.out.println("Client modifié avec succès.");
    }

    public void ajouterClient() {
        System.out.println("saisissez le nom de la personne");
        String nom = this.scan.nextLine();
        System.out.println("saisisssez le prénom");
        String prenom = this.scan.nextLine();
        System.out.println("saisissez l'age");
        int age = this.scan.nextInt();
        LocalDate ddd = LocalDate.now();
        boolean dateValide = false;

        while(!dateValide) {
            try {
                System.out.println("saisissez le jour");
                int jour = this.scan.nextInt();
                System.out.println("saisissez le mois");
                int mois = this.scan.nextInt();
                System.out.println("saisissez l'année");
                int annee = this.scan.nextInt();
                ddd = LocalDate.of(annee, mois, jour);
                dateValide = true;
            } catch (Exception e) {
                e.getMessage();
                System.err.println("vous avez saisi une date invalide");
            }
        }

        Client novCli = new Client(nom, prenom, age, ddd);
        GestionClient.getSingleton().getListe().add(novCli);
    }
}
