package application;


/**
 * Arbre binaire de Recherche
 * On utilise la générecité en passant le type des éléments en paramètres.
 * Pour rechercher il faut pouvoir trier et donc pouvoir comparer
 * Donc le type E doit être comparable.
 * @author leann
 *
 * @param <E>
 */

public class ArbreBinaire <E/* le type du parametre*/ extends Comparable<E> >{
	
	/**
	 * Un noeud est composé d'une valeur, d'un fils gauche et droit => c'est une classe.
	 * Cette classe ne sert que dans l'arbre bianire et nulle part ailleurs,
	 * donc on en fait une classe interne privée
	 * Cette classe doit avoir un type générique. 
	 * @author leann
	 *
	 */
	
	private static class Noeud <T>{
		// T désigne un type : Integer, String, FigureGeometrique, ...
		private T valeur;
		// Un arbre est récursif
		// Le fils gauche
		private Noeud <T> gauche;
		// Le fils droit
		private Noeud <T> droit;
		
		// Constructeur
		public Noeud(T t) {
			this.valeur = t;
			this.gauche = null;
			this.droit = null;
		}
		/**
		 * On redéfini la méthode toString pour pouvoir convertir un noeud en string
		 */
		@Override
		public String toString() {
			return "Noeud [valeur=" + valeur + ", gauche=" + gauche + ", droit=" + droit + "]";
		}
	} // fin classe noeud
	/**
	 * Attributs de l'arbre : la racine qui est obligatoire
	 */
	private Noeud<E> racine = null;
	/**
	 * Attention : on accède tjr a l'arbre par la racine
	 * Donc celle ci ne doit pas être modifiable => pas de setter
	 * @return : la racine de l'arbre
	 */
	public Noeud<E> getRacine() {
		return racine;
	}
	/**
	 * Algo iteratif
	 * @param element : l'element à ajouter (pas de doublon)
	 */
	public void ajouterNoeud(E element) {
		// arbre vide
		// Position dans l'arbre
		Noeud<E> courant = racine;
		if (racine == null) racine = new Noeud<E>(element);
		else {
			// On doit parcourir l'arbre de manière itérative
			// On prend un flag de type boolean
			boolean ok = false;
			while(!ok) {
				int test = element.compareTo(courant.valeur);
				// Si test < 0 on part dans le sous arbre gauche
				if(test < 0) {
					if(courant.gauche == null) {
						// On a trouve la place du nouveau noeud
						// On crée le nouveau noeud avec comme valeur élément
						// On fait pointer le fils gauche du noeud courant sur
						// le nouveau noeud
						courant.gauche = new Noeud<E> (element);
						// C'est terminé
						ok = true;
					}
					// le fils gauche n'est pas null
					else {
						// il faut se déplacer dans le sous arbre gauche
						courant = courant.gauche;
					}
				} // fin élément < valeur du noeud courant
				
				// element est > la valeur de l'element courant
				else if(test > 0) {
					if(courant.droit == null) {
						// On a trouve la place du nouveau noeud
						// On crée le nouveau noeud avec comme valeur élément
						// On fait pointer le fils gauche du noeud courant sur
						// le nouveau noeud
						courant.droit = new Noeud<E> (element);
						// C'est terminé
						ok = true;
					}
					// le fils gauche n'est pas null
					else {
						// il faut se déplacer dans le sous arbre gauche
						courant = courant.droit;
					}
				} // fin élément > valeur du noeud courant
				
				// element à ajouter existe déja
				// on ne veut pas de doublon
				else {
					ok = true;
				}
			} // fin du while, fin du parcourt
		} // fin arbre non vide
	} // fin ajouterNoeud
	
	public void parcoursInfixe(Noeud<E> n) {
		if (n != null) {
			// parcours infixe du sous arbre de gauche
			parcoursInfixe(n.gauche);
			System.out.println(n.valeur + " ; ");
			// parcours infixe du sous arbre droit
			parcoursInfixe(n.droit);
		}
	}
	/**
	 * Recherche recursive sur un arbre binaire
	 * @param noeud : la racine de l'arbre ou du sous arbre 
	 * @param element : element à rechercher
	 * @return : le oeud si trouvé
	 */
	public Noeud<E> rechercherRecursif(Noeud<E> noeud, E element) {
		if (noeud == null) return null;
		// On regarde si on a trouvé l'él.
		if (element.compareTo(noeud.valeur) == 0) return noeud; 
		// quand une seule instruction pas besoin d'accolade
		if (element.compareTo(noeud.valeur) > 0) return rechercherRecursif(noeud.droit, element);
		else return rechercherRecursif(noeud.gauche, element);
	}
	/**
	 * recherche d'un élément
	 @param noeud : la racine de l'arbre ou du sous arbre 
	 * @param element : element à rechercher
	 * @return : le oeud si trouvé
	 */
	public E rechercher(Noeud<E> noeud, E element) {
		Noeud<E> n = rechercherRecursif(noeud, element);
		if (n!=null) return n.valeur;
		return null;
	}
	/**
	 * Suppression d'un noeud de manière recursive
	 * @param noeud : la racine
	 * @param element : l'élément à supprimer
	 * @return : le noeud supprimer
	 */
	public Noeud<E> supprimer(Noeud<E> courant, E element) {
		Noeud<E> result = courant;
		// On compare l'élément a supprimer avec la valeur du noeud courant
		int test = element.compareTo(courant.valeur);
		// On a trouvé l'élement à supprimer => c'est le noeud courant
		if (test == 0) {
			// On teste si courant à un fils gauche
			if (courant.gauche == null) {
				result = courant.droit;
			}
			else if (courant.droit == null) {
				result = courant.gauche;
			}
			else {
				// Le noeud a supp possède 2 sous-arbres
				// On remplace le noeud a supprimer par le plus petit
				// du sous-arbre droit du noeud à supprimer
				courant.valeur = plusPetiteValeurDuSousArbre(courant.droit);
				// On supprime le noeud du sous arbre droit qui contenait cette
				// plus petite valeur
				courant.droit = supprimer(courant.droit, courant.valeur);
			}
		} // fin noeud à supp trouvé
		else if(test < 0) {
			// on parcours le sous-arbre gauche
			courant.gauche = supprimer(courant.gauche, element);
		}
		else {
			// on parcours le sous-arbre droit
			courant.droit = supprimer(courant.droit, element);
		}
		return result;
	} // fin de la méthode supprimer
	/**
	 * Renvoi le + petit element du sous arbre passé en parametre
	 * @param courant : racine du sous arbre dont on veut récuperer 
	 * le + petit element
	 * @return : la + petite valeur du sous arbre passé en parametre
	 */
	private E plusPetiteValeurDuSousArbre(Noeud<E> courant) {
		if(courant == null) throw new NullPointerException();
		// On a trouvé la plus petite valeur
		if(courant.gauche == null) return courant.valeur;
		return plusPetiteValeurDuSousArbre(courant.gauche);
	}
	/**
	 * suppression d'une valeur dans un arbre binaire
	 * SANS MODIFIER L'ORDRE
	 * @param element
	 */
	public void supprimer(E element) {
		// L'élément à supprimer ne peut être null
		if (element == null) throw new NullPointerException();
		// On met la racine en parametre = début de l'arbre
		racine = supprimer(racine, element);
	}
} // fin de la classe ArbreBinaire

