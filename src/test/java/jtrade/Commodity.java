package jtrade;

/**
 * This shows default methods on interfaces.  Oracle added the feature so
 * that it'd be easy to use the FP capabilities in Java8.
 */
public interface Commodity {
    public Double getPrice();
    public Integer getQuantity();

    public default Double getValue(){
        return getPrice() * getQuantity();
    }
}
