import java.awt.Color;

public class RedBlackTree {
	/**
	 * Node class created to help the Red Black Tree class
	 */
	public static class Node {
		public int key; // contains the score of the Keyword type
		public String URL; // contains the String of the Keyword type

		public Node left, right, p; // pointers
		public int index = 0; // index initialized just in case

		public int rank = 0;

		public Color c;

		/**
		 * Constructor for the Red Black Tree class
		 * 
		 * @param URL
		 * @param score
		 */
		public Node(String URL, int score) {
			this.URL = URL;
			key = score;
			c = Color.RED; // defaults new node as RED node
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
		public static Node linkToNode(String word, int s) {
			Node n = new Node(word, s);
			return n;
		}

		/**
		 * Gets the rank of the Link type
		 * 
		 * @return
		 */
		public int getRank() {
			return rank;
		}

		/**
		 * Sets the rank
		 * 
		 * @param r
		 *            the given rank
		 */
		public void setRank(int r) {
			rank = r;
		}

		/**
		 * Returns the color of the node
		 * 
		 * @return c
		 */
		public Color getColor() {
			return c;
		}

		/**
		 * Sets the color of the node to the given color co
		 * 
		 * @param co
		 *            the given color
		 */
		public void setColor(Color co) {
			c = co;
		}

	}

	private Node root; // the root of the RB Tree

	/**
	 * Constructor for the Red Black Tree class
	 */
	public RedBlackTree() {
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
	 * Returns the smallest value in the RB Tree Used to find successor and deletion
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
	 * Returns the largest value in the RB Tree
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
	 * to ensure RB Tree properties
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
	 * Exchanges two given nodes on the RB Tree Used for deletion
	 * 
	 * @param B
	 *            the Red Black Tree
	 * @param u
	 *            the given node
	 * @param v
	 *            the given node
	 */
	public static void Transplant(RedBlackTree B, Node u, Node v) {
		if (u.p == null) {
			B.root = v;
		} else if (u == u.p.left) {
			u.p.left = v;
		} else {
			u.p.right = v;
		}
		v.p = u.p;
	}

	/**
	 * Left rotates the given node on the RB Tree Used by insertion and deletion
	 * 
	 * @param B
	 *            the Red Black Tree
	 * @param z
	 *            the given node
	 */
	public static void leftRotate(RedBlackTree B, Node x) {
		Node y = x.right;
		x.right = y.left; // turn y's left subtree into x's right subtree

		if (y.left != null) {
			y.left.p = x;
		}

		y.p = x.p; // link x's parent to y

		if (x.p == null) {
			B.root = y;
		} else if (x == x.p.left) {
			x.p.left = y;
		} else {
			x.p.right = y;
		}
		y.left = x;
		x.p = y;
	}

	/**
	 * Right rotates the given node on the RB Tree Used by insertion and deletion
	 * 
	 * @param B
	 *            the Red Black Tree
	 * @param z
	 *            the given node
	 */
	public static void rightRotate(RedBlackTree B, Node x) {
		Node y = x.left;
		if (y != null) {
			x.left = y.right; // turn y's right subtree into x's left subtree

			if (y.right != null) {

				y.right.p = x;
			}

			y.p = x.p; // link x's parent to y
			if (x.p == null) {
				B.root = y;
			} else if (x == x.p.right) {
				x.p.right = y;
			} else {
				x.p.left = y;
			}
			y.right = x;
		}
		x.p = y;
	}

	/**
	 * Inserts the given node into the RB Tree and then maintains RB Tree properties
	 * 
	 * @param B
	 *            the Red Black Tree
	 * @param z
	 *            the given node
	 */
	public static void Insert(RedBlackTree B, Node z) {
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

		z.left = null;
		z.right = null;
		z.c = Color.RED;

		InsertFixup(B, z); // maintains RB Tree properties
	}

	/**
	 * Used to maintain RB Tree properties based on the color of the node inserted
	 * Used by insertion
	 * 
	 * @param B
	 *            the Red Black Tree
	 * @param z
	 *            the given node
	 */
	public static void InsertFixup(RedBlackTree B, Node z) {
		Node y = null;
		while (z != B.root && z.p.c == Color.RED) {
			if (z.p != B.root && z.p.p.left != null && z.p == z.p.p.left) {
				y = z.p.p.right;

				if (y.c == Color.RED) { // case 1
					z.p.c = Color.BLACK;
					y.c = Color.BLACK;
					z.p.p.c = Color.RED;
					z = z.p.p;
				} else if (z == z.p.right) { // case 2
					z = z.p;
					leftRotate(B, z);
					z.p.c = Color.BLACK;
					z.p.p.c = Color.RED;
					rightRotate(B, z.p.p);
				}
			} else { // case 3
				if (z.p != B.root && z.p == z.p.p.right) {
					y = z.p.p.left;

					if (y != null && y.c == Color.RED) { // case 1
						z.p.c = Color.BLACK;
						y.c = Color.BLACK;
						z.p.p.c = Color.RED;
						z = z.p.p;
					} else if (z == z.p.left) { // case 2
						z = z.p;
						leftRotate(B, z);
					}
					z.p.c = Color.BLACK;
					z.p.p.c = Color.RED;
					rightRotate(B, z.p.p);
				}
			}
		}
		B.root.c = Color.BLACK;
	}

	/**
	 * Deletes the given node from the RB Tree and maintains RB Tree properties
	 * 
	 * @param B
	 *            the Red Black Tree
	 * @param z
	 *            the given node
	 */
	public static void Delete(RedBlackTree B, Node z) {
		Node y = z;
		Color OC = y.c;
		Node x = z;
		if (z.left == null) {
			x = z.right;
			Transplant(B, z, z.right);
		}

		else if (z.right == null) {
			x = z.left;
			Transplant(B, z, z.left);
		}

		else {
			y = Minimum(z.right); // find z's successor to transplant
			OC = y.c;
			x = y.right;

			if (y.p == z) {
				x.p = y;

			}

			else {
				Transplant(B, y, y.right);
				y.right = z.right;
				y.right.p = y;
			}

			Transplant(B, z, y);
			y.left = z.left;
			y.left.p = y;

			y.c = z.c;
		}

		if (OC == Color.BLACK) {
			DeleteFixup(B, z);
		}
	}

	/**
	 * Used to maintain RB Tree properties based on the color of the node being
	 * deleted Used by deletion
	 * 
	 * @param B
	 * @param x
	 */
	public static void DeleteFixup(RedBlackTree B, Node x) {
		Node w = null;
		while (x != B.root && x.c == Color.BLACK) {
			if (x == x.p.left) {
				w = x.p.right;

				if (w.c == Color.RED) { // case 1
					w.c = Color.BLACK;
					x.p.c = Color.RED;

					leftRotate(B, x.p);
					w = x.p.right;
				}

				if (w.left.c == Color.BLACK && w.right.c == Color.BLACK) { // case 2
					w.c = Color.RED;
					x = x.p;
				} else if (w.right.c == Color.BLACK) { // case 3
					w.left.c = Color.BLACK;
					w.c = Color.RED;

					rightRotate(B, w);

					w = x.p.right;
				}
				// case 4
				w.c = x.p.c;
				x.p.c = Color.BLACK;
				w.right.c = Color.BLACK;
				leftRotate(B, x.p);
				x = B.root;
			} else {
				w = x.p.left;

				if (w.c == Color.RED) { // case 1
					w.c = Color.BLACK;
					x.p.c = Color.RED;

					rightRotate(B, x.p);
					w = x.p.left;
				}

				if (w.right.c == Color.BLACK && w.left.c == Color.BLACK) { // case 2
					w.c = Color.RED;
					x = x.p;
				} else if (w.left.c == Color.BLACK) { // case 3
					w.right.c = Color.BLACK;
					w.c = Color.RED;

					leftRotate(B, w);

					w = x.p.left;
				}
				w.c = x.p.c;
				x.p.c = Color.BLACK;
				w.left.c = Color.BLACK;
				rightRotate(B, x.p);
				x = B.root;
			}
		}
		x.c = Color.BLACK;
	}

	/**
	 * Returns the in-order of the RB Tree given the starting node
	 * 
	 * @param x
	 *            the given node
	 * @return the list of nodes in-order
	 */
	public static void inOrder(Node x) {
		if (x != null) {
			inOrder(x.left);
			System.out.println(x.getRank() + ". " + x.getURL() + " (" + x.key + ") Color: " + x.c);
			inOrder(x.right);
		}
	}
}