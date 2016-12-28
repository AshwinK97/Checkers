public class Score {

	private int score;
	private String name;

	public Score(String name) {
		score = 11;
		this.name = name;
	}

	public void addScore(int score) {
		this.score += score;
	}

	public int getScore() {
		return score;
	}

	public void displayScore() {
		int length = 25;
		int lineLength = length;
		String line = name + ": "+ score;
		lineLength -= line.length() + 1;

		System.out.println(); // skip 1 line at the beginning

		System.out.print(" ");
		for (int i = 0; i< length; i++) // top row of '='
			System.out.print("=");

		System.out.println();
		System.out.print("| "+line); // open '|' + line goes here
		for (int i = 0; i<lineLength; i++) // extra spaces
			System.out.print(" ");
		System.out.println("|"); // close '|'

		System.out.print(" ");
		for (int i = 0; i< length; i++)
			System.out.print("=");
		System.out.println();

		System.out.println(); // skip 1 line at the end
	}
}
