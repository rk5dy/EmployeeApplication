import React from 'react';

const Header = (props) => {
  const headerList = props.headers.map((headerName) => {
      return (
        <th key={headerName.key} scope="col">{headerName.name}</th>
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
