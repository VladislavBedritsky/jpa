CREATE DATABASE IF NOT EXISTS jpa;

CREATE TABLE IF NOT EXISTS customers (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  address varchar(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO customers (name, email, address) values ('Mike', 'mike@mike.com', 'Minsk');
INSERT INTO customers (name, email, address) values ('Kate', 'kate@kate.com', 'Paris');
INSERT INTO customers (name, email, address) values ('Steve', 'steve@steve.com', 'London');
