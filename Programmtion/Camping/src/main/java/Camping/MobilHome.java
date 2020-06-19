package Camping;

import javafx.scene.shape.Rectangle;

public class MobilHome extends Emplacement {

    private int nbLit;

    public MobilHome(Rectangle r,double surfac, int prixJour, int nbVehicule, int lit){
        super(r,surfac, prixJour, nbVehicule);
        nbLit = lit;
    }

    // Guetteur
    /**
     * @return the nbLit
     */
    public int getNbLit() {
        return nbLit;
    }

    // Setteur
    public void setNbLit(int lit){
        this.nbLit = lit;
    }

    public String toStringComplet() {
        return "Type : Mobil-Home \n" + super.toString() + "\nNombre de lit : " + this.nbLit;
    }

    public String toString(){
        return super.toString() + " : Mobil-Home";
    }
}