package tetris;

public class Grids_Creator {
	public static final int DEFAULT_HEIGHT = 100;
	public static final int DEFAULT_WEIGHT = 100;

	public static void main(String[] args) {
		System.out.println(getGrid(DEFAULT_HEIGHT, DEFAULT_WEIGHT));

	}
	
//	public static int[][] getGrid(int height, int weight){
//		int[][] answr = new int[weight][height];
//		
//		
//		return answr;
//	}
	
	public static String getGrid(int height, int weight){
		String answr ="{\n";
		for(int i=0; i< height;i++) {
			answr+="{";
			for (int k=0;k<weight;k++) {
//				answr+="{";
				answr+="0";
//				answr+="}";
				if(k<weight-1)
					answr+=",";
			}
			
			answr+="}";
			if(i<height-1)
				answr+=",";
			answr+="\n";
		}
		answr+="}";
		
		
		return answr;
	}

}
