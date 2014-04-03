package ics314;

public class Calculation {
	
	private int PLANE_COORD_X; // Normalized X Coordinate of Plane
	private int PLANE_COORD_Y; // Normalized Y Coordinate of Plane
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
		PLANE_COORD_X = x - Interface_Const.p_cx;
		PLANE_COORD_Y= y - Interface_Const.p_cy;
		
		int rotated_x = getRotatedX(angle);
		int rotated_y = getRotatedY(angle);

		updateOutputs(rotated_x, rotated_y, angle);
		return TOFROM;
	}
	
	public int calculateWestEast(int x, int y, int angle)
	{
		PLANE_COORD_X = x - Interface_Const.p_cx;
		PLANE_COORD_Y= y - Interface_Const.p_cy;
		
		int rotated_x = getRotatedX(angle);
		int rotated_y = getRotatedY(angle);

		updateOutputs(rotated_x, rotated_y, angle);
		return WESTEAST;	
	}
	
	
	private void updateOutputs(int r_x, int r_y, int angle)
	{
		int plane_angle = (int)Math.asin(PLANE_COORD_X/PLANE_COORD_Y);
		int norm_angle = normalizedAngle(plane_angle);
		if(norm_angle == angle){
			TOFROM = WESTEAST = Interface_Const.CENTER;
			return;
		} else {
			if(norm_angle < angle + Interface_Const.HALF_PI) {
				TOFROM = Interface_Const.FROM;
				WESTEAST = Interface_Const.EAST;
			} else if (norm_angle < angle + Interface_Const.PI) {
				TOFROM = Interface_Const.TO;
				WESTEAST = Interface_Const.EAST;
			} else if (norm_angle < angle + Interface_Const.THREE_FORTH_PI) {
				TOFROM = Interface_Const.TO;
				WESTEAST = Interface_Const.WEST;
			} else if (norm_angle < angle + Interface_Const.TWO_PI) {
				TOFROM = Interface_Const.FROM;
				WESTEAST = Interface_Const.WEST;
			} else {
				
			}
		}

	}

	public int normalizedAngle(int angle) 
	{
		return ((angle + Interface_Const.TWO_PI)%
				Interface_Const.TWO_PI);
	}
	
	/* Angle is negative since negative angle rotated CLOCK WISE*/
	
	private int getRotatedX(int angle)
	{
		float cosine =(float)Math.cos(-angle);
		float sine = (float)Math.sin(-angle);
		int new_x = (int)(PLANE_COORD_X*cosine -PLANE_COORD_Y*sine);
		return new_x;
	}
	
	private int getRotatedY(int angle)
	{
		float cosine =(float)Math.cos(-angle);
		float sine = (float)Math.sin(-angle);
		int new_y = (int)(PLANE_COORD_X*sine + PLANE_COORD_Y*cosine);
		return new_y;
	}
	

	
}
