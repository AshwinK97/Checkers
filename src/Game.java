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

	/*
	* colChoice is initialized in the main method as either 0 or 1
	* colChoice determines which player is red or black
	*/

	public Game(String name1, String name2, int colChoice) {
		gameBoard = new Board();
		if (colChoice == 0) {
			player1 = new Player(name1, "Red");
			player2 = new Player(name2, "Black");
		} else {
			player1 = new Player(name1, "Black");
			player2 = new Player(name2, "Red");
		}
		draw();
	}

	/*
	* Show the board
	*/

	public static void draw() {
		clear();
		System.out.println("Player1: " + player1.getName() + " - " + player1.getColour() + ".");
		System.out.println("Player2: " + player2.getName() + " - " + player2.getColour() + ".");
		prompt();
	}

	/*
	* Title Screen before game starts
	* will contain a text-art checkers crown
	*/

	public static void title() {
		System.out.println("-- Welcome to chess --");
		System.out.println("----------------------");
		System.out.println(""); // 
		System.out.println("");
		System.out.println("");
		System.out.println("");
		prompt();
	}


	/*
	* clear 50 lines on the screen
	*/

	public static void clear() {
		for (int i=0; i<50; i++)
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
	* 1) setup player names and colors
	*/

	public static void main(String args[]) {
		title();

		System.out.println("Enter player 1: ");
		String name1 = in.nextLine();
		System.out.println("Enter player 2: ");
		String name2 = in.nextLine();

		int colChoice = rand.nextInt(2); // random number betweeon 0 - 1

		Game game = new Game(name1, name2, colChoice);
	}
}