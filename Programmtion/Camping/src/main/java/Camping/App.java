package Camping;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
	
	public void start(Stage f) {
		f = new FenPrincipal();
		f.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}

