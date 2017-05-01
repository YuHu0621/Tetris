import java.awt.Color;

public class O_Piece extends Pieces {
	int[][] O_Piece;

	public O_Piece(int x, int y, int r) {
		super(x, y, r);
		O_Piece = Pieces.O_Piece;
		// TODO Auto-generated constructor stub
	}

	private static final Color O_Color = Color.YELLOW;

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
		return true;
	}

	

	@Override
	/**
	 * rotate clockwise
	 */
	public void rotateCW() {
		O_Piece = Pieces.O_Piece;

	}

	@Override
	/**
	 * rotate counterclockwise
	 */
	public void rotateCCW() {
		O_Piece = Pieces.O_Piece;

	}

	@Override
	/**
	 * getter method
	 * @return return the array of O piece
	 */
	public int[][] getCurrentArray() {
		return O_Piece;
	}


	/**
	 * getter method
	 * @return return the color of O piece
	 */
	public Color getColor() {
		return O_Color;
	}

}
