package Camping;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage = new FenClient();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}