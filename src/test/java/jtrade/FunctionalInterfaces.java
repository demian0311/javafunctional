package jtrade;

import org.junit.Test;

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

    @Test public void predicate() {
        Predicate<Stock> valueOver1000 = s -> s.getValue() > 1000;
        assertEquals(false, valueOver1000.test(new Stock("FOO", 11.0, 20)));
    }

    // TODO: show Function
    //Function<Stock, Double> findValue = (Stock s) -> s.getPrice() * s.getQuantity();

    /*
    @Test public void function() {
        assertEquals(new Double("30"), findValue.apply(new Stock("GOOG", 3.0, 10)));
    }*/

    Supplier<Boolean> tradingWindowOpen = () -> true;

    @Test public void supplier() {
        assertTrue(tradingWindowOpen.get());
    }

    Consumer<Stock> sell = (arg) -> System.out.println("\tSELL ORDER: " + arg);

    @Test public void consumer() {
        sell.accept(new Stock("FOO", 3.0, 12));
    }

    // TODO-DLN: show a couple of the functions that work with primitives.
}

// TODO: show an interface that doesn't compile when you try to add multiple abstract methods

// TODO: show that default methods are not counted as abstract methods


