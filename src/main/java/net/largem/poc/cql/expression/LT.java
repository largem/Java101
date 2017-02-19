package net.largem.poc.cql.expression;

/**
 * Created by James Tan on 1/20/2017.
 */
public class LT extends BinaryOperator{

    public LT(Expression left, Expression right)
    {
        super("<", left, right);
    }
}
