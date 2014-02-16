package jtrade;

import org.junit.Test;

import java.util.function.UnaryOperator;

import static org.junit.Assert.assertEquals;

/**
 * These are lambdas, all on their own.
 */
public class Lambdas {

    // great article
    // http://www.techempower.com/blog/2013/03/26/everything-about-java-8/
    @Test public void test() {
        Runnable r = () -> System.out.println("and I ran...");
        r.run();
    }

    // You can only do this if it's an instance variable.
    static UnaryOperator<Integer> factorial = i -> { return i == 0 ? 1 : i * Lambdas.factorial.apply( i - 1 ); };

    @Test public void factorial(){
        assertEquals(Integer.valueOf(120), factorial.apply(5));
    }
}
