package net.largem.java101.class101;

import org.junit.Assert;
import org.junit.Test;

public class Class101Test {

    @Test
    public void testClass101() {
        Class101 c = new Class101(0);
        Assert.assertEquals(0, c.getValue());
    }

}
