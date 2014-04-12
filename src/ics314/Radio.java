package ics314;

public class Radio {
	private int DEFLECTION;
	private int OBS_ANGLE;
	private int GOOD_BAD;
	private Calculation VOR_CALC;
	
	public Radio(int x, int y, int p, int o)
	{
		VOR_CALC = new Calculation();
		OBS_ANGLE = o;
	}
	
	public Radio()
	{
		initRadio();
	}
	
	public int getGoodBad()
	{
		return GOOD_BAD;
	}
	
	private void initRadio()
	{
		VOR_CALC = new Calculation();
		OBS_ANGLE = Iface_Const.START_ANGLE;

	}
	
	public void setOBSAngle(int angle)
	{
		OBS_ANGLE = angle;
	}
	
	
	public int getOBSAngle()
	{
		int temp = OBS_ANGLE;
		return temp;
	}
	
	//Debug
	public void debugCoord()
	{

	}
	
	//Debug
	public void debugAngle()
	{
	}
	
}
