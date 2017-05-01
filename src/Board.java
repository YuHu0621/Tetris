import java.awt.Color;

public class Board {

	// width of the board
	public static final int BOARD_WIDTH = 10;

	// height of the board
	public static final int BOARD_HEIGHT = 18;

	private int[][] board = new int[BOARD_HEIGHT][BOARD_WIDTH];

	Pieces currentPiece;

	public Board() {
		board = initBoard();

	}

	/**
	 * initialize an empty board
	 */
	public int[][] initBoard() {
		for (int r = 0; r < BOARD_HEIGHT; r++) {
			for (int c = 0; c < BOARD_WIDTH; c++) {
				board[r][c] = 0;
			}
		}
		return board;
		
		
	}

	public int[][] getBoard() {
		return board;
	}

	
	public boolean checkTetris(Pieces a){
		if(a.getCurrentArray() == Pieces.I_Piece0){
			for(int r = a.x_Pos; r < a.x_Pos + a.getCurrentArray().length; r++){
				for (int c = 0; c < BOARD_WIDTH; c++){
					if(board[r][c] == 0){
						return false;
					}
				}
			}
			System.out.println(true);
			return true;
		}else{
			return false;
		}
	}
	public int clearLine(Pieces a){
		int numClearLine = 0;
		int r = a.x_Pos;
		while(r < a.x_Pos + a.getCurrentArray().length) {
			for(int c = 0; c<BOARD_WIDTH; c++){
				if(board[r][c] != 0){
					
					//if the whole line is filled
					if(c == BOARD_WIDTH -1){
						numClearLine ++;
						
						//clear that line from bottom up
						for(int row = r; row > 0; row --){
							for(int col = 0; col < BOARD_WIDTH; col++){
								board[row][col] = board[row-1][col];
							}
						}
					}
				}else{
					//if the line is not filled, go to the next row
					break;
				}
			}
			r++;
		}
		for(int row = 0; row < numClearLine; row++){
			
				for(int col = 0; col < BOARD_WIDTH; col++){
					board[row][col] = 0;
				
		}
		
	}
		return numClearLine;
	}
	
	/**
	 * add the piece to the board when it is not active
	 * @param a the current piece
	 */
	public int[][] addToBoard(Pieces a) {
		int x = a.x_Pos;
		int y = a.y_Pos;
		int arr[][] = a.getCurrentArray();
		Color tColor = a.getColor();
		if (tColor == Color.CYAN) {
			for (int r = x; r < x + arr.length; r++) {
				for (int c = y; c < y + arr[0].length; c++) {
					if (arr[r - x][c - y] == 1) {
						board[r][c] = 1;
					}
				}
			}
		}
		if (tColor == Color.GRAY) {
			for (int r = x; r < x + arr.length; r++) {
				for (int c = y; c < y + arr[0].length; c++) {
					if (arr[r - x][c - y] == 1) {
						board[r][c] = 2;
					}
				}
			}
		}
		if (tColor == Color.ORANGE) {
			for (int r = x; r < x + arr.length; r++) {
				for (int c = y; c < y + arr[0].length; c++) {
					if (arr[r - x][c - y] == 1) {
						board[r][c] = 3;
					}
				}
			}
		}
		if (tColor == Color.YELLOW) {
			for (int r = x; r < x + arr.length; r++) {
				for (int c = y; c < y + arr[0].length; c++) {
					if (arr[r - x][c - y] == 1) {
						board[r][c] = 4;
					}
				}
			}
		}
		if (tColor == Color.GREEN) {
			for (int r = x; r < x + arr.length; r++) {
				for (int c = y; c < y + arr[0].length; c++) {
					if (arr[r - x][c - y] == 1) {
						board[r][c] = 5;
					}
				}
			}
		}
		if (tColor == Color.RED) {
			for (int r = x; r < x + arr.length; r++) {
				for (int c = y; c < y + arr[0].length; c++) {
					if (arr[r - x][c - y] == 1) {
						board[r][c] = 6;
					}
				}
			}
		}
		if (tColor == Color.MAGENTA) {
			for (int r = x; r < x + arr.length; r++) {
				for (int c = y; c < y + arr[0].length; c++) {
					if (arr[r - x][c - y] == 1) {
						board[r][c] = 7;
					}
				}
			}

		}
		return board;
	}
}
