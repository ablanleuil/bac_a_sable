package bac_a_sable.tutos;

public class Variables {
	public static void main(String[] args) {
		//   Dans un programme, on peut définir des variables.
		// 
		//   Ce sont des emplacements dans la mémoire de l'ordinateur
		// qu'on va utiliser pour stocker des valeurs.
		
		// Une variable se définit par : son type, et son nom
		// on écrit: 
		// 
		// [type] [nom];
		
		{
			int i;
			float x;
			String str;
		}
		
		// Comme en mathématiques, le type définit un ensemble:
		//
		// int     -> les entiers
		// float   -> les nombres décimaux (les réels)
		// boolean -> Vrai ou Faux (true ou false)
		// String  -> les chaînes de caractère.
		
		// Pour assigner une valeur à une vairiable, on utilise '='
		
		{
			int i = 5;
			float x = 3.14f;
			String str = "Salut !";
			
			boolean vraifaux = true;
		}
		
		// on peut changer la valeur d'une variable au cours du temps:
		
		{
			int i = 0;
			System.out.println("i = "+i);
			i = 5;
			System.out.println("i = "+i);
			i = i + i;
			System.out.println("i = "+i);
		}
	}
}
