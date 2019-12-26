package employeeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employeeapp.dao.EmployeeRepository;
import employeeapp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeServiceImpl(EmployeeRepository eRepository) {
    employeeRepository = eRepository;
  }

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(int id) {
    Optional<Employee> result = employeeRepository.findById(id);
    Employee e = null;

    if (result.isPresent()) {
      e = result.get();
    }
    else {
      throw new RuntimeException("Did not find employee id - " + id);
    }

    return e;
  }

  @Override
  public List<Employee> findByFirstName(String firstName) {
    List<Employee> result = employeeRepository.findByFirstName(firstName);

    return result;
  }

  @Override
  public void save (Employee employee) {
    employeeRepository.save(employee);
  }

  @Override
  public void deleteById(int id) {
    employeeRepository.deleteById(id);
  }
}
