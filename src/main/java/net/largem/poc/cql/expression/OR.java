package net.largem.poc.cql.expression;

/**
 * Created by James Tan on 1/20/2017.
 */
public class OR extends BinaryOperator {

    public OR(Expression left, Expression right)
    {
        super("OR", left, right);
    }
}
