-- liquibase formatted sql

-- changeset developer:03-Create-tblPrebookItem.sql
CREATE TABLE tblPrebookItem (
  id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  prebookId INT(11) UNSIGNED NOT NULL,
  productId INT(11) UNSIGNED NOT NULL,
  vendorCode VARCHAR(50) NOT NULL,
  boxType VARCHAR(50) NOT NULL,
  unitType VARCHAR(50) NOT NULL,
  markCode VARCHAR(100) NULL,
  unitPrice DOUBLE NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_PREBOOK
    FOREIGN KEY (prebookId)
    REFERENCES tblPrebook (id),
  CONSTRAINT FK_PRODUCT
    FOREIGN KEY (productId)
    REFERENCES tblProduct (id)
);