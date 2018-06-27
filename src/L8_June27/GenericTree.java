package L8_June27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 27, 2018
 */

public class GenericTree {

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	Scanner scn;
	private Node root;

	public GenericTree(String str) {
		scn = new Scanner(str);
		this.root = takeInput(null, -1);
	}

	private Node takeInput(Node parent, int ith) {

		// prompt
		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data);
		}

		// input
		int item = scn.nextInt();

		// new node create
		Node nn = new Node();
		nn.data = item;

		// no of children
		System.out.println("No. of children for " + nn.data + " ?");
		int noc = scn.nextInt();

		// loop on children
		for (int i = 0; i < noc; i++) {
			Node child = takeInput(nn, i);
			nn.children.add(child);
		}

		// return node
		return nn;

	}

	public void display() {
		System.out.println("-----------------");
		display(this.root);
		System.out.println("-----------------");
	}

	private void display(Node node) {

		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + " ";
		}
		str += ".";

		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		int count = 0;

		for (Node child : node.children) {
			count += size(child);
		}
		return count + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		int tm = node.data;

		for (Node child : node.children) {

			int cm = max(child);
			if (cm > tm) {
				tm = cm;
			}
		}

		return tm;
	}

	public boolean find(int item) {

		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {
			boolean cf = find(child, item);

			if (cf) {
				return true;
			}
		}

		return false;
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {

		int th = -1;

		for (Node child : node.children) {
			int ch = height(child);
			th = Math.max(th, ch);
		}

		return th + 1;

	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {

		for (Node child : node.children) {
			mirror(child);
		}

		// Collections.reverse(node.children);

		int left = 0;
		int right = node.children.size() - 1;

		while (left < right) {

			Node ln = node.children.get(left);
			Node rn = node.children.get(right);

			node.children.set(left, rn);
			node.children.set(right, ln);

			left++;
			right--;
		}

	}

	public void preorder() {
		preorder(this.root);
	}

	private void preorder(Node node) {

		// self work
		System.out.print(node.data + " ");

		// child
		for (Node child : node.children) {
			preorder(child);
		}

	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node node) {

		// child
		for (Node child : node.children) {
			postorder(child);
		}

		// self work
		System.out.print(node.data + " ");

	}

	public void traversal() {
		traversal(this.root);
	}

	private void traversal(Node node) {

		System.out.print("hii " + node.data);

		for (Node child : node.children) {
			System.out.println("going towards " + child.data);
			traversal(child);
			System.out.println("coming back from " + child.data);
		}

		System.out.print("bye " + node.data);

	}

	public void levelOrderR() {
		int ht = this.height();
		for (int i = 0; i <= ht; i++) {
			printAtLevel(this.root, 0, i);
			System.out.println();
		}

	}

	private void printAtLevel(Node node, int count, int level) {

		if (count == level) {
			System.out.print(node.data + " ");
			return;
		}
		for (Node child : node.children) {
			printAtLevel(child, count + 1, level);
		}

	}

	public void levelOrderI() {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();
			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				queue.addLast(child);
			}
		}
		
		System.out.println();

	}

}
