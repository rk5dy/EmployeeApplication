package employeeapp.dao;

import employeeapp.entity.Employee;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  @Query(value="SELECT * FROM Employee e WHERE e.first_name = :firstName", nativeQuery=true)
  public List<Employee> findByFirstName(@Param("firstName") String firstName);
}
