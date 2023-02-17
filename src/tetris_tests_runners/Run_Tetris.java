package tetris_tests_runners;
import javax.swing.JOptionPane;

import tetrisGUI.*;
import tetris.*;

public class Run_Tetris {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		JOptionPane.showMessageDialog(null, "Tetris_GUI(new Tetris())");
//		Tetris t = new Tetris();
//		System.out.println(t.toString());
//		System.out.println(t.array_to_string(t.getGameGrid()));
//		new Tetris_GUI(t);
//		new Tetris_GUI(t);
		
		TetrisGame_Controller controller = new TetrisGame_Controller();
		controller.start();
		

	}

}
