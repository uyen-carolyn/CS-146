import java.util.ArrayList;

/**
 * Bucket sort class created to sort a list of Keyword types by URL name
 */
public class BucketSort {
	/**
	 * Sorts an array of Keyword types alphabetically given the unsorted array 
	 * Uses insertS(ArrayList<Keyword> k) to sort buckets individually
	 * 
	 * @param k
	 *            the given array
	 * @return k
	 */
	public static Keyword[] bucketS(Keyword[] k) {
		ArrayList<Keyword> buckets[] = new ArrayList[k.length];

		int n = k.length;

		// create buckets
		for (int i = 0; i < k.length; i++) {
			buckets[i] = new ArrayList<Keyword>();
		}

		// add stuff into buckets
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				buckets[i].add(k[j]);
			}
		}

		// sort
		for (int i = 0; i < buckets.length; i++) {
			insertS(buckets[i]);
		}

		for (int i = 0; i <= k.length - 1; i++) {
			for (int j = 0; j <= buckets.length; j++) {
				k[i] = buckets[i].get(i);
			}
		}

		return k;

	}

	/**
	 * Altered insertion sort method from previous assignment used to perform bucket
	 * sort
	 * 
	 * @param k
	 *            the given array
	 * @return k
	 */
	private static ArrayList<Keyword> insertS(ArrayList<Keyword> k) {
		for (int i = 1; i < k.size(); i++) {
			Keyword key = k.get(i);
			int j = i - 1;

			while (j >= 0 && k.get(j).getName().compareTo(key.getName()) > 0) {
				k.set(j + 1, k.get(j));

				j = j - 1;
			}

			k.set(j + 1, key);
		}

		return k;

	}

	/**
	 * Prints the give array up to a given number along with its original index and
	 * score
	 * 
	 * @param k
	 *            the given array
	 * @param x
	 *            the given number
	 */
	static void printArrayB(Keyword[] k, int x) {
		int n = 1;
		for (int i = 0; i < x; ++i)
			System.out.println(
					n++ + ". " + k[i].getName() + " " + "(Index: " + i + " Total Score: " + k[i].getScore() + ")");
	}
}