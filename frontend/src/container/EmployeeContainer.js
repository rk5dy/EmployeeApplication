import React, {Component} from 'react';
import EmployeeList from '../components/EmployeeList';
import axios from 'axios';

class EmployeeContainer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      employeeList: []
    }
  }

  componentDidMount() {
    axios.get('http://localhost:9090/employee/')
      .then(response => {
        //console.log(response.data)
        this.setState((state, props) => ({
          employeeList : response.data
        }))
        //console.log(this.state.employeeList);
      });
  }

  render() {
    // console.log(this.state.employeeList);
    return (<div>
        <EmployeeList id="employeeList" employees={this.state.employeeList}/>
    </div>);
  }
}

export default EmployeeContainer;
