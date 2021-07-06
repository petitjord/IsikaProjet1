package application;



public class AppArbreBinaire {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArbreBinaire<Integer> monArbreBinaire = new ArbreBinaire<Integer>();
		monArbreBinaire.ajouterNoeud(53);
		monArbreBinaire.ajouterNoeud(30);
		monArbreBinaire.ajouterNoeud(72);
		monArbreBinaire.ajouterNoeud(25);
		
		System.out.println("Affichage de la racine " + monArbreBinaire.getRacine());
		
		ArbreBinaire<String> monArbreDeString = new ArbreBinaire<String>();
		monArbreDeString.ajouterNoeud("LACROIX");
		monArbreDeString.ajouterNoeud("CHAVENEAU");
		monArbreDeString.ajouterNoeud("GARIJO");
		monArbreDeString.ajouterNoeud("POTIN");
		monArbreDeString.ajouterNoeud("AUGEREAU");
		
		monArbreDeString.parcoursInfixe(monArbreDeString.getRacine());
		
	}

}
