# MaxHeap Assignment for Data Structure Class (CS 146)
As a way to explore MaxHeaps, a MaxHeap program is created to sort students by their GPA. The MaxHeap uses the Student class; the Student class requires the name of the student (given as a String), the student's units (given as an int), and the student's GPA (given as a double). 
## About the Assignment
There are two version of the program: an orignal and an obstruct. The purpose of both codes is to create a heap that organizes students by GPA; however, the codes differ from one another. The code should add students to the MaxHeap and be able to alter the student's GPA- the MaxHeap should adjust itself depending on what is being added or altered). For both versions, two methods are made by hand in the MaxHeap while the other methods are given and/or altered. For the original version of the Student class, nothing in the class is altered. For the obstructed version of the Student class, two additional methods are created instead. Both versions require any changes to first see if the node needs to move up the MaxHeap and then if it needs to move down. 
### Original MaxHeap and Student Class
The first is able to organize the heap but is not efficient when it comes to changing the GPA. In order to do this without breaking abstraction, the method indexOf(int n) is used. This method finds the index needed in linear time.  
### Obstructed MaxHeap
The second, on the other hand, is efficient but breaks abstraction as it shows the placement of the students. This is done by the added Student methods getIndex() and setIndex(int index). Unlike the original, this gets the index of the student in constant time instead. 
## The Takeaway
Both programs show how MaxHeap works and how it can be applied. The two versions also show the costs and benefits of writing a program that maintains abstraction versus code that is fast. 
