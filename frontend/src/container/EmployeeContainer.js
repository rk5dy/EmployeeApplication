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
        <AddEmployee id="addEmployee" />
        <EmployeeList id="employeeList" employees={this.state.employeeList}/>
    </div>);
  }
}

export default EmployeeContainer;
