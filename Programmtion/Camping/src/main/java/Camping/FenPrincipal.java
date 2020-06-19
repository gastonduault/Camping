package Camping;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FenPrincipal extends Stage {

    private static FenReservation fReservation = new FenReservation();
    private static FenetreSupr fSupr = new FenetreSupr();
    private static FenSearch fSearch = new FenSearch();
    private static FenInfoEmp fInfoEmp = new FenInfoEmp();

    Color bleu = Color.web("#5A68D3");
    Color blanc = Color.web("#E9E6FF");
    Color bleuF = Color.web("#B5C7F8");
    Color vert = Color.web("#30CE52");
    Color rouge = Color.web("#EF383C");

    private Button fermer = new Button("Quitter");

    public Rectangle[] tabRectangle = new Rectangle[33];

    public FenPrincipal() {
        this.setTitle("Camping");
        this.setResizable(true);
        this.setMinWidth(800);
        this.setMinHeight(600);
        Scene fenPrin = new Scene(contenu());

        this.setScene(fenPrin);
        this.sizeToScene();
    }

    Parent contenu() {

        // Création Emplacement
        Emplacement.listeEmplacement.clear();
        Emplacement.nbEmplacement = -1;
        boolean test = true;
        if (test){
            for (int i = 0; i < 33; i++) {
                tabRectangle[i] = new Rectangle(20, 20);
                Emplacement.listeEmplacement.add(new Emplacement(tabRectangle[i], 0, 0, 0));
    
            }
            test = false;
        }

        App.actualiserEmplacement();
        for (int i = 0; i < Emplacement.listeEmplacement.size(); i++){
            if (Emplacement.listeEmplacement.get(i).getDispo()){
                Emplacement.listeEmplacement.get(i).getRectangle().setFill(Color.GREEN);
            }
        }
        Rectangle fond = new Rectangle(0, 0, 800, 600);
        fond.setFill(bleuF);
        fond.setLayoutX(0);
        fond.setLayoutY(0);

        Circle rondloupe = new Circle(40, 40, 20);
        rondloupe.setFill(blanc);
        Image loupe = new Image(getClass().getResource("images/source-code.png").toString());
        ImageView loupeIV = new ImageView(loupe);
        loupeIV.setLayoutX(25);
        loupeIV.setLayoutY(25);
        loupeIV.setFitHeight(30);
        loupeIV.setFitWidth(30);

        loupeIV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                fSearch.show();
                close();
            }
        });
        rondloupe.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                fSearch.show();
                close();
            }
        });

        Rectangle carrevert = new Rectangle(20, 160, 30, 30);
        carrevert.setFill(vert);

        Rectangle carrerouge = new Rectangle(20, 260, 30, 30);
        carrerouge.setFill(rouge);

        Label Libre = new Label("Libre");
        Libre.setLayoutX(60);
        Libre.setLayoutY(170);

        Label reserve = new Label("réservé");
        reserve.setLayoutX(60);
        reserve.setLayoutY(270);

        Circle ajouter = new Circle(35, 410, 20);
        ajouter.setFill(blanc);
        Image plus = new Image(getClass().getResource("images/+.png").toString());
        ImageView plusIV = new ImageView(plus);
        plusIV.setFitWidth(30);
        plusIV.setFitHeight(30);
        plusIV.setLayoutX(20);
        plusIV.setLayoutY(395);

        Circle supprimer = new Circle(35, 470, 20);
        supprimer.setFill(blanc);
        Image moin = new Image(getClass().getResource("images/-.png").toString());
        ImageView moinIV = new ImageView(moin);
        moinIV.setFitWidth(30);
        moinIV.setFitHeight(30);
        moinIV.setLayoutX(20);
        moinIV.setLayoutY(455);

        rondloupe.setCursor(Cursor.HAND);
        loupeIV.setCursor(Cursor.HAND);
        ajouter.setCursor(Cursor.HAND);
        plusIV.setCursor(Cursor.HAND);

        ajouter.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                fReservation.show();
            }

        });

        supprimer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                fSupr.show();
            }

        });
        for (Rectangle r : tabRectangle) {
            r.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    fInfoEmp.actualiserInfo((Rectangle) t.getSource());

                    fInfoEmp.show();
                }

            });
        }

        supprimer.setCursor(Cursor.HAND);
        moinIV.setCursor(Cursor.HAND);

        GridPane plan = new GridPane();
        plan.setGridLinesVisible(false);
        plan.setLayoutX(200);
        plan.setLayoutY(100);
        plan.add(tabRectangle[0], 6, 0);
        plan.add(tabRectangle[1], 7, 0);
        plan.add(tabRectangle[2], 8, 0);
        plan.add(tabRectangle[3], 0, 1);
        plan.add(tabRectangle[4], 1, 1);
        plan.add(tabRectangle[5], 2, 1);
        plan.add(tabRectangle[6], 3, 1);
        plan.add(tabRectangle[7], 4, 1);
        plan.add(tabRectangle[8], 5, 1);
        plan.add(tabRectangle[9], 7, 1);
        plan.add(tabRectangle[10], 8, 1);
        plan.add(tabRectangle[11], 0, 2);
        plan.add(tabRectangle[12], 1, 2);
        plan.add(tabRectangle[13], 8, 2);
        plan.add(tabRectangle[14], 0, 3);
        plan.add(tabRectangle[15], 1, 3);
        plan.add(tabRectangle[16], 8, 3);
        plan.add(tabRectangle[17], 0, 4);
        plan.add(tabRectangle[18], 1, 4);
        plan.add(tabRectangle[19], 2, 4);
        plan.add(tabRectangle[20], 3, 4);
        plan.add(tabRectangle[21], 4, 4);
        plan.add(tabRectangle[22], 7, 4);
        plan.add(tabRectangle[23], 8, 4);
        plan.add(tabRectangle[24], 0, 5);
        plan.add(tabRectangle[25], 1, 5);
        plan.add(tabRectangle[26], 2, 5);
        plan.add(tabRectangle[27], 3, 5);
        plan.add(tabRectangle[28], 4, 5);
        plan.add(tabRectangle[29], 5, 5);
        plan.add(tabRectangle[30], 6, 5);
        plan.add(tabRectangle[31], 7, 5);
        plan.setHgap(50);
        plan.setVgap(50);

        Image lac = new Image(getClass().getResource("images/lac.png").toString());
        ImageView lacIV = new ImageView(lac);
        lacIV.setFitWidth(375);
        lacIV.setFitHeight(225);
        lacIV.setLayoutX(350);
        lacIV.setLayoutY(150);

        fermer.setLayoutX(700);
        fermer.setLayoutY(550);
        fermer.setOnAction(e -> {
            quitter(e);
        });

        Group recherche = new Group();
        recherche.getChildren().addAll(rondloupe, loupeIV);

        Group legende = new Group();
        legende.getChildren().addAll(carrevert, carrerouge, Libre, reserve, ajouter, supprimer, plusIV, moinIV);

        Group carte = new Group();
        carte.getChildren().addAll(plan, lacIV);

        Group total = new Group();
        total.getChildren().addAll(fond, recherche, legende, carte, fermer);
        return total;
    }

    private void quitter(ActionEvent e) {
        if (e.getSource() == fermer) {
            this.close();
        }
    }

}