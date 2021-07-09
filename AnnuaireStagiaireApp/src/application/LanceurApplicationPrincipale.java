package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class LanceurApplicationPrincipale extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		ViewGlobalConnexion connexion = new ViewGlobalConnexion();
		connexion.start(arg0);
	
	}

}
