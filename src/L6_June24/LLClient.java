package L6_June24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 24, 2018
 */

public class LLClient {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);

		// list.display();
		list.addFirst(100);
		list.addFirst(101);
		list.addFirst(102);
		list.addFirst(103);
		// list.display();
		// System.out.println(list.removeFirst());
		// System.out.println(list.removeLast());
		//
		// list.addAt(2, 45);
		// list.display();
		//
		// System.out.println(list.removeAt(3));
		// list.display();
		//
		// list.RDI();
		// list.display();
		//
		// list.RPI();
		// list.display();
		//
		// list.RPR();
		// list.display();
		// list.fold();
		list.display();

		list.kReverse(3);
		list.display();
		list.addLast(1000);
		list.display();
	}

}
