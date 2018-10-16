package bac_a_sable.corrections.tp3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Arthur Blanleuil
 *
 *    Cette classe fonctionne exactement de la même façon que la classe [InsertionInteger], à ceci près
 *    qu'elle contient des [Pair] (voir le fichier Pair.java dans le même package) plutôt que des [int].
 */
public class InsertionPair {
	private static final int SIZE_MAX = 10;
	private int size;
	private Pair[] array;
	
	public InsertionPair(){
		size = 0;
		
		// Allocation de [SIZE_MAX] Pairs
		array = new Pair[SIZE_MAX];

		for (Pair p : array)
			p = new Pair(0,0);
	}
	

	/**
	 * Copie la partie utilisée du tableau
	 * @return un tableau contenant les [size] premiers éléments de [array]
	 */
	public Pair[] toArray() {
		return Arrays.copyOf(array, size);
	}
	
	/**
	 * Insère une valeur dans le tableau. Les valeurs du tableau doivent être uniques, et toutes positives.
	 * 
	 * @pre [array] est trié
	 * 
	 * @param value, la valeur à insérer dans le tableau
	 * @return true si la valeur a été insérée, false sinon
	 */
	public boolean insert(Pair value) {
		
		// Seules les valeurs positives sont acceptées
		if (value == null || value.compareTo(new Pair(0, 0)) == -1)
			return false;
		
		// Si le tableau est rempli, il est impossible d'ajouter de nouvelles valeurs
		if (size == SIZE_MAX)
			return false;

		// recherche dichotomique de l'emplacement de [value]
		int i = 0, j = size;
		while (i < j) {
			int mid = (i+j) / 2;
			if      (value.compareTo(array[mid]) == 1)
				i = mid+1;
			else if (value.compareTo(array[mid]) == -1)
				j = mid;
			else                         // si [value] se trouve dans [array], on n'insère rien 
				return false;
		}
		
		// A la fin de la recherche, [j] est positionné sur la première case dont la valeur
		// est suppérieure à [value]. C'est ici qu'on va placer [value]
		
		// décale toutes les valeurs après [value] de 1 cran vers la droite

		// Méthode naïve
		// for (int k = size; k > j; --k)
		// 	 array[k] = array[k - 1];
		
		// Méthode optimisée
		System.arraycopy(array, j, array, j+1, size-j);
		
		// place [value] à la bonne place dans [array]
		array[j] = value;
		++size;
		
		// Si on arrive jusqu'ici, c'est que [value] a été placé dans le tableau. On renvoie donc [true]
		return true;
	}
	
	/**
	 * Remplit le tableau à partir d'entiers lus par un Scanner
	 * 
	 * @param scanner: le scanner permettant de récupérer les valeurs entières à partir du flux scanné
	 */
	public void createArray(Scanner scanner) {
		while (scanner.hasNextInt()) {
			int nextX = scanner.nextInt();
			if (nextX == -1)
				return;
			
			int nextY = scanner.nextInt();
			if (nextY == -1)
				return;
			
			insert(new Pair(nextX, nextY));
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
	
	public static void main(String[] args) {
		String choice;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Veuillez choisir une méthode de saisie:");
			System.out.println("\thand: entrez les valeurs à la main en finissant par un -1");
			System.out.println("\tfile: entrez le nom d'un fichier dans lequel seront lues les valeurs");
			choice = sc.nextLine();
			
			InsertionPair ip = new InsertionPair();
			
			switch (choice) {
			case "hand":
				
				System.out.println("Entrez vos coordonnées séparées par des espaces ou des nouvelles lignes:");
				ip.createArray(sc);

				System.out.println(ip);
				sc.nextLine();
				
				break;
			case "file":
				System.out.print("Entrez le nom d'un fichier: ");
				String filename = sc.nextLine();
				
				try {
					ip.createArray(new Scanner(new File(filename)));
				} catch (FileNotFoundException e) {
					System.out.println("Erreur: fichier "+filename+" non trouvé.");
					break;
				}
				
				System.out.println(ip);
				
				break;
			default:
				System.out.println("Commande "+choice+" inconnue.");	
			}
			
			System.out.println("Continuer ? (y/n)");
			choice = sc.nextLine();
			switch (choice.toLowerCase()) {
			case "y":
			case "yes":
				break;
			default:
				System.out.println("Au revoir !");
				return;
			}
		}
	}
}