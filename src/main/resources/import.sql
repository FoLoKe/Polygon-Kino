Insert into polygon.users(username, password) values ('user','user');
INSERT INTO polygon.cities(name) VALUES('Москва');
INSERT INTO polygon.cities(name) VALUES('Санкт-Петербург');
INSERT INTO polygon.buildings(city_id, type, address) values (1,'Кинотеатр', 'Пушкина к14 а1');
INSERT INTO polygon.buildings(city_id, type, address) values (2,'ТЦ', 'Колотушкина д1');
INSERT INTO polygon.buildings(city_id, type, address) values (2,'Кинотеатр', 'Вишневая д5');
INSERT INTO polygon.buildings(city_id, type, address) values (1,'ТЦ', 'Корзинкина д1');
INSERT INTO polygon.buildings(city_id, type, address) values (1,'Молл', 'Малиновая к1224б');
insert into polygon.performances(name, date, description, poster, imdbRating, trailerLink) values('Джуманджи: Зов джунглей', '2018-03-08', 'Сиквел суперуспешного блокбастера «Джуманджи: Зов джунглей» о приключениях четверых друзей внутри загадочной и таящей опасности игры.', FILE_READ('src/main/resources/images/1.jpg'), 'tt7975244', 'https://www.youtube.com/embed/J_bMArMJ-f8');
insert into polygon.performances(name, date, description, poster) values('Достать ножи', '2019-12-1', 'Признанный сценарист и режиссер Райан Джонсон отдает дань уважения детективному гению Агаты Кристи в фильме "Достать ножи", современной истории об убийстве, в которой под подозрением – каждый. ', FILE_READ('src/main/resources/images/2.jpg'));
insert into polygon.performances(name, date, description, poster) values('Рождество на двоих', '2019-03-14', 'Я обещаю в следующем году: Не влипать в истории. Торжественно завершить карьеру эльфа. Стать суперзвездой, стать певицей, выступать на сцене. Наладить отношения с сестрой. Стать хорошей дочерью. Завязать с вредными привычками.Завязать с мыслями о вредных привычках. Познакомиться с нормальным парнем', FILE_READ('src/main/resources/images/3.jpg'));
insert into polygon.performances(name, date, description, poster) values('Ржев', '2019-12-2', 'Красная Армия после нескольких месяцев ожесточенных боев, наконец-то выбивает врага из села Овсянниково, что стоит огромных потерь — от роты остается всего треть личного состава. Измотанные до предела бойцы ждут подкрепления…', FILE_READ('src/main/resources/images/4.jpg'));
insert into polygon.performances(name, date, description, poster) values('21 мост', '2020-08-15', 'Он охотится на преступников, которые совершили на Манхэттене дерзкое ограбление, оставив после себя 8 мертвых полицейских. А продажные копы тем временем охотятся на него, пытаясь подставить. ', FILE_READ('src/main/resources/images/5.jpg'));
insert into polygon.performances(name, date, description, poster) values('Война токов', '2017-03-14', 'Америка, конец 19-го века. Два лучших ума современности Томас Эдисон и Джордж Вестингауз ведут ожесточенную борьбу за право осветить страну. Блестящий предприниматель и изобретатель Эдисон идет на любые меры, чтобы одержать победу.', FILE_READ('src/main/resources/images/6.jpg'));
insert into polygon.performances(name, date, description, poster) values('Черное рождество', '2020-03-08', 'Праздник, которого вы все ждали от продюсеров фильмов Прочь и Хэллоуин.', FILE_READ('src/main/resources/images/7.jpg'));
insert into polygon.performances(name, date, description, poster) values('Ford против Ferrari', '2019-03-11', 'Несмотря на все старания конкурентов Энцо Феррари всегда выходил победителем в гонках. Не менее амбициозный Генри Форд решил положить конец его славе и, объединив вокруг себя самоуверенных и наглых конструкторов и инженеров, создал-таки автомобиль, способный побороться на равных с итальянцем.', FILE_READ('src/main/resources/images/8.jpg'));
insert into polygon.performances(name, date, description, poster) values('Полицейский с Рублевки', '2020-08-15', 'Близится новый год, и сотрудники отдела полиции Барвихи планируют праздновать его за городом в тёплой компании старых друзей и коллег. Но непредвиденные обстоятельства в лице преступников, ограбивших крупное ювелирное предприятие, ставят праздник под угрозу. ', FILE_READ('src/main/resources/images/9.jpg'));
insert into polygon.performances(name, date, description, poster) values('Звездные войны: Скайуокер. Восход', '2019-12-19', 'Легендарная сага, покорившая миллионы поклонников в самых разных странах, возвращается на большие экраны! Девятый эпизод космического эпоса «Звёздные Войны» завершает невероятную историю семьи Скайуокеров, длящуюся уже более сорока лет, и обещает дать ответы на все загадки из предыдущих серий.', FILE_READ('src/main/resources/images/10.jpg'));
insert into polygon.performances(name, date, description, poster) values('Холодное сердце 2', '2019-12-19', 'В ноябре 2019 года зимнее волшебство возвращается в кинотеатры! Анна, Эльза, Кристоф, его верный олень Свен и никогда не унывающий снеговик Олаф должны будут покинуть уютное королевство Эренделл и отправиться ещё дальше на север, в путешествие.', FILE_READ('src/main/resources/images/11.jpg'));
insert into polygon.performances(name, date, description, poster) values('Солярис', '2020-12-19', 'Синематека «Искусство кино» при поддержке ФГУП «Киноконцерн «Мосфильм» выпускает в повторный прокат фильм «Солярис» Андрея Тарковского.', FILE_READ('src/main/resources/images/12.jpg'));
insert into polygon.performances(name, date, description, poster) values('Алла Пугачева: Тот самый концерт', '2020-12-19', 'Юбилейный концерт Аллы Пугачевой в Кремлёвском дворце.', FILE_READ('src/main/resources/images/13.jpg'));
insert into polygon.performances(name, date, description, poster) values('Холоп', '2020-12-19', 'Эгоистичный «мажор» Гриша в один не очень прекрасный день после аварии приходит в себя… в 1860 году в барской усадьбе. Теперь он – обычный холоп без связей и связи: о смартфонах здесь не слышали, а все вокруг него – крепостные. ', FILE_READ('src/main/resources/images/14.jpg'));
insert into polygon.performances(name, date, description, poster) values('Союз спасения', '2020-12-19', 'Декабрь 1825 года, Санкт-Петербург, столица Российской империи, чьи войска недавно заняли Париж. Россия стала первой державой мира. Теперь все кажется возможным. Молодые победители, гвардейские офицеры, уверены, что равенство и свобода наступят здесь и сейчас. ', FILE_READ('src/main/resources/images/15.jpg'));
insert into polygon.performances(name, date, description, poster) values('Под водой', '2020-12-19', 'Группа исследователей подводного мира должна выбраться и спастись после того, как землетрясение разрушает их глубоководную лабораторию.', FILE_READ('src/main/resources/images/16.jpg'));
insert into polygon.performances(name, date, description, poster) values('Олдбой', '2020-12-19', '1988 год. Обыкновенный и ничем не примечательный бизнесмен по имени О Дэ-cу в день трёхлетия своей дочери по пути домой напивается, начинает хулиганить и закономерно попадает в полицейский участок.', FILE_READ('src/main/resources/images/17.jpg'));
insert into polygon.performances(name, date, description, poster) values('Ходячий замок', '2020-12-19', 'Шляпница Софи живет в параллельной вселенной Европы конца XIX века, в которой магия соседствует с технологиями. Ее заурядная жизнь вдруг резко меняется с появлением в городе волшебника Хаула, славящегося способностью порабощать женские сердца.', FILE_READ('src/main/resources/images/18.jpg'));
insert into polygon.performances(name, date, description, poster) values('Champions Cup Finals Counter Strike: Malta 2019', '2019-12-10', 'Эксклюзивные прямые трансляции Гранд-Финала Champions Cup Finals по игре Counter Strikeна большом экране! Champions Cup Final - финала кубка чемпионов по игре Counter Strike, который пройдет с 19 по 22 декабря на Мальте.', FILE_READ('src/main/resources/images/19.jpg'));
insert into polygon.performances(name, date, description, poster) values('Лев Яшин. Вратарь моей мечты', '2019-12-10', '«Черный паук», «Черная пантера» и даже «Черный осьминог» — такими прозвищами награждали Льва Яшина за гибкость, молниеносное перемещение и гениальное видение поля. Он, неизменно в черном свитере с буквой «Д», был полноправным хозяином в своей штрафной.', FILE_READ('src/main/resources/images/20.jpg'));

insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/18.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/17.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/16.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (1,1);
insert into polygon.previews_performances(performance_id, previews_id) values (1,2);
insert into polygon.previews_performances(performance_id, previews_id) values (1,3);

insert into polygon.categories(name) values ('РУССКИЕ ВПЕРЕД!!!!!!!!!!!!111111111111');
insert into polygon.categories(name) values ('Экшен');
insert into polygon.categories(name) values ('Мелодрамма');
insert into polygon.categories(name) values ('Триллер');
insert into polygon.categories(name) values ('Комедия');
insert into polygon.categories(name) values ('Анимация');
insert into polygon.categories(name) values ('Спортивная драма');
insert into polygon.categories(name) values ('Исторический');
insert into polygon.categories(name) values ('Классика мирового кино');
insert into polygon.categories_performances(categories_id, performance_id) values (1,4);
insert into polygon.categories_performances(categories_id, performance_id) values (1,9);
insert into polygon.categories_performances(categories_id, performance_id) values (1,12);
insert into polygon.categories_performances(categories_id, performance_id) values (1,13);
insert into polygon.categories_performances(categories_id, performance_id) values (1,14);
insert into polygon.categories_performances(categories_id, performance_id) values (1,15);
insert into polygon.categories_performances(categories_id, performance_id) values (1,16);
insert into polygon.categories_performances(categories_id, performance_id) values (2,1);
insert into polygon.categories_performances(categories_id, performance_id) values (2,2);
insert into polygon.categories_performances(categories_id, performance_id) values (2,4);
insert into polygon.categories_performances(categories_id, performance_id) values (2,5);
insert into polygon.categories_performances(categories_id, performance_id) values (2,7);
insert into polygon.categories_performances(categories_id, performance_id) values (2,8);
insert into polygon.categories_performances(categories_id, performance_id) values (2,10);
insert into polygon.categories_performances(categories_id, performance_id) values (2,16);
insert into polygon.categories_performances(categories_id, performance_id) values (2,17);
insert into polygon.categories_performances(categories_id, performance_id) values (3,3);
insert into polygon.categories_performances(categories_id, performance_id) values (3,6);
insert into polygon.categories_performances(categories_id, performance_id) values (3,8);
insert into polygon.categories_performances(categories_id, performance_id) values (3,10);
insert into polygon.categories_performances(categories_id, performance_id) values (3,11);
insert into polygon.categories_performances(categories_id, performance_id) values (3,15);
insert into polygon.categories_performances(categories_id, performance_id) values (3,18);
insert into polygon.categories_performances(categories_id, performance_id) values (3,20);
insert into polygon.categories_performances(categories_id, performance_id) values (4,2);
insert into polygon.categories_performances(categories_id, performance_id) values (4,5);
insert into polygon.categories_performances(categories_id, performance_id) values (4,7);
insert into polygon.categories_performances(categories_id, performance_id) values (4,13);
insert into polygon.categories_performances(categories_id, performance_id) values (4,16);
insert into polygon.categories_performances(categories_id, performance_id) values (5,1);
insert into polygon.categories_performances(categories_id, performance_id) values (5,3);
insert into polygon.categories_performances(categories_id, performance_id) values (5,9);
insert into polygon.categories_performances(categories_id, performance_id) values (5,11);
insert into polygon.categories_performances(categories_id, performance_id) values (5,14);
insert into polygon.categories_performances(categories_id, performance_id) values (6,11);
insert into polygon.categories_performances(categories_id, performance_id) values (6,18);
insert into polygon.categories_performances(categories_id, performance_id) values (7,8);
insert into polygon.categories_performances(categories_id, performance_id) values (7,19);
insert into polygon.categories_performances(categories_id, performance_id) values (7,20);
insert into polygon.categories_performances(categories_id, performance_id) values (8,4);
insert into polygon.categories_performances(categories_id, performance_id) values (8,6);
insert into polygon.categories_performances(categories_id, performance_id) values (8,8);
insert into polygon.categories_performances(categories_id, performance_id) values (8,15);
insert into polygon.categories_performances(categories_id, performance_id) values (8,20);
insert into polygon.categories_performances(categories_id, performance_id) values (9,12);
insert into polygon.categories_performances(categories_id, performance_id) values (9,17);
insert into polygon.categories_performances(categories_id, performance_id) values (9,18);


insert into polygon.rooms(building_id, type, number) values (1, 'simple', 1);
insert into polygon.rooms(building_id, type, number) values (2, 'simple', 1);
insert into polygon.rooms(building_id, type, number) values (3, 'IMAX', 1);
insert into polygon.rooms(building_id, type, number) values (4, 'IMAX', 1);
insert into polygon.rooms(building_id, type, number) values (4, 'simple', 1);
insert into polygon.rooms(building_id, type, number) values (5, 'simple', 2);

-- 1-ый зал (обычный)

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

-- 2-ой зал (обычный)

insert into polygon.seatsRows(room_id, seatsRow) values (2, 1);
insert into polygon.seatsRows(room_id, seatsRow) values (2, 2);
insert into polygon.seatsRows(room_id, seatsRow) values (2, 3);
insert into polygon.seatsRows(room_id, seatsRow) values (2, 4);

insert into polygon.seats(seatsRow_id, seat) values (5, 1);
insert into polygon.seats(seatsRow_id, seat) values (5, 2);
insert into polygon.seats(seatsRow_id, seat) values (5, 3);
insert into polygon.seats(seatsRow_id, seat) values (5, 4);
insert into polygon.seats(seatsRow_id, seat) values (5, 5);
insert into polygon.seats(seatsRow_id, seat) values (5, 6);
insert into polygon.seats(seatsRow_id, seat) values (5, 7);
insert into polygon.seats(seatsRow_id, seat) values (5, 8);
insert into polygon.seats(seatsRow_id, seat) values (5, 9);

insert into polygon.seats(seatsRow_id, seat) values (6, 1);
insert into polygon.seats(seatsRow_id, seat) values (6, 2);
insert into polygon.seats(seatsRow_id, seat) values (6, 3);
insert into polygon.seats(seatsRow_id, seat) values (6, 4);
insert into polygon.seats(seatsRow_id, seat) values (6, 5);
insert into polygon.seats(seatsRow_id, seat) values (6, 6);
insert into polygon.seats(seatsRow_id, seat) values (6, 7);
insert into polygon.seats(seatsRow_id, seat) values (6, 8);
insert into polygon.seats(seatsRow_id, seat) values (6, 9);

insert into polygon.seats(seatsRow_id, seat) values (7,1);
insert into polygon.seats(seatsRow_id, seat) values (7,2);
insert into polygon.seats(seatsRow_id, seat) values (7,3);
insert into polygon.seats(seatsRow_id, seat) values (7,4);
insert into polygon.seats(seatsRow_id, seat) values (7,5);
insert into polygon.seats(seatsRow_id, seat) values (7,6);
insert into polygon.seats(seatsRow_id, seat) values (7,7);
insert into polygon.seats(seatsRow_id, seat) values (7,8);
insert into polygon.seats(seatsRow_id, seat) values (7, 9);
insert into polygon.seats(seatsRow_id, seat) values (7, 10);
insert into polygon.seats(seatsRow_id, seat) values (7, 11);

insert into polygon.seats(seatsRow_id, seat) values (8,1);
insert into polygon.seats(seatsRow_id, seat) values (8,2);
insert into polygon.seats(seatsRow_id, seat) values (8,3);
insert into polygon.seats(seatsRow_id, seat) values (8,4);
insert into polygon.seats(seatsRow_id, seat) values (8,5);
insert into polygon.seats(seatsRow_id, seat) values (8,6);
insert into polygon.seats(seatsRow_id, seat) values (8,7);
insert into polygon.seats(seatsRow_id, seat) values (8,8);
insert into polygon.seats(seatsRow_id, seat) values (8, 9);
insert into polygon.seats(seatsRow_id, seat) values (8, 10);
insert into polygon.seats(seatsRow_id, seat) values (8, 11);
insert into polygon.seats(seatsRow_id, seat) values (8, 12);

-- 3-ий зал (IMAX)

insert into polygon.seatsRows(room_id, seatsRow) values (3, 1);
insert into polygon.seatsRows(room_id, seatsRow) values (3, 2);
insert into polygon.seatsRows(room_id, seatsRow) values (3, 3);
insert into polygon.seatsRows(room_id, seatsRow) values (3, 4);
insert into polygon.seatsRows(room_id, seatsRow) values (3, 5);
insert into polygon.seatsRows(room_id, seatsRow) values (3, 6);

insert into polygon.seats(seatsRow_id, seat) values (9, 1);
insert into polygon.seats(seatsRow_id, seat) values (9, 2);
insert into polygon.seats(seatsRow_id, seat) values (9, 3);
insert into polygon.seats(seatsRow_id, seat) values (9, 4);
insert into polygon.seats(seatsRow_id, seat) values (9, 5);
insert into polygon.seats(seatsRow_id, seat) values (9, 6);
insert into polygon.seats(seatsRow_id, seat) values (9, 7);

insert into polygon.seats(seatsRow_id, seat) values (10, 1);
insert into polygon.seats(seatsRow_id, seat) values (10, 2);
insert into polygon.seats(seatsRow_id, seat) values (10, 3);
insert into polygon.seats(seatsRow_id, seat) values (10, 4);
insert into polygon.seats(seatsRow_id, seat) values (10, 5);
insert into polygon.seats(seatsRow_id, seat) values (10, 6);
insert into polygon.seats(seatsRow_id, seat) values (10, 7);

insert into polygon.seats(seatsRow_id, seat) values (11,1);
insert into polygon.seats(seatsRow_id, seat) values (11,2);
insert into polygon.seats(seatsRow_id, seat) values (11,3);
insert into polygon.seats(seatsRow_id, seat) values (11,4);
insert into polygon.seats(seatsRow_id, seat) values (11,5);
insert into polygon.seats(seatsRow_id, seat) values (11,6);

insert into polygon.seats(seatsRow_id, seat) values (12,1);
insert into polygon.seats(seatsRow_id, seat) values (12,2);
insert into polygon.seats(seatsRow_id, seat) values (12,3);
insert into polygon.seats(seatsRow_id, seat) values (12,4);
insert into polygon.seats(seatsRow_id, seat) values (12,5);
insert into polygon.seats(seatsRow_id, seat) values (12,6);


insert into polygon.seats(seatsRow_id, seat) values (13,1);
insert into polygon.seats(seatsRow_id, seat) values (13,2);
insert into polygon.seats(seatsRow_id, seat) values (13,3);
insert into polygon.seats(seatsRow_id, seat) values (13,4);
insert into polygon.seats(seatsRow_id, seat) values (13,5);
insert into polygon.seats(seatsRow_id, seat) values (13,6);


insert into polygon.seats(seatsRow_id, seat) values (14,1);
insert into polygon.seats(seatsRow_id, seat) values (14,2);
insert into polygon.seats(seatsRow_id, seat) values (14,3);
insert into polygon.seats(seatsRow_id, seat) values (14,4);
insert into polygon.seats(seatsRow_id, seat) values (14,5);
insert into polygon.seats(seatsRow_id, seat) values (14,6);

-- 4-ый зал (IMAX)

insert into polygon.seatsRows(room_id, seatsRow) values (4, 1);
insert into polygon.seatsRows(room_id, seatsRow) values (4, 2);
insert into polygon.seatsRows(room_id, seatsRow) values (4, 3);
insert into polygon.seatsRows(room_id, seatsRow) values (4, 4);
insert into polygon.seatsRows(room_id, seatsRow) values (4, 5);
insert into polygon.seatsRows(room_id, seatsRow) values (4, 6);

insert into polygon.seats(seatsRow_id, seat) values (15, 1);
insert into polygon.seats(seatsRow_id, seat) values (15, 2);
insert into polygon.seats(seatsRow_id, seat) values (15, 3);
insert into polygon.seats(seatsRow_id, seat) values (15, 4);
insert into polygon.seats(seatsRow_id, seat) values (15, 5);
insert into polygon.seats(seatsRow_id, seat) values (15, 6);
insert into polygon.seats(seatsRow_id, seat) values (15, 7);

insert into polygon.seats(seatsRow_id, seat) values (16, 1);
insert into polygon.seats(seatsRow_id, seat) values (16, 2);
insert into polygon.seats(seatsRow_id, seat) values (16, 3);
insert into polygon.seats(seatsRow_id, seat) values (16, 4);
insert into polygon.seats(seatsRow_id, seat) values (16, 5);
insert into polygon.seats(seatsRow_id, seat) values (16, 6);
insert into polygon.seats(seatsRow_id, seat) values (16, 7);

insert into polygon.seats(seatsRow_id, seat) values (17,1);
insert into polygon.seats(seatsRow_id, seat) values (17,2);
insert into polygon.seats(seatsRow_id, seat) values (17,3);
insert into polygon.seats(seatsRow_id, seat) values (17,4);
insert into polygon.seats(seatsRow_id, seat) values (17,5);
insert into polygon.seats(seatsRow_id, seat) values (17,6);

insert into polygon.seats(seatsRow_id, seat) values (18,1);
insert into polygon.seats(seatsRow_id, seat) values (18,2);
insert into polygon.seats(seatsRow_id, seat) values (18,3);
insert into polygon.seats(seatsRow_id, seat) values (18,4);
insert into polygon.seats(seatsRow_id, seat) values (18,5);
insert into polygon.seats(seatsRow_id, seat) values (18,6);


insert into polygon.seats(seatsRow_id, seat) values (19,1);
insert into polygon.seats(seatsRow_id, seat) values (19,2);
insert into polygon.seats(seatsRow_id, seat) values (19,3);
insert into polygon.seats(seatsRow_id, seat) values (19,4);
insert into polygon.seats(seatsRow_id, seat) values (19,5);
insert into polygon.seats(seatsRow_id, seat) values (19,6);


insert into polygon.seats(seatsRow_id, seat) values (20,1);
insert into polygon.seats(seatsRow_id, seat) values (20,2);
insert into polygon.seats(seatsRow_id, seat) values (20,3);
insert into polygon.seats(seatsRow_id, seat) values (20,4);
insert into polygon.seats(seatsRow_id, seat) values (20,5);
insert into polygon.seats(seatsRow_id, seat) values (20,6);

-- 5-ый зал (обычный)

insert into polygon.seatsRows(room_id, seatsRow) values (5, 1);
insert into polygon.seatsRows(room_id, seatsRow) values (5, 2);
insert into polygon.seatsRows(room_id, seatsRow) values (5, 3);
insert into polygon.seatsRows(room_id, seatsRow) values (5, 4);

insert into polygon.seats(seatsRow_id, seat) values (21, 1);
insert into polygon.seats(seatsRow_id, seat) values (21, 2);
insert into polygon.seats(seatsRow_id, seat) values (21, 3);
insert into polygon.seats(seatsRow_id, seat) values (21, 4);
insert into polygon.seats(seatsRow_id, seat) values (21, 5);
insert into polygon.seats(seatsRow_id, seat) values (21, 6);
insert into polygon.seats(seatsRow_id, seat) values (21, 7);
insert into polygon.seats(seatsRow_id, seat) values (21, 8);
insert into polygon.seats(seatsRow_id, seat) values (21, 9);

insert into polygon.seats(seatsRow_id, seat) values (22, 1);
insert into polygon.seats(seatsRow_id, seat) values (22, 2);
insert into polygon.seats(seatsRow_id, seat) values (22, 3);
insert into polygon.seats(seatsRow_id, seat) values (22, 4);
insert into polygon.seats(seatsRow_id, seat) values (22, 5);
insert into polygon.seats(seatsRow_id, seat) values (22, 6);
insert into polygon.seats(seatsRow_id, seat) values (22, 7);
insert into polygon.seats(seatsRow_id, seat) values (22, 8);
insert into polygon.seats(seatsRow_id, seat) values (22, 9);

insert into polygon.seats(seatsRow_id, seat) values (23,1);
insert into polygon.seats(seatsRow_id, seat) values (23,2);
insert into polygon.seats(seatsRow_id, seat) values (23,3);
insert into polygon.seats(seatsRow_id, seat) values (23,4);
insert into polygon.seats(seatsRow_id, seat) values (23,5);
insert into polygon.seats(seatsRow_id, seat) values (23,6);
insert into polygon.seats(seatsRow_id, seat) values (23,7);
insert into polygon.seats(seatsRow_id, seat) values (23,8);
insert into polygon.seats(seatsRow_id, seat) values (23, 9);
insert into polygon.seats(seatsRow_id, seat) values (23, 10);
insert into polygon.seats(seatsRow_id, seat) values (23, 11);

insert into polygon.seats(seatsRow_id, seat) values (24,1);
insert into polygon.seats(seatsRow_id, seat) values (24,2);
insert into polygon.seats(seatsRow_id, seat) values (24,3);
insert into polygon.seats(seatsRow_id, seat) values (24,4);
insert into polygon.seats(seatsRow_id, seat) values (24,5);
insert into polygon.seats(seatsRow_id, seat) values (24,6);
insert into polygon.seats(seatsRow_id, seat) values (24,7);
insert into polygon.seats(seatsRow_id, seat) values (24,8);
insert into polygon.seats(seatsRow_id, seat) values (24, 9);
insert into polygon.seats(seatsRow_id, seat) values (24, 10);
insert into polygon.seats(seatsRow_id, seat) values (24, 11);
insert into polygon.seats(seatsRow_id, seat) values (24, 12);

-- 6-ой зал (обычный)

insert into polygon.seatsRows(room_id, seatsRow) values (6, 1);
insert into polygon.seatsRows(room_id, seatsRow) values (6, 2);
insert into polygon.seatsRows(room_id, seatsRow) values (6, 3);
insert into polygon.seatsRows(room_id, seatsRow) values (6, 4);

insert into polygon.seats(seatsRow_id, seat) values (25, 1);
insert into polygon.seats(seatsRow_id, seat) values (25, 2);
insert into polygon.seats(seatsRow_id, seat) values (25, 3);
insert into polygon.seats(seatsRow_id, seat) values (25, 4);
insert into polygon.seats(seatsRow_id, seat) values (25, 5);
insert into polygon.seats(seatsRow_id, seat) values (25, 6);
insert into polygon.seats(seatsRow_id, seat) values (25, 7);
insert into polygon.seats(seatsRow_id, seat) values (25, 8);
insert into polygon.seats(seatsRow_id, seat) values (25, 9);

insert into polygon.seats(seatsRow_id, seat) values (26, 1);
insert into polygon.seats(seatsRow_id, seat) values (26, 2);
insert into polygon.seats(seatsRow_id, seat) values (26, 3);
insert into polygon.seats(seatsRow_id, seat) values (26, 4);
insert into polygon.seats(seatsRow_id, seat) values (26, 5);
insert into polygon.seats(seatsRow_id, seat) values (26, 6);
insert into polygon.seats(seatsRow_id, seat) values (26, 7);
insert into polygon.seats(seatsRow_id, seat) values (26, 8);
insert into polygon.seats(seatsRow_id, seat) values (26, 9);

insert into polygon.seats(seatsRow_id, seat) values (27,1);
insert into polygon.seats(seatsRow_id, seat) values (27,2);
insert into polygon.seats(seatsRow_id, seat) values (27,3);
insert into polygon.seats(seatsRow_id, seat) values (27,4);
insert into polygon.seats(seatsRow_id, seat) values (27,5);
insert into polygon.seats(seatsRow_id, seat) values (27,6);
insert into polygon.seats(seatsRow_id, seat) values (27,7);
insert into polygon.seats(seatsRow_id, seat) values (27,8);
insert into polygon.seats(seatsRow_id, seat) values (27, 9);
insert into polygon.seats(seatsRow_id, seat) values (27, 10);
insert into polygon.seats(seatsRow_id, seat) values (27, 11);

insert into polygon.seats(seatsRow_id, seat) values (28,1);
insert into polygon.seats(seatsRow_id, seat) values (28,2);
insert into polygon.seats(seatsRow_id, seat) values (28,3);
insert into polygon.seats(seatsRow_id, seat) values (28,4);
insert into polygon.seats(seatsRow_id, seat) values (28,5);
insert into polygon.seats(seatsRow_id, seat) values (28,6);
insert into polygon.seats(seatsRow_id, seat) values (28,7);
insert into polygon.seats(seatsRow_id, seat) values (28,8);
insert into polygon.seats(seatsRow_id, seat) values (28, 9);
insert into polygon.seats(seatsRow_id, seat) values (28, 10);
insert into polygon.seats(seatsRow_id, seat) values (28, 11);
insert into polygon.seats(seatsRow_id, seat) values (28, 12);

commit;