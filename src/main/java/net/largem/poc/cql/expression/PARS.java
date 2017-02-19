package net.largem.poc.cql.expression;

/**
 * Created by James Tan on 1/20/2017.
 */
public class PARS extends SurroundOperator {

    public PARS(Expression exp)
    {
        super("(", ")", exp);
    }
}
