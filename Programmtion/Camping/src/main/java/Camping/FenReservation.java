package Camping;


import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FenReservation extends Stage{
    

    private Label emplacement = new Label("Emplacement");
    public static ComboBox<Emplacement> listeMenuEmplacement = new ComboBox<Emplacement>();
    private Label erreurEmplacement = new Label("Choississez un emplacement");

    private Label client = new Label("Client ");
    public static ComboBox<Client> listeClient = new ComboBox<Client>();
    private Button buttonAjoutClient = new Button("Créer Client");
    private Label erreurClient = new Label("Choississez un client");

    private DatePicker dateEntree = new DatePicker();
    private Label dateEntreeLabel = new Label("Date d'entrée");
    private DatePicker dateSortie = new DatePicker();
    private Label dateSortieLabel = new Label("Date Sortie");
    private Label erreurDate = new Label("Date incorrect");

    private Button submit = new Button("Enregistrer");
    private Button cancel = new Button("Annuler");

    private FenClient fClient = new FenClient();

    public FenReservation(){
        this.setTitle("Ajouter Réservation");
        this.setResizable(false);
        this.setMinWidth(500);
        this.setMinHeight(500);
        Scene fenReservation = new Scene(creerContenu());
        this.setScene(fenReservation);
    }

    private Parent creerContenu(){
        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(15);
        root.setVgap(15);
        root.setBackground(new Background(new BackgroundFill(Color.web("#B5C7F8"), CornerRadii.EMPTY, Insets.EMPTY)));
        
        listeMenuEmplacement.setPromptText("Emplacement");
        for (int i = 0; i < Emplacement.listeEmplacement.size(); i++ ){
            listeMenuEmplacement.getItems().add(Emplacement.listeEmplacement.get(i));
        }
        root.add(emplacement, 1, 1);
        root.add(listeMenuEmplacement, 2, 1);
        erreurEmplacement.setTextFill(Color.TRANSPARENT);
        root.add(erreurEmplacement, 2, 2);

        listeClient.setPromptText("Client");
        for (int i = 0; i < Client.listeClient.size(); i++){
            listeClient.getItems().add(Client.listeClient.get(i));
        }
        root.add(client, 1, 3);
        root.add(listeClient, 2, 3);
        buttonAjoutClient.setOnAction(e -> {ajouterClient(e);});
        root.add(buttonAjoutClient, 3, 3);
        erreurClient.setTextFill(Color.TRANSPARENT);
        root.add(erreurClient, 2, 4);

        dateEntree.setValue(LocalDate.now());
        root.add(dateEntreeLabel, 1, 5);
        root.add(dateEntree, 2, 5);
        erreurDate.setTextFill(Color.TRANSPARENT);
        root.add(erreurDate, 3, 5);

        dateSortie.setValue(LocalDate.now());
        root.add(dateSortieLabel, 1, 6);
        root.add(dateSortie, 2, 6);

        submit.setOnAction(e -> {enregistrer(e);});
        root.add(submit, 1, 7);
        cancel.setOnAction(e -> {fermer(e);});
        root.add(cancel, 2, 7);
        return root;
    }

    private void ajouterClient(ActionEvent e){
        fClient.show();

    }

    private void enregistrer(ActionEvent e){

        boolean test = true;
        if (listeMenuEmplacement.getValue() == null){
            erreurEmplacement.setTextFill(Color.RED);
            test = false;
        }else{
            erreurEmplacement.setTextFill(Color.TRANSPARENT);;
        }
        if (listeClient.getValue() == null){
            erreurClient.setTextFill(Color.RED);
            test = false;
        }else{
            erreurClient.setTextFill(Color.TRANSPARENT);
        }
        if (dateEntree.getValue().compareTo(dateSortie.getValue()) >= 0 ){
            erreurDate.setTextFill(Color.RED);
            test = false;
        } else{
            erreurDate.setTextFill(Color.TRANSPARENT);
        }

        if (test == true){
            Reservation r = new Reservation(listeMenuEmplacement.getValue(), dateEntree.getValue(), dateSortie.getValue(), listeClient.getValue());
            this.close();
        }
        
    }

    private void fermer(ActionEvent e){
        this.close();
    }
}