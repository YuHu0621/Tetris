import java.awt.Color;


/**
 * Pieces class contains the configuration of pieces and moving logic
 * @author Yu Hu
 *
 */
public abstract class Pieces {
	Board myBoard;
	int x_Pos ;
	int y_Pos ;
	int rotate;
    Pieces activePiece;
   
//configuration of O_Piece
public static int[][] O_Piece = new int[][]{
	{1,1},
	{1,1}
};
//configuration of L_Piece
public static int[][] L_Piece0 = new int[][]{
	{1, 0},
	{1, 0},
	{1, 1}
};
public static int[][] L_Piece1 = new int[][]{
	{1, 1, 1},
	{1, 0, 0}
	
};
public static int[][] L_Piece2 = new int[][]{
	{1, 1},
	{0, 1},
	{0, 1}
};
public static int[][] L_Piece3 = new int[][]{
	{0,0, 1},
	{1,1,1}
};
//configuration of J_Piece
public static int[][] J_Piece0 = new int[][]{
	{0, 1},
	{0, 1},
	{1, 1}
};
public static int[][] J_Piece1 = new int[][]{
	{1,0, 0},
	{1,1,1}
};
public static int[][] J_Piece2 = new int[][]{
	{1, 1},
	{1, 0},
	{1, 0}
};
public static int[][] J_Piece3 = new int[][]{
	{1,1,1},
	{0, 0, 1}
};

//configuration of T_Piece
public static int[][] T_Piece0 = new int[][]{
	{0, 1},
	{1, 1},
	{0, 1}
};
public static int[][] T_Piece1 = new int[][]{
	{0,1,0},
	{1,1,1}
};
public static int[][] T_Piece2 = new int[][]{
	{1, 0},
	{1, 1},
	{1, 0}
};
public static int[][] T_Piece3 = new int[][]{
	{1,1,1},
	{0,1,0}
};
//configuration of Z_Piece
public static int[][] Z_Piece0 = new int[][]{
	{0,1},
	{1,1},
	{1,0}
};
public static int[][] Z_Piece1 = new int[][]{
	{1,1,0},
	{0,1,1}
};

//configuration of S_Piece
public static int[][] S_Piece0 = new int[][]{
	{1, 0},
	{1, 1},
	{0, 1}
};
public static int[][] S_Piece1 = new int[][]{
	{0,1,1},
	{1,1,0}
}; 
//configuration of S_Piece
public static int[][] I_Piece0 = new int[][]{
	{1},
	{1},
	{1},
	{1}
};
public static int[][] I_Piece1 = new int[][]{
	{1,1,1,1}
};

/**
 * new piece constructor
 * @param x x position of a new piece
 * @param y y position of a new piece
 * @param r rotating position of a new piece
 */
public Pieces(int x, int y, int r){
x_Pos = x;
y_Pos = y;
rotate = r;

}
/**
 * get the color of the falling piece
 * @return return the color of the piece
 */
public abstract Color getColor();

/**
 * Fall down one step
 * 
 */
public void fall(){
	
		 x_Pos = x_Pos + 1;
}

/** 
 * Move Left
 */
public void left(){
	   
		y_Pos = y_Pos - 1;
}

/**
 * Move right
 */
public void right(){
	
	 y_Pos = y_Pos + 1;
}

/** 
 * rotate clokwise  
 */
public abstract void rotateCW();

/** 
 * rotate counter clockwise
 */
public abstract void rotateCCW();

public boolean checkFall(int x, int y, int[][] board, int[][] pieceArray){
	if (x + pieceArray.length -1 == Board.BOARD_HEIGHT -1){
		return false;
	}
	for(int r = x; r < x + pieceArray.length; r++){
		for (int c = y; c < y + pieceArray[0].length; c++){
			if(pieceArray[r-x][c-y] != 0){
				if(board[r+1][c] != 0){
					return false;
				}
			}
		}
	}return true;
	}


/** 
 * check if the piece can move left
 * @param x x pos of the piece
 * @param y y pos of the piece
 */
public boolean checkLeft(int x, int y, int[][] board, int[][] pieceArray){

 if (y == 0){
	 return false;

 }	for(int r = x; r < x + pieceArray.length; r++){
		for (int c = y; c < y + pieceArray[0].length; c++){
			if(pieceArray[r-x][c-y] != 0){
				if(board[r][c-1] != 0){
					return false;
				}
			}
		}
	}return true;
}
/** check if the piece can move right
 * 
 * @param x x pos of the piece
 * @param y y pos of the piece
 */
public boolean checkRight(int x, int y, int[][] board, int[][]pieceArray){
	
	 if (y+pieceArray[0].length -1 == board[0].length -1){
		 return false;
	 }	for(int r = x; r < x + pieceArray.length; r++){
			for (int c = y; c < y + pieceArray[0].length; c++){
				if(pieceArray[r-x][c-y] != 0){
					if(board[r][c+1] != 0){
						return false;
					}
				}
			}
		}return true;
}
/** 
 * abstract method to check if the piece can rotate clockwise
 * rotate method for different shape varies
 * @param x x pos of the piece
 * @param y y pos of the piece
 */
public abstract boolean checkRotate_CW(int x, int y, int rotation, int [][] board);
/** 
 * abstract method check if the piece can rotate counter clockwise
 * rotate method for different shape varies
 * @param x x pos of the piece
 * @param y y pos of the piece
 */
public abstract boolean checkRotate_CCW(int x, int y, int rotation, int [][] board);

/**
 * getter method
 * @return return the array of the falling piece
 */
public abstract int[][] getCurrentArray();
}
