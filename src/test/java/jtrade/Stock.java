package jtrade;

public class Stock {
    final String ticker;
    final Integer value;
    final Integer quantity;

    public Stock(String tickerIn, Integer valueIn, Integer quantityIn){
        ticker = tickerIn;
        value = valueIn;
        quantity = quantityIn;
    }

    public String getTicker(){ return ticker; }
    public Integer getValue(){ return value; }
    public Integer getQuantity() { return quantity;}

    public String toString(){
        return String.format("Stock(\"%s\", %s, %s)", ticker, value, quantity);
    }
}
