package javafunctional.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static java.util.Comparator.*;

public class FpijStringsComparatorsAndFilters {

    private static void printAsChar(int intValue) {
        System.out.println((char) (intValue));
    }

    @Test public void iterateAString() {
        final String str = "w00t";

        // these print integers
        str.chars().forEach(ch -> System.out.println(ch));
        str.chars().forEach(System.out::println);

        // using a method reference
        str.chars().forEach(FpijStringsComparatorsAndFilters::printAsChar);

        str.chars().mapToObj(ch -> Character.valueOf((char) ch)).forEach(System.out::println);
        str.chars().filter(ch -> Character.isDigit(ch)).forEach(FpijStringsComparatorsAndFilters::printAsChar);

        str.chars().filter(Character::isDigit).forEach(FpijStringsComparatorsAndFilters::printAsChar);
    }

    // Comparators

    private class Person{
        private final String name;
        private final int age;

        public Person(String nameIn, int ageIn){
            name = nameIn;
            age = ageIn;
        }

        public String getName(){ return name; }
        public int getAge(){ return age;}
        public int ageDifference(Person other) { return age - other.getAge(); }
        public String toString(){ return String.format("%s - %d", name, age); }
    }

    final List<Person> people = Arrays.asList(
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21),
            new Person("Greg", 35));

    @Test public void comparison(){

        List<Person> actual = people
                .stream()
                .sorted((p1, p2) -> p1.ageDifference(p2))
                .collect(toList());

        Person firstPerson = actual.stream().findFirst().get();
        assertEquals("John", firstPerson.getName());
    }

    /*
    public static void printPeople(
            final String message,
            final List<Person> people ) {
        System.out.println(message);
        people.forEach(System.out::println);
    }*/

    @Test public void betterComparison() {
        System.out.println("=== better comparison");
        List<Person> sortedPeople = people.stream().sorted(Person::ageDifference).collect(toList());
        System.out.println("sortedPeople: " + sortedPeople);
    }

    @Test public void comparators(){
        Comparator<Person> compareAscending = (p1, p2) -> p1.ageDifference(p2);
        Comparator<Person> compareDescending = compareAscending.reversed();

        System.out.println("ascending: " + people.stream().sorted(compareAscending).collect(toList()));
        System.out.println("descending: " + people.stream().sorted(compareDescending).collect(toList()));
    }

    @Test public void sortByName() {
        System.out.println("sorted by name: " +
                people.stream()
                        .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                        .collect(toList()));

        // youngest
        people.stream().min(Person::ageDifference).ifPresent(System.out::println);

        // oldest
        people.stream().max(Person::ageDifference).ifPresent(System.out::println);
    }

    @Test public void testComparing() {
        System.out.println("testComparing");
        final Function<Person, String> byName = p -> p.getName();
        List<Person> sortedByName = people.stream()
                .sorted(comparing(byName))
                .collect(toList());
        System.out.println("sortedByName: " + sortedByName);

        final Function<Person, Integer> byAge = p -> p.getAge();
        List<Person> sortedByNameAndAge = people.stream()
                .sorted(comparing(byName).thenComparing(byAge))
                .collect(toList());
        System.out.println("sortedByNameAndAge: " + sortedByNameAndAge);
    }
}
