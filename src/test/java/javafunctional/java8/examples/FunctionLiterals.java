package javafunctional.java8.examples;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by demian on 1/17/14.
 */
public class FunctionLiterals {
    private Predicate<Integer> divBy3() { return arg -> (arg % 3) == 0? true: false; }
    private Predicate<Integer> divBy5() { return arg -> (arg % 5) == 0? true: false; }
    private Predicate<Integer> divBy15() { return arg -> divBy3().test(arg) && divBy5().test(arg); }

    @Test public void testPredicates(){
        assertEquals(true, divBy3().test(3));
        assertEquals(true, divBy5().test(5));
        assertEquals(true, divBy15().test(15));

        assertFalse(divBy3().and(divBy5()).test(3));
        assertFalse(divBy3().and(divBy5()).test(5));
        assertTrue(divBy3().and(divBy5()).test(15));
    }

    public String fizzBuzz(Integer intIn){
        if(divBy15().test(intIn)){
            return "FizzBuzz";
        }
        if (divBy3().test(intIn)) {
            return "Fizz";
        }
        if(divBy5().test(intIn)) {
            return "Buzz";
        }
        return intIn.toString();
    }

    @Test public void testFizzBuzz() {
        assertEquals("Fizz", fizzBuzz(9));
        assertEquals("Buzz", fizzBuzz(10));
        assertEquals("FizzBuzz", fizzBuzz(30));
    }

    @Test public void test(){
        IntStream.range(1, 100)
                .mapToObj(ii -> fizzBuzz(ii))
                .forEach(s -> System.out.println(s));
    }
}
