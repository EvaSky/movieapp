package by.epam.movieapp;

import by.epam.movieapp.model.Role;
import by.epam.movieapp.model.User;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * @author Olga Shahray
 */
public final class TestData {

    private static int START_SEQ = 1;

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User ADMIN = new User(USER_ID, "Mike1", "admin@yandex.ru", "pass", "+375292223344", null, LocalDateTime.of(2016, Month.OCTOBER, 25, 0, 0), Role.ADMIN);
    public static final User USER = new User(ADMIN_ID, "Kris1", "user@yandex.ru", "pass", "+375295556677", null, LocalDateTime.of(2016, Month.OCTOBER, 25, 0, 0), Role.USER);
}
