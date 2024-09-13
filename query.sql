CREATE SCHEMA registrydatabase
	AUTHORIZATION postgres;

CREATE TABLE registrydatabase.users(
	user_id SERIAL NOT NULL PRIMARY KEY,
	user_name TEXT	NOT NULL,
	user_email TEXT NOT NULL UNIQUE,
	user_password  TEXT NOT NULL
);

CREATE TABLE registrydatabase.patients(
	patient_id 		INT 	NOT NULL 	REFERENCES registrydatabase.users(user_id) PRIMARY KEY,
	first_name 		TEXT 	NOT NULL,
	middle_name 	TEXT,
	last_name 		TEXT 	NOT NULL,
	suffix 			TEXT,
	sex 			TEXT 	NOT NULL,
	birthday 		DATE 	NOT NULL,
	address 		TEXT 	NOT NULL,
	region 			TEXT 	NOT NULL,
	marital_status 	TEXT 	NOT NULL,
	chief_complaint	TEXT	NOT NULL,
	blur_duration 	TEXT	NOT NULL,
	laterality 		TEXT	NOT NULL,
	family_member	TEXT,
	sibling_count	INT		NOT NULL,
	erg_date 		DATE	NOT NULL,
	erc_result		TEXT 	NOT NULL,
	diagnosis		TEXT	NOT NULL,
	variant			TEXT 	NOT NULL,
	gen_test_date	DATE	NOT NULL,
	digi_signature	TEXT 	NOT NULL
);

CREATE TABLE registrydatabase.clinicalExam(
	patient_id 		INT 	NOT NULL 	REFERENCES registrydatabase.patients(patient_id) PRIMARY KEY,
	eye 			TEXT 	NOT NULL,
	bcva			TEXT 	NOT NULL,
	cornea			TEXT 	NOT NULL,
	retina			TEXT 	NOT NULL
);

CREATE TABLE registrydatabase.queries(
	query_id 		SERIAL	PRIMARY KEY,
	query_type		TEXT	NOT NULL,
	query_email		TEXT 	NOT NULL,
	query_message 	TEXT	NOT NULL
);

INSERT INTO registrydatabase.users
VALUES(000000,'msrosales','msrosales@up.edu.ph', 'admin123');

SELECT * FROM registrydatabase.users;