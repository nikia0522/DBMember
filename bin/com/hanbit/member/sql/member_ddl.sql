--id, password, name, ssn, regdate
CREATE TABLE Member(
	id VARCHAR2(10), 
	name VARCHAR2(10),
	password VARCHAR2(10),
	ssn VARCHAR2(15),
	regdate DATE,
	PRIMARY KEY(id)
);
SELECT * FROM Member; --dml
DROP TABLE Member; --dcl