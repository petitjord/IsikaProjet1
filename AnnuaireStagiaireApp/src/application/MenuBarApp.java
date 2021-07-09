package application;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MenuBarApp extends Parent {

	// Création d'un constructeur surchargé vide
	public MenuBarApp() {

	}

	public void init() {

		// Création de MenuBar
		MenuBar menuBarApp = new MenuBar();

		// menus
		Menu ouvrirMenu = new Menu("Ouvrir");
		Menu ajouterMenu = new Menu("Ajouter");
		Menu editerMenu = new Menu("Editer");
		Menu aideMenu = new Menu("Aide");

		// MenuItems pour le menu Fichier
		
		// MenuItem download
		MenuItem downloadItem = new MenuItem("Télécharger la documentation");

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
		itemDroite.setAlignment(Pos.BASELINE_RIGHT);
		itemDroite.getChildren().add(btnsBox);

		GridPane gridMenu = new GridPane();
		gridMenu.add(itemGauche, 0, 0);
		gridMenu.add(itemDroite, 1, 0);

	}

}
