import java.awt.Color;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import java.util.Random;

/**
 * Simulator that runs the methods
 */

public class RBTestSimulator {

	public static void main(String[] args) {
		Spider spider = new Spider();
		spider.search("https://trends.google.com/trends/trendingsearches/daily?geo=US");
		spider.getPages();

		List<String> list = new ArrayList<String>(spider.getPages());
		ArrayList<Link> l = new ArrayList<Link>();

		Random rand = new Random();
		int n = rand.nextInt(10) + 1;
		int m = rand.nextInt(10) + 1;
		int o = rand.nextInt(10) + 1;
		int p = rand.nextInt(10) + 1;
		for (int i = 0; i < spider.getPages().size(); i++) {
			l.add(new Link(spider.getList().get(i), n, m, o, p));
			l.get(i).setIndex(i);
			n = rand.nextInt(10) + 1;
			m = rand.nextInt(10) + 1;
			o = rand.nextInt(10) + 1;
			p = rand.nextInt(10) + 1;
		}

		// assign initial ranking
		System.out.println("Assigning Rank");
		QuickSortForRank.quickS(l, 0, l.size() - 1);
		QuickSortForRank.assignRankQ(l);

		Scanner in = new Scanner(System.in);
		Scanner out = new Scanner(System.in);

		System.out.println("Adding to RB tree");
		ArrayList<RedBlackTree.Node> linkNodes = new ArrayList<>();
		RedBlackTree s = new RedBlackTree();
		for (int i = 0; i < l.size(); i++) {
			linkNodes.add(RedBlackTree.Node.linkToNode(l.get(i).getL(), l.get(i).getScore()));
			linkNodes.get(i).setIndex(i);
			linkNodes.get(i).setRank(l.get(i).getRank());
			RedBlackTree.Insert(s, linkNodes.get(i));
			System.out.println(linkNodes.get(i).getURL() + " " + linkNodes.get(i).getKey());
		}
		System.out.println("In order: ");
		RedBlackTree.inOrder(linkNodes.get(0));
		// Display the menu

		while (true) {
			System.out.println("Please Enter Your Choice: ");
			System.out.println("1\t Add a URL");
			System.out.println("2\t Remove a URL");
			System.out.println("3\t Sort Inorder");
			System.out.println("4\t Find a URL"); // returns both search and iterative_search methods
			System.out.println("5\t Return the URL with the smallest score");
			System.out.println("6\t Return the URL with the biggest score");
			System.out.println("7\t Return the successor of a URL");

			// Get user's choice
			int choice = in.nextInt();

			// Display the title of the chosen module
			switch (choice) {
			// INSERTION
			case 1:
				System.out.println("Current Order of URLs: ");
				RedBlackTree.inOrder(linkNodes.get(0));

				System.out.println("What would you like to input. Please enter its url, then ENTER, then the score");
				String newURL = out.nextLine();
				int newScore = in.nextInt();

				System.out.println("You have added " + newURL + " with a score of " + newScore);

				RedBlackTree.Node addThis = new RedBlackTree.Node(newURL, newScore);
				linkNodes.add(addThis);

				addThis.setIndex(linkNodes.size() - 1);
				RedBlackTree.Insert(s, addThis);

				// reassign indices
				InsertionSortForRank.insertS(linkNodes);
				InsertionSortForRank.assignRankI(linkNodes);

				System.out.println("New order of URLS: ");
				RedBlackTree.inOrder(linkNodes.get(0));
				break;
			// DELETION
			case 2:
				System.out.println("Current Order of URLs: ");
				RedBlackTree.inOrder(linkNodes.get(0));

				System.out.println("What would you like to delete?  Please enter its score");
				int removeScore = in.nextInt();

				System.out.println("You want to delete the URL with a score of " + removeScore);

				RedBlackTree.Node findThis = RedBlackTree.Search(linkNodes.get(0), removeScore);
				System.out.println(findThis.getURL());

				RedBlackTree.Delete(s, findThis);
				linkNodes.remove(linkNodes.indexOf(findThis));

				// reassign indices
				InsertionSortForRank.insertS(linkNodes);
				InsertionSortForRank.assignRankI(linkNodes);

				System.out.println("New Order of URLs: ");
				RedBlackTree.inOrder(linkNodes.get(0));
				break;
			// IN-ORDER
			case 3:
				System.out.println("Order of URLs: ");
				RedBlackTree.inOrder(linkNodes.get(0));
				break;
			// FIND URL GIVEN SCORE
			case 4:
				System.out.println("List of URLs: ");
				RedBlackTree.inOrder(linkNodes.get(0));
				System.out.println("What score would you like to find or try to find?");
				int find = in.nextInt();
				RedBlackTree.Node regularSearch = RedBlackTree.Search(linkNodes.get(0), find);
				RedBlackTree.Node iterativeSearch = RedBlackTree.Iterative_Search(linkNodes.get(0), find);

				System.out.println("Our results found this:");
				System.out.println("Regular search: " + regularSearch.getURL() + " at index " + regularSearch.getIndex()
						+ "with the color " + regularSearch.getColor());
				System.out.println("Iterative search: " + iterativeSearch.getURL() + " at index "
						+ iterativeSearch.getIndex() + "with the color " + iterativeSearch.getColor());
				break;
			// FIND MINIMUM
			case 5:
				System.out.println("URLs: ");
				RedBlackTree.inOrder(linkNodes.get(0));
				RedBlackTree.Node mini = RedBlackTree.Minimum(linkNodes.get(0));
				String color = "";
				if (mini.c == Color.RED) {
					color = "red";
				} else {
					color = "black";
				}
				System.out.println("The smallest score is " + mini.getURL() + " with a score of " + mini.getKey()
						+ " at index " + mini.getIndex() + " with a color of " + color);
				break;
			// FIND MAXIMUM
			case 6:
				System.out.println("URLs: ");
				RedBlackTree.inOrder(linkNodes.get(0));
				RedBlackTree.Node max = RedBlackTree.Maximum(linkNodes.get(0));

				if (max.c == Color.RED) {
					color = "red";
				} else {
					color = "black";
				}
				System.out.println("The largest score is " + max.getURL() + " with a score of " + max.getKey()
						+ " at index " + max.getIndex() + " with a color of " + color);
				break;
			// FIND SUCCESSOR
			case 7:
				System.out.println("Order of URLs: ");
				RedBlackTree.inOrder(linkNodes.get(0));
				System.out.println("What would you like to find the sucessor of? Please enter its score: ");
				int success = in.nextInt();
				RedBlackTree.Node findS = RedBlackTree.Search(linkNodes.get(0), success);
				RedBlackTree.Node successor = RedBlackTree.Successor(findS);

				if (successor.c == Color.RED) {
					color = "red";
				} else {
					color = "black";
				}
				System.out.println("The successor is " + successor.getURL() + " at index" + successor.getIndex()
						+ " with a score of " + successor.getKey() + " and the color of" + color);
				break;
			default:
				System.out.println("Sorry, that was the wrong input.");
			}
			// end of switch
		}
	}
}