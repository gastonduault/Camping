package Camping;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    
    Label num = new Label("Numéro : ");
    Label numE = new Label("");
    Label surface = new Label("Surface : ");
    Label prix = new Label("Prix : ");
    Label nbVehicule = new Label("Nombre de véhicule : ");
    Label dispo = new Label("Disponibilité : ");

    TextField surfaceText = new TextField();
    TextField prixText = new TextField();
    TextField nbVText = new TextField();

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
        root.add(prix, 1, 3);
        root.add(prixText, 2, 3);
        root.add(nbVehicule, 1, 4);
        root.add(nbVText, 2, 4);
        return root;
    }

    public void actualiserInfo(Rectangle r){
        boolean trouve = false;
        int i = 0;
        while (trouve == false && i < Emplacement.listeEmplacement.size()){
            if (Emplacement.listeEmplacement.get(i).getRectangle() == r){
                trouve = true;
            }
            i++;
        }
        surfaceText.setText(String.valueOf(Emplacement.listeEmplacement.get(i).getSurface()));
        prixText.setText(String.valueOf(Emplacement.listeEmplacement.get(i).getPrixJour()));
        nbVText.setText(String.valueOf(Emplacement.listeEmplacement.get(i).getNbVehicule()));
        numE.setText(String.valueOf(Emplacement.listeEmplacement.get(i).getNumeroEmp()));
    }
}