import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import EmployeeContainer from './container/EmployeeContainer'
import * as serviceWorker from './serviceWorker';
import {Switch, Route, BrowserRouter as Router} from 'react-router-dom';

const router = (
  <Router>
    <div>
      <Route exact path="/" component={ EmployeeContainer } />
    </div>
  </Router>
)

ReactDOM.render(
  router,
  document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
