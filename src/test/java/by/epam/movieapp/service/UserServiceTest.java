package by.epam.movieapp.service;

import by.epam.movieapp.UserTestData.*;
import by.epam.movieapp.model.Role;
import by.epam.movieapp.model.User;
import by.epam.movieapp.service.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static by.epam.movieapp.UserTestData.*;


/**
 * @author Olga Shahray
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql("classpath:db/populateDB.sql")
public class UserServiceTest {

    @Autowired
    private IUserService service;

    @Test
    public void testSave() throws ServiceException {
        TestUser tu = new TestUser("TestUser", "email@example.com", "Password123", "1234567", Role.USER);
        User savedUser = service.save(tu.asUser());
        tu.setId(savedUser.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, tu, USER), service.getAll());
    }

    @Test
    public void testUpdate() throws ServiceException {
        TestUser updatedUser = new TestUser(USER);
        updatedUser.setName("UpdatedName");
        service.update(updatedUser.asUser());
        MATCHER.assertEquals(updatedUser, service.get(USER_ID));
    }

    @Test(expected = DataAccessException.class)
    public void testDublicateSave() throws ServiceException {
        TestUser tu = new TestUser("Duplicate", "user@yandex.ru", "Password123", "1234567", Role.USER);
        service.save(tu.asUser());
    }

    @Test
    public void testDelete() throws ServiceException {
        service.delete(ADMIN_ID);
        MATCHER.assertCollectionEquals(Collections.singletonList(USER), service.getAll());
    }

    @Test
    public void testGet() throws ServiceException {
        User user = service.get(ADMIN_ID);
        MATCHER.assertEquals(ADMIN, user);
    }

    @Test
    public void testGetAll() throws ServiceException {
        List<User> allUsers = service.getAll();
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, USER), allUsers);
    }

}
