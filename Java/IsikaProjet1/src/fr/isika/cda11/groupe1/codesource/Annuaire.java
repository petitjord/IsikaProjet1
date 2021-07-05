package fr.isika.cda11.groupe1.codesource;

import java.util.StringTokenizer;



public class Annuaire {
	
	
	// Transforme une chaine en un objet de type Stagiaire
	
	private Stagiaire fabriqueStagiaire(String chaine){
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
