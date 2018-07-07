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
		// int n = 60;

		// System.out.println(FibTD(n, new int[n + 1]));
		// System.out.println(FibBU(n));
		// System.out.println(FibBUSE(n));
		//
		// System.out.println(BoardPathTD(0, n, new int[n + 1]));
		// System.out.println(BoardPathBU(n));
		// System.out.println(BoardPathBUSE(n));
		//
		// System.out.println(MazePathTD(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(MazePathBU(n, n));
		// System.out.println(MazePathBUSE(n, n));
		// System.out.println(MazePathBUSED(n, n));
		// System.out.println(LCSBU("abcd", "agcfd"));
		// System.out.println(EditDistanceBU("abcd", "agcfd"));

		// int[] arr = new int[n];
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = i + 1;
		// }
		//
		// System.out.println(MCM(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));
		// System.out.println(MCMBU(arr));

		// int[] prices = { 2, 3, 5, 1, 4 };
		// System.out.println(WineProblem(prices, 0, prices.length - 1, 1));
		// System.out.println(WineProblemBU(prices));

		// int[] prices = { 1, 4, 5, 7 };
		// int[] weight = { 1, 3, 4, 5 };
		// int cap = 7;
		// System.out.println(Knapsack(prices, weight, cap, 0, new int[prices.length +
		// 1][cap + 1]));
		// System.out.println(KnapsackBU(prices, weight, cap));

		// int[] prices = { 0, 3, 5, 8, 9, 10, 17, 17, 20 };
		// int n = prices.length;
		// System.out.println(RodCut(prices, n - 1, new int[n]));
		// System.out.println(RodCutBU(prices, n - 1));

		// int[] arr = { 10, 20, 30, 40, 50 };
		// System.out.println(MixturesTD(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));
		//
		// System.out.println(MixturesBU(arr));

		String str = "ababbbabbababacbhzxgcujsdhcusgdiydhuiyrhuivchdui";
		System.out.println(PalindromePartition(str, 0, str.length() - 1, new int[str.length()][str.length()]));
		long end = System.currentTimeMillis();
		System.out.println("Duration: " + (end - start) + " ms");

	}

	public static int Fib(int n) {

		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int fnm1 = Fib(n - 1);
		int fnm2 = Fib(n - 2);

		int fn = fnm1 + fnm2;

		return fn;
	}

	public static int FibTD(int n, int[] strg) {

		if (n == 0 || n == 1) {
			return n;
		}

		// use
		if (strg[n] != 0) {
			return strg[n];
		}

		int fnm1 = FibTD(n - 1, strg);
		int fnm2 = FibTD(n - 2, strg);

		int fn = fnm1 + fnm2;

		// store
		strg[n] = fn;

		return fn;
	}

	public static int FibBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];

	}

	public static int FibBUSE(int n) {

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

	public static int LCSBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {

			for (int col = s2.length() - 1; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = 1 + strg[row + 1][col + 1];
				} else {
					strg[row][col] = Math.max(strg[row][col + 1], strg[row + 1][col]);
				}
			}
		}

		return strg[0][0];

	}

	public static int EditDistanceTD(String s1, String s2, int[][] strg) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		if (strg[s1.length()][s2.length()] != 0) {
			return strg[s1.length()][s2.length()];
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EditDistanceTD(ros1, ros2, strg);
		} else {

			int ci = EditDistanceTD(ros1, s2, strg);
			int cd = EditDistanceTD(s1, ros2, strg);
			int cr = EditDistanceTD(ros1, ros2, strg);

			ans = Math.min(cr, Math.min(ci, cd)) + 1;

		}

		strg[s1.length()][s2.length()] = ans;
		return ans;

	}

	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {

			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
					continue;
				}
				if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
					continue;
				}

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {

					int ci = strg[row + 1][col];
					int cd = strg[row][col + 1];
					int cr = strg[row + 1][col + 1];

					strg[row][col] = Math.min(cr, Math.min(ci, cd)) + 1;
				}

			}
		}

		return strg[0][0];
	}

	public static int MCM(int[] arr, int si, int ei, int[][] strg) {

		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCM(arr, si, k, strg); // si * k
			int sp = MCM(arr, k, ei, strg); // k * ei
			int sw = arr[si] * arr[k] * arr[ei];

			int sum = fp + sp + sw;

			if (sum < min) {
				min = sum;
			}
		}

		strg[si][ei] = min;
		return min;

	}

	public static int MCMBU(int[] arr) {

		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 2; slide++) {

			for (int si = 0; si <= n - slide - 2; si++) {

				int ei = si + slide + 1;

				// si, ei
				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k <= ei - 1; k++) {

					int fp = strg[si][k]; // si * k
					int sp = strg[k][ei]; // k * ei
					int sw = arr[si] * arr[k] * arr[ei];

					int sum = fp + sp + sw;

					if (sum < min) {
						min = sum;
					}
				}

				strg[si][ei] = min;

			}

		}

		return strg[0][n - 1];

	}

	public static int WineProblem(int[] prices, int si, int ei, int yr) {

		if (si == ei) {
			return prices[si] * yr;
		}

		int fw = WineProblem(prices, si + 1, ei, yr + 1) + (prices[si] * yr);
		int lw = WineProblem(prices, si, ei - 1, yr + 1) + (prices[ei] * yr);

		int res = Math.max(fw, lw);

		return res;

	}

	public static int WineProblemTD(int[] prices, int si, int ei, int[][] strg) {

		int yr = prices.length - (ei - si);

		if (si == ei) {
			return prices[si] * yr;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int fw = WineProblemTD(prices, si + 1, ei, strg) + (prices[si] * yr);
		int lw = WineProblemTD(prices, si, ei - 1, strg) + (prices[ei] * yr);

		int res = Math.max(fw, lw);

		strg[si][ei] = res;
		return res;

	}

	public static int WineProblemBU(int[] prices) {

		int n = prices.length;

		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n; slide++) {

			for (int si = 0; si <= n - slide; si++) {

				int ei = si + slide - 1;

				int yr = n - (ei - si);

				if (si == ei) {
					strg[si][ei] = prices[si] * yr;
				} else {

					int fw = strg[si + 1][ei] + (prices[si] * yr);
					int lw = strg[si][ei - 1] + (prices[ei] * yr);

					int res = Math.max(fw, lw);

					strg[si][ei] = res;

				}

			}

		}

		return strg[0][n - 1];

	}

	public static int Knapsack(int[] prices, int[] weight, int cap, int vidx, int[][] strg) {

		if (vidx == weight.length) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		int include = 0;

		if (cap >= weight[vidx])
			include = Knapsack(prices, weight, cap - weight[vidx], vidx + 1, strg) + prices[vidx];

		int exclude = Knapsack(prices, weight, cap, vidx + 1, strg);

		int ans = Math.max(include, exclude);

		strg[vidx][cap] = ans;
		return ans;
	}

	public static int KnapsackBU(int[] prices, int[] weight, int cap) {

		int nr = prices.length + 1;
		int nc = cap + 1;

		int[][] strg = new int[nr][nc];

		for (int row = 0; row < nr; row++) {

			for (int col = 0; col < nc; col++) {

				if (row == 0 || col == 0) {
					strg[row][col] = 0;
				} else {

					int include = 0;

					if (col >= weight[row - 1]) {
						include = prices[row - 1] + strg[row - 1][col - weight[row - 1]];
					}

					int exclude = strg[row - 1][col];

					strg[row][col] = Math.max(include, exclude);

				}
			}
		}

		return strg[nr - 1][nc - 1];

	}

	public static int RodCut(int[] prices, int n, int[] strg) {

		if (n == 0) {
			return 0;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		int left = 1;
		int right = n - 1;

		int max = prices[n]; // sell n length ros as it is

		while (left <= right) {

			int fh = RodCut(prices, left, strg);
			int sh = RodCut(prices, right, strg);

			int sum = fh + sh;

			if (sum > max) {
				max = sum;
			}
			left++;
			right--;
		}

		strg[n] = max;
		return max;

	}

	public static int RodCutBU(int[] prices, int n) {

		int[] strg = new int[n + 1];

		for (int i = 1; i <= n; i++) {

			strg[i] = prices[i];

			int left = 1;
			int right = i - 1;

			while (left <= right) {

				int fh = strg[left];
				int sh = strg[right];

				int sum = fh + sh;

				if (sum > strg[i]) {
					strg[i] = sum;
				}

				left++;
				right--;
			}

		}

		return strg[n];

	}

	public static int color(int[] arr, int si, int ei) {

		int sum = 0;

		for (int i = si; i <= ei; i++) {
			sum += arr[i];
		}

		return sum % 100;
	}

	public static int MixturesTD(int[] arr, int si, int ei, int[][] strg) {

		if (si == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int fp = MixturesTD(arr, si, k, strg);
			int sp = MixturesTD(arr, k + 1, ei, strg);
			int sw = color(arr, si, k) * color(arr, k + 1, ei);

			int sum = fp + sp + sw;

			if (sum < min) {
				min = sum;
			}
		}

		strg[si][ei] = min;
		return min;

	}

	public static int MixturesBU(int[] arr) {

		int n = arr.length;
		int[][] strg = new int[arr.length][arr.length];

		for (int slide = 1; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				int min = Integer.MAX_VALUE;

				for (int k = si; k <= ei - 1; k++) {

					int fp = strg[si][k];
					int sp = strg[k + 1][ei];
					int sw = color(arr, si, k) * color(arr, k + 1, ei);

					int sum = fp + sp + sw;

					if (sum < min) {
						min = sum;
					}
				}

				strg[si][ei] = min;

			}

		}

		return strg[0][n - 1];

	}

	public static boolean isPalindrome(String str, int si, int ei) {

		int left = si;
		int right = ei;

		while (left < right) {

			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;

	}

	public static int PalindromePartition(String str, int si, int ei, int[][] strg) {

		if (isPalindrome(str, si, ei)) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int fh = PalindromePartition(str, si, k, strg);
			int sh = PalindromePartition(str, k + 1, ei, strg);

			int ans = fh + sh + 1;

			if (ans < min) {
				min = ans;
			}
		}

		strg[si][ei] = min;
		return min;

	}

}
