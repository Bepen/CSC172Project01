
/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Project 1 - Master Mind
bneupane@u.rochester.edu
*/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String restart = "y";
		String correctCodeGuess = "n";
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Master Mind where you will think of a code and I, the computer, will guess it.");
		System.out.println("You can enter any amount of tokens you want but keep in mind, the runtime will suffer.");

		while (restart.equals("y")) { // if the user wants to continue playing after the game ends, this will run. It will initially run because it is initialized as "y"
			System.out.print("What tokens will you be using this game (please separate the tokens with a space)? ");
			String tokens = scan.nextLine();
			String[] tokenArray = tokens.split(" "); // puts the inputted tokens in an array, separated by spaces
			System.out.print("How many of those tokens will you be using (up to six)? ");
			int positions = scan.nextInt();
			mm MasterMind = new mm(tokenArray, positions); //creates an instance
			MasterMind.newGame(tokenArray, positions); //fills up a list with arrays of possible combinations of the code
			while (!MasterMind.win) {
				MasterMind.printArray(MasterMind.nextMove()); //prints the first array
				System.out.print("Was that your secret code (y/n)? ");
				correctCodeGuess = scan.next();
				scan.nextLine();
				if (correctCodeGuess.equals("y")) { //if the array is correct, the game ends
					System.out.println("I have won!");
					break;
				}
				System.out.print("How many tokens are the right token and the right position? ");
				int rightColorRightPosition = scan.nextInt();
				System.out.print("How many tokens are the right token but are in the wrong position? ");
				int rightColorWrongPosition = scan.nextInt();
				scan.nextLine();
				MasterMind.response(rightColorWrongPosition, rightColorRightPosition); // arrays will be eliminated based on whether or not they are a possibility
				MasterMind.removeFirstArray(); // removes the first array since the user said the code is not the first array
			}
			System.out.print("Would you like to play again? (y/n): ");
			restart = scan.next();
			scan.nextLine();
			System.out.println();
			if (restart.equals("n")) { // if the user doesn't want to play again, the program ends
				System.out.println("Thanks for playing!");
			}
		}
		scan.close();
	}
}
