package Camping;


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

    public Reservation() {
        nbReservation++;
        numeroReservation = nbReservation;
    }

    public int getnbReservation() {
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

    public void modifierReservation(Client c, Int nbR){
        mesres.put(c, nbR);
    }

    public void afficher(){
        Set<Map.Entry<Client, Integer>> setEnt = this.mesres.entrySet();
        Iterator <Map.Entry<Client,Integer>> it = setEnt.iterator();

        Map.Entry<Client, Integer> ent;

        while (it.hasNext()){
            System.out.println(this.nbReservation );
        }
    }
}