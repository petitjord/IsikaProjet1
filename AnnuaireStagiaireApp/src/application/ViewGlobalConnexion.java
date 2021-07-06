package application;
import static javafx.scene.paint.Color.FIREBRICK;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewGlobalConnexion {
	
    public void start(Stage primaryStage) {
       
        //Remplir la grille
        Text titre = new Text("Bienvenue sur Développeurs d'avant !");
        //titre.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Text titre2 = new Text("Connecte toi pour accéder à plus d'options");
        //Utilis� dans le fichier css pour identifier le noeud
        titre.setId("titreText");
       
        Label login = new Label("Login:");
        TextField loginTextField = new TextField();
        
        Label pswd = new Label("Mot de passe :");
        PasswordField pswdPasswordField = new PasswordField();
        
        //Ajout du bouton � la grille
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
                ViewPrincipale viewPrincipale = new ViewPrincipale();
                viewPrincipale.start(primaryStage);
            }
         
        });
        //créer une grille (GridPane Layout)
        GridPane grille = new GridPane();
        grille.setAlignment(Pos.CENTER);
        grille.setHgap(10);
        grille.setVgap(10);
        grille.setPadding(new Insets(20, 20, 20, 20));
        grille.add(titre, 0, 0);
        grille.add(titre2, 0, 1);
        grille.add(login, 0, 2);
        grille.add(loginTextField, 1, 2);
        grille.add(pswd, 0, 3);
        grille.add(pswdPasswordField, 1, 3);
        grille.add(hbBtn, 1, 4);
        grille.add(actionTexte, 1, 6);
        //grille.setGridLinesVisible(true);
        HBox window = new HBox(10);
        window.getChildren().addAll(grille);
        Scene scene = new Scene(window, 400, 400);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Développeurs d'avant, annuaire des étudiants ISIKA");
        primaryStage.show();
    }
}
