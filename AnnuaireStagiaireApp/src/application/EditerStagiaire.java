package application;


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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditerStagiaire {

	GridPane gridPane = new GridPane();
	private ViewPrincipale viewPrincipale;
	private Stagiaire stagiaire;

	public EditerStagiaire(ViewPrincipale viewPrincipale, Stagiaire stagiaire) {

		this.viewPrincipale = viewPrincipale;
		this.stagiaire = stagiaire;
		init();
	}
	
	private void init() {

		Text titre = new Text("Modifier un stagiaire");
		
		Label nameLabel = new Label("Nom");
		TextField nameText = new TextField();
		nameText.setText(stagiaire.nom);
		
		Label firstNameLabel = new Label("Prénom");
		TextField firstNameText = new TextField();
		firstNameText.setText(stagiaire.prenom);

		Label departementLabel = new Label("Département");
		TextField departementText = new TextField();
		departementText.setText("" + stagiaire.departement);

		Label promotionsLabel = new Label("Promotion");
		ChoiceBox<String> promochoiceBox = new ChoiceBox<String>();
		promochoiceBox.getItems().addAll(viewPrincipale.getAnnuaire().getAllPromos());
		promochoiceBox.setValue(stagiaire.promo);


		Label anneeLabel = new Label("Année");
		ChoiceBox<Integer> anneechoiceBox = new ChoiceBox<Integer>();
		anneechoiceBox.getItems().addAll(viewPrincipale.getAnnuaire().getAllYears());
		anneechoiceBox.setValue(stagiaire.annee);

		Button buttonConfirm = new Button("Valider les modifications");
		buttonConfirm.setOnAction(new EventHandler<ActionEvent>() {

			
	// Fonctionnalité du bouton valider les modifications
	// Appel de la fonction editer de la vue principale avec l'objet stagiaire 
	// qui a été mis à jour
			@Override
			public void handle(ActionEvent arg0) {
				// à voir pour la méthode de sauvegarde
				// 1 - modifier les infos de l'objet stagiaire
				stagiaire.setNom(nameText.getText());
				System.out.println(stagiaire);
				
			}
		});

		gridPane.setMinSize(500, 500);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setVgap(15); 
		gridPane.setHgap(25);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.add(titre, 0, 0, 2, 1);
		GridPane.setHalignment(titre, HPos.CENTER);
		gridPane.add(nameLabel, 0, 1); 
		gridPane.add(nameText, 1, 1); 
		gridPane.add(titre, 0, 0, 2, 1);
		GridPane.setHalignment(titre, HPos.CENTER);
		gridPane.add(nameLabel, 0, 1); 
		gridPane.add(nameText, 1, 1); 
		gridPane.add(firstNameLabel, 0, 2);  
		gridPane.add(firstNameText, 1, 2); 
		gridPane.add(departementLabel, 0, 3); 
		gridPane.add(departementText, 1, 3);  
		gridPane.add(promotionsLabel, 0, 4); 
		gridPane.add(promochoiceBox, 1, 4);
		gridPane.add(anneeLabel, 0, 5); 
		gridPane.add(anneechoiceBox, 1, 5);  
		gridPane.add(buttonConfirm, 1, 7); 
		GridPane.setHalignment(buttonConfirm, HPos.CENTER);
		gridPane.add(promochoiceBox, 1, 4); 
		gridPane.add(anneeLabel, 0, 5); 
		gridPane.add(anneechoiceBox, 1, 5);
		gridPane.add(buttonConfirm, 1, 7); 
		GridPane.setHalignment(buttonConfirm, HPos.CENTER);
	}
	
	public void afficher() {
		Stage primaryStage = new Stage();
		Scene scene = new Scene(gridPane,500,500);
		scene.getStylesheets().add(getClass().getResource("applicationApp.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("DÉVELOPPEURS D'AVANT -  Formulaire d'édition d'un stagiare");
		primaryStage.setTitle("DÉVELOPPEURS D'AVANT -  Formulaire d'édition d'un stagiaire");
		primaryStage.show();
	}
}
