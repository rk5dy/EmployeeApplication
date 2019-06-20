import React, {Component} from 'react';

const Header = (props) => {
  const headerList = props.headers.map((headerName) => {
      return (
        <th scope="col">{headerName.name}</th>
      );
    }
  );
  return (
      <thead>
        <tr>
          {headerList}
        </tr>
      </thead>
  );
}

export default Header;
