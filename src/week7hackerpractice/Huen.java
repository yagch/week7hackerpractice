package week7hackerpractice;

public class Huen {
	public static void main(String[] arg) {
		double[] x = {2.0000, 6.1946, 14.843, 33.677, 75.339};
		double[] forward = new double[4];
		double[] huen = new double[4];
		double[] itHuen = new double[4];
		double t = 0;
		for(int i = 0; i < 4; i++) {
			forward[i] = forwardEular(x[i], t);
			huen[i] = trapezoidalEular(x[i], t);
			itHuen[i] = iterHuen(x[i], t); 
			t++;
		}
		System.out.format("%8s%20s%20s%20s%20s%20s%20s%20s", "t", "Xtrue", "Xfor", "error(%)", "Xhuen", "error()%", "Xithuen", "error(%)");
		System.out.println("");
		System.out.format("%8s%20s%20s%20s%20s%20s%20s%20s", "0", "2.0000", "2.0000", " ", "2.0000", " ", "2.0000", " ");
		System.out.println("");
		for(int i = 1; i <5; i++) {
			System.out.format("%8d%20g%20g%20g%20g%20g%20g%20g", i , x[i], forward[i - 1], Math.abs((forward[i - 1] - x[i]) / x[i]) * 100, huen[i - 1], Math.abs((huen[i - 1] - x[i]) / x[i]) * 100, itHuen[i - 1], Math.abs((itHuen[i - 1] - x[i]) / x[i]) * 100);
			System.out.println("");
		}
	}
	public static double xt(double t) {
		return (4 / 1.3) * (Math.exp(0.8 * t) - Math.exp(-0.5 * t)) + 2 * Math.exp(-0.5 * t);
	}
	public static double f(double x, double t) {
		return 4 * Math.exp(0.8 * t) - 0.5 * x;
	}
	public static double forwardEular(double x, double t) {
		return x + f(x, t);
	}
	public static double trapezoidalEular(double x, double t) {
		return 0.2 * (3 * x + 8 * Math.exp(0.8 * t) + 8 * Math.exp(0.8 * (t + 1)));
	}
	public static double iterHuen(double x, double t) {
		double x1 = trapezoidalEular(x, t);
		double x1j = x + 0.5 * (f(x, t) + f(x1, t + 1));
		while(Math.abs((x1 - x1j) / x1j) >= Math.pow(10, -3)) {
	        double helper = x1j;
			x1j = x + 0.5 * (f(x, t) + f(x1, t + 1));
			x1 = helper;
		}
		return x1j;
	}
}
