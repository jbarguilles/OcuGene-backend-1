CREATE SCHEMA registrydatabase
	AUTHORIZATION postgres;

CREATE TABLE registrydatabase.users(
	user_id SERIAL NOT NULL PRIMARY KEY,
	username TEXT	NOT NULL,
	user_password  TEXT NOT NULL
);

CREATE TABLE registrydatabase.patients(
	patient_id 		SERIAL 	NOT NULL PRIMARY KEY,
	first_name 		TEXT 	NOT NULL,
	middle_name 	TEXT,
	last_name 		TEXT 	NOT NULL,
	sex 			TEXT 	NOT NULL,
	birthday 		DATE 	NOT NULL,
	address 		TEXT 	NOT NULL,
	region 			TEXT 	NOT NULL,
	province		TEXT	NOT NULL,
	city			TEXT	NOT NULL,
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
	right_bcva		TEXT	NOT NULL,
	left_bcva		TEXT	NOT NULL,
	right_retina	TEXT	NOT NULL,
	left_retina		TEXT	NOT NULL,
	right_cornea	TEXT	NOT NULL,
	left_cornea		TEXT	NOT NULL
);

CREATE TABLE registrydatabase.queries(
	query_id 		SERIAL	PRIMARY KEY,
	query_type		TEXT	NOT NULL,
	query_email		TEXT 	NOT NULL,
	query_message 	TEXT	NOT NULL
);

SELECT * FROM registrydatabase.users;