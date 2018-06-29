package L9_June29;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class BSTClient {

	public static void main(String[] args) {

		int[] in = { 10, 20, 30, 40, 50, 60, 70 };

		BST bst = new BST(in);
		bst.display();

		System.out.println(bst.find(10));
		System.out.println(bst.max());
		bst.add(55);
		bst.display();

		bst.remove(55);
		bst.display();

		bst.remove(80);
		bst.display();
	}

}
