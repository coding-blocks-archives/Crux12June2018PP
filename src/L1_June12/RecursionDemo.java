package L1_June12;

public class RecursionDemo {

	public static void main(String[] args) {

		// System.out.println(power(5, 3));
		System.out.println(fib(8));
	}

	public static int factorial(int n) {

		if (n == 1) {
			return 1;
		}

		int fnm1 = factorial(n - 1);
		int fn = fnm1 * n;

		return fn;
	}

	public static int power(int x, int n) {

		// base case
		if (n == 0) {
			return 1;
		}

		// smaller problem
		int pnm1 = power(x, n - 1);

		// self work
		int pn = pnm1 * x;
		return pn;
	}

	public static int fib(int n) {

		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int fnm1 = fib(n - 1);
		int fnm2 = fib(n - 2);

		int fn = fnm1 + fnm2;

		return fn;
	}
	
	

}
