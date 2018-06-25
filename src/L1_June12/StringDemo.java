package L1_June12;

import java.util.ArrayList;
import java.util.Scanner;

public class StringDemo {

	public static void main(String[] args) {

		String str = "hello"; // 2k

		System.out.println(10 + 20 + "hello" + 10 + 20);

		// String s = "";
		// for (int i = 1; i <= 100000; i++) {
		// s += i;
		// }

		StringBuilder sb = new StringBuilder("hello");
		sb.append("bye");
		System.out.println(sb);
		sb.length();
		sb.insert(2, "abc");

		Scanner scn = new Scanner(System.in);
		// String str1 = scn.nextLine();

		String ss = str.substring(3, 2);

		String s1 = "hello";
		String s2 = "hello";

		String s3 = new String("hello");

		System.out.println(s1 == s3);
		System.out.println(s1.equals(s3));
		
		ArrayList<Integer> list = new ArrayList<>() ;
	}

}
