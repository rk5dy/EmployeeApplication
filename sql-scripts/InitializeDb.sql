CREATE DATABASE IF NOT EXISTS `EmployeeDatabase`;
USE `EmployeeDatabase`;

DROP TABLE IF EXISTS `Employee`;

create table Employee (
	id int not null,
    first_name varchar(50),
    last_name varchar(50)
);

INSERT INTO Employee VALUES
  (1, 'first', 'person'),
  (2, 'second', 'person');
