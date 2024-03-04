import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInterface startGame = new UserInterface();
        System.out.println("Welcome");
        startGame.userOptionsForDirections();

        while (true) {
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            input.useDelimiter("\n");
            boolean result = startGame.processUserInput(userInput);
            if (result) {
                //user input OK.
            } else {
                //User input not OK; retry
            }
            startGame.userOptionsForDirections();
        }
    }
}
