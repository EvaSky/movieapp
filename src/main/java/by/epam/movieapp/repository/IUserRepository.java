package by.epam.movieapp.repository;

import by.epam.movieapp.model.User;
import by.epam.movieapp.repository.exception.RepositoryException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface IUserRepository {

    User save(User user) throws RepositoryException;

    User authorize(String email, String password) throws RepositoryException;

    // false if not found
    boolean delete(int id) throws RepositoryException;

    // null if not found
    User get(int id) throws RepositoryException;

    List<User> getAll(int offset, int count) throws RepositoryException;

    List<User> getAll() throws RepositoryException;

    int checkIfEmailExist(String email)  throws RepositoryException;

    int getCountUsers()  throws RepositoryException;
}
