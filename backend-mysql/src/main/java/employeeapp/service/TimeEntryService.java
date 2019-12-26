package employeeapp.service;

import java.util.List;

import employeeapp.entity.TimeEntry;

public interface TimeEntryService {
  public List<TimeEntry> findAll();

  public TimeEntry findById(int id);

  public void save(TimeEntry employee);

  public void deleteById(int id);
}
