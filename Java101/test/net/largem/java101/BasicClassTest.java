package net.largem.java101;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasicClassTest {

	@Test
	public void testBasicClass() {
		BasicClass c = new BasicClass(0);
		assertEquals(0, c.getValue());
	}

}
