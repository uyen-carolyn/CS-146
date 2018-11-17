/**
 * Binary Search Tree class created to manipulate data
 */
public class BinarySearchTree {
	/**
	 * Node class created to help the Binary Search Tree class
	 */
	public static class Node {
		public int key; // contains the score of the Keyword type
		public String URL; // contains the String of the Keyword type

		public Node left, right, p; // pointers
		public int index = 0; // index initialized just in case

		/**
		 * Constructor for the Binary Search Tree class
		 * 
		 * @param URL
		 * @param score
		 */
		public Node(String URL, int score) {
			this.URL = URL;
			key = score;
		}

		/**
		 * Gets the URL of the Node
		 * 
		 * @return URL
		 */
		public String getURL() {
			return URL;
		}

		/**
		 * sets the URL as the given URL u
		 * 
		 * @param u
		 *            the given URL
		 */
		public void setURL(String u) {
			URL = u;
		}

		/**
		 * sets the key as the given key k
		 * 
		 * @param k
		 *            the given key
		 */
		public void setKey(int k) {
			key = k;
		}

		/**
		 * Gets the index of the Node
		 * 
		 * @return index
		 */
		public int getIndex() {
			return index;
		}

		/**
		 * sets the index as the given index aIndex
		 * 
		 * @param aIndex
		 *            the given index
		 */
		public void setIndex(int aIndex) {
			index = aIndex;
		}

		/**
		 * Gets the key of the Node
		 * 
		 * @return key
		 */
		public int getKey() {
			return key;
		}

		/**
		 * Returns the keyword type as a node so it can be manipulated
		 * 
		 * @param word
		 *            the given URL word
		 * @param s
		 *            the given score
		 * @return
		 */
		public static Node keywordToNode(String word, int s) {
			Node n = new Node(word, s);
			return n;
		}
	}

	private Node root; // the root of the BST

	/**
	 * Constructor for the Binary Search Tree class
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * Finds the node with the given score, or the last node searched to find it
	 * Uses recursion to search either the left or right subtree
	 * 
	 * @param x
	 *            the given node
	 * @param k
	 *            the score
	 * @return the node with the score or the last node searched before null
	 */
	public static Node Search(Node x, int k) {
		if (x == null || k == x.key) {
			return x;
		}

		if (k < x.key) {
			return Search(x.left, k);
		} else
			return Search(x.right, k);
	}

	/**
	 * Iteratively find the node with the given score, or the last node searched to
	 * find it
	 * 
	 * @param x
	 *            the given node
	 * @param k
	 *            the score
	 * @return the node with the score or the last node searched before null
	 */
	public static Node Iterative_Search(Node x, int k) {
		while (x != null && k != x.key) {
			if (k < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		return x;
	}

	/**
	 * Returns the smallest value in the BST Used to find successor and deletion
	 * 
	 * @param x
	 *            the given node
	 * @return the smallest value found
	 */
	public static Node Minimum(Node x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}

	/**
	 * Returns the largest value in the BST
	 * 
	 * @param x
	 *            the given node
	 * @return the largest value found
	 */
	public static Node Maximum(Node x) {
		while (x.right != null) {
			x = x.right;
		}
		return x;
	}

	/**
	 * Finds the smallest bigger value after the value of the node Used for deletion
	 * to ensure BST properties
	 * 
	 * @param x
	 *            the given node
	 * @return the successor y
	 */
	public static Node Successor(Node x) {
		if (x.right != null) {
			return Minimum(x.right);
		}

		Node y = x.p;

		while (y != null && x == y.right) {
			x = y;
			y = y.p;
		}

		return y;
	}

	/**
	 * Exchanges two given nodes on the BST tree Used for deletion
	 * 
	 * @param B
	 *            the Binary Search Tree
	 * @param u
	 *            the given node
	 * @param v
	 *            the given node
	 */
	public static void Transplant(BinarySearchTree B, Node u, Node v) {
		if (u.p == null) {
			B.root = v;
		} else if (u == u.p.left) {
			u.p.left = v;
		} else {
			u.p.right = v;
		}

		if (v != null) {
			v.p = u.p;
		}
	}

	/**
	 * Inserts the given node into the BST
	 * 
	 * @param B
	 *            the Binary Search Tree
	 * @param z
	 *            the given node
	 */
	public static void Insert(BinarySearchTree B, Node z) {
		Node y = null;
		Node x = B.root;

		while (x != null) { // searches for place to insert node z
			y = x;
			if (z.key < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}

		z.p = y;

		if (y == null) { // tree is empty so node z becomes root
			B.root = z;
		} else if (z.key < y.key) {
			y.left = z;
		} else {
			y.right = z;
		}

		z.setIndex(z.getIndex());
	}

	/**
	 * Deletes the given node from the BST and maintains BST properties
	 * 
	 * @param B
	 *            the Binary Search Tree
	 * @param z
	 *            the given node
	 */
	public static void Delete(BinarySearchTree B, Node z) {
		if (z.left == null) { // no left
			Transplant(B, z, z.right);
		} else if (z.right == null) { // no right
			Transplant(B, z, z.left);
		} else {
			Node y = Minimum(z.right); // find z's successor to transplant
			if (y.p != z) {
				Transplant(B, y, y.right);
				y.right = z.right;
				y.right.p = y;
			}

			Transplant(B, z, y);
			y.left = z.left;
			y.left.p = y;
		}
	}

	/**
	 * Returns the in-order of the BST given the starting node
	 * 
	 * @param x
	 *            the given node
	 * @return the list of nodes in-order
	 */
	public static void inOrder(Node x) {
		if (x != null) {
			inOrder(x.left);
			System.out.println(x.getURL() + " (" + x.key + ") ");
			inOrder(x.right);
		}
	}
}