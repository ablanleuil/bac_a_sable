package bac_a_sable.core.geometrie;

import bac_a_sable.core.Math;

public class Cercle implements Forme {

	private float rayon;
	
	public Cercle(float r) {
		rayon = r;
	}
	
	@Override
	public float surface() {
		return Math.PI * rayon * rayon;
	}

	@Override
	public float perimetre() {
		return 2 * Math.PI * rayon;
	}

	@Override
	public String nom() {
		return "Cercle";
	}
}
