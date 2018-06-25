package L3_June17;

import L2_June15.RecursionGet;

public class RecursionPrint {

	public static void main(String[] args) {

		// ("abc", "");
		// System.out.println(Permutation("abc", ""));
		// System.out.println(BoardPath(0, 10, ""));
		// System.out.println(MazePath(0, 0, 2, 2, ""));
		// LexicographicCounting(0, 1000);

		PermutationLexicoLarger("bcad", "", false);
	}

	public static void PrintSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		PrintSS(roq, ans); // no
		PrintSS(roq, ans + ch); // yes
	}

	public static void KPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		String code = RecursionGet.getCode(ch);

		for (int i = 0; i < code.length(); i++) {
			KPC(ros, ans + code.charAt(i));
		}

	}

	public static int Permutation(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);

			return 1;
		}

		int count = 0;
		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			count += Permutation(roq, ans + ch);
		}

		return count;
	}

	public static int BoardPath(int curr, int end, String ans) {

		if (curr == end) {
			System.out.println(ans);
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += BoardPath(curr + dice, end, ans + dice);
		}

		return count;

	}

	public static int MazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}

		int ch = MazePath(cr, cc + 1, er, ec, ans + "H");
		int cv = MazePath(cr + 1, cc, er, ec, ans + "V");

		return ch + cv;
	}

	public static int PermutationDuplicates(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);

			return 1;
		}

		int count = 0;
		boolean[] strg = new boolean[256];

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);

			if (strg[ch] == false) {
				String roq = ques.substring(0, i) + ques.substring(i + 1);

				count += PermutationDuplicates(roq, ans + ch);

				strg[ch] = true;
			}

		}

		return count;

	}

	public static int PermutationLexicoLarger(String ques, String ans, boolean isLarger) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		int count = 0;
		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			if (isLarger) {
				count += PermutationLexicoLarger(roq, ans + ch, true);
			} else {

				if (ch > ques.charAt(0)) {
					count += PermutationLexicoLarger(roq, ans + ch, true);
				} else if (ch < ques.charAt(0)) {
					// no call
				} else {
					count += PermutationLexicoLarger(roq, ans + ch, false);
				}
			}

		}

		return count;
	}

	public static void LexicographicCounting(int curr, int end) {

		if (curr > end) {
			return;
		}
		System.out.println(curr);

		if (curr == 0) {
			for (int i = 1; i <= 9; i++) {
				LexicographicCounting(curr * 10 + i, end);
			}
		} else {
			for (int i = 0; i <= 9; i++) {
				LexicographicCounting(curr * 10 + i, end);
			}
		}

	}

}
