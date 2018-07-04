package Assignments;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Jul-2018
 */

public class CodesOfString {

	public static void main(String[] args) {
		codes("1123", "");
	}

	public static void codes(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		String ch1 = ques.substring(0, 1);
		String ros1 = ques.substring(1);
		codes(ros1, ans + map(ch1));

		if (ques.length() > 1) {
			int intval = Integer.valueOf(ques.substring(0, 2));
			if (intval <= 26) {
				String ch2 = ques.substring(0, 2);
				String ros2 = ques.substring(2);
				codes(ros2, ans + map(ch2));
			}
		}

	}

	public static char map(String str) {
		int val = Integer.valueOf(str);
		return (char) (val + 96);
	}

}
