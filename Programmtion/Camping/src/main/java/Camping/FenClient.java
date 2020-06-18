package Camping;


import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FenClient extends Stage {

    private String caractereInterdit[] = {"1","2","3","4","5","6","7","8","9","0"};
    private TextField nomClient = new TextField();
    private TextField prenomClient = new TextField();
    private TextField emailClient = new TextField();

    private Text title = new Text (10, 20, "Ajouter un client");
    private Label numClient = new Label("Numéro");
    private Label nClient = new Label("Nom");
    private Label pClient = new Label("Prénom");
    private Label eClient = new Label("Email");
    private Label obligatoire = new Label(" * : Champs obligatoires");

    private Label erreurNom = new Label("Nom incorrect !");
    private Label erreurPrenom = new Label("Prénom incorrect !");
    private Label erreurEmail = new Label("Email incorrect !");

    private Button submit = new Button("Créer");
    private Button cancel = new Button("Annuler");

    private Label numC = new Label(String.valueOf(Client.getNbClient() + 1));

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
        root.setBackground(new Background(new BackgroundFill(Color.web("#B5C7F8"), CornerRadii.EMPTY, Insets.EMPTY)));

        //Titre
        title.setFont(new Font(36));
        root.add(title, 0, 0, 2,1);

        //Formulaire
        root.add(numClient, 0, 1);
        root.add(numC, 1, 1);

        root.add(nClient, 0, 2);
        nomClient.setMaxWidth(140);
        nomClient.setPromptText("*");
        erreurNom.setTextFill(Color.TRANSPARENT);
        root.add(nomClient, 1, 2);
        root.add(erreurNom, 2, 2);

        root.add(pClient, 0, 3);
        prenomClient.setMaxWidth(140);
        prenomClient.setPromptText("*");
        erreurPrenom.setTextFill(Color.TRANSPARENT);
        root.add(prenomClient, 1, 3);
        root.add(erreurPrenom, 2, 3);

        root.add(eClient, 0, 4);
        emailClient.setMaxWidth(140);
        emailClient.setPromptText("*");
        erreurEmail.setTextFill(Color.TRANSPARENT);
        root.add(emailClient, 1, 4);
        root.add(erreurEmail, 2, 4);

        root.add(submit, 0, 5);
        submit.setOnAction(e -> {creerClient(e);});
        root.add(cancel, 1, 5);
        cancel.setOnAction(e -> {fermer(e);});
        root.add(obligatoire, 2, 5);

        return root;
    }

    private void creerClient(ActionEvent e){
        
        boolean testOk = true;
        if (nomClient.getText().length() > 2 && testMot(nomClient.getText())){
            nClient.setTextFill(Color.BLACK);
            erreurNom.setTextFill(Color.TRANSPARENT);
        }
        else{
            nClient.setTextFill(Color.RED);
            erreurNom.setTextFill(Color.RED);
            testOk = false;
        }

        if (prenomClient.getText().length() > 2 && testMot(prenomClient.getText())){
            pClient.setTextFill(Color.BLACK);
            erreurPrenom.setTextFill(Color.TRANSPARENT);
        }
        else{
            pClient.setTextFill(Color.RED);
            erreurPrenom.setTextFill(Color.RED);
            testOk = false;
        }
        if (emailClient.getText().length() > 2 && emailClient.getText().contains("@")){
            eClient.setTextFill(Color.BLACK);
            erreurEmail.setTextFill(Color.TRANSPARENT);
        }
        else{
            eClient.setTextFill(Color.RED);
            erreurEmail.setTextFill(Color.RED);
            testOk = false;
        }
        if (testOk == true){
            Client c = new Client(String.valueOf(nomClient.getCharacters()), String.valueOf(prenomClient.getCharacters()) , String.valueOf(emailClient.getCharacters()));
            FenReservation.listeClient.getItems().add(c);
            FenSearchClient.Liste.getItems().add(c.toStringComplet());
            nomClient.setText("");
            prenomClient.setText("");
            emailClient.setText("");
            numC.setText(String.valueOf(Client.getNbClient() + 1)); 
            this.close();
        }
    }

    private boolean testMot(String a){
        int i = 0;
        boolean trouve = true;
        while (i<a.length() && trouve){
            int j = 0;
            while (j<caractereInterdit.length && trouve){
                if (caractereInterdit[j].charAt(0) == a.charAt(i)){
                    trouve = false;
                }
                j += 1;
            }
            i += 1;
        }
        return trouve;
    }

    private void fermer(ActionEvent e){
        nomClient.setText("");
        prenomClient.setText("");
        emailClient.setText("");
        numC.setText(String.valueOf(Client.getNbClient() + 1));
        this.close();
    }
}