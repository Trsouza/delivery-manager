
-- V01

CREATE TABLE OM_USER (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR_IGNORECASE(100) NOT NULL,
	email VARCHAR_IGNORECASE(100) NOT NULL,
	password varchar(400) NOT NULL,
	status BOOLEAN NOT NULL DEFAULT TRUE,
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
	user_id bigint NOT NULL,
	cnpj varchar(14) NOT NULL,
	phone varchar(20) NOT NULL,
	PRIMARY KEY (user_id),
	CONSTRAINT fk_cnpj_un UNIQUE (cnpj),
	CONSTRAINT fk_om_company_om_user FOREIGN KEY (user_id) REFERENCES om_user
);

CREATE TABLE OM_EMPLOYEE (
	user_id bigint NOT NULL,
	cpf varchar(11) NOT NULL,
	phone varchar(20) NOT NULL,
	PRIMARY KEY (user_id),
	CONSTRAINT fk_cpf_un UNIQUE (cpf),
	CONSTRAINT fk_om_employee_om_user FOREIGN KEY (user_id) REFERENCES om_user
);
--	company_id INTEGER NOT NULL,
--	CONSTRAINT fk_om_employee_om_company FOREIGN KEY (company_id) REFERENCES om_company

CREATE TABLE OM_DELIVERY (
	id INTEGER NOT NULL AUTO_INCREMENT,
	delivery_date timestamp,
	send_date timestamp NOT NULL,
	expected_delivery_date timestamp NOT NULL,
	first_try tinyint,
	second_try tinyint,
	company_id INTEGER NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_om_delivery_om_company FOREIGN KEY (company_id) REFERENCES om_company
);

--	employee_id INTEGER NOT NULL,
--	CONSTRAINT fk_om_delivery_om_employee FOREIGN KEY (employee_id) REFERENCES om_employee





-- INSERT INTO OM_ROLE (NAME) VALUES('Administrator');
-- INSERT INTO OM_ROLE (NAME) VALUES('Company');
-- INSERT INTO OM_ROLE (NAME) VALUES('employee');

-- INSERT INTO OM_USER (NAME, EMAIL, PASSWORD) VALUES('Administrador', 'adm@adm.com', '123');
-- INSERT INTO OM_USER_ROLE (USER_ID, ROLE_ID) VALUES ((SELECT id from OM_USER WHERE email = 'adm@adm.com'),(SELECT id from OM_ROLE WHERE name = 'Administrator'));

-- INSERT INTO OM_COMPANY (CNPJ) VALUES(02563325600);
-- INSERT INTO OM_EMPLOYEE (CPF, COMPANY_ID) VALUES(05328094328, 1);
-- INSERT INTO OM_DELIVERY (SEND_DATE, EXPECTED_DELIVERY_DATE, COMPANY_ID, EMPLOYEE_ID) VALUES(PARSEDATETIME('2020-11-30-10.20.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-12-30-10.30.00','yyyy-MM-dd-HH.mm.ss'), 1, 1);
-- INSERT INTO OM_DELIVERY (SEND_DATE, EXPECTED_DELIVERY_DATE, COMPANY_ID, EMPLOYEE_ID) VALUES(PARSEDATETIME('2020-11-20-10.20.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-12-25-10.30.00','yyyy-MM-dd-HH.mm.ss'), 1, 1);
