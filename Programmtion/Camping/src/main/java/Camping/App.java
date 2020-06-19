package Camping;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
	
	Client c1 = new Client("DeFosse", "Pierre", "efef@zdz");
	Client c2 = new Client("det", "Jean", "effe@fef");
	Emplacement e1 = new Emplacement(34, 12, 0);
	Emplacement e2 = new Emplacement(24, 34, 3);

	public static void actualiserClient(){
	    Emplacement.creeremplacement();
		FenReservation.listeClient.getItems().setAll();
		FenSearchClient.Liste.getItems().setAll();
		FenetreSupr.liste.getItems().setAll();
		for (int i = 0; i < Client.listeClient.size(); i++){
			FenReservation.listeClient.getItems().add(Client.listeClient.get(i));
			FenSearchClient.Liste.getItems().add(Client.listeClient.get(i).toString());
			FenetreSupr.liste.getItems().add(Client.listeClient.get(i).toString());
		}
	}
	
	public void start(Stage f) {
		f = new FenPrincipal();
		f.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}

