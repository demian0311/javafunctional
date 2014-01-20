package jtrade;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;
import static org.junit.Assert.*;

/**
 * Stream is an entry point into doing functional things with
 * the collections.
 */
public class StreamMethods {

    @Test public void range() {
        IntStream.range(1, 5).forEach(out::println);
    }

    /*
    @Test public void foo(){
        Stock.portfolio.forEach(out::println);
    }*/

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

    // TODO-DLN: reduce
    // TODO-DLN: parallelStream
    // TODO-DLN: http://download.java.net/jdk8/docs/api/java/nio/file/DirectoryStream.html
    // TODO-DLN: generate(Supplier<T>)
}
