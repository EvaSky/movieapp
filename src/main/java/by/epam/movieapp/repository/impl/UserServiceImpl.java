package by.epam.movieapp.repository.impl;

import by.epam.movieapp.model.User;
import by.epam.movieapp.repository.IUserRepository;
import by.epam.movieapp.service.IUserService;
import by.epam.movieapp.service.exception.ServiceException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public class UserServiceImpl implements IUserService {
    private IUserRepository userRepository;

    @Override
    public User save(User user) throws ServiceException {
        return null;
    }

    @Override
    public User get(int id) throws ServiceException {
        return null;
    }

    @Override
    public void delete(int id) throws ServiceException {

    }

    @Override
    public List<User> getAll() throws ServiceException {
        return null;
    }

    @Override
    public User authorize(String login, String password) throws ServiceException {
        return null;
    }

    @Override
    public int checkEmail(String email) throws ServiceException {
        return 0;
    }

    @Override
    public void updateUserPass(User loggedUser, String newPass, String confirmPass) throws ServiceException {

    }
}
