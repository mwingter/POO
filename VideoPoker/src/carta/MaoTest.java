package carta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaoTest {

	Mao m;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		Baralho b = new Baralho();
		m = new Mao(b);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConta() {
		int[] esperado = {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0};
		int[] deVdd = m.conta(m);
		assertEquals(esperado, deVdd);
		
	}

	@Test
	void testDoisPares() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testTrinca() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testQuadra() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testStraight() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testFlush() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testStraightFlush() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testFullHand() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testRoyalStraightFlush() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testPrintaMao() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testMao() {
		fail("Not yet implemented"); // TODO
	}

}
