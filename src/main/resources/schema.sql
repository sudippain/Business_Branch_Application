DROP TABLE IF EXISTS Business_Master;

DROP TABLE IF EXISTS Branch_Master;

CREATE TABLE Business_Master(
business_id INT AUTO_INCREMENT  PRIMARY KEY,
  business_name VARCHAR(250) NOT NULL,
  contact_no VARCHAR(250) NOT NULL,
pan VARCHAR(250) NOT NULL,created_date Date
,updated_date Date);

CREATE TABLE Branch_Master(
branch_id INT AUTO_INCREMENT,business_id INT REFERENCES Business_Master(business_id),
  branch_address VARCHAR(250) NOT NULL,
  branch_contact VARCHAR(250) NOT NULL,
active_ind VARCHAR(250) DEFAULT NULL,created_date Date
,updated_date Date,PRIMARY KEY (branch_id));










