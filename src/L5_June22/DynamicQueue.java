package L5_June22;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 26, 2018
 */

public class DynamicQueue extends Queue {

	public DynamicQueue(int cap) {
		super(cap);
	}

	@Override
	public void enqueue(int item) throws Exception {

		if (this.size() == this.data.length) {

			int[] oq = this.data;
			int[] nq = new int[oq.length * 2];

			for (int i = 0; i < this.size(); i++) {

				int idx = (i + this.front) % this.data.length;
				nq[i] = oq[idx];

			}

			this.data = nq;
			this.front = 0;

		}
		
		super.enqueue(item);
	}

}
