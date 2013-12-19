package javafunctional.java8.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FpijCollectionsIterationTest {

    @Test public void iteratingAList(){
        final List<String> friends = Arrays.asList(
                "Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        System.out.println("== The Old Way ==");
        for(int i = 0; i < friends.size(); i++){
            System.out.println(friends.get(i));
        }

        System.out.println("== Better Iteration ==");
        for(String currName: friends){
            System.out.println(currName);
        }

        System.out.println("== Lambda ==");
        friends.forEach((final String name) -> System.out.println(name));

        System.out.println("== Lambda Without Types on Parameters ==");
        friends.forEach(name -> System.out.println(name));

        System.out.println("== Method Reference ==");
        friends.forEach(System.out::println);
    }

    @Test public void transformation(){
        System.out.println("hello world");
    }
}
