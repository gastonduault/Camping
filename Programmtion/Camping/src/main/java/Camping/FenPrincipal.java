package Camping;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FenPrincipal extends Stage{
    
    public FenPrincipal(){
        this.setTitle("Camping");
        this.setResizable(false);
        this.setMinWidth(500);
        this.setMinHeight(700);
        Scene fenPrin = new Scene(new Group());
        this.setScene(fenPrin);
    }
}