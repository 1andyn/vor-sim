package ics314;

public class Calculation {
	
	private int TOFROM;
	private int OBS_ANGLE;
	private int RADIO_DEFLECTION;
	
	public Calculation()
	{
		init_Calc();
	}
	
	private void init_Calc()
	{

	}
	
//	public int calculateToFrom(int x, int y, int angle)
//	{
//		setPlaneCoords(x,y);
//		updateOutputs(angle);
//		return TOFROM;
//	}
//	
//	public int calculateWestEast(int x, int y, int angle)
//	{
//		setPlaneCoords(x,y);
//		updateOutputs(angle);
//		return WESTEAST;	
//	}
	
//	private void updateOutputs(int angle)
//	{
//
//		double opp = PLANE_COORD_X;
//		double adj = PLANE_COORD_Y;
//		int plane_angle = (int)Math.toDegrees(Math.atan2(opp,adj));
//		int norm_angle = normalizedAngle(plane_angle);
//		
//		if(norm_angle == angle){
//			TOFROM = WESTEAST = Vor_Const.CENTER;
//			return;
//		} else {
//			if(norm_angle < ((angle + Vor_Const.HALF_PI)%
//					Vor_Const.TWO_PI)) {
//				TOFROM = Vor_Const.FROM;
//				WESTEAST = Vor_Const.EAST;
//			} else if (norm_angle < ((angle + Vor_Const.PI)%
//			Vor_Const.TWO_PI)) {
//				TOFROM = Vor_Const.TO;
//				WESTEAST = Vor_Const.EAST;
//			} else if (norm_angle < ((angle + 
//					Vor_Const.THREE_FORTH_PI)%
//					Vor_Const.TWO_PI)) {
//				TOFROM = Vor_Const.TO;
//				WESTEAST = Vor_Const.WEST;
//			} else if (norm_angle < ((angle + Vor_Const.TWO_PI)%
//					Vor_Const.TWO_PI)) {
//				TOFROM = Vor_Const.FROM;
//				WESTEAST = Vor_Const.WEST;
//			} else {
//				
//			}
//		}
//
//	}

	public int normalizedAngle(int angle) 
	{
		return ((angle + Vor_Const.TWO_PI)%
			Vor_Const.TWO_PI);
	}
	
}
