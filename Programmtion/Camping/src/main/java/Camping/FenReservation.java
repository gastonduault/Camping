package Camping;


import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FenReservation extends Stage{
    
    private Label emplacement = new Label("Emplacement");
    private ComboBox<Emplacement> listeMenuEmplacement = new ComboBox<Emplacement>();
    private Label emplacementInfo = new Label("");
    private MobilHome e = new MobilHome(30, 30, 0, 3);

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
        
        for (int i = 0; i < Emplacement.listeEmplacement.size(); i++ ){
            listeMenuEmplacement.getItems().add(Emplacement.listeEmplacement.get(i)//);
        }
        listeMenuEmplacement.getSelectionModel().select(2);
        root.add(emplacement, 1, 1);
        root.add(listeMenuEmplacement, 2, 1);
        root.add(emplacementInfo, 3, 1);

        return root;
    }
}