class Board {
    private int size = 8;
    public Piece gameBoard[][];

    public Board() {
        gameBoard = new Piece[8][8];
        for (int x=0; x<size; x++){
            for(int y=0; y<size; y++){
                if(y <= 2){
                    if((x+y)%2 == 0){
                        gameBoard[x][y] = new Piece(x, y, " ");

                    }
                    else {
                        gameBoard[x][y] = new Piece(x, y, "X");
                    }
                }
                else if(y == 3 || y == 4) {
                    gameBoard[x][y] = new Piece(x, y, " ");
                }
                else if(y >= 5){
                    if((x+y)%2 == 0){
                        gameBoard[x][y] = new Piece(x, y, " ");

                    }
                    else {
                        gameBoard[x][y] = new Piece(x, y, "O");
                    }
                }
            }
        }
    }

    public void displayBoard() {
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print("[" + gameBoard[j][i].getColour() + "]");
            }
            System.out.println();
        }
    }























    // // Boundary check to make sure movement is in board
    // private boolean inBoundary(int x, int y, int newX, int newY) {
    //     if(x >= 0 && x < size){
    //         if(y>=0 && y < size){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    //  // returns true if piece is moving in correct direction and checks boundaries
    // private boolean isMovingForward(int x, int y, int newX, int newY, String colour) {
    //     if(gameBoard[x][y].colour == "red"){
    //         if(y < newY && inBoundary(x,y,newX,newY)) {
    //             return "red";
    //         }
    //     }
    //     else if(gameBoard[x][y].colour == "black"){
    //         if(y > newY && inBoundary(x,y,newX,newY)) {
    //             return "black";
    //         }
    //     }
    //     return "";
    // }

    // private boolean moveForwardBool(int x, int y, int newX, int newY, String colour) {
    //     if(gameBoard[x][y].colour == "red") {
    //         if(y < newY && (newY - y) <= 2 && inBoundary(x,y,newX,newY)) {
    //             if(newY - y == 1) {

    //             }
    //             else if(newY - y == 2){
    //                 if(isBoard[x][y].colour == "black")
    //             }
    //         }
    //     }
    //     else if(gameBoard[x][y].colour == "black") {

    //     }

    // }






    // // // returns true if piece is moving in correct direction and checks boundaries
    // // private String isMovingForward(int x, int y, int newX, int newY, String colour) {
    // //     if(gameBoard[x][y].colour == "red"){
    // //         if(y < newY && inBoundary(x,y,newX,newY)) {
    // //             return "red";
    // //         }
    // //     }
    // //     else if(gameBoard[x][y].colour == "black"){
    // //         if(y > newY && inBoundary(x,y,newX,newY)) {
    // //             return "black";
    // //         }
    // //     }
    // //     return "";
    // // }


    // // // checks if a player is trying to move his own piece
    // // private boolean isPlayersPiece(int x, int y, String colour){
    // //     if(gameBoard[x][y].colour == colour) {
    // //         return true;
    // //     }
    // //     return false;
    // // }

    // // // is player forced to move diagonal on any of his pieces, if so is he moving it => t/f
    // // private boolean checkDiagonals(int x, int y, int newX, int newY, String colour) {
    // //     if(gameBoard[x][y])
    // // }


    // // // is the players move valid
    // // private boolean isValid(int x, int y, int newX, int newY, String colour) {
    // //     String playerColour = gameBoard[x][y].colour;
    // //     if(isPlayersPiece(x, y,colour).equals(colour) && isMovingForward(x,y,newX,newY,colour)) {
    // //         if(colour == "red") {

    // //         }
    // //         else if(colour == "black") {

    // //         }
    // //     }
    // //     else {
    // //         System.out.println("Invalid Move!");
    // //     }
    // // }



    // // private jumpForced(int x, int y, int newX, int newY, String colour) { //this only works for basic pieces moving diagonal-forward
    // //     for (int y=0; y<size; y++){
    // //         for(int x=0; x<size; x++){

    // //         }
    // //     }
    // // }

    // // // moves a piece
    // // public boolean move(int x, int y, int newX, int newY, String colour) {

    // // }

}