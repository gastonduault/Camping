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

  private static FenClient fClient = new FenClient();
  private static FenetreSupr fSupr = new FenetreSupr();
  private static FenSearch fSearch = new FenSearch();

  Color bleu = Color.web("#5A68D3");
  Color blanc = Color.web("#E9E6FF");
  Color bleuF = Color.web("#B5C7F8");
  Color vert = Color.web("#30CE52");
  Color rouge = Color.web("#EF383C");
  
  private Button fermer = new Button("Quitter");

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

    loupeIV.setOnMouseClicked(new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent t) {
            fSearch.show();
            close();
        }
    });
    rondloupe.setOnMouseClicked(new EventHandler<MouseEvent>()
    {
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
    
    ajouter.setOnMouseClicked(new EventHandler<MouseEvent>(){
    	@Override
        public void handle(MouseEvent t) {
            fClient.show();
        }
    
	});
    
     supprimer.setOnMouseClicked(new EventHandler<MouseEvent>(){
    	@Override
        public void handle(MouseEvent t) {
            fSupr.show();
        }
    
	});
	
    supprimer.setCursor(Cursor.HAND);
    moinIV.setCursor(Cursor.HAND);
    Rectangle e1 = new Rectangle(20, 20);
    Rectangle e2 = new Rectangle(20, 20);
    Rectangle e3 = new Rectangle(20, 20);
    Rectangle e4 = new Rectangle(20, 20);
    Rectangle e5 = new Rectangle(20, 20);
    Rectangle e6 = new Rectangle(20, 20);
    Rectangle e7 = new Rectangle(20, 20);
    Rectangle e8 = new Rectangle(20, 20);
    Rectangle e9 = new Rectangle(20, 20);
    Rectangle e10 = new Rectangle(20, 20);
    Rectangle e11 = new Rectangle(20, 20);
    Rectangle e12 = new Rectangle(20, 20);
    Rectangle e13 = new Rectangle(20, 20);
    Rectangle e14 = new Rectangle(20, 20);
    Rectangle e15 = new Rectangle(20, 20);
    Rectangle e16 = new Rectangle(20, 20);
    Rectangle e17 = new Rectangle(20, 20);
    Rectangle e18 = new Rectangle(20, 20);
    Rectangle e19 = new Rectangle(20, 20);
    Rectangle e20 = new Rectangle(20, 20);
    Rectangle e21 = new Rectangle(20, 20);
    Rectangle e22 = new Rectangle(20, 20);
    Rectangle e23 = new Rectangle(20, 20);
    Rectangle e24 = new Rectangle(20, 20);
    Rectangle e25 = new Rectangle(20, 20);
    Rectangle e26 = new Rectangle(20, 20);
    Rectangle e27 = new Rectangle(20, 20);
    Rectangle e28 = new Rectangle(20, 20);
    Rectangle e29 = new Rectangle(20, 20);
    Rectangle e30 = new Rectangle(20, 20);
    Rectangle e31 = new Rectangle(20, 20);
    Rectangle e32 = new Rectangle(20, 20);
    Rectangle e33 = new Rectangle(20, 20);

    GridPane plan = new GridPane();
    plan.setGridLinesVisible(false);
    plan.setLayoutX(200);
    plan.setLayoutY(100);
    plan.add(e1, 6, 0);
    plan.add(e2, 7, 0);
    plan.add(e3, 8, 0);
    plan.add(e4, 0, 1);
    plan.add(e5, 1, 1);
    plan.add(e6, 2, 1);
    plan.add(e7, 3, 1);
    plan.add(e8, 4, 1);
    plan.add(e9, 5, 1);
    plan.add(e10, 7, 1);
    plan.add(e11, 8, 1);
    plan.add(e12, 0, 2);
    plan.add(e13, 1, 2);
    plan.add(e14, 8, 2);
    plan.add(e15, 0, 3);
    plan.add(e16, 1, 3);
    plan.add(e17, 8, 3);
    plan.add(e18, 0, 4);
    plan.add(e19, 1, 4);
    plan.add(e20, 2, 4);
    plan.add(e21, 3, 4);
    plan.add(e22, 4, 4);
    plan.add(e23, 7, 4);
    plan.add(e24, 8, 4);
    plan.add(e25, 0, 5);
    plan.add(e26, 1, 5);
    plan.add(e27, 2, 5);
    plan.add(e28, 3, 5);
    plan.add(e29, 4, 5);
    plan.add(e30, 5, 5);
    plan.add(e31, 6, 5);
    plan.add(e32, 7, 5);
    plan.add(e33, 8, 5);
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
    fermer.setOnAction(e -> {quitter(e);});

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

    private void quitter(ActionEvent e){
      if(e.getSource()==fermer){
          System.exit(0);;
      }
  }
}