package Camping;

import java.util.ArrayList;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FenetreSupr extends Stage {

	/*
	private static ObservableList<Client> lesClient = FXCollections.observableArrayList(Client.listeClient);
	static private ObservableList<Emplacement> lesEmplacement = FXCollections.observableArrayList(Emplacement.listeEmplacement);
	static private ObservableList<Reservation> lesReserv = FXCollections.observableArrayList(Reservation.listeReservation);


	public static ObservableList<Client> getLesClients() {
		return lesClient;
	}
	public static ObservableList<Emplacement> getLesEmplacements() {
		return lesEmplacement;
	}
	public static ObservableList<Reservation> getLesReserv() {
		return lesReserv;
	}
	public void actualiserListe(ObservableList<Client> lesClients) {
		listeClient.getItems().add(lesClients.toString());
		this.GereBtn();
	}
	public static void supprimerClient(int i) {
		lesClient.remove(i);
		fsup.actualiserListe(lesClient);
	}
	public static void supprimerReserv(int i) {
		lesReserv.remove(i);
		//fsup.actualiserListe(lesReserv);
	}
	public static void supprimerEmp(int i) {
		lesEmplacement.remove(i);
		//fsup.actualiserListe(lesEmplacement);
	}*/


	// les composants de la fen�tre
	private AnchorPane  		racine			= new AnchorPane();
	public static ListView<String> 	liste	= new ListView<String>();
	private Button 				bnSupprimer 	= new Button("Supprimer");
	private Button 				bnFermer 		= new Button("Retour");
	private Button 				bnRenitia 		= new Button("Renitialiser");
	private ComboBox<String> 	listeChoix	= new ComboBox<String>();
	private ComboBox<String> 	optionTri = new ComboBox<String>();

	private String [] triClient = {"Numéro client","Date","Nom"};
	private String [] triReserv = {"Numéro reserv","Prix","Date"};
	private String [] triEmplac = {"Numéro", "Surface", "Disponibilité", "Prix"};
	private TextField 		input = new TextField();


	// constructeur : initialisation de la fen�tre
	public FenetreSupr(){
		this.setTitle("Supprimer");
		this.setResizable(true);
		this.setScene(new Scene(creerContenu()));	
		this.setMinWidth(300);	
	}

	
	// cr�ation du Scene graph
	private Parent creerContenu() {
		

		bnSupprimer.setPrefWidth(100);
		bnFermer.setPrefWidth(100);
		bnRenitia.setPrefWidth(100);
		input.setMaxWidth(120.0);

		listeChoix.setPrefWidth(120.0);
		listeChoix.getItems().addAll("Client", "Réservation", "Emplacement");
		listeChoix.getSelectionModel().select(0);

		optionTri.setPrefWidth(120.0);
		optionTri.getItems().setAll(triClient);
		optionTri.getSelectionModel().select(0);

		for (int i = 0; i < Client.listeClient.size(); i++){
			liste.getItems().add(Client.listeClient.get(i).toString());
		}
		liste.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		AnchorPane.setTopAnchor(bnRenitia, 140.0);
		AnchorPane.setRightAnchor(bnRenitia, 10.0);
		AnchorPane.setTopAnchor(listeChoix, 10.0);
		AnchorPane.setRightAnchor(listeChoix, 10.0);
		AnchorPane.setTopAnchor(optionTri, 45.0);
		AnchorPane.setRightAnchor(optionTri, 10.0);
		AnchorPane.setTopAnchor(input, 80.0);
		AnchorPane.setRightAnchor(input, 10.0);
		AnchorPane.setTopAnchor(bnSupprimer, 110.0);
		AnchorPane.setRightAnchor(bnSupprimer, 10.0);
		AnchorPane.setBottomAnchor(bnFermer, 10.0);
		AnchorPane.setRightAnchor(bnFermer, 10.0);
		AnchorPane.setTopAnchor(liste, 10.0);
		AnchorPane.setLeftAnchor(liste, 10.0);
		AnchorPane.setRightAnchor(liste, 150.0);
		AnchorPane.setBottomAnchor(liste, 10.0);
		
		input.setPromptText("Saisir " + optionTri.getSelectionModel().getSelectedItem());
		
		listeChoix.setOnAction(e ->{
			String select = listeChoix.getSelectionModel().getSelectedItem();
			if(select.equals("Client")) {
				optionTri.getItems().setAll(triClient);
				optionTri.getSelectionModel().select(0);
				liste.getItems().setAll();
				for (int i = 0; i < Client.listeClient.size(); i++){
					liste.getItems().add(Client.listeClient.get(i).toString());
				}
				
			} else if(select.equals("Réservation")) {
				optionTri.getItems().setAll(triReserv);
				optionTri.getSelectionModel().select(0);
				liste.getItems().setAll();
				for (int i = 0; i < Reservation.listeReservation.size(); i++){
					liste.getItems().setAll(Reservation.listeReservation.get(i).toString());
				}
				
			}else if(select.equals("Emplacement")) {
				optionTri.getItems().setAll(triEmplac);
				optionTri.getSelectionModel().select(0);
				liste.getItems().setAll();
				for (int i = 0; i < Emplacement.listeEmplacement.size(); i++){
					liste.getItems().setAll(Emplacement.listeEmplacement.get(i).toString());
				}
			}
		});
		/*listeTri.setOnAction(e ->{
			input.setPromptText("Saisir " + listeTri.getSelectionModel().getSelectedItem());
		});
		/*bnRenitia.setOnAction(e ->{
			listeClient.setItems(getLesClients());
		});
		
		input.setOnKeyPressed(ke ->{
		KeyCode keyCode = ke.getCode();
		if(keyCode.equals(KeyCode.ENTER)) {
			String inputTxt = input.getText();
			if(getLesClients().contains(inputTxt)) {
				ArrayList<Client> newlist = new ArrayList<Client>();
				for(Client s : getLesClients()) {
					if (s.equals(inputTxt)) {
						newlist.add(s);
					}
				}
				//ObservableList<String> recherche = FXCollections.observableArrayList(newlist);
				//listeClient.setItems(recherche);
			}
		}
		});
			
		*/
		racine.setStyle("-fx-background-color: #EF3B3C");
		racine.getChildren().addAll(bnRenitia, optionTri,input,listeChoix,bnSupprimer, bnFermer, liste);
		
		// d�tection et traitement des �v�nements
		// A FAIRE : poser des �couteurs sur les composants de la fen�tre
		
		bnFermer.setOnAction(e -> {
			this.close();
		});
		
		liste.setOnMouseClicked(e->{
			GereBtn();
		});
		
		bnSupprimer.setOnAction(e -> {
			String select = listeChoix.getSelectionModel().getSelectedItem();
			Alert sur = new Alert(Alert.AlertType.CONFIRMATION,"Etes vous sur de vouloir supprimer ce " + listeChoix.getSelectionModel().getSelectedItem() +" ?" , ButtonType.YES,ButtonType.NO);
			Optional<ButtonType> res = sur.showAndWait();
			if(res.isPresent() && res.get() == ButtonType.YES) {
				if(select.equals("Client")) {
					liste.getItems().remove(liste.getSelectionModel().getSelectedIndex());
					boolean trouve = false;
					int i = 0;
					while (trouve == false && i < Client.listeClient.size()){
						if (liste.getSelectionModel().equals(Client.listeClient.get(i))){
							Client.listeClient.remove(i);
						}
						i++;
					}
					//supprimerClient(liste.getSelectionModel().getSelectedIndex());
				}/*else if(select.equals("R�servation")) {
					supprimerReserv(listeClient.getSelectionModel().getSelectedIndex());
				}else if(select.equals("Emplacement")) {
					supprimerEmp(listeClient.getSelectionModel().getSelectedIndex());
				}*/
				
			}
		});
		return racine;
	}



	public void GereBtn() {
		if(liste.getSelectionModel().getSelectedIndex() == -1 || liste.getItems().size() == 0) {
			bnSupprimer.setDisable(true);
		}else {
			bnSupprimer.setDisable(false);
		}
	}
}

