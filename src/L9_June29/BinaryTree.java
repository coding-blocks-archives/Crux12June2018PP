package L9_June29;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 27, 2018
 */

public class BinaryTree {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	Scanner scn;

	private Node root;

	public BinaryTree(String str) {
		scn = new Scanner(str);
		this.root = takeInput(null, false);
	}

	public BinaryTree(int[] pre, int[] in) {

		this.root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (plo > phi) {
			return null;
		}

		Node nn = new Node();
		nn.data = pre[plo];

		int si = -1;
		for (int i = ilo; i <= ihi; i++) {
			if (in[i] == pre[plo]) {
				si = i;
				break;
			}
		}

		int nel = si - ilo;

		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);

		return nn;

	}

	private Node takeInput(Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {

			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		int item = scn.nextInt();
		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + " has left child ?");
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			nn.left = takeInput(nn, true);
		}

		System.out.println(nn.data + " has right child ?");
		boolean hrc = scn.nextBoolean();

		if (hrc) {
			nn.right = takeInput(nn, false);
		}

		return nn;
	}

	public void display() {

		System.out.println("-------------");
		display(this.root);
		System.out.println("-------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}
		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lm = max(node.left);
		int rm = max(node.right);

		int ans = Math.max(node.data, Math.max(lm, rm));

		return ans;
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		boolean lf = find(node.left, item);
		boolean rf = find(node.right, item);

		return lf || rf;
	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;

	}

	public int diameter() {
		return this.diameter(this.root);
	}

	private int diameter(Node node) {

		if (node == null) {
			return 0;
		}

		int ld = diameter(node.left);
		int rd = diameter(node.right);

		int sp = ht(node.left) + ht(node.right) + 2;

		return Math.max(sp, Math.max(ld, rd));

	}

	private class Pair {

		int height;
		int diameter;
	}

	public int diameter2() {
		return diameter2(root).diameter;
	}

	private Pair diameter2(Node node) {

		if (node == null) {
			Pair bp = new Pair();
			bp.height = -1;
			bp.diameter = 0;
			return bp;
		}

		Pair lp = diameter2(node.left);
		Pair rp = diameter2(node.right);

		Pair sp = new Pair();
		sp.height = Math.max(lp.height, rp.height) + 1;

		int lpd = lp.diameter;
		int rpd = rp.diameter;
		int spd = lp.height + rp.height + 2;

		sp.diameter = Math.max(spd, Math.max(lpd, rpd));

		return sp;
	}

	private class BPair {
		boolean isBalanced;
		int height;
	}

	public boolean balanced() {
		return this.balanced(root).isBalanced;
	}

	private BPair balanced(Node node) {

		if (node == null) {
			BPair bp = new BPair();
			bp.height = -1;
			bp.isBalanced = true;
			return bp;
		}
		BPair lp = balanced(node.left);
		BPair rp = balanced(node.right);

		BPair sp = new BPair();
		sp.height = Math.max(lp.height, rp.height) + 1;

		int bf = lp.height - rp.height;

		if (lp.isBalanced && rp.isBalanced && bf >= -1 && bf <= 1) {
			sp.isBalanced = true;
		} else {
			sp.isBalanced = false;
		}

		return sp;
	}

}
