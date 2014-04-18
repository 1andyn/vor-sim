package ics314;

public class Calculation {
	
	public Calculation()
	{
		//Constructor
	}
	
	public int calculateBad(Radio vor)
	{
		/* First Case is when VOR says BAD (too close)*/
		if(vor.getGoodBad() == Vor_Const.BAD) {
			return Vor_Const.BAD;
		}
	}
	
	public int calculateToFrom(Radio vor)
	{
		return 0;
	}
	
	public int updateDeflection()
	{
		return 0;
	}
	
	public int calculateDeflection(Radio vor)
	{
		return (vor.getRadioAngle() - vor.getOBSAngle());
	}
	
}
