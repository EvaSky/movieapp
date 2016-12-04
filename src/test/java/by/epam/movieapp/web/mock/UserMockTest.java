package by.epam.movieapp.web.mock;

import by.epam.movieapp.model.Role;
import by.epam.movieapp.model.User;
import by.epam.movieapp.repository.IUserRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import by.epam.movieapp.repository.mock.MockUserRepository;
import by.epam.movieapp.web.rest.UserRestController;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static by.epam.movieapp.UserTestData.ADMIN;
import static by.epam.movieapp.UserTestData.USER;

/**
 * @author Olga Shahray
 */
public class UserMockTest {
    private  static ConfigurableApplicationContext context;
    private static UserRestController controller;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/mock.xml");
        System.out.println("\n" + Arrays.toString(context.getBeanDefinitionNames()) + "\n");
        controller = context.getBean(UserRestController.class);
    }

    @Before
    public void setUp() throws Exception {
        // Re-initialize
        IUserRepository repository = context.getBean(MockUserRepository.class);
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

    @AfterClass
    public static void afterClass() {
        context.close();
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
