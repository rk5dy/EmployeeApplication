import React from 'react';
import Header from './Header';
import Employee from './Employee';

class EmployeeList extends React.Component {
  renderEmployees() {
    const employeeList = this.props.employees.map((employee) => {
        return (
          <Employee key={employee.id} id={employee.id} first_name={ employee.firstName } last_name={ employee.lastName }/>
        )
      }
    );
    return <tbody>{employeeList}</tbody>
  }

  render() {
    const headerNames = [
      {key: 0, name: 'First Name'},
      {key: 1, name: 'Last Name'}
    ]

    return (
      <table className="table table-dark">
        <Header key="tableHeader" headers={headerNames} />
        {this.renderEmployees()}
      </table>
    );
  }
}

export default EmployeeList;
