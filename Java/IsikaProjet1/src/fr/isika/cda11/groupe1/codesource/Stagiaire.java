package fr.isika.cda11.groupe1.codesource;

public class Stagiaire {
	public String nom;
	public String prenom;
	public int departement;
	public String promo;
	public int annee;


	public Stagiaire(String nom, String prenom, int departement, String promo, int annee) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.departement = departement;
		this.promo = promo;
		this.annee = annee;
	}
	
	public Stagiaire() {
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public int getDepartement() {
		return departement;
	}


	public void setDepartement(int departement) {
		this.departement = departement;
	}


	public String getPromo() {
		return promo;
	}


	public void setPromo(String promo) {
		this.promo = promo;
	}


	public int getAnnee() {
		return annee;
	}


	public void setAnnee(int annee) {
		this.annee = annee;
	}



	public void afficher(){
		System.out.println("Nom : " + nom);
		System.out.println("Prénom : " + prenom);
		System.out.println("Département : " + departement);
		System.out.println("Promotion : " + promo);
		System.out.println("Année: " + annee);
	}

}
