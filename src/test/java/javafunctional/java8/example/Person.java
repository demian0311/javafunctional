package javafunctional.java8.example;

import java.time.LocalDate;

/**
 * This is pretty much the example from the Oracle tutorial.
 */
class Person {
    public enum Sex { MALE, FEMALE}

    private final String name;
    private final LocalDate birthday;
    private final Sex gender;
    private final String emailAddress;

    public Person(
            String nameIn,
            LocalDate birthdayIn,
            Sex genderIn,
            String emailAddressIn){
        name = nameIn;
        birthday = birthdayIn;
        gender = genderIn;
        emailAddress = emailAddressIn;
    }

    public String getName(){
        return name;
    }

    public LocalDate getBirthday{
        return birthday;
    }

    public Sex getGender{
        return gender;
    }

    public String getEmailAddress{
        return emailAddress;
    }

    public int getAge() {
        LocalDate age = LocalDate.now()
                .minusYears(birthday.getYear())
                .minusMonths(birthday.getDayOfMonth())
                .minusDays(birthday.getDayOfMonth());
        System.out.println("age: " + age);
        return age.getYear();
    }

    public String toString(){
        return String.format(
                "Person(%s, %s, %s, %s, %s)",
                name, birthday, gender, emailAddress, getAge());
    }
}
