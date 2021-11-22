package me.smc;

public class Treap {
	Node root;

	public Treap(Node root) {
		this.root = root;
	}

	Node insertNode(Node root, Node n) {
		if (root == null) return n;

		if (root.getPriority() > n.getPriority())
		{
			if (root.getKey() < n.getKey()) root.setRight(insertNode(root.getRight(), n));
			else root.setLeft(insertNode(root.getLeft(), n));
			return root;
		}

		NodePair np = split(root, n.getKey());
		n.setLeft(np.first);
		n.setRight(np.second);

		return n;
	}

	NodePair split(Node root, int key) {
		if (root == null) return new NodePair(null, null);
		if (root.getKey() < key)
		{
			NodePair np = split(root.getRight(), key);
			return new NodePair(root, np.second);
		}

		NodePair np = split(root.getLeft(), key);
		return new NodePair(np.first, root);
	}



}
