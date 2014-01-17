package javafunctional.java8.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JustifyingLambdas {

    private List<Stock> portfolio = Arrays.asList(
            new Stock("AAPL", 5, 100),
            new Stock("MSFT", 5, 19),
            new Stock("CSCO", 5, 84),
            new Stock("GOOG", 400, 759));

    @Test public void isAppleThere() {
        boolean isAppleThere = false;

        for (Stock currStock : portfolio) {
            if (currStock.getTicker().equals("AAPL")) {
               isAppleThere = true;
            }
        }

        assertTrue(isAppleThere);
    }

    @Test public void isAppleThereFunctional() {
       assertTrue(portfolio.stream().anyMatch(s -> s.getTicker().equals("AAPL")));
    }

    @Test public void stocksWeHaveManyOf() {
        List<String> stocksWeHaveManyOf = portfolio.stream()
                .filter(s -> s.getQuantity() >= 100)                 // filter it
                .sorted((a, b) -> a.getQuantity() - b.getQuantity()) // sort it
                .map(s -> s.getTicker())                             // turn it into a String
                .collect(Collectors.toList());                       // turn it into a List<String>
        assertEquals(Arrays.asList("AAPL", "GOOG"), stocksWeHaveManyOf);
    }
}
