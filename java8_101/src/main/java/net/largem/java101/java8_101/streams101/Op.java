package net.largem.java101.java8_101.streams101;

/** Represents an operation that we will want to time.
 *  Added a static and default method to the interface
 *  that we had used earlier.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already),
 *  and Java 8 programming (for those new to Java)</a>.
 */

@FunctionalInterface
public interface Op {
    void runOp();

    static void timeOp(Op operation) {
        long startTime = System.nanoTime();
        operation.runOp();
        long endTime = System.nanoTime();
        double oneBillion = 1_000_000_000;
        double elapsedSeconds = (endTime - startTime)/oneBillion;
        System.out.printf("  Elapsed time: %.3f seconds.%n", elapsedSeconds);
    }

    default Op combinedOp(Op secondOp) {
        return(() -> { runOp();
            secondOp.runOp(); });
    }
}
