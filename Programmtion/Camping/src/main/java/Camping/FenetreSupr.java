package application;


import java.awt.Color;
import java.util.ArrayList;
import java.util.Optional;

import javax.xml.ws.Response;

import javafx.beans.property.DoubleProperty;
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
	// les composants de la fenêtre
	private AnchorPane  		racine			= new AnchorPane();
	private ListView<String> 	listeClient	= new ListView<String>();
	private Button 				bnSupprimer 	= new Button("Supprimer");
	private Button 				bnFermer 		= new Button("Fermer");
	private Button 				bnRenitia 		= new Button("Renitialiser");
	private ComboBox<String> 	listeChoix	= new ComboBox<String>();
	private ComboBox<String> 	listeTri= new ComboBox<String>();
	private ObservableList<String> options = FXCollections.observableArrayList("Client","Réservation","Emplacement");
	private ObservableList<String> optionsTri = FXCollections.observableArrayList();
	private String [] triClient = {"Numéro client","Date","Nom"};
	private String [] triReserv = {"Numéro reserv","Prix","Date"};
	private String [] triEmplacement = {"Numéro emp","Date"};
	private TextField 		input = new TextField();
	// constructeur : initialisation de la fenêtre
	public FenetreSupr(){
		this.setTitle("Supprimer");
		this.setResizable(true);
		this.setScene(new Scene(creerContenu()));	
		this.setMinWidth(300);
		
	}
	
	// création du Scene graph
	private Parent creerContenu() {
		
		optionsTri.setAll(triClient);
		bnSupprimer.setPrefWidth(100);
		bnFermer.setPrefWidth(100);
		bnRenitia.setPrefWidth(100);
		input.setMaxWidth(120.0);
		listeChoix.setPrefWidth(120.0);
		listeTri.setPrefWidth(120.0);
		listeChoix.setItems(options);
		listeTri.setItems(optionsTri);
		listeChoix.getSelectionModel().select(0);
		listeClient.setItems(App.getLesClients());
		listeTri.getSelectionModel().select(0);
		listeClient.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		listeClient.setItems(App.getLesClients());
		AnchorPane.setTopAnchor(bnRenitia, 140.0);
		AnchorPane.setRightAnchor(bnRenitia, 10.0);
		AnchorPane.setTopAnchor(listeChoix, 10.0);
		AnchorPane.setRightAnchor(listeChoix, 10.0);
		AnchorPane.setTopAnchor(listeTri, 45.0);
		AnchorPane.setRightAnchor(listeTri, 10.0);
		AnchorPane.setTopAnchor(input, 80.0);
		AnchorPane.setRightAnchor(input, 10.0);
		AnchorPane.setTopAnchor(bnSupprimer, 110.0);
		AnchorPane.setRightAnchor(bnSupprimer, 10.0);
		AnchorPane.setBottomAnchor(bnFermer, 10.0);
		AnchorPane.setRightAnchor(bnFermer, 10.0);
		AnchorPane.setTopAnchor(listeClient, 10.0);
		AnchorPane.setLeftAnchor(listeClient, 10.0);
		AnchorPane.setRightAnchor(listeClient, 150.0);
		AnchorPane.setBottomAnchor(listeClient, 10.0);
		
		input.setPromptText("Saisir " + listeTri.getSelectionModel().getSelectedItem());
		
		listeChoix.setOnAction(e ->{
			String select = listeChoix.getSelectionModel().getSelectedItem();
			if(select.equals("Client")) {
				optionsTri.setAll(triClient);
				listeClient.setItems(App.getLesClients());
			}else if(select.equals("Réservation")) {
				optionsTri.setAll(triReserv);
			
				listeClient.setItems(App.getLesReserv());
			}else if(select.equals("Emplacement")) {
				optionsTri.setAll(triEmplacement);
				listeClient.setItems(App.getLesEmplacements());
			}
		});
		listeTri.setOnAction(e ->{
			input.setPromptText("Saisir " + listeTri.getSelectionModel().getSelectedItem());
		});
		bnRenitia.setOnAction(e ->{
			listeClient.setItems(App.getLesClients());
		});
		
		input.setOnKeyPressed(ke ->{
		KeyCode keyCode = ke.getCode();
		if(keyCode.equals(KeyCode.ENTER)) {
			String inputTxt = input.getText();
			if(App.getLesClients().contains(inputTxt)) {
				ArrayList<String> newlist = new ArrayList<String>();
				for(String s : App.getLesClients()) {
					if (s.equals(inputTxt)) {
						newlist.add(s);
					}
				}
				ObservableList<String> recherche = FXCollections.observableArrayList(newlist);
				listeClient.setItems(recherche);
			}
		}
		});
			
		
		racine.setStyle("-fx-background-color: #EF3B3C");
		racine.getChildren().addAll(bnRenitia, listeTri,input,listeChoix,bnSupprimer, bnFermer, listeClient);
		
		// détection et traitement des événements
		// A FAIRE : poser des écouteurs sur les composants de la fenêtre

		bnFermer.setOnAction(e -> {
			System.exit(0);
		});
		
		listeClient.setOnMouseClicked(e->{
			GereBtn();
		});
		
		bnSupprimer.setOnAction(e -> {
			String select = listeChoix.getSelectionModel().getSelectedItem();
			Alert sur = new Alert(Alert.AlertType.CONFIRMATION,"Etes vous sur de vouloir supprimer ce " + listeChoix.getSelectionModel().getSelectedItem() +" ?" , ButtonType.YES,ButtonType.NO);
			Optional<ButtonType> res = sur.showAndWait();
			if(res.isPresent() && res.get() == ButtonType.YES) {
				if(select.equals("Client")) {
					App.supprimerClient(listeClient.getSelectionModel().getSelectedIndex());
				}else if(select.equals("Réservation")) {
					App.supprimerReserv(listeClient.getSelectionModel().getSelectedIndex());
				}else if(select.equals("Emplacement")) {
					App.supprimerEmp(listeClient.getSelectionModel().getSelectedIndex());
				}
				
			}
		});
		return racine;
	}

	public void actualiserListe(ObservableList<String> lesClients) {
		listeClient.setItems(lesClients);
		this.GereBtn();
	}
	
	public void GereBtn() {
		if(listeClient.getSelectionModel().getSelectedIndex() == -1 || listeClient.getItems().size() == 0) {
			bnSupprimer.setDisable(true);
		}else {
			bnSupprimer.setDisable(false);
		}
	}
}
