import java.awt.Color;



public class L_Piece extends Pieces {
	int[][] L_Piece;
	
    public L_Piece(int x, int y, int r) {
		super(x,y,r);
	
		selectShape(r);
	}

	private static final Color L_Color = Color.ORANGE;
	

	@Override
	/**
	 * check if can rotate clockwise. 
	 * @param x current x position of the piece
	 * @param y current y position of the piece
	 * @param rotation current rotate position of the piece
	 * @param board current array of the board
	 * @return return if the piece can rotate or not
	 */
	public boolean checkRotate_CW(int x, int y, int rotation, int [][] board) {
		int[][] afterRotate = selectShape(rotation + 1);
		if(y+afterRotate[0].length >= Board.BOARD_WIDTH){
			y = Board.BOARD_WIDTH-afterRotate[0].length;
			y_Pos = y;
		}
		if (x + afterRotate.length >= Board.BOARD_HEIGHT){
			x = Board.BOARD_HEIGHT-afterRotate.length;
			x_Pos = x;
		}
		for (int r = x; r < x + afterRotate.length; r++) {
			for (int c = y; c < y + afterRotate[0].length; c++) {
				if (board[r][c] != 0)
					return false;
			}
		}
		return true;
	}

	@Override
	/**
	 * check if can rotate counter clockwise. 
	 * @param x current x position of the piece
	 * @param y current y position of the piece
	 * @param rotation current rotate position of the piece
	 * @param board current array of the board
	 * @return return if the piece can rotate or not
	 */
	public boolean checkRotate_CCW(int x, int y, int rotation, int [][] board) {
		int[][] afterRotate = selectShape(4-(rotation + 1)%4);
		if(y+afterRotate[0].length >= Board.BOARD_WIDTH){
			y = Board.BOARD_WIDTH-afterRotate[0].length;
			y_Pos = y;
		}
		if (x + afterRotate.length >= Board.BOARD_HEIGHT){
			x = Board.BOARD_HEIGHT-afterRotate.length;
			x_Pos = x;
		}
		for (int r = x; r < x + afterRotate.length; r++) {
			for (int c = y; c < y + afterRotate[0].length; c++) {
				if (board[r][c] != 0)
					return false;
			}
		}
		return true;
	}

	

	@Override
	/**
	 * rotate clockwise
	 */
	public void rotateCW() {
			rotate = rotate + 1;
			selectShape(rotate);
	}

	@Override
	/**
	 * rotate counter clockwise
	 */
	public void rotateCCW() {
			rotate = rotate +1;
			if (rotate % 4 ==0){
				selectShape(0);
			}else if (rotate %2 ==0 && rotate % 4 != 0){
				selectShape(2);
			}else if (rotate % 4 ==1){
				selectShape(3);
			}else if (rotate % 4 ==3){
				selectShape(1);
			}
		
		
	}

	@Override
	/**
	 * getter method
	 * @return return the array of S piece
	 */
	public int[][] getCurrentArray() {
		return L_Piece;
	}
	
	/**
	 * select the array of the piece based on its rotate position
	 * @param r rotate position
	 * @return array of the piece after rotation
	 */
	public int[][] selectShape(int r){
		if (r%4 ==0){
			L_Piece = Pieces.L_Piece0;
		}else if (r%4 == 1){
			L_Piece = Pieces.L_Piece1;
		}else if (r%2 == 0 && r%4 !=0){
			L_Piece = Pieces.L_Piece2;
		}else if (r%4 ==3){
			L_Piece = Pieces.L_Piece3;
		}
		return L_Piece;
	}

	/**
	 * getter method
	 * @return return the color of S piece
	 */
	public Color getColor() {
		return L_Color;
	}

}
