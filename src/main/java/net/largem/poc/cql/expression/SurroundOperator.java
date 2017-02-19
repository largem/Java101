package net.largem.poc.cql.expression;

/**
 * Created by James Tan on 1/20/2017.
 */
public abstract class SurroundOperator extends Expression {
    private final String op1_;

    private final String op2_;

    private final Expression exp_;

    SurroundOperator(String op1, String op2, Expression exp)
    {
        op1_ = op1;
        op2_ = op2;
        exp_ = exp;
    }

    @Override
    public String toString()
    {
        return op1_ + " " + exp_ + " " + op2_;
    }
}
