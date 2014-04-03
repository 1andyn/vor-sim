package ics314;

public class Calculation {
	
	private int PLANE_COORD_X; // X Coordinate of Plane
	private int PLANE_COORD_Y; // Y Coordinate of Plane
	private int TOFROM;
	private int WESTEAST;
	
	public Calculation()
	{
		init_Calc();
	}
	
	private void init_Calc()
	{
		PLANE_COORD_X = Interface_Const.p_cx;
		PLANE_COORD_Y = Interface_Const.p_cy;
		TOFROM = Interface_Const.CENTER;
		WESTEAST = Interface_Const.CENTER;
	}
	
	public int calculateToFrom(int x, int y, int angle)
	{
		PLANE_COORD_X = x;
		PLANE_COORD_Y= y;
		
		int rotated_x = getRotatedX(x,y,angle);
		int rotated_y = getRotatedY(x,y,angle);

		updateQuadrant(rotated_x, rotated_y, angle);
		return TOFROM;
	}
	
	public int calculateWestEast(int x, int y, int angle)
	{
		PLANE_COORD_X = x;
		PLANE_COORD_Y= y;
		
		int rotated_x = getRotatedX(x,y,angle);
		int rotated_y = getRotatedY(x,y,angle);

		updateQuadrant(rotated_x, rotated_y, angle);
		return WESTEAST;	
	}
	
	private void updateQuadrant(int r_x, int r_y, int angle)
	{
		if(angle < Interface_Const.HALF_PI || angle == Interface_Const.TWO_PI ){
			rotatedByLessThanFourth(r_x, r_y, angle);
		} else if (angle >= Interface_Const.HALF_PI && 
				angle < Interface_Const.PI) {
			rotatedByFourth(r_x, r_y, angle);
		} else if (angle >= Interface_Const.PI &&
				angle < Interface_Const.THREE_FORTH_PI) {
			rotatedByHalf(r_x, r_y, angle);
		} else if (angle >= Interface_Const.THREE_FORTH_PI &&
				angle < Interface_Const.TWO_PI) {
			rotatedByThreeFourth(r_x, r_y, angle);
		} else {
			/* This should not occur ever */
			System.out.println("Quadrant function failed.");
		}
	}
	
	/*	If Rotated by Less than 90 Deg, zero or greater
			WESTEAST -> Compare R_X with X, TOFROM -> R_Y with Y
		If Rotated by 90, less than 180,
			WESTEAST -> Compare R_X with Y, TOFROM -> R_Y with X
		If Rotated by 180, less than 270
			WESTEAST -> Compare R_X with -X, TOFROM -> R_Y with -Y
		If Rotated by 270, less than 360
			WESTEAST -> Compare R_X with -Y, TOFROM -> R_Y with -X
	*/
	private void rotatedByLessThanFourth(int r_x, int r_y, int angle)
	{
		
		if(r_x == PLANE_COORD_X) {
			WESTEAST = Interface_Const.CENTER;
		} else if (r_x > PLANE_COORD_X) {
			WESTEAST= Interface_Const.
		}
		
		
		//if(PLANE_COORD_X > r_x )
	}
	private void rotatedByFourth(int r_x, int r_y, int angle)
	{
		
	}
	
	private void rotatedByHalf(int r_x, int r_y, int angle)
	{
		
	}
	
	private void rotatedByThreeFourth(int r_x, int r_y, int angle)
	{
		
	}
	
	/* Angle is negative since negative angle rotated CLOCK WISE*/
	
	private int getRotatedX(int x, int y, int angle)
	{
		float cosine =(float)Math.cos(-angle);
		float sine = (float)Math.sin(-angle);
		int new_x = (int)(x*cosine -y*sine);
		return new_x;
	}
	
	private int getRotatedY(int x, int y, int angle)
	{
		float cosine =(float)Math.cos(-angle);
		float sine = (float)Math.sin(-angle);
		int new_y = (int)(x*sine + y*cosine);
		return new_y;
	}
	

	
}
