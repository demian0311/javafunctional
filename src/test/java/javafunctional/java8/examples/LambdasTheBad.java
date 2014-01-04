package javafunctional.java8.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LambdasTheBad {

    private List<Stock> stocks = Arrays.asList(
            new Stock("AAPL", 5, 1),
            new Stock("MSFT", 5, 1),
            new Stock("CSCO", 5, 1),
            new Stock("GOOG", 400, 1));

    @Test public void test() {
        try{
            stocks.stream().mapToInt(s -> s.getValue() / 0).sum();
        }
        catch(ArithmeticException e){
            e.printStackTrace();
            System.out.println("stack trace length: " + e.getStackTrace().length);
        }
    }

    @Test public void test1() {
        try {
            for (Stock currStock : stocks) {
                int foo = currStock.getValue() / 0;
            }
        }
        catch(ArithmeticException e){
            e.printStackTrace();
            System.out.println("stack trace length: " + e.getStackTrace().length);
        }
    }
}
