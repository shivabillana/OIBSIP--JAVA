import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        
        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts = 4;

       
        int secretNumber = 1 + (int)(100* Math.random());

        
        int score = 0;
        
        
        System.out.println("A number is chosen between 1 to 100. Guess that Secretnumber within 4 trials.");
        Scanner scanner = new Scanner(System.in);
        int attempt;
        for (attempt = 1; attempt <= maxAttempts; attempt++) {
            
            int nums =  maxAttempts-attempt;
            System.out.printf("Guess #%d: ", attempt);
            int guess = scanner.nextInt();

            
            if (guess == secretNumber) {
                score = calculateScore(attempt);
                System.out.println("Congratulations! You guessed the number.");
                break;
            } else if (guess < secretNumber) {
                System.out.println("Your guess is too low.");
                System.out.println("No of attempts left are "+nums);
            } else {
                System.out.println("Your guess is too high.");
                System.out.println("No of attempts left are "+nums);
            }
        }

        
        scanner.close();
        if (score == 0) {
            System.out.println("\nSorry, you failed to guess the number.");
            System.out.println("SecretNumber was "+secretNumber);
            System.out.println("Your Score is: "+score); 
        } else {
            int num =  maxAttempts-attempt+1;
            System.out.printf("You guessed the number in %d attempts. Your score is %d.\n", num, score);
        }
    }

    private static int calculateScore(int attempt) {
        switch (attempt) {
            case 1:
                return 150;
            case 2:
                return 100;
            case 3:
                return 50;
            case 4:
                return 25;
            default:
                return 0;
        }
    }
}
