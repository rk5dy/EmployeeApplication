import React from 'react';
import axios from 'axios';
import config from '../config/config';

class AddEmployee extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      firstName: "",
      lastName: "",
    };
  }

  handleSubmit(event) {
    console.log(this.state);
    axios.post(config.hosturi + '/employee/create', {firstName: this.state.firstName, lastName: this.state.lastName})
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
        <div class="form-group">
          <h3>Add new record</h3>
          <div class="col-sm-10">
          <label for="txtFirstName"> FirstName: </label>
          <input class="form-control" type="text" id="txtfirstName" name="firstName" value={this.state.firstName}  placeHolder="first name" onChange={(e) => this.onChange("firstName", e)} />
          <label for="txtLastName"> LastName: </label>
          <input class="form-control" type="text" id="txtLastName" name="lastName" value={this.state.lastName} placeHolder="last name" onChange={(e) => this.onChange("lastName", e)} />
          <button type="submit" class="btn btn-primary">Add Employee</button>
          </div>
        </div>
      </form>
    );
  }
}

export default AddEmployee;
