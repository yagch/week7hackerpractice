package week7hackerpractice;

public class BackwardandTrapezoidalEuler {
	public static void main(String[] arg) {
		System.out.println("When deltat is 0.5");
		double[] trape1 = TrapezoidalEuler(20, 0.5, -1);
		double[] back1 = BackwardEuler(20, 0.5, -1);
		System.out.format("%8s%32s%32s", "t", "BackwardError", "TrapezoidalError");
		double t = 0;
		for(int i = 0; i < 40; i++) {
			System.out.println("");
			t += 0.5;
			System.out.format("%8g%32g%32g", t, Math.abs(back1[i] - x(t)), Math.abs(trape1[i] - x(t)));
		}
		System.out.println("");
		System.out.println("");
		System.out.println("When deltat is 1");
		double[] trape2 = TrapezoidalEuler(20, 1, -1);
		double[] bac2k = BackwardEuler(20, 1, -1);
		System.out.format("%8s%32s%32s", "t", "BackwardError", "TrapezoidalError");
		t = 0;
		for(int i = 0; i < 20; i++) {
			System.out.println("");
			t += 1;
			System.out.format("%8g%32g%32g", t, Math.abs(bac2k[i] - x(t)), Math.abs(trape2[i] - x(t)));
		}
	}
	public static double x(double t) {
		return Math.exp(-1 * t);
	}
	public static double[] TrapezoidalEuler(double t, double deltat, double a) {
		double tempt = 0;
		double xt = x(0);
		double res[] = new double[(int) (t / deltat)];
        int i = 0;
		while(tempt < t) {
			xt *= (2 + a * deltat) / (2 - a * deltat);
			tempt += deltat;
			res[i] = xt;
			i++;
			}
		return res;
	}
	public static double[] BackwardEuler(double t, double deltat, double a) {
		double tempt = 0;
		double xt = x(0);
		double res[] = new double[(int) (t / deltat)];
        int i = 0;
		while(tempt < t) {
			xt /= 1 -  a * deltat;
			tempt += deltat;
			res[i] = xt;
			i++;
		}
		return res;
	}
}
