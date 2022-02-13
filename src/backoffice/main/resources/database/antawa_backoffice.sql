CREATE TABLE  IF NOT EXISTS document_type (
    uid 	CHAR(36) NOT NULL,
    name 	VARCHAR(255) NOT NULL,
    codigo 	VARCHAR(255) NOT NULL,
    PRIMARY KEY (uid)
);

CREATE TABLE  IF NOT EXISTS solicitudes (
    uid 				CHAR(36) NOT NULL,
    driver_uid 			VARCHAR(255) NOT NULL,
    names_driver 		VARCHAR(255) NOT NULL,
    last_name_driver 	VARCHAR(255) NOT NULL,
	document 			VARCHAR(255) NOT NULL,
	number_document 	VARCHAR(255) NOT NULL,
	status 				VARCHAR(255) NOT NULL,
	image_soa 				VARCHAR(255) NOT NULL,
	image_criminal_record 	VARCHAR(255) NOT NULL,
	image_vehiculo 			VARCHAR(255) NOT NULL,
	image_face_driver 		VARCHAR(255) NOT NULL,
	image_identidad 		VARCHAR(255) NOT NULL,
	observation				VARCHAR(255) NOT NULL,
	date_creation 			VARCHAR(255) NOT NULL,
    PRIMARY KEY (uid)
);

CREATE TABLE  IF NOT EXISTS uploads (
    uid 		CHAR(36) NOT NULL,
    name 		VARCHAR(255) NOT NULL,
	path 		VARCHAR(255) NOT NULL,
	owner_uid 	VARCHAR(255) NOT NULL,
    PRIMARY KEY (uid)
);

CREATE TABLE  IF NOT EXISTS users (
    uid CHAR(36) NOT NULL,
    names VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (uid)
) ;