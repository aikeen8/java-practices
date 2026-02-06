import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class WordGuess {
    private static final String[] WORDS = {"java", "hangman", "programming", "computer", "keyboard", "developer"};
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Select a random word
        String word = WORDS[random.nextInt(WORDS.length)];
        char[] hiddenWord = new char[word.length()];
        Arrays.fill(hiddenWord, '_');

        int triesLeft = MAX_TRIES;
        boolean wordGuessed = false;

        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the word: " + String.valueOf(hiddenWord));

        while (triesLeft > 0 && !wordGuessed) {
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            boolean correctGuess = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess && hiddenWord[i] == '_') {
                    hiddenWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                triesLeft--;
                System.out.println("Incorrect guess! Tries left: " + triesLeft);
            }

            System.out.println("Current word: " + String.valueOf(hiddenWord));

            if (String.valueOf(hiddenWord).equals(word)) {
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
