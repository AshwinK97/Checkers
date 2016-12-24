class Player {
	private String name, colour;
	private char symbol;
	private int score;

	public Player(String name, String colour) {
		this.name = name;
		this.score = 0;
		this.colour = colour;
		if (colour.equals("red"))
			symbol = 'X';
		else
			symbol = 'O';
	}

	public String getName() {
		return name;
	}

	public String getColour() {
		return colour;
	}

	public char getSymbol() {
		return symbol;
	}

	public int getScore() {
		return score;
	}

	public void addScore() {
		score+=1;
	}
}