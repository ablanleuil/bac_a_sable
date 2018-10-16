package bac_a_sable.corrections.tp3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Arthur Blanleuil
 *
 *         Cette classe représente un tableau à taille dynamique contenant des
 *         entiers. Sa taille maximale est représentée par [SIZE_MAX].
 * 
 *         Pour réussir à simuler la taille dynamique du tableau, on décide
 *         d'utiliser un tableau à taille statique contenant [SIZE_MAX]
 *         éléments, et dont le nombre d'éléments qui nous intéresse (le nombre
 *         d'élements utilisés) est définit par la variable [size].
 * 
 *         Exemples:
 * 
 *         Un InsertionInteger vide : - array = [?, ?, ?, ?, ?, ?, ?, ?, ?, ?];
 *         - size = 0;
 * 
 *         Un InsertionInteger avec deux valeurs : - array = [2, 5, ?, ?, ?, ?,
 *         ?, ?, ?, ?]; - size = 2;
 * 
 *         Dans ces exemples, les cases du tableau avec un '?' représentent
 *         n'importe quelles valeurs.
 */
public class InsertionInteger {
	private static final int SIZE_MAX = 10;
	private int size;
	private int[] array;

	public InsertionInteger() {
		size = 0;
		array = new int[SIZE_MAX];
	}

	/**
	 * Copie la partie utilisée du tableau
	 * 
	 * @return un tableau contenant les [size] premiers éléments de [array]
	 */
	public int[] toArray() {
		
		// méthode courte
		return Arrays.copyOf(array, size);
		
		// méthode longue
		//
		// int[] ret = new int[size];
		// for (int i = 0; i < size; ++i)
		//   ret[i] = array[i];
		// return ret;
	}

	/**
	 * Insère une valeur dans le tableau. Les valeurs du tableau doivent être
	 * uniques, et toutes positives.
	 * 
	 * @pre [array] est trié
	 * 
	 * @param value,
	 *            la valeur à insérer dans le tableau
	 * @return true si la valeur a été insérée, false sinon
	 */
	public boolean insert(int value) {

		// Seules les valeurs positives sont acceptées
		if (value < 0)
			return false;

		// Si le tableau est rempli, il est impossible d'ajouter de nouvelles valeurs
		if (size == SIZE_MAX)
			return false;

		// recherche dichotomique de l'emplacement de [value]
		int i = 0, j = size;
		while (i < j) {
			int mid = (i + j) / 2;
			if (value > array[mid])
				i = mid + 1;
			else if (value < array[mid])
				j = mid;
			else // si [value] se trouve dans [array], on n'insère rien
				return false;
		}

		// A la fin de la recherche, [j] est positionné sur la première case dont la
		// valeur
		// est suppérieure à [value]. C'est ici qu'on va placer [value]

		// décale toutes les valeurs après [value] de 1 cran vers la droite

		// Méthode naïve
		for (int k = size; k > j; --k)
			array[k] = array[k - 1];
		
		// Méthode optimisée
		// System.arraycopy(array, j, array, j+1, size-j);

		// place [value] à la bonne place dans [array]
		array[j] = value;
		++size;

		// Si on arrive jusqu'ici, c'est que [value] a été placé dans le tableau. On
		// renvoie donc [true]
		return true;
	}

	/**
	 * Remplit le tableau à partir d'entiers lus par un Scanner
	 * 
	 * @param scanner:
	 *            le scanner permettant de récupérer les valeurs entières à partir
	 *            du flux scanné
	 */
	public void createArray(Scanner scanner) {
		while (scanner.hasNextInt()) {
			int next = scanner.nextInt();

			if (next == -1)
				return;

			insert(next);
		}
	}

	/**
	 * fonction utilitaire pour permettre d'afficher facilement le tableau
	 */
	@Override
	public String toString() {
		// ouverture tu tableau
		String result = "[";

		// écriture des nombres séparés par un ';'
		for (int i = 0; i < size; ++i) {
			// a partir du deuxième élément, on ajoute le séparateur avant chaque nombre
			if (i > 0)
				result += "; ";

			result += array[i];
		}

		// fermeture du tableau
		result += "]";

		return result;
	}

}
