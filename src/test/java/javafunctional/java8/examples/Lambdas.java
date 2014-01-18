package javafunctional.java8.examples;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example usage for some of the things in java.util.function.
 */
public class Lambdas {
    @Test public void predicate() {
        Predicate<Integer> divBy3 = (arg) -> arg % 3 == 0? true: false;
        assertEquals(true, divBy3.test(9));
    }

    @Test public void function(){
        Function<String, String> reverse = (arg) -> (new StringBuffer(arg)).reverse().toString();
        assertEquals("olleH", reverse.apply("Hello"));
    }

    @Test public void supplier() {
        Supplier<String> headsOrTails = () -> (System.currentTimeMillis() % 2 == 0) ? "HEADS" : "TAILS";

        String result = headsOrTails.get();
        assertTrue(result.equals("HEADS") || result.equals("TAILS"));
    }

    @Test public void consumer() {
        Consumer<String> println = (arg) -> System.out.println(arg);
        println.accept("Hello World");
    }

}
