package javafunctional.java8.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example usage for some of the things in java.util.function.
 *
 * Figure out a use case that chains all of these functions together.
 */
public class Lambdas {

    private List<Stock> portfolio = Arrays.asList(
            new Stock("GOOG", 400, 759),
            new Stock("AAPL", 5, 100),
            new Stock("MSFT", 5, 19),
            new Stock("CSCO", 5, 84));

    @Test public void predicate() {
        Predicate<Integer> divBy3 = (arg) -> arg % 3 == 0? true: false;
        assertEquals(true, divBy3.test(9));
    }

    Function<String, String> reverse = (arg) -> (new StringBuffer(arg)).reverse().toString();

    @Test public void function(){
        assertEquals("olleH", reverse.apply("Hello"));
    }

    Supplier<String> headsOrTails = () -> (System.currentTimeMillis() % 2 == 0) ? "HEADS" : "TAILS";

    @Test public void supplier() {
        String result = headsOrTails.get();
        assertTrue(result.equals("HEADS") || result.equals("TAILS"));
    }

    Consumer<String> println = (arg) -> System.out.println(arg);

    /**
     * This interface is meant for side-effects.
     */
    @Test public void consumer() {
        println.accept("Hello World");
    }

    @Test public void allTogether(){
        //reverse.
    }

}
