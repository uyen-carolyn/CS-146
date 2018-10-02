/**
 * Insertion Sort based off Insertion Sort algorithm used in  
 * "Introduction to Algorithms" (Third Edition) by by Thomas H. Cormen, 
 * Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein
 *
 */
public class InsertionSort {
	public static int[] sort(int[] s) {
		for (int i = 1; i < s.length; i++) {
			int key = s[i];
			int j = i - 1;

			while (j >= 0 && s[j] > key) {
				s[j + 1] = s[j];

				j = j - 1;
			}
			s[j + 1] = key;
		}

		return s;
	}

	/**
	 * Prints the array as a string of numbers
	 * 
	 * @param s
	 */
	static void printArray(int s[]) {
		for (int i = 0; i < s.length; ++i)
			System.out.print(s[i] + " ");
	}

	/**
 	 * Tests sorting algorithm on an array of 20 distinct number elements 
	 * and returns the time it takes for best, average, and worst case scenario. 
         */
	public static void main(String args[]) {
		int best[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		int avg[] = { 3, 5, 7, 11, 2, 4, 6, 9, 16, 1, 8, 10, 20, 12, 15, 13, 14, 17, 19, 18 };
		int worst[] = { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		System.out.println("Insertion Algorithm Performance: ");
		System.out.println("Best case (already sorted): " + "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, "
				+ "11, 12, 13, 14, 15, 16, 17, 18, 19, 20 ]");
		long startTime = System.nanoTime();
		sort(best);
		long endTime = System.nanoTime();

		printArray(best);
		Long time = endTime - startTime;
		System.out.println("\n	Performance: " + Long.toString(time) + " ns\n");

		System.out.println("Average Case (randomly sorted): [3, 5, 7, 11, 2, 4, 6, 9, 16, 1,"
				+ "8, 10, 20, 12, 15, 13, 14, 17, 19, 18]");
		startTime = System.nanoTime();
		sort(avg);
		endTime = System.nanoTime();

		printArray(avg);
		time = endTime - startTime;
		System.out.println("\n	Performance: " + Long.toString(time) + " ns\n");

		System.out.println("Worst Case (in reverse): [20, 19, 18, 17, 16, 15, 14, 13, 12, 11, "
				+ "10, 9, 8, 7, 6, 5, 4, 3, 2, 1]");
		startTime = System.nanoTime();
		sort(worst);
		endTime = System.nanoTime();

		printArray(worst);
		time = endTime - startTime;
		System.out.println("\n	Performance: " + Long.toString(time) + " ns\n");
	}
}
