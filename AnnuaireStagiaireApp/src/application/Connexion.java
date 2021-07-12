package application;


import static javafx.scene.paint.Color.FIREBRICK;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Connexion {

	GridPane gridPane = new GridPane();
	private ViewPrincipale viewPrincipale;

	public Connexion(ViewPrincipale viewPrincipale) {
		this.viewPrincipale = viewPrincipale;
		init();
	}

	//public void start(Stage primaryStage) {
	private void init() {

		//Remplir la grille
		Text titre = new Text("Connecte toi pour accéder à plus d'options");

		titre.setId("titreText");

		Label login = new Label("Login :");
		TextField loginTextField = new TextField();

		Label pswd = new Label("Mot de passe :");
		PasswordField pswdPasswordField = new PasswordField();

		//Ajout du bouton la grille
		Button btn = new Button("Connexion");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		hbBtn.getChildren().add(btn);

		//Ajout d'une zone de texte
		Text actionTexte = new Text();
		actionTexte.setId("actionTexte");

		//Action Bouton
		btn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				actionTexte.setFill(FIREBRICK);
				actionTexte.setText("Vérification en cours");

			}

		});

		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.add(titre, 0, 0);
		gridPane.add(login, 0, 2);
		gridPane.add(loginTextField, 1, 2);
		gridPane.add(pswd, 0, 3);
		gridPane.add(pswdPasswordField, 1, 3);
		gridPane.add(hbBtn, 1, 4);
		gridPane.add(actionTexte, 1, 6);

	}

	public void afficher() {
		Stage primaryStage = new Stage();
		Scene scene = new Scene(gridPane,400,400);
		scene.getStylesheets().add(getClass().getResource("applicationApp.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("DÉVELOPPEURS D'AVANT -  Formulaire de connexion");
		primaryStage.show();
	}

}
