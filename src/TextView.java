
public class TextView {
int [][] currentPiece;
int[][] currentBoard;

int [][] boardView;
int pieceX;
int pieceY;
int numPieces;
int numLines;
String borderLine = "";

public TextView (int [][] piece, int [][] board, int x, int y, int newPiece, int clearLine){
	currentPiece = piece;
	currentBoard = board;
	
	pieceX = x;
	pieceY = y;
	numPieces = newPiece;
	numLines = clearLine;
	printEachStep();
}

public void printEachStep(){
	 boardView = combinePieceboard();
	 
	System.out.println("Number of new Pieces " + numPieces );
	System.out.println("Number of clear lines " + numLines);
	for (int i = 0; i < Board.BOARD_WIDTH; i++){
		borderLine += "-";
	}

	System.out.println(borderLine);
	for (int w = 0; w < boardView.length; w++){
		String thisLine = "";
		for (int h = 0; h < boardView[w].length; h++){
			if (boardView[w][h]==0)
				thisLine += " ";
			else
				thisLine += "*";
		}System.out.println(thisLine);
	}
	System.out.println(borderLine);
	boardView = clearView();
}

public int[][] combinePieceboard(){
   int [][] boardPlusPiece = new int[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
   for (int r = 0; r<boardPlusPiece.length; r++){
	   for(int c = 0; c < boardPlusPiece[r].length; c++){
		   if (currentBoard[r][c] ==1){
			   boardPlusPiece[r][c]=1;
		   }
	   }
   }
	for(int r = pieceX; r < currentPiece.length + pieceX; r++){
		for(int c = pieceY; c < currentPiece[0].length + pieceY;c++){
			if (currentPiece[r - pieceX][c - pieceY] == 1)
				boardPlusPiece[r][c] = 1;
		}
		
	}return boardPlusPiece;
}
  public int[][] clearView(){
	  int[][]view = new int[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
	  return view;
  }
}