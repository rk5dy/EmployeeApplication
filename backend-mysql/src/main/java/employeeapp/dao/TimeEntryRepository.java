package employeeapp.dao;

import employeeapp.entity.TimeEntry;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Integer> {

}
