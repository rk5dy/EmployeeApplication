package employee;

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

    @Autowired
    private EmployeeRepository repository;

    // basic GET method
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
      return repository.findAll();
    }

    // basic POST method
    @PostMapping("/create")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
      System.out.println("Create employee: " + employee.getName() + "...");

      return repository.save(employee);
    }

    // basic PUT method
    @PutMapping("/edit/{employeeId}")
    public Map<String, Object> editEmployee(@PathVariable("employeeId") String employeeId,
      @RequestBody Map<String, Object> employeeMap) {
        Employee employee = new Employee(
        employeeMap.get("firstName").toString(),
        employeeMap.get("lastName").toString());
        employee.setId(employeeId);

        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Employee Updated successfully");
        response.put("employee", repository.save(employee));
        return response;
    }

    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") String employeeId) {
        repository.findById(employeeId).map(employee -> {
          repository.delete(employee);
          return "Deleted successfully";
        }).orElseThrow(() -> new RuntimeException(String.format("Employee not found with employeeId = %s", employeeId)));
        return "Deleted successfully";
    }
}
