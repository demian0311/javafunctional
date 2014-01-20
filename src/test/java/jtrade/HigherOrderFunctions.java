package jtrade;

import org.junit.Test;

import java.util.List;
import java.util.function.Function;

/**
 * Demonstrate functions that create other functions and functions that take in functions.
 */
public class HigherOrderFunctions {
    public Function<Stock, Stock> createBalanceStockAlgorithm(Integer maximumValueOfStock){
        Function<Stock, Stock> algorithm = (Stock s) -> {
            Double overageValue = (s.getPrice() * s.getQuantity()) - maximumValueOfStock;
            Integer overageQuantity = (int) Math.round(overageValue % s.getPrice());

            if(overageQuantity > 0) {
                System.out.println(String.format("SELL: %s shares of %s", overageQuantity, s.getTicker()));
            }

            return new Stock(s.getTicker(), s.getPrice(), s.getQuantity() - overageQuantity);
        };

        return algorithm;
    }

    @Test public void testCreateBalanceStockAlgorithm() {
        System.out.println("hello world");
        Function<Stock, Stock> alg = createBalanceStockAlgorithm(5);
        Stock result = alg.apply(new Stock("FOO", 3.0, 3));
        System.out.println("result: " + result);
    }

    /*
     * apply the alg to each stock,
     * send sell order
     * return adjusted portfolio
     */
    public List<Stock> applyAlgorithmToPortfolio(Function<Stock, Integer> algorithm, List<Stock> portfolio) {
        return null;
    }


    // TODO-DLN: show a function that takes another function
    // wrap a transaction in a 3-phase commit
    /*
    public Stock applyAlgorithmWithinTransaction(Function<Stock, Stock> algorithm){
        System.out.println("<transaction>");
        System.out.println("\t<performTransaction/>");
        System.out.println("</transaction>");
        return null;
    }
    */


    @Test public void test(){
        /*
        TODO-DLN:
        List<Stock> newPortfolio = Stock.portfolio.stream()
            .map(algorithm) // map takes a function, it is a higher order function
            .collect(List.collection)
         */

    }
}
