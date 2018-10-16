package bac_a_sable.corrections.tp3;

/**
 * 
 * @author Mickaël Foursov <foursov@univ-rennes1.fr>
 * @version 5.0
 * @since 2015-11-10
 * 
 *        Classe représentant des doublets non modifiables
 */

public class Pair implements Comparable<Pair> {
	
	private int first; //first member of pair
    private int second; //second member of pair

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Cette fonction nous vient de l'interface [Comparable<Pair>]
     * 
     * p1.compareTo(p2) renvoie respectivement -1, 0, ou 1, selon si [p1] est
     * inférieur, égal, ou suppérieur à [p2].
     */
	@Override
	public int compareTo(Pair d) {
		// this < d
		if (d.first > this.first || (this.first == d.first && d.second > this.second))
			return -1;
		// this > d
		else if (d.first < this.first || (this.first == d.first && d.second < this.second))
			return 1;
		// this == d
		else
			return 0;
	}

	@Override
	public Pair clone() {
	    return new Pair(first, second);
	}

	@Override
	public String toString() {
		return "(" + first + "; " + second + ")";
	}

	/**
	 * obj1.equals(obj2) renvoie true si [obj1] est équivalent à [obj2]
	 * 
	 * Cette fonction diffère de 'obj1 == obj2', qui ne test que l'égalité entre références.
	 * 
	 * Ce code d'exemple:
	 * 
	 * Pair p1 = new Pair(0, 0);
	 * Pair p2 = new Pair(0, 0);
	 * 
	 * if (p1 == p2) {
	 *   System.out.println("p1 == p2 a renvoyé true !");
	 * }
	 * 
	 * if (p1.equals(p2)) {
	 *   System.out.println("p1.equals(p2) a renvoyé true !");
	 * }
	 * 
	 * n'affichera que "p1.equals(p2) a renvoyé true !"
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Pair) {
			Pair p = (Pair)obj;
			return compareTo(p) == 0;
		}
		
		return false;
	}
}