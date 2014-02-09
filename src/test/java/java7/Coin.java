package java7;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class Coin {

    @Test public void stringInSwitch(){

        String numberSpelledOut = "Two";
        Integer result = 0;

        switch (numberSpelledOut){
            case "One"  : result = 1; break;
            case "Two"  : result = 2; break;
            case "Three": result = 3; break;
            default: result = 0;
        }

        assertEquals(new Integer(2), result);
    }

    @Test public void testBinaryLiterals(){
        int a = Integer.parseInt("1100110", 2);
        int b = 0b1100110;

        assertEquals(a, b);
    }

    @Test public void underscoresInNumbers() {
        assertEquals(1000000, 1_000_000);
        assertEquals(100, 1__00);
        assertEquals(10L, 1_0L);
    }

    @Test public void newExceptionHandling() {
        try{
            File.createTempFile("foo", "bar");
            Thread.sleep(1);
        }catch(IOException| InterruptedException e){
            e.getClass();
        }
    }

    @Test public void finalRethrow() {
        // TODO: final rethrow
        // sure seems confusing and questionable
    }

    class SomeResource implements AutoCloseable {
        @Override public void close() throws Exception {
            System.out.println("close was called");
        }
    }

    /**
     * Figure out a good way to test this.
     */
    @Test public void testAutoCloseable() {
        try(SomeResource sr = new SomeResource()) {
            throw new Exception("foo");
        } catch (Exception e){
        }
    }

    @Test public void testDiamondSyntax(){
        Map<Integer, String> lookup = new HashMap<>();
        assertTrue(lookup.keySet().isEmpty());
    }

    private Integer sum(Integer ... integers) {
        return Arrays.asList(integers)
                .stream()
                .mapToInt(p -> p)
                .sum();
    }

    @Test public void testVarArgs() {
        assertEquals(new Integer(6), sum(1, 2, 3));
    }
}
