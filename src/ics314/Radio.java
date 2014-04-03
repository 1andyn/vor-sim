package ics314;

public class Radio {
	private int PLANE_X_COORD;
	private int PLANE_Y_COORD;
	private int PLANE_ANGLE;
	private int OBS_ANGLE;
	private int WEST_EAST;
	private int NORTH_SOUTH;
	private Calculation VOR_CALC;
	
	public Radio(int x, int y, int p, int o)
	{
		VOR_CALC = new Calculation();
		PLANE_X_COORD = x;
		PLANE_Y_COORD = y;
		PLANE_ANGLE = p;
		OBS_ANGLE = o;
		NORTH_SOUTH = Interface_Const.CENTER;
		WEST_EAST = Interface_Const.CENTER;
	}
	
	public Radio()
	{
		initRadio();
	}
	
	private void initRadio()
	{
		VOR_CALC = new Calculation();
		PLANE_X_COORD = Interface_Const.p_cx;
		PLANE_Y_COORD = Interface_Const.p_cy;
		PLANE_ANGLE = Interface_Const.START_ANGLE;
		OBS_ANGLE = Interface_Const.START_ANGLE;
		NORTH_SOUTH = Interface_Const.CENTER;
		WEST_EAST = Interface_Const.CENTER;
	}
	
	public void updateToFrom()
	{
		 NORTH_SOUTH = VOR_CALC.calculateToFrom(PLANE_X_COORD,
				 PLANE_Y_COORD,OBS_ANGLE);
	}
	
	public void updateWestEast()
	{
		WEST_EAST = VOR_CALC.calculateWestEast(PLANE_X_COORD,
				 PLANE_Y_COORD,OBS_ANGLE);
	}
	
	public void updateDisplays()
	{
		updateToFrom();
		updateWestEast();
	}
	
	public int getToFrom(){
		return NORTH_SOUTH;
	}
	
	public int getWestEast(){
		return WEST_EAST;
	}
	
	public void setPlaneAngle(int angle)
	{
		PLANE_ANGLE = angle;
	}
	
	public void setOBSAngle(int angle)
	{
		OBS_ANGLE = angle;
	}
	
	public void setXCoord(int x)
	{
		PLANE_X_COORD = x;
	}
	
	public void setYCoord(int y)
	{
		PLANE_Y_COORD = y;
	}
	
	public int getPlaneAngle()
	{
		int temp = PLANE_ANGLE;
		return temp;
	}
	
	public int getXCoord()
	{
		int temp = PLANE_X_COORD;
		return temp;
	}
	
	public int getYCoord()
	{
		int temp = PLANE_Y_COORD;
		return temp;
	}
	
	public int getOBSAngle()
	{
		int temp = OBS_ANGLE;
		return temp;
	}
	
	//Debug
	public void debugCoord()
	{
		 System.out.println("Current Coordinates are: " + getXCoord() + ", "
				 + getYCoord());
	}
	
	//Debug
	public void debugAngle()
	{
		 System.out.println("Current Angles are PLANE: " + getPlaneAngle() + ", OBS: "
				 + getOBSAngle());
	}
	
}
