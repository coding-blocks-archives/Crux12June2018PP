package L10_July1.Generics;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Jul-2018
 */

public class GenericDemo {

	public static void main(String[] args) {

		Integer[] arr = { 10, 20, 30, 40 };

		display(arr);
		String[] arrs = { "a", "b", "c" };
		display(arrs);

		Car[] cars = new Car[5];
		cars[0] = new Car(100, 100, "grey");
		cars[1] = new Car(300, 600, "red");
		cars[2] = new Car(700, 400, "black");
		cars[3] = new Car(200, 200, "white");
		cars[4] = new Car(900, 1000, "Black");

		display(cars);

		bubbleSort(cars);
		display(cars);

		Pair<String> pair = new Pair<>();

		Pair2<String, Integer> pair2 = new Pair2<>();
		Pair2<Pair2<String, Double>, Pair2<String, Integer>> pair3 = new Pair2<>();
		pair3.one = new Pair2<>();
		System.out.println(pair3.one.one);
	}

	public static <T> void display(T[] arr) {
		for (T val : arr) {
			System.out.println(val);
		}

	}

	public static void display(Integer[] arr) {
		for (int val : arr) {
			System.out.println(val);
		}

	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		for (int counter = 0; counter < arr.length - 1; counter++) {

			for (int j = 0; j < arr.length - 1 - counter; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}
		}
	}

}
