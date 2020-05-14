import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	GradeBook g1;
	GradeBook g2;
	GradeBook g3;
	
	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g3 = new GradeBook(5);
		
		g1.addScore(97.44);
		g1.addScore(82.73);
		g1.addScore(91.2);
		
		g2.addScore(79.92);
		g2.addScore(84.17);
		g2.addScore(64.63);
		
		g3.addScore(87.64);
		g3.addScore(90.98);
		g3.addScore(83.18);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = g2 = g3 = null;
	}

	@Test
	void testAddScore() {
		String test1 = "97.44 82.73 91.2",
			   test2 = "79.92 84.17 64.63",
			   test3 = "87.64 90.98 83.18";
		
		assertTrue(test1.equals(g1.toString()));
		assertTrue(test2.equals(g2.toString()));
		assertTrue(test3.equals(g3.toString()));
		
		assertEquals(3, g1.getScoresSize(), 0.001);
		assertEquals(3, g2.getScoresSize(), 0.001);
		assertEquals(3, g3.getScoresSize(), 0.001);
	}

	@Test
	void testSum() {
		assertEquals(271.37, g1.sum(), 0.001);
		assertEquals(228.72, g2.sum(), 0.001);
		assertEquals(261.80, g3.sum(), 0.001);
	}

	@Test
	void testMinimum() {
		assertEquals(82.73, g1.minimum(), 0.001);
		assertEquals(64.63, g2.minimum(), 0.001);
		assertEquals(83.18, g3.minimum(), 0.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(188.64, g1.finalScore(), 0.001);
		assertEquals(164.09, g2.finalScore(), 0.001);
		assertEquals(178.62, g3.finalScore(), 0.001);
	}

}
