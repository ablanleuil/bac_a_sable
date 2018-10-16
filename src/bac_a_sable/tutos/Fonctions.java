package bac_a_sable.tutos;

public class Fonctions {

	/**
	 * 
	 * Met un nombre au carré
	 * 
	 * @param x
	 * @return x * x
	 */
	public static float carre(float x) {
		return power(x, 2);
	}
	
	/**
	 * 
	 * Calcule un nombre [x] à la puissance [n]
	 * 
	 * @param x
	 * @param n
	 * @return x puissance n
	 */
	public static float power(float x, int n) {
		float ret = 1;

		while (n > 0) {
			ret *= x;
			--n;
		}
		
		return ret;
	}
	
	/**
	 * 
	 * Affiche un tableau sous la forme "[val1; val2; val3; ...]"
	 * 
	 * @param array: le tableau a afficher
	 */
	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; ++i) {
			if (i > 0)
				System.out.print("; ");
			System.out.print(array[i]);
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		// Quand on crée un programme, pour l'organiser convenablement, on peut le séparer en fonctions.
		//
		
		{
			// Si jamais on a besoin de calculer PI à des puissances différentes, on peut écrire ce programme:
			
			System.out.println("Sans fonction: ");
			float pi = 3.14f;
			float pi2, pi3;
			
			pi2 = 1;
			for (int i = 0; i < 2; ++i)
				pi2 = pi2 * pi;
			System.out.println("pi^2 = "+pi2);
			
			pi3 = 1;
			for (int i = 0; i < 3; ++i)
				pi3 = pi3 * pi;
			System.out.println("pi^3 = "+pi3);
		}
		
		{
			// Plutôt que d'écrire une boucle pour chaque calcul des puissances de PI, on peut écrire une fonction
			// qui calcule une puissance:

			System.out.println("Avec fonction: ");
			
			float pi = 3.14f;
			float pi2 = power(pi, 2);
			float pi3 = power(pi, 3);
			
			System.out.println("pi^2 = "+pi2);
			System.out.println("pi^3 = "+pi3);
		}
		
		
		// Les fonctions se définissent par :
		// - Leur nom
		// - Leurs paramètres
		// - Le type de leur résultat
		
		// Exemple: 
		//
		// - float carre(float x) ->  la fonction se nomme "carre",
		//                            elle demande un 'float' en paramètre et renvoie un 'float'
		// - float power(float x, int n) -> "power" demande un 'float' et un 'int', et renvoie un 'float'
		//
		
		// On peut imbriquer les fonctions. La fonction [carre] utilise la fonction [power] pour mettre a la puissance 2
		System.out.println("5 * 5 = "+carre(5));
		
		// Une fonction n'a pas besoin de calculer une valeur à retourner.
		// Afficher un tableau, par exemple, ne calcule aucune valeur.
		
		// Le type du résultat sera donc [void] (vide/rien)
		
		int[] array = new int[] { 1, 2, 3 };
		printArray(array);
		printArray(new int[]{3, 2, 1, 6, 4, 5});
	}
}
