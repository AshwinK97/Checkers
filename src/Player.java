class Player {
    private Score score;
    private String name, colour;
    private String symbol;


    public Player(String name, String colour) {
        this.name = name;
        this.colour = colour;
        score = new Score(name);
        if (colour.equals("red"))
            symbol = "X";
        else
            symbol = "O";
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public String getSymbol() {
        return symbol;
    }

    public void displayScore() {
    	score.displayScore();
    }

    public int getScore() {
      return score.getScore();
   }

    public void addScore(int score) {
        this.score.addScore(score);
    }
}
