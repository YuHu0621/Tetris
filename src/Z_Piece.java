import java.awt.Color;

/**
 * Z Pieces
 * @author Yu Hu
 *
 */
public class Z_Piece extends Pieces {
	int[][] Z_Piece;

	public Z_Piece(int x, int y, int r) {
		super(x, y, r);
		selectShape(r);
	}

	private static final Color Z_Color = Color.RED;

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



	/**
	 * rotate clockwise
	 */
	@Override
	public void rotateCW() {

		rotate = rotate + 1;
		selectShape(rotate);
	}

	/**
	 * rotate counterclockwise
	 */
	@Override
	public void rotateCCW() {
		rotate = rotate + 1;
		selectShape(rotate);
	}

	
	@Override
	/**
	 * return the current Array of Z piece
	 */
	public int[][] getCurrentArray() {
		return Z_Piece;
	}
/**
 * select the shape of the pieces based on the rotate position
 * @param r rotate position
 * @return
 */
	private int[][] selectShape(int r) {
		if (r % 2 == 0) {
			Z_Piece = Pieces.Z_Piece0;
		} else if (r % 2 == 1) {
			Z_Piece = Pieces.Z_Piece1;
		}
		return Z_Piece;
	}

	/**
	 * getter method
	 * @return return color of Z piece
	 */
	public Color getColor() {
		return Z_Color;
	}

}
