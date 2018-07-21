package Doubts;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Jul-2018
 */

public class Webinar1 {

	public static void main(String[] args) {

		System.out.println(LCS("abc", "def", 3, new int[10][10][10]));

		// uglyNumbers(50);

		// nknights(0, 0, "", 0, new boolean[4][4]);

		System.out.println(wildcardMatching("abcdef", "?b*e"));
	}

	public static int LCS(String s1, String s2, int k, int[][][] strg) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		if (strg[s1.length()][s2.length()][k] != 0) {
			return strg[s1.length()][s2.length()][k];
		}

		char c1 = s1.charAt(0);
		char c2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		// o1
		int a1 = LCS(ros1, s2, k, strg);
		int a2 = LCS(s1, ros2, k, strg);

		int ans1 = Math.max(a1, a2);

		// o2 -> k consume
		int ans2 = 0;

		if (k >= 1)
			ans2 = 1 + LCS(ros1, ros2, k - 1, strg);

		// o3 elements equal
		int ans3 = 0;
		if (c1 == c2) {
			ans3 = LCS(ros1, ros2, k, strg) + 1;
		}

		int ans = Math.max(ans1, Math.max(ans2, ans3));

		strg[s1.length()][s2.length()][k] = ans;
		return ans;

	}

	public static int LCSBU3Strings(String s1, String s2, String s3) {

		int[][][] strg = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];

		for (int i = s1.length() - 1; i >= 0; i--) {

			for (int j = s2.length() - 1; j >= 0; j--) {

				for (int k = s3.length() - 1; k >= 0; k--) {
					if ((s1.charAt(i) == s2.charAt(j)) && (s2.charAt(j) == s3.charAt(k))) {
						strg[i][j][k] = 1 + strg[i + 1][j + 1][k + 1];
					} else {
						strg[i][j][k] = Math.max(strg[i][j][k + 1], Math.max(strg[i + 1][j][k], strg[i][j + 1][k]));
					}
				}
			}
		}

		return strg[0][0][0];

	}

	public static void uglyNumbers(int n) {

		int[] arr = new int[n];

		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		int num2 = 2;
		int num3 = 3;
		int num5 = 5;

		arr[0] = 1;

		for (int i = 1; i < arr.length; i++) {

			int min = Math.min(num2, Math.min(num3, num5));

			arr[i] = min;

			if (num2 == min) {
				i2 = i2 + 1;
				num2 = arr[i2] * 2;
			}

			if (num3 == min) {
				i3 = i3 + 1;
				num3 = arr[i3] * 3;
			}

			if (num5 == min) {
				i5 = i5 + 1;
				num5 = arr[i5] * 5;
			}

		}

		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	public static void nknights(int row, int col, String ans, int kpsf, boolean[][] board) {

		if (kpsf == board.length) {
			System.out.println(ans);
			return;
		}

		if (row == board.length) {
			return;
		}
		
		if (col == board[0].length) {
			nknights(row + 1, 0, ans, kpsf, board);
			return;
		}

		board[row][col] = true;
		nknights(row, col + 1, ans + "{" + row + "-" + col + "}", kpsf + 1, board);

		board[row][col] = false;
		nknights(row, col + 1, ans, kpsf, board);

	}

	public static boolean wildcardMatching(String src, String pattern) {

		if (src.length() == 0 && pattern.length() == 0) {
			return true;
		}

		if (src.length() != 0 && pattern.length() == 0) {
			return false;
		}

		if (src.length() == 0 && pattern.length() != 0) {
			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*') {
					return false;
				}
			}

			return true;
		}

		char chs = src.charAt(0);
		String ross = src.substring(1);

		char chp = pattern.charAt(0);
		String rosp = pattern.substring(1);

		if (chp == '*') {

			boolean c1 = wildcardMatching(src, rosp);
			boolean c2 = wildcardMatching(ross, pattern);

			return c1 || c2;

		} else if (chp == '?' || chs == chp) {
			return wildcardMatching(ross, rosp);
		} else {
			return false;
		}
	}

}
