package L1_June12;

public class Basic {

	public static void main(String[] args) {

		int num = 286415;
		int r = 3;

		int count = 0;
		int temp = num;
		while (num != 0) {
			num = num / 10;
			count++;
		}

		r = r % count;

		if (r < 0) {
			r = r + count;
		}
		num = temp;
		int divisor = (int) Math.pow(10, r);
		int rem = num % divisor;
		int quot = num / divisor;

		int mul = (int) Math.pow(10, count - r);
		int ans = rem * mul + quot;

		System.out.println(ans);
	}

}
