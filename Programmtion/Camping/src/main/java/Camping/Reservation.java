package Camping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Reservation {

    private Emplacement emplacement;
    private LocalDate dateArrivee;
    private LocalDate dateDepart;
    private Client client;
    private static int nbReservation = 0;
    private int numeroReservation;
    private Map<Client, Integer> mesres;
    public static ArrayList<Reservation> listeReservation  = new ArrayList<Reservation>();

    public Reservation(Emplacement e, LocalDate dd , LocalDate da, Client client) {
        nbReservation++;
        numeroReservation = nbReservation;
        emplacement = e;
        dateArrivee = da;
        dateDepart = dd;
        this.client = client;
        listeReservation.add(this); 
    }

    public static int getnbReservation() {
        return nbReservation;
    }

    public void ajouterReservation(Client client, int nbRes) {
        this.mesres = new HashMap<Client, Integer>();
        mesres.put(client, nbRes);
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
        }
        else{
            System.out.println("la réservation que vous voulez supprimer n'existe pas");
        }
    }

    public void modifierReservation(Client client, int nbR, LocalDate dateD, LocalDate dateA){
        mesres.put(client, nbR);
        dateDepart = dateD;
        dateArrivee = dateA;
    }


    public void afficher(){
        Set<Map.Entry<Client, Integer>> setEnt = this.mesres.entrySet();
        Iterator <Map.Entry<Client,Integer>> it = setEnt.iterator();

        while (it.hasNext()){
            System.out.println(this.numeroReservation + dateDepart.toString() + dateArrivee.toString());
            client.afficher();
        }
    }

    public String toString(){
        return "numero reservation"+numeroReservation+"numero d'emplacment :"+emplacement.toString()+"nom prénom client:"+client.toString()+dateArrivee+dateDepart; 
    }
}