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
	public void testCalculation() {
		Calculation test = new Calculation();
		fail("Not yet implemented");
	}

	@Test
	public void testCalculateToFrom() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculateWestEast() {
		fail("Not yet implemented");
	}

	@Test
	public void testNormalizedAngle() {
		Calculation test = new Calculation();
		for(int x = -1; x > -360; x--){
			int y = test.normalizedAngle(x);
			assertEquals("Testing normalization", 360+x, y);
		}
		
		for(int y = 0; y < 360; y++){
			int x = test.normalizedAngle(y);
			assertEquals("Testing normalization", x, y);
		}

	}

}
