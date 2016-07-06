package net.largem.java101.class101;

import static org.junit.Assert.*;

import org.junit.Test;

import net.largem.java101.class101.Class101;

public class Class101Test {

    @Test
    public void testClass101() {
        Class101 c = new Class101(0);
        assertEquals(0, c.getValue());
    }

}
