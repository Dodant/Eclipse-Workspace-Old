package CG;

public class IntervalMethod {
	private static final double EPSILON = 0.000001;
	public static double[] itvAdjust(double a[], double b) {
		return new double[] {a[0]+b, a[1]+b};
	}
	public static double[] itvMultiply(double a[], double b[]) {
		double num[] = new double[] { a[0]*b[0], a[1]*b[0], a[0]*b[1], a[1]*b[1] };
		double max = num[0], min = num[0];
		for (int i = 0; i < 4; i++) {
			if (num[i] > max) max = num[i];
			if (num[i] < min) min = num[i];
		}
		return new double[] {min,max};
	}
	public static double[] itvSqr(double a[]) {
		double min = a[0], max = a[1];
		return min*max < 0 	? new double[] {0, Math.max(min*min, max*max) } 
							: new double[] {Math.min(min*min, max*max), Math.max(min*min, max*max) };	
	}
	public static double[] IMforFX(double I[]) {
		double a = I[0], b = I[1];
		double J[] = itvMultiply(itvMultiply(itvAdjust(I, 1), itvAdjust(I, -1)), itvAdjust(I, -4));
		// f(x) = (x+1)(x-1)(x-4)
		
		if (J[0]*J[1] > 0) return null;
		double m = (a+b)/2;
		if (Math.abs(b-a) < EPSILON) {
			System.out.println("root = " + m);
			return new double [] {m, m + EPSILON};
		}
		
		double I1[] = new double[] {a, m}, I2[] = new double[] {m, b};
		IMforFX(I1); IMforFX(I2);
		return null;
	}
	public static double[] IMforGX(double I[]) {
		double a = I[0], b = I[1];
		double J[] = itvMultiply(itvMultiply(itvAdjust(I, 1), itvSqr(itvAdjust(I, -1))), itvAdjust(I, -4));
		// g(x) = (x+1)(x-1)^2(x-4)
		
		if (J[0]*J[1] > 0) return null;
		double m = (a+b)/2;
		if (Math.abs(b-a) < EPSILON) {
			System.out.println("root = " + m);
			return new double [] {m, m + EPSILON};
		}
		
		double I1[] = new double[] {a, m}, I2[] = new double[] {m, b};
		IMforGX(I1); IMforGX(I2);
		return null;
	}
	
	public static void main(String[] args) {
		double I[] = {0, 5};
		System.out.println("f(x) = (x+1)(x-1)(x-4)");
		System.out.println("g(x) = (x+1)(x-1)^2(x-4)");
		System.out.println("Given Interval of f(x) & g(x) : I = [0, 5]");
		System.out.println("Roots of f(x) : "); IMforFX(I); 
		System.out.println("Roots of g(x) : "); IMforGX(I);
	}
}
