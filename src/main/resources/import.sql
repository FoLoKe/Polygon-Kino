INSERT INTO polygon.cities(name) VALUES('Москва');
INSERT INTO polygon.cities(name) VALUES('Санкт-Петербург');
INSERT INTO polygon.buildings(city_id, type, address) values (1,'Кинотеатр', 'Пушкина к14 а1');
INSERT INTO polygon.buildings(city_id, type, address) values (2,'ТЦ', 'Колотушкина д1');
INSERT INTO polygon.buildings(city_id, type, address) values (2,'Кинотеатр', 'Вишневая д5');
INSERT INTO polygon.buildings(city_id, type, address) values (1,'ТЦ', 'Корзинкина д1');
INSERT INTO polygon.buildings(city_id, type, address) values (1,'Молл', 'Малиновая к1224б');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Джуманджи: Новый уровень', '2018-03-08', 'Сиквел суперуспешного блокбастера «Джуманджи: Зов джунглей» о приключениях четверых друзей внутри загадочной и таящей опасности игры.', FILE_READ('src/main/resources/images/1.jpg'), 'tt7975244', '12+', 'https://www.youtube.com/embed/E_116VG-djE');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Достать ножи', '2019-12-1', 'Признанный сценарист и режиссер Райан Джонсон отдает дань уважения детективному гению Агаты Кристи в фильме "Достать ножи", современной истории об убийстве, в которой под подозрением – каждый. ', FILE_READ('src/main/resources/images/2.jpg'),'tt8946378', '16+', 'https://www.youtube.com/embed/Wi3wPg4IaeA');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Рождество на двоих', '2019-03-14', 'Я обещаю в следующем году: Не влипать в истории. Торжественно завершить карьеру эльфа. Стать суперзвездой, стать певицей, выступать на сцене. Наладить отношения с сестрой. Стать хорошей дочерью. Завязать с вредными привычками.Завязать с мыслями о вредных привычках. Познакомиться с нормальным парнем', FILE_READ('src/main/resources/images/3.jpg'),'tt8623904', '16+', 'https://www.youtube.com/embed/BShQ2aIkWmg');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Ржев', '2019-12-2', 'Красная Армия после нескольких месяцев ожесточенных боев, наконец-то выбивает врага из села Овсянниково, что стоит огромных потерь — от роты остается всего треть личного состава. Измотанные до предела бойцы ждут подкрепления…', FILE_READ('src/main/resources/images/4.jpg'),'tt11426562', '12+', 'https://www.youtube.com/embed/06EYAs1GOp0');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('21 мост', '2020-08-15', 'Он охотится на преступников, которые совершили на Манхэттене дерзкое ограбление, оставив после себя 8 мертвых полицейских. А продажные копы тем временем охотятся на него, пытаясь подставить. ', FILE_READ('src/main/resources/images/5.jpg'),'tt8688634', '12+', 'https://www.youtube.com/embed/2dNjqi7CBsc');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Война токов', '2017-03-14', 'Америка, конец 19-го века. Два лучших ума современности Томас Эдисон и Джордж Вестингауз ведут ожесточенную борьбу за право осветить страну. Блестящий предприниматель и изобретатель Эдисон идет на любые меры, чтобы одержать победу.', FILE_READ('src/main/resources/images/6.jpg'),'tt2140507', '12+', 'https://www.youtube.com/embed/aEkALjltXLE');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Черное рождество', '2020-03-08', 'Праздник, которого вы все ждали от продюсеров фильмов Прочь и Хэллоуин.', FILE_READ('src/main/resources/images/7.jpg'),'tt10481868', '18+', 'https://www.youtube.com/embed/IoArNJyQmKE');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Ford против Ferrari', '2019-03-11', 'Несмотря на все старания конкурентов Энцо Феррари всегда выходил победителем в гонках. Не менее амбициозный Генри Форд решил положить конец его славе и, объединив вокруг себя самоуверенных и наглых конструкторов и инженеров, создал-таки автомобиль, способный побороться на равных с итальянцем.', FILE_READ('src/main/resources/images/8.jpg'),'tt1950186', '16+', 'https://www.youtube.com/embed/fAD-D3P-s0I');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Полицейский с Рублевки', '2020-08-15', 'Близится новый год, и сотрудники отдела полиции Барвихи планируют праздновать его за городом в тёплой компании старых друзей и коллег. Но непредвиденные обстоятельства в лице преступников, ограбивших крупное ювелирное предприятие, ставят праздник под угрозу. ', FILE_READ('src/main/resources/images/9.jpg'),'tt9472658', '12+', 'https://www.youtube.com/embed/HcUfY2lNhoM');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Звездные войны: Скайуокер. Восход', '2019-12-19', 'Легендарная сага, покорившая миллионы поклонников в самых разных странах, возвращается на большие экраны! Девятый эпизод космического эпоса «Звёздные Войны» завершает невероятную историю семьи Скайуокеров, длящуюся уже более сорока лет, и обещает дать ответы на все загадки из предыдущих серий.', FILE_READ('src/main/resources/images/10.jpg'),'tt2527338', '16+', 'https://www.youtube.com/embed/HfnINdtw_8E');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Холодное сердце 2', '2019-12-19', 'В ноябре 2019 года зимнее волшебство возвращается в кинотеатры! Анна, Эльза, Кристоф, его верный олень Свен и никогда не унывающий снеговик Олаф должны будут покинуть уютное королевство Эренделл и отправиться ещё дальше на север, в путешествие.', FILE_READ('src/main/resources/images/11.jpg'),'tt4520988', '6+', 'https://www.youtube.com/embed/WXUB4PnpaO4');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Солярис', '2020-12-19', 'Синематека «Искусство кино» при поддержке ФГУП «Киноконцерн «Мосфильм» выпускает в повторный прокат фильм «Солярис» Андрея Тарковского.', FILE_READ('src/main/resources/images/12.jpg'),'tt0069293', '12+', 'https://www.youtube.com/embed/n6DpzBjNSKc');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Алла Пугачева: Тот самый концерт', '2020-12-19', 'Юбилейный концерт Аллы Пугачевой в Кремлёвском дворце.', FILE_READ('src/main/resources/images/13.jpg'),'tt1003080', '0+', 'https://www.youtube.com/embed/baPG8oU_GPE');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Холоп', '2020-12-19', 'Эгоистичный «мажор» Гриша в один не очень прекрасный день после аварии приходит в себя… в 1860 году в барской усадьбе. Теперь он – обычный холоп без связей и связи: о смартфонах здесь не слышали, а все вокруг него – крепостные. ', FILE_READ('src/main/resources/images/14.jpg'),'tt1467304', '12+', 'https://www.youtube.com/embed/C8m6K_Er3BI');
insert into polygon.performances(name, date, description, poster, restriction, trailerLink) values('Союз спасения', '2020-12-19', 'Декабрь 1825 года, Санкт-Петербург, столица Российской империи, чьи войска недавно заняли Париж. Россия стала первой державой мира. Теперь все кажется возможным. Молодые победители, гвардейские офицеры, уверены, что равенство и свобода наступят здесь и сейчас. ', FILE_READ('src/main/resources/images/15.jpg'), '12+', 'https://www.youtube.com/embed/dHpaNjLWoDU');
insert into polygon.performances(name, date, description, poster, restriction, trailerLink) values('Под водой', '2020-12-19', 'Группа исследователей подводного мира должна выбраться и спастись после того, как землетрясение разрушает их глубоководную лабораторию.', FILE_READ('src/main/resources/images/16.jpg'), '18+', 'https://www.youtube.com/embed/2PA6cwu_DlM');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Олдбой', '2020-12-19', '1988 год. Обыкновенный и ничем не примечательный бизнесмен по имени О Дэ-cу в день трёхлетия своей дочери по пути домой напивается, начинает хулиганить и закономерно попадает в полицейский участок.', FILE_READ('src/main/resources/images/17.jpg'),'tt0364569', '18+', 'https://www.youtube.com/embed/2HkjrJ6IK5E');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Ходячий замок', '2020-12-19', 'Шляпница Софи живет в параллельной вселенной Европы конца XIX века, в которой магия соседствует с технологиями. Ее заурядная жизнь вдруг резко меняется с появлением в городе волшебника Хаула, славящегося способностью порабощать женские сердца.', FILE_READ('src/main/resources/images/18.jpg'),'tt0347149', '6+', 'https://www.youtube.com/embed/IMJ2bNgP048');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Реальная любовь в Нью-Йорке', '2019-12-10', 'Судьбы четверых незнакомцев, попавших в трудное положение, сплетаются воедино.', FILE_READ('src/main/resources/images/19.jpg'), 'tt0314331', '16+', 'https://www.youtube.com/embed/p770IMOvvA8');
insert into polygon.performances(name, date, description, poster, imdbRating, restriction, trailerLink) values('Лев Яшин. Вратарь моей мечты', '2019-12-10', '«Черный паук», «Черная пантера» и даже «Черный осьминог» — такими прозвищами награждали Льва Яшина за гибкость, молниеносное перемещение и гениальное видение поля. Он, неизменно в черном свитере с буквой «Д», был полноправным хозяином в своей штрафной.', FILE_READ('src/main/resources/images/20.jpg'),'tt8266452', '6+', 'https://www.youtube.com/embed/2Jc9zPIwzIo');

insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/22.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/23.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/24.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (1,1);
insert into polygon.previews_performances(performance_id, previews_id) values (1,2);
insert into polygon.previews_performances(performance_id, previews_id) values (1,3);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/25.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/26.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/27.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (2,4);
insert into polygon.previews_performances(performance_id, previews_id) values (2,5);
insert into polygon.previews_performances(performance_id, previews_id) values (2,6);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/28.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/29.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/30.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (3,7);
insert into polygon.previews_performances(performance_id, previews_id) values (3,8);
insert into polygon.previews_performances(performance_id, previews_id) values (3,9);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/31.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/32.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/33.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (4,10);
insert into polygon.previews_performances(performance_id, previews_id) values (4,11);
insert into polygon.previews_performances(performance_id, previews_id) values (4,12);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/34.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/35.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/36.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (5,13);
insert into polygon.previews_performances(performance_id, previews_id) values (5,14);
insert into polygon.previews_performances(performance_id, previews_id) values (5,15);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/37.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/38.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/39.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (6,16);
insert into polygon.previews_performances(performance_id, previews_id) values (6,17);
insert into polygon.previews_performances(performance_id, previews_id) values (6,18);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/40.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/41.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/42.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (7,19);
insert into polygon.previews_performances(performance_id, previews_id) values (7,20);
insert into polygon.previews_performances(performance_id, previews_id) values (7,21);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/43.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/44.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/45.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (8,22);
insert into polygon.previews_performances(performance_id, previews_id) values (8,23);
insert into polygon.previews_performances(performance_id, previews_id) values (8,24);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/46.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/47.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/48.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (9,25);
insert into polygon.previews_performances(performance_id, previews_id) values (9,26);
insert into polygon.previews_performances(performance_id, previews_id) values (9,27);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/49.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/50.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/51.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (10,28);
insert into polygon.previews_performances(performance_id, previews_id) values (10,29);
insert into polygon.previews_performances(performance_id, previews_id) values (10,30);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/52.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/53.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/54.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (11,31);
insert into polygon.previews_performances(performance_id, previews_id) values (11,32);
insert into polygon.previews_performances(performance_id, previews_id) values (11,33);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/55.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/56.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/57.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (12,34);
insert into polygon.previews_performances(performance_id, previews_id) values (12,35);
insert into polygon.previews_performances(performance_id, previews_id) values (12,36);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/58.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/59.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/60.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (13,37);
insert into polygon.previews_performances(performance_id, previews_id) values (13,38);
insert into polygon.previews_performances(performance_id, previews_id) values (13,39);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/61.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/62.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/63.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (14,40);
insert into polygon.previews_performances(performance_id, previews_id) values (14,41);
insert into polygon.previews_performances(performance_id, previews_id) values (14,42);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/64.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/65.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/66.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (15,43);
insert into polygon.previews_performances(performance_id, previews_id) values (15,44);
insert into polygon.previews_performances(performance_id, previews_id) values (15,45);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/67.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/68.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/69.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (16,46);
insert into polygon.previews_performances(performance_id, previews_id) values (16,47);
insert into polygon.previews_performances(performance_id, previews_id) values (16,48);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/70.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/71.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/72.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (17,49);
insert into polygon.previews_performances(performance_id, previews_id) values (17,50);
insert into polygon.previews_performances(performance_id, previews_id) values (17,51);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/73.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/74.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/75.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (18,52);
insert into polygon.previews_performances(performance_id, previews_id) values (18,53);
insert into polygon.previews_performances(performance_id, previews_id) values (18,54);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/76.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/77.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/78.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (19,55);
insert into polygon.previews_performances(performance_id, previews_id) values (19,56);
insert into polygon.previews_performances(performance_id, previews_id) values (19,57);
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/79.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/80.jpg'));
insert into polygon.previews(image) values (FILE_READ('src/main/resources/images/81.jpg'));
insert into polygon.previews_performances(performance_id, previews_id) values (20,58);
insert into polygon.previews_performances(performance_id, previews_id) values (20,59);
insert into polygon.previews_performances(performance_id, previews_id) values (20,60);

insert into polygon.categories(name) values ('Русское кино');
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
insert into polygon.categories_performances(categories_id, performance_id) values (3,19);
insert into polygon.categories_performances(categories_id, performance_id) values (3,20);
insert into polygon.categories_performances(categories_id, performance_id) values (4,2);
insert into polygon.categories_performances(categories_id, performance_id) values (4,5);
insert into polygon.categories_performances(categories_id, performance_id) values (4,7);
insert into polygon.categories_performances(categories_id, performance_id) values (4,13);
insert into polygon.categories_performances(categories_id, performance_id) values (4,16);
insert into polygon.categories_performances(categories_id, performance_id) values (5,1);
insert into polygon.categories_performances(categories_id, performance_id) values (5,3);
insert into polygon.categories_performances(categories_id, performance_id) values (5,9);
insert into polygon.categories_performances(categories_id, performance_id) values (5,19);
insert into polygon.categories_performances(categories_id, performance_id) values (5,11);
insert into polygon.categories_performances(categories_id, performance_id) values (5,14);
insert into polygon.categories_performances(categories_id, performance_id) values (6,11);
insert into polygon.categories_performances(categories_id, performance_id) values (6,18);
insert into polygon.categories_performances(categories_id, performance_id) values (7,8);
insert into polygon.categories_performances(categories_id, performance_id) values (7,20);
insert into polygon.categories_performances(categories_id, performance_id) values (8,4);
insert into polygon.categories_performances(categories_id, performance_id) values (8,6);
insert into polygon.categories_performances(categories_id, performance_id) values (8,8);
insert into polygon.categories_performances(categories_id, performance_id) values (8,15);
insert into polygon.categories_performances(categories_id, performance_id) values (8,20);
insert into polygon.categories_performances(categories_id, performance_id) values (9,12);
insert into polygon.categories_performances(categories_id, performance_id) values (9,17);
insert into polygon.categories_performances(categories_id, performance_id) values (9,18);


insert into polygon.rooms(building_id, type, number) values (1, '2D', 1);
insert into polygon.rooms(building_id, type, number) values (2, '3D', 1);
insert into polygon.rooms(building_id, type, number) values (3, 'IMAX', 1);
insert into polygon.rooms(building_id, type, number) values (4, 'IMAX', 1);
insert into polygon.rooms(building_id, type, number) values (4, '2D', 2);
insert into polygon.rooms(building_id, type, number) values (5, '3D', 1);

-- 1-ый зал (обычный)

insert into polygon.seatsRows(room_id, seatsRow) values (1, 1);
insert into polygon.seatsRows(room_id, seatsRow) values (1, 2);
insert into polygon.seatsRows(room_id, seatsRow) values (1, 3);
insert into polygon.seatsRows(room_id, seatsRow) values (1, 4);

insert into polygon.seats(seatsRow_id, seat, isseat) values (1, 1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (1, 2,false);
insert into polygon.seats(seatsRow_id, seat, isseat) values (1, 2,false);
insert into polygon.seats(seatsRow_id, seat, isseat) values (1, 2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (1, 3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (1, 4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (1, 5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (1, 6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (1, 7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (1, 8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (1, 9,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (2, 1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (2, 2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (2, 3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (2, 4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (2, 5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (2, 6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (2, 7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (2, 8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (2, 9,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (3,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (3,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (3,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (3,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (3,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (3,6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (3,7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (3,8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (3, 9,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (3, 10,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (3, 11,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (4,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (4,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (4,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (4,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (4,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (4,6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (4,7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (4,8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (4, 9,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (4, 10,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (4, 11,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (4, 12,true);

-- 2-ой зал (обычный)

insert into polygon.seatsRows(room_id, seatsRow) values (2, 1);
insert into polygon.seatsRows(room_id, seatsRow) values (2, 2);
insert into polygon.seatsRows(room_id, seatsRow) values (2, 3);
insert into polygon.seatsRows(room_id, seatsRow) values (2, 4);

insert into polygon.seats(seatsRow_id, seat, isseat) values (5, 1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (5, 2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (5, 3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (5, 4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (5, 5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (5, 6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (5, 7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (5, 8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (5, 9,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (6, 1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (6, 2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (6, 3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (6, 4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (6, 5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (6, 6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (6, 7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (6, 8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (6, 9,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (7,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (7,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (7,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (7,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (7,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (7,6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (7,7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (7,8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (7, 9,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (7, 10,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (7, 11,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (8,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (8,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (8,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (8,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (8,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (8,6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (8,7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (8,8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (8, 9,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (8, 10,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (8, 11,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (8, 12,true);

-- 3-ий зал (IMAX)

insert into polygon.seatsRows(room_id, seatsRow) values (3, 1);
insert into polygon.seatsRows(room_id, seatsRow) values (3, 2);
insert into polygon.seatsRows(room_id, seatsRow) values (3, 3);
insert into polygon.seatsRows(room_id, seatsRow) values (3, 4);
insert into polygon.seatsRows(room_id, seatsRow) values (3, 5);
insert into polygon.seatsRows(room_id, seatsRow) values (3, 6);

insert into polygon.seats(seatsRow_id, seat, isseat) values (9, 1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (9, 2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (9, 3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (9, 4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (9, 5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (9, 6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (9, 7,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (10, 1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (10, 2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (10, 3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (10, 4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (10, 5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (10, 6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (10, 7,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (11,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (11,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (11,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (11,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (11,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (11,6,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (12,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (12,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (12,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (12,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (12,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (12,6,true);


insert into polygon.seats(seatsRow_id, seat, isseat) values (13,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (13,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (13,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (13,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (13,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (13,6,true);


insert into polygon.seats(seatsRow_id, seat, isseat) values (14,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (14,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (14,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (14,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (14,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (14,6,true);

-- 4-ый зал (IMAX)

insert into polygon.seatsRows(room_id, seatsRow) values (4, 1);
insert into polygon.seatsRows(room_id, seatsRow) values (4, 2);
insert into polygon.seatsRows(room_id, seatsRow) values (4, 3);
insert into polygon.seatsRows(room_id, seatsRow) values (4, 4);
insert into polygon.seatsRows(room_id, seatsRow) values (4, 5);
insert into polygon.seatsRows(room_id, seatsRow) values (4, 6);

insert into polygon.seats(seatsRow_id, seat, isseat) values (15, 1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (15, 2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (15, 3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (15, 4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (15, 5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (15, 6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (15, 7,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (16, 1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (16, 2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (16, 3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (16, 4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (16, 5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (16, 6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (16, 7,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (17,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (17,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (17,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (17,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (17,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (17,6,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (18,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (18,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (18,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (18,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (18,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (18,6,true);


insert into polygon.seats(seatsRow_id, seat, isseat) values (19,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (19,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (19,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (19,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (19,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (19,6,true);


insert into polygon.seats(seatsRow_id, seat, isseat) values (20,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (20,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (20,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (20,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (20,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (20,6,true);

-- 5-ый зал (обычный)

insert into polygon.seatsRows(room_id, seatsRow) values (5, 1);
insert into polygon.seatsRows(room_id, seatsRow) values (5, 2);
insert into polygon.seatsRows(room_id, seatsRow) values (5, 3);
insert into polygon.seatsRows(room_id, seatsRow) values (5, 4);

insert into polygon.seats(seatsRow_id, seat, isseat) values (21, 1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (21, 2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (21, 3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (21, 4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (21, 5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (21, 6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (21, 7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (21, 8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (21, 9,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (22, 1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (22, 2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (22, 3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (22, 4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (22, 5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (22, 6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (22, 7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (22, 8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (22, 9,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (23,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (23,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (23,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (23,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (23,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (23,6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (23,7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (23,8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (23, 9,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (23, 10,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (23, 11,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (24,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (24,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (24,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (24,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (24,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (24,6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (24,7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (24,8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (24, 9,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (24, 10,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (24, 11,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (24, 12,true);

-- 6-ой зал (обычный)

insert into polygon.seatsRows(room_id, seatsRow) values (6, 1);
insert into polygon.seatsRows(room_id, seatsRow) values (6, 2);
insert into polygon.seatsRows(room_id, seatsRow) values (6, 3);
insert into polygon.seatsRows(room_id, seatsRow) values (6, 4);

insert into polygon.seats(seatsRow_id, seat, isseat) values (25, 1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (25, 2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (25, 3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (25, 4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (25, 5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (25, 6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (25, 7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (25, 8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (25, 9,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (26, 1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (26, 2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (26, 3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (26, 4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (26, 5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (26, 6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (26, 7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (26, 8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (26, 9,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (27,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (27,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (27,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (27,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (27,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (27,6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (27,7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (27,8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (27, 9,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (27, 10,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (27, 11,true);

insert into polygon.seats(seatsRow_id, seat, isseat) values (28,1,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (28,2,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (28,3,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (28,4,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (28,5,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (28,6,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (28,7,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (28,8,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (28, 9,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (28, 10,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (28, 11,true);
insert into polygon.seats(seatsRow_id, seat, isseat) values (28, 12,true);

commit;