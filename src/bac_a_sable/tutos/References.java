package bac_a_sable.tutos;

import bac_a_sable.core.geometrie.Point;

public class References {

	
	public static void modifyPoint(Point p) {
		++p.x;
	}
	
	public static void modifyInt(int n) {
		++n;
	}
	
	// tri par selection
	public static void tri(int[] tab) {
		for (int i = 0; i < tab.length; ++i) {
			int minJ = i;
			for (int j = i+1; j < tab.length; ++j) {
				if (tab[minJ] > tab[j])
					minJ = j;
			}
			
			int buff = tab[minJ];
			tab[minJ] = tab[i];
			tab[i] = buff;
		}
	}
	
	public static String arrayToString(int[] tab) {
		String ret = "[";
		for (int i = 0; i < tab.length; ++i) {
			if (i > 0)
				ret += "; ";
			ret += tab[i];
		}
		
		return ret + "]";
	}
	
	public static int power(int x, int n) {
		if (n == 0)
			return 1;
		else
			return x * power(x, n-1);
	}
	
	public static void main(String[] args) {
		
		// Les types primitifs sont reconnaissables par
		// leur nom entièrement en minuscule (int, char, float ...)
		//
		// quand on crée une variable de type primitif, on demande à l'ordinateur
		// une case en mémoire dans laquelle on pourra ranger la valeur de la variable.
		
		// Les classes (comme String, Integer, ...) par contre, sont différentes.
		//
		// Créer une variable qui a une classe en type revient à demander à l'ordinateur
		// une case en mémoire pour y placer une adresse. <- PAS UN OBJET
		//
		// On peut assigner deux valeurs différentes à une telle variable.
		// 
		// - Soit avec le mot clé [null], qui définit une adresse inexistante. Aucun objet n'est pointé par la variable.
		//
		// - Soit avec le mot clé "new".
		//   Cette opération va créer quelque-part en mémoire un objet, puis donner l'adresse de
		//   cet objet à la variable.
		//

		Integer i1 = null;
		Integer i2 = new Integer(0);
		
		System.out.println("i1 = "+i1);
		i1 = new Integer(0);
		System.out.println("i1 = "+i1);
		
		// Pour les objets, l'opérateur (==) teste l'égalité de leurs adresses.
		//
		// Pour tester l'égalité entre deux objets, on doit utiliser la méthode equals().
		
		
		System.out.println("\n---------- Test de (==) et equals() ------\n");
		System.out.println("i1 == i2      -> "+(i1 == i2));
		System.out.println("i1.equals(i2) -> "+(i1.equals(i2)));
		
		
		
		// Lors d'un appel de fonction, un objet est passé par référence. C'est à dire
		// qu'on envoie l'adresse de l'objet, plutôt que l'objet lui même.
		
		// Si on modifie un objet passé par référence dans une fonction, alors les changements
		// resteront une fois la fonction temrinée.
		
		System.out.println("\n---------- Test de modifyPoint(p) ---------\n");
		Point p = new Point(0, 0);
		System.out.println("avant modifyPair(p), p = "+p);
		modifyPoint(p);
		System.out.println("apres modifyPair(p), p = "+p);
		
		
		// Si on envoie un variable de type primitif en paramètres, alors elle
		// est passée par valeur. La fonction travaillera sur une copie du paramètre.
		// Les modifications sur un paramètre primitif se perdent une fois la fonction terminée.
		
		System.out.println("\n---------- Test de modifyInt(x) ----------\n");
		int x = 0;
		System.out.println("avant modifyInt(x), x = "+x);
		modifyInt(x);
		System.out.println("apres modifyInt(x), x = "+x);
		
		
		
		//
		// Les tableaux sont des objets ! Ils obéissent aux mêmes lois qu'eux.
		//
		// Notamment, modifier un tableau dans une fonction le gardera modifié
		// une fois la fonction terminée.
		//
		
		System.out.println("\n---------- Test de tri(tab) -----------------\n");
		
		int[] tab = new int[] { 9, 15, 1, 109, 59, 324, 5, 12, 156, 3 };
		
		System.out.println("avant tri(tab), tab = "+arrayToString(tab));
		tri(tab);
		System.out.println("apres tri(tab), tab = "+arrayToString(tab));
	}
}
