package L5_June22;

public class Queue {

	protected int[] data;
	protected int front;
	private int size;

	public Queue(int cap) {

		this.data = new int[cap];
		this.front = 0;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void enqueue(int item) throws Exception {

		if (this.size == this.data.length) {
			throw new Exception("Queue is Full.");
		}

		int idx = (this.front + this.size) % this.data.length;

		this.data[idx] = item;
		this.size++;

	}

	public int dequeue() throws Exception {

		if (this.size == 0) {
			throw new Exception("Queue is Empty.");
		}

		int rv = this.data[this.front];
		this.data[this.front] = 0;

		this.front = (this.front + 1) % this.data.length;
		this.size--;

		return rv;

	}

	public int getFront() throws Exception {

		if (this.size == 0) {
			throw new Exception("Queue is Empty.");
		}

		int rv = this.data[this.front];
		return rv;

	}

	public void display() {

		System.out.println("---------------------");
		for (int i = 0; i < this.size; i++) {

			int idx = (i + this.front) % this.data.length;

			System.out.print(this.data[idx] + " ");
		}
		System.out.println();
		System.out.println("---------------------");
	}

}
