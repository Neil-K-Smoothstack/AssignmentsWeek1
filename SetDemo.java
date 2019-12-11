package Day2;

import java.util.*;

public class SetDemo { 
	public static void main( String [] args ) {  
		
		// Create a set called mySet
		Set<String> mySet = new HashSet<String>();  
		
		// Ensure that this set contains an interesting selection of fruit 
		String fruit1 = "pear", fruit2 = "banana", fruit3 = "tangerine", fruit4 = "strawberry", fruit5 = "blackberry";
		mySet.add( fruit1 );
		mySet.add( fruit2 );
		mySet.add( fruit3 );
		mySet.add( fruit2 );
		mySet.add( fruit4 );
		mySet.add( fruit5 );  
		
		// Display contents of mySet
		System.out.println("mySet now contains: ");
		System.out.println(mySet); 
		System.out.println("meSet contains "+mySet.size()+" elements.");
		mySet.remove("blackberry");
		mySet.remove("strawberry");
		System.out.println("mySet now contains: ");
		System.out.println(mySet);
		mySet.clear();
		if(mySet.isEmpty())
			System.out.println("mySet is now empty!");
		else
			System.out.println("mySet still has stuff in it");
	}
}
