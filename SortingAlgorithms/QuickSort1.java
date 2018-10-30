/**
 * Program that sorts an array of numbers using the quicksort algorithm
 */
public class QuickSort1 {
	/**
	 * Sorts the array using recursion
	 * 
	 * @param s the array used
	 * @param p the leftmost element of the array
	 * @param r the rightmost element of the array
	 * @return s the array now sorted
	 */
	public static int[] sort(int[] s, int p, int r) {
		if (p < r) {
			int q = partition(s, p, r);
			
      sort(s, p, q - 1); // recursively sorts the left side
			sort(s, q + 1, r); // recursively sorts the right side
		}

		return s;
	}

	/**
	 * Determines the pivot to be used during sorting
	 * 
	 * @param A the array used
	 * @param p the leftmost element of the array
	 * @param r the rightmost element of the array
	 * @return i + 1
	 */
	public static int partition(int[] s, int p, int r) {
		int x = s[r];
		int i = p - 1;

		for (int j = p; j < r; j++) {
			if (s[j] <= x) {
				i++;

				int temp = s[i];
				s[i] = s[j];
				s[j] = temp;
			}
		}
		
    int temp = s[i + 1];
		s[i + 1] = s[r];
		s[r] = temp;

		return i + 1;
	}

	/**
	 * Prints the array in a readable format
	 * 
	 * @param s the array being read
	 */
	static void printArray(int s[]) {
		int n = s.length;
		for (int i = 0; i < n; ++i)
			System.out.print(s[i] + " ");
		System.out.println("\n");
	}

	public static void main(String args[]) {
		int best[] = { 1, 2, 4, 3, 8, 6, 9, 7, 5, 11, 12, 14, 16, 13, 19, 17, 20, 18, 15, 10 };
		int avg[] = { 2, 6, 3, 10, 9, 1, 15, 18, 4, 16, 7, 14, 20, 11, 12, 8, 13, 19, 5, 17 }; 
		int worst[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 }; 

		System.out.println("	----------------------------------------------- ");
		System.out.println("	| Quick Sort Version 1 Algorithm Performance: |");
		System.out.println("	----------------------------------------------- \n ");
		
    System.out.println("Best Case (evenly distributed subarray size): "
				+ "[1, 2, 4, 3, 8, 6, 9, 7, 5, 11, 12, 14, 16, 13, 19, 17, 20, 18, 15, 10]");
		long startTime = System.nanoTime();
		sort(best, 0, best.length - 1);
		long endTime = System.nanoTime();

		System.out.print("Sorted: ");
		printArray(best);
		Long time = endTime - startTime;
		System.out.println("Performance: " + Long.toString(time) + " ns");
		
		System.out.println("--------------------------------------------------------------------- ");

		System.out.println("Average Case (randomly sorted): "
				+ "[2, 6, 3, 10, 9, 1, 15, 18, 4, 16, 7, 14, 20, 11, 12, 8, 13, 19, 5, 17]");
		startTime = System.nanoTime();
		sort(avg, 0, avg.length - 1);
		endTime = System.nanoTime();

		System.out.print("Sorted: ");
		printArray(avg);
		time = endTime - startTime;
		System.out.println("Performance: " + Long.toString(time) + " ns");
		
		System.out.println("--------------------------------------------------------------------- ");
		
		System.out.println("Worst Case (already sorted): "
				+ "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]");
		startTime = System.nanoTime();
		sort(worst, 0, worst.length - 1);
		endTime = System.nanoTime();

		System.out.print("Sorted: ");
		printArray(worst);
		time = endTime - startTime;
		System.out.println("Performance: " + Long.toString(time) + " ns");
	}
}
