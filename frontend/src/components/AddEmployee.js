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
    // console.log(this.state);
    axios.post(config.hosturi + '/employee/create', {id: 0, firstName: this.state.firstName, lastName: this.state.lastName })
      .then(response => {
        // console.log(this.state)
      });
  };

  onChange(section, event) {
    if (section === "firstName")
      this.setState({ firstName: event.target.value });
    if (section === "lastName")
      this.setState({ lastName: event.target.value });

    console.log(this.state);
  }

  render() {
    return (
      <form onSubmit={ (e) => this.handleSubmit(e) }>
        <div className="form-group">
          <h3>Add new record</h3>
          <div className="col-sm-10">
          <label htmlFor="txtFirstName"> FirstName: </label>
          <input className="form-control" type="text" id="txtfirstName" name="firstName" value={this.state.firstName}  placeholder="first name" onChange={(e) => this.onChange("firstName", e)} />
          <label htmlFor="txtLastName"> LastName: </label>
          <input className="form-control" type="text" id="txtLastName" name="lastName" value={this.state.lastName} placeholder="last name" onChange={(e) => this.onChange("lastName", e)} />
          <button type="submit" className="btn btn-primary">Add Employee</button>
          </div>
        </div>
      </form>
    );
  }
}

export default AddEmployee;
