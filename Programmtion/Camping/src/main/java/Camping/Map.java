package Camping;

import java.util.ArrayList;

public class Map {
    private String nom;
    private int nbPlace;
    private int nbPlaceMax;
    private ArrayList<Emplacement> mesEmplacements;

    public Map(String n, int nbPlaceM){
        nom = n;
        nbPlaceMax = nbPlaceM;
        mesEmplacements = new ArrayList<Emplacement>(nbPlaceMax);
        nbPlace ++;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        return this.getNom()+this.nbPlace+"/"+this.nbPlaceMax;
    }

    public void ajouterEmplacement(Emplacement e){
        mesEmplacements.add(e);
    }

    public void supprimerEmplacement(int numeroEmplacement){
        int i = 0;
        boolean trouve = false;
        while(i<=nbPlaceMax || trouve==false){
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
        for (int i = 0; i < mesEmplacements.size(); i++) {
            System.out.println(mesEmplacements.get(i).toString() + "\n");
        }
    }

}
