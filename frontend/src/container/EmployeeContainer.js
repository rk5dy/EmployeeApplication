import React from 'react';
import AddEmployee from '../components/AddEmployee';
import EmployeeList from '../components/EmployeeList';
import axios from 'axios';
import config from '../config/config.js';

class EmployeeContainer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      employeeList: []
    }
  }

  // handle deleted employee and refresh
  onDelete(employeeId) {
      axios.delete(config.hosturi + '/employee/delete/' + employeeId)
        .then(response => {
      });

  }

  // handle added employee. Passed via props
  handleSubmit(event, firstName, lastName) {
    axios.post(config.hosturi + '/employee/create', {id: 0, firstName: firstName, lastName: lastName })
      .then(response => {

    });
  };

  componentDidMount() {
    axios.get(config.hosturi + '/employee')
      .then(response => {
        this.setState((state, props) => ({
          employeeList : response.data
        }))
      });
  }

  render() {
    return (<div>
        <AddEmployee id="addEmployee" handleSubmit={this.handleSubmit} />
        <EmployeeList id="employeeList" employees={this.state.employeeList} onDelete={(employeeId) => this.onDelete(employeeId)}/>
    </div>);
  }
}

export default EmployeeContainer;
