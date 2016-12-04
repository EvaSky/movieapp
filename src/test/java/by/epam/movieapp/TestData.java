package by.epam.movieapp;

import by.epam.movieapp.model.Genre;

/**
 * @author Olga Shahray
 */
public class TestData {
    private static int START_SEQ = 1;

    public static final int GENRE1_ID = START_SEQ + 5;
    public static final int GENRE2_ID = START_SEQ + 6;

    public static final Genre GENRE1 = new Genre(GENRE1_ID, "action6");
    public static final Genre GENRE2 = new Genre(GENRE2_ID, "adventure7");



}

