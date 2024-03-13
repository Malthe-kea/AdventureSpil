import java.util.Scanner;

public class UserInterface {
    //Attributes
    boolean gameIsRunning = true;
    Scanner scanner;
    AdventureController controller;
    //Constructor
    public UserInterface() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        controller = new AdventureController();
    }

    //Methods
    public void startGame() {
playGame(controller.getGamePlayer());
    }
    public void playGame(Player gamePlayer){
        String command;
        System.out.println("Welcome");
        userOptionsForDirections();
        while (gameIsRunning) {
            command = scanner.next().toLowerCase();
            switch (command) {

                case "5", "take item", "t" -> {
                    System.out.println("enter the name of the item you want to take");
                    String itemToTake = scanner.next();
                    gamePlayer.takeItemAndAddToInventory(itemToTake);
                }
                case "6", "drop", "d" -> {
                    System.out.println("enter the name of the item you want to drop");
                    String itemToDrop = scanner.next();
                    gamePlayer.dropItemInCurrentRoom(itemToDrop);
                }
                case "go north", "n" ->{;
                    controller.moveNorth("go north");
                }
                case "go west", "w" ->{
                    controller.moveWest("go west");
                }
                case "go south", "s" -> {
                    controller.moveSouth("go south");
                }
                case "go east", "e" -> {
                    controller.moveEast("go east");
                }
                case "exit" -> {
                    System.exit(0);
                }
                case "help", "h" -> {
                    System.out.println("Please write a direction if you wanna leave the room");
                }
                case "look", "l" -> {
                    System.out.println(controller.look());
                    System.out.println("Please write a direction if you wanna leave the room");
                }
                case "inventory", "inv", "i" -> {
                    if (controller.getGamePlayer().getInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else
                    controller.getGamePlayer().getInventory();
                }
                default -> System.out.println("Your input is invalid");
            }
        }
    }

    public void userOptionsForDirections() {
        System.out.println("Write 'go north' to go north");
        System.out.println("Write 'go west' to go west");
        System.out.println("Write 'go south' to go south");
        System.out.println("Write 'go east' to go east");
        System.out.println("Write 'Look' to go look around");
        System.out.println("Write 'Help' to ask for help");
        System.out.println("Write Inventory' to look up your inventory");
    }
    public String chooseDirection() {
        System.out.println("go north, west, east or south");
        scanner.nextLine();
        String userDirection = scanner.nextLine();
        userDirection = userDirection.toLowerCase();
        return userDirection;
    }

}