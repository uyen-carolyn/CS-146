/**
 * Quicksort based off Quicksort algorithm used in  
 * "Introduction to Algorithms" (Third Edition) by by Thomas H. Cormen, 
 * Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein
 */
public class QuickSortDualPivots {
	/**
	 * Sorts the array using two pivots and recursion
	 * 
	 * @param s
	 *            the array used
	 * @param p
	 *            the leftmost element of the array
	 * @param r
	 *            the rightmost element of the array
	 * @return s the array now sorted
	 */
	public static int[] sort(int[] s, int p, int r) {
		if (p < r) { 
	        int lp = partition(s, p, r, p);		// left pivot
	        int rp = partition(s, p, r, lp); 	// right pivot
	        
	        sort(s, p, lp - 1); 				// recursively sorts the left,
	        sort(s, lp + 1, rp - 1); 			// middle, and right sub-arrays 
	        sort(s, rp + 1, r); 				// created for algorithm
		}
		return s;
	}

	/**
	 * Determines the pivot to be used during sorting based on the position of the left pivot
	 * 
	 * @param A
	 *            the array used
	 * @param p
	 *            the leftmost element of the array
	 * @param r
	 *            the rightmost element of the array
	 * @return i + 1
	 */
	public static int partition(int[] s, int p, int r, int lp) {
		if (s[p] > s[r]) { 
			int temp = s[p];
			s[p] = s[r];
			s[r] = temp;
		}
 
	    int j = p + 1; 
	    int g = r - 1;
	    int k = p + 1;
	    int h = s[p];		// left pivot
	    int i = s[r]; 		// right pivot
	    
	    while (k <= g) { 	
	  
	        // checks if element at k is less than the left pivot 
	        if (s[k] < h) { 
	        	int temp = s[k];
				s[k] = s[j];
				s[j] = temp;
	            j++; 
	        } 
	  
	        // checks if element at k is greater than or equal to the right pivot 
	        else if (s[k] >= i) { 
	            while (s[g] > i && k < g) 
	                g--; 
	            int temp = s[k];
				s[k] = s[g];
				s[g] = temp;
	            g--; 
	            if (s[k] < h) { 
	            	temp = s[k];
					s[k] = s[j];
					s[j] = temp;
	                j++; 
	            } 
	        } 
	        k++; 
	    } 
	    j--; 
	    g++; 
	  
	    // puts pivots into their position in the array
	    
	    // left pivot
	    int temp = s[p];
		s[p] = s[j];
		s[j] = temp; 
		// right pivot
		temp = s[r];
		s[r] = s[g];
		s[g] = temp;
	  
	    // return indices of pivots 
	    lp = j; // resets left pivot (cannot return two elements for this method)
	  
	    return g; 
	}

	/**
	 * Prints the array in a readable format
	 * 
	 * @param s
	 *            the array being read
	 */
	static void printarray(int s[]) {
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
		System.out.println("	| Quick Sort Version 2 Algorithm Performance: |");
		System.out.println("	----------------------------------------------- \n ");

		System.out.println("Worst Case (already sorted): "
				+ "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]");
		long startTime = System.nanoTime();
		sort(worst, 0, worst.length - 1);
		long endTime = System.nanoTime();
		System.out.print("Sorted: ");
		printarray(worst);
		long time = endTime - startTime;
		System.out.println("Performance: " + Long.toString(time) + " ns");

		System.out.println("--------------------------------------------------------------------- ");

		System.out.println("Average Case (randomly sorted): "
				+ "[2, 6, 3, 10, 9, 1, 15, 18, 4, 16, 7, 14, 20, 11, 12, 8, 13, 19, 5, 17]");
		startTime = System.nanoTime();
		sort(avg, 0, avg.length - 1);
		endTime = System.nanoTime();
		System.out.print("Sorted: ");
		printarray(avg);
		time = endTime - startTime;
		System.out.println("Performance: " + Long.toString(time) + " ns");

		System.out.println("--------------------------------------------------------------------- ");

		System.out.println("Best Case (evenly distributed subarray size): "
				+ "[1, 2, 4, 3, 8, 6, 9, 7, 5, 11, 12, 14, 16, 13, 19, 17, 20, 18, 15, 10]");
		startTime = System.nanoTime();
		sort(best, 0, best.length - 1);
		endTime = System.nanoTime();
		System.out.print("Sorted: ");
		printarray(best);
		time = endTime - startTime;
		System.out.println("Performance: " + Long.toString(time) + " ns");
	}
}
