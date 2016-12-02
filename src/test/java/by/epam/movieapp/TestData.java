package by.epam.movieapp;

import by.epam.movieapp.matcher.ModelMatcher;
import by.epam.movieapp.model.Role;
import by.epam.movieapp.model.User;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

/**
 * @author Olga Shahray
 */
public final class TestData {

    private static int START_SEQ = 1;

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User ADMIN = new User(USER_ID, "Mike1", "admin@yandex.ru", "pass", "+375292223344", null, LocalDateTime.of(2016, Month.OCTOBER, 25, 0, 0), Role.ADMIN);
    public static final User USER = new User(ADMIN_ID, "Kris1", "user@yandex.ru", "pass", "+375295556677", null, LocalDateTime.of(2016, Month.OCTOBER, 25, 0, 0), Role.USER);


    public static class TestUser extends User {

        public TestUser(User u) {
            this(u.getId(), u.getName(), u.getEmail(), u.getPass(), u.getPhone(), u.getPhoto(), u.getDateRegistration(), u.getRole());
        }

        public TestUser(String name, String email, String password, String phone, Role role) {
            this(0, name, email, password, phone, null, null, role);
        }

        public TestUser(int id, String name, String email, String password, String phone, String photo, LocalDateTime dateReg, Role role) {
            super(id, name, email, password, phone, photo, dateReg, role);
        }

        @Override
        public String toString() {
            return "User (" +
                    "id=" + id +
                    ", name=" + name +
                    ", email=" + email +
                    ", password=" + pass +
                    ", phone=" + phone +
                    ", photo=" + photo +
                    ", role=" + role +
                    ')';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            TestUser that = (TestUser) o;
            return Objects.equals(this.id, that.id)
                    && Objects.equals(this.name, that.name)
                    && Objects.equals(this.email, that.email)
                    && Objects.equals(this.pass, that.pass)
                    && Objects.equals(this.phone, that.phone)
                    && Objects.equals(this.photo, that.photo)
                    && Objects.equals(this.role, that.role);
        }
    }
    /*public static final ModelMatcher<User, TestUser> MATCHER = new ModelMatcher<>(
            new Function<User, TestUser>() {
                @Override
                public TestUser apply(User u) {
                    return ((u instanceof TestUser) ? (TestUser) u : new TestUser(u));
                }
            }
            u -> ((u instanceof TestUser) ? (TestUser) u : new TestUser(u)), User.class);*/
    public static final ModelMatcher<User, TestUser> MATCHER = new ModelMatcher<>(u -> ((u instanceof TestUser) ? (TestUser) u : new TestUser(u)));


}
