package net.largem.poc.cql.expression;

/**
 * Created by James Tan on 1/20/2017.
 */
public class NE extends BinaryOperator {

    public NE(Expression left, Expression right)
    {
        super("!=", left, right);
    }
}
