package tetris;

public class Figure extends Figures{

	
	public static final int MANY_FIGURES_IN_GAME= Figures.TOTAL_FIGURES;
	
	private int[][] figure;
	private int x;//x coordinate of left upper corner of this figure's matrix
	private int y;//y coordinate of left upper cornerof this figure's matrix
	public static final int WIDTH = 4;
	public static final int HEIGHT =4;
	
	public Figure(int[][] figure){
		this.figure= figure;
		x=Tetris.ENTRANCE_X;
		y=Tetris.ENTRANCE_Y;
	}
	
	public Figure(int[][] figure, int initialY, int initialX){
		this.figure = figure;
		x = initialX;
		y = initialY;
	}

	
	/**
	 * This method is rotating figure clockwise by using two loops.
	 * 
	 */
	public void rotate_clockwise() {		
		int[][] answrArr = new int[this.figure.length][this.figure[0].length];		
		for(int i=0; i<figure.length; i++){			
			for(int k = figure[i].length-1, j=0; k>=0; k--, j++){
				answrArr[i][j]=figure[k][i];
			}			
		}
		figure = answrArr;
		
	}
	public static int[][] rotate_clockwise(int[][] figure) {		
		int[][] answrArr = new int[figure.length][figure[0].length];		
		for(int i=0; i<figure.length; i++){			
			for(int k = figure[i].length-1, j=0; k>=0; k--, j++){
				answrArr[i][j]=figure[k][i];
			}			
		}
		return answrArr;
		
	}
	public void rotate_counterclockwise() {		
		int[][] answrArr = new int[this.figure.length][this.figure[0].length];		
		for(int i=figure.length-1,l=0; i>=0 && l<figure.length; i--,l++){			
			for(int k = 0; k< figure[i].length;k++){
				answrArr[l][k]=figure[k][i];
			}			
		}
		figure = answrArr;
		
	}
	public static int[][] rotate_counterclockwise(int[][] figure) {		
		int[][] answrArr = new int[figure.length][figure[0].length];		
		for(int i=figure.length-1,l=0; i>=0 && l<figure.length; i--,l++){			
			for(int k = 0; k< figure[i].length;k++){
				answrArr[l][k]=figure[k][i];
			}			
		}
		return answrArr;
		
	}
	

	
	
	public int[][] getFigure() {
		return figure;
	}

	public void setFigure(int[][] figure) {
		this.figure = figure;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public static int[][] getRandomFigure(){
		int randNum = (int)(MANY_FIGURES_IN_GAME*Math.random())+1;
		
		switch(randNum){
			case 1: 
				return Figures.ZZ;
			case 2: 
				return Figures.SS;
			case 3: 
				return Figures.L;
			case 4: 
				return Figures.G;
			case 5: 
				return Figures.SQUARE;
			case 6: 
				return Figures.LINE;
			case 7: 
				return Figures.T;
		}
		
		return Figures.LINE;
	}
	
	public String toString(){
		return "Figure Class"; 
	}
	
}
