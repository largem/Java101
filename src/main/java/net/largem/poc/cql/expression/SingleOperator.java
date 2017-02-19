package net.largem.poc.cql.expression;

/**
 * Created by James Tan on 1/20/2017.
 */
public abstract class SingleOperator extends Expression {
    private final String op_;
    private final Expression value_;

    SingleOperator(String op, Expression value)
    {
        op_ = op;
        value_ = value;
    }

    @Override
    public String toString()
    {
        return op_ + " " + value_;
    }
}

