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
		//Needs to be rewritten
	}
	
	@Test
	public void testToFromResult() {
		Calculation test = new Calculation();
		Radio vor = new Radio();
		vor.setOBSAngle(0);
		vor.setRadioAngle(20);
		int result = test.calculateToFrom(vor);
		assertEquals("EXPECTING FROM #1", result, Vor_Const.FROM);
		vor.setOBSAngle(80);
		result = test.calculateToFrom(vor);
		assertEquals("EXPECTING FROM #2", result, Vor_Const.FROM);
		vor.setOBSAngle(110);
		result = test.calculateToFrom(vor);
		assertEquals("EXPECTING OFF #3", result, Vor_Const.OFF);
		vor.setOBSAngle(130);
		result = test.calculateToFrom(vor);
		assertEquals("EXPECTING TO #4", result, Vor_Const.TO);
		vor.setOBSAngle(290);
		result = test.calculateToFrom(vor);
		assertEquals("EXPECTING OFF #5", result, Vor_Const.OFF);
		vor.setOBSAngle(310);
		result = test.calculateToFrom(vor);
		assertEquals("EXPECTING FROM #6", result, Vor_Const.FROM);
		
		vor.setRadioAngle(100);
		vor.setOBSAngle(0);
		result = test.calculateToFrom(vor);
		assertEquals("EXPECTING TO #7", result, Vor_Const.TO);
		vor.setOBSAngle(80);
		result = test.calculateToFrom(vor);
		assertEquals("EXPECTING FROM #8", result, Vor_Const.FROM);
		vor.setOBSAngle(110);
		result = test.calculateToFrom(vor);
		assertEquals("EXPECTING FROM #9", result, Vor_Const.FROM);
		vor.setOBSAngle(130);
		result = test.calculateToFrom(vor);
		assertEquals("EXPECTING FROM #10", result, Vor_Const.FROM);
		vor.setOBSAngle(290);
		result = test.calculateToFrom(vor);
		assertEquals("EXPECTING TO #11", result, Vor_Const.TO);
		vor.setOBSAngle(310);
		result = test.calculateToFrom(vor);
		assertEquals("EXPECTING TO #12", result, Vor_Const.TO);
		
		
	}

}
