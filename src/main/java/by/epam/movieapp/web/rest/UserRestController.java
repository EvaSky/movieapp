package by.epam.movieapp.web.rest;

import by.epam.movieapp.LoggerWrapper;
import by.epam.movieapp.model.User;
import by.epam.movieapp.service.IUserService;
import by.epam.movieapp.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Controller
public class UserRestController {
    private static final LoggerWrapper LOG = LoggerWrapper.get(UserRestController.class);

    @Autowired
    private IUserService userService;

    public User save(User user){
        try {
            return userService.save(user);
        } catch (ServiceException e) {
            LOG.error("exception caught " + e);
        }
        return user;
    }


    public User get(int id) {
        try {
            return userService.get(id);
        } catch (ServiceException e) {
            LOG.error("exception caught " + e);
        }
        return null;
    }

    public void delete(int id) {
        try {
            userService.delete(id);
        } catch (ServiceException e) {
            LOG.error("exception caught " + e);
        }
    }

    public List<User> getAll() {
        try {
            return userService.getAll();
        } catch (ServiceException e) {
            LOG.error("exception caught " + e);
        }
        return null;
    }
}
