package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		ViewGlobalConnexion connexion = new ViewGlobalConnexion();
		connexion.start(arg0);
	}

}
