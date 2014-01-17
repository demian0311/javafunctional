package javafunctional.java8.examples;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FunctionLiterals {
    private Predicate<Integer> divBy3() { return arg -> (arg % 3) == 0? true: false; }
    private Predicate<Integer> divBy5() { return arg -> (arg % 5) == 0? true: false; }

    @Test public void testPredicates(){
        assertEquals(true, divBy3().test(3));
        assertEquals(true, divBy5().test(5));
    }

    public String fizzBuzz(Integer intIn){
        String fizz = (divBy3().test(intIn))? "Fizz" : "";
        String buzz = (divBy5().test(intIn))? "Buzz" : "";
        return (fizz.isEmpty() && buzz.isEmpty())? intIn.toString() : fizz + buzz;
    }

    @Test public void testFizzBuzz() {
        assertEquals("Fizz", fizzBuzz(9));
        assertEquals("Buzz", fizzBuzz(10));
        assertEquals("FizzBuzz", fizzBuzz(30));
    }

    @Test public void runit(){
        IntStream.range(1, 100)
                .mapToObj(ii -> fizzBuzz(ii))
                .forEach(s -> System.out.println(s));
    }
}
