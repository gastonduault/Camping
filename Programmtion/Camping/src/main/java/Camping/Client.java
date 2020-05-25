package Camping;

public class Client {
    
    private String nom;
    private String prenom;
    private String email;


    public Client(String n, String p, String e){
        nom = n;
        prenom = p;
        email = e;
    }

    public String toString() {
        return this.getNom()+" - "+this.getPrenom()+" - "+this.getPrenom();
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

    public void afficher(){
        System.out.println(this.toString());
    }
}