package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import application.ArbreBinaire.Noeud;


public class Annuaire {
	
	
	// Transforme une chaine en un objet de type Stagiaire
	private static final String STAGIAIRES_DON = "src/application/fichiers/STAGIARES.DON";
	private ArbreBinaire<Stagiaire> arbre;
	private List<Stagiaire> listeStagiaires;

	public void lectureFichier(String fileName) {
		arbre = new ArbreBinaire<Stagiaire>();
		try {
		//	int compteur = 0;
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
				
				arbre.ajouterNoeud(stagiaire/*, compteur*/);

			//	compteur++;
			}
			scanner.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
		listeStagiaires = getListStagiaireDansArbreBinaire();
//		arbre.parcoursInfixe(arbre.getRacine());
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
	

	public Set<String> getAllPromos() {
		return listeStagiaires.stream()
			.map(stagiaire -> stagiaire.getPromo())
			.sorted()
			.collect(Collectors.toSet());
	}
	
	public Set<Integer> getAllYears() {
		return listeStagiaires.stream()
			.map(stagiaire -> stagiaire.getAnnee())
			.sorted()
			.collect(Collectors.toSet());
	}
	
	/**
	 * Recupere la liste dans l'arbre binaire
	 * 
	 * @return stagiaires
	 */
	public List<Stagiaire> getListStagiaireDansArbreBinaire() {
		List<Stagiaire> stagiaires = new ArrayList<>();
		getElementsArbreBinaire(stagiaires, arbre.getRacine());
		return stagiaires;
	}
	/**
	 * return le nombre d'elements dans l'arbre binaire
	 * 
	 * @param elements
	 * @param noeud
	 */
	private void getElementsArbreBinaire(List<Stagiaire> elements, Noeud<Stagiaire> noeud) {
		if(noeud.gauche != null) {
			getElementsArbreBinaire(elements, noeud.gauche);
		}
		if(noeud.droit != null ) {
			getElementsArbreBinaire(elements, noeud.droit);
		}
		elements.add(noeud.valeur);
	}


}
