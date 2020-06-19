package Camping;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application{
	
	Client c1 = new Client("DeFosse", "Pierre", "efef@zdz");
	Client c2 = new Client("det", "Jean", "effe@fef");
	Client c3 = new Client("A", "nathan", "zdzdzd@");
	Client c4 = new Client("Y", "nathan", "zdzdzd@");
	
	
  	public static void actualiserClient(){  
		FenReservation.listeClient.getItems().setAll();
		FenSearchClient.Liste.getItems().setAll();
		FenetreSupr.listeView.getItems().setAll();
		for (int i = 0; i < Client.listeClient.size(); i++){
			FenReservation.listeClient.getItems().add(Client.listeClient.get(i));
			FenSearchClient.Liste.getItems().add(Client.listeClient.get(i).toString());
			FenetreSupr.listeView.getItems().add(Client.listeClient.get(i).toString());
		}
	}

	public static void actualiserEmplacement(){
		FenReservation.listeMenuEmplacement.getItems().setAll();
		//FenetreSupr.listeView.getItems().setAll();
		for (int i = 0; i < Emplacement.listeEmplacement.size(); i++){
			FenReservation.listeMenuEmplacement.getItems().add(Emplacement.listeEmplacement.get(i));
			//FenetreSupr.listeView.getItems().add(Emplacement.listeEmplacement.get(i));
			if (Emplacement.listeEmplacement.get(i).getDispo() == false){
				Emplacement.listeEmplacement.get(i).getRectangle().setFill(Color.GREEN);
			}
		}
	}

	public static void actualiserReservation(){
		FenetreSupr.listeView.getItems().setAll();
		for (int i = 0; i < Reservation.listeReservation.size(); i++){
			FenetreSupr.listeView.getItems().add(Reservation.listeReservation.get(i));
		}
	}


	public void start(Stage f) {
		f = new FenPrincipal();
		f.show();
	}
	public static void main(String[] args) {
		launch();
	}
}

