package ics314;

public class Calculation {
	
	private int PREV_COORD_X;
	private int PREV_COORD_Y;
	
	public Calculation(){
		
	}
	
	public int calculateToFrom(int x, int y, int angle){
		PREV_COORD_X = x;
		PREV_COORD_Y= y;
		
		float cosine =(float)Math.cos(angle);
		float sine = (float)Math.sin(angle);
		
		int new_x = (int)(x*cosine -y*sine);
		if(x < new_x) {
			return Interface_Const.WEST;
		} else if (x > new_x) {
			return Interface_Const.EAST;
		} else {
			return Interface_Const.UNCHANGED;
		}
		
	}
	
	public int calculateWestEast(int x, int y, int angle){
		PREV_COORD_Y = y;
		PREV_COORD_Y= y;
		
		return Interface_Const.UNCHANGED;
	}
	
}
