package net.largem.poc.cql.expression;

/**
 * Created by James Tan on 1/20/2017.
 */
public class TestExp {
    public static void main(String[] args) {
        final VAR v1 = new VAR("Value1");
        final EQ eq1 = new EQ(v1, VAR.PL);

        final VAR v2 = new VAR("Value2");
        final GT gt1 = new GT(v2, VAR.PL);

        final AND and = new AND(eq1, gt1);

        System.out.println(and);
    }
}
