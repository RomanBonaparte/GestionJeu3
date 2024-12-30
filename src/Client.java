//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.LocalDate;

public class Client {
    public static int count = 1;
    private int id;
    private String identifiant;
    private String nom;
    private String prenom;
    private int age;
    private LocalDate ddd;

    public Client(String nom, String prenom, int age, LocalDate ddd) {
        this.identifiant = Application.getInstance().generate_identif(count);
        this.id = count;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.ddd = ddd;
        ++count;
    }

    public Client(String identif, String nom, String prenom, int age, LocalDate ddd) {
        this.identifiant = identif;
        this.id = count;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.ddd = ddd;
        ++count;
    }

    public int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Client.count = count;
    }

    public String getIdentifiant() {
        return this.identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDdd() {
        return this.ddd;
    }

    public void setDdd(LocalDate ddd) {
        this.ddd = ddd;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
