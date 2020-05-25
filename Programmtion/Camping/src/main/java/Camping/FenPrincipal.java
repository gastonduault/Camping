package Camping;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FenPrincipal extends Stage{

    Color bleu = Color.web("#5A68D3");
    Color blanc = Color.web("#E9E6FF");
    Color bleuF = Color.web("#00172F");
    Color vert = Color.web("#30CE52");
    Color rouge = Color.web("#EF383C");

    public FenPrincipal(){
        this.setTitle("Camping");
        this.setResizable(true);
        this.setMinWidth(500);
        this.setMinHeight(700);
        Scene fenPrin = new Scene(contenu());
        this.setScene(fenPrin);
		this.sizeToScene();
    }

    Parent contenu(){
        Circle recherche = new Circle(30, 30, 20);
        Rectangle fond = new Rectangle(0 , 0, 500, 500);
        
        recherche.setFill(blanc);

        fond.setFill(bleu);
        fond.setLayoutX(0);
        fond.setLayoutY(0);

        Group total = new Group();
        total.getChildren().addAll(fond, recherche);
        return total;
      }
}