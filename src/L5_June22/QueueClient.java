package L5_June22;

import java.util.LinkedList;

public class QueueClient {

	public static void main(String[] args) throws Exception {

		Queue q = new Queue(5);

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.display();
		System.out.println(q.dequeue());
		q.enqueue(60);
		q.display();
	}

	public static void max(int[] arr, int k) {

		LinkedList<Integer> queue = new LinkedList<>();

		int i;

		for (i = 0; i < k; i++) {

		}
		
		for (; i < arr.length; i++) {
			int val = arr[i];

			while ((!queue.isEmpty()) && queue.getFirst() <= i - k)
				queue.removeFirst();

			while (!queue.isEmpty() && val >= queue.getLast()) {
				queue.removeLast();
			}

			queue.addLast(i);

			System.out.println(queue.getFirst());
		}

	}

}
