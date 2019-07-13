CREATE DATABASE IF NOT EXISTS `EmployeeDatabase`;
USE `EmployeeDatabase`;

DROP TABLE IF EXISTS `Employee`;

create table Employee (
	id int not null AUTO_INCREMENT,
    first_name varchar(50),
    last_name varchar(50),
    PRIMARY KEY (id)
);

INSERT INTO Employee VALUES
  (0,'first', 'person'),
  (0, 'second', 'person');
