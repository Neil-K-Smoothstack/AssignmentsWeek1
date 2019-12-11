
import java.util.Scanner;

public class Exercise2 {

	public static String name1;
	public static String name2;
	public static int p1Chips;
	public static int p2Chips;
	public static int pile;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String again = "y";
		String pileInit = "";
		pile = Integer.MAX_VALUE;
		boolean intEntered = false;

		while (again.equalsIgnoreCase("y")) {
			System.out.print("What is the name of the first player? ");
			name1 = in.next();
			System.out.print("What is the name of the second player? ");
			name2 = in.next();
			while (name1.equalsIgnoreCase(name2)) {
				System.out.print("Both players cannot be named "+name2+". Enter a different name: ");
				name2 = in.next();
			}
			System.out.print("How many chips does the initial pile have? ");
			
			while (!intEntered) {
				intEntered = true;
				try {
					pileInit = in.next();
					pile = Integer.parseInt(pileInit);
				} catch (NumberFormatException e) {
					System.out.print("Invalid input! Try a number! ");
					intEntered = false;
				}
			}
			intEntered = false;
			while (pile<3 || pile%2==0) {
				if(pile<3) 
					System.out.print("You have to start with at least 3 chips. Choose another number: ");
				else if (pile%2==0) 
					System.out.print("You have to start with an odd number of chips. Choose another number: ");
				while (!intEntered) {
					intEntered = true;
					try {
						pileInit = in.next();
						pile = Integer.parseInt(pileInit);
					} catch (NumberFormatException e) {
						System.out.print("Invalid input! Try a number! ");
						intEntered = false;
					}
				}
				intEntered = false;			
			}
			p1Chips = 0;
			p2Chips = 0;
			int turn = 1;
			while(pile>0) {
				play(turn%2, in);
				turn++;
			}
			System.out.println(name1+" has "+p1Chips+" chips.");
			System.out.println(name2+" has "+p2Chips+" chips.");
			if(p1Chips%2==0)
				System.out.print(name1);
			else
				System.out.print(name2);
			System.out.print(" wins! Play another game? (y/n) ");
			again = in.next();
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
			
		}
		in.close();
	}
	
	public static void play(int turn, Scanner in) {
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * ");
		int max;
		int take = Integer.MAX_VALUE;
		
		String takeInit = "";
		boolean intEntered = false;
		
		if(pile>1) 
			max = pile/2;
		else
			max = 1;
		if(turn==1) { // Player1's turn
			System.out.println(name1+" has "+p1Chips+" chips.");
			System.out.println(name2+" has "+p2Chips+" chips.");
			System.out.println("It's your turn "+name1+".");
			System.out.println("There are "+pile+" chips remaining.");
			if (pile>1)
				System.out.print("You may take any number of chips from 1 to "+max+". ");
			System.out.print("How many will you take, "+name1+"? ");
			while (!intEntered) {
				intEntered = true;
				try {
					takeInit = in.next();
					take = Integer.parseInt(takeInit);
				} catch (NumberFormatException e) {
					System.out.print("Invalid input! Try a number! ");
					intEntered = false;
				}
			}
			intEntered = false;
			while(take<1 || take>max) {
				if(take<1) {
					System.out.println("Illegal move: you must take at least one chip.");
				} else {
					System.out.println("Illegal move: you may not take more than "+max+" chips.");
				}
				System.out.print("How many will you take, "+name1+"? ");
				while (!intEntered) {
					intEntered = true;
					try {
						takeInit = in.next();
						take = Integer.parseInt(takeInit);
					} catch (NumberFormatException e) {
						System.out.print("Invalid input! Try a number! ");
						intEntered = false;
					}
				}
				intEntered = false;
			}
			pile -= take;
			p1Chips += take;		
		} else { // Player2's turn
			System.out.println(name2+" has "+p2Chips+" chips.");
			System.out.println(name1+" has "+p1Chips+" chips.");
			System.out.println("It's your turn "+name2+".");
			System.out.println("There are "+pile+" chips remaining.");
			if (pile>1)
				System.out.print("You may take any number of chips from 1 to "+max+". ");
			System.out.print("How many will you take, "+name2+"? ");
			while (!intEntered) {
				intEntered = true;
				try {
					takeInit = in.next();
					take = Integer.parseInt(takeInit);
				} catch (NumberFormatException e) {
					System.out.print("Invalid input! Try a number! ");
					intEntered = false;
				}
			}
			intEntered = false;
			while(take<1 || take>max) {
				if(take<1)
					System.out.println("Illegal move: you must take at least one chip.");
				else
					System.out.println("Illegal move: you may not take more than "+max+" chips.");
				System.out.print("How many will you take, "+name2+"? ");
				while (!intEntered) {
					intEntered = true;
					try {
						takeInit = in.next();
						take = Integer.parseInt(takeInit);
					} catch (NumberFormatException e) {
						System.out.print("Invalid input! Try a number! ");
						intEntered = false;
					}
				}
				intEntered = false;
			}
			pile -= take;
			p2Chips += take;
		}
	}
}
