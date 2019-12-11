package Day2;

import java.util.*;

public class Person {
	private List<Integer> grades;
	private String name;
	
	public Person(String n) {
		grades = new ArrayList<Integer>();
		name = n;
	}

	public String getName() {
		return name;
	}
	
	public void addGrade(int g) {
		grades.add((Integer)g);
	}
	
	public List<Integer> getGrades() {
		return grades;
	}
	
	public double getAvg() {
		double avg = 0.0;
		Iterator<Integer> itr = grades.iterator();
		while(itr.hasNext())
			avg += (double)itr.next();
		return avg/count();
	}
	
	public int count() {
		return grades.size();
	}
}
