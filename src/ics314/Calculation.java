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
		PLANE_COORD_X = Iface_Const.p_cx;
		PLANE_COORD_Y = Iface_Const.p_cy;
		TOFROM = Iface_Const.CENTER;
		WESTEAST = Iface_Const.CENTER;
	}
	
	private void setPlaneCoords(int x, int y)
	{
		PLANE_COORD_X = x - Iface_Const.p_cx;
		PLANE_COORD_Y= Iface_Const.INVERT*(y - Iface_Const.p_cy);
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
			TOFROM = WESTEAST = Iface_Const.CENTER;
			return;
		} else {
			if(norm_angle < ((angle + Iface_Const.HALF_PI)%
					Iface_Const.TWO_PI)) {
				TOFROM = Iface_Const.FROM;
				WESTEAST = Iface_Const.EAST;
			} else if (norm_angle < ((angle + Iface_Const.PI)%
			Iface_Const.TWO_PI)) {
				TOFROM = Iface_Const.TO;
				WESTEAST = Iface_Const.EAST;
			} else if (norm_angle < ((angle + 
					Iface_Const.THREE_FORTH_PI)%
					Iface_Const.TWO_PI)) {
				TOFROM = Iface_Const.TO;
				WESTEAST = Iface_Const.WEST;
			} else if (norm_angle < ((angle + Iface_Const.TWO_PI)%
					Iface_Const.TWO_PI)) {
				TOFROM = Iface_Const.FROM;
				WESTEAST = Iface_Const.WEST;
			} else {
				
			}
		}

	}

	public int normalizedAngle(int angle) 
	{
		return ((angle + Iface_Const.TWO_PI)%
			Iface_Const.TWO_PI);
	}
	
}
