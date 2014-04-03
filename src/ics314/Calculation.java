package ics314;

public class Calculation {
	
	private int PREV_COORD_X;
	private int PREV_COORD_Y;
	private int Quadrant;
	
	public Calculation()
	{
		init_Calc();
	}
	
	private void init_Calc()
	{
		PREV_COORD_X = Interface_Const.p_cx;
		PREV_COORD_Y = Interface_Const.p_cy;
		Quadrant = Interface_Const.Q_CENTER;
	}
	
	public int calculateToFrom(int x, int y, int angle)
	{
		PREV_COORD_X = x;
		PREV_COORD_Y= y;
		
		int rotated_x = getRotatedX(x,y,angle);
		int rotated_y = getRotatedY(x,y,angle);

		
		
		
		
		
		return Interface_Const.UNCHANGED;
		
	}
	
	public int calculateWestEast(int x, int y, int angle){
		PREV_COORD_Y = y;
		PREV_COORD_Y= y;
		
		return Interface_Const.UNCHANGED;
	}
	
	private int calculateQuadrant(int r_x, int r_y, int angle)
	{
		if(angle < Interface_Const.HALF_PI || angle == Interface_Const.TWO_PI){
			return rotatedByLessThanFourth(r_x, r_y, angle);
		} else if (angle >= Interface_Const.HALF_PI && 
				angle < Interface_Const.THREE_FORTH_PI) {
			
		}
	}
	
	private int rotatedByLessThanFourth(int r_x, int r_y, int angle)
	{
		
	}
	private int rotatedByFourth()
	private int rotatedByHalf()
	private int rotatedByThreeFourth()
	
	private int getRotatedX(int x, int y, int angle)
	{
		float cosine =(float)Math.cos(angle);
		float sine = (float)Math.sin(angle);
		int new_x = (int)(x*cosine -y*sine);
		return new_x;
	}
	
	private int getRotatedY(int x, int y, int angle)
	{
		float cosine =(float)Math.cos(angle);
		float sine = (float)Math.sin(angle);
		int new_y = (int)(x*sine + y*cosine);
		return new_y;
	}
	

	
}
