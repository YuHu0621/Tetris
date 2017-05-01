import javax.swing.JFrame;


public class TetrisApplication {

	public static void main(String[] args) {
			JFrame guiFrame;
			
			guiFrame = new JFrame();
			guiFrame.setTitle("Tetris Game");		
			// set size
			guiFrame.setSize( 400, 750 );

			// create a TreeCollage and add it
			guiFrame.add( new GuiController("Enter a move (s, a, d, z, x).") );
			
			guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

			// show frame
			guiFrame.setVisible( true );
			}
			
}
