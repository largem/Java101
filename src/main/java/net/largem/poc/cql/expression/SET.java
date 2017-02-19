package net.largem.poc.cql.expression;

import com.google.common.base.Joiner;

/**
 * Created by James Tan on 1/20/2017.
 */
public class SET extends Expression {
    private final VAR[] vars_;

    public SET(VAR[] vars)
    {
        vars_ = vars.clone();
    }

    @Override
    public String toString()
    {
        if (vars_.length == 0)
        {
            return "()";
        }
        else
        {
            return Joiner.on(',').join(vars_);
        }
    }
}
