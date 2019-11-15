DROP TABLE cities;

CREATE TABLE cities(id serial PRIMARY KEY, name VARCHAR(255));
INSERT INTO cities(name) VALUES('Bratislava');
INSERT INTO cities(name) VALUES('Budapest');
commit;
