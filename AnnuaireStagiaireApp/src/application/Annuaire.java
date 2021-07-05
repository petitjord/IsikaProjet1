package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Annuaire {
	
	
	// Transforme une chaine en un objet de type Stagiaire
	private static final String STAGIAIRES_DON = "src/application/fichiers/STAGIARES.DON";
	
	public List<Stagiaire> lectureFichier() {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		try {
			FileInputStream file = new FileInputStream(Annuaire.class.getResource("fichiers/STAGIAIRES.DON").getFile());
			Scanner scanner = new Scanner(file);
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
				
				// TODO remove later
				stagiaire.afficher();
				
				// ajout du stagiaire à la liste
				stagiaires.add(stagiaire);
			}
			scanner.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return stagiaires;
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
