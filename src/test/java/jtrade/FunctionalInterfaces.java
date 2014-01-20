package jtrade;

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
 * Demonstrate using the functional interfaces in java.util.function.
 * And what interfaces correspond to what functions.
 */
public class FunctionalInterfaces {

    /*
    private List<Stock> portfolio = Arrays.asList(
            new Stock("TWC",    135.71, 68),
            new Stock("LVLT",    33.96, 22),
            new Stock("GOOG", 1_150.53, 17),
            new Stock("AAPL",   540.67, 30),
            new Stock("MSFT",    36.38, 87),
            new Stock("ORCL",    38.21, 26));
            */

    Function<Stock, Double> findValue = (Stock s) -> s.getPrice() * s.getQuantity();

    Predicate<Stock> valueOver1000 = s -> findValue.apply(s) > 1000;

    @Test public void valueOver1000() {
        assertEquals(true, valueOver1000.test(new Stock("FOO", 11.0, 20)));
    }

    @Test public void function() {
        assertEquals(new Double("30"), findValue.apply(new Stock("GOOG", 3.0, 10)));
    }

    Supplier<Boolean> tradingWindowOpen = () -> true;

    @Test public void supplier() {
        assertTrue(tradingWindowOpen.get());
    }

    Consumer<Stock> sell = (arg) -> System.out.println("\tSELL ORDER: " + arg);

    @Test public void consumer() {
        sell.accept(new Stock("FOO", 3.0, 12));
    }

    // TODO-DLN: show a couple of the functions that work with primitives.

    /*
     * This probably doens't need to be here.
    @Test public void allTogether() {
        System.out.println("--- BEGIN");

        Stock.portfolio.stream()
                .peek(s -> System.out.println("NOW CHECKING: " + s.getTicker()))
                .peek(s -> System.out.println("VALUE: " + s.getPrice() * s.getQuantity()))
                .filter(s -> valueOver1000.test(s))
                .filter(s -> tradingWindowOpen.get())
                .forEach(s -> sell.accept(s));

        System.out.println("--- END");
    }
     */
}
