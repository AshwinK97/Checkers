import java.util.Scanner;

class Game {

	Board gameBoard;
	Player player1, player2;
	static Scanner in = new Scanner(System.in);

	public Game(String name1, String name2) {
		gameBoard = new Board();
		player1 = new Player(name1);
		player2 = new Player(name2);
		draw();
	}

	public void draw() {
		System.out.println(player1.getName());
		System.out.println(player2.getName());
	}

	public static void main(String args[]) {
		System.out.println("Welcome to chess");
		System.out.println("Enter player 1: ");
		String name1 = in.nextLine();
		System.out.println("Enter player 2: ");
		String name2 = in.nextLine();

		Game game = new Game(name1, name2);
	}
}