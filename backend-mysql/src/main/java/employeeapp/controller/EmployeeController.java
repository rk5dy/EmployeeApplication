package employeeapp.controller;

import employeeapp.entity.Employee;
import employeeapp.dao.EmployeeRepository;
import employeeapp.service.EmployeeService;
import java.util.Optional;
import java.util.*;
import org.springframework.http.MediaType;
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

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService eService) {
      employeeService = eService;
    }

    // basic GET method
    @GetMapping("")
    public List<Employee> getAllEmployees() {
      return employeeService.findAll();
    }

    // modified get method
    @GetMapping("/get/{employeeFirstName}")
    public List<Employee> getEmployeeByFirstName(@PathVariable("employeeFirstName") String employeeFirstName) {
      return employeeService.findByFirstName(employeeFirstName);
    }

    // basic POST method
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
      employee.setId(0);
      employeeService.save(employee);
      return employee;
    }

    // basic PUT method
    @PutMapping(path="/edit/{employeeId}", consumes="application/json")
    public Employee editEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") int employeeId) {
        Employee tmpEmployee = employeeService.findById(employeeId);
        if (tmpEmployee == null) {
          throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted successfully";
    }
}
