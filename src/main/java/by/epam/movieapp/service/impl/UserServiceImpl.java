package by.epam.movieapp.service.impl;

import by.epam.movieapp.model.User;
import by.epam.movieapp.repository.IUserRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import by.epam.movieapp.service.IUserService;
import by.epam.movieapp.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User save(User user) throws ServiceException {
        try {
            return userRepository.save(user);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(User user) throws ServiceException {
        try {
            userRepository.save(user);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User get(int id) throws ServiceException {
        try {
            return userRepository.get(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            userRepository.delete(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAll() throws ServiceException {
        try {
            return userRepository.getAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User authorize(String login, String password) throws ServiceException {
        return null;
    }


    public IUserRepository getUserRepository() {
        return userRepository;
    }

    /*public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }*/
}
