package Camping;



import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class App extends Application{

    private static FenetreSupr fsup		= new FenetreSupr();
	
	
	private static ObservableList<String> lesClient = FXCollections.observableArrayList("Thomas","Vincent","Ewen","Clement","Gaston");
	static private ObservableList<String> lesEmplacement = FXCollections.observableArrayList("emp1","emp2","emp3","emp4","emp5");
	static private ObservableList<String> lesReserv = FXCollections.observableArrayList("reserv1","reserv2","reserv3","reserv4","reserv5");
	public void start(Stage f) {
		fsup.actualiserListe(App.lesClient);
		f = fsup;
		f.show();
	}
	public static ObservableList<String> getLesClients() {
		return App.lesClient;
	}
	public static ObservableList<String> getLesEmplacements() {
		return App.lesEmplacement;
	}
	public static ObservableList<String> getLesReserv() {
		return App.lesReserv;
	}
	public static void main(String[] args) {
		Application.launch(args);
		
	}
	
	public static void supprimerClient(int i) {
		lesClient.remove(i);
		fsup.actualiserListe(App.lesClient);
	}
	public static void supprimerReserv(int i) {
		lesReserv.remove(i);
		fsup.actualiserListe(lesReserv);
	}
	
	public static void supprimerEmp(int i) {
		lesEmplacement.remove(i);
		fsup.actualiserListe(lesEmplacement);
	}
}

