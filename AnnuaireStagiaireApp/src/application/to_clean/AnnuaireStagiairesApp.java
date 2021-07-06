package application.to_clean;
	
import application.ViewPrincipale;
import application.VueAjoutStagiaire;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class AnnuaireStagiairesApp extends Application {
	
	public void start(Stage primaryStage) {
		
		ViewPrincipale view = new ViewPrincipale();
		
//		Annuaire annuaire = new Annuaire();
//		List<Stagiaire> lectureFichier = annuaire.lectureFichier();
//		String texteTemporaire = "";
//		for(Stagiaire st : lectureFichier) {
//			st.afficher();
//			texteTemporaire += st.toString() + "\n"; 
//		}
		
		try {
			BorderPane root = new BorderPane();
			
			// TODO remplacer par la table view
			// creation de la table
			// ajout des colonnes
			// ajout des stagiaires à afficher
			
			TextArea text = new TextArea();
			
			//text.setText(texteTemporaire);
			
			root.setCenter(text);
			
			
			// Popur tester les autres vues
			VueAjoutStagiaire vueAjout = new VueAjoutStagiaire();
			vueAjout.afficher();
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		launch(args);
//	}
}
