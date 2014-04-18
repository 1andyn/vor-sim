package ics314;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculationTest {

	public CalculationTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeflect(){
		Calculation test = new Calculation();
		Radio vor = new Radio();
		int interceptedradial = vor.getRadioAngle();
		for(int x = 0; x < 359; x++) {
			vor.setOBSAngle(x);
			int course = vor.getOBSAngle();
			int result = interceptedradial - course;
			assertEquals("Radial Difference", result,test.calculateDeflection(vor));
		}
	}
	
	@Test
	public void testGoodBad() {
		Calculation test = new Calculation();
		Radio vor = new Radio();
		for(int x = 0; x < 359; x++) {
			vor.setOBSAngle(x);
			int interceptedRadial = vor.getRadioAngle();
			int course = vor.getOBSAngle();
			int result = test.calculateBad(vor);
			if(vor.getGoodBad() == Vor_Const.BAD) {
				assertEquals("test should return BAD", result, Vor_Const.BAD);
			} else {
				if(((interceptedRadial-course)%Vor_Const.PERPENDICULAR) == 0) {
					assertEquals("test should return BAD", result, Vor_Const.BAD);
				} else {
					assertEquals("test should return GOOD", result, Vor_Const.GOOD);
				}
			}
		}
	}
	
	@Test
	public void testToFromResult() {
		Calculation test = new Calculation();
		Radio vor = new Radio();
		int result = test.calculateToFrom(vor);
		
	}

}
