package L4_June19;

public class StackClient {

	public static void main(String[] args) throws Exception {

		Stack s = new DynamicStack(5);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.push(70);
		s.display();
		System.out.println(s.pop());
		s.display();

		// int[] prices = { 10, 5, 13, 17, 12, 9, 15, 6, 11 };
		// // ans : 1 1 3 4 1 1 3 1 2
		// int[] span = stockSpan(prices);
		// for (int val : span) {
		// System.out.print(val + " ");
		// }

		// int[] arr = { 100, 5, 2, 20, 7, 3, 9 };
		// nextGreater(arr);
	}

	public static void displayReverse(Stack s) throws Exception {

		if (s.isEmpty()) {
			return;
		}
		int temp = s.pop();
		displayReverse(s);
		System.out.println(temp);

	}

	public static void actualReverse(Stack s, Stack helper) throws Exception {

		if (s.isEmpty()) {

			if (helper.isEmpty()) {
				return;
			}

			int temph = helper.pop();
			actualReverse(s, helper);
			s.push(temph);

			return;
		}

		int temp = s.pop();
		helper.push(temp);
		actualReverse(s, helper);

	}

	public static int[] stockSpan(int[] prices) throws Exception {

		int[] span = new int[prices.length];

		Stack s = new Stack(100);

		s.push(0);
		span[0] = 1;

		for (int i = 1; i < prices.length; i++) {

			while (!s.isEmpty() && prices[s.peek()] < prices[i]) {
				s.pop();
			}

			if (s.isEmpty()) {
				span[i] = i + 1;
			} else {
				span[i] = i - s.peek();
			}

			s.push(i);
		}

		return span;

	}

	public static void nextGreater(int[] arr) throws Exception {

		Stack s = new Stack(100);

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && s.peek() < arr[i]) {
				int temp = s.pop();

				System.out.println(temp + " -> " + arr[i]);
			}

			s.push(arr[i]);

		}

		while (!s.isEmpty()) {

			int temp = s.pop();
			System.out.println(temp + " -> " + (-1));
		}
	}
}
