package jtrade;

import org.junit.Test;

import java.util.stream.IntStream;

public class Streams {

    @Test
    public void range(){
        IntStream.range(0, 20).forEach(System.out::println);
    }

    @Test public void test(){
        Long count = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).count();
        System.out.println("count: " + count);
    }
}
