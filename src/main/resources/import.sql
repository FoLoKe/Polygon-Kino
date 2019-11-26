INSERT INTO polygon.cities(name) VALUES('Москва');
INSERT INTO polygon.cities(name) VALUES('Санкт-Петербург');
INSERT INTO polygon.cities(name) VALUES('Челябинск');
INSERT INTO polygon.cities(name) VALUES('Омск');
INSERT INTO polygon.cities(name) VALUES('Мурманск');
INSERT INTO polygon.cities(name) VALUES('Архангельск');
INSERT INTO polygon.cities(name) VALUES('Красноярск');
INSERT INTO polygon.buildings(city_id) values (1);
INSERT INTO polygon.buildings(city_id) values (2);
insert into polygon.performances(name, description) values('Аниме', 'параша');

commit;
