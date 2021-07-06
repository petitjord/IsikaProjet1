package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Annuaire {
	
	
	// Transforme une chaine en un objet de type Stagiaire
	private static final String STAGIAIRES_DON = "src/application/fichiers/STAGIARES.DON";
	private ArbreBinaire<Stagiaire> arbre; 
		
	public void lectureFichier(String fileName) {
		arbre = new ArbreBinaire<Stagiaire>();
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			Scanner scanner = new Scanner(fis);
			while(scanner.hasNextLine()) {
		
				String nom = scanner.nextLine();
				String prenom = scanner.nextLine();
				int departement = Integer.parseInt(scanner.nextLine());
				String promo = scanner.nextLine();
				int annee = Integer.parseInt(scanner.nextLine());

				// la ligne avec * => ignorée
				scanner.nextLine();
				
				// On reconstitue une ligne complète avec les infos 
				String ligneCompleteAvecSeparateur = nom + "*" + prenom + "*" + departement+ "*"+promo+ "*"+annee;
				
				Stagiaire stagiaire = fabriqueStagiaire(ligneCompleteAvecSeparateur);
				
				arbre.ajouterNoeud(stagiaire);
			}
			scanner.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
		arbre.parcoursInfixe(arbre.getRacine());
	}
	
	Stagiaire fabriqueStagiaire(String chaine){
        Stagiaire stag=null;
        StringTokenizer st = new StringTokenizer(chaine, "*");
        if(st.countTokens()==5){
            String nom = st.nextToken();
            String prenom = st.nextToken();
            int departement = Integer.parseInt(st.nextToken());
            String promo = st.nextToken(); 
            int annee = Integer.parseInt(st.nextToken());
			stag = new Stagiaire(nom,prenom,departement,promo,annee);
        }   
        return stag;
    }

}
