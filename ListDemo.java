package Day2;

import java.util.*;

public class ListDemo {

	public static void main(String[] args) {
		List<String> myList = new ArrayList<String>();
		myList.add("Pear");
		myList.add("Banana");
		myList.add("Tangerine");
		myList.add("Strawberry");
		myList.add("Blackberry");
		
		Iterator<String> itr = myList.iterator();
		while(itr.hasNext())
			System.out.print(itr.next()+" ");
		System.out.println();
		
		ListIterator<String> litr = myList.listIterator();
		while(litr.hasNext())
			litr.next();
		while(litr.hasPrevious())
			System.out.print(litr.previous()+" ");
		System.out.println();
		
		for(int i=0; i<3; i++)
			litr.next();
		litr.add("Banana");
		litr = myList.listIterator();
		while(litr.hasNext())
			System.out.print(litr.next()+" ");
		
	}

}
