class Board {
    private int size = 8;
    public Piece gameBoard = new Piece[8][8];

    public Board() {
        for (int y=0; y<size; y++){
            for(int x=0; x<size; x++){
                if(y <= 2){
                    if((x+y)%2 == 0){
                        gameBoard[x][y] = new Piece(x, y, "");

                    }
                    else {
                        gameBoard[x][y] = new Piece(x, y, "red");
                    }
                }
                else if(y == 3 || y == 4) {
                    gameBoard[x][y] = new Piece(x, y, "");
                }
                else if(y >= 5){
                    if((x+y)%2 == 0){
                        gameBoard[x][y] = new Piece(x, y, "");

                    }
                    else {
                        gameBoard[x][y] = new Piece(x, y, "black");
                    }
                }
            }
        }
    }

    private boolean isValid(int x, int y, int newX, int newY) {
        String playerColour = theBoard[x][y].colour;
        if (newX < size && newY < size){
            if(playerColour == theBoard[x+1][y+1].colour ||
                playerColour == )
        }
    }

    private boolean checkDiagonals(int x, int y) {

        if(gameBoard[x][y+1].colour != "" ) {

        }
    }


    private jumpForced(String color) { //this only works for basic pieces moving diagonal-forward
        for (int y=0; y<size; y++){
            for(int x=0; x<size; x++){
                if(gameBoard[x][y].colour == colour) {
                    checkDiagonals(x, y);
                }
            }
        }
    }

    public boolean move(int x, int y, int newX, int newY, String color) {

    }

}