DROP TABLE IF EXISTS discount;
DROP TABLE IF EXISTS preferences;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS filmmakers;
DROP TABLE IF EXISTS allfilmmakers;
DROP TABLE IF EXISTS filmgenres;
DROP TABLE IF EXISTS allgenres;
DROP TABLE IF EXISTS films;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 1;

CREATE TABLE users
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name              VARCHAR NOT NULL,
  email             VARCHAR NOT NULL,
  password          VARCHAR NOT NULL,
  phone             VARCHAR NOT NULL,
  photo             VARCHAR,
  date_reg          TIMESTAMP DEFAULT now(),
  role              VARCHAR NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE country
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  country           VARCHAR NOT NULL UNIQUE
);

CREATE TABLE films
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  title             VARCHAR NOT NULL,
  release_year      SMALLINT CHECK (release_year > 1900),
  country_id        INTEGER NOT NULL,
  description       TEXT NOT NULL,
  duration          SMALLINT CHECK (duration > 0),
  age_restriction   SMALLINT CHECK (age_restriction >= 0),
  price             NUMERIC CHECK (price > 0),
  poster            VARCHAR NOT NULL,
  video             VARCHAR NOT NULL,
  rating            DECIMAL DEFAULT 0.0 CHECK (rating >= 0.0),
  date_add          DATE DEFAULT now(),
  FOREIGN KEY (country_id) REFERENCES country (id) ON DELETE CASCADE
);
CREATE INDEX films_title_idx ON films (title);
CREATE INDEX films_country_idx ON films (country_id);

CREATE TABLE allgenres
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  genre_name        VARCHAR NOT NULL
);
CREATE UNIQUE INDEX allgenres_unique_genre_idx ON allgenres (genre_name);

CREATE TABLE filmgenres
(
  film_id            INTEGER NOT NULL,
  genre_id           INTEGER NOT NULL,
  CONSTRAINT filmgenres_idx UNIQUE (film_id, genre_id),
  FOREIGN KEY (film_id) REFERENCES films (id) ON DELETE CASCADE,
  FOREIGN KEY (genre_id) REFERENCES allgenres (id) ON DELETE CASCADE
);

CREATE TABLE allfilmmakers
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name              VARCHAR NOT NULL,
  profession        VARCHAR NOT NULL
);
CREATE UNIQUE INDEX allfilmmakers_unique_name_idx ON allfilmmakers (name, profession);

CREATE TABLE filmmakers
(
  film_id            INTEGER NOT NULL,
  person_id          INTEGER NOT NULL,
  CONSTRAINT filmakers_idx UNIQUE (film_id, person_id),
  FOREIGN KEY (film_id) REFERENCES films (id) ON DELETE CASCADE,
  FOREIGN KEY (person_id) REFERENCES allfilmmakers (id) ON DELETE CASCADE
);

CREATE TABLE comments
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  film_id           INTEGER NOT NULL,
  user_id           INTEGER NOT NULL,
  mark              SMALLINT CHECK (mark >= 1 AND mark <= 5) ,
  comment           TEXT NOT NULL,
  date_com          TIMESTAMP DEFAULT now(),
  status            VARCHAR NOT NULL,
  FOREIGN KEY (film_id) REFERENCES films (id) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE orders
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  film_id           INTEGER NOT NULL,
  user_id           INTEGER NOT NULL,
  date_sale         TIMESTAMP DEFAULT now(),
  sum               NUMERIC CHECK (sum > 0),
  status            VARCHAR NOT NULL,
  FOREIGN KEY (film_id) REFERENCES films (id) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE preferences
(
  user_id            INTEGER NOT NULL,
  film_id            INTEGER NOT NULL,
  CONSTRAINT preferences_idx UNIQUE (user_id, film_id),
  FOREIGN KEY (film_id) REFERENCES films (id) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE discount
(
  discount_id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  sum_from          NUMERIC CHECK (sum_from >= 0.0),
  value             NUMERIC CHECK (value > 0.0)
);
