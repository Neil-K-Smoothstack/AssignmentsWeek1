package Day2;

import java.io.*;
import java.util.*;
import java.math.*;

public class Marks {

	
	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Person> peopleMap = getMap();
		Collection<Person> people = peopleMap.values();
		alphabetic(people);
		merit(people);
		System.out.println("Number of Students: "+people.size());
		System.out.println("Average student mark: "+findAvg(people));
		System.out.println("Standard deviation: "+std(people));
	}
	
	
	public static double std(Collection<Person> people) {
		double avg = findAvg(people);
		List<Double> avgs = new ArrayList<Double>();
		Iterator itr = people.iterator();
		Person temp;
		while (itr.hasNext()) {
			temp = (Person) itr.next();
			avgs.add(temp.getAvg());
		}
		itr = avgs.listIterator();
		double total = 0.0;
		while(itr.hasNext()) {
			double i = (double)itr.next();
			i -= avg;
			i *= i;
			total+=i;
		}
		total /= (avgs.size()-1);
		total = Math.sqrt(total);
		return round(total);
	}
	
	
	public static double round(double in) {
		BigDecimal bd = new BigDecimal(in).setScale(1, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	
	
	public static double findAvg(Collection<Person> people) {
		Iterator<Person> itr = people.iterator();
		double total = 0;
		while (itr.hasNext()) {
			total += itr.next().getAvg();
		}
		total /= people.size();
		return round(total);
	}
	
	
	public static void merit(Collection<Person> people) {
		System.out.println("Merit order:");
		Iterator<Person> itr = people.iterator();
		List<Double> grades = new ArrayList<Double>();
		Person temp;
		while (itr.hasNext()) {
			temp = itr.next();
			grades.add(temp.getAvg());
		}
		grades.sort(null);
		ListIterator<Double> gitr = grades.listIterator();
		while(gitr.hasNext()) {
			gitr.next();
		}
		double tempGrade;
		while(gitr.hasPrevious()) {
			tempGrade = gitr.previous();
			itr = people.iterator();
			while(itr.hasNext()) {
				temp = itr.next();
				if(temp.getAvg() == tempGrade) {
					System.out.println(temp.getName()+" "+temp.count()+" "+temp.getAvg());
				}
			}
		}
		System.out.println();
	}
	
	
	public static void alphabetic(Collection<Person> people) {
		System.out.println("Alpha Order:");
		Iterator<Person> itr = people.iterator();
		List<String> names = new ArrayList<String>();
		Person temp;
		while (itr.hasNext()) {
			temp = itr.next();
			names.add(temp.getName());
		}
		names.sort(null);
		Iterator<String> nitr = names.iterator();
		String tempName;
		while(nitr.hasNext()) {
			tempName = nitr.next();
			itr = people.iterator();
			while(itr.hasNext()) {
				temp = itr.next();
				if(temp.getName().equals(tempName)) {
					System.out.println(tempName+" "+temp.count()+" "+temp.getAvg());
				}
			}
		}
		System.out.println();
	}
	
	
	@SuppressWarnings("resource")
	public static Map<String, Person> getMap() throws FileNotFoundException{
		File file = new File("Test.txt");
		Scanner sc = new Scanner(file);
		
		Map<String, Person> people = new TreeMap<String, Person>();
		String name = "";
		int grade = 0;
		while(sc.hasNext()) {
			name = sc.next();
			grade = sc.nextInt();
			Person temp = new Person(name);
			if(people.containsKey(name)) {
				temp = people.get(name);
			}
			temp.addGrade(grade);
			people.put(name, temp);
				
		}
		return people;
	}

}
