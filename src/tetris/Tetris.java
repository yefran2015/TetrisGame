package tetris;

/**
 * This is home work assignment 2 for  ICS 340 class.
 * This program is emulate tetris game grid and one of it shape.
 * Also it provides ability to rotate active shape and checking if cells on game grid are not
 * occupied under active shape.
 * @author Andrey Yefremov
 * @version 0.0.1
 */
public class Tetris {
	public static final int EMPTY = 0;
	public static final int OCCUPATED =  1;
	public static final int BORDER = 2;
	public static final int CONFIRMED = 3;
	public static final int DELETE = 4;
	public static final int ENTRANCE_Y=0;
	public static final int ENTRANCE_X=6;
	public static int PLAYING_HORIZONTAL_SPACE=11;
	public static final int BORDER_BREADTH = 3;
	
	private int[][]  gameGrid;
	private Figure activeShape;
	private Figure nextShape;
	
	public Tetris(){
		gameGrid = TetrisGrids.GAME_GRID_3;
		PLAYING_HORIZONTAL_SPACE = gameGrid[0].length-1;
		activeShape = new Figure(Figures.ZZ, Tetris.ENTRANCE_Y, Tetris.ENTRANCE_X);
		nextShape = new Figure(Figure.getRandomFigure(), Tetris.ENTRANCE_Y, Tetris.ENTRANCE_X);
	}

	/**
	 * This method is returning gameGrid array;
	 * @return -- gameGrid array
	 */
	public int[][] getGameGrid() {
		return gameGrid;
	}

	/**
	 * This method is setting game grid to new from input array
	 * @param gameGrid --new gameGrid array
	 */
	public void setGameGrid(int[][] gameGrid) {
		this.gameGrid = gameGrid;
	}

	/**
	 * This method is taking integer gameGrid 2D array 
	 * and transforms it into string.
	 * @param gameGrid2 -- gameGrid Array which is integer 2D array
	 * @return -- string representation of given gameGrid array
	 */
	public String array_to_string(int[][] gameGrid2) {
		String answr = "";
		for(int i=0; i< gameGrid2.length; i++){
			for(int k =0; k< gameGrid2[i].length; k++){
				if(gameGrid2[i][k]==EMPTY)
					answr+="-";
				else
					if(gameGrid2[i][k]!=EMPTY )
						answr+="*";
			}
			answr+="\n";
		}
		return answr;
	}

	/**
	 * 
	 * This method is checking position under activeShape figure on gameGrid 
	 * and returns false if all cells are empty or true if not.
	 * @param i - y coordinate of upper left corner of active shape on gameGrid
	 * @param j -- x coordinate of upper left corner of active shape on gameGrid
	 * @return -- true if any cell under activeShape figure is not empty
	 * 		 and False if all cells empty for to place active shape to there 
	 */
	public boolean test_position(int i, int j) {

		for(int i1= i, shapesI=0; shapesI< activeShape.getFigure().length; i1++,shapesI++){
			for(int k = j, shapesK=0; shapesK< activeShape.getFigure()[shapesI].length; k++,shapesK++){
				if(activeShape.getFigure()[shapesI][shapesK]==OCCUPATED && gameGrid[i1][k]!=EMPTY){
					return false;
				}				
			}
		}
				
		return true;
	}
	
	private boolean test_left(){
		return(test_position(activeShape.getY(),activeShape.getX()-1));
	}
	private boolean test_right(){
		return(test_position(activeShape.getY(),activeShape.getX()+1));
	}
	private boolean test_down(){
		return(test_position(activeShape.getY()+1,activeShape.getX()));
	}
	
	public boolean moveLeft(){
		if(test_left()){
			activeShape.setX(activeShape.getX()-1);
			return true;
		}	
		return false;
	}
	public boolean moveRight(){
		if(test_right()){
			activeShape.setX(activeShape.getX()+1);
			return true;
		}	
		return false;
	}
	public boolean moveDown(){
		if(test_down()){
			activeShape.setY(activeShape.getY()+1);
			return true;
		}	
		return false;
	}
	
	/**
	 * This method is printing to console integer matrix with one row per line.
	 * @param matrix -- 2D array of integer numbers
	 */
	public static void printMatrixToConsole(int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j< matrix[i].length; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	public Figure getActiveShape() {
		return activeShape;
	}

	public void setActiveShape(Figure activeShape) {
		this.activeShape = activeShape;
	}

	public Figure getNextShape() {
		return nextShape;
	}

	public void setNextShape(Figure nextShape) {
		this.nextShape = nextShape;
	}

	public void clearArray(int numToClear){ // clearing array from specific number
		for(int i=0;i<gameGrid.length;i++){
			for(int k=0;k<gameGrid[i].length;k++){
				if(gameGrid[i][k]==numToClear){
					gameGrid[i][k]=EMPTY;
				}
			}
			
		}
	}

//	public void writeFigure(int[][] coordinates){//writing figure to tetrisArray if only another not exists on same cell
//		for(int i=0; i < coordinates.length; i++){
//			if(gameGrid[coordinates[i][0]][coordinates[i][1]]==1 || gameGrid[coordinates[i][0]][coordinates[i][1]]==2 ||
//					gameGrid[coordinates[i][0]][coordinates[i][1]]==3)
//				break;
//			else	
//				gameGrid[coordinates[i][0]][coordinates[i][1]]=1;
//		}
//	}
	public void confirm(){
		change(OCCUPATED,CONFIRMED);
		setActiveShape(nextShape);
		nextShape = new Figure(Figure.getRandomFigure());
	}
	
	
	public void writeFigure(Figure figure){//writing figure to tetrisArray if only another not exists on same cell
		for(int i=figure.getY(),m=0; m < figure.getFigure().length; i++,m++){
			for(int k = figure.getX(),j=0; j< figure.getFigure()[m].length;j++,k++)
				if(figure.getFigure()[m][j]==OCCUPATED)
					gameGrid[i][k]=OCCUPATED;
		}
	}
	public void change(int from, int to){ // metod to change one number to another in this set
		for(int i=0;i<gameGrid.length;i++){
			for(int k=0;k<gameGrid[i].length;k++){
				if(gameGrid[i][k]==from){
					gameGrid[i][k]=to;
				}
			}
			
		}
	}
	
	public void change(int from, int to, int onLineNum){ // metod to change one number to another in this set
		
			for(int k=0;k<gameGrid[onLineNum].length;k++){
				if(gameGrid[onLineNum][k]==from){
					gameGrid[onLineNum][k]=to;
				}
			}
			
		
	}

	public int[][] getTetrisArray() {
		return gameGrid;
	}
	
	public String toString(){
		return "Tetris Grid";
	}

	public void checkDeleteLines(){

		int count;
		for(int i= (gameGrid.length-1-Tetris.BORDER_BREADTH); i>0; i--){
			count = 0;
			for(int k=0; k<gameGrid[i].length; k++){
				if(gameGrid[i][k]==Tetris.CONFIRMED || gameGrid[i][k]== Tetris.BORDER){
					count++;

				}
			}

			if(count > Tetris.PLAYING_HORIZONTAL_SPACE){

				removeLineNumber(i);
				i++;//to allow checking of double deletionlines 
			}
		}
	}
	
	private void removeLineNumber(int lineNum) {
		this.change(CONFIRMED, DELETE, lineNum);
		  for(int i=lineNum; i> 0; i--){
			  for(int k=0; k<gameGrid[i].length;k++){
				  if(gameGrid[i][k]!=BORDER)
					  gameGrid[i][k]=gameGrid[i-1][k];
			  }
			  
		  }
		
	}
	
}
