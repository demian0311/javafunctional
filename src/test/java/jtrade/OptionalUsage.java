package jtrade;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalUsage{

    @Test public void optionalInCollections(){
        Optional<Stock> firstStock = Stock.portfolio.stream().findFirst();
        if(firstStock.isPresent()) {
            assertEquals(new Stock("TWC", 135.71, 68), firstStock.get());
        }else {
            fail("there should have been a first stock");
        }
    }

    @Test public void wrongOptionalProcessing() {
        Optional<String> name = Optional.of("Jay");
        assertEquals("Jay", name.get()); // this is risky

        Optional<String> name1 = Optional.empty();
        try{
            String name1Value = name1.get();
            fail("should have thrown an exception");
        } catch(NoSuchElementException nsee){
            //
        }
    }

    @Test public void optionalNotPresentEquality(){
        Optional<String> name = Optional.empty();
        Optional<String> name2 = Optional.empty();

        assertEquals(name, name2);
    }

    @Test public void optionalPresentEquality() {
        Optional<String> name = Optional.of("Jay");
        Optional<String> name2 = Optional.of("Jay");
        Optional<String> name3 = Optional.of("Fay");

        assertEquals(name, name2);
        assertEquals(name.hashCode(), name2.hashCode());

        assertNotEquals(name2, name3);
        assertNotEquals(name2.hashCode(), name3.hashCode());
    }

    @Test public void optionalInBeans(){
        Person p = new Person(
                "Demian",
                Optional.of("Leo"),
                "Neidetcher",
                new Date());
        assertTrue(p.getMiddleName().isPresent());
        assertEquals("Leo", p.getMiddleName().orElse("NONE"));
    }

    @Test public void optionalInBeansEmpty() {
        Person p = new Person(
                "Demian",
                Optional.empty(),
                "Neidetcher",
                new Date());
        assertFalse(p.getMiddleName().isPresent());
        assertEquals("NONE", p.getMiddleName().orElse("NONE"));
    }
}

class Person{
    private String firstName;
    private Optional<String> middleName;
    private String lastName;
    private Date dateOfBirth;

    Person(String firstName,
           Optional<String> middleName,
           String lastName,
           Date dateOfBirth) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public Optional<String> getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isValid(){
        return (this.firstName != null && this.lastName != null && this.dateOfBirth != null);
    }

    public String getFullName(){
        return firstName + (middleName.isPresent()? middleName: "") + lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", middleName=" + middleName +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!dateOfBirth.equals(person.dateOfBirth)) return false;
        if (!firstName.equals(person.firstName)) return false;
        if (!lastName.equals(person.lastName)) return false;
        if (!middleName.equals(person.middleName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        return result;
    }
}
