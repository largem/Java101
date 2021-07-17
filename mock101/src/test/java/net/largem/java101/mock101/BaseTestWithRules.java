package net.largem.java101.mock101;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class BaseTestWithRules {

    //rule in between subclass and baseclass can not be the same name.
    //mockitoRunner will ignore base rule with the same name
    @Rule
    public final BaseSetupRule baseSetupRule = new BaseSetupRule();

    @Rule
    public final TeardownRule teardownRule = new TeardownRule();


    public static class BaseSetupRule implements TestRule {
        @Override
        public Statement apply(Statement statement, Description description) {
            System.out.println("BaseTestWithRules SetupRule is applied");
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    System.out.println("BaseTestWithRules SetupRule is evaluated");
                    statement.evaluate();
                }
            };

        }
    }

    public static class TeardownRule extends ExternalResource {
        @Override
        protected void after() {
            System.out.println("BaseTestWithRules TeardownRule is called");
        }
    }
}
