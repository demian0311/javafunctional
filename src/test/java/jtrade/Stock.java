package jtrade;

import java.util.Arrays;
import java.util.List;

public class Stock implements Commodity{
    final String ticker;
    final Double price;
    final Integer quantity;
    // TODO: include an Optional field

    public Stock(String tickerIn, Double priceIn, Integer quantityIn){
        ticker = tickerIn;
        price = priceIn;
        quantity = quantityIn;
    }

    public String getTicker(){ return ticker; }
    public @Override Double getPrice(){ return price; }
    public @Override Integer getQuantity() { return quantity;}

    public String toString(){
        return String.format("Stock(\"%s\", %s, %s)", ticker, price, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (price != null ? !price.equals(stock.price) : stock.price != null) return false;
        if (quantity != null ? !quantity.equals(stock.quantity) : stock.quantity != null) return false;
        if (ticker != null ? !ticker.equals(stock.ticker) : stock.ticker != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ticker != null ? ticker.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }

    public static List<Stock> portfolio = Arrays.asList(
            new Stock("TWC", 135.71, 68),
            new Stock("LVLT", 33.96, 22),
            new Stock("GOOG", 1_150.53, 17),
            new Stock("AAPL", 540.67, 30),
            new Stock("MSFT", 36.38, 87),
            new Stock("ORCL", 38.21, 26));
}
