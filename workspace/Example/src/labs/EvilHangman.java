package labs;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * In Evil Hangman, the computer maintains a list of every word in the
 * English language, then continuously pares down the word list to try
 * to dodge the player's guesses as much as possible.
 *
 * Details here:
 * http://nifty.stanford.edu/2011/schwarz-evil-hangman/Evil_Hangman.pdf
 */
public class EvilHangman extends Hangman {
	private int numGuesses;
	protected List<String> masterList;
	private Random random;
	EvilHangman(int wordLength, int guesses) throws FileNotFoundException {
		super();
		File file = new File("resources/dictionary.txt");
		FileReader reader = new FileReader(file);
		Scanner scanner = new Scanner(reader);
		// TODO: build up a data structure here
		masterList = new ArrayList<String>();		
		while (scanner.hasNextLine()) {
		String word = scanner.nextLine();
		if(word.length() == wordLength)
		{
			masterList.add(word);
		}
		}
		random = new Random();
		super.setWord(masterList.get(random.nextInt(masterList.size())));
		this.numGuesses = guesses;
	}
	// TODO: extend existing methods to be evil
	//word length is 1 - 29
	public boolean makeGuess(char letter){
		Map<Set<Integer>, Set<String>> familyMap = new HashMap<>();
		for(String word:masterList)
		{
			Set<Integer> position = new HashSet<Integer>();
			for(int i = 0; i < word.length(); i++)
			{
				if(word.charAt(i)==letter)
				{
					position.add(i);
				}
			}
			if(!familyMap.containsKey(position))
			{
				familyMap.put(new HashSet<>(position), new HashSet<>());
			}
			familyMap.get(position).add(word);
			
		}
		Set<Integer> biggestFamily = new HashSet<>();
		int biggestFamilySize = 0;
		for(Set<Integer> position:familyMap.keySet()){
			if(familyMap.get(position).size() > biggestFamilySize)
			{
				biggestFamilySize = familyMap.get(position).size();
				biggestFamily = position;
			}
		}
		masterList = new ArrayList<>(familyMap.get(biggestFamily));
		super.setWord(masterList.get(random.nextInt(masterList.size())));
		return super.makeGuess(letter);
	}
	public int guessesRemaining() {
		return numGuesses - (guesses.size() - correct.size());
	}
}
