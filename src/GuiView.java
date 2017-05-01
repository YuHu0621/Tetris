import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * 
 * @author yu hu
 *
 */
public class GuiView extends JComponent {
	int[][] myPiece;
	int[][] myBoard;
	int x;
	int y;
	float blockWeight;
	float blockHeight;
	float blockBoader;
	Color tColor;

	public void updatePiece(int[][] piece, int x, int y, Color tColor) {
		myPiece = piece;
		this.x = x;
		this.y = y;
		this.tColor = tColor;

		blockWeight = getWidth()/13;
		blockHeight = getHeight()/24;
		blockBoader = blockWeight/4;
	}

	public void updateBoard(int[][] board) {
		myBoard = board;
	}

	/**
	 * paint the board and paint the current piece
	 * 
	 */
	public void paint(Graphics g) {
		paintBoard(g);
		if(myPiece != null)
			paintPiece(g);

	}

	/**
	 * paint the board
	 * 
	 */
	public void paintBoard(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(
				0,
				0,
				(int) ((Board.BOARD_WIDTH) * (blockWeight + blockBoader) + blockBoader),
				(int) ((Board.BOARD_HEIGHT) * (blockHeight + blockBoader) + blockBoader));

		// empty blocks are blue
		for (int r = 0; r < Board.BOARD_HEIGHT; r++) {
			for (int c = 0; c < Board.BOARD_WIDTH; c++) {
				if (myBoard[r][c] == 0) {
					g.setColor(Color.BLUE);
					g.fillRect((int) (blockBoader + c * blockBoader + c
							* blockWeight),
							(int) (blockBoader + r * blockBoader + r
									* blockHeight), (int) blockWeight, (int) blockHeight);
				}
				// blocks with the dead pieces has the color of the pieces
				if (myBoard[r][c] == 1) {
					g.setColor(Color.CYAN);
					g.fillRect((int) (blockBoader + c * blockBoader + c
							* blockWeight),
							(int) (blockBoader + r * blockBoader + r
									* blockHeight), (int) blockWeight, (int) blockHeight);
				}
				if (myBoard[r][c] == 2) {
					g.setColor(Color.GRAY);
					g.fillRect((int) (blockBoader + c * blockBoader + c
							* blockWeight),
							(int) (blockBoader + r * blockBoader + r
									* blockHeight), (int) blockWeight, (int) blockHeight);
				}
				if (myBoard[r][c] == 3) {
					g.setColor(Color.ORANGE);
					g.fillRect((int) (blockBoader + c * blockBoader + c
							* blockWeight),
							(int) (blockBoader + r * blockBoader + r
									* blockHeight), (int) blockWeight, (int) blockHeight);
				}
				if (myBoard[r][c] == 4) {
					g.setColor(Color.YELLOW);
					g.fillRect((int) (blockBoader + c * blockBoader + c
							* blockWeight),
							(int) (blockBoader + r * blockBoader + r
									* blockHeight), (int) blockWeight, (int) blockHeight);
				}
				if (myBoard[r][c] == 5) {
					g.setColor(Color.GREEN);
					g.fillRect((int) (blockBoader + c * blockBoader + c
							* blockWeight),
							(int) (blockBoader + r * blockBoader + r
									* blockHeight), (int) blockWeight, (int) blockHeight);
				}
				if (myBoard[r][c] == 6) {
					g.setColor(Color.RED);
					g.fillRect((int) (blockBoader + c * blockBoader + c
							* blockWeight),
							(int) (blockBoader + r * blockBoader + r
									* blockHeight), (int) blockWeight, (int) blockHeight);
				}
				if (myBoard[r][c] == 7) {
					g.setColor(Color.MAGENTA);
					g.fillRect((int) (blockBoader + c * blockBoader + c
							* blockWeight),
							(int) (blockBoader + r * blockBoader + r
									* blockHeight), (int) blockWeight, (int) blockHeight);
				}
			}
		}

	}

	/**
	 * paint the piece
	 * 
	 */
	public void paintPiece(Graphics g) {
		for (int r = 0; r < myPiece.length; r++) {
			for (int c = 0; c < myPiece[r].length; c++) {
				g.setColor(tColor);
				if (myPiece[r][c] == 1)
					g.fillRect(
							(int) (blockBoader + (c + y) * blockBoader + (c + y) * blockWeight), 
							(int) (blockBoader + (r + x) * blockBoader + (r + x) * blockHeight),
							(int) blockWeight, (int) blockHeight);
			}
		}
	}

	/**
	 * erase the piece from the displaying view
	 * 
	 * @return return a board without the active piece
	 */
	public int[][] clearView() {
		int[][] view = new int[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		return view;
	}
}
