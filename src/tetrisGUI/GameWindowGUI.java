package tetrisGUI;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import tetris.Tetris;



public class GameWindowGUI extends JPanel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int GRID_COLUMNS = 17;
	private final int GRID_ROWS = 23;
	private  int WIN_WIDTH = 325;
	private  int WIN_HEIGHT = 420;
	private  int SQUARE_WIDTH = (WIN_WIDTH / GRID_COLUMNS);
	private  int SQUARE_HEIGHT = (WIN_HEIGHT / GRID_ROWS);
	private int[][][] coordTable;//Table of upper left corner coordinates x and y
	private Tetris tetrisTbl;
	
	public GameWindowGUI(Tetris tetrisTbl){
		this.tetrisTbl = tetrisTbl;
		setCoordinatesArrs();
	}
	
	
	private void setCoordinatesArrs(){//this method setting upper left corner coordinates by given board size
		coordTable = new int[GRID_ROWS][GRID_COLUMNS][2];
		for(int i=0; i< coordTable.length;i++){
			for(int k=0;k<coordTable[i].length;k++){
				coordTable[i][k][0]= i*SQUARE_HEIGHT;
				coordTable[i][k][1]= k*SQUARE_WIDTH;
			}
		}
	}
	
	
	@Override
	protected void paintComponent(Graphics g){
		super.setSize(WIN_WIDTH,WIN_HEIGHT);
		this.setBorder(new LineBorder(Color.RED, 1));
			for(int i=0; i< coordTable.length;i++){
				for(int k=0;k<coordTable[i].length;k++){
					
					switch(tetrisTbl.getGameGrid()[i][k]){
						case Tetris.EMPTY: 
							g.setColor(Color.WHITE);
							break;
						case Tetris.OCCUPATED: 
							g.setColor(Color.GREEN);
							break;
						case Tetris.BORDER: 
							g.setColor(Color.RED);
							break;
						case Tetris.CONFIRMED: 
							g.setColor(Color.BLUE);
							break;
						case Tetris.DELETE: 
							g.setColor(Color.ORANGE);
							break;
					}
					g.fill3DRect(coordTable[i][k][1], coordTable[i][k][0], SQUARE_WIDTH, SQUARE_HEIGHT, true);
				}
			}
	}


	public Tetris getTetrisTbl() {
		return tetrisTbl;
	}


	public void setTetrisTbl(Tetris tetrisTbl) {
		this.tetrisTbl = tetrisTbl;
	}


	


}
