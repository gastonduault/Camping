package Camping;

public class Tente extends Emplacement{

    private int nbPersonne;
    private boolean eau;
    private boolean electricite;

    public Tente(double surface, int prixJour, int nbVehicule, int nombrePersonne, boolean eauDispo, boolean elecDispo){
        super(surface, prixJour, nbVehicule);
        nbPersonne = nombrePersonne;
        eau = eauDispo;
        electricite = elecDispo;
    }

    // Guetteur

    /**
     * @return the nbPersonne
     */
    public int getNbPersonne() {
        return nbPersonne;
    }

    public boolean getDispoEau(){
        return eau;
    }

    public boolean getDispoElec(){
        return electricite;
    }

    public String toString() {
        String eauDispo = "Non";
        String elecDispo = "Non";
        if (eau){
            eauDispo = "Oui";
        }
        if (electricite){
            elecDispo = "Oui";
        }
        return "Type : Tente \n" + super.toString() + "\nNombre de personnes : " + this.nbPersonne + "\nEau : " + eauDispo + "\nElectricité : " + elecDispo;
    }

}