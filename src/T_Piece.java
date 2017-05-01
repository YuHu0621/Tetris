import java.awt.Color;


public class T_Piece extends Pieces {
	int[][] T_Piece;

	public T_Piece(int x, int y, int r) {
		super(x, y, r);
		selectShape(r);
	}

	private static final Color T_Color = Color.MAGENTA;

	@Override
	/**
	 * check if can rotate clockwise. 
	 * @param x current x position of the piece
	 * @param y current y position of the piece
	 * @param rotation current rotate position of the piece
	 * @param board current array of the board
	 * @return return if the piece can rotate or not
	 */
	public boolean checkRotate_CW(int x, int y, int rotation, int[][] board) {
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
	public boolean checkRotate_CCW(int x, int y, int rotation, int[][] board) {
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
		rotate = rotate + 1;
		if (rotate % 4 == 0) {
			selectShape(0);
		} else if (rotate % 2 == 0 && rotate % 4 != 0) {
			selectShape(2);
		} else if (rotate % 4 == 1) {
			selectShape(3);
		} else if (rotate % 4 == 3) {
			selectShape(1);
		}
	}

	
	/**
	 * return the current Array of T piece
	 */
	public int[][] getCurrentArray() {
		return T_Piece;
	}

	/**
	 * select the shape of the pieces based on the rotate position
	 * @param r rotate position
	 * @return
	 */
	private int[][] selectShape(int r) {
		if (r % 4 == 0) {
			T_Piece = Pieces.T_Piece0;
		} else if (r % 4 == 1) {
			T_Piece = Pieces.T_Piece1;
		} else if (r % 2 == 0 && r % 4 != 0) {
			T_Piece = Pieces.T_Piece2;
		} else if (r % 4 == 3) {
			T_Piece = Pieces.T_Piece3;
		}
		return T_Piece;
	}

	/**
	 * getter method
	 * @return return the color of T piece
	 */
	public  Color getColor() {
		return T_Color;
	}

}
