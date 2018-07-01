package L10_July1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Jul-2018
 */

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();
		// put
		map.put("US", 10);
		System.out.println(map);
		map.put("India", 20);
		System.out.println(map);
		map.put("India", 40);
		System.out.println(map);

		// get
		System.out.println(map.get("UK"));
		System.out.println(map.get("India"));

		// contains key
		System.out.println(map.containsKey("India"));
		System.out.println(map.containsKey("UK"));

		// key set
		ArrayList<String> list = new ArrayList<>(map.keySet());

		System.out.println(list);

		Set<String> set = map.keySet();
		System.out.println(set);

		int[] arr1 = { 10, 10, 2, 6, 1, 8, 3, 2, 2 };
		int[] arr2 = { 30, 40, 2, 1, 2, 3 };

		System.out.println(intersection(arr1, arr2));

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		consecutiveSequence(arr);

	}

	public static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr1.length; i++) {

			int val = arr1[i];

			if (map.containsKey(val)) {
				int of = map.get(val);
				int nf = of + 1;
				map.put(val, nf);
			} else {
				map.put(val, 1);
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr2.length; i++) {

			int val = arr2[i];

			if (map.containsKey(val) && map.get(val) != 0) {

				list.add(val);
				map.put(val, map.get(val) - 1);
			}
		}

		return list;

	}

	public static void consecutiveSequence(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			int val = arr[i];

			if (map.containsKey(val - 1)) {
				map.put(val, false);
			} else {
				map.put(val, true);
			}

			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}
		}

		int maxcount = 0;
		int starting = 0;

		Set<Integer> keys = map.keySet();

		for (int key : keys) {

			if (map.get(key)) {

				int count = 0;
				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > maxcount) {
					maxcount = count;
					starting = key;
				}

			}

		}

		for (int i = 0; i < maxcount; i++) {
			System.out.println(starting + i);
		}

	}

}
