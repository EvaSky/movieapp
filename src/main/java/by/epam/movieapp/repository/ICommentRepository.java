package by.epam.movieapp.repository;

import by.epam.movieapp.model.Comment;
import by.epam.movieapp.model.CommentStatus;
import by.epam.movieapp.repository.exception.RepositoryException;

import java.util.List;

/**
 * @author Olga Shahray
 */
public interface ICommentRepository {

    Comment save(Comment comment, int filmId, int userId) throws RepositoryException;

    // false if not found
    boolean delete(int id, int filmId, int userId) throws RepositoryException;

    Comment get(int id, int filmId, int userId)throws RepositoryException;

    List<Comment> getAllOfUser(int userId) throws RepositoryException;

    List<Comment> getAllOfFilm(int filmId) throws RepositoryException;

    List<Comment> getAll() throws RepositoryException;

    List<Comment> getByStatus(CommentStatus status, int offset, int count) throws RepositoryException;

    int getCount(CommentStatus status) throws RepositoryException;
}
