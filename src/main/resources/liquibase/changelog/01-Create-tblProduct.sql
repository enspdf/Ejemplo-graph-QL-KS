-- liquibase formatted sql

-- changeset developer:01-Create-tblProduct.sql
CREATE TABLE tblProduct (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  description varchar(500) NOT NULL,
  PRIMARY KEY (id)
);