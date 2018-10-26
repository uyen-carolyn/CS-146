import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class SimulatorTester2 {

	public static void main(String[] args) {
		ArrayList<String> w = new ArrayList<>();

		ArrayList<KeyWord> searches = new ArrayList<>();
		Simulator h = new Simulator(searches.size());

		int x = 0; 
		System.out.println("Hello, and welcome to the Google Simulator");
		while (x <= 9) {		// ten searches
			Spider spider = new Spider();
			Scanner sc = new Scanner(System.in);
			//System.out.println("Please enter a website ending in .com");
			//String link = "http://" + sc.nextLine() + "/";
			System.out.println("Please enter a keyword you would like to look up:	");
			String word = sc.nextLine();
			w.add(word);

			spider.search("https://google.com/", word);
			spider.getPages();
			List<String> list = new ArrayList<String>(spider.getPages());
			ArrayList<KeyWord> URL = new ArrayList<KeyWord>();

			Simulator heap = new Simulator(URL.size());
			for (int i = 0; i < list.size(); i++) {
				KeyWord n = new KeyWord(list.get(i), 0);
				System.out.println("For " + n.getWord());
				System.out.println("Enter the URL's frequency score");
				int freq = sc.nextInt();
				System.out.println("Enter the URL's time score");
				int time = sc.nextInt();
				System.out.println("Enter the URL's other webpages score");
				int other = sc.nextInt();
				System.out.println("Enter the URL's payment score");
				int pay = sc.nextInt();

				// URL.add(new KeyWord(list.get(i), (freq + time + other + pay) / 4));
				n.setScore((freq + time + other + pay)/4);
				heap.Insert(URL, n, freq, time, other, pay);
				System.out.println(
						"URL #" + (i + 1) + "'s total score has been calculated.");
				System.out.println("---------------------------------------");
			}

			System.out.println("The maximum: " + heap.Maximum(URL).getWord() +" with a score of " + heap.Maximum(URL).getScore());
			heap.BuildMaxHeap(URL);

			heap.Heapsort(URL);
			System.out.println("Top Priority Searches");
			int j = 1;
			if (URL.size() >= 10) {
				for (int i = 9; i >= 0; i--) {
					System.out.println(
							"Rank #" + (j++) + ": " + URL.get(i).getWord() + " (score: " + URL.get(i).getScore() + ")");
				}
			}
			else {
				for (int i = URL.size()-1; i >= 0; i--) {
					System.out.println(
							"Rank #" + (j++) + ": " + URL.get(i).getWord() + " (score: " + URL.get(i).getScore() + ")");
				}
			}
			x++; 
			System.out.println(x);
		}

		ArrayList<String> unique = new ArrayList<>();
		ArrayList<String> notUnique = new ArrayList<>();
		
		ArrayList<String> allSearches = new ArrayList<>(); 
		int repeat = 0; // count how many times the word is seen

		for (int i = 0; i < w.size(); i++) {

			for (int j = 0; j < w.size(); j++) {
				if (w.get(i).equals(w.get(j))) {
					repeat++;
				}
			}

			if (repeat == 1) { // only repeat is itself
				unique.add(w.get(i));
				
			}
			else {
				notUnique.add(w.get(i)); 
			}

			repeat = 0; // resets for the next word
		}
		
		for (int i = 0; i < unique.size(); i++) {
			allSearches.add(unique.get(i)); 
		}
		
		for (int i = 0; i < unique.size(); i++) {
			allSearches.add(notUnique.get(i)); 
		}
		
 		System.out.println("Most Unique Searches Today: "); 
		if(allSearches.size() >= 10) {
			for (int i = 0; i < 10; i++) {
				System.out.print(allSearches.get(i) + " ");
			}
		}
		else {
			for (int i = 0; i < allSearches.size(); i++) {
				System.out.print(allSearches.get(i) + " ");
			}
		}
	}
	
	

}