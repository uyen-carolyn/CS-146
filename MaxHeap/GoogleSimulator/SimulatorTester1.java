import java.util.ArrayList;

public class SimulatorTester1 {

	public static void main(String[] args) {
		KeyWord e = new KeyWord("e", 0);
		KeyWord b = new KeyWord("b", 0);
		KeyWord d = new KeyWord("d", 0);
		KeyWord c = new KeyWord("c", 0);
		KeyWord a = new KeyWord("a", 0);
		KeyWord f = new KeyWord("f", 0);
		KeyWord o = new KeyWord("o", 0);
		KeyWord g = new KeyWord("g", 0);
		KeyWord l = new KeyWord("l", 0);
		KeyWord m = new KeyWord("m", 0);
		ArrayList<KeyWord> h = new ArrayList<KeyWord>();
		ArrayList<KeyWord> h1 = new ArrayList<KeyWord>();

		Simulator heap = new Simulator(h.size());
		Simulator heap1 = new Simulator(h1.size());
		
		System.out.println("-------------------------------------");
		System.out.println("Basic Heapsort."); 
		System.out.println("-------------------------------------");
		// heap insert test
		
		System.out.println("Insertion");
		heap.Insert(h, e, 5, 5, 5, 5);
		heap.Insert(h, b, 2, 2, 2, 2);
		heap.Insert(h, d, 4, 4, 4, 4);
		heap.Insert(h, c, 3, 3, 3, 3);
		heap.Insert(h, a, 1, 1, 1, 1);
		heap.Insert(h, f, 6, 6, 6, 6);
		heap.Insert(h, o, 15, 15, 15, 15);
		heap.Insert(h, g, 7, 7, 7, 7);
		heap.Insert(h, l, 12, 12, 12, 12);
		heap.Insert(h, m, 13, 13, 13, 13);

		System.out.println("- Current Heap Order: ");
		for (int i = 0; i <= h.size() - 1; i++) {
			System.out.print(h.get(i).getWord() + " ");
		}

		System.out.println();
		// max test
		System.out.println("- The maximum right now: " + heap.Maximum(h).getWord());
		heap.Heapsort(h);
		System.out.println("- Heapsort Heap Results");
		for (int i = 0; i < h.size(); i++) {
			System.out.print(h.get(i).getWord() + " ");
		}
		System.out.println();
		System.out.println("- The maximum right now: " + heap.Maximum(h).getWord());
		System.out.println("-------------------------------------");
		heap1.Insert(h1, e, 5, 5, 5, 5);
		heap1.Insert(h1, b, 2, 2, 2, 2);
		heap1.Insert(h1, d, 4, 4, 4, 4);
		heap1.Insert(h1, c, 3, 3, 3, 3);
		heap1.Insert(h1, a, 1, 1, 1, 1);
		heap1.Insert(h1, f, 6, 6, 6, 6);
		heap1.Insert(h1, o, 15, 15, 15, 15);
		heap1.Insert(h1, g, 7, 7, 7, 7);
		heap1.Insert(h1, l, 12, 12, 12, 12);
		heap1.Insert(h1, m, 13, 13, 13, 13);

		System.out.println("Increasing the Key of an Element in Heap");
		System.out.println("-------------------------------------");
		System.out.println("Current Heap Order: ");
		for (int i = 0; i <= h1.size() - 1; i++) {
			System.out.print(h1.get(i).getWord() + " ");
		}
		System.out.println();

		System.out.println("Increasing a");
		heap1.IncreaseKey(h1, h1.indexOf(a), a, 10, 10, 10, 10);
		heap1.Heapsort(h1);
		System.out.println("Heapsort Heap Results");
		for (int i = 0; i < h.size(); i++) {
			System.out.print(h.get(i).getWord() + " ");
		}
		
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println("Max Extraction");
		System.out.println("-------------------------------------");
		ArrayList<KeyWord> h3 = h1; 
		Simulator heap3 = heap1;
		heap3.BuildMaxHeap(h3);
		
		System.out.println("Current Heap Order: ");
		for (int i = 0; i <= h3.size() - 1; i++) {
			System.out.print(h3.get(i).getWord() + " ");
		}
		System.out.println();
		ArrayList<KeyWord> h2 = h1; 
		Simulator heap2 = heap1;
		
		System.out.println("Extracted max: " + heap2.ExtractMax(h2).getWord()); 
	}
}
