package Camping;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        MobilHome m1 = new MobilHome(30, 12, 0, 4);
        Tente t1 = new Tente(24, 9, 3, 4, true , true);
        primaryStage = new FenReservation();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}