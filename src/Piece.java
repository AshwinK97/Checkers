class Piece {
    
    private int x, y;
    private String colour;
    
    public Piece(int x, int y, String colour) {
        this.colour = colour;
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public String getColour(){
        return colour;
    }
    
    public void updateCoords(int newX, int newY){
        this.x = newX;
        this.y = newY;
    }
}