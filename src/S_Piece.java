import java.awt.Color;

public class S_Piece extends Pieces {
	int[][] S_Piece;

	public S_Piece(int x, int y, int r) {
		super(x, y, r);
		selectShape(r);
	}

	private static final Color S_Color = Color.GREEN;

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
		if (y + afterRotate[0].length >= Board.BOARD_WIDTH) {
			y = Board.BOARD_WIDTH - afterRotate[0].length;
			y_Pos = y;
		}
		if (x + afterRotate.length >= Board.BOARD_HEIGHT) {
			x = Board.BOARD_HEIGHT - afterRotate.length;
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
		if (y + afterRotate[0].length >= Board.BOARD_WIDTH) {
			y = Board.BOARD_WIDTH - afterRotate[0].length;
			y_Pos = y;
		}
		if (x + afterRotate.length >= Board.BOARD_HEIGHT) {
			x = Board.BOARD_HEIGHT - afterRotate.length;
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
		selectShape(rotate);

	}

	@Override
	/**
	 * getter method
	 * @return return the array of S piece
	 */
	public int[][] getCurrentArray() {
		return S_Piece;
	}

	/**
	 * select the array of the piece based on its rotate position
	 * @param r rotate position
	 * @return array of the piece after rotation
	 */
	public int[][] selectShape(int r) {
		if (r % 2 == 0) {
			S_Piece = Pieces.S_Piece0;
		} else if (r % 2 == 1) {
			S_Piece = Pieces.S_Piece1;
		}
		return S_Piece;

	}

	/**
	 * getter method
	 * @return return the color of S piece
	 */
	public Color getColor() {
		return S_Color;
	}

}
