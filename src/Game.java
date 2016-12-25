/**
 * Text based checkers game
 * Author: Fidel Stalin, SentouSlayWalrus, Kotsauce
 */

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

class Game {

    private static Board gameBoard;
    private static Player[] players;
    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();

    String letters[] = { "a", "b", "c", "d", "e", "f", "g", "h" };
    HashMap<String, Integer> charInts;
    private boolean isPlaying;

    /*
     * colChoice is initialized in the main method as either 0 or 1 colChoice
     * determines which player is red or black
     */

    public Game(String name1, String name2, String col1, String col2) {
        gameBoard = new Board();
        players = new Player[2];
        players[0] = new Player(name1, col1);
        players[1] = new Player(name2, col2);

        isPlaying = true;
        playerInfo(); // show player information
        loadCharInts(); // load coordinate dictionary
        play(); // start game loop
    }

    /*
     * This is the main game loop will loop as long as isPlaying is true will
     * take commands from user
     */

    public void play() {
        String currentPlayer, from = "", to = "", buffer = "";
        while (isPlaying) {
            for (int i = 0; i < players.length; i++) {
                do { // check if user input is valid before proceeding
                	// clear(); // uncomment this once finished
                	players[0].displayScore(); // show player 1 score
                	gameBoard.displayBoard(); // show board before
                	players[1].displayScore(); // show player 2 score
                    System.out.println();
                    System.out.print(players[i].getName() + " [" + players[i].getSymbol() + "]" + " select a piece: ");
                    buffer = in.nextLine();
                    if (checkSpecialCommands(buffer)) // check for special commands
                    	continue;
                    from = buffer;
                    System.out.print(players[i].getName() + " [" + players[i].getSymbol() + "]" + " select a location: ");
                    buffer = in.nextLine();
                    if (checkSpecialCommands(buffer)) // check for special commands
                    	continue;
                    to = buffer;
                } while (!parseCommand(from + to, players[i].getSymbol()) && isPlaying);
                if (!isPlaying)
                	break;
            }
        }
    }

    /*
     * checks if movement command is valid or not if valid, parses and sends
     * commands to gameBoard returns true if successful
     * movePiece returns either
     	-1: for an invalid input
         0: for move
         1: single jump
     */

    public boolean parseCommand(String command, String colour) {
    	int moveResult = 0;
        if (command.length() == 4 &&
        	charInts.containsKey(command.substring(0, 1)) &&
        	charInts.containsKey(command.substring(2, 3)) &&
        	Integer.parseInt(command.substring(1, 2)) >= 0 &&
        	Integer.parseInt(command.substring(1, 2)) <= 7 &&
        	Integer.parseInt(command.substring(3, 4)) >= 0 &&
        	Integer.parseInt(command.substring(3, 4)) <= 7) {

            moveResult = gameBoard.movePiece(
            	charInts.get(command.substring(0, 1)),
            	Integer.parseInt(command.substring(1, 2)),
            	charInts.get(command.substring(2, 3)),
            	Integer.parseInt(command.substring(3, 4)),
            	colour);

            if (moveResult == -1) {
            	System.out.println(" <invalid input> ");
        		return false;
            }

            if (players[0].getSymbol().equals(colour))
            	players[0].addScore(moveResult);
            else
            	players[1].addScore(moveResult);

            return true;
        }
        System.out.println(" <invalid input> ");
        return false;
    }

    /*
    * takes commands user enteres while playing.
    * checks for special commands like 'help' and 'exit'.
    */

    public boolean checkSpecialCommands(String command) {
    	if (command.toLowerCase().equals("exit")) {
    		isPlaying = false;
    		return true;
    	} else if (command.toLowerCase().equals("help")) {
    		instructions();
    		return true;
    	}
    	return false;
    }

    /*
    * creates a dictionary of String, Integer pairs.
    * dictionary is used to convert letter coordinates
    * to number indexes on the board array.
    */

    public void loadCharInts() {
        charInts = new HashMap<String, Integer>();
        for (int i = 0; i < 8; i++)
            charInts.put(letters[i], i);
    }

    /*
     * test method for showing player information
     */

    public static void playerInfo() {
        clear();
        for (int i = 0; i < players.length; i++)
            System.out.println("Player " + (i + 1) + ": " +
             players[i].getName() + " - " +
             players[i].getColour() + " (" +
             players[i].getSymbol() + ").");
        prompt();
        clear();
    }

    /*
    * Show instructions before game starts or whenever a player enters 'help'
    */
    public static void instructions() {
    	clear();
        System.out.println(" <instructions go here>");
        prompt();
        clear();
    }

    /*
     * Title Screen before game starts contains text-art checkers crown
     */

    public static void intro() {
        clear();
        System.out.println("------- CHECKERS -------");
        System.out.println("------------------------");
        System.out.println("                        ");
        System.out.println("* ** ** ** ** ** ** ** *");
        System.out.println(" \\/\\ /\\ /\\ /\\ /\\ /\\ /\\/ ");
        System.out.println("  \\                  /  ");
        System.out.println("   \\                /   ");
        System.out.println("    \\              /    ");
        System.out.println("     **************     ");
        prompt();
        clear();
    }

    /*
     * Exit screen after game ends
     */

    public static void outro() {
        clear();
        System.out.println("Thankyou for playing!");
        prompt();
    }

    /*
     * clear 50 lines on the screen
     */

    public static void clear() {
        for (int i = 0; i < 35; i++)
            System.out.println();
    }

    /*
     * wait and prompt user to press enter before continuing
     */

    public static void prompt() {
    	System.out.println();
        System.out.println(" <enter to continue> ");
        in.nextLine();
    }

    /*
     * - play intro - setup player names and colors - create instance of game
     */

    public static void main(String args[]) {
        // play intro
        intro();

        // show instructions
        instructions();

        // let players enter their names
        System.out.print("Enter player 1: ");
        String name1 = in.nextLine();
        clear();
        System.out.print("Enter player 2: ");
        String name2 = in.nextLine();
        clear();

        // pick cplayer colors and initialize game
        int colChoice = rand.nextInt(2); // random number betweeon 0 - 1
        Game game;
        if (colChoice == 0)
            game = new Game(name1, name2, "red", "black");
        else
            game = new Game(name1, name2, "black", "red");

        outro(); // play outro
    }
}
