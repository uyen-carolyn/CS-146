import java.util.Scanner;

public class WuBookSimulator {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		FriendLinkedList<Person> amyFriends = new FriendLinkedList<Person>();
		FriendLinkedList<Person> choFriends = new FriendLinkedList<Person>();
		FriendLinkedList<Person> hudaFriends = new FriendLinkedList<Person>();
		FriendLinkedList<Person> kristFriends = new FriendLinkedList<Person>();
		FriendLinkedList<Person> sheiFriends = new FriendLinkedList<Person>();
		FriendLinkedList<Person> laurenFriends = new FriendLinkedList<Person>();
		
		Person amy = new Person("Amy", amyFriends); 
		Person cho = new Person("Cho", choFriends); 
		Person huda = new Person("Huda", hudaFriends); 
		Person krist = new Person("Krist", kristFriends); 
		Person shei = new Person("Shei", sheiFriends); 
		Person lauren = new Person("Lauren", laurenFriends); 
		
		FriendLinkedList.LLNode<Person> a = new FriendLinkedList.LLNode(amy.getName());		
		FriendLinkedList.LLNode<Person> c = new FriendLinkedList.LLNode(cho.getName());	
		FriendLinkedList.LLNode<Person> h = new FriendLinkedList.LLNode(huda.getName());		
		FriendLinkedList.LLNode<Person> k = new FriendLinkedList.LLNode(krist.getName());		
		FriendLinkedList.LLNode<Person> s = new FriendLinkedList.LLNode(shei.getName());	
		FriendLinkedList.LLNode<Person> l = new FriendLinkedList.LLNode(lauren.getName());
		
		
		amyFriends.addFriend(amyFriends, c);
		amyFriends.addFriend(amyFriends, h);
		amyFriends.addFriend(amyFriends, k);
		
		choFriends.addFriend(choFriends, s);
		choFriends.addFriend(choFriends, h);
		choFriends.addFriend(choFriends, k);
		choFriends.addFriend(choFriends, l);
		
		hudaFriends.addFriend(hudaFriends, l);
		hudaFriends.addFriend(hudaFriends, c);
		
		kristFriends.addFriend(kristFriends, a);
		kristFriends.addFriend(kristFriends, s);
		kristFriends.addFriend(kristFriends, h);
		kristFriends.addFriend(kristFriends, c);
		kristFriends.addFriend(kristFriends, l);
		
		sheiFriends.addFriend(sheiFriends, h);
		
		laurenFriends.addFriend(laurenFriends, c);
		laurenFriends.addFriend(laurenFriends, a);
		laurenFriends.addFriend(laurenFriends, s);
		
		
		
		System.out.println("Welcome to Wu-Book! A social media platform for all things Professor Wu!");
		while (true) {
			System.out.println("Please Enter Your Choice: ");
			System.out.println("1\t Add a friend");
			System.out.println("2\t Remove a friend");
			System.out.println("3\t Find a friend");
			System.out.println("4\t See if you are friends"); // returns both search and iterative_search methods
			System.out.println("5\t ");
			System.out.println("6\t ");
			System.out.println("7\t ");
			
			int choice = in.nextInt();

			switch (choice) {
			case 1: 
				break;
			case 2:
				break; 
			
			default:
				System.out.println("Sorry, that was the wrong input.");
			}
		}
	}
}
