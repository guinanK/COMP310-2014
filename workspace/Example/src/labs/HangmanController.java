package labs;

import java.io.FileNotFoundException;
import java.util.Scanner;

// The console user interface
public class HangmanController {
	private static boolean showRemaining;
	private static void view(EvilHangman game) {
		System.out.format("Guesses remaining: %d\nYou used: %s\nWord: %s\n",
				game.guessesRemaining(), game.getGuesses().toString(),
				game.visible());
		if(showRemaining){
			System.out.println("Words Remaining: "+game.masterList.size());
		}
	}
	

	public static void consoleUI(EvilHangman game) {
		Scanner scanner = new Scanner(System.in);
		char letter;
		String line;
		while (!game.isOver()) {
			view(game);
			System.out.println("Enter a letter: ");
			while ((line = scanner.nextLine()).equals(""))
				;
			letter = line.charAt(0);
			while (!game.makeGuess(letter)) {
				System.out.println("Try another letter: ");
				letter = scanner.nextLine().charAt(0);
			}
		}
		if (game.won()) {
			System.out.println("Yay, you won!");
		} else {
			System.out.println("You lost! It was: " + game.getWord());
		}
	}

	// TODO: change the constructor to use EvilHangman
	public static void main(String[] args) throws FileNotFoundException {
		int guesses;
		int wordLength;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Y/N: Would you like to know remaining words?");
		showRemaining=keyboard.nextLine().equalsIgnoreCase("Y");
		System.out.println("How many guesses would you like?");
		EvilHangman game = null;
		guesses = keyboard.nextInt();
		while(true){
		try {
			System.out.println("Enter word length:");
			wordLength = keyboard.nextInt();
			game = new EvilHangman(wordLength, guesses);
			break;
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid word length please try again");
		}}
		HangmanController.consoleUI(game);
	}
}
