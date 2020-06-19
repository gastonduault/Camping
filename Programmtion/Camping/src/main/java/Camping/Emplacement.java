package Camping;

import java.util.ArrayList;

public class Emplacement {

    private int numeroEmplacement;
    private static int nbEmplacement = 0;
    private double surface;
    private boolean estDispo;
    private int prixJour;
    private int nbVehicule;

    public static ArrayList<Emplacement> listeEmplacement = new ArrayList<Emplacement>();  

    // Contructeur
    public Emplacement(double surface, int prix, int vehicule){
        nbEmplacement++;
        numeroEmplacement = nbEmplacement;
    
        this.surface = surface;
        this.prixJour = prix;
        this.nbVehicule = vehicule;
        estDispo = true;
        listeEmplacement.add(this);
    }


    // Guetteur
    public int getNumeroEmp(){
        return numeroEmplacement;
    }

    /**
     * @return the surface
     */
    public double getSurface() {
        return surface;
    }
    /**
     * @return the prixJour
     */
    public int getPrixJour() {
        return prixJour;
    }

    /**
     * @return the nbVehicule
     */
    public int getNbVehicule() {
        return nbVehicule;
    }

    public boolean getDispo(){
        return this.estDispo;
    }

    // Setteur

    public void setDispo(boolean dispo){
        this.estDispo = dispo;
    }

    public void setPrixJour(int prix){
        this.prixJour = prix;
    }

    public void setNbVehicule(int vehicule){
        this.nbVehicule = vehicule;
    }

    public String toStringComplet() {
        String dispo = "Non";
        if (estDispo){
            dispo = "Oui";
        }
        return "N° d'emplacement : " + this.numeroEmplacement + "\nSurface : " + this.surface + "\nPrix par Jour : " + this.prixJour
         + "\nNombre de véhicule : " + this.nbVehicule + "\nDisponible : " + dispo;
    }

    public String toString(){
        return "N°" + this.getNumeroEmp() + "\nSurface : " + this.surface + "\nPrix " + this.prixJour;
    }

}