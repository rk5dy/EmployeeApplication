import React from 'react';
import axios from 'axios';
import config from '../config/config.js';
class Employee extends React.Component {
  constructor(props) {
    super(props);
  }

  deleteEmployee() {
    console.log(this.props);
    axios.delete(config.hosturi + '/employee/delete/' + this.props.employeeId)
      .then(response => {
        console.log(response.data)
      });
  };

  render() {
    return (
    <tr>
      <td>{this.props.firstName}</td>
      <td>{this.props.lastName}</td>
      <td><button className="btn btn-warning" onClick={() => this.deleteEmployee()}>Delete</button></td>
    </tr>
    );
  }
}

export default Employee;
