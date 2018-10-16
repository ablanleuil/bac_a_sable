package bac_a_sable.tutos;

import java.util.Scanner;

public class ConditionsEtBoucles {
	
	public static boolean sorted(int[] array) {
		for (int i = 0; i < array.length-1; ++i) {
			if (array[i] > array[i+1])
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// Dans un programme, on doit souvent faire des choix.
		// Par exemple ... donner l'accès à un site selon une limite d'âge ;-)
		
		int age = 15;
		if (age >= 18) {
			System.out.println("Entrez donc !");
		} else {
			System.out.println("Stop, on ne passe pas !");
		}
		
		// La structure "if" est constituée de plusieurs parties:
		
		//   if (condition)    <- la condition (une expression qui doit renvoyer une valeur booléenne (true ou false)
		//   {
		//        un bloc de code; qui sera exécuté seulement si la [condition] est vraie
		//   }
		//   else              <- sinon
		//   {
		//        un deuxième bloc de code qui s'exécutera seulement si la condition est fausse 
		//   }
		
		// Dans la partie [condition] on peut trouver toutes sortes de tests.
		// des tests d'égalité (==) , d'inégalité (>, <, <=, >=, !=)
		
		// mais aussi d'autres tests comme "savoir si un tableau est trié"
		int[] array = new int[] { 1, 2, 3, 4 };
		if (sorted(array)) {
			System.out.println("Ce tableau est trié, youpi !");
		} else {
			System.out.println("Nope, ce tableau n'est pas trié.");
		}
		
		
		// Quand on veut répéter une action selon une condition, on utilise la structure:
		
		// while (condition) {
		//    bloc de code;
		// }
		
		// Par exemple
		
		Scanner sc = new Scanner(System.in);
		int n = -1;
		while (n < 0) {
			System.out.println("Entrez un nombre positif: ");
			n = sc.nextInt();
		}
		
		// Quand on veut effectuer une tâche un nombre définit de fois, on peut utiliser une boucle [for]
		//
		// for (initialisation; condition; pas)
		// {
		//     bloc de code;
		// }
		
		// "Pour tout [i] allant de 0 à 9, afficher [i]"
		for (int i = 0; i < 10; ++i) {
			System.out.println(i);
		}
	}
}
