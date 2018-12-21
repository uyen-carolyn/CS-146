import java.util.ArrayList;

/**
 * Insertion sort class created to sort a list of Node types by key For this
 * simulator, it is simply used to assign ranking to the Node type after the
 * tree has been altered due to insertion or deletion
 */
public class InsertionSortForRank {
	/**
	 * Insertion sort method of the class
	 * 
	 * @param s
	 *            The Arraylist given
	 * @return
	 */
	public static ArrayList<RedBlackTree.Node> insertS(ArrayList<RedBlackTree.Node> s) {
		for (int i = 1; i < s.size() - 1; i++) {
			RedBlackTree.Node key = s.get(i);
			int j = i - 1;

			while (j >= 0 && s.get(j).key > key.key) {
				s.set(j + 1, s.get(j));

				j = j - 1;
			}

			s.set(j + 1, key);
		}

		return s;
	}

	/**
	 * Used to assign the rank of the Node type
	 * 
	 * @param k
	 *            the Arraylist used
	 */
	static void assignRankI(ArrayList<RedBlackTree.Node> k) {
		int n = 1;
		for (int i = k.size() - 1; i >= 0; i--) {
			k.get(i).setRank(n);
			n++;
		}

	}

}