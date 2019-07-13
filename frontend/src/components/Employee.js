import React from 'react';
import axios from 'axios';
import config from '../config/config.js';
class Employee extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
    <tr>
      <td>{this.props.first_name}</td>
      <td>{this.props.last_name}</td>
      <td><button type="submit" value={"DeleteButton" + this.props.id} className="btn btn-warning" onClick={this.props.onDelete}>Delete</button></td>
    </tr>
    );
  }
}

export default Employee;
