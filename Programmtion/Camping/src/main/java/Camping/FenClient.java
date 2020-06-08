package Camping;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FenClient extends Stage {

    private TextField nomClient = new TextField();
    private TextField prenomClient = new TextField();
    private TextField emailClient = new TextField();

    private Text title = new Text (10, 20, "Ajouter un client");
    private Label nClient = new Label("Nom*");
    private Label pClient = new Label("Prénom*");
    private Label eClient = new Label("Email*");

    private Button submit = new Button("Créer");

    private Client c = new Client(null, null, null);

    public FenClient() {
        this.setTitle("Camping");
        this.setResizable(true);
        this.setMinWidth(350);
        this.setMinHeight(350);
        Scene fenClient = new Scene(creerContenu());
        this.setScene(fenClient);
    }

    private Parent creerContenu() {

        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(15);
        root.setVgap(15);

        //Titre
        title.setFont(new Font(36));
        root.add(title, 0, 0, 2,1);

        //Formulaire
        root.add(nClient, 0, 1);
        nomClient.setMaxWidth(120);
        root.add(nomClient, 1, 1);

        root.add(pClient, 0, 2);
        prenomClient.setMaxWidth(120);
        root.add(prenomClient, 1, 2);

        root.add(eClient, 0, 3);
        emailClient.setMaxWidth(120);
        root.add(emailClient, 1, 3);

        root.add(submit, 0, 4);
        submit.setOnAction(e -> {creerClient(e);});

        return root;
    }

    private void creerClient(ActionEvent e){
        if (nomClient.getCharacters().length() > 2 && prenomClient.getCharacters().length() > 2 && emailClient.getCharacters().length() > 2){
            c.setNom(String.valueOf(nomClient.getCharacters()));
            c.setPrenom(String.valueOf(prenomClient.getCharacters()));
            c.setEmail(String.valueOf(emailClient.getCharacters()));
        }
    }
}