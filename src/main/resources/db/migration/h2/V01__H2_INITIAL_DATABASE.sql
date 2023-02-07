
-- V01

CREATE TABLE OM_USER (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR_IGNORECASE(100) NOT NULL,
	email VARCHAR_IGNORECASE(100) NOT NULL,
	password varchar(400) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_email_un UNIQUE (email),
	CONSTRAINT name_user_fk_email_un UNIQUE (name, email)
);

CREATE UNIQUE INDEX idx_uniq_email on om_user(email);

CREATE TABLE OM_USER_ROLE (
	user_id INTEGER NOT NULL,
	role varchar(20) NOT NULL,
	CONSTRAINT fk_om_user_role_om_user FOREIGN KEY (user_id) REFERENCES om_user
);

CREATE TABLE OM_COMPANY (
	id INTEGER NOT NULL AUTO_INCREMENT,
	cnpj BIGINT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE OM_DELIVERYMAN (
	id INTEGER NOT NULL AUTO_INCREMENT,
	cpf BIGINT NOT NULL,
	company_id INTEGER NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_om_deliveryman_om_company FOREIGN KEY (company_id) REFERENCES om_company
);

CREATE TABLE OM_DELIVERY (
	id INTEGER NOT NULL AUTO_INCREMENT,
	delivery_date timestamp,
	send_date timestamp NOT NULL,
	expected_delivery_date timestamp NOT NULL,
	company_id INTEGER NOT NULL,
	first_try tinyint,
	second_try tinyint,
	deliveryman_id INTEGER NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_om_delivery_om_company FOREIGN KEY (company_id) REFERENCES om_company,
	CONSTRAINT fk_om_delivery_om_deliveryman FOREIGN KEY (deliveryman_id) REFERENCES om_deliveryman
);






-- INSERT INTO OM_ROLE (NAME) VALUES('Administrator');
-- INSERT INTO OM_ROLE (NAME) VALUES('Company');
-- INSERT INTO OM_ROLE (NAME) VALUES('Deliveryman');

-- INSERT INTO OM_USER (NAME, EMAIL, PASSWORD) VALUES('Administrador', 'adm@adm.com', '123');
-- INSERT INTO OM_USER_ROLE (USER_ID, ROLE_ID) VALUES ((SELECT id from OM_USER WHERE email = 'adm@adm.com'),(SELECT id from OM_ROLE WHERE name = 'Administrator'));

-- INSERT INTO OM_COMPANY (CNPJ) VALUES(02563325600);
-- INSERT INTO OM_DELIVERYMAN (CPF, COMPANY_ID) VALUES(05328094328, 1);
-- INSERT INTO OM_DELIVERY (SEND_DATE, EXPECTED_DELIVERY_DATE, COMPANY_ID, DELIVERYMAN_ID) VALUES(PARSEDATETIME('2020-11-30-10.20.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-12-30-10.30.00','yyyy-MM-dd-HH.mm.ss'), 1, 1);
-- INSERT INTO OM_DELIVERY (SEND_DATE, EXPECTED_DELIVERY_DATE, COMPANY_ID, DELIVERYMAN_ID) VALUES(PARSEDATETIME('2020-11-20-10.20.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-12-25-10.30.00','yyyy-MM-dd-HH.mm.ss'), 1, 1);
