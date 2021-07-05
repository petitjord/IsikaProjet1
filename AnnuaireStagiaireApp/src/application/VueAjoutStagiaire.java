package application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class VueAjoutStagiaire {

	private FlowPane pane;

	public VueAjoutStagiaire() {
		init();
	}

	private void init() {
		pane = new FlowPane();
		pane.getChildren().add(new Label("test"));
	}
	
	public void afficher() {
		Stage primaryStage = new Stage();
		Scene scene = new Scene(pane,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
