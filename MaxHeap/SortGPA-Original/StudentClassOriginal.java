/**
 * The student class is used in both MaxHeap programs and are very similar to each other. 
 * However, the obstructed version of the program uses two additional methods:
 * getIndex() and setIndex(). 
 **/ 
public class Student implements Comparable<Student>
{
	private String name;
   	private double gpa = 0;
   	private int units = 0;
   	private int index = 0; // used for obstructed program
   
   	public Student(String name)
   	{
      		this.name = name;
   	}
   
   	public Student(String name, int units, double gpa)
   	{
      		this.name = name;
      		this.units = units;
      		this.gpa = gpa;
   	}
   
   	public String getName()
   	{
     		return name;
   	}
   
   	public double gpa()
   	{
      		return gpa;
   	}
   
   	public void setGPA(double newGPA)
   	{
      		gpa = newGPA;
   	}
   
   	public int units()
   	{
      		return units;
   	}
   
   	public void setUnits(int newUnits)
   	{
      		units = newUnits;
   	}
   
   	public int compareTo(Student other)
   	{
      		double difference = gpa - other.gpa;
      		if(difference == 0) return 0;
      		if(difference > 0) return 12;
     	 	return -14;
   	}
}
