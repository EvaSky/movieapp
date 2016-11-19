package by.epam.movieapp.repository.mock;

import by.epam.movieapp.LoggerWrapper;
import by.epam.movieapp.model.User;
import by.epam.movieapp.repository.IUserRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Olga Shahray
 */
@Repository
public class MockUserRepository implements IUserRepository{
    private static final LoggerWrapper LOG = LoggerWrapper.get(MockUserRepository.class);

    @Override
    public User save(User user) throws RepositoryException {
        LOG.info("save user in MockUserRepository");
        return user;
    }

    @Override
    public User authorize(String email, String password) throws RepositoryException {
        return null;
    }

    @Override
    public boolean delete(int id) throws RepositoryException {
        LOG.info("delete user " + id + " in MockUserRepository");
        return true;
    }

    @Override
    public User get(int id) throws RepositoryException {
        LOG.info("get user " + id + " in MockUserRepository");
        return null;
    }

    @Override
    public List<User> getAll(int offset, int count) throws RepositoryException {
        return null;
    }

    @Override
    public List<User> getAll() throws RepositoryException {
        LOG.info("get all users in MockUserRepository");
        return null;
    }

    @Override
    public int checkIfEmailExist(String email) throws RepositoryException {
        return 0;
    }

    @Override
    public int getCountUsers() throws RepositoryException {
        return 0;
    }
}
