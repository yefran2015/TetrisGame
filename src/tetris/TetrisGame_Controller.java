package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import tetrisGUI.Tetris_GUI;


public class TetrisGame_Controller{
	private Tetris game;
	@SuppressWarnings("unused")
	private Tetris_GUI gameGUI;
	private int timerTime =500;
	private Timer timer = new Timer(timerTime, new TimerListener());
	
	
	public TetrisGame_Controller(){
		game = new Tetris();
		gameGUI = new Tetris_GUI(game);		
	}
	
	
	public void start(){		
		timer.start();				
	}
	
	public void stop(){
		timer.stop();
	}
	
	class TimerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
//			checkRemoveLine();
			moveDown();
			
		}

		
	}
	
	private void checkRemoveLine() {
		game.checkDeleteLines();
		
	}
	public void moveDown(){
		game.clearArray(Tetris.OCCUPATED);
		if(!game.moveDown()){
			game.writeFigure(game.getActiveShape());
			if(game.getActiveShape().getY()==Tetris.ENTRANCE_Y){
				stop();				
				game.change(Tetris.OCCUPATED, Tetris.CONFIRMED);
				JOptionPane.showMessageDialog(null, "Game Over");
			}else{
				game.confirm();
				game.checkDeleteLines();
			}
//			stop();
			
		}else
			game.writeFigure(game.getActiveShape());
	}

}
