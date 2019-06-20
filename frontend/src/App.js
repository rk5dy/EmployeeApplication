import React from 'react';
import './App.css';
import EmployeeList from './components/EmployeeList';

function App() {
  const employeeList = [
    {
      id: 0,
      firstName: 'Rock',
      lastName: 'Kim'
    },
    {
      id: 1,
      firstName: 'Rod',
      lastName: 'Dim'
    }
  ]
  return (
    <div className="App">
      <EmployeeList employees={employeeList}/>
    </div>
  );
}

export default App;
