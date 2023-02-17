package tetris;

public class Figures {
	public static final int TOTAL_FIGURES = 7;// 7:: ZZ, SS, L, G, LINE, SQUARE, T
	
	public static final int[][] ZZ= {
		 {0,0,1}
		,{0,1,1}
		,{0,1,0}
	 };
	public static final int[][] ZZ_2= {
		 {0,0,1,0}
		,{0,1,1,0}
		,{0,1,0,0}
		,{0,0,0,0}
	 };
	public static final int[][] SS= {
		 {0,1,0}
		,{0,1,1}
		,{0,0,1}
	};
	public static final int[][] SS_2= {
		 {0,1,0,0}
		,{0,1,1,0}
		,{0,0,1,0}
		,{0,0,0,0}
	};
	public static final int[][] L= {
		 {0,1,0}
		,{0,1,0}
		,{0,1,1}
	};
	public static final int[][] L_2= {
		 {0,1,0,0}
		,{0,1,0,0}
		,{0,1,1,0}
		,{0,0,0,0}
	};
	public static final int[][] G= {
		 {0,1,1}
		,{0,1,0}
		,{0,1,0}
	};
	public static final int[][] G_2= {
		 {0,1,1,0}
		,{0,1,0,0}
		,{0,1,0,0}
		,{0,0,0,0}
	};
	public static final int[][] LINE= {
		 {1,1,1,1}
		,{0,0,0,0}
		,{0,0,0,0}
		,{0,0,0,0}
	};
	
	public static final int[][] T= {
		 {0,1,0}
		,{1,1,1}
		,{0,0,0}
		
	};
	public static final int[][] SQUARE= {
		{1,1},
		{1,1}
	};
	public static final int[][] SQUARE_2= {
		 {0,0,0,0}
		,{0,1,1,0}
		,{0,1,1,0}
		,{0,0,0,0}
	};
	
	
	
}
