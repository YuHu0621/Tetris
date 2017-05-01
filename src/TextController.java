import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class TextController {
	String input;
	private Board myBoard;
	private Pieces myPiece;
	TextView myDisplay;
	int [][] boardArray;
	int newPiece;
	int totalClearLine;
	boolean canMove;
public TextController(){
	myBoard = new Board();
	boardArray = myBoard.getBoard();
	newPiece = 0;
	totalClearLine = 0;
	initPiece(0, Board.BOARD_WIDTH/2 -1, 0);
	myDisplay = new TextView(myPiece.getCurrentArray(), boardArray, myPiece.x_Pos, myPiece.y_Pos, newPiece, totalClearLine);
	scan();
}

/**
 * keep listening to user input and move until user enters "Quit" to end the game
 */
public void scan(){
	BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
	
	// I/O almost always requires a try/catch 
	try 
	{
		String line;
		// loop until the user types "Quit"
		do {
			
			System.out.println( "Enter a move (d, l, r, z, x) or type Quit to end." ); 
			line = in.readLine(); 
			start(line);
		} while ( (!line.equals( "Quit" ) ) );
	}
	catch ( IOException ioe )
	{
		// tell exception to print its error log
		ioe.printStackTrace();
		
	
}
	
}

/**
 * moving logic
 * @param input listen to user input "d, r, l, z, x"
 */
public void start(String input){
	if (input.equals("l")){
		
		canMove = myPiece.checkLeft(myPiece.x_Pos, myPiece.y_Pos, boardArray, myPiece.getCurrentArray());
		
		
		if(canMove == true)
		myPiece.left();
		
	}else if(input.equals("r")){
		
		canMove = myPiece.checkRight(myPiece.x_Pos, myPiece.y_Pos, boardArray, myPiece.getCurrentArray());
		
		if (canMove == true)
		myPiece.right();
		
		
			
	}else if(input.equals("d")){
		
		canMove = myPiece.checkFall(myPiece.x_Pos, myPiece.y_Pos, boardArray, myPiece.getCurrentArray());
		
	
		if (canMove == true){
			myPiece.fall();
		}else{
			//change the array when the old piece is added to it.
			boardArray = myBoard.addToBoard(myPiece);
			int numClearLine = myBoard.clearLine(myPiece);
			
			totalClearLine += numClearLine;
			myDisplay = new TextView(myPiece.getCurrentArray(), boardArray, myPiece.x_Pos, myPiece.y_Pos, newPiece, totalClearLine);
			initPiece(0, Board.BOARD_WIDTH/2, 0);
			
		}
	}else if(input.equals("z")){
		
		
		canMove = myPiece.checkRotate_CW(myPiece.x_Pos, myPiece.y_Pos, myPiece.rotate, boardArray);
		if (canMove == true)
		myPiece.rotateCW();
		
	}else if (input.equals("x")){
		
		
		canMove = myPiece.checkRotate_CCW(myPiece.x_Pos, myPiece.y_Pos, myPiece.rotate, boardArray);
		if (canMove == true)
		myPiece.rotateCCW();
		
	}
	
	//get the current piece, its position, the current board, score number
	myDisplay = new TextView(myPiece.getCurrentArray(), boardArray, myPiece.x_Pos, myPiece.y_Pos, newPiece, totalClearLine);
	
}

/** 
 * initialize a piece
 * @param x x_pos
 * @param y y_Pos
 * @param r rotate position
 */
public void initPiece(int x, int y, int r){
	Pieces[] pieceCollection = new Pieces[7];
	pieceCollection[0] = new I_Piece(x, y, r);
	pieceCollection[1] = new J_Piece(x, y, r);
	pieceCollection[2] = new L_Piece(x, y, r);
	pieceCollection[3] = new O_Piece(x, y, r);
	pieceCollection[4] = new Z_Piece(x, y, r);
	pieceCollection[5] = new S_Piece(x, y, r);
	pieceCollection[6] = new T_Piece(x, y, r);
	
	int rand = (int) (Math.random()*pieceCollection.length);
	myPiece = pieceCollection[rand];	
	newPiece ++;
}



}
