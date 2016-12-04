package by.epam.movieapp.web.mock;

import by.epam.movieapp.model.Role;
import by.epam.movieapp.model.User;
import by.epam.movieapp.repository.IUserRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import by.epam.movieapp.web.rest.UserRestController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static by.epam.movieapp.UserTestData.ADMIN;
import static by.epam.movieapp.UserTestData.USER;

/**
 * @author Olga Shahray
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/mock.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserSpringMockTest {

    @Autowired
    private UserRestController controller;
    @Autowired
    private IUserRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.getAll().forEach(u -> {
            try {
                repository.delete(u.getId());
            } catch (RepositoryException e) {
                e.printStackTrace();
            }
        });
        repository.save(USER);
        repository.save(ADMIN);
    }

    @Test
    public void testSave(){
        controller.save(new User(0, "TestUser", "email@example.com", "Password123", "1234567", Role.USER));
    }

    @Test
    public void testDelete(){
        controller.delete(1);
    }

    @Test
    public void testGetAll(){
        controller.getAll();
    }
}
