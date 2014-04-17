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
	public void testGoodBad() {
		Calculation test = new Calculation();
		Radio vor = new Radio();
		int result = test.calculateBad(vor);
		if(vor.getGoodBad() == Vor_Const.BAD) {
			assertEquals("test should return BAD", result, Vor_Const.BAD);
		} else {
			int interceptedRadial = vor.getRadioAngle();
			int course = vor.getOBSAngle();
			if(((interceptedRadial-course)% Vor_Const.PERPENDICULAR) == 0) {
				assertEquals("test should return BAD", result, Vor_Const.BAD);
			} else {
				assertEquals("test should return GOOD", result, Vor_Const.GOOD);
			}
		}
	}
	
	@Test
	public void testToFromResult() {
		
	}

}
