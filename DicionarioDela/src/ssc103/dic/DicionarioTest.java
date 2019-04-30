package ssc103.dic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DicionarioTest {
	Dicionario<Integer,String> dic;
	
	@Before
	public void setUp() throws Exception {
		 dic = new Dicionario<Integer,String>(10);
	}

	@After
	public void tearDown() throws Exception {
		dic = null;
	}

	@Test
	public void testAdd() {
		dic.add(1, "José");
		String s = dic.get(1);
		assertEquals("José", s);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddFull() {
		dic.add(1, "José");
		dic.add(2, "Josée");
		dic.add(3, "Joséee");
		dic.add(4, "Joséeee");
		dic.add(5, "Joséeeee");
		dic.add(6, "Joséeeeee");
		dic.add(7, "Joséeeeee");
		dic.add(8, "Joséeeeeee");
		dic.add(9, "Joséeeeeeee");
		dic.add(10, "Joséeeeeeeee");
		dic.add(11, "Joséeeeeeeeee");
	}
	
	@Test
	public void testGetNotPresent() {
		dic.add(1, "José");
		String s = dic.get(2);
		assertNull(s);
	}

	@Test
	public void testGetNotPresentFull() {
		dic.add(1, "José");
		dic.add(2, "Josée");
		dic.add(3, "Joséee");
		dic.add(4, "Joséeee");
		dic.add(5, "Joséeeee");
		dic.add(6, "Joséeeeee");
		dic.add(7, "Joséeeeee");
		dic.add(8, "Joséeeeeee");
		dic.add(9, "Joséeeeeeee");
		dic.add(10, "Joséeeeeeeee");
		String s = dic.get(11);
		assertNull(s);
	}
	
	@Test
	public void testContainsFalse() {
		assertFalse(dic.contains(1));
	}
	
	@Test
	public void testContainsTrue() {
		dic.add(1, "José");
		assertTrue(dic.contains(1));
	}
	
	@Test
	public void testContainsValueTrue() {
		dic.add(1, "José");
		assertTrue(dic.containsValue("José"));
	}

	@Test
	public void testContainsValueFalse() {
		dic.add(1, "José");
		assertFalse(dic.containsValue("Josée"));
	}

	@Test
	public void testContainsValueFalseFull() {
		dic.add(1, "José");
		dic.add(2, "Josée");
		dic.add(3, "Joséee");
		dic.add(4, "Joséeee");
		dic.add(5, "Joséeeee");
		dic.add(6, "Joséeeeee");
		dic.add(7, "Joséeeeee");
		dic.add(8, "Joséeeeeee");
		dic.add(9, "Joséeeeeeee");
		dic.add(10, "Joséeeeeeeee");

		assertFalse(dic.containsValue("Josi"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddDuplicate() {
		dic.add(1, "José");
		dic.add(1, "Josée");
	}

}

