import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class WordGuess {
    private static final String[] WORDS = {"java", "hangman", "programming", "computer", "keyboard", "developer"}; // an array list called WORDS that contains the possible words to guess
    private static final int MAX_TRIES = 6; // maximum number of incorrect guesses allowed

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Select a random word
        String word = WORDS[random.nextInt(WORDS.length)]; // randomly selects a word from the WORDS array
        char[] hiddenWord = new char[word.length()]; // creates a char array to represent the hidden word
        Arrays.fill(hiddenWord, '_'); // fills the hidden word array with underscores

        int triesLeft = MAX_TRIES; 
        boolean wordGuessed = false; 

        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the word: " + String.valueOf(hiddenWord));

        while (triesLeft > 0 && !wordGuessed) { // as long as there are tries left and the word hasn't been guessed, keep looping
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            boolean correctGuess = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess && hiddenWord[i] == '_') { // if the guessed letter is in the word, reveal the letter and its position
                    hiddenWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                triesLeft--;
                System.out.println("Incorrect guess! Tries left: " + triesLeft);
            }

            System.out.println("Current word: " + String.valueOf(hiddenWord));

            if (String.valueOf(hiddenWord).equals(word)) { // checks if the hidden word matches the actual word
                wordGuessed = true;
                System.out.println("Congratulations! You guessed the word: " + word);
            }
        }

        if (!wordGuessed) {
            System.out.println("Game over! The word was: " + word);
        }

        scanner.close();
    }
}
