package Camping;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class FenSearchClient extends Stage {
    Color bleu = Color.web("#5A68D3");
    Color blanc = Color.web("#E9E6FF");
    Color bleuF = Color.web("#B5C7F8");
    Color vert = Color.web("#30CE52");
    Color rouge = Color.web("#EF383C");

    private static Client c1 = new Client("duault", "gaston", "gaston.duault@univ-rennes1.fr");
    
    static private FenSearch fsearch = new FenSearch();
  
    private ListView<String> Liste  = new ListView<String>();

    public FenSearchClient() {
      this.setTitle("Camping");
      this.setResizable(true);
      this.setMinWidth(800);
      this.setMinHeight(600);
      Scene fenPrin = new Scene(contenu());
      this.setScene(fenPrin);
      this.sizeToScene();
    }

    Parent contenu(){
        Rectangle fond = new Rectangle(0, 0, 800, 600);
        fond.setFill(bleuF);

        Circle annuler = new Circle(700, 45, 25);
        annuler.setFill(blanc);
        Image croix = new Image(getClass().getResource("images/croix.png").toString());
        ImageView croixIV = new ImageView(croix);
        croixIV.setFitWidth(25);
        croixIV.setFitHeight(25);
        croixIV.setLayoutX(688);
        croixIV.setLayoutY(33);
        annuler.setOnMouseClicked(new EventHandler<MouseEvent>()
        
    {
        @Override
        public void handle(MouseEvent t) {
          fsearch.show();
          close();
        }
    });
        Label client = new Label("Client");
        client.setLayoutX(350);
        client.setLayoutY(30);
        client.setStyle("-fx-font: 20 arial;");

        Liste.setLayoutX(200);
        Liste.setLayoutY(300);
        Liste.getItems().add(c1.toString());
        Liste.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);	

        Group hautpage = new Group();
        hautpage.getChildren().addAll(annuler, croixIV, client);

        Group midpage = new Group();
        midpage.getChildren().addAll(Liste);

        Group total = new Group();
        total.getChildren().addAll(fond, hautpage, Liste);
        return total;
    }
}