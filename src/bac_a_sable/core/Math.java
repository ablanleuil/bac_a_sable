package bac_a_sable.core;

public class Math {
	
	// Une valeur *très* approximative de PI
	public static final float PI = 3.14f;
	
	public static float power(float x, int n) {
		if (n < 0) return power(1/x, -n);
		
		float ret = 1;
		while (n > 0) {
			ret *= x;
			--n;
		}
		
		return ret;
	}
	
	public static float abs(float x) {
		if (x < 0)
			return -x;
		else
			return  x;
	}
	public static float sqrt(float x) {
		float rmin = 0, rmax = 1+x;

		while (abs(rmin - rmax) > 0.000001) {
			float mid = (rmin + rmax) / 2;
			if (mid * mid > x)
				rmax = mid;
			else if (mid * mid < x)
				rmin = mid;
			else return mid;
		}

		return rmin;
	}
}
