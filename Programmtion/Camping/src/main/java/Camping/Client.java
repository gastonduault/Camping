package Camping;

public class Client {
    
    private String nom;
    private String prenom;
    private String email;
    private int numClient;
    private int nbClient = 1;


    public Client(String n, String p, String e){
        nom = n;
        prenom = p;
        email = e;
        nbClient += 1;
    }

    public String toString() {
        return this.getNom()+" - "+this.getPrenom()+" - "+this.getNum()+ " - "+this.getEmail();
    }

    public int getNum(){
        return numClient;
    }
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void afficher(){
        System.out.println(this.toString());
    }
}