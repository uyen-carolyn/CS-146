import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import java.util.Random;

/**
 * Simulator that runs the methods
 */

public class GoogleSimulatorTester {

	public static void main(String[] args) {
		Spider spider = new Spider();
		spider.search("https://trends.google.com/trends/trendingsearches/daily?geo=US");
		spider.getPages();

		List<String> list = new ArrayList<String>(spider.getPages());
		ArrayList<Keyword> k = new ArrayList<Keyword>();

		Random rand = new Random();
		int n = rand.nextInt(10) + 1;
		int m = rand.nextInt(10) + 1;
		int o = rand.nextInt(10) + 1;
		int p = rand.nextInt(10) + 1;
		for (int i = 0; i < spider.getPages().size(); i++) {
			k.add(new Keyword(spider.getList().get(i), n, m, o, p));
			k.get(i).setIndex(i);
			n = rand.nextInt(10) + 1;
			m = rand.nextInt(10) + 1;
			o = rand.nextInt(10) + 1;
			p = rand.nextInt(10) + 1;
		}

		Scanner in = new Scanner(System.in);
		Scanner out = new Scanner(System.in);
		// Display the menu

		System.out.println("Please enter your choice:");
		System.out.println("1\t Sort By Score");
		System.out.println("2\t Change the Data");
		System.out.println("3\t Sort by Name");

		// Get user's choice
		int choice = in.nextInt();

		// Display the title of the chosen module
		switch (choice) {
		case 1:
			System.out.println("Top 10 URLS Sorted By Score: ");
			QuickSort.quickS(k, 0, k.size() - 1);
			QuickSort.printArrayQ(k);
			break;
		case 2:
			// convert Keyword into Node and create a Binary Search Tree
			ArrayList<BinarySearchTree.Node> keywordNodes = new ArrayList<>();
			BinarySearchTree s = new BinarySearchTree();
			for (int i = 0; i < k.size() - 1; i++) {
				keywordNodes.add(BinarySearchTree.Node.keywordToNode(k.get(i).getName(), k.get(i).getScore()));
				keywordNodes.get(i).setIndex(i);
				BinarySearchTree.Insert(s, keywordNodes.get(i));

			}
			System.out.println("Please Enter Your Choice: ");
			System.out.println("1\t Add a URL");
			System.out.println("2\t Remove a URL");
			System.out.println("3\t Sort Inorder");
			System.out.println("4\t Find a URL"); // returns both search and iterative_search methods
			System.out.println("5\t Return the URL with the smallest score");
			System.out.println("6\t Return the URL with the biggest score");
			System.out.println("7\t Return the successor of a URL");

			int option = in.nextInt();
			String name = out.next();

			switch (option) {
			case 1:
				System.out.println("Current Order of URLs: ");
				BinarySearchTree.inOrder(keywordNodes.get(0));
				System.out.println("What would you like to input. Please enter its score");
				int newScore = in.nextInt();

				BinarySearchTree.Node newURL = new BinarySearchTree.Node("fake.com", newScore);
				keywordNodes.add(newURL);
				newURL.setIndex(keywordNodes.size() - 1);
				BinarySearchTree.Insert(s, newURL);

				System.out.println("New Order of URLs: ");
				BinarySearchTree.inOrder(keywordNodes.get(0));
				break;
			case 2:
				BinarySearchTree.Node newURLr = new BinarySearchTree.Node("fake.com", 20);
				keywordNodes.add(newURLr);
				newURLr.setIndex(keywordNodes.size() - 1);
				BinarySearchTree.Insert(s, newURLr);
				System.out.println("Current Order of URLs: ");
				BinarySearchTree.inOrder(keywordNodes.get(0));
				System.out.println("What would you like to remove. Please enter its url");
				String newS = out.next();
				BinarySearchTree.Delete(s, newURLr);

				System.out.println("New Order of URLs: ");
				BinarySearchTree.inOrder(keywordNodes.get(0));
				break;
			case 3:
				System.out.println("Order of URLs: ");
				BinarySearchTree.inOrder(keywordNodes.get(0));
				break;
			case 4:
				System.out.println("List of URLs: ");
				BinarySearchTree.inOrder(keywordNodes.get(0));
				System.out.println("What score would you like to find or try to find?");
				int find = in.nextInt();
				BinarySearchTree.Node regularSearch = BinarySearchTree.Search(keywordNodes.get(0), find);
				BinarySearchTree.Node iterativeSearch = BinarySearchTree.Iterative_Search(keywordNodes.get(0), find);

				System.out.println("Our results found this:");
				System.out
						.println("Regular search: " + regularSearch.getURL() + " at index " + regularSearch.getIndex());
				System.out.println(
						"Iterative search: " + iterativeSearch.getURL() + " at index " + iterativeSearch.getIndex());
				break;

			case 5:
				System.out.println("URLs: ");
				BinarySearchTree.inOrder(keywordNodes.get(0));
				BinarySearchTree.Node mini = BinarySearchTree.Minimum(keywordNodes.get(0));
				System.out.println("The smallest score is " + mini.getURL() + " with a score of " + mini.getKey()
						+ " at index " + mini.getIndex());
				break;
			case 6:
				System.out.println("URLs: ");
				BinarySearchTree.inOrder(keywordNodes.get(0));
				BinarySearchTree.Node max = BinarySearchTree.Maximum(keywordNodes.get(0));
				System.out.println("The largest score is " + max.getURL() + " with a score of " + max.getKey()
						+ " at index " + max.getIndex());
				break;
			case 7:
				System.out.println("Order of URLs: ");
				BinarySearchTree.inOrder(keywordNodes.get(0));
				System.out.println("What would you like to find the sucessor of? Please enter its score");
				int success = in.nextInt();
				BinarySearchTree.Node findS = BinarySearchTree.Search(keywordNodes.get(0), success);
				BinarySearchTree.Node successsor = BinarySearchTree.Successor(findS);

				System.out.println("The successor is " + successsor.getURL() + " at index" + successsor.getIndex()
						+ " with a score of " + successsor.getKey());
				break;
			default:
				System.out.println("Sorry, that was the wrong input.");
			}
			break;
		case 3:
			System.out.println("How many would you like to see? (Max is 30) ");
			int amount = in.nextInt();

			Keyword[] newK = new Keyword[k.size()];
			for (int i = 0; i < k.size(); i++) {
				newK[i] = k.get(i);
			}

			BucketSort.bucketS(newK);
			System.out.println("Top " + amount + " URLS Sorted By Score: ");
			BucketSort.printArrayB(newK, amount);
			break;
		default:
			System.out.println("Sorry, that was the wrong input.");
		}
		// end of switch
	}
}