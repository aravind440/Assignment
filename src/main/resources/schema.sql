CREATE TABLE ENTITIES (
 id SERIAL PRIMARY KEY,
 name varchar(100),
 address varchar(100),
 email varchar(100),
 company_name varchar(100),
 is_company boolean,
 created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE CASES (
 id SERIAL PRIMARY KEY,
 case_number varchar(100),
 created_at TIMESTAMP NOT NULL DEFAULT NOW()
);


CREATE TABLE ENTITIES_TO_CASES (
 id SERIAL PRIMARY KEY,
 case_number varchar(100),
 entity_id integer
);