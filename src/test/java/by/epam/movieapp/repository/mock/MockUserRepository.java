package by.epam.movieapp.repository.mock;

import by.epam.movieapp.LoggerWrapper;
import by.epam.movieapp.model.User;
import by.epam.movieapp.repository.IUserRepository;
import by.epam.movieapp.repository.exception.RepositoryException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author Olga Shahray
 */
@Repository
public class MockUserRepository implements IUserRepository{
    private static final LoggerWrapper LOG = LoggerWrapper.get(MockUserRepository.class);

    private Map<Integer, User> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    @PostConstruct
    public void postConstruct(){
        LOG.info("+++++++PostConstruct+++++++");
    }

    @PreDestroy
    public void preDestroy(){
        LOG.info("+++++++PreDestroy+++++++");
    }

    @Override
    public User save(User user) throws RepositoryException {
        LOG.info("save user in MockUserRepository");
        Objects.requireNonNull(user);
        if (user.getId() == 0) {
            user.setId(counter.incrementAndGet());
        }
        repository.put(user.getId(), user);
        return user;
    }

    @Override
    public boolean delete(int id) throws RepositoryException {
        LOG.info("delete user " + id + " in MockUserRepository");
        return repository.remove(id) != null;
    }

    @Override
    public User get(int id) throws RepositoryException {
        LOG.info("get user " + id + " in MockUserRepository");
        return repository.get(id);
    }

    @Override
    public List<User> getAll() throws RepositoryException {
        LOG.info("get all users in MockUserRepository");
        return repository.values().stream().collect(Collectors.toList());
    }


    @Override
    public User authorize(String email, String password) throws RepositoryException {
        return null;
    }

    @Override
    public List<User> getAll(int offset, int count) throws RepositoryException {
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
