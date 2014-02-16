package jtrade;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * There are some Single Abstract Method interfaces that already
 * existed in Java before Java8.  They are now more useful in the
 * context of Java8.
 */
public class ExistingFunctionalInterfaces {
    /**
     * Runnable is a SAM Interface so you can use it as a functional interface.
     */
    @Test public void runnable(){

        // Anonymous class syntax
        Runnable sayHello = new Runnable() {
            @Override
            public void run() {
                System.out.print("hello ");
            }
        };

        // Lambda syntax
        Runnable sayWorld = () -> System.out.println("world");

        sayHello.run();
        sayWorld.run();
        // hello world
    }

    @Test public void comparator(){

        // Instantiating a Comparator
        Comparator<Stock> stockComparator = new Comparator<Stock>() {
            @Override
            public int compare(Stock s1, Stock s2) {
                return s1.getValue().compareTo(s2.getValue());
            }
        };

        int result = stockComparator.compare(Stock.portfolio.get(0), Stock.portfolio.get(2));
        assertEquals(-1, result);

        List<Stock> sortedList0 = Stock.portfolio
                .stream()
                .sorted(stockComparator)
                .collect(Collectors.toList());

        // Declaring it anonymously inline
        List<Stock> sortedList1 = Stock.portfolio
                .stream()
                .sorted(new Comparator<Stock>() {
                    @Override
                    public int compare(Stock s1, Stock s2) {
                        return s1.getValue().compareTo(s2.getValue());
                    }
                })
                .collect(Collectors.toList());

        assertEquals(sortedList0, sortedList1);

        // Lamda expression inline
        List<Stock> sortedList2 = Stock.portfolio
                .stream()
                .sorted((s1, s2) -> s1.getValue().compareTo(s2.getValue()))
                .collect(Collectors.toList());

        assertEquals(sortedList1, sortedList2);
    }
}
