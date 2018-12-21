/**
 * Generic linked list used by WuBook simulator
 * 
 * @param <V>
 *            the generic parameter
 */
public class FriendLinkedList<V> {
	/**
	 * Generic node class used by the FriendLinkedList<V> class
	 * 
	 * @param <V>
	 *            the generic parameter
	 */
	public static class LLNode<V> {
		private V key;
		private LLNode<V> next;
		private LLNode<V> prev;;

		/**
		 * Constructor of generic node class
		 * 
		 * @param key
		 *            the key of the node
		 */
		public LLNode(V key) {
			this.key = key;
		}

		/**
		 * Returns the next node in the linked list from the current one
		 * 
		 * @return next
		 */
		public LLNode<V> getNext() {
			return next;
		}

		/**
		 * Sets the given node as the current node's next
		 * 
		 * @param n
		 *            the new next node
		 */
		public void setNext(LLNode<V> n) {
			next = n;
		}

		/**
		 * Return the previous node in the linked list from the current one
		 * 
		 * @return prev
		 */
		public LLNode<V> getPrev() {
			return prev;
		}

		/**
		 * Sets the given node has the current node's previous
		 * 
		 * @param p
		 *            the new previous node
		 */
		public void setPrev(LLNode<V> p) {
			prev = p;
		}

		/**
		 * Returns the key of the generic node
		 * 
		 * @return key
		 */
		public V getKey() {
			return key;
		}

	}

	protected LLNode<V> head, tail;

	public FriendLinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Returns the head of the linked list
	 * 
	 * @return head
	 */
	public LLNode<V> getHead() {
		return head;
	}

	/**
	 * Sets the given node as the new head of the linked list
	 * 
	 * @param h
	 *            the head node
	 */
	public void setHead(LLNode<V> h) {
		head = h;
	}

	/**
	 * Returns the tail of the linked list
	 * 
	 * @return tail
	 */
	public LLNode<V> getTail() {
		return tail;
	}

	/**
	 * Sets the given node as the new tail of the linked list
	 * 
	 * @param t
	 *            the tail node
	 */
	public void setTail(LLNode<V> t) {
		tail = t;
	}

	/**
	 * Adds the given node into the given linked list
	 * 
	 * @param L
	 *            the linked list
	 * @param x
	 *            the node
	 */
	public void addFriend(FriendLinkedList<V> L, LLNode<V> x) {
		x.next = L.head;
		if (L.head != null) {
			L.head.prev = x;
		}
		L.head = x;
		x.prev = null;
	}

	/**
	 * Searches for the node inside the given linked list given the key
	 * 
	 * @param L
	 *            the linked list
	 * @param k
	 *            the key
	 * @return the node with the key or the last node in the list if not found
	 */
	public LLNode<V> listSearch(FriendLinkedList<V> L, V k) {
		LLNode<V> x = L.head;
		while (x != null && x.key != k) {
			x = x.next;
		}
			return x;
	}

	/**
	 * Deletes the given node from the given linked list
	 * 
	 * @param L
	 *            the linked list
	 * @param x
	 *            the node
	 */
	public void listDelete(FriendLinkedList<V> L, LLNode<V> x) {
		if (x.prev != null) {
			x.prev.next = x.next;
		} else {
			L.head = x.next;
		}
		if (x.next != null) {
			x.next.prev = x.prev;
		}
	}
	
	public String printList(FriendLinkedList<V> L) {
		String result = ""; 
		LLNode<V> current = L.head; 
		while (current.getNext() != null) {
			current = current.getNext(); 
			result = current.key + " "; 
		}
		return "Friends list: " + result; 
	}
}
