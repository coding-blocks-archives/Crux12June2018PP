package L2_June15;

import java.util.ArrayList;

public class RecursionGet {

	public static void main(String[] args) {
		//
		// ArrayList<String> list = new ArrayList<>();
		//
		// list.add("abc");
		// list.add("def");
		// for (String val : list) {
		// System.out.println(val);
		// val = "xyz";
		// }
		//
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i));
		// list.set(i, "qwe");
		// }
		//
		// String s = "";
		// ArrayList<String> list = new ArrayList<>();
		// System.out.println(list.size());
		// list.add(s);
		// System.out.println(list.get(0).length());
		// System.out.println(getSS("abc"));
		// System.out.println(getBoardPath(0, 10));

		// System.out.println(coinToss(3));

		System.out.println(mazePath(0, 0, 2, 2));
	}

	public static ArrayList<String> getSS(String str) {

		if (str.length() == 0) {

			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		// smaller prob
		ArrayList<String> rr = getSS(ros);
		ArrayList<String> mr = new ArrayList<>();

		// self work
		for (String rrs : rr) {
			mr.add(rrs); // ch says no
			mr.add(ch + rrs); // ch says yes

		}

		return mr;
	}

	public static String getCode(char ch) {

		if (ch == '1') {
			return "abc";
		} else if (ch == '2') {
			return "def";
		} else if (ch == '3') {
			return "ghi";
		} else if (ch == '4') {
			return "jk";
		} else if (ch == '5') {
			return "lmno";
		} else if (ch == '6') {
			return "pqrs";
		} else if (ch == '7') {
			return "tu";
		} else if (ch == '8') {
			return "vw";
		} else if (ch == '9') {
			return "xyz";
		} else if (ch == '0') {
			return "#$";
		} else {
			return "";
		}
	}

	public static ArrayList<String> getKPC(String str) {

		if (str.length() == 0) {

			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getKPC(ros);

		String code = getCode(ch);
		ArrayList<String> mr = new ArrayList<>();

		for (int i = 0; i < code.length(); i++) {

			for (String rrs : rr) {
				mr.add(code.charAt(i) + rrs);
			}
		}

		return mr;
	}

	public static ArrayList<String> getPermutation(String str) {

		if (str.length() == 0) {

			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getPermutation(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {

			for (int i = 0; i <= rrs.length(); i++) {
				mr.add(rrs.substring(0, i) + ch + rrs.substring(i));
			}

		}

		return mr;
	}

	public static ArrayList<String> getBoardPath(int curr, int end) {

		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		
		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> rr = getBoardPath(curr + dice, end);

			for (String rrs : rr) {
				mr.add(dice + rrs);
			}

		}

		return mr;

	}

	public static ArrayList<String> coinToss(int n) {

		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> rr = coinToss(n - 1);

		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {
			mr.add("H" + rrs);
			mr.add("T" + rrs);
		}

		return mr;

	}

	public static ArrayList<String> mazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = mazePath(cr, cc + 1, er, ec);

		for (String rrhs : rrh) {
			mr.add("H" + rrhs);
		}

		ArrayList<String> rrv = mazePath(cr + 1, cc, er, ec);

		for (String rrvs : rrv) {
			mr.add("V" + rrvs);
		}

		return mr;

	}

}
