CREATE DATABASE IF NOT EXISTS `EmployeeDatabase`;
USE `EmployeeDatabase`;

DROP TABLE IF EXISTS `TimeEntry`;
DROP TABLE IF EXISTS `ChargeCodeLu`;
DROP TABLE IF EXISTS `Employee`;

create table Employee (
		id int not null AUTO_INCREMENT,
    first_name varchar(50),
    last_name varchar(50),
    PRIMARY KEY (id)
);

create table ChargeCodeLu (
		id int not null AUTO_INCREMENT,
    Description varchar(50),
    PRIMARY KEY (id)
);

create table TimeEntry (
		id int not null AUTO_INCREMENT,
		EmployeeId int,
    ChargeCodeLuId int,
    hours int,
    dateEntered DateTime,
		PRIMARY KEY (id),
    FOREIGN KEY (EmployeeId) REFERENCES Employee(id),
    FOREIGN KEY (ChargeCodeLuId) REFERENCES ChargeCodeLu(id)
);

INSERT INTO Employee VALUES
  (0,'first', 'person'),
  (0, 'second', 'person');

INSERT INTO ChargeCodeLu VALUES
	(0,'chargecode1'),
    (0,'chargecode2');
