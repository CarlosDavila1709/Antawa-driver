CREATE TABLE  IF NOT EXISTS users (
    uid CHAR(36) NOT NULL,
    names VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone_mobile VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    personal_document_uid VARCHAR(255) NOT NULL,
    number_document VARCHAR(255) NOT NULL,
    PRIMARY KEY (uid)
) ;

CREATE TABLE  IF NOT EXISTS personal_document (
    uid CHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (uid)
) ;

CREATE TABLE IF NOT EXISTS personal_dni (
    uid        CHAR(36) NOT NULL,
    PRIMARY KEY (uid),
    CONSTRAINT fk_personal_dni_personal_document_id FOREIGN KEY (uid) REFERENCES personal_document(uid)
) ;

CREATE TABLE IF NOT EXISTS personal_passport (
    uid        CHAR(36) NOT NULL,
    PRIMARY KEY (uid),
    CONSTRAINT fk_personal_passport_personal_document_id FOREIGN KEY (uid) REFERENCES personal_document(uid)
) ;

CREATE TABLE IF NOT EXISTS personal_extranjeria (
    uid        CHAR(36) NOT NULL,
    PRIMARY KEY (uid),
    CONSTRAINT fk_personal_extranjeria_personal_document_id FOREIGN KEY (uid) REFERENCES personal_document(uid)
) ;