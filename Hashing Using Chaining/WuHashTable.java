import java.util.ArrayList;

/**
 * Hash
 *
 */
public class WuHashTable {
	ArrayList<FriendLinkedList.LLNode> bucket = new ArrayList<>();
	
	private ArrayList<FriendLinkedList.LLNode> hashArrayList; 
	private int bucketSize = 10; 
	private int arrayListSize = 0; 
	
	public WuHashTable() {
        hashArrayList = new ArrayList<>(); 

        bucketSize = 10; 
        arrayListSize = 0; 
  
        // Create empty chains 
        for (int i = 0; i < bucketSize; i++) {
        	hashArrayList.add(null); 
        }
	}
	
	public int getSize() {
		return arrayListSize;
	}
	
	public FriendLinkedList.LLNode hashSearch(WuHashTable T, FriendLinkedList.LLNode k) {
		int i = 0; 
		
	}
	public void hashInsert(WuHashTable T, Person k) {
		int i = 0; 
		while (i != m) {
			
		}
		
	}
}
