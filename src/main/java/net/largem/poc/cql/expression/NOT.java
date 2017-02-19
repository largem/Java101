package net.largem.poc.cql.expression;

/**
 * Created by James Tan on 1/20/2017.
 */
public class NOT extends SingleOperator {

    public NOT(Expression exp)
    {
        super("NOT", exp);
    }
}
