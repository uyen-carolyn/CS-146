import java.util.ArrayList;
import java.util.Collection;

/**
 *      Original code has the changeKey method run at linear time. In order to make
 *      it faster, data abstraction is broken by allowing the user to have access to
 *      their position in the heap. Two methods from the Student class are used:
 *      getIndex() and setIndex()
 *
 *      The purpose of this code is to compare and contrast how the changes make
 *      the changeKey method faster but sacrifices the abstraction.
 */
public class MaxHeap {
  private ArrayList students;

  public MaxHeap(int capacity) {
    students = new ArrayList < Student > (capacity);
  }

 /**
  * Because the method setIndex can change the index of the object, 
  * it is important to make sure the indexes change according to 
  * what has been changed and be sure they are in the right position. 
  * @param collection
  */
  public MaxHeap(Collection < Student > collection) {
    students = new ArrayList < Student > (collection);

    for (int i = 0; i < students.size(); i++) {
      students.get(i).setIndex(i);
    }

    for (int j = size() / 2; j >= 0; j--) {
      maxHeapify(j);
    }
  }

  public Student getMax() {
    if (size() < 1) {
      throw new IndexOutOfBoundsException("No maximum value:  the heap is empty.");
    }
    
    return students.get(0);
  }

 /**
  * The method has been altered so that getIndex and setIndex can be used
  * @return
  */
  public Student extractMax() {
    Student value = getMax();

    students.set(0, students.get(size() - 1));

    students.get(0).setIndex(0);

    students.remove(size() - 1);

    maxHeapify(0);

    return value;
  }

 /**
  * The method is used to move objects up the heap if they are bigger than the parent.
  * Both the insert and changeKey method of the original and this code 
  * use this method.
  * Method uses the swap method.
  * @param i
  */
  public void moveUp(int i) {
    Student elt = students.get(i);

    while (elt.compareTo(students.get(parent(i))) > 0) {
      swap(i, parent(i));

      i = parent(i);
    }
  }

 /** 
  * Method that was created by hand. 
  * @param elt
  */
  public void insert(Student elt) {
    students.add(elt);
    elt.setIndex(students.size() - 1);
    moveUp(students.size() - 1);
  }

 /**
  * Method that was created by hand.
  * Originally running in linear time, obstructing the abstraction allows
  * the method to run faster. 
  * @param s
  * @param newGPA
  */
  public void changeKey(Student s, double newGPA) {
    double oldGPA = s.gpa();
    int i = s.getIndex();
    s.setGPA(newGPA);

    if (s.gpa() > oldGPA) { // maybe don't need this?
      moveUp(i);
    } 
    else {
      maxHeapify(i);
    }
  }

  private int parent(int index) {
  return (index - 1) / 2;
 }

 private int left(int index) {
  return 2 * index + 1;
 }

 private int right(int index) {
  return 2 * index + 2;
 }

 private int size() {
  return students.size();
 }

 /**
  * Most of the work required to ensure that the indexes are properly
  * updated are in this method. 
  * @param from
  * @param to
  */
  private void swap(int from, int to) {
    Student val = students.get(from);
    int temp = students.get(from).getIndex();

    val.setIndex(students.get(to).getIndex());
    students.get(to).setIndex(temp);

    students.set(from, students.get(to));
    students.set(to, val);
  }

  private void maxHeapify(int index) {
    int left = left(index);
    int right = right(index);
    int largest = index;

    if (left < size() && students.get(left).compareTo(students.get(largest)) > 0) {
      largest = left;
    }

    if (right < size() && students.get(right).compareTo(students.get(largest)) > 0) {
      largest = right;
    }

    if (largest != index) {
      swap(index, largest);
      maxHeapify(largest);
    }
  }
}
