package application;


import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

	public ViewPrincipale() {
		initAnnuaire();
	}

	private void initAnnuaire() {
		annuaire = new Annuaire();
		annuaire.lectureFichier(fileName);
	}
	
	//public void afficher() {
	public void start(Stage primaryStage) {
		
		vueAjoutStagiaire = new VueAjoutStagiaire(this);
		
		// Création d'un menu
		MenuBar menuBarApp = new MenuBar();
		// menus
        Menu ouvrirMenu = new Menu("Ouvrir");
        Menu ajouterMenu = new Menu("Ajouter");
        Menu editerMenu = new Menu("Editer");
        Menu aideMenu = new Menu("Aide");
        
        //MenuItem download
        MenuItem downloadItem = new MenuItem("Télécharger la documentation yes");
        aideMenu.getItems().add(downloadItem);
        
	    MenuItem ajouterStagiaireMenuItem = new MenuItem("Ajouter un Stagiaire");
	    ajouterMenu.getItems().add(ajouterStagiaireMenuItem);
	    ajouterStagiaireMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				vueAjoutStagiaire.afficher();
			}
		});
	    
	    
	    // ajout de tous les menus
	    menuBarApp.getMenus().addAll(ouvrirMenu, ajouterMenu, editerMenu, aideMenu);
	    
	    BorderPane root = new BorderPane();
	    root.setTop(menuBarApp);
        
        //Button et hbox pour connexion 
	    Button buttonConnexion = new Button("Connexion");
        HBox btnsBox = new HBox(10);
        buttonConnexion.setAlignment(Pos.BASELINE_LEFT);
	    btnsBox.getChildren().add(buttonConnexion);
	    
	    // colonne de gauche et de droite pour le menu globale
	    HBox itemGauche = new HBox();
	    itemGauche.getChildren().add(root);
	    itemGauche.setAlignment(Pos.BASELINE_LEFT);
	    HBox itemDroite = new HBox();
	    itemDroite.setAlignment(Pos.BASELINE_RIGHT);
	    itemDroite.getChildren().add(btnsBox);
	    itemDroite.setPadding(new Insets(0, 0, 0, 100));
	    
	    GridPane gridMenu = new GridPane();
	    gridMenu.add(itemGauche, 0, 0);
	    gridMenu.add(itemDroite, 3, 0);
	    gridMenu.setVgap(5); 
	    gridMenu.setHgap(5);
	    //gridMenu.setGridLinesVisible(true);
	    gridMenu.setAlignment(Pos.BASELINE_LEFT);
	    
	    //gridMenu.setPadding(new Insets(0, 0, 0, 0)); 
	    
	    // Cr�ation du tableaux 
	    
	    TableView<Stagiaire> tableauxList = new TableView();
	    TableColumn<Stagiaire, String> NomCol = new TableColumn<>("Nom");
	    TableColumn<Stagiaire, String> PrenomCol = new TableColumn<>("Prenom");
	    TableColumn<Stagiaire, String> DepartementCol = new TableColumn<>("Département");
	    TableColumn<Stagiaire, String> PromotionCol = new TableColumn<>("Promotion");
	    TableColumn<Stagiaire, String> AnneeCol = new TableColumn<>("Année");
	    
	    
	    NomCol.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));
	    PrenomCol.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("prenom"));
	    DepartementCol.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("departement"));
	    PromotionCol.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("promo"));
	    AnneeCol.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("annee"));
	    
	    tableauxList.getColumns().addAll(NomCol, PrenomCol, DepartementCol, PromotionCol, AnneeCol);
	    
	   
	//    List<Stagiaire> liste = annuaire.getStagiaires();
	    List<Stagiaire> listStagiaireDansArbreBinaire = annuaire.getListStagiaireDansArbreBinaire();
	    tableauxList.setItems(FXCollections.observableList(listStagiaireDansArbreBinaire));
	    
	    ScrollPane tableauxBox = new ScrollPane();
	    tableauxBox.setContent(tableauxList);
	    tableauxBox.setPadding(new Insets(0 ,0 , 0 ,0));
	    
	    Button saveBtn = new Button("Sauvegarder");
	    HBox saveBoxBtn = new HBox(0);
	    
	    
	   
//		Button ajouterStagiaireBtn = new Button("Ajouter");
	   
	    
	    
	    VBox canvas = new VBox();
	    canvas.setSpacing(5); 
	    //canvas.setHgap(5);
	    canvas.getChildren().addAll(gridMenu, tableauxBox);
	    
		Scene scene = new Scene(canvas, 700, 550);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setTitle("Développeur d'avant l'annuaire des étudiants Isika");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public Annuaire getAnnuaire() {
		return annuaire;
	}
}
