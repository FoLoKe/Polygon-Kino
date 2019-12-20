Insert into polygon.users(username, password) values ('user','user');
INSERT INTO polygon.cities(name) VALUES('Москва');
INSERT INTO polygon.cities(name) VALUES('Санкт-Петербург');
INSERT INTO polygon.buildings(city_id, type, address) values (1,'Кинотеатр', 'Пушкина к14 а1');
INSERT INTO polygon.buildings(city_id, type, address) values (2,'ТЦ', 'Колотушкина д1');
INSERT INTO polygon.buildings(city_id, type, address) values (2,'Кинотеатр', 'Вишневая д5');
INSERT INTO polygon.buildings(city_id, type, address) values (1,'ТЦ', 'Корзинкина д1');
INSERT INTO polygon.buildings(city_id, type, address) values (1,'Молл', 'Малиновая к1224б');
insert into polygon.performances(name, date, description, poster) values('film 0', '2019-12-1', 'description 0', FILE_READ('src/main/resources/images/cover2.jpg'));
insert into polygon.performances(name, date, description, poster) values('РЖЕВ', '2019-12-2', 'Красная Армия после нескольких месяцев ожесточенных боев, наконец-то выбивает врага из села Овсянниково, что стоит огромных потерь — от роты остается всего треть личного состава. Измотанные до предела бойцы ждут подкрепления…', FILE_READ('src/main/resources/images/cover4.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 2', '2019-03-14', 'description 2', FILE_READ('src/main/resources/images/cover3.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 3', '2018-03-08', 'description 3', FILE_READ('src/main/resources/images/cover1.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 4', '2021-03-11', 'description 4', FILE_READ('src/main/resources/images/cover4.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 5', '2020-08-15', 'description 5', FILE_READ('src/main/resources/images/cover5.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 6', '2017-03-14', 'description 6', FILE_READ('src/main/resources/images/cover6.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 7', '2020-03-08', 'description 3', FILE_READ('src/main/resources/images/cover7.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 8', '2021-03-11', 'description 4', FILE_READ('src/main/resources/images/cover8.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 9', '2020-08-15', 'description 5', FILE_READ('src/main/resources/images/cover9.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 10', '2019-12-19', 'description 6', FILE_READ('src/main/resources/images/cover10.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/cover10.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/cover10.jpg'))
insert into POLYGON.PREVIEWS_PERFORMANCES(previews_id, performance_id) values (1,1);
insert into POLYGON.PREVIEWS_PERFORMANCES(previews_id, performance_id) values (1,2);
insert into POLYGON.PREVIEWS_PERFORMANCES(previews_id, performance_id) values (2,1);
insert into POLYGON.PREVIEWS_PERFORMANCES(previews_id, performance_id) values (2,2);


insert into polygon.categories(name) values ('Боевик');
insert into polygon.categories(name) values ('Экшен');
insert into polygon.categories(name) values ('Мелодрамма');
insert into polygon.categories_performances(categories_id, performance_id) values (1,1);
insert into polygon.categories_performances(categories_id, performance_id) values (2,1);
insert into polygon.categories_performances(categories_id, performance_id) values (3,1);
insert into polygon.categories_performances(categories_id, performance_id) values (1,4);

insert into polygon.categories_performances(categories_id, performance_id) values (3,5);
insert into polygon.categories_performances(categories_id, performance_id) values (2,6);
insert into polygon.categories_performances(categories_id, performance_id) values (1,2);
insert into polygon.categories_performances(categories_id, performance_id) values (2,2);
insert into polygon.categories_performances(categories_id, performance_id) values (1,3);

insert into polygon.categories_performances(categories_id, performance_id) values (1,7);
insert into polygon.categories_performances(categories_id, performance_id) values (2,7);
insert into polygon.categories_performances(categories_id, performance_id) values (1,8);
insert into polygon.categories_performances(categories_id, performance_id) values (2,8);
insert into polygon.categories_performances(categories_id, performance_id) values (1,9);
insert into polygon.categories_performances(categories_id, performance_id) values (2,9);
insert into polygon.categories_performances(categories_id, performance_id) values (2,10);
insert into polygon.categories_performances(categories_id, performance_id) values (1,10);
insert into polygon.categories_performances(categories_id, performance_id) values (3,10);
insert into polygon.categories_performances(categories_id, performance_id) values (1,11);
insert into polygon.categories_performances(categories_id, performance_id) values (2,11);
insert into polygon.categories_performances(categories_id, performance_id) values (3,11);

insert into polygon.rooms(building_id, type) values (1, 'simple');
insert into polygon.rooms(building_id, type) values (1, 'simple');
insert into polygon.rooms(building_id, type) values (2, 'IMAX');
insert into polygon.rooms(building_id, type) values (3, 'IMAX');
insert into polygon.rooms(building_id, type) values (4, 'simple');
insert into polygon.rooms(building_id, type) values (4, 'simple')
insert into polygon.rooms(building_id, type) values (5, 'simple');


insert into polygon.seatsRows(room_id, seatsRow) values (1, 1);
insert into polygon.seatsRows(room_id, seatsRow) values (1, 2);
insert into polygon.seatsRows(room_id, seatsRow) values (1, 3);
insert into polygon.seatsRows(room_id, seatsRow) values (1, 4);

insert into polygon.seats(seatsRow_id, seat) values (1, 1);
insert into polygon.seats(seatsRow_id, seat) values (1, 2);
insert into polygon.seats(seatsRow_id, seat) values (1, 3);
insert into polygon.seats(seatsRow_id, seat) values (1, 4);
insert into polygon.seats(seatsRow_id, seat) values (1, 5);
insert into polygon.seats(seatsRow_id, seat) values (1, 6);
insert into polygon.seats(seatsRow_id, seat) values (1, 7);
insert into polygon.seats(seatsRow_id, seat) values (1, 8);
insert into polygon.seats(seatsRow_id, seat) values (1, 9);

insert into polygon.seats(seatsRow_id, seat) values (2, 1);
insert into polygon.seats(seatsRow_id, seat) values (2, 2);
insert into polygon.seats(seatsRow_id, seat) values (2, 3);
insert into polygon.seats(seatsRow_id, seat) values (2, 4);
insert into polygon.seats(seatsRow_id, seat) values (2, 5);
insert into polygon.seats(seatsRow_id, seat) values (2, 6);
insert into polygon.seats(seatsRow_id, seat) values (2, 7);
insert into polygon.seats(seatsRow_id, seat) values (2, 8);
insert into polygon.seats(seatsRow_id, seat) values (2, 9);

insert into polygon.seats(seatsRow_id, seat) values (3,1);
insert into polygon.seats(seatsRow_id, seat) values (3,2);
insert into polygon.seats(seatsRow_id, seat) values (3,3);
insert into polygon.seats(seatsRow_id, seat) values (3,4);
insert into polygon.seats(seatsRow_id, seat) values (3,5);
insert into polygon.seats(seatsRow_id, seat) values (3,6);
insert into polygon.seats(seatsRow_id, seat) values (3,7);
insert into polygon.seats(seatsRow_id, seat) values (3,8);
insert into polygon.seats(seatsRow_id, seat) values (3, 9);
insert into polygon.seats(seatsRow_id, seat) values (3, 10);
insert into polygon.seats(seatsRow_id, seat) values (3, 11);

insert into polygon.seats(seatsRow_id, seat) values (4,1);
insert into polygon.seats(seatsRow_id, seat) values (4,2);
insert into polygon.seats(seatsRow_id, seat) values (4,3);
insert into polygon.seats(seatsRow_id, seat) values (4,4);
insert into polygon.seats(seatsRow_id, seat) values (4,5);
insert into polygon.seats(seatsRow_id, seat) values (4,6);
insert into polygon.seats(seatsRow_id, seat) values (4,7);
insert into polygon.seats(seatsRow_id, seat) values (4,8);
insert into polygon.seats(seatsRow_id, seat) values (4, 9);
insert into polygon.seats(seatsRow_id, seat) values (4, 10);
insert into polygon.seats(seatsRow_id, seat) values (4, 11);
insert into polygon.seats(seatsRow_id, seat) values (4, 12);

insert into polygon.seatsRows(room_id, seatsRow) values (2, 1);
insert into polygon.seatsRows(room_id, seatsRow) values (2, 2);
insert into polygon.seatsRows(room_id, seatsRow) values (2, 3);
insert into polygon.seatsRows(room_id, seatsRow) values (2, 4);
insert into polygon.seatsRows(room_id, seatsRow) values (2, 5);
insert into polygon.seatsRows(room_id, seatsRow) values (2, 6);

insert into polygon.seats(seatsRow_id, seat) values (5, 1);
insert into polygon.seats(seatsRow_id, seat) values (5, 2);
insert into polygon.seats(seatsRow_id, seat) values (5, 3);
insert into polygon.seats(seatsRow_id, seat) values (5, 4);
insert into polygon.seats(seatsRow_id, seat) values (5, 5);
insert into polygon.seats(seatsRow_id, seat) values (5, 6);
insert into polygon.seats(seatsRow_id, seat) values (5, 7);

insert into polygon.seats(seatsRow_id, seat) values (6, 1);
insert into polygon.seats(seatsRow_id, seat) values (6, 2);
insert into polygon.seats(seatsRow_id, seat) values (6, 3);
insert into polygon.seats(seatsRow_id, seat) values (6, 4);
insert into polygon.seats(seatsRow_id, seat) values (6, 5);
insert into polygon.seats(seatsRow_id, seat) values (6, 6);
insert into polygon.seats(seatsRow_id, seat) values (6, 7);

insert into polygon.seats(seatsRow_id, seat) values (7,1);
insert into polygon.seats(seatsRow_id, seat) values (7,2);
insert into polygon.seats(seatsRow_id, seat) values (7,3);
insert into polygon.seats(seatsRow_id, seat) values (7,4);
insert into polygon.seats(seatsRow_id, seat) values (7,5);
insert into polygon.seats(seatsRow_id, seat) values (7,6);

insert into polygon.seats(seatsRow_id, seat) values (8,1);
insert into polygon.seats(seatsRow_id, seat) values (8,2);
insert into polygon.seats(seatsRow_id, seat) values (8,3);
insert into polygon.seats(seatsRow_id, seat) values (8,4);
insert into polygon.seats(seatsRow_id, seat) values (8,5);
insert into polygon.seats(seatsRow_id, seat) values (8,6);


insert into polygon.seats(seatsRow_id, seat) values (9,1);
insert into polygon.seats(seatsRow_id, seat) values (9,2);
insert into polygon.seats(seatsRow_id, seat) values (9,3);
insert into polygon.seats(seatsRow_id, seat) values (9,4);
insert into polygon.seats(seatsRow_id, seat) values (9,5);
insert into polygon.seats(seatsRow_id, seat) values (9,6);


insert into polygon.seats(seatsRow_id, seat) values (10,1);
insert into polygon.seats(seatsRow_id, seat) values (10,2);
insert into polygon.seats(seatsRow_id, seat) values (10,3);
insert into polygon.seats(seatsRow_id, seat) values (10,4);
insert into polygon.seats(seatsRow_id, seat) values (10,5);
insert into polygon.seats(seatsRow_id, seat) values (10,6);

commit;