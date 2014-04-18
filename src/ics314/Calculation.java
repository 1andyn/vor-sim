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
		} else {
			return checkAbeam(vor.getRadioAngle(), vor.getOBSAngle());
		}
	}
	
	private int checkAbeam(int intercept, int course)
	{
		if((intercept-course)%Vor_Const.PERPENDICULAR == 0) {
			return Vor_Const.ABEAM;
		} else {
			return Vor_Const.NOT_ABEAM;
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
