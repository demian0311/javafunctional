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

    Function<Stock, Integer> findValue = (Stock s) -> s.getValue() * s.getQuantity();

    Predicate<Stock> valueOver200 = s -> findValue.apply(s) > 200;

    @Test public void saleOver200() {
        assertEquals(true, valueOver200.test(new Stock("FOO", 11, 20)));
    }

    @Test public void function() {
        assertEquals(new Integer("30"), findValue.apply(new Stock("GOOG", 3, 10)));
    }

    Supplier<Boolean> tradingWindowOpen = () -> true;

    @Test public void supplier() {
        assertTrue(tradingWindowOpen.get());
    }

    Consumer<Stock> sell = (arg) -> System.out.println("\tSELL ORDER: " + arg);

    @Test public void consumer() {
        sell.accept(new Stock("FOO", 3, 12));
    }

    @Test public void allTogether() {
        System.out.println("--- BEGIN");

        portfolio.stream()
                .filter(s -> valueOver200.test(s))
                .filter(s -> tradingWindowOpen.get())
                .reduce()
                .peek(s -> System.out.println("GOING TO SELL: " + s.getTicker()))
                .forEach(s -> sell.accept(s));

        System.out.println("--- END");
    }

}
