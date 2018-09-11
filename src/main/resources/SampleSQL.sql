CREATE TABLE tblProduct (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  description varchar(500) NOT NULL,
  boxes int(11) NOT NULL,
  bunches int(11) NOT NULL,
  stemsBunch int(11) NOT NULL,
  unitCost double NOT NULL,
  PRIMARY KEY (id)
);