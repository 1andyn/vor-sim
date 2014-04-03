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

	/*
	@Test
	public void testCalculation() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testNormalizedAngle() {
		Calculation test = new Calculation();
		int x = test.normalizedAngle(90);
		assertEquals("90 will normalize to 90", 90, x);
	}

}
