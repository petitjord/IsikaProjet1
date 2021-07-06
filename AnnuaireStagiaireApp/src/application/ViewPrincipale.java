package application;


import java.util.List;

import javafx.collections.FXCollections;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewPrincipale {
	
	private String fileName = "C:\\STAGIAIRES.DON";
	private Annuaire annuaire;

//	private VueAjoutStagiaire vueAjoutStagiaire = new VueAjoutStagiaire();
//	private Stage primaryStage;
//
	public ViewPrincipale() {
		initAnnuaire();
	}

	private void initAnnuaire() {
		annuaire = new Annuaire();
		annuaire.lectureFichier(fileName);
	}
	
	//public void afficher() {
	public void start(Stage primaryStage) {
		
		// Cr�ation d'un menu
		MenuBar menuBarApp = new MenuBar();
		// menus
        Menu ouvrirMenu = new Menu("Ouvrir");
        Menu ajouterMenu = new Menu("Ajouter");
        Menu editerMenu = new Menu("Editer");
        Menu aideMenu = new Menu("Aide");
        //MenuItem download
        MenuItem downloadItem = new MenuItem("T�l�charger la documentation yes");
        aideMenu.getItems().add(downloadItem);
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
	    TableColumn<Stagiaire, String> DepartementCol = new TableColumn<>("D�partement");
	    TableColumn<Stagiaire, String> PromotionCol = new TableColumn<>("Promotion");
	    TableColumn<Stagiaire, String> AnneeCol = new TableColumn<>("Ann�e");
	    tableauxList.getColumns().addAll(NomCol, PrenomCol, DepartementCol, PromotionCol, AnneeCol);
	    
	    
	    //List<Stagiaire> liste = annuaire.getStagiaires();
	    //tableauxList.setItems(FXCollections.observableList(liste));
	    
	    ScrollPane tableauxBox = new ScrollPane();
	    tableauxBox.setContent(tableauxList);
	    tableauxBox.setPadding(new Insets(0 ,0 , 0 ,0));
	    
	    Button saveBtn = new Button("Sauvegarder");
	    HBox saveBoxBtn = new HBox(0);
	    
	    
	   
//		Button ajouterStagiaireBtn = new Button("Ajouter");
//		ajouterStagiaireBtn.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				vueAjoutStagiaire.afficher();
//			}
//		});
	    VBox canvas = new VBox();
	    canvas.setSpacing(5); 
	    //canvas.setHgap(5);
	    canvas.getChildren().addAll(gridMenu, tableauxBox);
	    
		Scene scene = new Scene(canvas, 700, 550);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setTitle("D�veloppeur d'avant l'annuaire des �tudiants Isika");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
