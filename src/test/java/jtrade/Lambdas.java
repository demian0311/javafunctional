package jtrade;

import org.junit.Test;

import java.util.function.Function;

/**
 * These are lambdas, all on their own.
 */
public class Lambdas {
    // great article
    // http://www.techempower.com/blog/2013/03/26/everything-about-java-8/
    @Test public void test() {
        System.out.println("hello world");

        //(int x, int y) -> x + y;
        //(String s) -> { System.out.println(s); }
        Runnable r = () -> System.out.println("and I ran...");

        r.run();
        r.run();
        r.run();
        r.run();


    }
}
