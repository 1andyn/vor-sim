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

		double opp = PLANE_COORD_X;
		double adj = PLANE_COORD_Y;
		int plane_angle = (int)Math.toDegrees(Math.atan2(opp,adj));
		int norm_angle = normalizedAngle(plane_angle);
		
		if(norm_angle == angle){
			TOFROM = WESTEAST = Interface_Const.CENTER;
			return;
		} else {
			if(norm_angle + angle < angle + Interface_Const.HALF_PI) {
				TOFROM = Interface_Const.FROM;
				WESTEAST = Interface_Const.EAST;
			} else if (norm_angle+ angle  < angle + Interface_Const.PI) {
				TOFROM = Interface_Const.TO;
				WESTEAST = Interface_Const.EAST;
			} else if (norm_angle + angle < angle + Interface_Const.THREE_FORTH_PI) {
				TOFROM = Interface_Const.TO;
				WESTEAST = Interface_Const.WEST;
			} else if (norm_angle + angle < angle + Interface_Const.TWO_PI) {
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
