import React, {Component} from 'react';
import Header from './Header';
import Employee from './Employee';

class EmployeeList extends React.Component {
  renderEmployees() {
    const employeeList = this.props.employees.map((employee) => {
        return (
          <Employee key={employee.id} firstName={ employee.firstName } lastName={ employee.lastName }/>
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
