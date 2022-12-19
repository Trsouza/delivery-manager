CREATE TABLE OM_USER (
	id number(19,0) generated AS IDENTITY, 
	name varchar2(100 char) NOT NULL, 
	email varchar2(100 char) NOT NULL, 
	constraint PK_TAB_OM_ADM PRIMARY KEY (id)
);

CREATE TABLE OM_DELIVERY (
	id number(19,0) generated AS IDENTITY, 
	name varchar2(255 char) NOT NULL, 
	constraint PK_TAB_OM_ORDER PRIMARY KEY (id)
);

CREATE TABLE OM_COMPANY (
	id number(19,0) generated AS IDENTITY, 
	name varchar2(255 char) NOT NULL, 
	constraint PK_TAB_OM_COMPANY PRIMARY KEY (id)
);

