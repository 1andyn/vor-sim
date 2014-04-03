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
	
	private void setPlaneCoords(int x, int y)
	{
		PLANE_COORD_X = x - Interface_Const.p_cx;
		PLANE_COORD_Y= Interface_Const.INVERT*(y - Interface_Const.p_cy);
	}
	
	public int calculateToFrom(int x, int y, int angle)
	{
		setPlaneCoords(x,y);
		updateOutputs(angle);
		return TOFROM;
	}
	
	public int calculateWestEast(int x, int y, int angle)
	{
		setPlaneCoords(x,y);
		updateOutputs(angle);
		return WESTEAST;	
	}
	
	private void updateOutputs(int angle)
	{
		int plane_angle;
		if(PLANE_COORD_Y == 0 || PLANE_COORD_X == 0){
			plane_angle = 0;
		} else {
			plane_angle = (int)Math.atan(PLANE_COORD_X/PLANE_COORD_Y);
		}
		
		int norm_angle = normalizedAngle(plane_angle);
		System.out.println("X" + PLANE_COORD_X);
		System.out.println("Y:" + PLANE_COORD_Y);
		System.out.println("Normalized Angle: " + norm_angle);
		
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
	
}
