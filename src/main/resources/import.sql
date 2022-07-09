INSERT INTO polygon.cities(name) VALUES
('Москва'), ('Санкт-Петербург');

INSERT INTO polygon.buildings(city_id, type, address) VALUES
(1,'Кинотеатр', 'Пушкина к14 а1'),
(2,'ТЦ', 'Колотушкина д1'),
(2,'Кинотеатр', 'Вишневая д5'),
(1,'ТЦ', 'Корзинкина д1'),
(1,'Молл', 'Малиновая к1224б');

INSERT INTO polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) VALUES
('Джуманджи: Новый уровень', '2018-03-08', 'Сиквел суперуспешного блокбастера «Джуманджи: Зов джунглей» о приключениях четверых друзей внутри загадочной и таящей опасности игры.', FILE_READ('src/main/resources/images/1.jpg'), 'tt7975244', '12+', 'https://www.youtube.com/embed/E_116VG-djE'),
('Достать ножи', '2019-12-1', 'Признанный сценарист и режиссер Райан Джонсон отдает дань уважения детективному гению Агаты Кристи в фильме "Достать ножи", современной истории об убийстве, в которой под подозрением – каждый. ', FILE_READ('src/main/resources/images/2.jpg'),'tt8946378', '16+', 'https://www.youtube.com/embed/Wi3wPg4IaeA'),
('Рождество на двоих', '2019-03-14', 'Я обещаю в следующем году: Не влипать в истории. Торжественно завершить карьеру эльфа. Стать суперзвездой, стать певицей, выступать на сцене. Наладить отношения с сестрой. Стать хорошей дочерью. Завязать с вредными привычками.Завязать с мыслями о вредных привычках. Познакомиться с нормальным парнем', FILE_READ('src/main/resources/images/3.jpg'),'tt8623904', '16+', 'https://www.youtube.com/embed/BShQ2aIkWmg'),
('Ржев', '2019-12-2', 'Красная Армия после нескольких месяцев ожесточенных боев, наконец-то выбивает врага из села Овсянниково, что стоит огромных потерь — от роты остается всего треть личного состава. Измотанные до предела бойцы ждут подкрепления…', FILE_READ('src/main/resources/images/4.jpg'),'tt11426562', '12+', 'https://www.youtube.com/embed/06EYAs1GOp0'),
('21 мост', '2020-08-15', 'Он охотится на преступников, которые совершили на Манхэттене дерзкое ограбление, оставив после себя 8 мертвых полицейских. А продажные копы тем временем охотятся на него, пытаясь подставить. ', FILE_READ('src/main/resources/images/5.jpg'),'tt8688634', '12+', 'https://www.youtube.com/embed/2dNjqi7CBsc'),
('Война токов', '2017-03-14', 'Америка, конец 19-го века. Два лучших ума современности Томас Эдисон и Джордж Вестингауз ведут ожесточенную борьбу за право осветить страну. Блестящий предприниматель и изобретатель Эдисон идет на любые меры, чтобы одержать победу.', FILE_READ('src/main/resources/images/6.jpg'),'tt2140507', '12+', 'https://www.youtube.com/embed/aEkALjltXLE'),
('Черное рождество', '2020-03-08', 'Праздник, которого вы все ждали от продюсеров фильмов Прочь и Хэллоуин.', FILE_READ('src/main/resources/images/7.jpg'),'tt10481868', '18+', 'https://www.youtube.com/embed/IoArNJyQmKE'),
('Ford против Ferrari', '2019-03-11', 'Несмотря на все старания конкурентов Энцо Феррари всегда выходил победителем в гонках. Не менее амбициозный Генри Форд решил положить конец его славе и, объединив вокруг себя самоуверенных и наглых конструкторов и инженеров, создал-таки автомобиль, способный побороться на равных с итальянцем.', FILE_READ('src/main/resources/images/8.jpg'),'tt1950186', '16+', 'https://www.youtube.com/embed/fAD-D3P-s0I'),
('Полицейский с Рублевки', '2020-08-15', 'Близится новый год, и сотрудники отдела полиции Барвихи планируют праздновать его за городом в тёплой компании старых друзей и коллег. Но непредвиденные обстоятельства в лице преступников, ограбивших крупное ювелирное предприятие, ставят праздник под угрозу. ', FILE_READ('src/main/resources/images/9.jpg'),'tt9472658', '12+', 'https://www.youtube.com/embed/HcUfY2lNhoM'),
('Звездные войны: Скайуокер. Восход', '2019-12-19', 'Легендарная сага, покорившая миллионы поклонников в самых разных странах, возвращается на большие экраны! Девятый эпизод космического эпоса «Звёздные Войны» завершает невероятную историю семьи Скайуокеров, длящуюся уже более сорока лет, и обещает дать ответы на все загадки из предыдущих серий.', FILE_READ('src/main/resources/images/10.jpg'),'tt2527338', '16+', 'https://www.youtube.com/embed/HfnINdtw_8E'),
('Холодное сердце 2', '2019-12-19', 'В ноябре 2019 года зимнее волшебство возвращается в кинотеатры! Анна, Эльза, Кристоф, его верный олень Свен и никогда не унывающий снеговик Олаф должны будут покинуть уютное королевство Эренделл и отправиться ещё дальше на север, в путешествие.', FILE_READ('src/main/resources/images/11.jpg'),'tt4520988', '6+', 'https://www.youtube.com/embed/WXUB4PnpaO4'),
('Солярис', '2020-12-19', 'Синематека «Искусство кино» при поддержке ФГУП «Киноконцерн «Мосфильм» выпускает в повторный прокат фильм «Солярис» Андрея Тарковского.', FILE_READ('src/main/resources/images/12.jpg'),'tt0069293', '12+', 'https://www.youtube.com/embed/n6DpzBjNSKc'),
('Алла Пугачева: Тот самый концерт', '2020-12-19', 'Юбилейный концерт Аллы Пугачевой в Кремлёвском дворце.', FILE_READ('src/main/resources/images/13.jpg'),'tt1003080', '0+', 'https://www.youtube.com/embed/baPG8oU_GPE'),
('Холоп', '2020-12-19', 'Эгоистичный «мажор» Гриша в один не очень прекрасный день после аварии приходит в себя… в 1860 году в барской усадьбе. Теперь он – обычный холоп без связей и связи: о смартфонах здесь не слышали, а все вокруг него – крепостные. ', FILE_READ('src/main/resources/images/14.jpg'),'tt1467304', '12+', 'https://www.youtube.com/embed/C8m6K_Er3BI'),
('Олдбой', '2020-12-19', '1988 год. Обыкновенный и ничем не примечательный бизнесмен по имени О Дэ-cу в день трёхлетия своей дочери по пути домой напивается, начинает хулиганить и закономерно попадает в полицейский участок.', FILE_READ('src/main/resources/images/17.jpg'),'tt0364569', '18+', 'https://www.youtube.com/embed/2HkjrJ6IK5E'),
('Ходячий замок', '2020-12-19', 'Шляпница Софи живет в параллельной вселенной Европы конца XIX века, в которой магия соседствует с технологиями. Ее заурядная жизнь вдруг резко меняется с появлением в городе волшебника Хаула, славящегося способностью порабощать женские сердца.', FILE_READ('src/main/resources/images/18.jpg'),'tt0347149', '6+', 'https://www.youtube.com/embed/IMJ2bNgP048'),
('Реальная любовь в Нью-Йорке', '2019-12-10', 'Судьбы четверых незнакомцев, попавших в трудное положение, сплетаются воедино.', FILE_READ('src/main/resources/images/19.jpg'), 'tt0314331', '16+', 'https://www.youtube.com/embed/p770IMOvvA8'),
('Лев Яшин. Вратарь моей мечты', '2019-12-10', '«Черный паук», «Черная пантера» и даже «Черный осьминог» — такими прозвищами награждали Льва Яшина за гибкость, молниеносное перемещение и гениальное видение поля. Он, неизменно в черном свитере с буквой «Д», был полноправным хозяином в своей штрафной.', FILE_READ('src/main/resources/images/20.jpg'),'tt8266452', '6+', 'https://www.youtube.com/embed/2Jc9zPIwzIo');

INSERT INTO polygon.performances(name, date, description, poster, restriction, trailerLink) VALUES
('Союз спасения', '2020-12-19', 'Декабрь 1825 года, Санкт-Петербург, столица Российской империи, чьи войска недавно заняли Париж. Россия стала первой державой мира. Теперь все кажется возможным. Молодые победители, гвардейские офицеры, уверены, что равенство и свобода наступят здесь и сейчас. ', FILE_READ('src/main/resources/images/15.jpg'), '12+', 'https://www.youtube.com/embed/dHpaNjLWoDU'),
('Под водой', '2020-12-19', 'Группа исследователей подводного мира должна выбраться и спастись после того, как землетрясение разрушает их глубоководную лабораторию.', FILE_READ('src/main/resources/images/16.jpg'), '18+', 'https://www.youtube.com/embed/2PA6cwu_DlM');

INSERT INTO polygon.previews(image) VALUES 
(FILE_READ('src/main/resources/images/22.jpg')), (FILE_READ('src/main/resources/images/23.jpg')),
(FILE_READ('src/main/resources/images/24.jpg')), (FILE_READ('src/main/resources/images/25.jpg')),
(FILE_READ('src/main/resources/images/26.jpg')), (FILE_READ('src/main/resources/images/27.jpg')),
(FILE_READ('src/main/resources/images/28.jpg')), (FILE_READ('src/main/resources/images/29.jpg')),
(FILE_READ('src/main/resources/images/30.jpg')), (FILE_READ('src/main/resources/images/31.jpg')),
(FILE_READ('src/main/resources/images/32.jpg')), (FILE_READ('src/main/resources/images/33.jpg')),
(FILE_READ('src/main/resources/images/34.jpg')), (FILE_READ('src/main/resources/images/35.jpg')),
(FILE_READ('src/main/resources/images/36.jpg')), (FILE_READ('src/main/resources/images/37.jpg')),
(FILE_READ('src/main/resources/images/38.jpg')), (FILE_READ('src/main/resources/images/39.jpg')),
(FILE_READ('src/main/resources/images/40.jpg')), (FILE_READ('src/main/resources/images/41.jpg')),
(FILE_READ('src/main/resources/images/42.jpg')), (FILE_READ('src/main/resources/images/43.jpg')),
(FILE_READ('src/main/resources/images/44.jpg')), (FILE_READ('src/main/resources/images/45.jpg')),
(FILE_READ('src/main/resources/images/46.jpg')), (FILE_READ('src/main/resources/images/47.jpg')),
(FILE_READ('src/main/resources/images/48.jpg')), (FILE_READ('src/main/resources/images/49.jpg')),
(FILE_READ('src/main/resources/images/50.jpg')), (FILE_READ('src/main/resources/images/51.jpg')),
(FILE_READ('src/main/resources/images/52.jpg')), (FILE_READ('src/main/resources/images/53.jpg')),
(FILE_READ('src/main/resources/images/54.jpg')), (FILE_READ('src/main/resources/images/55.jpg')),
(FILE_READ('src/main/resources/images/56.jpg')), (FILE_READ('src/main/resources/images/57.jpg')),
(FILE_READ('src/main/resources/images/58.jpg')), (FILE_READ('src/main/resources/images/59.jpg')),
(FILE_READ('src/main/resources/images/60.jpg')), (FILE_READ('src/main/resources/images/61.jpg')),
(FILE_READ('src/main/resources/images/62.jpg')), (FILE_READ('src/main/resources/images/63.jpg')),
(FILE_READ('src/main/resources/images/64.jpg')), (FILE_READ('src/main/resources/images/65.jpg')),
(FILE_READ('src/main/resources/images/66.jpg')), (FILE_READ('src/main/resources/images/67.jpg')),
(FILE_READ('src/main/resources/images/68.jpg')), (FILE_READ('src/main/resources/images/69.jpg')),
(FILE_READ('src/main/resources/images/70.jpg')), (FILE_READ('src/main/resources/images/71.jpg')),
(FILE_READ('src/main/resources/images/72.jpg')), (FILE_READ('src/main/resources/images/73.jpg')),
(FILE_READ('src/main/resources/images/74.jpg')), (FILE_READ('src/main/resources/images/75.jpg')),
(FILE_READ('src/main/resources/images/76.jpg')), (FILE_READ('src/main/resources/images/77.jpg')),
(FILE_READ('src/main/resources/images/78.jpg')), (FILE_READ('src/main/resources/images/79.jpg')),
(FILE_READ('src/main/resources/images/80.jpg')), (FILE_READ('src/main/resources/images/81.jpg'));

INSERT INTO polygon.previews_performances(performance_id, previews_id) VALUES 
(1, 1), (1, 2), (1, 3),
(2, 4), (2, 5), (2, 6),
(3, 7), (3, 8), (3, 9),
(4, 10), (4, 11), (4, 12),
(5, 13), (5, 14), (5, 15),
(6, 16), (6, 17), (6, 18),
(7, 19), (7, 20), (7, 21),
(8, 22), (8, 23), (8, 24),
(9, 25), (9, 26), (9, 27),
(10, 28), (10, 29), (10, 30),
(11, 31), (11, 32), (11, 33),
(12, 34), (12, 35), (12, 36),
(13, 37), (13, 38), (13, 39),
(14, 40), (14, 41), (14, 42),
(15, 43), (15, 44), (15, 45),
(16, 46), (16, 47), (16, 48),
(17, 49), (17, 50), (17, 51),
(18, 52), (18, 53), (18, 54),
(19, 55), (19, 56), (19, 57),
(20, 58), (20, 59), (20, 60);

INSERT INTO polygon.categories(name) VALUES 
('Русское кино'), ('Экшен'), ('Мелодрамма'),
('Триллер'), ('Комедия'), ('Анимация'),
('Спортивная драма'), ('Исторический'),
('Классика мирового кино');

INSERT INTO polygon.categories_performances(categories_id, performance_id) VALUES 
(1, 4), (1, 9), (1, 12), (1, 13), (1, 14), (1, 15), (1, 16),
(2, 1), (2, 2), (2, 4), (2, 5), (2, 7), (2, 8), (2, 10), (2, 16), (2, 17),
(3, 3), (3, 6), (3, 8), (3, 10), (3, 11), (3, 15), (3, 18), (3, 19), (3, 20),
(4, 2), (4, 5), (4, 7), (4, 13), (4, 16),
(5, 1), (5, 3), (5, 9), (5, 19), (5, 11), (5, 14),
(6, 11), (6, 18),
(7, 8), (7, 20),
(8, 4), (8, 6), (8, 8), (8, 15), (8, 20),
(9, 12), (9, 17), (9, 18);

INSERT INTO polygon.rooms(building_id, type, number) VALUES 
(1, '2D', 1),
(2, '3D', 1),
(3, 'IMAX', 1),
(4, 'IMAX', 1), (4, '2D', 2),
(5, '3D', 1);

-- 1-ый зал (обычный)
INSERT INTO polygon.seatsRows(room_id, seatsRow) VALUES 
(1, 1), (1, 2), (1, 3), (1, 4);

INSERT INTO polygon.seats(seatsRow_id, seat, isSeat) VALUES
(1, 1, true), (1, 2, false), (1, 2, false), (1, 2, true),
(1, 3, true), (1, 4, true), (1, 5, true), (1, 6, true),
(1, 7, true), (1, 8, true), (1, 9, true),
(2, 1, true), (2, 2, true), (2, 3, true), (2, 4, true),
(2, 5, true), (2, 6, true), (2, 7, true), (2, 8, true),
(2, 9, true),
(3, 1, true), (3, 2, true), (3, 3, true), (3, 4, true),
(3, 5, true), (3, 6, true), (3, 7, true), (3, 8, true),
(3, 9, true), (3, 10, true), (3, 11, true),
(4, 1, true), (4, 2, true), (4, 3, true), (4, 4, true),
(4, 5, true), (4, 6, true), (4, 7, true), (4, 8, true),
(4, 9, true), (4, 10, true), (4, 11, true), (4, 12, true);

-- 2-ой зал (обычный)
INSERT INTO polygon.seatsRows(room_id, seatsRow) VALUES
(2, 1), (2, 2), (2, 3), (2, 4);

INSERT INTO polygon.seats(seatsRow_id, seat, isSeat) VALUES
(5, 1, true), (5, 2, true), (5, 3, true), (5, 4, true),
(5, 5, true), (5, 6, true), (5, 7, true), (5, 8, true),
(5, 9, true),
(6, 1, true), (6, 2, true), (6, 3, true), (6, 4, true),
(6, 5, true), (6, 6, true), (6, 7, true), (6, 8, true),
(6, 9, true),
(7, 1, true), (7, 2, true), (7, 3, true), (7, 4, true),
(7, 5, true), (7, 6, true), (7, 7, true), (7, 8, true),
(7, 9, true), (7, 10, true), (7, 11, true),
(8, 1, true), (8, 2, true), (8, 3, true), (8, 4, true),
(8, 5, true), (8, 6, true), (8, 7, true), (8, 8, true),
(8, 9, true), (8, 10, true), (8, 11, true), (8, 12, true);

-- 3-ий зал (IMAX)
INSERT INTO polygon.seatsRows(room_id, seatsRow) VALUES
(3, 1), (3, 2), (3, 3), (3, 4),
(3, 5), (3, 6);

INSERT INTO polygon.seats(seatsRow_id, seat, isSeat) VALUES
(9, 1, true), (9, 2, true), (9, 3, true), (9, 4, true),
(9, 5, true), (9, 6, true), (9, 7, true),
(10, 1, true), (10, 2, true), (10, 3, true), (10, 4, true),
(10, 5, true), (10, 6, true), (10, 7, true),
(11, 1, true), (11, 2, true), (11, 3, true), (11, 4, true),
(11, 5, true), (11, 6, true),
(12, 1, true), (12, 2, true), (12, 3, true), (12, 4, true),
(12, 5, true), (12, 6, true),
(13, 1, true), (13, 2, true), (13, 3, true), (13, 4, true),
(13, 5, true), (13, 6, true),
(14, 1, true), (14, 2, true), (14, 3, true), (14, 4, true),
(14, 5, true), (14, 6, true);

-- 4-ый зал (IMAX)
INSERT INTO polygon.seatsRows(room_id, seatsRow) VALUES
(4, 1), (4, 2), (4, 3), (4, 4),
(4, 5), (4, 6);

INSERT INTO polygon.seats(seatsRow_id, seat, isSeat) VALUES
(15, 1, true), (15, 2, true), (15, 3, true), (15, 4, true),
(15, 5, true), (15, 6, true), (15, 7, true),
(16, 1, true), (16, 2, true), (16, 3, true), (16, 4, true),
(16, 5, true), (16, 6, true), (16, 7, true),
(17, 1, true), (17, 2, true), (17, 3, true), (17, 4, true),
(17, 5, true), (17, 6, true),
(18, 1, true), (18, 2, true), (18, 3, true), (18, 4, true),
(18, 5, true), (18, 6, true),
(19, 1, true), (19, 2, true), (19, 3, true), (19, 4, true),
(19, 5, true), (19, 6, true),
(20, 1, true), (20, 2, true), (20, 3, true), (20, 4, true),
(20, 5, true), (20, 6, true);

-- 5-ый зал (обычный)

INSERT INTO polygon.seatsRows(room_id, seatsRow) VALUES
(5, 1), (5, 2), (5, 3), (5, 4);

INSERT INTO polygon.seats(seatsRow_id, seat, isSeat) VALUES
(21, 1, true), (21, 2, true), (21, 3, true), (21, 4, true),
(21, 5, true), (21, 6, true), (21, 7, true), (21, 8, true),
(21, 9, true),
(22, 1, true), (22, 2, true), (22, 3, true), (22, 4, true),
(22, 5, true), (22, 6, true), (22, 7, true), (22, 8, true),
(22, 9, true),
(23, 1, true), (23, 2, true), (23, 3, true), (23, 4, true),
(23, 5, true), (23, 6, true), (23, 7, true), (23, 8, true),
(23, 9, true), (23, 10, true), (23, 11, true),
(24, 1, true), (24, 2, true), (24, 3, true), (24, 4, true),
(24, 5, true), (24, 6, true), (24, 7, true), (24, 8, true),
(24, 9, true), (24, 10, true), (24, 11, true), (24, 12, true);

-- 6-ой зал (обычный)
INSERT INTO polygon.seatsRows(room_id, seatsRow) VALUES
(6, 1), (6, 2), (6, 3), (6, 4);

INSERT INTO polygon.seats(seatsRow_id, seat, isSeat) VALUES
(25, 1, true), (25, 2, true), (25, 3, true), (25, 4, true),
(25, 5, true), (25, 6, true), (25, 7, true), (25, 8, true),
(25, 9, true),
(26, 1, true), (26, 2, true), (26, 3, true), (26, 4, true),
(26, 5, true), (26, 6, true), (26, 7, true), (26, 8, true),
(26, 9, true),
(27, 1, true), (27, 2, true), (27, 3, true), (27, 4, true),
(27, 5, true), (27, 6, true), (27, 7, true), (27, 8, true),
(27, 9, true), (27, 10, true), (27, 11, true),
(28, 1, true), (28, 2, true), (28, 3, true), (28, 4, true),
(28, 5, true), (28, 6, true), (28, 7, true), (28, 8, true),
(28, 9, true), (28, 10, true), (28, 11, true), (28, 12, true);

commit;