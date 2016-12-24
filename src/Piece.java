class Piece {

    private int x, y;
    private String colour;

	public Piece(int x, int y, String colour) {
        this.colour = colour;
        this.isAlive = true;
        this.x = x;
        this.y = y;
	}

	public getX(){
        return this.x;
    }

    public getY(){
        return this.y;
    }

    public getColour(){
        return colour;
    }

    public updateCoords(int newX, int newY){
        this.x = newX;
        this.y = newY;
    }
}