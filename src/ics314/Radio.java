package ics314;

import java.util.Random;

public class Radio {
	private int USR_OBS_ANGLE;
	private int GOOD_BAD;
	private int OBS_ANGLE;

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
		USR_OBS_ANGLE = Vor_Const.START_ANGLE;
		generateRandomGoodBad();
		generateRandomOBS();
	}
	
	public void setOBSAngle(int angle)
	{
		USR_OBS_ANGLE = angle;
	}
	
	public void generateRandomOBS()
	{
		Random rand = new Random();
		int obs = rand.nextInt(360);
		OBS_ANGLE = obs;
	}
	
	public int getOBS() 
	{
		int temp = OBS_ANGLE;
		return temp;
	}
	
	public int getOBSAngle()
	{
		int temp = USR_OBS_ANGLE;
		return temp;
	}
	
	public void generateRandomGoodBad()
	{
		Random rand = new Random();
		int gb = rand.nextInt(2);
		GOOD_BAD = gb;
	}
	
	//Debug
	public void debugAngle()
	{
		System.out.println("OBS LOC ANGLE: " + OBS_ANGLE);
	}
	
}
