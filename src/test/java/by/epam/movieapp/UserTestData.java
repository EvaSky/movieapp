package by.epam.movieapp;

import by.epam.movieapp.matcher.ModelMatcher;
import by.epam.movieapp.model.Role;
import by.epam.movieapp.model.User;

import java.util.Objects;

/**
 * @author Olga Shahray
 */
public final class UserTestData {

    private static int START_SEQ = 1;

    public static final int ADMIN_ID = START_SEQ;
    public static final int USER_ID = START_SEQ + 1;

    public static final User ADMIN = new User(ADMIN_ID, "Admin Kris", "admin@yandex.ru", "pass", "+375292223344", Role.ADMIN);
    public static final User USER = new User(USER_ID, "User Mike", "user@yandex.ru", "pass", "+375295556677", Role.USER);

    public static class TestUser extends User {

        public TestUser(User u) {
            this(u.getId(), u.getName(), u.getEmail(), u.getPass(), u.getPhone(), u.getRole());
        }

        public TestUser(String name, String email, String password, String phone, Role role) {
            this(0, name, email, password, phone, role);
        }

        public TestUser(int id, String name, String email, String password, String phone, Role role) {
            super(id, name, email, password, phone, role);
        }

        public User asUser() {
            return new User(this);
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

    public static final ModelMatcher<User, TestUser> MATCHER = new ModelMatcher<>(u -> ((u instanceof TestUser) ? (TestUser) u : new TestUser(u)));


}
