package net.largem.poc.cql.expression;

/**
 * Created by James Tan on 1/20/2017.
 */
public class AND extends BinaryOperator {

    public AND(Expression left, Expression right)
    {
        super("AND", left, right);
    }
}
