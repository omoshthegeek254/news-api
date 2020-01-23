CREATE DATABASE companyapi;

\c companyapi;

CREATE TABLE IF NOT EXISTS departments (
 id SERIAL PRIMARY KEY,
 name VARCHAR,
 description VARCHAR
);


CREATE TABLE IF NOT EXISTS users (
id SERIAL PRIMARY KEY,
 name VARCHAR,
 position VARCHAR,
 role VARCHAR,
 departmentid int
);

CREATE TABLE IF NOT EXISTS news (
 id SERIAL PRIMARY KEY,
 headline VARCHAR,
 content VARCHAR,
 departmentid int
);
CREATE DATABASE companyapi_test WITH TEMPLATE companyapi;
