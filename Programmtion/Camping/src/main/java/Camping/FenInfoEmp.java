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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class FenInfoEmp extends Stage {
    int index = 0;

    Label num = new Label("Numéro : ");
    Label numE = new Label("");
    Label surface = new Label("Surface : ");
    Label erreurSurface = new Label("Valeur incorrect");
    Label prix = new Label("Prix : ");
    Label erreurPrix = new Label("Valeur incorrect");
    Label nbVehicule = new Label("Nombre de véhicule : ");
    Label erreurVehicule = new Label("Valeur inccorect");
    Label dispo = new Label("Disponibilité : ");
    Label dispoText = new Label("");

    TextField surfaceText = new TextField();
    TextField prixText = new TextField();
    TextField nbVText = new TextField();

    Button submit = new Button("Enregistrer");
    Button cancel = new Button("Annuler");

    public FenInfoEmp(){
        this.setTitle("Camping");
        this.setResizable(true);
        this.setMinWidth(350);
        this.setMinHeight(350);
        Scene fenInfoEmp = new Scene(creerContenu());
        this.setScene(fenInfoEmp);
    }

    private Parent creerContenu(){

        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(15);
        root.setVgap(15);
        root.setBackground(new Background(new BackgroundFill(Color.web("#B5C7F8"), CornerRadii.EMPTY, Insets.EMPTY)));
        
        root.add(num, 1, 1);
        root.add(numE, 2, 1);
        root.add(surface, 1, 2);
        root.add(surfaceText, 2, 2);
        root.add(erreurSurface, 3, 2);
        erreurSurface.setTextFill(Color.TRANSPARENT);
        root.add(prix, 1, 3);
        root.add(prixText, 2, 3);
        root.add(erreurPrix, 3, 3);
        erreurPrix.setTextFill(Color.TRANSPARENT);
        root.add(nbVehicule, 1, 4);
        root.add(nbVText, 2, 4);
        root.add(erreurVehicule, 3, 4);
        erreurVehicule.setTextFill(Color.TRANSPARENT);
        submit.setOnAction(e -> {enregistrer(e);});
        root.add(dispo, 1, 5);
        root.add(dispoText, 2, 5);
        root.add(submit, 1, 6);
        cancel.setOnAction(e -> {annuler(e);});
        root.add(cancel, 2, 6);
        return root;
    }


    public void actualiserInfo(Rectangle r){
        boolean trouve = false;
        int i = 0;
        while (trouve == false && i < Emplacement.listeEmplacement.size()){
            if (Emplacement.listeEmplacement.get(i).getRectangle() == r){
                index = i;
                trouve = true;
            }
            i++;
        }
        surfaceText.setText(String.valueOf(Emplacement.listeEmplacement.get(index).getSurface()));
        prixText.setText(String.valueOf(Emplacement.listeEmplacement.get(index).getPrixJour()));
        nbVText.setText(String.valueOf(Emplacement.listeEmplacement.get(index).getNbVehicule()));
        numE.setText(String.valueOf(Emplacement.listeEmplacement.get(index).getNumeroEmp()));
        if (Emplacement.listeEmplacement.get(index).getDispo()){
            dispoText.setText("Oui");
        } else {
            dispoText.setText("Non");
        }
    }

    public void enregistrer(ActionEvent e){
        boolean valide = true;
        if (surfaceText.getText().equals(null) || Double.valueOf(surfaceText.getText()) <= 0.0){
            erreurSurface.setTextFill(Color.RED);
            valide = false;
        }else{
            erreurSurface.setTextFill(Color.TRANSPARENT);
        }

        if (prixText.getText().equals(null) || Integer.valueOf(prixText.getText()) <= 0){
            erreurPrix.setTextFill(Color.RED);
            valide = false;
        } else{
            erreurPrix.setTextFill(Color.TRANSPARENT);
        }

        if (nbVText.getText().equals(null) || Integer.parseInt(nbVText.getText()) < 0){
            erreurVehicule.setTextFill(Color.RED);
            valide = false;
        } else {
            erreurVehicule.setTextFill(Color.TRANSPARENT);
        }

        if (valide){
            Emplacement.listeEmplacement.get(index).setNbVehicule(Integer.parseInt(nbVText.getText()));
            Emplacement.listeEmplacement.get(index).setPrixJour(Integer.parseInt(prixText.getText()));
            Emplacement.listeEmplacement.get(index).setSurface(Double.parseDouble(surfaceText.getText()));
            this.close();
        }
    }

    public void annuler(ActionEvent e){
        surfaceText.setText(String.valueOf(Emplacement.listeEmplacement.get(index).getSurface()));
        prixText.setText(String.valueOf(Emplacement.listeEmplacement.get(index).getPrixJour()));
        nbVText.setText(String.valueOf(Emplacement.listeEmplacement.get(index).getNbVehicule()));
        this.close();
    }
}