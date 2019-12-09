
INSERT INTO polygon.cities(name) VALUES('Москва');
INSERT INTO polygon.cities(name) VALUES('Санкт-Петербург');
INSERT INTO polygon.cities(name) VALUES('Челябинск');
INSERT INTO polygon.cities(name) VALUES('Омск');
INSERT INTO polygon.cities(name) VALUES('Мурманск');
INSERT INTO polygon.cities(name) VALUES('Архангельск');
INSERT INTO polygon.cities(name) VALUES('Красноярск');
INSERT INTO polygon.buildings(city_id, type) values (1,'Кинотеатр');
INSERT INTO polygon.buildings(city_id, type) values (2,'ТЦ');
INSERT INTO polygon.buildings(city_id, type) values (2,'Кинотеатр');
INSERT INTO polygon.buildings(city_id, type) values (1,'ТЦ');
INSERT INTO polygon.buildings(city_id, type) values (1,'Молл');
insert into polygon.performances(name, date, description) values('Аниме', '2019-12-01', 'параша');
insert into polygon.performances(name, date, description) values('film 1', '2019-12-20', 'description 1');
insert into polygon.performances(name, date, description) values('film 2', '2019-03-14', 'desc 2');
insert into polygon.performances(name, date, description) values('film 3', '2020-03-08', 'description 3');
insert into polygon.performances(name, date, description) values('film 4', '2021-03-11', 'description 4');
insert into polygon.performances(name, date, description) values('film 5', '2020-08-15', 'description 5');
insert into polygon.performances(name, date, description) values('film 6', '2017-03-14', 'description 6');
insert into polygon.categories(name) values ('Боевик');
insert into polygon.categories(name) values ('Экшен');
insert into polygon.categories(name) values ('Мелодрамма');
insert into polygon.categories_performances(categories_id, performance_id) values (1,1);
insert into polygon.categories_performances(categories_id, performance_id) values (2,1);
insert into polygon.categories_performances(categories_id, performance_id) values (3,1);
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

insert into polygon.seats(seatsRow_id, seat) values (3, 1);
insert into polygon.seats(seatsRow_id, seat) values (3,2);
insert into polygon.seats(seatsRow_id, seat) values (3,3);
insert into polygon.seats(seatsRow_id, seat) values (3,4);
insert into polygon.seats(seatsRow_id, seat) values (3,6);
insert into polygon.seats(seatsRow_id, seat) values (3,7);
insert into polygon.seats(seatsRow_id, seat) values (3,8);
insert into polygon.seats(seatsRow_id, seat) values (3,9);
insert into polygon.seats(seatsRow_id, seat) values (4,1);
insert into polygon.seats(seatsRow_id, seat) values (4,2);
insert into polygon.seats(seatsRow_id, seat) values (4,3);
insert into polygon.seats(seatsRow_id, seat) values (4,4);

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

commit;