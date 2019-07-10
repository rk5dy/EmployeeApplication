package employee;

import org.springframework.data.annotation.Id;


public class Employee {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    public Employee() {}

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
      return String.format("%s %s", firstName, lastName);
    }

    public String getId() {
      return this.id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getFirstName() {
      return this.firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return this.lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "{id='%s', firstName='%s', lastName='%s'}",
                id, firstName, lastName);
    }

}
