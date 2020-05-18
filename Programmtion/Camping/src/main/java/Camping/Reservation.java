package Camping;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Reservation {

    private Date dateArrivee;
    private Date dateDepart;
    private Client client;
    private int nbReservation = 0;
    private int numeroReservation;
    private Map<Client, Integer> mesres;
    private ArrayList<Emplacement> mesEmplacements;
    private final int MAX = 30;

    public Reservation(Date dd , Date da) {
        nbReservation++;
        numeroReservation = nbReservation;
        dateArrivee = da;
        dateDepart = dd;
        mesEmplacements = new ArrayList<Emplacement>(MAX);
    }

    public int getnbReservation() {
        return nbReservation;
    }

    public void ajouterReservation(Client client, int nbRes) {
        this.mesres = new HashMap<Client, Integer>();
        mesres.put(client, nbRes);
    }

    public void ajouterEmplacement(Emplacement e){
        mesEmplacements.add(e);
    }

    /*
     * public boolean validerReservation(){ // à faire }
     */

    public void supprimerReservation(String nomC){
        Set<Map.Entry<Client, Integer>> setEnt = this.mesres.entrySet();
        Iterator <Map.Entry<Client, Integer>> it = setEnt.iterator();

        Map.Entry<Client, Integer> ent;
        Client c = null;
        Boolean trouve = false;

        while(it.hasNext() & (!trouve)){
            ent = it.next();
            c=ent.getKey();
            if(c.getNom()==nomC){
                trouve = true;
            }
        }

        if(mesres.containsKey(c)){
            mesres.remove(c);
            mesEmplacements=null;
        }
        else{
            System.out.println("la réservation que vous voulez supprimer n'existe pas");
        }
    }

    public void modifierReservation(Client client, int nbR, Date dateD, Date dateA){
        mesres.put(client, nbR);
        dateDepart = dateD;
        dateArrivee = dateA;
    }

    public void supprimerEmplacement(int numeroEmplacement){
        int i = 0;
        boolean trouve = false;
        while(i<=MAX || trouve==false){
            if(numeroEmplacement==mesEmplacements.get(i).getNumeroEmp()){
                trouve = true;
            }
        }
        if (trouve==true){
            mesEmplacements.remove(i);
        }
        else{
            System.out.println("Nous n'avons pas trouvé l'emplacement que vous voulez supprimer");
        }
    }

    public void afficher(){
        Set<Map.Entry<Client, Integer>> setEnt = this.mesres.entrySet();
        Iterator <Map.Entry<Client,Integer>> it = setEnt.iterator();

        Map.Entry<Client, Integer> ent;

        while (it.hasNext()){
            System.out.println(this.numeroReservation + dateDepart.toString() + dateArrivee.toString());
            client.afficher();
        }
        for (int i = 0; i < mesEmplacements.size(); i++) {
            System.out.println(mesEmplacements.get(i).toString() + "\n");
        }
    }
}