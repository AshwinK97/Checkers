

public class Score {
	private int score;
	private String name;

	public Score(String name) {
		score = 0;
		this.name = name;
	}

	public int getScore() {
		return 0;
	}

	public void setScore(int score) {
		this.score += score;
	}
	public void displayScore(){
		int length = 20;
		int linelength = length;
		String line = name + ": "+ score;
		linelength -= line.length() + 1;
		for (int i = 0; i< length; i++)
			System.out.print("=");
		System.out.println();
		System.out.print("|"+line);
		for (int i = 0; i<linelength; i++)
			System.out.print(" ");
		System.out.println("|");
		for (int i = 0; i< length; i++)
			System.out.print("=");
		System.out.println();
	}

}
