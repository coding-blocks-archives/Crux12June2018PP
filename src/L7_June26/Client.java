package L7_June26;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 26, 2018
 */

public class Client {

	public static void main(String[] args) {

		ArrayList<String> list;
		C c1 = new C();
		System.out.println(c1);

		// case 1
		P obj1 = new P();
		System.out.println(obj1.d);
		System.out.println(obj1.d1);
		obj1.fun();
		obj1.fun1();

		// case 2
		P obj2 = new C();
		System.out.println(obj2.d); // 10
		System.out.println(((C) obj2).d); // 20
		System.out.println(obj2.d1); // 100
		System.out.println(((C) obj2).d2); // 200

		obj2.fun();
		((P) obj2).fun();
		obj2.fun1();
		((C) obj2).fun2();

		// case 3
		// C obj3 = new P() ;

		// case 4
		C obj4 = new C();
		System.out.println(obj4.d);
		System.out.println(obj4.d1);
		System.out.println(obj4.d2);

		obj4.fun();
		obj4.fun1();
		obj4.fun2();
	}

}
