import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    private String wordToGuess;
    private char[] guessedLetters;
    private int attempts;

    public WordGuessingGame(String[] wordList, int maxAttempts) {
        Random rand = new Random();
        // picks a random word from the list of words (wordList) and save it in the wordToGuess variable
        this.wordToGuess = wordList[rand.nextInt(wordList.length)];
        // creates an empty array of characters to keep track of the player's guesses
        this.guessedLetters = new char[this.wordToGuess.length()];  
        
        for(int i=0; i<this.guessedLetters.length; i++) {
            this.guessedLetters[i] = '_';
        }
        this.attempts = maxAttempts;
    }

    public String play() {
        System.out.println("The word is: "+wordToGuess);

        Scanner sc = new Scanner(System.in);
        while (attempts > 0) {
            displayState();

            System.out.println("You have "+attempts+" attempts left...");
            System.out.println("Guess a letter: ");

            char guess = sc.nextLine().toLowerCase().charAt(0);

            if(processGuess(guess)) {
                System.out.println("Correct!");
                if(new String(guessedLetters).equals(wordToGuess)) {
                    System.out.println("You have guessed the correct word! you won!");
                    return "Won";
                }
            } else {
                System.out.println("Incorrect guess!");
                attempts--;
            }
        }
        return "Loss";
    }

    private boolean processGuess(char letter) {
        boolean letterFound = false;
        for(int i=0; i<wordToGuess.length(); i++) {
            if(wordToGuess.charAt(i) == letter) {
                guessedLetters[i] = letter;
                letterFound = true;
            }
        }
        return letterFound;
    }

    private void displayState() {
        System.out.println("Guessed Letters: "+new String(guessedLetters));
    }
} 