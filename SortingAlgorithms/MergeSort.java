/**
 * Top-Down Merge Sort based off Merge Sort algorithm used in  
 * "Introduction to Algorithms" (Third Edition) by by Thomas H. Cormen, 
 * Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein
 */
public class MergeSort {
	public static int[] sort(int[] s, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;

			sort(s, p, q);
			sort(s, q + 1, r);
			merge(s, p, q, r);
		}
		return s;
	}

	public static void merge(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;

		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];

		for (int i = 0; i < n1; i++) {
			L[i] = A[p + i];
		}

		for (int j = 0; j < n2; j++) {
			R[j] = A[q + j + 1];
		}

		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;

		int i = 0, j = 0;

		for (int k = p; k <= r; k++) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			} 
			else {
				A[k] = R[j];
				j++;
			}
		}
	}

	/**
	 * Prints the array as a string of numbers
	 * 
	 * @param s
	 */
	static void printArray(int s[]) {
		int n = s.length;
		for (int i = 0; i < n; ++i)
			System.out.print(s[i] + " ");
	}

	public static void main(String args[]) {
		int best[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		int avg[] = { 3, 5, 7, 11, 2, 4, 6, 9, 16, 1, 8, 10, 20, 12, 15, 13, 14, 17, 19, 18 };
		int worst[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };

		System.out.println("Merge Sort Algorithm Performance: ");
		System.out.println("Best case (already sorted): " + "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, "
				+ "11, 12, 13, 14, 15, 16, 17, 18, 19, 20 ]");
		long startTime = System.nanoTime();
		sort(best, 0, best.length - 1);
		long endTime = System.nanoTime();

		printArray(best);
		Long time = endTime - startTime;
		System.out.println("\n	Performance: " + Long.toString(time) + " ns\n");

		System.out.println("Average Case (randomly sorted): [3, 5, 7, 11, 2, 4, 6, 9, 16, 1,"
				+ "8, 10, 20, 12, 15, 13, 14, 17, 19, 18]");
		startTime = System.nanoTime();
		sort(avg, 0, avg.length - 1);
		endTime = System.nanoTime();

		printArray(avg);
		time = endTime - startTime;
		System.out.println("\n	Performance: " + Long.toString(time) + " ns\n");

		System.out.println("Worst Case (maximum comparisons possible )" + ": [2, 4, 6, 8, 10, 12, 14, 16, 18, 20, "
				+ "1, 3, 5, 7, 9, 11, 13, 15, 17, 19]");
		startTime = System.nanoTime();
		sort(worst, 0, worst.length - 1);
		endTime = System.nanoTime();

		printArray(worst);
		time = endTime - startTime;
		System.out.println("\n	Performance: " + Long.toString(time) + " ns\n");
	}
}
