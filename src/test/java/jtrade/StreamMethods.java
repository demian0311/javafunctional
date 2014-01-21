package jtrade;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.stream.IntStream;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Stream is an entry point into doing functional things with
 * the collections.
 */
public class StreamMethods {

    @Test public void range() {
        IntStream.range(1, 5).forEach(out::println);
    }

    @Test public void usingPredicates() {
        // do we have any Oracle?
        assertTrue(Stock.portfolio.stream().anyMatch(s -> s.getTicker() == "ORCL"));

        // do we have over 10 shares of all stocks?
        assertTrue(Stock.portfolio.stream().allMatch(s -> s.getQuantity() > 10));

        // how many stocks do we have that are valued over 10,000
        assertEquals(2, Stock.portfolio.stream()
                .filter(s -> s.getValue() > 10_000.0)
                .count());

        // what is the value of portfolio
        assertEquals(49_913, Stock.portfolio.stream().mapToDouble(s -> s.getValue()).sum(), 1);
    }

    private void expensiveOperation(Integer arg) {
        if(arg % 50 == 0){System.out.print(".");}
        try {
            Thread.sleep(10l);
        } catch (Exception e) { /* do nothing */ }
    }

    @Test public void parallelStream(){
        Stopwatch swStream = new Stopwatch().start();
        IntStream.range(0, 1000).forEach(ii -> expensiveOperation(ii));
        System.out.println("\nstream: " + swStream.stop().elapsedMillis());

        Stopwatch swParallelStream = new Stopwatch().start();
        IntStream.range(0, 1000).parallel().limit(1000).forEach(ii -> expensiveOperation(ii));
        System.out.println("\nparallel stream: " + swParallelStream.stop().elapsedMillis());
    }

    // TODO-DLN: reduce
    // TODO-DLN: http://download.java.net/jdk8/docs/api/java/nio/file/DirectoryStream.html
    // TODO-DLN: generate(Supplier<T>)
}
