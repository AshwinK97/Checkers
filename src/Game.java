/**
* Text based checkers game
* Author: Fidel Stalin, SentouSlayWalrus, Kotsauce
*/

import java.util.Scanner;
import java.util.Random;

class Game {

	private static Board gameBoard;
	private static Player player1, player2;
	static Scanner in = new Scanner(System.in);
	static Random rand = new Random();

	private boolean isPlaying;

	/*
	* colChoice is initialized in the main method as either 0 or 1
	* colChoice determines which player is red or black
	*/

	public Game(String name1, String name2, int colChoice) {
		gameBoard = new Board();
		if (colChoice == 0) {
			player1 = new Player(name1, "red");
			player2 = new Player(name2, "black");
		} else {
			player1 = new Player(name1, "black");
			player2 = new Player(name2, "red");
		}
		isPlaying = true;
		playerInfo();
		play();
	}

	/*
	* This is the main game loop
	* will loop as long as isPlaying is true
	* will take movement commands from player
	*/

	public void play() {
		String currentPlayer, command;
		while(isPlaying) {
			game.displayBoard();
			System.out.print("Player1 move: ");
			command = in.nextLine();
			if (command.equals("exit")) {
				isPlaying = false;
			}
		}
	}

	public boolean parseCommand(String command) {

	}

	/*
	* test method for showing player information
	*/

	public static void playerInfo() {
		clear();
		System.out.println("Player1: " + player1.getName() + " - " + player1.getColour() 
			+ " ( " + player1.getSymbol + ").");
		System.out.println("Player2: " + player2.getName() + " - " + player2.getColour() 
			+ " ( " + player2.getSymbol + ").");
		prompt();
	}

	public void instructions() {

	}

	/*
	* Title Screen before game starts
	* contains text-art checkers crown
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
		for (int i=0; i<35; i++)
			System.out.println();
	}

	/*
	* wait and prompt user to press enter before continuing
	*/

	public static void prompt() {
		System.out.println(" <enter to continue> ");
		in.nextLine();
	}

	/*
	* main method
	* 
	* - play intro
	* - setup player names and colors
	* - create instance of game
	*/

	public static void main(String args[]) {
		intro();
		System.out.print("Enter player 1: ");
		String name1 = in.nextLine();
		clear();
		System.out.print("Enter player 2: ");
		String name2 = in.nextLine();
		clear();
		int colChoice = rand.nextInt(2); // random number betweeon 0 - 1
		Game game = new Game(name1, name2, colChoice); // initialize game
		outro();
	}
}