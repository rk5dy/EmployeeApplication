package hello;

import org.springframework.data.annotation.Id;


public class Employee {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Employee() {}

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
      return String.format("%s %s", firstName, lastName);
    }

    @Override
    public String toString() {
        return String.format(
                "{id='%s', firstName='%s', lastName='%s'}",
                id, firstName, lastName);
    }

}
