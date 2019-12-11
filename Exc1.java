import java.util.Random;
import java.util.Scanner;

public class Exc1 {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner in = new Scanner(System.in);
		int num = rand.nextInt();
		System.out.print("Guess a number: ");
		int guess = 0;
		try{
			guess = in.nextInt();
		} catch (Exception e) {
			System.out.println("That wasn't a number!");
		}
			
		int count = 1;
		while (Math.abs(num-guess)>10 && count<5) {
			count++;
			System.out.print("Try again: ");
			try{
				guess = in.nextInt();
			} catch (Exception e) {
				System.out.println("That wasn't a number!");
			}
		}
		if (Math.abs(num-guess) <= 10)
			System.out.println("You win... the answer was "+num);
		else 
			System.out.println("Sorry!!!!!");
	}

}
