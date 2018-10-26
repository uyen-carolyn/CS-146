import java.util.ArrayList;

public class Simulator {
	private ArrayList<KeyWord> keywords;
	private int heapSize;
	private boolean isSorted; // determines if the ArrayList is already sorted

	/**
	 * Constructor for the Simulator class
	 * 
	 * @param capacity
	 *            the size
	 */
	public Simulator(int capacity) {
		keywords = new ArrayList<KeyWord>(capacity);
		heapSize = capacity;
		isSorted = false;
	}

	/**
	 * Help maintain MaxHeap properties by swapping nodes with their children or
	 * with their parents
	 * Complexity: T(n) + 1 -> O(nlgn) 
	 * @param A
	 *            the ArrayList used
	 * @param i
	 *            the index
	 */
	public void maxHeapify(ArrayList<KeyWord> A, int i) {
		int left = left(i);
		int right = right(i);
		int largest = i;

		// compares the children of the node
		if (left <= heapSize - 1 && A.get(left).getScore() > A.get(i).getScore()) {
			largest = left;
		}

		if (right <= heapSize - 1 && A.get(right).getScore() > A.get(largest).getScore()) {
			largest = right;
		}

		// recursively swaps and maintain MaxHeap properties
		if (largest != i) {
			KeyWord temp = A.get(i); // swap
			A.set(i, A.get(largest));
			A.set(largest, temp);

			maxHeapify(A, largest);
		}
	}

	/**
	 * Method to build MaxHeap given the ArrayList by implementing MaxHeap properties
	 * Complexity: T(2n) + 1 -> O(nlgn) 
	 * @param A
	 *            the ArrayList used
	 */
	public void BuildMaxHeap(ArrayList<KeyWord> A) {
		keywords = A;
		heapSize = A.size();

		for (int i = (A.size() / 2) - 1; i >= 0; i--) {
			maxHeapify(A, i); // although added values, MaxHeap properties must be maintained
		}
	}

	/**
	 * Like extractMax() but continuously swap and maxHeapify in order to do a
	 * complete sort
	 * Complexity: O(nlgn) + (T(n) + 1 -> O(nlgn)
	 * @param A
	 *            the ArrayList used
	 */
	public void Heapsort(ArrayList<KeyWord> A) {
		BuildMaxHeap(A);

		for (int i = A.size() - 1; i >= 0; i--) {
			KeyWord temp = A.get(0); // swap
			A.set(0, A.get(i));
			A.set(i, temp);

			heapSize--;			// "deleting" the node, actually putting the node in the end of the ArrayList
			maxHeapify(A, 0);
		}
		isSorted = true;
	}

	/**
	 * Inserts the KeyWord into the heap and sets the score
	 * Complexity: O(1) + O(n) -> O(n)
	 * @param A
	 *            the ArrayListused
	 * @param e
	 *            the KeyWord inserted
	 * @param f
	 *            the score for frequency
	 * @param t
	 *            the score for time
	 * @param o
	 *            the score for other links
	 * @param p
	 *            the score for payment
	 */
	public void Insert(ArrayList<KeyWord> A, KeyWord e, int f, int t, int o, int p) {
		A.add(e);
		keywords.add(e);

		A.set(heapSize, e);

		IncreaseKey(A, heapSize, e, f, t, o, p);	// adjusts the placement of the new node according to MaxHeap properties
		heapSize++;
	}

	/**
	 * Swaps the biggest value with the last leaf before removing said value
	 * Complexity: O(1) + O(nlgn) -> O(nlgn)
	 * @param A
	 *            the ArrayList used
	 */
	public KeyWord ExtractMax(ArrayList<KeyWord> A) {
		if (heapSize < 1) {
			throw new IllegalArgumentException("Heap underflow.");
		}

		KeyWord max = A.get(0);
		keywords.set(0, keywords.get(keywords.size() - 1));
		keywords.remove(keywords.size() - 1);
		maxHeapify(A, 0);

		return max;
	}

	/**
	 * Increases one of the factors that the user chooses and swaps
	 * Complexity: O(1) + O(n) -> O(n)
	 * @param A
	 *            the ArrayList used
	 * @param i
	 *            the index of the keyword being changed
	 * @param factor
	 *            the factor that is being altered
	 * @param key
	 *            the amount that the factor will be increased
	 */
	public void IncreaseKey(ArrayList<KeyWord> A, int i, KeyWord key, int f, int t, int o, int p) {
		if (key.getScore() < A.get(i).getScore()) {
			throw new IllegalArgumentException("New key cannot be smaller than current key.");
		}

		key.setScore((f + t + o + p) / 4);
		A.set(i, key);
		// keywords.set(i, key);

		// maintains the MaxHeap properties now that score has changed
		while (i > 0 && (A.get(parent(i)).getScore() < A.get(i).getScore())) {
			// KeyWord temp = keywords.get(i); // swap
			KeyWord tp = A.get(i);
			// keywords.set(i, keywords.get(parent(i)));
			A.set(i, A.get(parent(i)));
			// keywords.set(parent(i), temp);
			A.set(parent(i), tp);

			i = parent(i);
		}
	}

	/**
	 * Returns the biggest value of the MaxHeap or ArrayList, depending on whether
	 * it is sorted or not
	 * Complexity: O(1)
	 * @param A
	 *            the Array that will be sorted
	 */
	public KeyWord Maximum(ArrayList<KeyWord> A) {
		if (isSorted) {
			return A.get(A.size() - 1);
		} else {
			return A.get(0); // biggest value is the root
		}
	}

	// methods used to determine other nodes given the index of a certain node

	/**
	 * Returns the parent of the given node's index
	 * Complexity: O(1)
	 * @param index
	 *            the index of the node
	 * @return
	 */
	private int parent(int index) {
		return (index - 1) / 2;
	}

	/**
	 * Returns the left of the given node's index
	 * Complexity: O(1)
	 * @param index
	 *            the index of the node
	 * @return
	 */
	private int left(int index) {
		return 2 * index + 1;
	}

	/**
	 * Returns the right of the given node's index
	 * Complexity: O(1)
	 * @param index
	 *            the index of the node
	 * @return
	 */
	private int right(int index) {
		return 2 * index + 2;
	}
}
// Total Complexity:  4O(1) + 2O(n) + 4O(nlgn) -> O(nlgn) 