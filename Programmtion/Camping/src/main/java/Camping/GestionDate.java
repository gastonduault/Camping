package Camping;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class GestionDate {
    

    private Calendar cal;

    public GestionDate(){
    	cal = Calendar.getInstance();
    }

    // Guetteur

    public int getJour() {
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public int getMois() {
        return cal.get(Calendar.MONTH);
    }

    public int getAnnee() {
        return cal.get(Calendar.YEAR);
    }

    public String getDate(){
       String strDate;
       Date date = cal.getTime();
       DateFormat dateFormat = new SimpleDateFormat("dd MMMM YYYY");
       strDate = dateFormat.format(date);
       return strDate;
    }
    
    public String nouvelleDate(int jours, int mois,int annee) {
    	Calendar dateR = Calendar.getInstance();
    	dateR.set(annee, mois, jours);
    	 String strDate;
         Date date = dateR.getTime();
         DateFormat dateFormat = new SimpleDateFormat("dd MMMM YYYY");
         strDate = dateFormat.format(date);
         return strDate;
    }
}
