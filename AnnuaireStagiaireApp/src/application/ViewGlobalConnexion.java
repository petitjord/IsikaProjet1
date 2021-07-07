package application;
import static javafx.scene.paint.Color.FIREBRICK;

import java.net.URL;

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
        VBox titreBox = new VBox(10);
        titreBox.getChildren().addAll(titre, titre2);
        titreBox.setAlignment(Pos.CENTER);
       
        Label login = new Label("Login:");
        TextField loginTextField = new TextField();
        HBox loginBox = new HBox(55);
        loginBox.getChildren().addAll(login, loginTextField);
        loginBox.setAlignment(Pos.CENTER);
        
        Label pswd = new Label("Mot de passe :");
        PasswordField passwordField = new PasswordField();
        HBox pswdBox = new HBox(10);
        pswdBox.getChildren().addAll(pswd, passwordField);
        pswdBox.setAlignment(Pos.CENTER);
        
        //Ajout du bouton à la grille
        Button btn = new Button("Connexion");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
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
        grille.add(titreBox, 0, 0);
        grille.add(loginBox, 0, 2);
        grille.add(pswdBox, 0, 3);
        grille.add(hbBtn, 0, 4);
        grille.add(actionTexte, 0, 6);
        //grille.setGridLinesVisible(true);
        //HBox window = new HBox(10);
        //window.getChildren().addAll(formulaireMain);
        Scene scene = new Scene(grille, 400, 400);
        scene.getStylesheets().add(getClass().getResource("applicationApp.css").toExternalForm());
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Développeurs d'avant, annuaire des étudiants ISIKA");
        primaryStage.show();
    }
}
