package Camping;

public class MobilHome extends Emplacement{

    private int nbLit;

    public MobilHome(double surfac, int prixJour, int nbVehicule, int lit){
        super(surfac, prixJour, nbVehicule);
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

    public String toString() {
        return super.toString() + "\nNombre de lit : " + this.nbLit;
    }
}