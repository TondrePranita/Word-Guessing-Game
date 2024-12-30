import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] words = {"java","programming","code","computer","methods","objects"};
        WordGuessingGame game;
        Scanner sc = new Scanner(System.in);

        boolean shouldPlayAgain = false;
        int wins = 0;
        int losses = 0;

        do {
            game = new WordGuessingGame(words, 2);
            String result = game.play();

            if(result.equals("Won")) {
                wins += 1;
            } else {
                losses += 1;
            }

            System.out.println("Wins: "+wins+", Losses: "+losses);

            System.out.print("Would you like to play again? (y/n): ");
            char playAgain = sc.nextLine().toLowerCase().charAt(0);

            shouldPlayAgain = playAgain == 'y';
        } while(shouldPlayAgain);

        System.out.println("Thanks for playing! Final score: Wins: " + wins + ", Losses: " + losses);
    }
}
