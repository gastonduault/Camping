package Camping;

public class Date {
    
    private int jour;
    private String mois;
    private int annee;

    public Date(int j, String m, int a){
        jour = j;
        mois = m;
        annee = a;
    }

    // Guetteur

    public int getJour() {
        return jour;
    }

    public String getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public String toString(){
        return jour + " " + mois + " " + annee;
    }
}