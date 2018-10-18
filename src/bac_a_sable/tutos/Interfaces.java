package bac_a_sable.tutos;

import java.util.ArrayList;

import bac_a_sable.core.geometrie.Cercle;
import bac_a_sable.core.geometrie.Forme;
import bac_a_sable.core.geometrie.Rectangle;

public class Interfaces {
	public static void main(String[] args) {
		
		// Une interface définit un comportement commun à plusieurs classes
		// Par exemple, une Forme géométrique est un objet pour lequel on peut
		// calculer le périmètre et la surface (c.f. interface Forme)
		
		// Mais il existe plusieurs formes géométriques remarquables:
		// Les cercles, les rectangles, ...
		
		// Et si jamais on avait envie de manipuler des formes sans se soucier de quel type de forme
		// on manipule ? C'est possible grace aux interfaces.
		
		
		// Ici, [f] pointe vers un objet qui "est une Forme". Ou dit autrement, qui
		// "peut se comporter comme une Forme"
		Forme f;

		// Dans notre exemple, Deux classes peuvent être des Formes (Rectangle, et Cercle)
		f = new Cercle(10f);

		System.out.println("Périmetre du "+f.nom()+" 'f': "+f.perimetre());
		
		// Mais la seule restriction sur [f] est qu'elle doit contenir un objet qui "se comporte comme une Forme"
		// On peut donc créer un Rectangle et le mettre dans [f]
		f = new Rectangle(21f, 29.7f);
		
		System.out.println("Périmetre du "+f.nom()+" 'f': "+f.perimetre());
		
		
		// C'est très pratique notamment quand on veut créer des contenants (tableaux, listes, ...)
		// qui peuvent contenir des objets différents:
		
		// Si on cré une liste de Cercle:
		ArrayList<Cercle> cList = new ArrayList<Cercle>();
		
		// On peut ajouter des Cercles, aucun soucis
		cList.add(new Cercle(1));
		
		// Mais si on veut ajouter autre chose, par exemple, des Rectangles
		// On aura une erreur !!
		
		// décommentez la ligne suivante pour voir apparaitre une erreur.
		// cList.add(new Rectangle(1f, 2f)); 
		
		
		
		// Si maintenant on a une liste de [Forme]
		ArrayList<Forme> fList = new ArrayList<Forme>();
		
		// On peut y ajouter n'importe quel style de Forme que l'on veut.
		fList.add(new Cercle(10f));
		fList.add(new Rectangle(4, 4));
		
		// Et on peut les afficher un par un:
		for (Forme e : fList) {
			System.out.println("Un "+e.nom()+" avec une surface de "+e.surface());
		}
		
		
	}
}
