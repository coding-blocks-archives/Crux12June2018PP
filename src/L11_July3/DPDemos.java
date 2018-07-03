package L11_July3;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Jul-2018
 */

public class DPDemos {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		int n = 3;
		// System.out.println(fibTD(n, new int[n + 1]));
		// System.out.println(fibBU(n));
		// System.out.println(fibBUSE(n));

		// System.out.println(BoardPathTD(0, n, new int[n + 1]));
		// System.out.println(BoardPathBU(n));
		// System.out.println(BoardPathBUSE(n));

		// System.out.println(MazePathTD(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(MazePathBU(n, n));
		// System.out.println(MazePathBUSE(n, n));
		// System.out.println(MazePathBUSED(n, n));
		System.out.println(LCS("abcdgh", "adefg"));
		long end = System.currentTimeMillis();

		System.out.println(end - start);
	}

	public static int fib(int n) {

		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int fnm1 = fib(n - 1);
		int fnm2 = fib(n - 2);

		int fn = fnm1 + fnm2;

		return fn;
	}

	public static int fibTD(int n, int[] strg) {

		if (n == 0 || n == 1) {
			return n;
		}

		// use
		if (strg[n] != 0) {
			return strg[n];
		}

		int fnm1 = fibTD(n - 1, strg);
		int fnm2 = fibTD(n - 2, strg);

		int fn = fnm1 + fnm2;

		// store
		strg[n] = fn;

		return fn;
	}

	public static int fibBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];

	}

	public static int fibBUSE(int n) {

		int[] strg = new int[2];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 1; i <= n - 1; i++) {
			int temp = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = temp;
		}

		return strg[1];

	}

	public static int BoardPathTD(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += BoardPathTD(curr + dice, end, strg);
		}

		strg[curr] = count;
		return count;

	}

	public static int BoardPathBU(int n) {

		int[] strg = new int[n + 6];

		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}

		return strg[0];
	}

	public static int BoardPathBUSE(int n) {

		int[] strg = new int[6];

		strg[0] = 1;

		for (int i = 1; i <= n; i++) {

			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];

			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];
			strg[0] = sum;
		}

		return strg[0];
	}

	public static int MazePathTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = MazePathTD(cr, cc + 1, er, ec, strg);
		int cv = MazePathTD(cr + 1, cc, er, ec, strg);

		strg[cr][cc] = ch + cv;

		return ch + cv;
	}

	public static int MazePathBU(int er, int ec) {

		int[][] strg = new int[er + 1][ec + 1];

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {

				if (row == er || col == ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row][col + 1] + strg[row + 1][col];
				}
			}
		}

		return strg[0][0];

	}

	public static int MazePathBUSE(int er, int ec) {

		int[] strg = new int[ec + 1];
		Arrays.fill(strg, 1);

		for (int slide = ec - 1; slide >= 0; slide--) {

			for (int col = ec; col >= 0; col--) {

				if (col == ec) {
					strg[col] = 1;
				} else {
					strg[col] = strg[col] + strg[col + 1];
				}
			}

		}

		return strg[0];
	}

	public static int MazePathBUSED(int er, int ec) {

		int[] strg = new int[ec + 1];
		Arrays.fill(strg, 1);

		int diag = 0;

		for (int slide = ec - 1; slide >= 0; slide--) {

			for (int col = ec; col >= 0; col--) {

				if (col == ec) {
					strg[col] = 1;
					diag = 1;
				} else {
					int temp = strg[col] + strg[col + 1] + diag;
					diag = strg[col];
					strg[col] = temp;
				}
			}

		}

		return strg[0];
	}

	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char c1 = s1.charAt(0);
		char c2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (c1 == c2) {
			ans = LCS(ros1, ros2) + 1;
		} else {

			int a1 = LCS(ros1, s2);
			int a2 = LCS(s1, ros2);

			ans = Math.max(a1, a2);
		}

		return ans;

	}

}
