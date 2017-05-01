import java.awt.Color;


public class J_Piece extends Pieces {
	int[][] J_Piece;

	public J_Piece(int x, int y, int r) {
		super(x, y, r);
		selectShape(r);
	}

	private static final Color J_Color = Color.GRAY;

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
		int[][] afterRotate = selectShape(4-(rotation + 1)%4);
		if(y+afterRotate[0].length >= Board.BOARD_WIDTH){
			y = Board.BOARD_WIDTH-afterRotate[0].length;
			y_Pos = y;
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

	@Override
	public int[][] getCurrentArray() {
		return J_Piece;
	}

	public int[][] selectShape(int r) {
		if (r % 4 == 0) {
			J_Piece = Pieces.J_Piece0;
		} else if (r % 4 == 1) {
			J_Piece = Pieces.J_Piece1;
		} else if (r % 2 == 0 && r % 4 != 0) {
			J_Piece = Pieces.J_Piece2;
		} else if (r % 4 == 3) {
			J_Piece = Pieces.J_Piece3;
		}return J_Piece;
	}

	public  Color getColor() {
		return J_Color;
	}

}
