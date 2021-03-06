package Camping;

import java.util.ArrayList;
import java.util.Optional;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FenetreSupr extends Stage {

	// les composants de la fen�tre
	private AnchorPane racine = new AnchorPane();
	public static ListView<Object> listeView = new ListView<Object>();
	private Button bnSupprimer = new Button("Supprimer");
	private Button bnFermer = new Button("Retour");
	private Button bnRenitia = new Button("Renitialiser");
	private ComboBox<String> listeChoix = new ComboBox<String>();
	private ComboBox<String> optionTri = new ComboBox<String>();

	private String[] triClient = { "Numéro", "Date de création", "Nom" };
	private String[] triReserv = { "Numéro reserv", "Prix", "Date" };
	private TextField input = new TextField();

	// constructeur : initialisation de la fen�tre
	public FenetreSupr() {
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
		listeChoix.getItems().setAll();
		listeChoix.getItems().addAll("Réservation","Client");
		listeChoix.getSelectionModel().select(0);

		optionTri.setPrefWidth(120.0);
		optionTri.getItems().setAll(triClient);
		optionTri.getSelectionModel().select(0);
		listeView.getItems().setAll();
		for (int i = 0; i < Client.listeClient.size(); i++) {
			listeView.getItems().add(Client.listeClient.get(i));
		}
		listeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

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
		AnchorPane.setTopAnchor(listeView, 10.0);
		AnchorPane.setLeftAnchor(listeView, 10.0);
		AnchorPane.setRightAnchor(listeView, 150.0);
		AnchorPane.setBottomAnchor(listeView, 10.0);

		input.setPromptText("Saisir " + optionTri.getSelectionModel().getSelectedItem());

		listeChoix.setOnAction(e -> {
			String select = listeChoix.getSelectionModel().getSelectedItem();
			if (select.equals("Client")) {
				optionTri.getItems().setAll(triClient);
				optionTri.getSelectionModel().select(0);
				listeView.getItems().setAll();
				for (int i = 0; i < Client.listeClient.size(); i++){
					listeView.getItems().add(Client.listeClient.get(i));
				}
				//App.actualiserClient();

			} else if (select.equals("Réservation")) {
				optionTri.getItems().setAll(triReserv);
				optionTri.getSelectionModel().select(0);
				listeView.getItems().setAll();
				for (int i = 0; i < Reservation.listeReservation.size(); i++) {
					listeView.getItems().add(Reservation.listeReservation.get(i));
				}

			} 
		});

		optionTri.setOnAction(e -> {
			String liste = listeChoix.getSelectionModel().getSelectedItem();
			String select = optionTri.getSelectionModel().getSelectedItem();
			if (liste.equals("Client")){
				if (select.equals("Numéro")){  // Tri par numéro
					listeView.getItems().setAll();
					for (int i = 0; i < Client.listeClient.size() ; i++) {
						listeView.getItems().add(Client.listeClient.get(i));
					}
				}
				else if (select.equals("Date de création")){  // Tri par date de création
					listeView.getItems().setAll();
					for (int i = 0; i < Client.listeClient.size() ; i++) {
						listeView.getItems().add(0,	 Client.listeClient.get(i));
					}
					
				}
				else if (select.equals("Nom")){	// Tri par nom

					listeView.getItems().setAll();
					for (int i = 0; i <  Client.listeClient.size(); i++){
						Client c = Client.listeClient.get(i);
						int j = i;
						while(j>0 && Client.listeClient.get(j-1).getNom().compareTo(c.getNom()) > 0){
							listeView.getItems().add(j, Client.listeClient.get(j-1));
							listeView.getItems().remove(j-1);
							j = j-1;
						}	
						listeView.getItems().add(j, c);
					}
				}
			}
			else if (liste.equals("Réservation")){

			}
		});
		/*
		 * listeTri.setOnAction(e ->{ input.setPromptText("Saisir " +
		 * listeTri.getSelectionModel().getSelectedItem()); });
		 */
		bnRenitia.setOnAction(e -> {
			listeView.getItems().setAll();
			for (int i = 0; i < Client.listeClient.size(); i++) {
				listeView.getItems().add(Client.listeClient.get(i));
			}
			listeChoix.getSelectionModel().select(0);
			optionTri.getSelectionModel().select(0);
		});
		/*
		 * input.setOnKeyPressed(ke ->{ KeyCode keyCode = ke.getCode();
		 * if(keyCode.equals(KeyCode.ENTER)) { String inputTxt = input.getText();
		 * if(getLesClients().contains(inputTxt)) { ArrayList<Client> newlist = new
		 * ArrayList<Client>(); for(Client s : getLesClients()) { if
		 * (s.equals(inputTxt)) { newlist.add(s); } } //ObservableList<String> recherche
		 * = FXCollections.observableArrayList(newlist);
		 * //listeClient.setItems(recherche); } } });
		 * 
		 */
		racine.setStyle("-fx-background-color: #EF3B3C");
		racine.getChildren().addAll(bnRenitia, optionTri, input, listeChoix, bnSupprimer, bnFermer, listeView);

		// d�tection et traitement des �v�nements
		// A FAIRE : poser des �couteurs sur les composants de la fen�tre

		bnFermer.setOnAction(e -> {
			this.close();
			listeView.getItems().setAll();
			for (int i = 0; i < Client.listeClient.size(); i++) {
				listeView.getItems().add(Client.listeClient.get(i));
			}
			listeChoix.getSelectionModel().select(0);
			optionTri.getSelectionModel().select(0);
		});

		listeView.setOnMouseClicked(e -> {
			GereBtn();
		});

		bnSupprimer.setOnAction(e -> {
			String select = listeChoix.getSelectionModel().getSelectedItem();
			Alert sur = new Alert(Alert.AlertType.CONFIRMATION,
					"Etes vous sur de vouloir supprimer ce " + listeChoix.getSelectionModel().getSelectedItem() + " ?",
					ButtonType.YES, ButtonType.NO);
			Optional<ButtonType> res = sur.showAndWait();
			if (res.isPresent() && res.get() == ButtonType.YES) {
				if (select.equals("Client")) {
					Object s = listeView.getSelectionModel().getSelectedItem();
					boolean trouve = false;
					int i = 0;
					while(trouve == false && i < Client.listeClient.size()){
						if (s.equals(Client.listeClient.get(i))){
							trouve = true;
						}
						System.out.println(Client.listeClient.get(i).toString());
						i++;
					}
					listeView.getItems().remove(listeView.getSelectionModel().getSelectedIndex());
					Client.listeClient.remove(i);
					App.actualiserClient();

				} else if (select.equals("Réservation")) {
					listeView.getItems().remove(listeView.getSelectionModel().getSelectedIndex());
					Reservation.listeReservation.remove(listeView.getSelectionModel().getSelectedIndex());
					App.actualiserReservation();
				}
			}
		});
		return racine;
	}

	public void GereBtn() {
		if (listeView.getSelectionModel().getSelectedIndex() == -1 || listeView.getItems().size() == 0) {
			bnSupprimer.setDisable(true);
		} else {
			bnSupprimer.setDisable(false);
		}
	}
}
