package L7_June26;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 26, 2018
 */

public class C extends P {

	int d = 20;
	int d2 = 200;

	public void fun() {
		System.out.println("In C Fun");
	}

	public void fun2() {
		System.out.println("In C Fun 2");
	}

	@Override
	public String toString() {
		return d + " " + d2 + " in class c";

	}

}
