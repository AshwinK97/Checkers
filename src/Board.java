class Board {
    private int size = 8;
    public Piece gameBoard[][];
    private int forcedMoves[][];

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
        char letters[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        System.out.print("  ");
        for (int i=0; i<size; i++)
            System.out.print(" " + letters[i] + " ");
        System.out.println();
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if (j==0)
                    System.out.print(i + " ");
                System.out.print("[" + gameBoard[j][i].getColour() + "]");
            }
            System.out.println();
        }
    }

    private boolean inBoundary(int newX, int newY) {
        if (newX >= 0 && newX < size) {
            if (newY >= 0 && newY < size) {
                return true;
            }
        }
        return false;
    }


// returns -1 if invalid, 0 if move diagonal once, and 1 if jump over piece
    public int movePiece(int x, int y, int newX, int newY, String colour) {
        int xDiff = newX - x;
        int yDiff = newY - y;
        if (colour == gameBoard[x][y].getColour() && colour != " " && inBoundary(newX, newY)) {
            if (colour == "X") {
                if (Math.abs(xDiff) == Math.abs(yDiff) && yDiff > 0) {
                    if (xDiff == -1 || xDiff == 1) {
                        if (gameBoard[newX][newY].getColour() == " ") {
                            gameBoard[newX][newY] = gameBoard[x][y];
                            gameBoard[x][y] = new Piece(x, y, " ");
                            return 0;
                        }
                    } else if (xDiff == 2 || xDiff == -2) {
                        if (gameBoard[x + xDiff][newY].getColour() == " ") {
                            if (xDiff == 2) {
                                if (gameBoard[x + 1][y + 1].getColour() == "O") {
                                    gameBoard[newX][newY] = gameBoard[x][y];
                                    gameBoard[x][y] = new Piece(x, y, " ");
                                    gameBoard[x + 1][y + 1] = new Piece(x, y, " ");
                                    doubleJump(newX, newY, colour);
                                    return 1;
                                }
                            } else if (xDiff == -2) {
                                if (gameBoard[x - 1][y + 1].getColour() == "O") {
                                    gameBoard[newX][newY] = gameBoard[x][y];
                                    gameBoard[x][y] = new Piece(x, y, " ");
                                    gameBoard[x - 1][y + 1] = new Piece(x, y, " ");
                                    doubleJump(newX, newY, colour);
                                    return 1;
                                }
                            }
                        }
                    }
                }
            } else if (colour == "O") {
                if (Math.abs(xDiff) == Math.abs(yDiff) && yDiff < 0) {
                    if (xDiff == -1 || xDiff == 1) {
                        if (gameBoard[newX][newY].getColour() == " ") {
                            gameBoard[newX][newY] = gameBoard[x][y];
                            gameBoard[x][y] = new Piece(x, y, " ");
                            return 0;
                        }
                    } else if (xDiff == 2 || xDiff == -2) {
                        if (gameBoard[x + xDiff][newY].getColour() == " ") {
                            if (xDiff == 2) {
                                if (gameBoard[x + 1][y - 1].getColour() == "X") {
                                    gameBoard[newX][newY] = gameBoard[x][y];
                                    gameBoard[x][y] = new Piece(x, y, " ");
                                    gameBoard[x + 1][y - 1] = new Piece(x, y, " ");
                                    doubleJump(newX, newY, colour);
                                    return 1;
                                }
                            } else if (xDiff == -2) {
                                if (gameBoard[x - 1][y - 1].getColour() == "X") {
                                    gameBoard[newX][newY] = gameBoard[x][y];
                                    gameBoard[x][y] = new Piece(x, y, " ");
                                    gameBoard[x - 1][y - 1] = new Piece(x, y, " ");
                                    doubleJump(newX, newY, colour);
                                    return 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    void doubleJump(int newX, int newY, String colour) {
        // both are there
        boolean hasMoved = false;
        if (colour == "O" && inBoundary(newX+2, newY-2) && inBoundary(newX-2, newY-2) &&
            (gameBoard[newX + 1][newY - 1].getColour() == "X") &&
            (gameBoard[newX - 1][newY - 1].getColour() == "X") &&
            (gameBoard[newX + 2][newY - 2].getColour() == " ") &&
            (gameBoard[newX - 2][newY - 2].getColour() == " ")
            ) {
            System.out.print("While jumping you reached a spot with 2 possible paths, which will you take? ");
            String path;
            path = Game.in.nextLine();
            if(path.equals("l")){
                movePiece(newX, newY, newX-2, newY-2, colour);
            }
            else if(path.equals("r")) {
                movePiece(newX, newY, newX+2, newY-2, colour);
            }
            else {
                System.out.println();
                System.out.println("Invalid path, choose either 'l' or 'r'");
                doubleJump(newX, newY, colour);
            }
            hasMoved = true;
        }
        else if (colour == "O" && inBoundary(newX+2, newY-2) &&
            (gameBoard[newX + 1][newY - 1].getColour() == "X") &&
            (gameBoard[newX + 2][newY - 2].getColour() == " ")) {
            movePiece(newX, newY, newX+2, newY-2, colour);
            hasMoved = true;
        }
        else if (colour == "O" && inBoundary(newX-2, newY-2) &&
            (gameBoard[newX - 1][newY - 1].getColour() == "X") &&
            (gameBoard[newX - 2][newY - 2].getColour() == " ")) {
            movePiece(newX, newY, newX - 2, newY - 2, colour);
            hasMoved = true;
        }
        else if(colour == "X" && inBoundary(newX+2, newY+2) && inBoundary(newX-2, newY+2) &&
            (gameBoard[newX + 1][newY - 1].getColour() == "O") &&
            (gameBoard[newX - 1][newY - 1].getColour() == "O") &&
            (gameBoard[newX + 2][newY - 2].getColour() == " ") &&
            (gameBoard[newX - 2][newY - 2].getColour() == " ")) {
            System.out.print("While jumping you reached a spot with 2 possible paths, which will you take? ");
            String path;
            path = Game.in.nextLine();
            if(path.equals("l")){
                movePiece(newX, newY, newX-2, newY+2, colour);
            }
            else if(path.equals("r")) {
                movePiece(newX, newY, newX+2, newY+2, colour);
            }
            else {
                System.out.println();
                System.out.println("Invalid path, choose either 'l' or 'r'");
                doubleJump(newX, newY, colour);
            }
            hasMoved = true;
        }
        else if (colour == "X" && inBoundary(newX+2, newY+2) &&
            (gameBoard[newX + 1][newY + 1].getColour() == "O") &&
            (gameBoard[newX + 2][newY + 2].getColour() == " ")) {
            movePiece(newX, newY, newX + 2, newY + 2, colour);
            hasMoved = true;
        }
        else if (colour == "X" && inBoundary(newX-2, newY+2) &&
            (gameBoard[newX - 1][newY + 1].getColour() == "O") &&
            (gameBoard[newX - 2][newY + 2].getColour() == " ")) {
            movePiece(newX, newY, newX - 2, newY + 2, colour);
            hasMoved = true;
        }
        if (hasMoved) displayBoard();
    }


    // private void kingPiece(String colour) {
    //     for(int i=0; i<size; i++){
    //         if(gameBoard[i][size-1].colour == "X"){
    //             gameBoard[i][size-1].colour = "x";
    //         }
    //         if(gameBoard[i][0].colour == "O"){
    //             gameBoard[i][size-1].colour = "o";
    //         }
    //     }
    // }


    // private void jumpForced(int x, int y, int newX, int newY, String colour) { //this only works for basic pieces moving diagonal-forward
    //     for (int y=0; y<size; y++){
    //         for(int x=0; x<size; x++){
    //             if(gameBoard[x][y].getColour() == colour) {

    //             }
    //         }
    //     }
    // }

}