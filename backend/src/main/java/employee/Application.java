package employee;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private EmployeeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
  	public void run(String... args) throws Exception {

  		repository.deleteAll();

  		// save a couple of customers
  		repository.save(new Employee("Alice", "Smith"));
  		repository.save(new Employee("Bob", "Smith"));

  		// fetch all customers
  		System.out.println("Employees found with findAll():");
  		System.out.println("-------------------------------");
  		for (Employee customer : repository.findAll()) {
  			System.out.println(customer);
  		}
  		System.out.println();

  		// fetch an individual customer
  		System.out.println("Employee found with findByFirstName('Alice'):");
  		System.out.println("--------------------------------");
  		System.out.println(repository.findByFirstName("Alice"));

  		System.out.println("Employees found with findByLastName('Smith'):");
  		System.out.println("--------------------------------");
  		for (Employee customer : repository.findByLastName("Smith")) {
  			System.out.println(customer);
  		}

  	}

}
