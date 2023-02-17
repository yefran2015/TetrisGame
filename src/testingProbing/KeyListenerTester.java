package testingProbing;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class KeyListenerTester extends JFrame implements KeyListener, Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KeyListenerTester(){

		setSize(new Dimension(600,500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		addKeyListener(this);
		add(new JPanel());
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("GGGGGGGGGG");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("GGGGGGGGGG");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("GGGGGGGGGG");
		
	}
	


}
