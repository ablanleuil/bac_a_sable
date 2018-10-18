package bac_a_sable.tutos;

import bac_a_sable.core.Math;
import bac_a_sable.core.StaticTest;
import bac_a_sable.core.geometrie.Point;

public class Static {
	public static void main(String[] args) {
		
		// Quand on crée un objet, on dit qu'on "instancie sa classe",
		// ou qu'on crée une "instance d'une classe":
		
		{
			// Ici, on instancie la classe [Point]
			// Autrement dit : on crée un objet de type [Point]
			Point p = new Point(0, 0);
			
			// Un objet peut avoir des attributs propres, comme par exemple:
			// pour notre variable [p], les attributs [x] et [y].
			
			System.out.println("p.x = "+ p.x );
			System.out.println("p.y = "+ p.y );
		}
		
		{
			// En général, les attributs sont liés à leur objet.
			// Par exemple, pour deux [Point] différents, on aura deux [x] et deux [y] différents:
			Point p1 = new Point(0, 0);
			Point p2 = new Point(1, 1);
			
			System.out.println("p1 = "+p1);
			System.out.println("p2 = "+p2);
		}
		
		// Il existe des attributs communs à toutes les instances d'une classe.
		// Ces attributs sont préfixés par le mot clé "static"
		
		// Par exemple, la classe [bac_a_sable.core.Math] ne contient que des attributs
		// statiques.
		
		StaticTest s1 = new StaticTest();
		StaticTest s2 = new StaticTest();
		
		s1.notStaticValue = 6;
		s2.notStaticValue = 10;
		
		// ici, les valeurs seront différentes car ce sont des cases mémoire distinctes:
		System.out.println("notStaticValue: "+s1.notStaticValue+"  "+s2.notStaticValue);

		s1.staticValue = 18;
		s2.staticValue = 95;
		
		// ici, [staticValue] est une variable statique, alors tous les objets auront la
		// dernière valeur affectée:
		System.out.println("staticValue: "+s1.staticValue+"  "+s2.staticValue);
		
		// En général, les méthodes statiques d'une classe s'utilisent sans créer d'objet.
		// Pour utiliser une méthode statique, il suffit de l'appeler avec le nom de sa classe:

		// C'est très pratique quand on veut créer un module de fonctions utilitaires comme le module Math
		
		// La fonction racine carré est la même pour tout le monde
		System.out.println( Math.sqrt(4) );
		System.out.println( Math.sqrt(2) );
		// Dès qu'on veut utiliser des constantes mathématiques comme PI, on sait où les trouver
		System.out.println( Math.PI );
		
	}
}
