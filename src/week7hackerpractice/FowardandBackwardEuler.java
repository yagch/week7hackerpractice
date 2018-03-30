package week7hackerpractice;

public class FowardandBackwardEuler {
	public static void main(String[] arg) {
		ForwardEuler(20, 0.5, -1);
		ForwardEuler(20, 1, -1);
		ForwardEuler(20, 2, -1);
		BackwardEuler(20, 0.5, -1);
		BackwardEuler(20, 1, -1);
		BackwardEuler(20, 2, -1);
	}
	public static double f(double t) {
		return Math.exp(-1 * t);
	}
	public static void ForwardEuler(double t, double deltat, double a) {
		double tempt = 0;
		double ft = f(0);
		while(tempt < t) {
			ft *= 1 + a * deltat;
			tempt += deltat;
			System.out.println("The ground truth f(" + tempt + ") is: " + f(tempt));
			System.out.println("The f(" + tempt + ") evaluated by Forward Euler with deltat = " + deltat + " is: " + ft);
		}
	}
	public static void BackwardEuler(double t, double deltat, double a) {
		double tempt = 0;
		double ft = f(0);
		while(tempt < t) {
			ft /= 1 -  a * deltat;
			tempt += deltat;
			System.out.println("The ground truth f(" + tempt + ") is: " + f(tempt));
			System.out.println("The f(" + tempt + ") evaluated by Backward Euler with deltat = " + deltat + " is: " + ft);
		}
	}
}
