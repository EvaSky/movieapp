package by.epam.movieapp.repository;

import by.epam.movieapp.model.Comment;
import by.epam.movieapp.model.CommentStatus;
import by.epam.movieapp.repository.exception.RepositoryException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface ICommentRepository {

    void save(Comment comment) throws RepositoryException;

    void update(int id, CommentStatus status) throws RepositoryException;

    // false if not found
    boolean delete(int id) throws RepositoryException;

    List<Comment> getAllOfUser(int userId) throws RepositoryException;

    List<Comment> getAllOfFilm(int filmId) throws RepositoryException;

    List<Comment> getByStatus(CommentStatus status, int offset, int count) throws RepositoryException;

    int getCount(CommentStatus status) throws RepositoryException;
}
