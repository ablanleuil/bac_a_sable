package bac_a_sable.corrections.tp3;

public class Fourmis{
	/**
	 * @param s
	 * 	un terme de la suite des fourmis
	 * @pre s.lenght() > 0
	 * 
	 * @return le terme suivant de la suite des fourmis
	 */
	
	public static String next(String ui){
		
		// normalement, la précondition nous affirme que [next]
		// ne sera appelée qu'avec un paramètre non null, et non vide
		// cependant, un petit test n'est pas superflu
		
		// Si [ui] est null ou vide, on retourne le premier élément de la suite
		if (ui == null || ui.isEmpty())
			return "1";
		
		/// A partir d'ici, nous sommes certains que [ui] n'est pas vide
		/// sinon la fonction aurait retourné "1"

		String new_value = "";

		final int length = ui.length(); // longueur de [ui]
		int i = 0, j; // compteurs de boucles
		
		while (i < length) {
			// caractère à l'emplacement [i]
			char atI = ui.charAt(i);
			
			// cette boucle [for] n'est ici que pour avancer [j]
			// elle s'arrête une fois la fin de la chaîne atteinte
			// ou un nouveau "groupe" de chiffres atteint
			for (j = i+1; j < length && atI == ui.charAt(j); ++j);

			new_value += "" + (j-i) + atI;
			i = j;
		}
		
		return new_value;
	}
}