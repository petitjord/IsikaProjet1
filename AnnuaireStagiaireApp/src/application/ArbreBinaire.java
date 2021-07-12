package application;

/**
 * Arbre binaire de Recherche
 * On utilise la g�n�recit� en passant le type des �l�ments en param�tres.
 * Pour rechercher il faut pouvoir trier et donc pouvoir comparer
 * Donc le type E doit �tre comparable.
 * @author leann
 *
 * @param <E>
 */

public class ArbreBinaire <E/* le type du parametre*/ extends Comparable<E> >{

	/**
	 * Un noeud est compos� d'une valeur, d'un fils gauche et droit => c'est une classe.
	 * Cette classe ne sert que dans l'arbre bianire et nulle part ailleurs,
	 * donc on en fait une classe interne priv�e
	 * Cette classe doit avoir un type g�n�rique. 
	 * @author leann
	 *
	 */

	public static class Noeud <T>{
		// T d�signe un type : Integer, String, FigureGeometrique, ...
		public T valeur;
		// Un arbre est r�cursif
		// Le fils gauche
		public Noeud <T> gauche;
		// Le fils droit
		public Noeud <T> droit;

		// Constructeur
		public Noeud(T t) {
			this.valeur = t;
			this.gauche = null;
			this.droit = null;
		}
		/**
		 * On red�fini la m�thode toString pour pouvoir convertir un noeud en string
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
	 * Attention : on acc�de tjr a l'arbre par la racine
	 * Donc celle ci ne doit pas �tre modifiable => pas de setter
	 * @return : la racine de l'arbre
	 */
	public Noeud<E> getRacine() {
		return racine;
	}
	/**
	 * Algo iteratif
	 * @param element : l'element � ajouter (pas de doublon)
	 */
	public void ajouterNoeud(E element) {
		// arbre vide
		// Position dans l'arbre
		Noeud<E> courant = racine;
		if (racine == null) racine = new Noeud<E>(element);
		else {
			// On doit parcourir l'arbre de mani�re it�rative
			// On prend un flag de type boolean
			boolean ok = false;
			while(!ok) {
				int test = element.compareTo(courant.valeur);
				// Si test < 0 on part dans le sous arbre gauche
				if(test < 0) {
					if(courant.gauche == null) {
						// On a trouve la place du nouveau noeud
						// On cr�e le nouveau noeud avec comme valeur �l�ment
						// On fait pointer le fils gauche du noeud courant sur
						// le nouveau noeud
						courant.gauche = new Noeud<E> (element);
						// C'est termin�
						ok = true;
					}
					// le fils gauche n'est pas null
					else {
						// il faut se d�placer dans le sous arbre gauche
						courant = courant.gauche;
					}
				} // fin �l�ment < valeur du noeud courant

				// element est > la valeur de l'element courant
				else if(test > 0) {
					if(courant.droit == null) {
						// On a trouve la place du nouveau noeud
						// On cr�e le nouveau noeud avec comme valeur �l�ment
						// On fait pointer le fils gauche du noeud courant sur
						// le nouveau noeud
						courant.droit = new Noeud<E> (element);
						// C'est termin�
						ok = true;
					}
					// le fils gauche n'est pas null
					else {
						// il faut se d�placer dans le sous arbre gauche
						courant = courant.droit;
					}
				} // fin �l�ment > valeur du noeud courant

				// element � ajouter existe d�ja
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
	 * @param element : element � rechercher
	 * @return : le oeud si trouv�
	 */
	public Noeud<E> rechercherRecursif(Noeud<E> noeud, E element) {
		if (noeud == null) return null;
		// On regarde si on a trouv� l'�l.
		if (element.compareTo(noeud.valeur) == 0) return noeud; 
		// quand une seule instruction pas besoin d'accolade
		if (element.compareTo(noeud.valeur) > 0) return rechercherRecursif(noeud.droit, element);
		else return rechercherRecursif(noeud.gauche, element);
	}
	/**
	 * recherche d'un �l�ment
	 @param noeud : la racine de l'arbre ou du sous arbre 
	 * @param element : element � rechercher
	 * @return : le oeud si trouv�
	 */
	public E rechercher(Noeud<E> noeud, E element) {
		Noeud<E> n = rechercherRecursif(noeud, element);
		if (n!=null) return n.valeur;
		return null;
	}
	/**
	 * Suppression d'un noeud de mani�re recursive
	 * @param noeud : la racine
	 * @param element : l'�l�ment � supprimer
	 * @return : le noeud supprimer
	 */
	public Noeud<E> supprimer(Noeud<E> courant, E element) {
		Noeud<E> result = courant;
		// On compare l'�l�ment a supprimer avec la valeur du noeud courant
		int test = element.compareTo(courant.valeur);
		// On a trouv� l'�lement � supprimer => c'est le noeud courant
		if (test == 0) {
			// On teste si courant � un fils gauche
			if (courant.gauche == null) {
				result = courant.droit;
			}
			else if (courant.droit == null) {
				result = courant.gauche;
			}
			else {
				// Le noeud a supp poss�de 2 sous-arbres
				// On remplace le noeud a supprimer par le plus petit
				// du sous-arbre droit du noeud � supprimer
				courant.valeur = plusPetiteValeurDuSousArbre(courant.droit);
				// On supprime le noeud du sous arbre droit qui contenait cette
				// plus petite valeur
				courant.droit = supprimer(courant.droit, courant.valeur);
			}
		} // fin noeud � supp trouv�
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
	 * Renvoi le + petit element du sous arbre pass� en parametre
	 * @param courant : racine du sous arbre dont on veut r�cuperer 
	 * le + petit element
	 * @return : la + petite valeur du sous arbre pass� en parametre
	 */
	private E plusPetiteValeurDuSousArbre(Noeud<E> courant) {
		if(courant == null) throw new NullPointerException();
		// On a trouv� la plus petite valeur
		if(courant.gauche == null) return courant.valeur;
		return plusPetiteValeurDuSousArbre(courant.gauche);
	}
	/**
	 * suppression d'une valeur dans un arbre binaire
	 * SANS MODIFIER L'ORDRE
	 * @param element
	 */
	public void supprimer(E element) {
		// L'�l�ment � supprimer ne peut être null
		if (element == null) throw new NullPointerException();
		// On met la racine en parametre = d�but de l'arbre
		racine = supprimer(racine, element);
	}


} // fin de la classe ArbreBinaire

