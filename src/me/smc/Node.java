package me.smc;

public class Node {
	private int priority;
	private int key;
	private int size;
	private Node left = null;
	private Node right = null;

	public Node(int key) {
		this.key = key;
		this.priority = (int)Math.random();
		this.left = null;
		this.right = null;
		this.size = 1;
	}

	int calcSize() {
		int leftsize = left != null ? this.left.calcSize() : 0;
		int rightsize = right != null ? this.right.calcSize() : 0;
		this.size = leftsize + rightsize + 1;
		return this.size;
	}

	void setRight(Node right) {
		this.right = right;
		calcSize();
	}

	void setLeft(Node left) {
		this.left = left;
		calcSize();
	}

	public int getKey() {
		return key;
	}

	public int getPriority() {
		return priority;
	}

	public int getSize() {
		return size;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}
}
