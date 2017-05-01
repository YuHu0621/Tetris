import java.awt.Color;


public class I_Piece extends Pieces {
	int[][] I_Piece;

	public I_Piece(int x, int y, int r) {
		super(x, y, r);
		selectShape(r);

	}

	private static final Color I_Color = Color.CYAN;

	@Override
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

	

	@Override
	public void rotateCW() {
		rotate = rotate + 1;
		selectShape(rotate);
	}

	@Override
	public void rotateCCW() {
		rotate = rotate + 1;
		selectShape(rotate);

	}

	@Override
	public int[][] getCurrentArray() {
		return I_Piece;
	}

	public int[][] selectShape(int r) {
		if (r % 2 == 0) {
			I_Piece = Pieces.I_Piece0;
		} else if (r % 2 == 1) {
			I_Piece = Pieces.I_Piece1;
		}
		return I_Piece;
	}

	public  Color getColor() {
		return I_Color;
	}
}
