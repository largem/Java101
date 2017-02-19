package net.largem.poc.cql.expression;

/**
 * Created by James Tan on 1/20/2017.
 */
public abstract class BinaryOperator extends Expression{
    private final String op_;

    private final Expression left_;

    private final Expression right_;

    public BinaryOperator(String op, Expression left, Expression right)
    {
        op_ = op;
        left_ = left;
        right_ = right;
    }

    @Override
    public String toString()
    {
        return left_.toString() + " " + op_ + " " + right_.toString();
    }
}
