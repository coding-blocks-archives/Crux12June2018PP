package L8_June27;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 27, 2018
 */

public class GTClient {

	public static void main(String[] args) {

		// 10 3 20 2 50 0 60 0 30 0 40 1 70 0
		// 10 3 20 2 50 0 60 2 70 0 80 2 120 0 130 0 30 0 40 1 90 2 100 0 110 2 140 0 150 0
		String str = "10 3 20 2 50 0 60 2 70 0 80 2 120 0 130 0 30 0 40 1 90 2 100 0 110 2 140 0 150 0";
		
		GenericTree gt = new GenericTree(str);
		gt.display();

		// System.out.println(gt.height());
		// System.out.println(gt.max());
		// System.out.println(gt.size());
		// gt.mirror();
		gt.display();
		gt.preorder();
		System.out.println();
		gt.postorder();
		System.out.println();
		System.out.println();
		gt.levelOrderR();
		gt.levelOrderI();
	}

}
