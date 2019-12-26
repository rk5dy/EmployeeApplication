package employeeapp.service;

import java.util.List;

import employeeapp.entity.Employee;

public interface EmployeeService {
  public List<Employee> findAll();

  public Employee findById(int id);

  public List<Employee> findByFirstName(String firstName);

  public void save(Employee employee);

  public void deleteById(int id);
}
