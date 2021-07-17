package net.largem.java101.mock101;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.modules.junit4.PowerMockRunner;

/*
1.5.6 version of PowerMockerRunner is not handle junit rules correctly,
1.7.4 works better but must align with junit 4.13.1 (same version in the powermock dependency
Further checking, it seems junit version plays the major role here.

no matter use any runner or not use runner, we expect the following order of execution
SetupRule is applied
BaseTestWithRules SetupRule is applied
BaseTestWithRules SetupRule is evaluated
SetupRule is evaluated
Test setUp is called
Test method is called
Test tearDown method is called
BaseTestWithRules TeardownRule is called

 */
//@RunWith(PowerMockRunner.class)
//@RunWith(MockitoJUnitRunner.class)
public class PowermockRunnerWithJunitTestRule extends BaseTestWithRules {

    @Rule
    //be careful about the rule name (field name)
    public final TestRule setupRule = new TestRule() {
        @Override
        public Statement apply(Statement statement, Description description) {
            System.out.println("SetupRule is applied");
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    System.out.println("SetupRule is evaluated");
                    statement.evaluate();
                }
            };
        }
    };

    @Before
    public void setUp() {
        System.out.println("Test setUp is called");
    }

    @Test
    public void test() {
        System.out.println("Test method is called");
    }

    @After
    public void tearDown() {
        System.out.println("Test tearDown method is called");
    }
}
