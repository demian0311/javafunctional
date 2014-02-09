package jtrade;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.function.ToDoubleFunction;

/**
 * This shows how the new capabilities in the stream API really take
 * instances of interfaces found in java.util.function or SAM
 * interfaces that you create.
 */
public class LambdasAreClasses {

    private Double TAX_RATE = .40;

    @Test public void asFunctionClass(){
        Double taxesIfSoldPortfolio = Stock.portfolio
                .stream()
                .mapToDouble(new CalculateTaxes())
                .sum();
        assertEquals(19965.212, taxesIfSoldPortfolio, 1);
    }

    @Test public void asLambda(){
        Double taxesIfSoldPortfolio = Stock.portfolio
                .stream()
                .mapToDouble(s -> s.getValue() * TAX_RATE)
                .sum();
        assertEquals(19965.212, taxesIfSoldPortfolio, 1);
    }
}

class CalculateTaxes implements ToDoubleFunction<Stock> {
    private Double TAX_RATE = .40;

    @Override
    public double applyAsDouble(Stock stock) {
        return stock.getValue() * TAX_RATE;
    }
}
