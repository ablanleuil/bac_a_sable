package bac_a_sable.core.geometrie;

public class Rectangle implements Forme {

	private float largeur;
	private float hauteur;
	
	public Rectangle(float w, float h) {
		largeur = w;
		hauteur = h;		
	}
	
	@Override
	public float surface() {
		return largeur * hauteur;
	}

	@Override
	public float perimetre() {
		return 2 * (largeur + hauteur);
	}

	@Override
	public String nom() {
		return "Rectangle";
	}
}
