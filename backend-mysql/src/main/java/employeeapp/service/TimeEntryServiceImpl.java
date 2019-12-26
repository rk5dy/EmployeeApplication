package employeeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employeeapp.dao.TimeEntryRepository;
import employeeapp.entity.TimeEntry;

@Service
public class TimeEntryServiceImpl implements TimeEntryService {
  private TimeEntryRepository timeEntryRepository;

  @Autowired
  public TimeEntryServiceImpl(TimeEntryRepository eRepository) {
    timeEntryRepository = eRepository;
  }

  @Override
  public List<TimeEntry> findAll() {
    return timeEntryRepository.findAll();
  }

  @Override
  public TimeEntry findById(int id) {
    Optional<TimeEntry> result = timeEntryRepository.findById(id);
    TimeEntry e = null;

    if (result.isPresent()) {
      e = result.get();
    }
    else {
      throw new RuntimeException("Did not find time entry id - " + id);
    }

    return e;
  }

  @Override
  public void save (TimeEntry employee) {
    timeEntryRepository.save(employee);
  }

  @Override
  public void deleteById(int id) {
    timeEntryRepository.deleteById(id);
  }
}
