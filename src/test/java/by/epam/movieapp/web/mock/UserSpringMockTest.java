package by.epam.movieapp.web.mock;

import by.epam.movieapp.model.User;
import by.epam.movieapp.web.rest.UserRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Olga Shahray
 */
@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserSpringMockTest {

    @Autowired
    private UserRestController controller;

    @Test
    public void testSave(){
        controller.save(new User(0, "User"));
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
