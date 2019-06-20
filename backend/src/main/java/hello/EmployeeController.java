package hello;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = {"*"})
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/")
    public List<Employee> employees() {
      return repository.findAll();
    }

    @PostMapping("/create")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
      System.out.println("Create employee: " + employee.getName() + "...");

      return repository.save(employee);
    }
}
