package tetrisGUI;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import tetris.Tetris;
import tetris.Figure;

public class Tetris_GUI extends JFrame implements ActionListener, Serializable, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String authorInfoStr = "Made By: Andrey Yefremov 2015";
	private JButton jbtDown; 
	private JButton jbtStop; 
	private JButton jbtLeft; 
	private JButton jbtRight; 
	private JButton jbtRotateL; 
	private JButton jbtRotateR;
	private JButton jbtNextFigure;
	private JButton jbtSaveFigurePositon;
	public final static int MIDDLE = 0;
	public final static int DOWN = 1;
	public final static int LEFT = 2;
	public final static int RIGHT = 3;
	public final static int UP = 4;
	private GameWindowGUI gw;
	private Tetris game;
	
	private JPanel jPTestBtns;
	

	public Tetris_GUI(Tetris game){
		
		///initial code for main Frame(aka Window)
		// This code is almost same for all GUIes 
		setTitle("Tetris");					
		setSize(850,520);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setLayout(new BorderLayout(0,5));
		
		
		///end initial
		this.game = game;
		gw = new GameWindowGUI(this.game);//assigning game window
		gw.setFocusable(true);//this is need for make game window focused
		gw.addKeyListener(this);
		//Main panel---CENTRAL
		JPanel mainCentralPanel = new JPanel(new GridLayout(0,2));
		
		// LEFT PANEL CODE 
		JPanel leftPanel = new JPanel(new GridLayout());
		
		leftPanel.add(gw, BorderLayout.CENTER);
		leftPanel.setBorder(new TitledBorder("Left"));
		// End of LEFT Panel
		
		// RIGHT PANEL CODE 
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(new TitledBorder("Right"));
		jbtDown = new JButton("Down");
		jbtDown.addActionListener(this);
		jbtDown.setFocusable(false);// makining button not focusable for allowing to use keypad as input for game window (gw)
		jbtStop = new JButton("Stop");
		jbtStop.addActionListener(this);
		jbtStop.setFocusable(false);
		jbtLeft= new JButton("<<<Left<<<");	
		jbtLeft.addActionListener(this);
		jbtLeft.setFocusable(false);
		jbtRight = new JButton(">>>Right>>>");
		jbtRight.addActionListener(this);
		jbtRight.setFocusable(false);
		jbtRotateL = new JButton("Rotate L <--");
		jbtRotateL.addActionListener(this);
		jbtRotateL.setFocusable(false);
		jbtRotateR = new JButton("Rotate R -->");
		jbtRotateR.addActionListener(this);
		jbtRotateR.setFocusable(false);
		
		jbtNextFigure= new JButton("Next Figure");
		jbtNextFigure.addActionListener(this);
		jbtNextFigure.setFocusable(false);
		jbtSaveFigurePositon= new JButton("Save Figures Position");
		jbtSaveFigurePositon.addActionListener(this);
		jbtSaveFigurePositon.setFocusable(false);
		
		
		jPTestBtns = new JPanel(new GridLayout(4,2));
		jPTestBtns.add(jbtLeft);
		jPTestBtns.add(jbtRight);
		jPTestBtns.add(jbtDown);
		jPTestBtns.add(jbtNextFigure);
		jPTestBtns.add(jbtRotateL);
		jPTestBtns.add(jbtRotateR);
		jPTestBtns.add(jbtStop);
		jPTestBtns.add(jbtSaveFigurePositon);
		rightPanel.add(jPTestBtns);
		
		// End of RIGHT Panel
		
		
		mainCentralPanel.add(leftPanel);
		mainCentralPanel.add(rightPanel);
//		mainCentralPanel.setFocusable(true);
//		mainCentralPanel.addKeyListener(this);
		//End of CENTRAL code here
		
		
		add(mainCentralPanel, BorderLayout.CENTER);
		JLabel authorInfo = new JLabel(authorInfoStr, JLabel.CENTER);
		add(authorInfo, BorderLayout.SOUTH);
		
		setVisible(true);	
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jbtDown){
			
			game.clearArray(1);
			game.moveDown();
			game.writeFigure(game.getActiveShape());
		
		}else if(e.getSource()==jbtStop){
	        game.clearArray(3);
	        game.clearArray(1);
	    
		
		}else if(e.getSource()==jbtLeft){
			game.clearArray(1);
			game.moveLeft();
			game.writeFigure(game.getActiveShape());
	        
		
		}else if(e.getSource()==jbtRight){
			game.clearArray(1);
			game.moveRight();
			game.writeFigure(game.getActiveShape());
	        		
		}else if(e.getSource()==jbtRotateL){
			game.getActiveShape().rotate_counterclockwise();
			game.clearArray(1);

			if(game.test_position(game.getActiveShape().getY(),game.getActiveShape().getX())){
				
			}else{
				game.getActiveShape().rotate_clockwise();
			}
			game.clearArray(1);
			game.writeFigure(game.getActiveShape());

		
		}else if(e.getSource()==jbtRotateR){
			game.getActiveShape().rotate_clockwise();
			game.clearArray(1);

			if(game.test_position(game.getActiveShape().getY(),game.getActiveShape().getX())){
				
			}else{
				game.getActiveShape().rotate_counterclockwise();
			}
			game.clearArray(1);
			game.writeFigure(game.getActiveShape());
	
		}else if(e.getSource()==jbtNextFigure){
			game.setActiveShape(new Figure(Figure.getRandomFigure()));
			game.clearArray(1);
			game.writeFigure(game.getActiveShape());
//		
		}else if(e.getSource()==jbtSaveFigurePositon){
//			game.change(1, 3);
//			game.setGameGrid(game.getTetrisArray());
			game.confirm();
		}
//		
//		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			game.clearArray(1);
			game.moveRight();
			game.writeFigure(game.getActiveShape());
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			game.clearArray(1);
			game.moveLeft();
			game.writeFigure(game.getActiveShape());
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			game.clearArray(1);
			game.moveDown();
			game.writeFigure(game.getActiveShape());
		}else if(e.getKeyCode()==KeyEvent.VK_UP){
			game.getActiveShape().rotate_clockwise();
			game.clearArray(1);

			if(game.test_position(game.getActiveShape().getY(),game.getActiveShape().getX())){
				
			}else{
				game.getActiveShape().rotate_counterclockwise();
			}
			game.clearArray(1);
			game.writeFigure(game.getActiveShape());
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
	}


}
