package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuBar extends Application{
	
	// Création d'un constructeur surchargé vide
	public MenuBar() {
		
	}
	
	public void MenuBar() {
		
		// Création de MenuBar
		javafx.scene.control.MenuBar menuBar = new javafx.scene.control.MenuBar();
		
		// menus
        Menu ouvrirMenu = new Menu("Ouvrir");
        Menu ajouterMenu = new Menu("Ajouter");
        Menu editerMenu = new Menu("Editer");
        Menu aideMenu = new Menu("Aide");
 
        // MenuItems pour le menu Fichier
        //MenuItem download
        MenuItem downloadItem = new MenuItem("Télécharger la documentation");
        
        //Button pour connexion 
	    Button buttonConnexion = new Button("Connexion");
        
        HBox connexionBtn = new HBox(10);
        buttonConnexion.setAlignment(Pos.BOTTOM_RIGHT);
	    buttonConnexion.getChildrenUnmodifiable().add(connexionBtn);
	    
	    aideMenu.getItems().add(downloadItem);
	    menuBar.getMenus().addAll(ouvrirMenu, ajouterMenu, editerMenu, aideMenu); 
	    
	    VBox itemGauche = new VBox();
	    itemGauche.getChildren().add(menuBar);
	    VBox itemDroite = new VBox();
	    itemDroite.setAlignment(Pos.BASELINE_RIGHT);
	    itemDroite.getChildren().add(buttonConnexion);
	    
	    GridPane gridMenu = new GridPane();
	    gridMenu.add(itemGauche, 0, 0);
	    gridMenu.add(itemDroite, 1, 0);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
