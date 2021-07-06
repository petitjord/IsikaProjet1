package application.to_clean;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VueAjoutStagiaireLow {

	private Pane pane;
	
	public VueAjoutStagiaireLow() {
		init();
	}

	private void init() {
		pane = new Pane();
		pane.getChildren().add(new Label("Test"));
	}

	public void afficher() {
		Stage stage = new Stage();
		Scene scene = new Scene(pane, 400, 250);
		
		stage.setScene(scene);
		stage.setTitle("Ajout de stagiaire");
		stage.show();
	}
}
