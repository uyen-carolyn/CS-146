import java.util.ArrayList;

/**
 * Quick sort class created to sort a list of Keyword types by score
 */
public class QuickSort {
	/**
	 * Recursively sorts the ArrayList using Quicksort by comparing scores
	 * 
	 * @param k
	 *            the ArrayList used
	 * @param p
	 *            the leftmost index of the ArrayList
	 * @param r
	 *            the rightmost index of the ArrayList
	 * @return k the ArrayList sorted
	 */
	public static ArrayList<Keyword> quickS(ArrayList<Keyword> k, int p, int r) {
		if (p < r) {
			int q = partition(k, p, r);
			quickS(k, p, q - 1); // recursively sorts the left side
			quickS(k, q + 1, r); // recursively sorts the right side
		}

		return k;
	}

	/**
	 * Finds the pivot that will be used to sort in the quickS method
	 * 
	 * @param k
	 *            the ArrayList used
	 * @param p
	 *            the left index used
	 * @param r
	 *            the right index used
	 * @return the pivot
	 */
	public static int partition(ArrayList<Keyword> k, int p, int r) {
		int x = k.get(r).getScore();
		int i = p - 1;

		for (int j = p; j < r; j++) {
			if (k.get(j).getScore() <= x) {
				i++;

				Keyword temp = k.get(i); // swap
				k.set(i, k.get(j));
				k.set(j, temp);
			}
		}

		Keyword temp = k.get(i + 1); // swap
		k.set(i + 1, k.get(r));
		k.set(r, temp);

		return i + 1;
	}

	/**
	 * Used to print out the top ten along with their scores, indices, and new rank.
	 * 
	 * @param k
	 *            the Arraylist used
	 */
	static void printArrayQ(ArrayList<Keyword> k) {
		int n = 1;
		for (int i = k.size()-1; i >= 0; i--)
			System.out.println(n++ + ". " + k.get(i).getName() + " " + "(Index: " + k.get(i).getIndex()
					+ " Total Score: " + k.get(i).getScore() + ")");

	}
}
