DELETE FROM discount;
DELETE FROM preferences;
DELETE FROM orders;
DELETE FROM comments;
DELETE FROM filmmakers;
DELETE FROM allfilmmakers;
DELETE FROM filmgenres;
DELETE FROM allgenres;
DELETE FROM country;
DELETE FROM films;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO users (name, email, password, phone, role)
VALUES ('Mike1', 'admin@yandex.ru', 'pass', '+375292223344', 'admin');

INSERT INTO users (name, email, password, phone, role)
VALUES ('Kris2', 'user@yandex.ru', 'pass', '+375295556677', 'user');

INSERT INTO country (country)
VALUES ('USA3');

INSERT INTO films (title, release_year, country_id, description, duration, age_restriction, price, poster, video, rating)
VALUES ('4 film', 2016, 3, 'About love', 90, 16, 10.0, 'movie1.jpg', 'movie1.link', 5.0);

INSERT INTO films (title, release_year, country_id, description, duration, age_restriction, price, poster, video, rating)
VALUES ('5 filmy', 2015, 3, 'About love', 100, 12, 10.0, 'movie2.jpg', 'movie2.link', 4.0);

INSERT INTO allgenres (genre)
VALUES ('adventure6');

INSERT INTO filmgenres (film_id, genre_id)
VALUES (4, 6);

INSERT INTO filmgenres (film_id, genre_id)
VALUES (5, 6);

INSERT INTO allfilmmakers (name, profession)
VALUES ('Actor7', 'actor');

INSERT INTO allfilmmakers (name, profession)
VALUES ('Director8', 'director');

INSERT INTO filmmakers (film_id, person_id)
VALUES (4, 7);

INSERT INTO filmmakers (film_id, person_id)
VALUES (4, 8);

INSERT INTO filmmakers (film_id, person_id)
VALUES (5, 8);

INSERT INTO comments (film_id, user_id, mark, comment, status)
VALUES (4, 2, 5, 'good9', 'new');

INSERT INTO orders (film_id, user_id, sum, status)
VALUES (4, 2, 10.0, 'paid');

INSERT INTO preferences (user_id, film_id)
VALUES (2, 5);