package javafunctional.java8.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class JustifyingLambdas {

    private List<Stock> portfolio = Arrays.asList(
            new Stock("AAPL", 5, 1),
            new Stock("MSFT", 5, 1),
            new Stock("CSCO", 5, 1),
            new Stock("GOOG", 400, 1));

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
       portfolio.stream().map(s -> s.getTicker().equals("AAPL")).collect(Collectors.toList());
    }
}
