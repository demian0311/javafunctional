package jtrade;

import org.junit.Test;

import java.util.function.BinaryOperator;

import static org.junit.Assert.*;

/**
 * This shows us creating our own YourOwnFunctionalInterfaces.
 */
public class YourOwnFunctionalInterfaces {

    @Test public void ourOwnPredicate(){
        ShouldSell shouldSell = s -> s.getQuantity() > 1000;
        assertTrue(shouldSell.analyze(new Stock("AAA", 20d, 1050)));
    }

    @Test public void test(){
        System.out.println("hello world");

        BinaryOperator<Integer> addition = (i1, i2) -> i1 + i2;
        assertEquals(new Integer(8), addition.apply(3, 5));
    }
}

// TODO: show defualt methods?

@FunctionalInterface interface ShouldSell{
    public Boolean analyze(Stock stock);
}

//@FunctionalInterface
