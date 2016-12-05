package by.epam.movieapp;

import by.epam.movieapp.model.*;

/**
 * @author Olga Shahray
 */
public class TestData {
    private static int START_SEQ = 1;

    public static final int COUNTRY_ID = START_SEQ + 2;
    public static final Country COUNTRY = new Country(COUNTRY_ID, "USA3");

    public static final int FILM1_ID = START_SEQ + 3;
    public static final int FILM2_ID = START_SEQ + 4;

    public static final Film FILM1 = new Film(FILM1_ID, "4 film", 2016, COUNTRY, "About love", 90, 16, 10.0, 4.0, "movie1.jpg", "movie1.link");
    public static final Film FILM2 = new Film(FILM2_ID, "5 film", 2015, COUNTRY, "About love", 100, 12, 10.0, 0.0, "movie2.jpg", "movie2.link");

    public static final int GENRE1_ID = START_SEQ + 5;
    public static final int GENRE2_ID = START_SEQ + 6;

    public static final Genre GENRE1 = new Genre(GENRE1_ID, "action6");
    public static final Genre GENRE2 = new Genre(GENRE2_ID, "adventure7");

    public static final int ACTOR_ID = START_SEQ + 7;
    public static final int DIRECTOR_ID = START_SEQ + 8;

    public static final FilmMaker ACTOR = new FilmMaker(ACTOR_ID, "Actor8", Profession.ACTOR);
    public static final FilmMaker DIRECTOR = new FilmMaker(DIRECTOR_ID, "Director9", Profession.DIRECTOR);

    public static final int COMMENT1_ID = START_SEQ + 9;
    public static final int COMMENT2_ID = START_SEQ + 10;

    public static final Comment COMMENT1 = new Comment(COMMENT1_ID, 5, "good10", CommentStatus.CHECKED);
    public static final Comment COMMENT2 = new Comment(COMMENT2_ID, 3, "good11", CommentStatus.CHECKED);

    public static final int ORDER_ID = START_SEQ + 11;
    public static final Order ORDER = new Order(ORDER_ID, null, null, 10.0, OrderStatus.PAID);

    public static final int DISCOUNT1_ID = START_SEQ + 12;
    public static final int DISCOUNT2_ID = START_SEQ + 13;

    public static final Discount DISCOUNT1 = new Discount(DISCOUNT1_ID, 0.0, 0.0);
    public static final Discount DISCOUNT2 = new Discount(DISCOUNT2_ID, 50.0, 5.0);



}

