package ics314;

public class Radio {
	private int PLANE_X_COORD;
	private int PLANE_Y_COORD;
	private int PLANE_ANGLE;
	private int OBS_ANGLE;
	
	public Radio(int x, int y, int p, int o)
	{
		PLANE_X_COORD = x;
		PLANE_Y_COORD = y;
		PLANE_ANGLE = p;
		OBS_ANGLE = o;
	}
	
	public Radio()
	{
		initRadio();
	}
	
	private void initRadio()
	{
		PLANE_X_COORD = Interface_Const.START_COORD;
		PLANE_Y_COORD = Interface_Const.START_COORD;
		PLANE_ANGLE = Interface_Const.START_ANGLE;
		OBS_ANGLE = Interface_Const.START_ANGLE;
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
	
}
