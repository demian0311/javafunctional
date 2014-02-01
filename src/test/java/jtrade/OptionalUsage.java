package jtrade;

import org.junit.Test;

import java.util.Date;
import java.util.Optional;

public class OptionalUsage{
    // TODO: where does optional show up coming out of the collecitons API?

    // TODO: the wrong way to process Optional

    // TODO: using optionals in your own beans

    // TODO-DLN: Optional
    @Test public void optional(){


    }

    // TODO-DLN: String.join
}

class Person{
    String firstName;
    Optional<String> middleName;
    String lastName;
    Date dateOfBirth;

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
}
