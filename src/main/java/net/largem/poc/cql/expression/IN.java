package net.largem.poc.cql.expression;

/**
 * Created by James Tan on 1/20/2017.
 */
public class IN extends SingleOperator {

    public IN(SET exp)
    {
        super("IN", exp);
    }
}
