package jtrade;

public interface Commodity {
    public Double getPrice();
    public Integer getQuantity();

    default Double getValue(){
        return getPrice() * getQuantity();
    }
}
