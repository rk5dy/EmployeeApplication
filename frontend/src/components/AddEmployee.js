import React, {Component} from 'react';
import axios from 'axios';

class AddEmployee extends React.Component {
  constructor() {
    super();
    this.state = {
      firstName: "",
      lastName: ""
    };
  }

  handleSubmit(event) {
    console.log(this.state);
    axios.post('http://localhost:9090/employee/add', {firstName: this.state.firstName, lastName: this.state.lastName})
      .then(response => {
        //console.log(response.data)
        console.log(this.state)
      });
  };

  onChange(section, event) {
    if (section === "firstName")
      this.setState({ firstName: event.target.value });
    if (section === "lastName")
      this.setState({ lastName: event.target.value });
  }

  render() {
    return (
      <form onSubmit={ (e) => this.handleSubmit(e) }>
        <h3>Add new record</h3>
        <label> FirstName:
          <input type="text" name="firstName" value={this.state.firstName} onChange={(e) => this.onChange("firstName", e)} />
        </label>
        <label> LastName:
          <input type="text" name="lastName" value={this.state.lastName} onChange={(e) => this.onChange("lastName", e)} />
        </label>
        <input type="submit" value="Add" />
      </form>
    );
  }
}

export default AddEmployee;
