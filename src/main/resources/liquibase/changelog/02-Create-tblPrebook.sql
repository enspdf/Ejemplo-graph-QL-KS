-- liquibase formatted sql

-- changeset developer:02-Create-tblPrebook.sql
CREATE TABLE tblPrebook (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  customerName VARCHAR (100) NOT NULL,
  carrierName VARCHAR (100) NOT NULL,
  customerPoNumber VARCHAR (50) NULL,
  shipDate TIMESTAMP NULL,
  PRIMARY KEY (id)
);