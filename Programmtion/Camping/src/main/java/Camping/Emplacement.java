package Camping;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

public class Emplacement {

    private Rectangle r;
    private int numeroEmplacement = 0;
    public static int nbEmplacement = -1;
    private double surface;
    private boolean estDispo;
    private int prixJour;
    private int nbVehicule;


    public static ArrayList<Emplacement> listeEmplacement = new ArrayList<Emplacement>();

    // Contructeur
    public Emplacement(Rectangle rectangle, double surface, int prix, int vehicule) {
        this.r = rectangle;
        nbEmplacement++;
        numeroEmplacement = nbEmplacement;
        this.surface = surface;
        this.prixJour = prix;
        this.nbVehicule = vehicule;
        estDispo = true;
        // listeEmplacement.add(this);
    }

    public Rectangle getRectangle() {
        return this.r;
    }

    // Guetteur
    public int getNumeroEmp() {
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

    public boolean getDispo() {
        return this.estDispo;
    }

    // Setteur

    public void setSurface(double s){
        this.surface = s;
    }
    public void setDispo(boolean dispo) {
        this.estDispo = dispo;
    }

    public void setPrixJour(int prix) {
        this.prixJour = prix;
    }

    public void setNbVehicule(int vehicule) {
        this.nbVehicule = vehicule;
    }

    public String toStringComplet() {
        String dispo = "Non";
        if (estDispo) {
            dispo = "Oui";
        }
        return "N° d'emplacement : " + numeroEmplacement + "\nSurface : " + this.surface + "\nPrix par Jour : "
                + this.prixJour + "\nNombre de véhicule : " + this.nbVehicule + "\nDisponible : " + dispo;
    }

    public String toString() {
        return "N°" + getNumeroEmp();
    }

    public static void afficher() {
        int i = 0;
        while (i <= listeEmplacement.size()) {
            System.out.println(listeEmplacement.get(i).toString());
            i++;
        }
    }

}