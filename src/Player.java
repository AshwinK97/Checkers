class Player {
	private String name, colour;
	private int score;

	public Player(String name, String colour) {
		this.name = name;
		this.colour = colour;
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public String getColour() {
		return colour;
	}
}