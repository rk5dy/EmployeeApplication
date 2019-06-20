import React, {Component} from 'react';

const Employee = (props) => {
  return (
    <tr>
      <td>{props.firstName}</td>
      <td>{props.lastName}</td>
    </tr>
  );
}

export default Employee;
