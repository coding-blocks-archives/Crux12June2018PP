package L10_July1;

import java.util.ArrayList;
import L10_July1.Generics.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Jul-2018
 */

public class HeapClient {

	public static void main(String[] args) {

		Heap heap = new Heap();
		heap.insert(10);
		heap.insert(20);
		heap.insert(5);
		heap.insert(8);
		heap.insert(7);

		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());

		Car[] cars = new Car[5];
		cars[0] = new Car(100, 100, "grey");
		cars[1] = new Car(300, 600, "red");
		cars[2] = new Car(700, 400, "black");
		cars[3] = new Car(200, 200, "white");
		cars[4] = new Car(900, 1000, "Black");

		HeapGeneric<Car> heapg = new HeapGeneric<>();
		heapg.insert(cars[0]);
		heapg.insert(cars[1]);
		heapg.insert(cars[2]);
		heapg.insert(cars[3]);
		heapg.insert(cars[4]);

		System.out.println(heapg.remove());
		System.out.println(heapg.remove());
		System.out.println(heapg.remove());
		System.out.println(heapg.remove());
		System.out.println(heapg.remove());

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(2);
		list1.add(3);
		list1.add(5);
		list1.add(10);
		list1.add(15);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(15);
		list2.add(100);
		list2.add(200);
		list2.add(300);
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(6);
		list3.add(8);
		list3.add(9);
		list3.add(10);

		lists.add(list1);
		lists.add(list2);
		lists.add(list3);

		System.out.println(mergeKSortedLists(lists));

		ArrayList<Integer> list = new ArrayList<>();

		list.add(10);
		list.add(100);
		list.add(20);
		list.add(30);
		list.add(5);

		System.out.println(kLargest(list, 3));
	}

	private static class Pair implements Comparable<Pair> {
		int data;
		int itemno;
		int listno;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}

	}

	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {

		ArrayList<Integer> ans = new ArrayList<>();
		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < lists.size(); i++) {
			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.itemno = 0;
			np.listno = i;

			heap.insert(np);
		}

		while (heap.size() != 0) {

			Pair rp = heap.remove();
			ans.add(rp.data);

			rp.itemno++;
			if (rp.itemno < lists.get(rp.listno).size()) {
				rp.data = lists.get(rp.listno).get(rp.itemno);
				heap.insert(rp);
			}

		}

		return ans;
	}

	public static ArrayList<Integer> kLargest(ArrayList<Integer> list, int k) {

		Heap heap = new Heap();

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			heap.insert(list.get(i));
		}

		for (int i = k; i < list.size(); i++) {

			int fv = heap.get();

			if (list.get(i) > fv) {
				heap.remove();
				heap.insert(list.get(i));
			}
		}

		while (heap.size() != 0) {
			ans.add(heap.remove());
		}
		return ans;
	}

}
