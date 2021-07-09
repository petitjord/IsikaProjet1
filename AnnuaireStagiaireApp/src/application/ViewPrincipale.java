package application;


import static javafx.scene.paint.Color.FIREBRICK;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ViewPrincipale {


	private String fileName = "C:/GitHubRepo/IsikaProjet1/STAGIAIRES.DON";

	private Annuaire annuaire;
	private VueAjoutStagiaire vueAjoutStagiaire;
	private EditerStagiaire editerStagiaire;
	private Connexion connexionStagiaire;


	public ViewPrincipale() {
		initAnnuaire();
	}

	private void initAnnuaire() {
		annuaire = new Annuaire();
		annuaire.lectureFichier(fileName);
	}

	public void start(Stage primaryStage) {


		// Création d'un menu
		MenuBar menuBarApp = new MenuBar();

		// menus
		Menu ouvrirMenu = new Menu("Ouvrir");
		Menu ajouterMenu = new Menu("Ajouter");
		Menu editerMenu = new Menu("Editer");
		Menu aideMenu = new Menu("Aide");

		//MenuItem download
		MenuItem downloadItem = new MenuItem("Télécharger la documentation");
		aideMenu.getItems().add(downloadItem);
		downloadItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		MenuItem ajouterStagiaireMenuItem = new MenuItem("Ajouter un Stagiaire");
		ajouterMenu.getItems().add(ajouterStagiaireMenuItem);
		ajouterStagiaireMenuItem.setOnAction(new EventHandler<ActionEvent>() {


			@Override
			public void handle(ActionEvent arg0) {
				afficherVueAjoutStagiaire();
			}

		});

		MenuItem editerStagiaireMenuItem = new MenuItem("Editer un Stagiaire");
		editerMenu.getItems().add(editerStagiaireMenuItem);


		// ajout de tous les menus
		menuBarApp.getMenus().addAll(ouvrirMenu, ajouterMenu, editerMenu, aideMenu);
		BorderPane root = new BorderPane();
		root.setTop(menuBarApp);

		//Button et hbox pour connexion 
		Button buttonConnexion = new Button("Connexion");
		HBox btnsBox = new HBox(10);
		buttonConnexion.setAlignment(Pos.BASELINE_LEFT);
		btnsBox.getChildren().add(buttonConnexion);
		buttonConnexion.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				afficherVueConnexion();
			}

		});

		// Recherche Avancée

		// colonne de gauche et de droite pour le menu globale
		HBox itemGauche = new HBox();
		itemGauche.getChildren().add(root);
		itemGauche.setAlignment(Pos.BASELINE_LEFT);
		HBox itemDroite = new HBox();
		itemDroite.setAlignment(Pos.BASELINE_RIGHT);
		itemDroite.getChildren().add(btnsBox);
		itemDroite.setPadding(new Insets(0, 0, 0, 380));

		GridPane gridMenu = new GridPane();
		gridMenu.add(itemGauche, 0, 0);
		gridMenu.add(itemDroite, 3, 0);
		gridMenu.setVgap(5); 
		gridMenu.setHgap(5);
		gridMenu.setAlignment(Pos.BASELINE_LEFT);

		Label nameLabel = new Label("Nom-Prénom");
		TextField nameText = new TextField();

		// ajout de la HBox
		HBox searchBar = new HBox(10);
		searchBar.getChildren().addAll(nameLabel, nameText);

		// ajout de la VBox
		VBox rootSearch = new VBox();
		rootSearch.getChildren().addAll(searchBar);

		// box des départements
		ChoiceBox departementchoiceBox = new ChoiceBox();
		departementchoiceBox.getItems().addAll(getAnnuaire().getAllDep());
		Button departementBtn = new Button("Départements", departementchoiceBox);
		HBox departementBox = new HBox(10);
		departementBox.getChildren().add(departementBtn);

		// box des années
		ChoiceBox<Integer> anneechoiceBox = new ChoiceBox();
		anneechoiceBox.getItems().addAll(getAnnuaire().getAllYears());
		Button yearBtn = new Button("Année", anneechoiceBox);
		HBox yearBox = new HBox(10);
		yearBox.getChildren().add(yearBtn);

		// box des promotions
		ChoiceBox<String> promotionschoiceBox = new ChoiceBox();
		promotionschoiceBox.getItems().addAll(getAnnuaire().getAllPromos());
		Button promotionBtn = new Button("Promotions", promotionschoiceBox);
		HBox promotionBox = new HBox(10);
		promotionBox.getChildren().add(promotionBtn);

		// Ajout des boutons à la grille
		Button validateBtn = new Button("Valider");
		HBox validateBox = new HBox(10);
		validateBox.getChildren().add(validateBtn);

		// Hbox des comboBox
		HBox itemsChoiceBox = new HBox(10);
		itemsChoiceBox.getChildren().addAll(departementBox, yearBox, promotionBox, validateBox);

		GridPane gridPaneSearch = new GridPane();
		gridPaneSearch.setHgap(10);
		gridPaneSearch.setVgap(10);
		gridPaneSearch.setPadding(new Insets(20, 20, 20, 20));
		gridPaneSearch.add(searchBar, 0, 0);
		gridPaneSearch.add(itemsChoiceBox, 0, 1);


		// Création du tableaux 

		TableView<Stagiaire> tableauxList = new TableView();
		Stagiaire stagi = tableauxList.getSelectionModel().getSelectedItem();
		TableColumn<Stagiaire, String> NomCol = new TableColumn<>("Nom");
		TableColumn<Stagiaire, String> PrenomCol = new TableColumn<>("Prenom");
		TableColumn<Stagiaire, String> DepartementCol = new TableColumn<>("Département");
		TableColumn<Stagiaire, String> PromotionCol = new TableColumn<>("Promotion");
		TableColumn<Stagiaire, String> AnneeCol = new TableColumn<>("Année");

		NomCol.prefWidthProperty().bind(tableauxList.widthProperty().divide(5));
		PrenomCol.prefWidthProperty().bind(tableauxList.widthProperty().divide(5));
		DepartementCol.prefWidthProperty().bind(tableauxList.widthProperty().divide(5));
		PromotionCol.prefWidthProperty().bind(tableauxList.widthProperty().divide(5));
		AnneeCol.prefWidthProperty().bind(tableauxList.widthProperty().divide(5));

		NomCol.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));
		PrenomCol.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));
		DepartementCol.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("departement"));
		PromotionCol.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("promo"));
		AnneeCol.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("annee"));

		tableauxList.getColumns().addAll(NomCol, PrenomCol, DepartementCol, PromotionCol, AnneeCol);
		tableauxList.setMaxWidth(660);
		tableauxList.setMinWidth(660);

		editerStagiaireMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Stagiaire selectedLine = tableauxList.getSelectionModel().getSelectedItem();
				afficherVueEditerStagiaire(selectedLine);
			}
		});

		tableauxList.setMaxWidth(660);
		tableauxList.setMinWidth(660);

		List<Stagiaire> listStagiaireDansArbreBinaire = annuaire.getListStagiaireDansArbreBinaire();
		tableauxList.setItems(FXCollections.observableList(listStagiaireDansArbreBinaire));

		Button selectAllBtn = new Button("Sélectionner tout");
		HBox selectAllBoxBtn = new HBox(5);
		selectAllBoxBtn.getChildren().add(selectAllBtn);

		GridPane topBtns = new GridPane();
		topBtns.add(selectAllBoxBtn, 0, 0);
		topBtns.setPadding(new Insets(10, 0, 0, 20));

		HBox tableauxBox = new HBox();
		tableauxBox.getChildren().add(tableauxList);
		tableauxBox.setPadding(new Insets(10 ,10 ,10 ,20));
		tableauxBox.setMinWidth(680);

		Button printBtn = new Button("Imprimer");
		HBox printBoxBtn = new HBox(5);
		printBoxBtn.getChildren().add(printBtn);
		Button deleteBtn = new Button("Supprimer");
		HBox deleteBoxBtn = new HBox(5);
		deleteBoxBtn.getChildren().add(deleteBtn);
		Button editBtn = new Button("Editer");
		HBox editBoxBtn = new HBox(5);
		editBoxBtn.getChildren().add(editBtn);
		editBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				Stagiaire selectedLine = tableauxList.getSelectionModel().getSelectedItem();
				afficherVueEditerStagiaire(selectedLine);
			}

		});

		Button saveBtn = new Button("Sauvegarder");
		HBox saveBoxBtn = new HBox(5);
		saveBoxBtn.getChildren().add(saveBtn);
		saveBoxBtn.setPadding(new Insets(0 ,0 ,0 ,370));
		saveBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				AnnuaireFileWriter annuaireFileWriter = new AnnuaireFileWriter();
				annuaireFileWriter.getListAnnuaireBinaire(listStagiaireDansArbreBinaire);
			}
		});

		GridPane bottomBtns = new GridPane();
		bottomBtns.add(printBoxBtn, 0, 0);
		bottomBtns.add(deleteBoxBtn, 1, 0);
		bottomBtns.add(editBoxBtn, 2, 0);
		bottomBtns.add(saveBoxBtn, 5, 0);
		bottomBtns.setPadding(new Insets(10, 0, 0, 20));
		bottomBtns.setVgap(5);
		bottomBtns.setHgap(5);
		bottomBtns.setStyle("-fx-background-color : BLACK");

		VBox canvas = new VBox();
		canvas.setSpacing(5); 
		canvas.getChildren().addAll(gridMenu, gridPaneSearch, topBtns, tableauxBox,bottomBtns);

		Scene scene = new Scene(canvas, 700, 550);
		scene.getStylesheets().add(getClass().getResource("applicationApp.css").toExternalForm());
		primaryStage.setTitle("DÉVELOPPEURS D'AVANT - l'annuaire des étudiants Isika");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public Annuaire getAnnuaire() {
		return annuaire;
	}

	public void editerStagiaire(Stagiaire stagiaire) {
		annuaire.modifierStagiaire(stagiaire);
	}

	private void afficherVueEditerStagiaire(Stagiaire stagiaire) {
		editerStagiaire = new EditerStagiaire(this, stagiaire);
		editerStagiaire.afficher();
	}

	private void afficherVueAjoutStagiaire() {
		vueAjoutStagiaire = new VueAjoutStagiaire(this);
		vueAjoutStagiaire.afficher();
	}

	private void afficherVueConnexion() {
		connexionStagiaire = new Connexion(this);
		connexionStagiaire.afficher();
	}
}
