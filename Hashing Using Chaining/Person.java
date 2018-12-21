/**
 * Person class used by the simulator
 */
public class Person {
	private String name;
	private FriendLinkedList<Person> friends;

	public Person(String name, FriendLinkedList<Person> friends) {
		this.name = name;
		this.friends = friends;
	}

	/**
	 * Returns the name of the person
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the person as the given name
	 * @param n the given name
	 */
	public void setName(String n) {
		name = n;
	}
	
	/**
	 * Returns the list of friends
	 * @return
	 */
	public FriendLinkedList<Person> getFriends() {
		return friends; 
	}
}
