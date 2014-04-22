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
			return checkAbeam(vor.getOBSAngle(), vor.getRadioAngle());
		}
	}
	
	private int normNegAngle(int x) {
		if(x < 0) {
			return(Vor_Const.TWO_PI + x);
		} else {
			return x;
		}
	}
	
	private int checkAbeam(int crs, int icp)
	{
		int abeam_a, abeam_b;
		abeam_a = (crs+Vor_Const.HALF_PI)%Vor_Const.TWO_PI;
		abeam_b = crs-Vor_Const.HALF_PI;
		
		abeam_b = normNegAngle(abeam_b);
		
		// Abeam Angles
		int[] badangles;
		badangles = new int[6];
		badangles[0] = abeam_a;
		badangles[1] = abeam_b;
		badangles[2] = (abeam_a + Vor_Const.ABEAM_OFFSET)%Vor_Const.TWO_PI;
		badangles[3] = (abeam_b + Vor_Const.ABEAM_OFFSET)%Vor_Const.TWO_PI;
		badangles[4] = normNegAngle(abeam_a - Vor_Const.ABEAM_OFFSET);
		badangles[5] = normNegAngle(abeam_b - Vor_Const.ABEAM_OFFSET);

		for(int x = 0; x < 6; x++) {
			System.out.println(x + " " + badangles[x]);
			if(badangles[x] == icp) {
				return Vor_Const.BAD;
			}
		}
		return Vor_Const.GOOD;
	}
	
	public int calculateToFrom(Radio vor)
	{
		int interceptedRadial = vor.getRadioAngle();
		int Course = vor.getOBSAngle();
		
		/* Less than angle */
		int firstangle = (Course + Vor_Const.HALF_PI)%Vor_Const.TWO_PI;
		
		/* Greater than angle */
		int secondangle = ((Course-Vor_Const.HALF_PI)%Vor_Const.TWO_PI);
		if(secondangle < 0) {
			/* If Negative, Wrap Around */
			secondangle = secondangle + Vor_Const.TWO_PI;
		}
		
		if(firstangle < secondangle) {
			if (interceptedRadial==((Course+Vor_Const.HALF_PI)%Vor_Const.TWO_PI) 
            		|| interceptedRadial==((Course-Vor_Const.HALF_PI)%Vor_Const.TWO_PI)) {
            	return Vor_Const.OFF;
			}
			else if(interceptedRadial < secondangle && interceptedRadial > firstangle){
                return Vor_Const.TO;
            } else {
                return Vor_Const.FROM;
            }
		} else {
			if (interceptedRadial==((Course+Vor_Const.HALF_PI)%Vor_Const.TWO_PI) 
	        		|| interceptedRadial==((Course-Vor_Const.HALF_PI)%Vor_Const.TWO_PI)) {
	        	return Vor_Const.OFF;
			} else if(interceptedRadial > secondangle && interceptedRadial < firstangle) {
				return Vor_Const.FROM;
	        } else {
	           return Vor_Const.TO;
	        }
		}
    }

	public int calculateDeflection(Radio vor)
	{
		return (vor.getRadioAngle() - vor.getOBSAngle());

	}
	
}
