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
	/* This should use PARAMETERIZED TESTS instead */
	public void testGoodBad() {
		Calculation test = new Calculation();
		Radio vor = new Radio();
		vor.setGoodBad(Vor_Const.BAD);
		vor.setRadioAngle(0);
		int gb;
		for(int x = 0; x < 360; x++) {
			vor.setOBSAngle(x);
			gb = test.calculateBad(vor);
			assertEquals("Should always be bad", gb, Vor_Const.BAD);
		}
		vor.setGoodBad(Vor_Const.GOOD);
		gb = test.calculateBad(vor);
		
		vor.setRadioAngle(89);
		vor.setOBSAngle(89);
		gb = test.calculateBad(vor);
		assertEquals("GOOD 89", gb, Vor_Const.GOOD);
		vor.setOBSAngle(357);
		gb = test.calculateBad(vor);
		assertEquals("GOOD 357", gb, Vor_Const.GOOD);
		vor.setOBSAngle(358);
		gb = test.calculateBad(vor);
		assertEquals("BAD 358", gb, Vor_Const.BAD);
		vor.setOBSAngle(359);
		gb = test.calculateBad(vor);
		assertEquals("BAD 359", gb, Vor_Const.BAD);
		vor.setOBSAngle(0);
		gb = test.calculateBad(vor);
		assertEquals("BAD", gb, Vor_Const.BAD);
		vor.setOBSAngle(1);
		gb = test.calculateBad(vor);
		assertEquals("GOOD", gb, Vor_Const.GOOD);
	}
	
	@Test
	public void testToFromResult() {
		Calculation test = new Calculation();
		Radio vor = new Radio();
		vor.setOBSAngle(0);
		vor.setRadioAngle(0);

		/* Testings Plane at 0 == 360 */
		int result = test.calculateToFrom(vor);
		assertEquals("0:0 - Expect FROM", result, Vor_Const.FROM);
		vor.setOBSAngle(89);
		result = test.calculateToFrom(vor);
		assertEquals("0:89 - Expect FROM", result, Vor_Const.FROM);
		vor.setOBSAngle(90);
		result = test.calculateToFrom(vor);
		assertEquals("0:90 - Expect OFF", result, Vor_Const.OFF);
		vor.setOBSAngle(91);
		result = test.calculateToFrom(vor);
		assertEquals("0:91 - Expect TO", result, Vor_Const.TO);
		
	
		vor.setOBSAngle(269);
		result = test.calculateToFrom(vor);
		assertEquals("0:269 - Expect TO", result, Vor_Const.TO);
		vor.setOBSAngle(270);
		result = test.calculateToFrom(vor);
		assertEquals("0:270 - Expect OFF", result, Vor_Const.OFF);
		vor.setOBSAngle(271);
		result = test.calculateToFrom(vor);
		assertEquals("0:271 - Expect FROM", result, Vor_Const.FROM);
		
		/* Testings Plane at 90 */	
		vor.setRadioAngle(90);
		vor.setOBSAngle(359);
		result = test.calculateToFrom(vor);
		assertEquals("90:359 - Expect TO", result, Vor_Const.TO);
		vor.setOBSAngle(0);
		result = test.calculateToFrom(vor);
		assertEquals("90:0 - Expect OFF", result, Vor_Const.OFF);
		vor.setOBSAngle(1);
		result = test.calculateToFrom(vor);
		assertEquals("90:1 - Expect FROM", result, Vor_Const.FROM);
		
		vor.setOBSAngle(90);
		result = test.calculateToFrom(vor);
		assertEquals("90:90 - Expect FROM", result, Vor_Const.FROM);
		vor.setOBSAngle(179);
		result = test.calculateToFrom(vor);
		assertEquals("90:179 - Expect FROM", result, Vor_Const.FROM);
		vor.setOBSAngle(180);
		result = test.calculateToFrom(vor);
		assertEquals("90:180 - Expect OFF", result, Vor_Const.OFF);
		vor.setOBSAngle(181);
		result = test.calculateToFrom(vor);
		assertEquals("90:181 - Expect TO", result, Vor_Const.TO);
		
		/* Testings Plane at 180 */
		vor.setRadioAngle(180);
		vor.setOBSAngle(89);
		result = test.calculateToFrom(vor);
		assertEquals("180:89 - Expect TO", result, Vor_Const.TO);
		vor.setOBSAngle(90);
		result = test.calculateToFrom(vor);
		assertEquals("180:90 - Expect OFF", result, Vor_Const.OFF);
		vor.setOBSAngle(91);
		result = test.calculateToFrom(vor);
		assertEquals("180:91 - Expect FROM", result, Vor_Const.FROM);

		vor.setOBSAngle(180);
		result = test.calculateToFrom(vor);
		assertEquals("180:180 - Expect FROM", result, Vor_Const.FROM);
		vor.setOBSAngle(269);
		result = test.calculateToFrom(vor);
		assertEquals("180:269 - Expect FROM", result, Vor_Const.FROM);
		vor.setOBSAngle(270);
		result = test.calculateToFrom(vor);
		assertEquals("180:270 - Expect OFF", result, Vor_Const.OFF);
		vor.setOBSAngle(272);
		result = test.calculateToFrom(vor);
		assertEquals("180:271 - Expect TO", result, Vor_Const.TO);
				
		/* Testings Plane at 270 */
		vor.setRadioAngle(270);
		vor.setOBSAngle(179);
		result = test.calculateToFrom(vor);
		assertEquals("270:179 - Expect TO", result, Vor_Const.TO);
		vor.setOBSAngle(180);
		result = test.calculateToFrom(vor);
		assertEquals("270:180 - Expect OFF", result, Vor_Const.OFF);
		vor.setOBSAngle(181);
		result = test.calculateToFrom(vor);
		assertEquals("270:181 - Expect FROM", result, Vor_Const.FROM);
		
		vor.setOBSAngle(270);
		result = test.calculateToFrom(vor);
		assertEquals("270:270 - Expect FROM", result, Vor_Const.FROM);
		vor.setOBSAngle(359);
		result = test.calculateToFrom(vor);
		assertEquals("270:359 - Expect FROM", result, Vor_Const.FROM);
		vor.setOBSAngle(0);
		result = test.calculateToFrom(vor);
		assertEquals("270:0 - Expect OFF", result, Vor_Const.OFF);
		vor.setOBSAngle(1);
		result = test.calculateToFrom(vor);
		assertEquals("270:1 - Expect TO", result, Vor_Const.TO);
		
		/* Outlier Test (Testing 0/360 Wrapping) */
		vor.setRadioAngle(330);
		vor.setOBSAngle(239);
		result = test.calculateToFrom(vor);
		assertEquals("330:179 - Expect TO", result, Vor_Const.TO);
		vor.setOBSAngle(240);
		result = test.calculateToFrom(vor);
		assertEquals("330:180 - Expect OFF", result, Vor_Const.OFF);
		vor.setOBSAngle(241);
		result = test.calculateToFrom(vor);
		assertEquals("330:181 - Expect FROM", result, Vor_Const.FROM);
		
		vor.setOBSAngle(330);
		result = test.calculateToFrom(vor);
		assertEquals("330:330 - Expect FROM", result, Vor_Const.FROM);
		vor.setOBSAngle(59);
		result = test.calculateToFrom(vor);
		assertEquals("330:59 - Expect FROM", result, Vor_Const.FROM);
		vor.setOBSAngle(60);
		result = test.calculateToFrom(vor);
		assertEquals("330:0 - Expect OFF", result, Vor_Const.OFF);
		vor.setOBSAngle(61);
		result = test.calculateToFrom(vor);
		assertEquals("330:61 - Expect TO", result, Vor_Const.TO);
		
	}

}
