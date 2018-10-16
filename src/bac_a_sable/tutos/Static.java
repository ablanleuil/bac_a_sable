package bac_a_sable.tutos;

import bac_a_sable.core.Math;
import bac_a_sable.core.Point;

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
		
		Math m1 = new Math();
		Math m2 = new Math();
		
		System.out.println("m1.PI == m2.PI ? -> " + (m1.PI == m2.PI));
		
		// En général, les méthodes statiques d'une classe s'utilisent sans créer d'objet.
		// Pour utiliser une méthode statique, il suffit de l'appeler avec le nom de sa classe:
		
		System.out.println( Math.sqrt(4) );
		System.out.println( Math.sqrt(2) );
		System.out.println( Math.sqrt(Math.PI) );
	}
}
