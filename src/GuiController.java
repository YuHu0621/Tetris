import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * GuiController control the motion of the pieces and update the view after each
 * step
 * the gui controller has a restart button
 * count tetris when four line decreases at the same time
 * 
 * @author Yu Hu
 *
 */
public class GuiController extends JPanel implements KeyListener {
	Pieces myPiece;
	Board myBoard;
	GuiView myDisplay;

	int[][] boardArray;
	int tetris = 0;
	int newPieceNum = 0;
	int totalClearLine = 0;
	Color tColor;

	JLabel instruction;
	JLabel score;
	boolean canMove;
	
	//moving command
	static char left = 'a';
	static char right = 'd';
	static char CW = 'z';
	static char CCW = 'x';
	static char fall = 's';

	public GuiController(String instruct) {
		super(new BorderLayout());
		
		addKeyListener(this);
		setFocusable(true);
		
		// add instructions
		JPanel topPanel = new JPanel(new GridLayout(2,1));
		instruction = new JLabel(instruct);
		topPanel.add(instruction);
		JButton start = new JButton("Start");
		topPanel.add(start);
		add(topPanel, BorderLayout.NORTH);
		start.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					initGame();
				}
		}
				);

		
		
		//display the score at the bottom
		score = new JLabel("Number of New Pieces: "
				+ newPieceNum
				+ ".    Tetris: " + tetris
				+ "    Number of cleared line: "
				+ Integer.toString(totalClearLine));
		add(score, BorderLayout.SOUTH);

		

	}

	public void initGame(){
		//remove the old panel
		if(myDisplay != null)
			remove(myDisplay);
		
		//reinitialize all the instant variable
		tetris = 0;
		totalClearLine = 0;
		newPieceNum = 0;
		
		score.setText("Number of New Pieces: "
				+ Integer.toString(newPieceNum +1)
				+ ".    Tetris: " + tetris
				+ "    Number of cleared line: "
				+ Integer.toString(totalClearLine));
		myDisplay = new GuiView();
		
		//initialize a new board
		myBoard = new Board();
		boardArray = myBoard.getBoard();
		
		// randomly initialize a new piece
		init(0, Board.BOARD_WIDTH / 2 - 1, 0);
		
		//update the GuiView and display the pieces on the board
		myDisplay.updatePiece(myPiece.getCurrentArray(), myPiece.x_Pos,
						myPiece.y_Pos, tColor);
		myDisplay.updateBoard(boardArray);
		
		add(myDisplay, BorderLayout.CENTER);
		validate();
		repaint();
		this.grabFocus();
		
		
		//timer
		createTimer();
	}
	
	
	/**
	 * read user input and move down, right, left, or rotate
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyChar() == left) {

			canMove = myPiece.checkLeft(myPiece.x_Pos, myPiece.y_Pos,
					boardArray, myPiece.getCurrentArray());
			if (canMove == true) {
				myPiece.left();
			}
		} else if (e.getKeyChar() == right) {
			canMove = myPiece.checkRight(myPiece.x_Pos, myPiece.y_Pos,
					boardArray, myPiece.getCurrentArray());
			if (canMove == true) {
				myPiece.right();
			}
		} else if (e.getKeyChar() == fall) {
			canMove = myPiece.checkFall(myPiece.x_Pos, myPiece.y_Pos,
					boardArray, myPiece.getCurrentArray());
			if (canMove == true) {
				myPiece.fall();
			} 
			else 
			{
				if(myBoard.checkTetris(myPiece) == true){
					tetris ++;
				}
				boardArray = myBoard.addToBoard(myPiece);
				totalClearLine += myBoard.clearLine(myPiece);
			
				remove(myDisplay);
				myDisplay.updateBoard(myBoard.getBoard());
				add(myDisplay,BorderLayout.CENTER);
				validate();
				repaint();
				init(0, Board.BOARD_WIDTH / 2 - 1, 0);

				score.setText("Number of New Pieces: "
						+ newPieceNum
						+ ".    Tetris: " + tetris 
						+ ".    Number of cleared line: "
						+ Integer.toString(totalClearLine));

			}
		} else if (e.getKeyChar() == CW) {
			canMove = myPiece.checkRotate_CW(myPiece.x_Pos, myPiece.y_Pos,
					myPiece.rotate, boardArray);
			if (canMove == true) {
				myPiece.rotateCW();
			}
		} else if (e.getKeyChar() == CCW) {
			canMove = myPiece.checkRotate_CCW(myPiece.x_Pos, myPiece.y_Pos,
					myPiece.rotate, boardArray);
			if (canMove == true) {
				myPiece.rotateCCW();
			}
		}
		//remove(myDisplay);
		myDisplay.updatePiece(myPiece.getCurrentArray(), myPiece.x_Pos,
				myPiece.y_Pos, tColor);
		
	
		//add(myDisplay, BorderLayout.CENTER);
		validate();
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * automatically fall down
	 */
	public void start() {
		canMove = myPiece.checkFall(myPiece.x_Pos, myPiece.y_Pos, boardArray,
				myPiece.getCurrentArray());
		
		//if the piece is not blocked
		if (canMove == true) {
			myPiece.fall();
			
			//update the GuiView and display the piece falling one step
			myDisplay.updatePiece(myPiece.getCurrentArray(), myPiece.x_Pos,
					myPiece.y_Pos, tColor);
			repaint();
		} else {
			//if the piece is blocked
			//add the old piece to the board 
			if(myBoard.checkTetris(myPiece)== true){
				tetris ++;
			}
			boardArray = myBoard.addToBoard(myPiece);
			
			//clear the bottom line if filled
			totalClearLine += myBoard.clearLine(myPiece);
			
			myDisplay.updateBoard(myBoard.getBoard());
			
			//initiate a new piece
			init(0, Board.BOARD_WIDTH / 2 - 1, 0);
			
			//update the score and counting the number of pieces
			score.setText("Number of New Pieces: " 
					+ newPieceNum
					+ ".    Tetris" + tetris
					+ "    Number of cleared line: "
					+ Integer.toString(totalClearLine));
			myDisplay.updatePiece(myPiece.getCurrentArray(), myPiece.x_Pos,
					myPiece.y_Pos, tColor);
			repaint();
		}
	}

	/**
	 * timer control the speed of the piece falling
	 */
	public void createTimer() {
		Timer simulationTimer = new Timer(1200, new ActionListener() {
			// Invoked every time the timer finishes
			public void actionPerformed(ActionEvent e) {
				start();

			}

		});
		simulationTimer.start();
	}

	/**
	 * initialize a board and initialize a piece
	 * 
	 * @param x initial x position of the piece
	 * @param y initial y position of the piece
	 * @param r initial rotate position of the piece
	 */

	public void init(int x, int y, int r) {
		Pieces[] pieceCollection = new Pieces[7];
		pieceCollection[0] = new I_Piece(x, y, r);
		pieceCollection[1] = new J_Piece(x, y, r);
		pieceCollection[2] = new L_Piece(x, y, r);
		pieceCollection[3] = new O_Piece(x, y, r);
		pieceCollection[4] = new Z_Piece(x, y, r);
		pieceCollection[5] = new S_Piece(x, y, r);
		pieceCollection[6] = new T_Piece(x, y, r);

		//randomly select a new piece
		int rand = (int) (Math.random() * pieceCollection.length);
		myPiece = pieceCollection[rand];
		tColor = myPiece.getColor();
		newPieceNum++;

	}

}
