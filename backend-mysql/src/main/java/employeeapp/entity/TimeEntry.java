package employeeapp.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TimeEntry")
public class TimeEntry {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="TimeEntryId")
    private int timeEntryId;

    @Column(name="EmployeeId")
    private int employeeId;

    @Column(name="ChargeCodeLuId")
    private int chargeCodeLuId;

    private String chargeCodeDescription;

    @Column(name="hours")
    private int hours;

    @Column(name="dateEntered")
    private Date dateEntered;

    public TimeEntry() {}

    public TimeEntry(int employeeId, int chargeCodeLuId, int hours, Date dateEntered) {
      this.employeeId = employeeId;
      this.chargeCodeLuId = chargeCodeLuId;
      this.hours = hours;
      this.dateEntered = dateEntered;
      chargeCodeDescription = new String();
    }

    public int getEmployeeId() {
      return this.employeeId;
    }

    public int getHours() {
      return this.hours;
    }

    public Date getDateEntered() {
      return this.dateEntered;
    }

    public String getChargeCodeDescription() {
      return this.chargeCodeDescription;
    }

    public void setHours(int hours) {
      this.hours = hours;
    }

    public void setDateEntered(Date dateEntered) {
      this.dateEntered = dateEntered;
    }

    public void setChargeCodeLuId(int chargeCodeLuId) {
      this.chargeCodeLuId = chargeCodeLuId;
    }

    public void setChargeCodeDescription(String chargeCodeDescription) {
      this.chargeCodeDescription = chargeCodeDescription;
    }

    @Override
    public String toString() {
        return String.format(
                "{id='%s', chargeCodeDescription='%s', hours='%s', dateEntered='%s'}",
                timeEntryId, chargeCodeDescription, hours, dateEntered);
    }

}
