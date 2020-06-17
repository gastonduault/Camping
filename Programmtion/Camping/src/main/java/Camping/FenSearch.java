package Camping;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class FenSearch extends Stage{
    Color bleu = Color.web("#5A68D3");
    Color blanc = Color.web("#E9E6FF");
    Color bleuF = Color.web("#B5C7F8");
    Color vert = Color.web("#30CE52");
    Color rouge = Color.web("#EF383C");

    static private FenPrincipal fprincipal = new FenPrincipal();
  
    public FenSearch() {
      this.setTitle("Camping");
      this.setResizable(true);
      this.setMinWidth(800);
      this.setMinHeight(600);
      Scene fenPrin = new Scene(recherche());
      this.setScene(fenPrin);
      this.sizeToScene();
    }

    Parent recherche(){
        Rectangle fond = new Rectangle(0, 0, 800, 600);
        fond.setFill(bleuF);

        Label Recherche = new Label("Recherche");
        Recherche.setLayoutX(350);
        Recherche.setLayoutY(30);
        Recherche.setStyle("-fx-font: 24 arial;");

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
          fprincipal.show();
          close();
        }
    });

        Rectangle carreClient = new Rectangle(200, 200);
        carreClient.setFill(blanc);
        carreClient.setOnMouseClicked(new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent t) {
          Scene fenPrin = new Scene(client());
          
        }
    });
        Rectangle carreEmplacement = new Rectangle(200,200);
        carreEmplacement.setFill(blanc);
        Rectangle carreOrdredujour = new Rectangle(200, 200);
        carreOrdredujour.setFill(blanc);
        Rectangle carreReservation = new Rectangle(200,200);
        carreReservation.setFill(blanc);

        GridPane menu = new GridPane();
        menu.setGridLinesVisible(false);
        menu.setLayoutX(170);
        menu.setLayoutY(100);
        menu.add(carreClient, 0, 0);
        menu.add(carreEmplacement, 1, 0);
        menu.add(carreOrdredujour, 0, 1);
        menu.add(carreReservation, 1, 1);
        menu.setHgap(80);
        menu.setVgap(80);

        Label client = new Label("Client");
        client.setLayoutX(245);
        client.setLayoutY(185);
        client.setStyle("-fx-font: 18 Arial;");
        Label emplacement = new Label("Emplacement");
        emplacement.setLayoutX(500);
        emplacement.setLayoutY(185);
        emplacement.setStyle("-fx-font: 18 Arial;");
        Label ordredujour = new Label("Ordre du jour");
        ordredujour.setLayoutX(215);
        ordredujour.setLayoutY(465);
        ordredujour.setStyle("-fx-font: 18 Arial;");
        Label reservation = new Label("Réservation");
        reservation.setLayoutX(500);
        reservation.setLayoutY(465);
        reservation.setStyle("-fx-font: 18 Arial;");
        
        Group hautPage = new Group();
        hautPage.getChildren().addAll(Recherche, annuler,croixIV);

        Group Menu = new Group();
        Menu.getChildren().addAll(menu, client, emplacement, ordredujour, reservation); 

        Group total = new Group();
        total.getChildren().addAll(fond, hautPage, Menu);
        return total;
    }

    Parent client(){
      Group total = new Group();
      return total;
    }
}