package javafunctional.java8.example;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by demian on 1/1/14.
 */
public class Lambdas {

    List<Person> roster = Arrays.asList(
            new Person("Alice", LocalDate.parse("1976-11-12"), Person.Sex.FEMALE, "alice@example.com"),
            new Person("Bob", LocalDate.parse("1970-03-22"), Person.Sex.MALE, "bob@example.com"),
            new Person("Chad", LocalDate.parse("1958-09-14"), Person.Sex.MALE, "chad@example.com"),
            new Person("Demian", LocalDate.parse("1971-12-04"), Person.Sex.MALE, "demian0311@gmail.com");

    @Test
    public void findMalesOver40() {
        List<Person> malesOver40 = new ArrayList<Person>();

        for (Person person : roster) {
            if(person.getGender == Person.Sex.MALE){
                if(person.getAge() >= 40){
                   malesOver40.add(person);
                }
            }
        }

        System.out.println("malesOver40: " + malesOver40);
    }
}
