package Camping;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FenAddClient extends Stage {
    private TextField nomClient = new TextField();
    private TextField prenomClient = new TextField();
    private TextField emailClient = new TextField();

    private Text title = new Text (10, 20, "Ajouter un client");
    private Label nClient = new Label("Nom");
    private Label pClient = new Label("Prénom");
    private Label eClient = new Label("Email");

    private VBox root = new VBox();
    private HBox titre = new HBox();
    private VBox formulaire = new VBox();
    
    public FenAddClient(){
        this.setTitle("Camping");
        this.setResizable(false);
        this.setMinWidth(500);
        this.setMinHeight(700);
        Scene fenAddClient = new Scene(creerContenu());
        this.setScene(fenAddClient);
    }

    private Parent creerContenu(){
        
        // Titre
        title.setFont(new Font(36));
        titre.getChildren().add(title);
        titre.setAlignment(Pos.CENTER);
        titre.setPadding(new Insets(10));
        HBox.setHgrow(title, Priority.ALWAYS);

        // Formulaire
        VBox n = new VBox();
        nomClient.setMaxWidth(120);
        n.setPadding(new Insets(10));
        n.getChildren().addAll(nClient, nomClient);

        VBox p = new VBox();
        p.getChildren().addAll(prenomClient, pClient);

        formulaire.getChildren().addAll(n,p);
        root.getChildren().addAll(titre, formulaire);

        return root;
    }
}