Insert into polygon.users(username, password) values ('user','user');
INSERT INTO polygon.cities(name) VALUES('Москва');
INSERT INTO polygon.cities(name) VALUES('Санкт-Петербург');
INSERT INTO polygon.buildings(city_id, type, address) values (1,'Кинотеатр', 'Пушкина к14 а1');
INSERT INTO polygon.buildings(city_id, type, address) values (2,'ТЦ', 'Колотушкина д1');
INSERT INTO polygon.buildings(city_id, type, address) values (2,'Кинотеатр', 'Вишневая д5');
INSERT INTO polygon.buildings(city_id, type, address) values (1,'ТЦ', 'Корзинкина д1');
INSERT INTO polygon.buildings(city_id, type, address) values (1,'Молл', 'Малиновая к1224б');
insert into polygon.performances(name, date, description, poster) values('Аниме', '2019-12-20', 'параша', FILE_READ('src/main/resources/images/cover.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 1', '2019-12-20', 'description 1', FILE_READ('src/main/resources/images/cover1.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 2', '2019-03-14', 'description 2', FILE_READ('src/main/resources/images/cover2.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 3', '2020-03-08', 'description 3', FILE_READ('src/main/resources/images/cover3.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 4', '2021-03-11', 'description 4', FILE_READ('src/main/resources/images/cover4.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 5', '2020-08-15', 'description 5', FILE_READ('src/main/resources/images/cover5.jpg'));
insert into polygon.performances(name, date, description, poster) values('film 6', '2017-03-14', 'description 6', FILE_READ('src/main/resources/images/cover6.jpg'));
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


insert into polygon.sessions(Price, time, Room_id, Performance_id) values (100, '2020-01-15 10:30:00' , 1, 1);
insert into polygon.sessions(Price, time, Room_id, Performance_id) values (100, '2020-01-15 10:35:00' , 3, 2);
insert into polygon.sessions(Price, time, Room_id, Performance_id) values (100, '2020-01-15 12:30:00' , 1, 1);
insert into polygon.sessions(Price, time, Room_id, Performance_id) values (100, '2020-01-15 14:35:00' , 1, 2);
insert into polygon.sessions(Price, time, Room_id, Performance_id) values (100, '2020-01-15 11:50:00' , 3, 1);

insert into polygon.sessions(Price, time, Room_id, Performance_id) values (100, '2020-01-15 10:30:00' , 5, 2);
insert into polygon.sessions(Price, time, Room_id, Performance_id) values (100, '2020-01-15 10:35:00' , 5, 2);
insert into polygon.sessions(Price, time, Room_id, Performance_id) values (100, '2020-01-15 12:30:00' , 6, 2);
insert into polygon.sessions(Price, time, Room_id, Performance_id) values (100, '2020-01-15 14:35:00' , 7, 2);
insert into polygon.sessions(Price, time, Room_id, Performance_id) values (100, '2020-01-15 11:50:00' , 7, 2);


insert into polygon.sessions(Price, time, Room_id, Performance_id) values (100, '2020-01-15 14:35:00' , 2, 2);
insert into polygon.sessions(Price, time, Room_id, Performance_id) values (100, '2020-01-15 11:50:00' , 2, 1);



insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 1);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 2);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 3);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 4);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 5);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 6);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 7);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 8);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 9);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 10);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 11);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 12);
insert into polygon.tickets(occupied, session_Id, seat_id) values (true, 4, 13);
insert into polygon.tickets(occupied, session_Id, seat_id) values (true, 4, 14);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 15);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 16);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 17);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 18);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 19);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 20);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 21);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 22);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 23);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 24);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 25);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 26);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 27);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 28);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 29);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 30);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 31);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 32);
insert into polygon.tickets(occupied, session_Id, seat_id) values (true, 4, 33);
insert into polygon.tickets(occupied, session_Id, seat_id) values (true, 4, 34);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 35);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 36);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 37);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 38);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 39);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 40);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 4, 41);

insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 1);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 2);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 3);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 4);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 5);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 6);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 7);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 8);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 9);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 10);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 11);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 12);
insert into polygon.tickets(occupied, session_Id, seat_id) values (true, 11, 13);
insert into polygon.tickets(occupied, session_Id, seat_id) values (true, 11, 14);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 15);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 16);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 17);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 18);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 19);
insert into polygon.tickets(occupied, session_Id, seat_id) values (false, 11, 20);

commit;