package application;

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
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewPrincipale {
	
	private VueAjoutStagiaire vueAjoutStagiaire = new VueAjoutStagiaire();
//	private Stage primaryStage;
//
//	public ViewPrincipale(Stage primaryStage) {
//		this.primaryStage = primaryStage;
//		
//	}

	//public void afficher() {
	public void start(Stage primaryStage) {
		
		MenuBar menuBarApp = new MenuBar();
		
		// menus
        Menu ouvrirMenu = new Menu("Ouvrir");
        Menu ajouterMenu = new Menu("Ajouter");
        Menu editerMenu = new Menu("Editer");
        Menu aideMenu = new Menu("Aide");
 
        // MenuItems pour le menu Fichier
        //MenuItem download
        MenuItem downloadItem = new MenuItem("Télécharger la documentation yes");
        
        //Button pour connexion 
	    Button buttonConnexion = new Button("Connexion");
        
        HBox btnsBox = new HBox(10);
        buttonConnexion.setAlignment(Pos.BOTTOM_RIGHT);
	    btnsBox.getChildren().add(buttonConnexion);
	    
	    aideMenu.getItems().add(downloadItem);
	    
	    menuBarApp.getMenus().addAll(ouvrirMenu, ajouterMenu, editerMenu, aideMenu); 
	    
	    VBox itemGauche = new VBox();
	    itemGauche.getChildren().add(menuBarApp);
	    VBox itemDroite = new VBox();
	    itemDroite.setAlignment(Pos.CENTER_RIGHT);
	    itemDroite.getChildren().add(btnsBox);
	    
	    GridPane gridMenu = new GridPane();
	    gridMenu.add(itemGauche, 0, 0);
	    gridMenu.add(itemDroite, 1, 0);
	    gridMenu.setVgap(50); 
	    gridMenu.setHgap(50);
	    //gridMenu.setGridLinesVisible(true);
	    //gridMenu.setPadding(new Insets(0, 0, 0, 0)); 
	    
	    Button saveBtn = new Button("Sauvegarder");
	    HBox saveBoxBtn = new HBox(10);
	    itemDroite.setPadding(new Insets(0, 0, 0, 360));
	    
	    TableView tableauxList = new TableView();
	    
	    ScrollPane tableauxBox = new ScrollPane();
	    //tableauxBox.
	    BorderPane root = new BorderPane();
	    root.setTop(gridMenu);
//		Button ajouterStagiaireBtn = new Button("Ajouter");
//		ajouterStagiaireBtn.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				vueAjoutStagiaire.afficher();
//			}
//		});
		Scene scene = new Scene(root, 700, 550);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setTitle("Développeur d'avant l'annuaire des étudiants Isika");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
