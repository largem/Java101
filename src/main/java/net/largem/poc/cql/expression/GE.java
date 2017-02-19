package net.largem.poc.cql.expression;

/**
 * Created by James Tan on 1/20/2017.
 */
public class GE extends BinaryOperator{

    public GE(Expression left, Expression right)
    {
        super(">=", left, right);
    }
}
