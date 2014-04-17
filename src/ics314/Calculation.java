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
	


	public int normalizedAngle(int angle) 
	{
		return ((angle + Vor_Const.TWO_PI)%
			Vor_Const.TWO_PI);
	}
	
}
