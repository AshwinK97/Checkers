public class Score {

	private int score;
	private String name;

	public Score(String name) {
		score = 0;
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void addScore(int score) {
		this.score += score;
	}

	public void displayScore() {
		int length = 25;
		int lineLength = length;
		String line = name + ": "+ score;
		lineLength -= line.length() + 1;

		System.out.print(" ");
		for (int i = 0; i< length; i++)
			System.out.print("=");
		System.out.println();
		System.out.print("|"+line);
		for (int i = 0; i<lineLength; i++)
			System.out.print(" ");
		System.out.println("|");

		System.out.print(" ");
		for (int i = 0; i< length; i++)
			System.out.print("=");
		System.out.println();
	}
}
