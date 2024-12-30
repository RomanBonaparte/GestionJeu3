//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionClient {
    private static GestionClient Singleton;
    private ArrayList<Client> liste = new ArrayList();

    public GestionClient() {
    }

    public static GestionClient getSingleton() {
        if (Singleton == null) {
            Singleton = new GestionClient();
        }

        return Singleton;
    }

    public void init() {
        String[] noms = new String[]{"Alice", "Bob", "Charlie", "Diana"};
        String[] prenoms = new String[]{"Martin", "Johnson", "Brown", "Taylor"};
        int[] ages = new int[]{25, 30, 22, 28};
        LocalDate[] datesNaissance = new LocalDate[]{LocalDate.of(1998, 1, 15), LocalDate.of(1993, 5, 22), LocalDate.of(2001, 8, 30), LocalDate.of(1996, 12, 10)};

        for(int i = 0; i < noms.length; ++i) {
            Client client = new Client(Application.getInstance().generate_identif(Client.count), noms[i], prenoms[i], ages[i], datesNaissance[i]);
            this.liste.add(client);
        }

    }

    public ArrayList<Client> getListe() {
        return this.liste;
    }

    public boolean estVide() {
        return this.getListe().isEmpty();
    }

    public void setListe(ArrayList<Client> liste) {
        this.liste = liste;
    }

    public void modifierClient(int index, Client client) {
        ((Client)this.liste.get(index)).setAge(client.getAge());
        ((Client)this.liste.get(index)).setNom(client.getNom());
        ((Client)this.liste.get(index)).setPrenom(client.getPrenom());
        ((Client)this.liste.get(index)).setDdd(client.getDdd());
    }

    public void supprimerClient(int index) {
        this.liste.remove(index);
    }
}
